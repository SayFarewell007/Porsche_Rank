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

	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js">
	</script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js">
	</script>

</head>
<body onload='init()'>
<br>
<div id="monthselect" align="center">
					<input id="modelId" name="modelId" class="easyui-combobox" 
				data-options="
							value: '---请选择统计月份---', 
    						valueField: 'id',
  						    textField: 'text',
  						    editable: false,
   					        url: 'getAvailableMonths',
 		  					onChange:getSummaryReport
  							  ">
				</div>

 <div id="rankTable" style="display:none" class="zzsc-container">
	<section id="accordion" class="accordion"> 
	
		 	<!--  <div class="item">
	 		    	<img src="img/Location-Pin.png" alt="">
	 		    	<h3>第一名:</h3><h3>sss</h3><h3 style="float:right;width:20%;color:red;font-size:22px">83分</h3></div>
	 		    	<p>aaaa</p>  -->
	 		    	 
	 		    	
		   <!-- <div class="item">
				<img src="img/Location-Pin.png" alt="">
				<h3>第一名:</h3><h3>周杰伦</h3><h3 style="float:right;width:20%;color:red;font-size:22px">60分</h3>
		   </div>
				<p>
					<table width="80%">
						<tr>
							<td>姓名</td>
							<td>姓名</td>
							<td>姓名</td>
							<td>姓名</td>
					
					</table>

				</p>
			<div class="item">
				<img src="img/Location-Pin.png" alt="">
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
	 -->
	   </section>
</div>
 

</body>

<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	/* (function ($) {
		'use strict';
		$('.item').on("click", function () {
			$(this).next().slideToggle(100);
			$('p').not($(this).next()).slideUp('fast');
		});
	}(jQuery)); */
</script>


<script type="text/javascript">

	function init(){
		/* <div id="rankTable" style="display:none" class="zzsc-container">
		<section id="accordion" class="accordion"> */
			var line0 = '<div id="rankTable" style="display:none" class="zzsc-container">';
			var line01 = '<section id="accordion" class="accordion">';
			var line1 = '<div class="item">';
	    	var line2 = '<img src="img/Location-Pin.png" alt="">'
	    	var line3 = '<h3>第一名:</h3><h3>aaaaa</h3><h3 style="float:right;width:20%;color:red;font-size:22px">sssss分</h3></div>';
	    	var line4 = '<p>aaaa</p>';
	    	var line5 = '</section>'
	    	var line6 = '</div>'
	    	
/* 	    	</section>
	    	</div> */
	    	
	    	
	    	
		
	}
	
	
	function getSummaryReport(yyyymm){
		
		//alert('get report' + data.id);
		//document.getElementById("rankTable").style.display="";//显
		//获取modelId对应的全部规则
    	var url = 'getSummaryReport?month=' + yyyymm;
    	  $.ajax({
		    type:'GET',
		    async:false, 
		    url:url,
		     beforeSend: function () {
		    	 
		    	 //alert('showMask');
		    	 //showMask();
		    	 
		    	/* $.messager.progress({ 
			         title: '提示', 
			         msg: '数据加载中，请稍候……', 
			         text: '' 
			      }); */
		      },
		    complete: function () {
		    	
		    	//alert('complete');
		    	//hideMask();
		           /* $.messager.progress('close'); */
		      }, 
		      
 		    success:function(data){
 		    	
 		    	//alert(JSON.stringify(data));
 		    	document.getElementById("rankTable").style.display="";//显
 		    	
 		    	var jsonDataArr = JSON.parse(JSON.stringify(data));
 		    	
 		    	var singleLine = jsonDataArr[0];
		    		
		    		
		    		var line1 = '<div class="item">' + '<img src="img/Location-Pin.png" alt="">' + '<h3>第一名:</h3><h3>aaaaa</h3><h3 style="float:right;width:20%;color:red;font-size:22px">sssss分</h3></div>' + '<p>aaaa</p>';
	 		    	var line2 = ''
	 		    	var line3 = '';
	 		    	var line4 = '';
	 		    	/* $('#accordion').append(line1);
	 		    	$('#accordion').append(line2);
	 		    	$('#accordion').append(line3);
	 		    	$('#accordion').append(line4);
	 		    	
	 		    	$("#accordion").trigger("create"); */
	 		    	//$('#accordion').trigger("resize");
	 		    	/* var myEvent = new Event('resize');
	 		    	window.dispatchEvent(myEvent); */
	 		    	
 		    	//alert(jsonDataArr.length);
 		    	/*
 		    	
 		    	
 		    	<div class="item">
				<img src="img/Location-Pin.png" alt="">
				<h3>第一名:</h3><h3>周杰伦</h3><h3 style="float:right;width:20%;color:red;font-size:22px">60分</h3>
		   		</div>
				<p>
					<table width="80%">
						<tr>
							<td>姓名</td>
							<td>姓名</td>
							<td>姓名</td>
							<td>姓名</td>
					
					</table>

				</p>
				
 		    	
 		    	*/
 		    	 // 清除原来的数据
 		    	 $('#accordion').empty();
 		    	 
 		    	 for(var i=0; i<jsonDataArr.length;i++){
 		    		
 		    		var singleLine = jsonDataArr[i];
 		    		
 		    		
 		    		//var line1 = '<div class="item">';
 		    		var line1 = '<div class="item">' + '<img src="img/Location-Pin.png" alt="">' + '<h3>第'+ singleLine.rank +'名:</h3><h3>'+ singleLine.username +'</h3><h3  style="float:right;width:20%;color:red;font-size:22px;text-shadow:1px 1px 1px #000;">'+singleLine.totalPoints+'分</h3></div>' + '<p style="font-size:15px;">';
 		    		line1 += '<table width="80%" border="1" cellspacing="0" border-color="green" color="white" cellpadding="1" bgcolor="white"><tr><td>销售日期</td><td width="30%">销售车型</td><td>精品</td><td>非搭售精品</td><td>付款方式</td><td>收购二手车品牌</td></tr>';
 		    		
 		    		
 		    		var ordersArr = singleLine.orders;
 		    		
 		    		if(ordersArr.length > 0){
 		    			
 		    			for(var k=0; k< ordersArr.length; k++){
 		    				line1 += ('<tr><td>'+ordersArr[k].tranDate+'</td><td>'+ordersArr[k].model+'</td><td>'+ordersArr[k].accessory+'</td><td>'+ordersArr[k].notAccessory+'</td><td>'+ordersArr[k].payMode+'</td><td>'+ordersArr[k].secondHandCarType+'</td></tr>');
 		    			}
 		    			
 		    		} 
 		    		
 		    		line1 += '</table><br><br>';
 		    		
 		    		var pointRemarksArr = singleLine.pointsRemark;
 		    		
 		    		if(pointRemarksArr.length > 0){
 		    			
 		    			for(var j =0; j< pointRemarksArr.length; j++) {
 		    				line1 += (pointRemarksArr[j].text + '记' + pointRemarksArr[j].point + '分<br>');	
 		    			}
 		    			 	
 		    		} 
 		    		
 		    		line1 += '</p>';
 	 		    
 	 		    	$('#accordion').append(line1);
 	 		    	
 	 		    	(function ($) {
 	 		  		'use strict';
 	 		  		$('.item').on("click", function () {
 	 		  			$(this).next().slideToggle(200);
 	 		  			Console.log($(this).next());
 	 		  			//alert('call slideToggle');
 	 		  			$('p').not($(this).next()).slideUp('fast');
 	 		  		});
 	 		  		}(jQuery)); 
 	 		    	
 		    		
 		    	} 
 		    	
 		    	
 		    	
 		    	
		    }
			
		});  
	}
	
	function showMask(){
		
		$.messager.progress({ 
	         title: '提示', 
	         msg: '数据加载中，请稍候……', 
	         text: '' 
	      }); 
		
	}
	
	function hideMask(){
		
		$.messager.progress('close');
	}

   
</script>

</html>