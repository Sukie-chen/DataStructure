$(function(){

    var baseUrl = 'http://47.101.144.142:8010'
    // home网页信息
    $.ajax({
        url:baseUrl+'/company/getCompanyInfo',
        type:'GET',
        success:function(res){
            $('.intro_info').children('h1').text(res.c_title)
            $('.intro_info').children('p').text(res.c_introduce)
        }
    })
    // home图片信息
    $.ajax({
        url:baseUrl+'/company/getImgUrl',
        type:'GET',
        success:function(res){
            $('.company_intro').children(':first').children('img').attr('src',res.c_img_introduce)
            $('.slider1').children('img').attr('src',res.c_img_lunbo_one)
            $('.slider2').children('img').attr('src',res.c_img_lunbo_two)
            $('.slider3').children('img').attr('src',res.c_img_lunbo_three)
        }
    })
    // 关于我们
    $.ajax({//介绍
        url:baseUrl+'/company/selCompanyInfo',
        type:'GET',
        success:function(res){
            $('#contentdiv_aboutus>div').eq(0).html(res.companyInfo)
        }
    })
    $.ajax({//历史
        url:baseUrl+'/company/selCompanyHistory',
        type:'GET',
        success:function(res){
            $('#contentdiv_aboutus>div').eq(1).html(res.companyHistory)
        }
    })
    $.ajax({//文化
        url:baseUrl+'/company/selCompanyCulture',
        type:'GET',
        success:function(res){
            $('#contentdiv_aboutus>div').eq(2).html(res.companyCulture)
        }
    })
    $.ajax({//架构
        url:baseUrl+'/company/selCompanyStructure',
        type:'GET',
        success:function(res){
            $('#contentdiv_aboutus>div').eq(3).children('img').attr('src',res.companyStructure)
        }
    })
    $.ajax({//认证
        url:baseUrl+'/company/selCompanyAuthentication',
        type:'GET',
        success:function(res){
            $('#contentdiv_aboutus>div').eq(4).children('img').attr('src',res.companyAuthentication)
        }
    })
    //品牌介绍
    $.ajax({//代理
        url:baseUrl+'/brand/selBrandAgency',
        type:'GET',
        success:function(res){
            let agency = $('.agency');
            let agencyDetail = $('.agency_detail');
            for(let i=0;i<res.length;i++){
                if(i != res.length-1){ //节点复制
                   let cloneDiv = agencyDetail.eq(i).clone(true)
                   agency.append(cloneDiv);
                }
                agencyDetail = $('.agency_detail');
                agencyDetail.eq(i).children('img').attr('src',res[i].b_agency_img)
                agencyDetail.eq(i).children('.brand_detail').children('h4').text(res[i].b_agency_title)
                agencyDetail.eq(i).children('.brand_detail').children('p').text(res[i].b_agency_content)
            }
        }
    })
    $.ajax({//分销
        url:baseUrl+'/brand/selBrandAuthorized',
        type:'GET',
        success:function(res){
            let authorized =  $('.authorized');
            let authorizationDetail = $(".authorization_detail");
            for(let autorizedIndex=0; autorizedIndex < res.length; autorizedIndex++){
                if(autorizedIndex != res.length-1){ //节点复制
                    let cloneDiv = authorizationDetail.eq(autorizedIndex).clone(true);
                    authorized.append(cloneDiv);
                }
                authorizationDetail = $(".authorization_detail")
                authorizationDetail.eq(autorizedIndex).children('img').attr('src',res[autorizedIndex].b_authorized_img)
                authorizationDetail.eq(autorizedIndex).children(".brand_detail").children('h4').text(res[autorizedIndex].b_authorized_title)
                authorizationDetail.eq(autorizedIndex).children(".brand_detail").children('p').text(res[autorizedIndex].b_authorized_content)
            }
        }
    })
    $.ajax({//库存
        url:baseUrl+'/brand/selBrandWareHouse',
        type:'GET',
        success:function(res){
            $('.wareHouse').html(res.b_warehouse_content)
        }
    })
    $.ajax({//优势
        url:baseUrl+'/brand/selBrandAdvantage',
        type:'GET',
        success:function(res){
            for(var i=1;i<res.length;i++){
                let cloneImg = $('.advantageBrand>img').eq(0).clone(true)
                cloneImg.attr('src',res[i].b_advantage_img)
                $('.advantageBrand').append(cloneImg)
            }
            $('.advantageBrand>img').eq(0).attr('src',res[0].b_advantage_img)
        }
    })
    // 产品展示
    $.ajax({
        url:baseUrl+'/product/selProduct',
        type:'GET',
        success:function(res){
            let productshow = $("#contentdiv_productshow");
            let productDetail = $(".product_detail")
            for(var productIndex=0; productIndex < res.length; productIndex++){
                if(productIndex != res.length-1){
                    let cloneDiv = productDetail.eq(0).clone(true);
                    productshow.append(cloneDiv)
                }
                productDetail = $(".product_detail")
                productDetail.eq(productIndex).children('img').attr('src',res[productIndex].p_img)
                productDetail.eq(productIndex).children('p').text(res[productIndex].p_name)
                
            }
        }
    })
    // 合作伙伴
    $.ajax({
        url:baseUrl+'/brand/selBrandPartner',
        type:'GET',
        success:function(res){
            let keyArr = Object.keys(res)//res的key值数组
            for(var i=0;i<keyArr.length;i++){
                let OuterDiv = $(`<div><h2 style="font-weight: 500;"></h2></div>`)
                OuterDiv.children('h2').text(keyArr[i])
                for(var j=0;j<res[keyArr[i]].length;j++){
                    let InnerDiv = $(`<div><img class="imgShow"><p></p></div>`)
                    InnerDiv.children('img').attr('src',res[keyArr[i]][j].brand_img)
                    InnerDiv.children('p').text(res[keyArr[i]][j].brand_name)
                    OuterDiv.append(InnerDiv)
                }
                $('#contentdiv_partner').append(OuterDiv)
            }
        }
    })
    // 在线留言
    $('#messageForm img').attr('src',baseUrl+'/message/getIVerificationCode?date='+new Date())
    $('#messageForm img').click(function(){
            $(this).attr('src',baseUrl+'/message/getIVerificationCode?date='+new Date())
    })
    $('#submit').click(function(){
        $.ajax({
            url:baseUrl+'/message/leaveMessage',
            type:'POST',
            contentType:'application/json',
            dataType:'json',
            data:JSON.stringify({
                m_title:$('#messageForm>input').eq(0).val(),
                m_name:$('#messageForm>input').eq(1).val(),
                m_tel:$('#messageForm>input').eq(2).val(),
                m_mail:$('#messageForm>input').eq(3).val(),
                m_content:$('#messageForm>textarea').val(),
                code:$('#messageForm>input').eq(4).val()
            }),
            success:function(res){
                if(res.status==200){
                    alert(res.msg)
                    $('#messageForm>input:text').each(function(){
                        $(this).val('')
                    })
                    $('#messageForm>textarea').val('')
                }else if (res.status==-100){
                    alert(res.msg)
                }else{
                    alert('系统错误，请稍后重试！')
                }
            },
            error:function(res){
                alert('请确保您的手机号或邮箱格式正确！')
            }
        })
    })
    // 联系我们
    $.ajax({
        url:baseUrl+'/company/selContract',
        type:'GET',
        success:function(res){
            $('#contentdiv_contactUs').children('span').eq(0).text(res.c_tel)
            $('#contentdiv_contactUs').children('span').eq(1).text(res.c_mail)
            $('#contentdiv_contactUs').children('span').eq(2).text(res.c_website)
            $('#contentdiv_contactUs').children('span').eq(3).text(res.c_address)
            // $('#contentdiv_contactUs').children('img').attr('src',res.c_address_img)
        }
    })
})