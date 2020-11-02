// 仿路由切换
$(function(){
    // 点击切换
    $('.menu ul li').click(function(){
        //console.log($(this)[0].id)
        let idName = '#container_'+$(this)[0].id
        $('#allContainer>div').css('display','none')
        $(idName).css('display','block')
    })
})

// 监听页面刷新
window.onload = function(event){
    //console.log(event)
    changeRoute();
}
// 监听url变化
$(window).bind('hashchange',function(e){
    changeRoute();
})

function changeRoute(){
    let router = window.location.hash.substring(2)||'home'
    let idName = '#container_'+router
    if($(idName)){
        $('#allContainer>div').css('display','none')
        $(idName).css('display','block')
    }else{
        window.location.hash=''
    }
}