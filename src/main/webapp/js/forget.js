//获取验证码
function get_captcha() {
        if($("#user_account").val() ==null || $("#user_account").val() =="" ||$("#new_password").val() ==null || $("#new_password").val() ==""){

            alert("邮箱发送失败，必填项不能为空");

            setTimeout(function () {
                $("#notice").hide();
            }, 1000);
        }
        else {
            $.ajax({
                type:"POST",
                url :"/user/forget_send?random"+Math.random(),
                data:{
                    user_account:$("#user_account").val(),
                },
                success:function(data){
                    if (data){
                        alert("验证码发送成功，请注意查收。");
                    }
                    else {
                        alert("邮箱或账号不存在！")
                    }
                }
            })

        }

}


//重改密码

function forget_password_modify() {
    $.post('/user/forget_password_modify',{
            user_account:$('#user_account').val(),
            new_password:$('#new_password').val(),
            captcha:$('#captcha').val()},
        function(result){
            if(result.msg == "ok"){
                alert("修改成功");
                window.location.reload();
            }else {
                alert("验证码错误，请重试")
            }
        });

}

