//添加评论
function answer(question_id,seller_id,user_id){

    if (user_id==seller_id){
        layui.use('layer', function(){
            var layer = layui.layer;
            //这句话是关键:如果不加上这句话，弹出的框就是在浏览器外面了
            layer.config({offset:'150'})
            layer.open({
                type: 0
                ,shadeClose: false
                ,title: false //不显示标题栏
                ,closeBtn: false
                ,area: '300px;'
                ,shade: 0.1
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,resize: false
                ,btn: ['提交','取消']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: '<div style="padding: 50px; line-height: 22px; background-color: #46b8da; color: #fff; font-weight: 300;"><input type="text" id="answer_text" placeholder="输入你的回答"></div>'
                ,yes:function (index,layero) {
                    var answer_text = $('#answer_text').val();
                    //调用ajax方法
                    var formData = new FormData();//新建一个表单数据对象，用来传给后端
                    formData.append('question_id',question_id) //往里面加数据，数据是input标签换头像的文件对象
                    formData.append("answer_text",answer_text)
                    $.ajax({
                        type: "post", //表明是post
                        url: "/user/submit_answer",
                        enctype: "multipart/form-data",
                        //表示上传对象
                        data : formData, //传给后端的的数据
                        processData: false, //data的值是FormData对象，不需要对数据进行处理
                        contentType: false, //FormData对象由form表单构建
                        catch :false, //不缓存
                        success : function (msg) {
                            //这里是成功之后的回调函数
                            alert("成功");
                            window.location.reload();
                            // 然后attr("src","内容")设置src的新内容

                        }
                    });

                }
            });
            var mask = $(".layui-layer-shade");
            mask.appenTo(layero.parent());

            layer.msg('hello');
        });
    }
  else {
      alert("您不是该二手房的自由经纪人，无法回答")
    }
}