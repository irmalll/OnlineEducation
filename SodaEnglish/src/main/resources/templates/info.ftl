<!DOCTYPE html>
<html style="height: 100%;">

<head>
    <title>苏打英语</title>
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
</head>

<body ontouchstart style="height: 100%;">

    <!--me-main -->
    <div class="info-main clearfix" >
       
  
       
         <!-- weui-tab -->
         <div class="weui-tab">
              <div class="weui-navbar">
                    <a class="weui-navbar__item weui-bar__item--on" href="#tab1">
                      简介
                    </a>
                    <a class="weui-navbar__item" href="/word">
                      单词
                    </a>
                    <a class="weui-navbar__item" href="#tab3">
                      听力
                    </a>
                    <a class="weui-navbar__item" href="/video">
                      视频讲解
                    </a>
              </div>
              <div class="weui-tab__bd">
                <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
                    <div class="weui-panel__bd">
                      <a href="actile.html" class="weui-media-box weui-media-box_appmsg">
                        <div class="weui-media-box__hd">
                          <img class="weui-media-box__thumb" src="images/AnnofGreenGables.jpg" alt="">
                        </div>
                        <div class="weui-media-box__bd flex flex-v ">
                          <h4 class="weui-media-box__title">Ann of Green Gables绿山墙的安妮</h4>
                          <p class="weui-media-box__desc"> 《绿山墙的安妮》是加拿大女作家露西•莫德•蒙格马利创作的长篇小说，创作于1904年。
《绿山墙的安妮》讲述了纯真善良、热爱生活的女主人公小安妮，自幼失去父母，11岁时被绿山墙的马修和玛丽拉兄妹领养，但她个性鲜明，富于幻想，而且自尊自强，凭借自己的刻苦勤奋，不但得到领养人的喜爱，也赢得老师和同学的关心和友谊。
成长与梦想是全书的主题，作者以安妮的故事告诉人们：只要胸怀梦想，不懈努力，生活就会丰富多彩，生命就会美丽多姿。
</p>
                        </div>
						
                      </a>
                       
                    </div>
                </div>

                <div id="tab2" class="weui-tab__bd-item">
                  <div class="weui-panel__bd">
                     
                    </div>
                </div>
                <div id="tab3" class="weui-tab__bd-item">
                  <div class="weui-panel__bd">
                      
                    </div>
                </div>
                <div id="tab4" class="weui-tab__bd-item">
                  <div class="weui-panel__bd">
                      
                    </div>
                </div>
              </div>
            </div>
            <!-- weui-tab -->
       
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
                <img src="./images/tarbar_me.png" alt="/me">
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