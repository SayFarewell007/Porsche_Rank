<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%><html>
<head>
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.easyui.min.js">
	</script>
	<script>
	
	function trim(s){  
	    return trimRight(trimLeft(s));  
	} 
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
				<%-- <td>${c.payMode}</td> --%>
				<td><c:if test="${c.payMode =='1'}">先付后贷车辆</c:if><c:if test="${c.payMode =='2'}">正常贷款车辆</c:if><c:if test="${c.payMode =='3'}">一次性车辆</c:if><c:if test="${c.payMode =='0'}"></c:if></td>
				<td>${c.secondHandCarType}</td>
				<td>${c.secondHandCarDetail}</td>
				<td>${c.name}</td>
				<td>${c.inputDate}</td>
				<td>${c.modDate}</td>
				<td><a href="#" class="btn btn-default" data-toggle="modal" data-target="#myModal">修改</a> 
					<a href="deleteOrder?id=${c.id}" class="btn btn-default">删除</a>
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
				
				<form action="updateOrder" method="post" accept-charset="utf-8">
					<input type="hidden" name="id" value="">
					
					<label class="col-md-4 control-label" style="width:130px">销售日期：</label>
					<div class="col-md-8" style="float: left">
						<input id="carTranDate" name="tranDate" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser " ></input>
						<!-- <input type="text" class="form-control" name="tranDate" value=""
							placeholder="#"> -->
					</div>

					<br><br>
					<label class="col-md-4 control-label" style="width:130px;float:left;">销售车型：</label>
					<div class="col-md-8" style="float: left">
						
						 <input id="carModel" name="model" class="easyui-combobox" 
							data-options="
							value: '---请选择销售车型---', 
    						valueField: 'id',
  						    textField: 'text',
   					        url: 'getCarsByBrandId?brand_id=189'
    					    " >
    					    <!--  <input type="text" class="form-control" name="model" value=""
							placeholder="#">  -->
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">精品：</label>
					<div class="col-md-8" style="float: left">
						<!-- <input type="text" class="form-control" name="accessory" value=""
							placeholder="#"> -->
							
							<input type="text" id="carAccessory" name="accessory" class="easyui-numberbox" value="0" data-options="min:0,precision:2">
					</div>
					<br><br>

					<label class="col-md-4 control-label" style="width:130px;float:left;">非搭售精品：</label>
					<div class="col-md-8" style="float: left">
						<!-- <input type="text" class="form-control" name="notAccessory" value=""
							placeholder="#"> -->
							<input type="text" id="carNotAccessory" name="notAccessory" class="easyui-numberbox" value="0" data-options="min:0,precision:2">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">付款方式：</label>
					<div class="col-md-8" style="float: left">
						<select id="carPayMode" name="payMode" class="easyui-combobox" style="width:200px;">
					 		<option value="0" selected>---请选择付款方式---</option>
    		     			 <option value="1">先付后贷车辆</option>
   							 <option value="2">正常贷款车辆</option>
   							 <option value="3">一次性车辆</option>
    
						</select>
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">收购二手品牌：</label>
					<div class="col-md-8" style="float: left">
					 	<!-- <input type="text" class="form-control" name="secondHandCarType" value=""
							placeholder="#">
						 -->
						 <input id="carSecondHandCarType" name="secondHandCarType" class="easyui-combobox" 
					data-options="
							value: '---请选择品牌---', 
    						valueField: 'id',
  						    textField: 'name',
   					        url: 'getCarsBrands',
    					    onSelect: function(rec){
 						    var url = 'getCarsByBrandId?brand_id='+rec.id;
 						    $('#carSecondHandCarDetail').attr('value','666');
 						    $('#carSecondHandCarDetail').combobox('reload', url);
 						      
  							  }">
							
							
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">收购二手型号：</label>
					<div class="col-md-8" style="float: left">
						<!-- <input type="text" class="form-control" name="secondHandCarDetail" value=""
							placeholder="#"> -->
							
							<input id="carSecondHandCarDetail" name="secondHandCarDetail" class="easyui-combobox" data-options="valueField:'id',textField:'text',value: '---请选择车型---' ">
					</div>
					<br><br>
					
					<label class="col-md-4 control-label" style="width:130px;float:left;">销售人：</label>
					<div class="col-md-8" style="float: left">
						<input type="text" class="form-control" name="name" value=""
							placeholder="#">
					</div>
					<br><br>

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
			var modalId = btnThis.data('id'); //解析出data-id的内容  
			var content = btnThis.closest('tr').find('td').eq(0).text();
			modal.find('input[name="id"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(1).text();
			modal.find('input[name="tranDate"]').val(content);
			$("#carTranDate").datebox("setValue",myformatter(new Date(content.replace(/-/g,"/"))));
			var content = btnThis.closest('tr').find('td').eq(2).text();
			//modal.find('input[name="model"]').val(content);
			//console.log(modal.find('input[name="model"]'));
			$('#carModel').combobox('select', content);
			
			var content = btnThis.closest('tr').find('td').eq(3).text();
			
			$('#carAccessory').numberbox('setValue',content);
			
			var content = btnThis.closest('tr').find('td').eq(4).text();
	
			$('#carNotAccessory').numberbox('setValue',content);
			
			var content = btnThis.closest('tr').find('td').eq(5).text();
			
			$('#carPayMode').combobox('select', content);
			
			var content = btnThis.closest('tr').find('td').eq(6).text();
			
			$('#carSecondHandCarType').combobox('setValue', content);
			
			modal.find('input[name="secondHandCarType"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(7).text();
			$('#carSecondHandCarDetail').combobox('setValue', content);
			
			modal.find('input[name="secondHandCarDetail"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(8).text();
			modal.find('input[name="name"]').val(content);
			var content = btnThis.closest('tr').find('td').eq(9).text();

			
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