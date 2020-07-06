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

//这里专门给我的出售做ajax分页
function get_allmyhouse(page,limit) {
    $('#my_seller').empty()
    $('#get_last').remove()
    $('#get_next').remove()
    $.get("/house/get_allmyhouse",{page:page,limit:limit},function (res) {
        console.log(res.data);
        res.data.forEach(x=>{
            $('#my_seller').append('<dl>\n' +
                '                    <dt><img src="/house/get_pic_image?file_name='+x.house_pic+'&house_id='+x.house_id+'" /></dt>\n' +
                '                    <dd>\n' +
                '                        <h3><a href="/house/house_detail?house_id='+x.house_id+'">'+x.house_community+'</a> <img src="/images/timg.jpg" />'+x.house_date+'</h3>\n' +
                '                        <div class="wuxing">'+x.house_type+'</div>\n' +
                '                        <div class="dizhi">西安市 - '+x.house_address+' - 二手房</div>\n' +
                '                    </dd>\n' +
                '                    <div class="xunzhang" id=n'+x.house_id+'><strong>是否下定金：'+x.house_buy+'</strong> <br> <strong>是否有意愿:'+x.house_need+'</strong><br></div>\n' +
                '                    <div class="seller"><button onclick="reserved(\''+x.house_id+'\',\''+x.house_buy+'\')">已预订/闲置</button><button onclick="house_back(\''+x.house_id+'\')">占用太长？一键恢复</button>' +
                '                    <button onclick="sold(\''+x.house_id+'\')">已出售</button></div>\n' +
                '                </dl>')
            if (x.house_need!=null && x.house_need!=undefined&&x.house_need!=""){
                $('#'+'n'+x.house_id).append(`<strong>时间${x.house_need_time}</strong>`)
            }
        })


        $('#my_seller').after('<button onclick="get_last('+page+')" id="get_last">上一页</button>\n' +
            '\t\t\t\t\t\t\t\t\t\t<button onclick="get_next('+page+','+res.count+')" id="get_next">下一页</button>')
    })
}
//关注分页
function get_last(page){
    if(page<=1){
        page=1
    }else {
        page--
    }
    get_allmyhouse(page,5)
}
function get_next(page,count){
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
//设为已预订
function reserved(house_id,house_buy) {
    console.log(house_id);
    $.post('/house/reserved',{
            house_id:house_id,
            house_buy:house_buy},
        function(result){
            alert("好的，已标记");
            window.location.reload();
        });
}
//已出售
function sold(house_id) {
    console.log(house_id);
    $.post('/house/sold',{
            house_id:house_id},
        function(result){
        if (result.msg='yes'){
            alert("恭喜您，已出售");
            window.location.reload();
        }else {
            alert("抱歉，出错了");
            window.location.reload();
        }

        });
}

function house_back(house_id) {
    console.log(house_id);
    $.post('/house/house_back',{
            house_id:house_id},
        function(result){
            alert("好的，已恢复");
            window.location.reload();
        });
}

$(document).ready(function(){
    get_allmyhouse(1,5);

})