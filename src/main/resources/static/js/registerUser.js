window.addEventListener("load", () => {
    let regForm = $(".register-form");

    regForm.submit((e) => {
        let user = Object.fromEntries(new FormData(e.target));
        let error = "";
        console.log(user);
        if (user.firstName.length <= 2 && user.firstName.length > 30) {
            error += "First name must to be from 2 to 30 letters \n"
        }
        if (user.secondName.length < 2 || user.secondName.length > 30) {
            error += "Last name must to be from 2 to 30 letters \n"
        }
        if (user.username.length < 4 || user.username.length > 30) {
            error += "Username name must to be from 4 to 30 letters \n"
        }
        if (user.email.length < 5 || user.email.length > 50) {
            //делать через регулярку = муторно в тестах, так что поставил такую заглушку
            error += "Email is incorrect \n"
        }
        if (user.password.length < 5 || user.password.length > 18) {
            error += "Password must to be from 5 to 18 letters \n"
        }
        if (user.password !== user.passwordConfirm) {
            error += "Passwords are not the same \n"
        }
        console.log(JSON.stringify(user));
        if (error !== "") {
            alert(error);
        } else {
            $.ajax({
                url: "/rest/user/submitRegister",
                method: "post",
                contentType: "application/json",
                data: JSON.stringify(user),
                success: (data) => {
                    if (data === "success") {
                        window.location.href = "/clients"
                    } else {
                        alert("data");
                    }
                },
                error: (xl, er, errMsg) => {
                    alert(er)
                }
            })
        }
        return false;
    })
});