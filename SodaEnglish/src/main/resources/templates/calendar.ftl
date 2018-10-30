<!DOCTYPE html>
<html style="height: 100%;">

<head>
    <title>资讯</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="description" content="">
    <link rel="stylesheet" href="lib/weui.min.css">
    <link rel="stylesheet" href="css/jquery-weui.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/box-flex.css">
    <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/MyCenter.css"/>
	<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/sign2.css"/>
    <link href="css/WeUI/weui.min.css" rel="stylesheet" />
    <script src="lib/jquery-2.1.4.js"></script>
    <script src="js/adaptive.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    adaPtive(); //铺页面调用             
    //页面加载时调用
    $(function() { direction(); });
    //用户变化屏幕方向时调用
    $(window).on('orientationchange', function(e) { direction(); });
    //调用adaptive
    function adaPtive(max) {
        window['adaptive'].desinWidth = 720;
        window['adaptive'].baseFont = 24;
        window['adaptive'].scaleType = 1;
        window['adaptive'].maxWidth = max;
        window['adaptive'].init();
    }
    //判断手机屏幕方向
    function direction() { if (window.orientation == 90 || window.orientation == -90) { adaPtive(320); return false; } else if (window.orientation == 0 || window.orientation == 180) { adaPtive(); return false; } }
    </script>
	
	
<script type="text/javascript" src="js/calendar2.js"></script>
<script type="text/javascript">
$(function(){
  //ajax获取日历json数据
  
  var signList=[{"signDay":"08"},{"signDay":"09"},{"signDay":"11"},{"signDay":"12"},{"signDay":"13"}];
   calUtil.init(signList);
});
</script>
</head>

<body ontouchstart style="height: 100%;">

    <!--me-main -->
    <div class="info-main clearfix" >
       

	   
	   <div style="" id="calendar"></div>

       <div id="sign_note" style="text-align:center;position: relative;padding: 15px;    font-size: 14px;">
	
       </div>
    <!--me-main -->
    <!--  weui-tabbar -->
    <div id="footer" class="weui-tabbar">
        
        <a href="/info" class="weui-tabbar__item">
            <div class="weui-tabbar__icon rw">
                <img src="images/tarbar_rw.png" alt="">
            </div>
            <p class="weui-tabbar__label">学习</p>
        </a>
        <a href="/calendar" class="weui-tabbar__item">
            <div class="weui-tabbar__icon zx">
                <img src="images/tarbar_zx.png" alt="">
            </div>
            <p class="weui-tabbar__label">复习</p>
        </a>
        <a href="/me" class="weui-tabbar__item">
            <div class="weui-tabbar__icon me">
                <img src="./images/tarbar_me.png" alt="">
            </div>
            <p class="weui-tabbar__label">我的</p>
        </a>
    </div>
    <!--  weui-tabbar -->
    
    <script src="lib/fastclick.js"></script>
    <script type='text/javascript' src='js/swiper.js' charset='utf-8'></script>

    <script src="js/jquery-weui.js"></script>
</body>

</html>