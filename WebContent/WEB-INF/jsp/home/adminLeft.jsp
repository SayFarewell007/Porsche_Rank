<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../base.jsp"%>
<html>
<head>
<script type="text/javascript">
function changeStyle(id) {
	var lis = document.getElementsByTagName("li");
	for(var i=0;i<lis.length;i++){
		lis[i].className = "";
	}
   	var obj = document.getElementById(id);
	obj.className = "active";
}

window.onload = function() {
	var clock = document.getElementById('clock');
	setInterval(function() {
		var now = new Date();
		clock.innerHTML = now.getFullYear() + '年' + (now.getMonth() + 1)
				+ '月' + now.getDate() + '日' + '<br/>' + now.getHours()
				+ ':' + now.getMinutes() + ':' + now.getSeconds();
		clock.style.color = 'gray'; //设置随机颜色
	}, 1000)
}
</script>
<style type="text/css">
body{
    background-color:#d4d4d4;
}
</style>
</head>

<body>
	<div style="padding: 10px;padding-left">
		<ul class="nav nav-pills nav-stacked">
			<li id="li1" onclick="changeStyle('li1')" class="active"><a
				target="mainFrame" href="homeMain">企业文化</a></li>
			<li id="li2" onclick="changeStyle('li2')"><a target="mainFrame"
				href="analysis">整体统计分析</a></li>
			<li id="li3" onclick="changeStyle('li3')"><a target="mainFrame"
				href="adminDocumentary">销售经理跟单</a></li>
			<li id="li6" onclick="changeStyle('li6')"><a target="mainFrame"
				href="ordersManage?beginDate=&endDate=&name=">管理订单</a></li>
			<li id="li4" onclick="changeStyle('li4')"><a target="mainFrame"
				href="others">其他功能</a></li>
			<li id="li5" onclick="changeStyle('li5')"><a target="mainFrame"
				href="orders">入单</a></li>
			<li id="li7" onclick="changeStyle('li7')"><a target="mainFrame"
				href="rulesManage">考核规则管理</a></li>
			<li id="clock" style="font-size: 20px;margin-left: 10px;"></li>
		</ul>
	</div>
</body>
</html>