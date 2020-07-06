//每一个Ajax 请求完成之后都会执行。
$(document).ajaxComplete(function (event, xhr, settings) {
    console.log("ajaxComplete  ")
    redirectHandle(xhr);
})

function  redirectHandle(XHR) {
    //获取后台返回的参数
    var url = XHR.getResponseHeader("CONTEXTPATH");
    var enable = XHR.getResponseHeader("SESSIONSTATUS");
    console.log("redirectUrl = " + url);

    if((enable == "TIMEOUT") && (url != "")){
        var win = window;
        while(win != win.top){
            win = win.top;
        }
        win.location.href = url;
    }
}



//修改个人资料
function submit_change() {
    //判断必填项是不是填了
    if ($("#user_name").val() == null || $("#user_name").val() == "" || $("#rbSex1").val() == null || $("#rbSex1").val() == ""
    || $("#rbSex2").val() == null || $("#rbSex2").val() ==""){
        alert("必填项不可以为空")
    }
    else {
        $.post('/user/modify_userinfo',{
                user_name:$('#user_name').val(),
                user_sex:$('input[name="user_sex"]:checked').val(),
                user_seat:$('#user_seat').val(),
                user_address:$('#user_address').val()},
            function(result){
                window.location.href="/user/userinfo"
            });
    }

}

//修改个人密码
function change_password() {
    if ($("#new_password").val() == null || $("#new_password").val() == "" || $("#new_password1").val() == null || $("#new_password1").val() == "" ){
        alert("必填项不可以为空")
    }else {
        $.post('/user/modify_password',{
                new_password:$('#new_password').val()},
            function(result){
                alert("修改成功");
                window.location.href="/user/userinfo"
            });
    }
    }

//成为经纪人
function become_seller() {
    if ($("#seller_phone").val() == null || $("#seller_phone").val() == "" || $("#seller_name").val() == null || $("#seller_name").val() == ""
    ||$("#seller_years").val() == null || $("#seller_years").val() == ""||$("#seller_certificate").val() == null || $("#seller_certificate").val() == ""
    ||$("#seller_describe").val() == null || $("#seller_describe").val() == ""||$("#seller_street").val() == null || $("#seller_street").val() == ""
        ||$("#seller_age").val() == null || $("#seller_age").val() == ""
        ||$("#seller_card").val() == null || $("#seller_card").val() == ""||$("#seller_address").val() == null || $("#seller_address").val() == ""
        ||$("#seller_realname").val() == null || $("#seller_realname").val() == ""||$("#seller_realname").val() == null || $("#seller_realname").val() == ""
        ||$("#seller_education").val() == null || $("#seller_education").val() == ""||$("#seller_email").val() == null || $("#seller_email").val() == ""
        ||$("#seller_bank_card").val() == null || $("#seller_bank_card").val() == ""
    ){
        alert("必填项不可以为空")
    }
    else {
        $.post('/user/become_seller', {
                seller_phone: $('#seller_phone').val(),
                seller_name: $('#seller_name').val(),
                seller_years: $('#seller_years').val(),
                seller_certificate: $('#seller_certificate').val(),
                seller_describe: $('#seller_describe').val(),
                seller_street: $('#seller_street').val(),
                seller_sex: $('input[name="seller_sex"]:checked').val(),
                seller_age: $('#seller_age').val(),
                seller_card: $('#seller_card').val(),
                seller_address: $('#seller_address').val(),
                seller_realname: $('#seller_realname').val(),
                seller_education: $('#seller_education').val(),
                seller_email: $('#seller_email').val(),
                seller_bank_card:$('#seller_bank_card').val()
            },
            function (result) {
                alert("提交成功，等待管理员审核")
                window.location.href = "/user/userinfo"
            });
    }

}
//重改邮箱
    function check_mail() {
        $.post('/user/check_mail',{
                user_email:$('#new_email').val(),
                captcha:$('#captcha').val()},
            function(result){
                if(result.msg == "ok"){
                    alert("修改成功");
                    window.location.href="/user/userinfo"
                }else {
                    alert("验证码不正确，修改失败")
                }
            });
    }

    //提交建议信息
function submit_comment(house_id) {

    if ($("#submit_comment").val() == null || $("#submit_comment").val() == ""){
        alert("评论不可以为空")
    }else {
        $.post('/house/submit_comment',{
                user_comment:$('#submit_comment').val(),
                house_id:house_id},
            function(result){
                if(result.msg == "ok"){
                    alert("提交成功");
                    window.location.reload();
                }else {
                    alert("提交失败")
                }
            });
    }

}
//提交问题信息
function submit_question(house_id,seller_id) {
    if ($("#submit_question").val() == null || $("#submit_question").val() == ""){
        alert("问题不可以为空")
    }else {
        $.post('/house/submit_question',{
                user_question:$('#submit_question').val(),
                house_id:house_id,
                seller_id:seller_id},
            function(result){
                if(result.msg == "ok"){
                    alert("提交成功");
                    window.location.reload();
                }else {
                    alert("提交失败")
                }
            });
    }
}

//放到想要购买的地方，表示已经被占据
function need_house(house_id,user_id) {
    var layer = layui.layer;
    //这句话是关键:如果不加上这句话，弹出的框就是在浏览器外面了
    layer.config({offset:'200'})
    layer.open({
        type: 0
        ,shadeClose: false
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '500px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,resize: false
        ,btn: ['立刻加入订单', '再看看']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,yes: function(layero){
            $.post('/house/need_house',{
                    house_id:house_id,
                    user_id:user_id},
                function(result){
                    if(result.msg == "yes"){
                        alert("加入成功");
                        window.location.reload();
                    }else {
                        alert("加入失败")
                    }
                });
            alert("银行卡号是："+seller_bank_card);
            window.location.reload();
        }
    });
    var mask = $(".layui-layer-shade");
    mask.appenTo(layer.parent());

}
//购买房子



function add_house(new_house_id) {
    //这里是触发一下文件输入框的操作，change是当元素的值发生改变时，也就是选择一个文件时
    $("#file_pic").click().change(function () {
        //获取图片路径
        var file =document.getElementById('file_pic').files[0];
        //调用ajax方法
        var formData = new FormData();//新建一个表单数据对象，用来传给后端
        formData.append('file',file) //往里面加数据，数据是input标签换头像的文件对象
        formData.append("house_id",new_house_id)
        $.ajax({
            type: "post", //表明是post
            url: "/house/put_pic",
            enctype: "multipart/form-data",
            //表示上传对象
            data : formData, //传给后端的的数据
            processData: false, //data的值是FormData对象，不需要对数据进行处理
            contentType: false, //FormData对象由form表单构建
            catch :false, //不缓存
            success : function (msg) {
                //这里是成功之后的回调函数
                alert("成功");
                // 然后attr("src","内容")设置src的新内容

            }
        });
    });
}

//新添加房子
function add_new_house(house_id,user_id,user_name) {

    if ($("#house_community").val() == null || $("#house_community").val() == ""
        ||$("#house_type").val() == null || $("#house_type").val() == ""||$("#house_address").val() == null || $("#house_address").val() == ""
        ||$("#house_money").val() == null || $("#house_money").val() == ""||$("#house_deposit").val() == null || $("#house_deposit").val() == ""
        ||$("#house_area").val() == null || $("#house_area").val() == ""||$("#house_floor").val() == null || $("#house_floor").val() == ""
        ||$("#house_info").val() == null || $("#house_info").val() == ""||$("#house_community_info").val() == null || $("#house_community_info").val() == ""
        ||$("#house_detail_info").val() == null || $("#house_detail_info").val() == ""
    )
    {
        alert("必填项不可以为空")
    }
    else {
        $.post('/house/add_house_info',{
                house_id:house_id,
                house_community:$('#house_community').val(),
                house_type:$('#house_type').val(),
                house_address:$('#house_address').val(),
                house_money:$('#house_money').val(),
                house_deposit:$('#house_deposit').val(),
                house_area:$('#house_area').val(),
                house_floor:$('#house_floor').val(),
                house_info:$('#house_info').val(),
                house_community_info:$('#house_community_info').val(),
                house_detail_info:$('#house_detail_info').val(),
                seller_id:user_id,
                seller_name:user_name},
            function(result){
                if(result.msg == "ok"){
                    alert("添加成功");
                    window.location.reload();
                }else {
                    alert("提交失败")
                }
            });
    }

}

//注册须知
function register_need_know() {
    layui.use('layer', function(){
        var layer = layui.layer;
        //这句话是关键:如果不加上这句话，弹出的框就是在浏览器外面了
        layer.config({offset:'150'})
        layer.open({
            type: 0
            ,shadeClose: false
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '700px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,resize: false
            ,btn: ['我已了解','拒绝']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 50px; line-height: 22px; background-color: #46b8da; color: #fff; font-weight: 300;">很高兴，您能使用二手房交易网站，希望您能找到心仪的二手房。但是，在此之前，您需要遵守下面所列的要求：<br>（1）请自觉遵守《中华人民共和国城市房地产管理法》,《城市商品房预售管理办法》,《物权法》,《担保法》,《中华人民共和国合同法》等法律法规，诚实守信。<br>（2）作为自由经纪人，需要出示房屋的证明信息、个人的真实信息并保证交易公开、透明。同时，作为买家，也要出示个人的真实信息，保证交易公开、透明。<br>（3）请自觉遵守相关规定，如果违反相关规定，我方将追究相关法律责任，同时我方拥有最终解释权。</div>'
        });
        var mask = $(".layui-layer-shade");
        mask.appenTo(layero.parent());

        layer.msg('hello');
    });

}
