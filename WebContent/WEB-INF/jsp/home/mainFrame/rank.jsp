<%@ page contentType="text/html; charset=utf-8"%>

<html>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>销售排行榜</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/zzsc-demo.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="zzsc-container">
	<section class="accordion">
		   <div class="item">
				<img src="img/Location-Pin.png" alt="">
				<h3>第一名</h3>
		   </div>
				<p>t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using</p>
			<div class="item">
				<img src="img/Headphones.png" alt="">
				<h3>第一名</h3>
		   </div>
			<p>t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using</p>
			<div class="item">
				<img src="img/Lightbulb.png" alt="">
				<h3>第一名</h3>
		   </div>
				<p>t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using</p>
			<div class="item">
				<img src="img/Bookmarks.png" alt="">
				<h3>第一名</h3>
		   </div>
				<p>t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using</p>
			<div class="item">
				<img src="img/Lightning-Bolt.png" alt="">
				<h3>第一名</h3>
		   </div>
			   <p>t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using</p>
	   </section>
</div>

<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	(function ($) {
		'use strict';
		$('.item').on("click", function () {
			$(this).next().slideToggle(100);
			$('p').not($(this).next()).slideUp('fast');
		});
	}(jQuery));
</script>


</body>
</html>