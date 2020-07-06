//指定购房的提交
//提交问题信息
function appoint_house() {
    if ($("#phone").val() == null || $("#phone").val() == ""){
        alert("手机不可以为空")
    }else {
        $.post('/house/submit_appoint_house',{
                where_address:$('#where_address').val(),
                phone:$('#phone').val()},
            function(result){
                if(result.msg == "yes"){
                    alert("好的，已收到");
                    window.location.reload();
                }else {
                    alert("发生了一些问题")
                }
            });
    }

}


function submit_advise() {
    if ($("#advise_detail").val() == null || $("#advise_detail").val() == ""){
        alert("建议不可以为空")
    }
    else {
        $.post('/user/submit_advise',{
                advise_detail:$('#advise_detail').val()},
            function(result){
                if(result.msg == "ok"){
                    alert("好的，已收到");
                    window.location.reload();
                }else {
                    alert("发生了一些问题")
                }
            });

    }


}