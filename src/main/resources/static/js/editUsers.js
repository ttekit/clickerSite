window.addEventListener("load", ()=>{
    let $submitBtn = $(".saveBtn");
    $submitBtn.on("click", (e)=>{
        let data = $(e.target).closest("tr");
        let user = {};
        user.Id = data.find("input[name='Id']").val()
        user.email = data.find("input[name='email']").val()
        user.username = data.find("input[name='username']").val()
        user.password = data.find("input[name='password']").val()
        user.firstName = data.find("input[name='firstname']").val()
        user.secondName = data.find("input[name='secondname']").val()
        user.role = data.find("select[name='role'] option:selected").text()
        user.status = data.find("select[name='status'] option:selected").text()

        $.ajax({
            url: "/rest/user/updateUser",
            method: "post",
            contentType: "application/json",
            data: JSON.stringify(user),
            success: (data) => {
                if (data === "success") {
                    window.location.href = "/user"
                } else {
                    alert("data");
                }
            },
            error: (xl, er, errMsg) => {
                alert(er)
            }
        })
        console.log(user)
    })
})