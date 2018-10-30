<!DOCTYPE html>
<html>

<head>
    <title>正文</title>
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
    <div class="art-main clearfix">
        <div class="art-cont clearfix">
            <div class="art-title">
                <h1>Ann of Green Gables绿山墙的安妮</h1>
                <p class="art-time">
                    2017-09-20 18:30:15
                </p>
            </div>
            <div class="art-nl">
                <img src="images/AnnofGreenGables.jpg" alt="">
                <p style="padding-top: .4rem;">
                    There are plenty of people in Avonlea and out of it, who can attend closely to their neighbor’s business by dint of neglecting their own; but Mrs. Rachel Lynde was one of those capable creatures who can manage their own concerns and those of other folks into the bargain. She was a notable housewife; her work was always done and well done; she “ran” the Sewing Circle, helped run the Sunday-school, and was the strongest prop of the Church Aid Society and Foreign Missions Auxiliary. Yet with all this Mrs. Rachel found abundant time to sit for hours at her kitchen window, knitting “cotton warp” quilts—she had knitted sixteen of them, as Avonlea housekeepers were wont to tell in awed voices—and keeping a sharp eye on the main road that crossed the hollow and wound up the steep red hill beyond. Since Avonlea occupied alittle triangular peninsula jutting out into the Gulf of St. Lawrence with water on two sides of it, anybody who went out of it or into it had to pass over that hill road and so run the unseen gauntlet of Mrs. Rachel’s all-seeing eye.
                </p>
            </div>
        </div>
       
    </div>
   
    
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