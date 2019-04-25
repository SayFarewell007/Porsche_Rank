<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%><html>
<head>
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js">
	</script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js">
	</script>
</head>
<body>
	<div align="center">
		<h4>———— 经理跟单 ————</h4>
	</div>
	
	<table align='center' width="90%" class="table">
		<tr>
			<td style="display:none;">项目ID</td>
			<td>销售日期</td>
			<td>销售车型</td>
			<td>精品</td>
			<td>非搭售精品</td>
			<td>付款方式</td>
			<td>收购二手车品牌</td>
			<td>收购二手车型号</td>
			<td>销售人</td>
			<td>添加日期</td>
			<td>修改日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="c" varStatus="st">
			<tr>
				<td style="display:none;">${c.id}</td>
				<td>${c.tranDate}</td>
				<td>${c.model}</td>
				<td>${c.accessory}</td>
				<td>${c.notAccessory}</td>
				<td>${c.payMode}</td>
				<td>${c.secondHandCarType}</td>
				<td>${c.secondHandCarDetail}</td>
				<td>${c.name}</td>
				<td>${c.inputDate}</td>
				<td>${c.modDate}</td>
				<td><a href="#" class="btn btn-default" data-toggle="modal" data-target="#myModal">修改</a> 
					<a href="deleteProject?id=${c.id}" class="btn btn-default">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<!-- 修改订单信息（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改订单信息</h4>
				</div>
				
				<form action="changeProject" method="post" accept-charset="utf-8">
					<input type="hidden" name="id" value="">
					
					<label class="col-md-4 control-label" style="width:130px">销售日期：</label>
					<div class="col-md-8" style="float: left">
						 <input type="text" class="form-control" name="tranDate" value=""
							placeholder="#"> 
						<!-- <input name="tranDate" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser " value=""
							placeholder="#"></input> -->
					</div>

					<br><br>
					<label class="col-md-4 control-label" style="width:130px;float:left;">销售车型：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="model" value=""
							placeholder="#">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">精品：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="accessory" value=""
							placeholder="#">
					</div>
					<br><br>

					<label class="col-md-4 control-label" style="width:130px;float:left;">非搭售精品：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="notAccessory" value=""
							placeholder="#" > <!-- readonly="readonly -->
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">付款方式：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="payMode" value=""
							placeholder="#">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">收购二手品牌：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="secondHandCarType" value=""
							placeholder="#">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">收购二手型号：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="secondHandCarDetail" value=""
							placeholder="#">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">销售人：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="name" value=""
							placeholder="#">
					</div>
					<br><br>
					
					<!-- <label class="col-md-4 control-label" style="width:130px;float:left;">销售人：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="name" value=""
							placeholder="#" list="wlmslist1">
						<datalist id="wlmslist1">
							<option value="待支付">待支付</option>
							<option value="已取消">已取消</option>
							<option value="已发货">已发货</option>
							<option value="已完成">已完成</option>
						</datalist>
					</div> -->
					<br><br>
					
					<!-- <label class="col-md-4 control-label" style="width:114px;float:left;">开始时间：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="startDate" value=""
							placeholder="#">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:114px;float:left;">结束时间：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="endDate" value=""
							placeholder="#">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:114px;float:left;">下一步计划：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="plan" value=""
							placeholder="#">
					</div>
					<br><br> -->

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交更改</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		$('#myModal').on('show.bs.modal', function(event) {
			var btnThis = $(event.relatedTarget); //触发事件的按钮  
			var modal = $(this); //当前模态框  
			alert(btnThis);
			alert('hello~');
			var modalId = btnThis.data('id'); //解析出data-id的内容  
			var content = btnThis.closest('tr').find('td').eq(0).text();
			modal.find('input[name="id"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(1).text();
			modal.find('input[name="tranDate"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(2).text();
			modal.find('input[name="model"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(3).text();
			modal.find('input[name="accessory"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(4).text();
			modal.find('input[name="notAccessory"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(5).text();
			modal.find('input[name="payMode"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(6).text();
			modal.find('input[name="secondHandCarType"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(7).text();
			modal.find('input[name="secondHandCarDetail"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(8).text();
			modal.find('input[name="name"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(9).text();
			modal.find('input[name="plan"]').val(content);
			
		});
	</script>

	<a href="#" class="btn btn-default"
		style="float: right; margin-right: 60px;" data-toggle="modal"
		data-target="#myModal1">审批意见</a>
	<!-- 审批意见（Modal） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">编写审批意见</h4>
				</div>
				
				<form action="addInstruction" method="post" accept-charset="utf-8">
					<label class="col-md-4 control-label" style="width:114px;float:left;">审批人：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="adminName" value="${sessionScope.user.name}"
							placeholder="#"  readonly="readonly">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:114px;float:left;">审批对象：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="staffName" value=""
							placeholder="#">
					</div>
					<br><br>

					<label class="col-md-4 control-label" style="width:114px;float:left;">审批内容：</label>
					<div class="col-md-8" style="float: left">
						<textarea type="text" class="form-control" name="content"
							value="" placeholder="#" style="height: 200px;"></textarea>
					</div>
					<br><br><br><br><br><br><br><br><br><br>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		$(function() {
			$('#myModal1').on('hide.bs.modal', function() {
				 location.reload();
			})
		});
	</script>
	
	
</body>
</html>