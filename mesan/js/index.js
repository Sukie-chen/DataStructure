$(function(){
    // 下拉dropdown
    $('#aboutUs,#brandIntro').hover(
        function(){
            $(this).css('background-color','#0185D0')
            $(this).children('ul').slideDown("fast")
        },
        function(){
            $(this).css('background-color','#014489')
            $(this).children('ul').hide()
        }
    )
    $('.dropdown li,.menu_click li').mouseenter(function(){
        $(this).css('background-color','#0185D0')
        $(this).css('color','#ffffff')
    })
    $('.dropdown li,.menu_click li').mouseleave(function(){
        $(this).css('background-color','rgba(255, 255, 255, 1)')
        $(this).css('color','#000000')
    })
    

    // 轮播初始化
    $("#owl-demo").owlCarousel({
        autoPlay: 1000, 
        stopOnHover:true,
        items : 1
    });
        
    $('.content_aboutus_right>div').css('display','none')
    $('#contentdiv_aboutus>div').eq(0).css('display','block')
    $('#contentdiv_productshow>div').eq(0).css('display','block')
    $('#contentdiv_brandintro>div').eq(0).css('display','block')
    $('#contentdiv_partner>div').eq(0).css('display','block')
    
    // 选项卡
    function changeTabs(clickLi,headerNav,contentDivlist){
        // $('#menu_click li').click(function(){
        //     console.log($(this))
        //     $('#header_nav').html($(this).children('span').text()||$(this).text())
        //     $('.content_aboutus_right>div').css('display','none')
        //     $('.content_aboutus_right>div').eq($(this).index()).css('display','block')
        // })
        $(clickLi).click(function(){
            $(headerNav).html($(this).children('span').text()||$(this).text())
            $(contentDivlist).css('display','none')
            $(contentDivlist).eq($(this).index()).css('display','block')
        })
    }  

    changeTabs('#menu_click_aboutus li','#header_nav_aboutus','#contentdiv_aboutus>div')
    changeTabs('#menu_click_brandintro li','#header_nav_brandintro','#contentdiv_brandintro>div')
})

