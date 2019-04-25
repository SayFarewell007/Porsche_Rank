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
	
	

<style type="text/css">
.box {
	margin-left: 10px;
}
</style>
</head>
<body onload='init()'>
	<div class="box">
		<form action="addOrder" method="post" accept-charset="utf-8" >
			<fieldset>
				<div align="center">
					<h4>————新增订单————</h4>
				</div>
				<div id="p" class="easyui-panel" style="width:100%;height:100%;padding:10px;"
    			title="新增销售" iconCls="icon-save" collapsible="true">
  				  <table align='center' width="90%" class="table">
		<tr>

			<td><label>销售车型</label></td><td><input name="modelId" class="easyui-combobox" 
				data-options="
							value: '---请选择销售车型---', 
    						valueField: 'id',
  						    textField: 'text',
  						    editable: false,
   					        url: 'getCarsByBrandId?brand_id=189'
    					    " ></td>
    					    
    	</tr>	
    	<tr>			    
			<td><label>精品</label></td><td><input type="text"  name="accessory" class="easyui-numberbox" value="0" data-options="min:0,precision:2"></td>
		</tr>
		<tr>
			<td><label>非搭售精品</label></td>
			<td><input type="text"  name="notAccessory" class="easyui-numberbox" value="0" data-options="min:0,precision:2"></td>
		</tr>
		<tr>
			<td><label>付款方式</label></td>
			<td><select name="payMode" class="easyui-combobox" style="width:200px;" data-options="editable: false " >
					 <option value="0" selected>---请选择付款方式---</option>
    		     	 <option value="1">先付后贷车辆</option>
   					 <option value="2">正常贷款车辆</option>
   					 <option value="3">一次性车辆</option>
    
				</select></td>
		</tr>
		<tr>
			<td><label>收购二手车品牌</label></td>
		
			<td><label><input id="cc1" name="secondHandCarTypeId" class="easyui-combobox" 
					data-options="
							value: '---请选择品牌---', 
    						valueField: 'id',
  						    textField: 'name',
  						    editable: false,
   					        url: 'getCarsBrands',
    					    onSelect: function(rec){
 						    var url = 'getCarsByBrandId?brand_id='+rec.id;
 						    $('#cc2').attr('value','666');
 						    $('#cc2').combobox('reload', url);
 						    
 						    <!-- $('#cc2').attr('value','---请选择车型---'); -->     
  							  }"></label></td>
  		</tr>
  		<tr>
			<td><label>收购二手车型号</label></td>
			<td><label><input id="cc2" name="secondHandCarDetailId" class="easyui-combobox" data-options="valueField:'id',textField:'text',editable: false,value: '---请选择车型---' "></label></td>
		</tr>	
		
		<tr>	
			<td><label>销售日期</label></td> <td><input name="tranDate" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser " ></input></td>
		</tr>
		<tr>
			<td><label>销售人</label></td> 
			<td><input type="text" name="name" value="${user.name }"/></td> 
		</tr>
		
	</table>
	
				</div>
				
	
				<button type="submit" class="btn">提交</button>
			</fieldset>
		</form>
	</div>

	<table align='center' width="90%" class="table">
		<tr>
			<td style="display:none;">项目ID</td>
			<td>项目名</td>
			<td>负责人</td>
			<td>客户</td>
			<td>货物</td>
			<td>货物数量</td>
			<td>订单状态</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>下一步计划</td>
		</tr>
		<c:forEach items="${list}" var="c" varStatus="st">
			<tr>
				<td style="display:none;">${c.id}</td>
				<td>${c.name}</td>
				<td>${c.staffName}</td>
				<td>${c.clientName}</td>
				<td>${c.goodsName}</td>
				<td>${c.goodsNumber}</td>
				<td>${c.state}</td>
				<td>${c.startDate}</td>
				<td>${c.endDate}</td>
				<td>${c.plan}</td>
			</tr>
		</c:forEach>
	</table>
</body>

<script type="text/javascript">

	var retJson = null;  
	
	function check1() {
		var goodsName = document.getElementsByName("goodsName")[0].value;
		var goodsNumber = document.getElementsByName("goodsNumber")[0].value;
		var unitPrice = document.getElementsByName("unitPrice")[0].value;
		
		
		if (goodsName == "") {
			alert("商品名不能为空！");
			return false;
		} else if (goodsNumber == "") {
			alert("储量不能为空！");
			return false;
		} else if (unitPrice == "") {
			alert("单价不能为空！");
			return false;
		}
	}

	function check2() {
		var clientName = document.getElementsByName("clientName")[0].value;
		if (clientName == "") {
			alert("客户姓名不能为空！");
			return false;
		}
	}
	
	function check3() {
		var ClientName1 = document.getElementsByName("ClientName1")[0].value;
		var ClientPhone = document.getElementsByName("ClientPhone")[0].value;
		if (ClientName1 == "") {
			alert("客户姓名不能为空！");
			return false;
		}else if (ClientPhone == "") {
			alert("号码不能为空！");
			return false;
		}
	}
	
	function init(){
			
		
	    var retObj = $.ajax({
	        type: "get",
	        url: "listGoods",
	        cache: false,
	        async : false,
	        dataType: "json",
	        success: function (data ,textStatus, jqXHR)
	        {
	          
	                if(textStatus == 'success'){
	                	
	                	retJson = data.Detail;
	                	//alert(data.TotalCount);	
	                	
	                }
	                
	          
	        },
	        error:function (XMLHttpRequest, textStatus, errorThrown) {      
	            alert("请求失败！");
	        }
	     });
	    


		
	
	}
</script>

</html>