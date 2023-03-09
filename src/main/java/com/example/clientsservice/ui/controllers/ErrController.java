package com.example.clientsservice.ui.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@Controller
public class ErrController implements ErrorController {
    @RequestMapping( "error")
    public ModelAndView errorHandle(HttpServletRequest request) {
        String errCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
        return new ModelAndView("error", new ModelMap()
                .addAttribute("message", request.getAttribute(RequestDispatcher.ERROR_MESSAGE))
                .addAttribute("timestamp", LocalDateTime.now())
                .addAttribute("status", errCode)
        );
    }
}
