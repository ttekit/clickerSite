package com.example.clientsservice.security;

import com.example.clientsservice.models.enums.Role;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    InMemoryUserDetailsManager inMemory(BCryptPasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
                User.builder().passwordEncoder(encoder::encode).username("root").password("root").roles(Role.ARCHITECTOR.name()).build(),
                User.builder().passwordEncoder(encoder::encode).username("u").password("u").roles(Role.USER.name()).build()
        );
    }

    @Bean
    public AuthenticationManager authManager(
            HttpSecurity security,
            BCryptPasswordEncoder encoder,
            UserDetailsService userDetailsService
    ) throws Exception {
        System.err.println("authManager");
        return security
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder)
                .and().build();
    }

    @Bean
    public WebSecurityCustomizer securityCustomizer() {
        return customizer ->
                customizer.debug(false)
                        .ignoring()
                        .antMatchers("/css/**")
                        .antMatchers("/register")
                        .antMatchers("/js/registerUser.js")
                        .mvcMatchers(HttpMethod.POST, "/register")
                        .mvcMatchers(HttpMethod.POST, "/user/submitRegister");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity secur) throws Exception {

        secur.authorizeRequests()
                .antMatchers("/error", "/register")
                .permitAll()
                .antMatchers(
                        "/clients"
                )
                .authenticated()
                .antMatchers("/users",
                        "/user/updateUser"
                )
                .hasAuthority(
                        Role.ARCHITECTOR.name()
                )
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginAction")
                .defaultSuccessUrl("/")
                .and()
                .logout()
 //               .logoutUrl("j_spring_security_logout")
                .logoutSuccessUrl("/login")
                .and()
                .csrf()
                .disable()
        ;
        return secur.build();
    }

}
