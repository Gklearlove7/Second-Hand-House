//修改用户状态
function forbid_user(user_id) {
    $.post('/adminstor/switchstatusByuserid',{
            user_id:user_id},
        function(result){
            if(result.msg == "ok"){
                alert("设置成功");
                window.location.reload();
            }else {
                alert("提交失败")
            }
        });
}

//评价审核
function comment_analysis(comment_id) {
    console.log(comment_id);
    $.post('/adminstor/remove_comment',{
            comment_id:comment_id},
        function(result){
            if(result.msg == "ok"){
                alert("删除成功");
                window.location.reload();
            }else {
                alert("删除失败")
            }
        });
}

//卖家信息审核
function pass_check(seller_id) {
    $.post('/adminstor/pass_seller',{
            seller_id:seller_id},
        function(result){
            if(result.msg == "ok"){
                alert("切换成功");
                window.location.reload();
            }else {
                alert("切换失败")
            }
        });
}

//采纳建议
function adopt(advise_id) {
    $.post('/adminstor/adopt_advise',{
            advise_id:advise_id},
        function(result){
            if(result.msg == "ok"){
                alert("采纳成功");
                window.location.reload();
            }else {
                alert("采纳失败")
            }
        });
}

//获悉指定购房
function appoint_know(appoint_id) {
    $.post('/adminstor/know_appoint',{
            appoint_id:appoint_id},
        function(result){
            if(result.msg == "ok"){
                alert("成功");
                window.location.reload();
            }else {
                alert("失败")
            }
        });
}
