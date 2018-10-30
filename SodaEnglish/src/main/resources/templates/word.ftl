<!DOCTYPE html>
<html style="height: 100%;">

<head>
    <title></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="description" content="">
   
	
    <script src="js/jquery.min.js"></script>
	
    <link rel="stylesheet" href="css/index.css">
	
    <script src='js/index.js'></script>
	
</head>

<body>
   
    <div class="container">

       
        <div class="wordItemBox">
            <p class="word">attend </p><img class="pronounce" src="images/pronounce.png" alt="voice">
            <hr>
            <p class="translate">vi 出席,致力于,献身于,侍候,照顾,关注;</p>
			<hr>
			<p class="translate">vt 出席,参加（常用于被动语态，作为结果，情况）伴随,照顾，陪伴;</p>
			<hr>
			<p class="translate">例句：Thounds of people attend the furneral .数千人参加了葬礼</p>	
        </div>
         <div class="wordItemBox">
            <p class="word">attend </p><img class="pronounce" src="images/pronounce.png" alt="voice">
            <hr>
            <p class="translate">vi 出席,致力于,献身于,侍候,照顾,关注;</p>
			<hr>
			<p class="translate">vt 出席,参加（常用于被动语态，作为结果，情况）伴随,照顾，陪伴;</p>
			<hr>
			<p class="translate">例句：Thounds of people attend the furneral .数千人参加了葬礼</p>	
        </div>
         <div class="wordItemBox">
            <p class="word">attend </p><img class="pronounce" src="images/pronounce.png" alt="voice">
            <hr>
            <p class="translate">vi 出席,致力于,献身于,侍候,照顾,关注;</p>
			<hr>
			<p class="translate">vt 出席,参加（常用于被动语态，作为结果，情况）伴随,照顾，陪伴;</p>
			<hr>
			<p class="translate">例句：Thounds of people attend the furneral .数千人参加了葬礼</p>	
        </div>
         <div class="wordItemBox">
            <p class="word">attend </p><img class="pronounce" src="images/pronounce.png" alt="voice">
            <hr>
            <p class="translate">vi 出席,致力于,献身于,侍候,照顾,关注;</p>
			<hr>
			<p class="translate">vt 出席,参加（常用于被动语态，作为结果，情况）伴随,照顾，陪伴;</p>
			<hr>
			<p class="translate">例句：Thounds of people attend the furneral .数千人参加了葬礼</p>	
        </div>
      
    </div>
   <audio id="audio" src="http://dict.youdao.com/dictvoice?type=2&audio=hello"></audio>
</body>
<script>
    var url = $('#audio').attr('src');

    // 点击发音图标里发音
    $('img.pronounce').click(function(){
        var word = $(this).parent().find('p').eq(0).text();
        newurl = url.replace('hello',word);
       
        $('#audio').attr('src',newurl).trigger('play');
    });

    // 点击单词时发音
    $('p.word').click(function(){
        var word = $(this).text();
        newurl = url.replace('hello',word);
        $('#audio').attr('src',newurl).trigger('play');
    })

    $('.banner button').click(function(){
        $(window).scrollTop(404);
    })
</script>

</html>