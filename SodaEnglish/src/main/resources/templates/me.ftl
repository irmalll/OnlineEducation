<!DOCTYPE html>
<html>

<head>
    <title>我</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="description" content="">
    <link rel="stylesheet" href="lib/weui.min.css">
    <link rel="stylesheet" href="css/jquery-weui.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/box-flex.css">
    <link rel="stylesheet" href="css/style.css">
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
</head>

<body ontouchstart>
    
    <!--me-main -->
    <div class="me-main clearfix">
        <div class="weui-cells" style="margin-top: 0">
            <a class="weui-cell head-cells weui-cell_access" href="javascript:;">
                <div class="weui-cell__hd"><img src="images/me_head_img.jpg" alt=""></div>
                <div class="weui-cell__bd flex flex-v">
                    <p>恍然如梦</p>
                    <p>账号：ceshi01</p>
                </div>
                <div class="weui-cell__ft">
                    <img src="images/me_erwema.jpg" alt="">
                </div>
            </a>
        </div>
        <div class="weui-cells__title"></div>
        <div class="weui-cells">
            <a class="weui-cell weui-cell_access" href="wallet.html">
                <div class="weui-cell__hd"><img src="images/me_plate.png" alt=""></div>
                <div class="weui-cell__bd">
                    <p>学习成长报告</p>
                </div>
                <div class="weui-cell__ft"></div>
            </a>
        </div>
        <div class="weui-cells__title"></div>
        <div class="weui-cells">
            <a class="weui-cell weui-cell_access" href="javascript:;">
                <div class="weui-cell__hd"><img src="images/me_collect.png" alt=""></div>
                <div class="weui-cell__bd">
                    <p>推荐有奖</p>
                </div>
                <div class="weui-cell__ft"></div>
            </a>
            <a class="weui-cell weui-cell_access" href="javascript:;">
                <div class="weui-cell__hd"><img src="images/me_photo.png" alt=""></div>
                <div class="weui-cell__bd">
                    <p>单词本</p>
                </div>
                <div class="weui-cell__ft"></div>
            </a>
            <a class="weui-cell weui-cell_access" href="javascript:;">
                <div class="weui-cell__hd"><img src="images/me_card.png" alt=""></div>
                <div class="weui-cell__bd">
                    <p>我的笔记</p>
                </div>
                <div class="weui-cell__ft"></div>
            </a>
            <a class="weui-cell weui-cell_access" href="javascript:;">
                <div class="weui-cell__hd"><img src="images/me_smile.png" alt=""></div>
                <div class="weui-cell__bd">
                    <p>英雄榜</p>
                </div>
                <div class="weui-cell__ft"></div>
            </a>
        </div>
        <div class="weui-cells__title"></div>
        
       
    </div>
    <!--me-main -->
    <!--  weui-tabbar -->
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
    <script>
    $(function() {
        FastClick.attach(document.body);
        $("#showMoreLink").on('click',function(){
            $(".moreLink").toggle("fast");
        })
    });
    </script>
    <script src="js/jquery-weui.js"></script>
</body>

</html>