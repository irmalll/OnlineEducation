<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
    <link href="../css/MyCenter.css" rel="stylesheet" />
    <link href="../css/WeUI/weui.min.css" rel="stylesheet" />


    <style>
        body {
            font-family: 'Microsoft YaHei';
        }

        p {
            font-size: 4.5vw;
        }
    </style>
    <title>苏打英语，快乐学英语</title>



</head>

<body>
    <div class="top_div">
        <img src="../css/images/bac.jpg" class="top_img">
        <div class="userInfo">
            <img   class="uPic" th:src="@{${headImgUrl}}" /><br/>
            <img src="../css/images/hy.png" class="hy" />
            <span class="uName" style="color:#302e2e; font-weight:bold;">
                                     年费会员 2017-03-02到期
            </span><br />
            <span class="uBalance" th:text="${nickName}"></span>
         
        </div>
    </div>
    <div class="weui-cells__title">开通年费会员所有视频免费观看</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check__label" for="x11">
            <div class="weui-cell__bd">
                <p style="font-weight:bold; color:#ffd800;"><span style="font-size:2.5vw; color:#808080; font-weight:100;">开通/续费</span>&nbsp;&nbsp;&nbsp;普通课程99元/月</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" class="weui-check" name="radio1" id="x11" />
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="x12">
            <div class="weui-cell__bd">
                <p style="font-weight:bold; color:#ff6a00;"><span style="font-size:2.5vw; color:#808080; font-weight:100;">开通/续费</span>&nbsp;&nbsp;&nbsp;高级课程199元/季</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" name="radio1" class="weui-check" id="x12" />
                <span class="weui-icon-checked"></span>
            </div>
        </label>
       
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips">立即开通/续费</a>
    </div>
</body>
</html>