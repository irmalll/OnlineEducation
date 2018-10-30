<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <meta name="apple-mobile-web-app-capable" content="yes">
            <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
                <meta name="generator" content="bd-mobcard">
                    <meta http-equiv="Cache-Control" content="no-cache" />
                    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

                    <title>每日一练</title>
                    <link href="css/style.css" rel="stylesheet" type="text/css" />
                    </head>

                    <body>
                        <div   id="sr"  style=" width: 100%; height: 80%;display: none; left: 0;right: 0; margin-left:auto;margin-right:auto; margin-top: 50px; position: fixed; z-index: -100" >
                            <span id="close"> <img src="imags/guanbi.png"> </span>
                        <iframe width="100%" height="100%" name="s" id="s">
                          
                        </iframe>
                         </div>
    <div class="sharebox" id="fenxiang" style="display: none">
    <div class="sharetop"></div>
    
       <div class="sharetitle2">
     <div class="sharetitle2left"><img src="imags/shareico.jpg" /></div>
     <div class="sharetitle2right"><a >分享到</a></div>
   </div>
    
   <div class="shareicobox">
       
      <div class="icon1">
           <a onclick="WeiXinShareBtn()"  >
        <div class="icon1top"><img src="imags/weixin.jpg" /></div>
        <div class="conbottomcon">微信</div>
        </a>
      </div>
       
      <div class="icon1">
               <a href="http://v.t.sina.com.cn/share/share.php?url=http://wx.linewow.com/meiriyilian/index.htmlt&title='每日一练'" target="s">
        <div class="icon1top"><img src="imags/xinlang.jpg" /></div>
         </a>
        <div class="conbottomcon">新浪微博</div>
       
     </div>
       
      <div class="icon1">
     <a href="http://v.t.qq.com/share/share.php?url=http://wx.linewow.com/meiriyilian/index.html&title='每日一练'" target="s">
        <div class="icon1top"><img src="imags/tengxun.jpg" /></div>
         </a>
        <div class="conbottomcon">腾讯微博</div>
       
      </div>
       
      <div class="icon1">
          <a href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http://wx.linewow.com/meiriyilian/index.html&title='每日一练'" target="s">
        <div class="icon1top"><img src="imags/kongjian.jpg" /></div>
           </a>
        <div class="conbottomcon">QQ空间</div>
     
      </div>
       
      <div style="clear:both;"></div>
   </div>   
   
   <div class="quxiao">取　消</div>
   
</div>
                        <div class="headerbox">
                            <div class="headerleft"><a id="share"><img src="imags/jiantou.jpg" /></a></div>
                            每日一练
                        </div>

                        <div class="djsbox"><span class="timeico"><img src="imags/timeicon.png" /></span>距离下节课更新还有： <span class="timestyle" id='divname'></span></div>

                        <div class="box">

                            <div class="mrtopic">Today's Topic:<span class="topicstyle">“Why” Questions</span></div>
                            <div class="btn"><a  class="i"></a></div>
                            <div class="line" id="testDiv"><span><a  id="line"></a></span></div>
                            <script type="text/javascript">
                                $('#testDiv').mousemove(function(e) {
                                    var xx = e.originalEvent.x || e.originalEvent.layerX || 0;
                                    //ar yy = e.originalEvent.y || e.originalEvent.layerY || 0; 
                                    var x = document.getElementById("a");
                                    var time = x.duration;
                                    var z = $(this).width();
                                    var start = parseInt(xx / z * time);
                                    x.currentTime = start;

                                });
                            </script>
                            <div class="timebox">
                                <span class="timeleft" id="cc">00:00</span>
                                <span class="timeright" id="all"></span>  </div>
                            <div style=" display: none">
                                <audio id="a" controls="controls" src="http://wx.linewow.com/Public/test/mp3/39-LP_20140807181404.mp3">

                                </audio>
                            </div>
                        </div>

                        <div class="classbigimgbox">
                            <img src="imags/53e207863bbc8.jpg" id="t_infoimg" />
                        </div>
                        <div class="cihuititle"> 课程教材</div>

                        <div class="lianxiconen">
                            场景一<br/>1.Why are some people more successful than others?<br/>
                            为什么有些人比其他人更成功呢？<br/><br/>

                            场景一<br/>2.Why are divorce rates climbing?<br/>
                            为什么离婚率不断上升呢？<br/><br/>

                            场景一<br/>3.Why do clothing fashions change so quickly?<br/>
                            为什么服饰流行变化这么快？
                        </div>


                        <div class="cihuititle"> 本课重点词汇</div>
                        <div class="lianxiconch">
                            economist 经济学家<br/>
                            socialist economy社会主义经济<br/>
                            capitalist economy 资本主义经济<br/>
                            collective economy 集体经济<br/>
                            planned economy 计划经济<br/>
                            controlled economy 管制经济<br/>
                            rural economics 农村经济</div>

                    </body>
                    </html>
                    <script language="javascript" type="text/javascript">
                        
                           $(function(){   
                               function update(){
                                  $.getJSON('http://wx.linewow.com/index.php/show/ajax_app_test/type/today?jsoncallback=?', function(data) {
                                    // alert('aaa');
//                                       alert(data.t_id);
                                    $('.topicstyle').html(data.t_jianjieen);
                                    $('#a').attr('src', "http://wx.linewow.com/Public/test/mp3/" + data.t_recording);
                                    $('#t_infoimg').attr('src', "http://wx.linewow.com/Public/test/infoimg/" + data.t_infoimg);
                                    $('.lianxiconen').html(data.t_coutenten);
                                    $('.lianxiconch').html(data.t_words);

                                })
                        }
                        function getone(){
                                     $.getJSON('http://wx.linewow.com/index.php/show/ajax_app_test/type/yesterday?jsoncallback=?', function(data) {
                                       // alert('aaa');
   //                                       alert(data.t_id);
                                       $('.topicstyle').html(data.t_jianjieen);
                                       $('#a').attr('src', "http://wx.linewow.com/Public/test/mp3/" + data.t_recording);
                                       $('#t_infoimg').attr('src', "http://wx.linewow.com/Public/test/infoimg/" + data.t_infoimg);
                                       $('.lianxiconen').html(data.t_coutenten);
                                       $('.lianxiconch').html(data.t_words);

                                   })
                           }
						   // 页面加载完成 判断时间大于 18点 则 调用 今天的数据，否则调用昨天的数据。
                               var n = new Date();
                               var t=n.getUTCHours();
                               if(t>18){
                                    update();
                               }else{
                                    getone();
                               }
 
                                 //分享
                                 $('#share').click(function(){
                                    
//                                     $('#fenxiang').css('display','block');
                                     $('#fenxiang').fadeIn("slow");
                                     
                                 });
                                $('.quxiao').click(function(){
                                      $('#fenxiang').fadeOut("slow");
                                });
                                    $('.icon1 a').click(function(){
                                       
                                        $('#fenxiang').fadeOut("slow");
                                        $('#sr').css('z-index','100');
                                        $('#sr').css('display','block');
                                    });
                                $('#close').click(function(){
                                    
                                     $('#sr').css('z-index','-100');
                                        $('#sr').css('display','none');
                                });

 
                            });
                        
                           // 定时器                    
                        var interval = 1000;
                         function update(){
                                  $.getJSON('http://wx.linewow.com/index.php/show/ajax_app_test/type/today?jsoncallback=?', function(data) {
                                    // alert('aaa');
//                                       alert(data.t_id);
                                    $('.topicstyle').html(data.t_jianjieen);
                                    $('#a').attr('src', "http://wx.linewow.com/Public/test/mp3/" + data.t_recording);
                                    $('#t_infoimg').attr('src', "http://wx.linewow.com/Public/test/infoimg/" + data.t_infoimg);
                                    $('.lianxiconen').html(data.t_coutenten);
                                    $('.lianxiconch').html(data.t_words);

                                })
                        }
                        function ShowCountDown(divname)
                        {
                            var now = new Date();
                            var endDate = new Date(now.getUTCFullYear(), now.getUTCMonth(), now.getUTCDate(), 18);
                            var leftTime = endDate.getTime() - now.getTime();
                            var leftsecond = parseInt(leftTime / 1000);
                            //var day1=parseInt(leftsecond/(24*60*60*6)); 
                            if (leftsecond < 0) {
                                var leftsecond = Math.floor(leftsecond + 24 * 60 * 60);
                            }
                            if (leftsecond == 0) {
                                update();
                            }
                            var day1 = Math.floor(leftsecond / (60 * 60 * 24));
                            var hour = Math.floor((leftsecond - day1 * 24 * 60 * 60) / 3600);
                            var minute = Math.floor((leftsecond - day1 * 24 * 60 * 60 - hour * 3600) / 60);
                            var second = Math.floor(leftsecond - day1 * 24 * 60 * 60 - hour * 3600 - minute * 60);
                            var cc = document.getElementById(divname);
                            //alert(endDate);
                            if (hour < 10) {
                                hour = '0' + hour;
                            }
                            if (minute < 10) {
                                minute = '0' + minute;
                            }
                            if (second < 10) {
                                second = '0' + second;
                            }
                            cc.innerHTML = hour + ":" + minute + ":" + second;
                        }

						// 每一秒 更新   头部的时间
                        window.setInterval(function() {
                            ShowCountDown('divname');
                        }, interval);
                    </script> 
                     <!--音乐播放器-->
                    <script type="text/javascript">

                        function getdate(time) {

                            fen = parseInt(time / 60);
                            miao = parseInt(time - fen * 60);
                            if (fen < 10) {
                                fen = '0' + fen;
                            }
                            if (miao < 10) {
                                miao = '0' + miao;
                            }
                            return  fen + ':' + miao;
                        }


                        window.onload = function() {

                       var x = document.getElementById("a");
                            var m = x.duration;
                            var t = Math.floor(m / 60);
                            var s = Math.floor(m - t * 60);
                            if (t < 10) {
                                t = '0' + t;
                            }
                            if (s < 10) {
                                s = '0' + s;
                            }
                            var all = t + ':' + s;
                            //         alert(m);
                            //     $('#all').html(all);

                        };

                   // 播放器 播放是跟新进度条长度
                        function check() {
                            var x = document.getElementById("a");
                            var cc = document.getElementById('cc');

                            var testDiv = $('#testDiv').width();

                            var time = x.currentTime;
                            var zong = x.duration;
                            var w = testDiv * time / zong;

                            if (time <= zong) {
                                var ti = getdate(time);
                                var all = getdate(zong);
                                cc.innerHTML = ti;
                                $('#line').width(w);
                                $('#all').html(all);
                            }

                        }
                        ;
                         // 播放器开始和停止
                        $('.i').click(function() {
                            var x = document.getElementById("a");
                            if (x.paused) {
                                x.play();
                                $(this).css('backgroundImage', "url('./imags/anniu2.jpg')");
								// 更新进度条
                                window.setInterval("check()", 1000);
                            } else {
                                x.pause();
                                $(this).css('backgroundImage', "url('./imags/anniu.jpg')");
                            }


                        })
                         function WeiXinShareBtn() {
                                    if (typeof WeixinJSBridge == "undefined") {
                                    alert("请先通过微信搜索 线话英语 添加线话英语为好友，通过微信分享文章 :) ");
                                    } else {
                                    WeixinJSBridge.invoke('shareTimeline', 
                                    {
                                    "title":"线话英语",
                                    "link": "http://wx.linewow.com/index.php/meiriyilian/index.html",
                                    "desc": "关注线话英语",
                                    "img_url": "http://wx.linewow.com/index.php/meiriyilian/imags/58-58.png"
                                    });
                                    }
                                    }


                    </script>