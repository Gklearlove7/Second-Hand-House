//每一个Ajax 请求完成之后都会执行。
$(document).ajaxComplete(function (event, xhr, settings) {
    console.log("ajaxComplete  ")
    redirectHandle(xhr);
})

function  redirectHandle(xhr) {

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

//这里专门给我的需要做ajax分页
function get_allmyneed(page,limit) {
    $('#my_need').empty()
    $('#get_need_last').remove()
    $('#get_need_next').remove()
    $.get("/house/get_allmyneed",{page:page,limit:limit},function (res) {
        console.log(res.data);
        res.data.forEach(x=>{
            $('#my_need').append('<dl>\n' +
                '                    <dt><img src="/house/get_pic_image?file_name='+x.house_pic+'&house_id='+x.house_id+'" /></dt>\n' +
                '                    <dd>\n' +
                '                        <h3>'+x.house_info+' <img src="/images/timg.jpg" />'+x.need_time+'</h3>\n' +
                '                        <div class="wuxing">'+x.house_type+'</div>\n' +
                '                        <div class="dizhi">西安市 - '+x.house_address+' - 二手房</div>\n' +
                '                    </dd>\n' +
                '                    <div class="seller" id=n'+x.need_id+'>' +
                '                    </div>\n' +
                '                </dl>')
            if (x.is_buy!=null && x.is_buy!=undefined&&x.is_buy!=""){
                $('#'+'n'+x.need_id).append(`<button type="button">已下定金</button>`)
            }
            else {
                $('#'+'n'+x.need_id).append(`<button onclick="buy_house('${x.seller_bank_card}')">下定金</button> 
                                       <button onclick="buy_house_zhifu('${x.house_id}','${x.house_deposit}','${x.need_id}')">支付宝</button>
                                        <button onclick="not_need('${x.house_id}','${x.need_id}')">不想要了</button>`)
            }

        })
        $('#my_need').after('<button onclick="get_need_last('+page+')" id="get_need_last">上一页</button>\n' +
            '\t\t\t\t\t\t\t\t\t\t<button onclick="get_need_next('+page+','+res.count+')" id="get_need_next">下一页</button>')
    })
}
//关注分页
function get_need_last(page){
    if(page<=1){
        page=1
    }else {
        page--
    }
    get_allmyhouse(page,5)
}
function get_need_next(page,count){
    var maxpage = Math.ceil(count/5)
    // var maxpage=count/5
    console.log(maxpage);
    if (page>=maxpage){
        page=maxpage;
    }else {
        page++
    }
    get_allmyhouse(page,5)

}
//下定金
function buy_house(seller_bank_card) {
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
        ,btn: ['立刻购买', '再看看']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">很高兴，您能在我们网站找到您心仪的二手房。<br>付完定金后，我们有责任并有义务保证您的交易。<br>请安全使用</div>'
        ,yes: function(layero){
            alert("银行卡号是："+seller_bank_card);
            window.location.reload();
        }
    });
    var mask = $(".layui-layer-shade");
    mask.appenTo(layer.parent());

}


//支付宝支付
function buy_house_zhifu(house_id,house_money,need_id){
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.config({offset:'50'})
        layer.open({
            type: 2,
            area: ['470px', '500px'],
            title: ['下单确认', 'font-size:18px;'],
            content: `/cc?WIDout_trade_no=${need_id}&WIDsubject=buy_house&WIDtotal_amount=${house_money}&WIDbody=this_to_buy&house_id=${house_id}` //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
    })
    return false
}

// //支付宝支付
// function buy_house_zhifu1(house_id,house_money,need_id) {
//     $.post('/cc',{
//             WIDout_trade_no:need_id,
//             WIDsubject:'buy_house',
//             WIDtotal_amount:house_money,
//             WIDbody:'this to buy',
//             house_id:house_id,
//         },
//         function(result){
//         if (result.msg='yes'){
//             alert("好的已付定金");
//             window.location.reload();
//         }else {
//             alert("抱歉，出错了");
//             window.location.reload();
//         }
//
//         });
// }

//不需要了
function not_need(house_id,need_id) {
    console.log(house_id);
    $.post('/house/not_need',{
            house_id:house_id,
            need_id:need_id
        },
        function(result){
            if (result.msg='yes'){
                alert("好的已去除");
                window.location.reload();
            }else {
                alert("抱歉，出错了");
                window.location.reload();
            }

        });
}

$(document).ready(function(){
    get_allmyneed(1,5);

})