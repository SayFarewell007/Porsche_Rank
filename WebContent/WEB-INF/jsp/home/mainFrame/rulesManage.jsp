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
	margin-top:  10px;
}
</style>
</head>
<body onload='init()'>
	<div class="box">
		<form id="ruleForm" action="ruleRedirect" method="post" accept-charset="utf-8" >
			<fieldset>
				<div align="center">
					<input id="modelId" name="modelId" class="easyui-combobox" 
				data-options="
							<!-- value: '---请选择销售车型---', --> 
    						valueField: 'id',
  						    textField: 'text',
   					        url: 'getCarsByBrandId?brand_id=189'
   					      
    					    " >
				</div>
				<br>
				<div id="p" class="easyui-panel" style="width:100%;height:100%;padding:10px;"
    			title="考核规则管理" iconCls="icon-save" collapsible="true">
  				  <table align='center' width="90%" class="table">
  				
  				   <tr>
  				 		<td colspan="2"> <label>车辆销售考核<br></label></td>
  				  </tr>
			<tr>
			<td>
			
			月销售<select id="condition1" name="condition1" class="easyui-combobox" style="width:90px;" data-options="editable: false " >
					 <option value="0" selected>条件1</option>
					 <option value="lt">小于</option>
    		     	 <option value="le">小于等于</option>
   					 <option value="gt">大于</option>
   					 <option value="ge">大于等于</option>
    
				</select>
				<input id="value1" name="value1" class="easyui-numberspinner" data-options="min:0,max:100" style="width:80px;"></input>辆，
				<select id="condition2" name="condition2" class="easyui-combobox" style="width:90px;" data-options="editable: false " >
					 <option value="0" selected>条件2</option>
					 <option value="lt">小于</option>
    		     	 <option value="le">小于等于</option>
   					 <option value="gt">大于</option>
   					 <option value="ge">大于等于</option>
    
				</select>
			    <input id="value2" name="value2" class="easyui-numberspinner" data-options="min:0,max:100" style="width:80px;"></input>辆时，记
			    <input id="points" class="easyui-numberbox" name="points" style="width:50px;" data-options="min:-100,max:100">分
    		</td>
    		<td>
    		<a href="javascript:void(0);" onclick="addCarTypeRule()" class="btn btn-default">增加规则</a>
    		<a href="javascript:void(0);" onclick="delCarTypeRule()" class="btn btn-default">删除规则</a>
    		</td>			    
    		</tr>
    
  				  
  				  <tr>
  				  
  				  <td>
  				  <div id="datalist1" class="easyui-datalist" title="已有车辆销售考核规则" style="width:800px;height:250px" data-options="
						url: 'datalist_data1.json',
						method: 'get',
						checkbox: true,
						selectOnCheck: false,
						onBeforeSelect: function(){return false;}
						">
				  </div>
  				  </td>
  				  <td>
  				  <a href="javascript:void(0);" onclick="delCarTypeRule()" class="btn btn-default">删除规则</a>
  				  </td>
  				  </tr>
  				<tr>
  				<td colspan="2"> 
  				<div align="center" style="width:80%;height:0px;border-top:1px black dashed;" />
  				</td>
  				</tr>
  		 <!-- ================================================================================================ -->		
  				  <!-- 精品考核 -->
  				  
  				  <tr>
  				 		<td colspan="2"> <label>精品考核<br></label></td>
  				  </tr>
			<tr>
			<td>
			
			均车计精品<select id="condition1_acc" name="condition1_acc" class="easyui-combobox" style="width:90px;" data-options="editable: false " >
					 <option value="0" selected>条件1</option>
					 <option value="lt">小于</option>
    		     	 <option value="le">小于等于</option>
   					 <option value="gt">大于</option>
   					 <option value="ge">大于等于</option>
    
				</select>
				<input id="value1_acc" name="value1_acc" class="easyui-numberspinner" data-options="min:0,max:500000" style="width:80px;"></input>元，
				<select id="condition2_acc" name="condition2_acc" class="easyui-combobox" style="width:90px;" data-options="editable: false " >
					 <option value="0" selected>条件2</option>
					 <option value="lt">小于</option>
    		     	 <option value="le">小于等于</option>
   					 <option value="gt">大于</option>
   					 <option value="ge">大于等于</option>
    
				</select>
			    <input id="value2_acc" name="value2_acc" class="easyui-numberspinner" data-options="min:0,max:50000" style="width:80px;"></input>元时，记
			    <input id="points_acc" name="points_acc" class="easyui-numberbox" style="width:50px;" data-options="min:-100,max:100">分
    		</td>
    		<td>
    		<a href="javascript:void(0);" onclick="addAccessoryTypeRule()"  class="btn btn-default">增加规则</a>
    		<a href="javascript:void(0);" onclick="delAccessoryTypeRule()"  class="btn btn-default">删除规则</a>
    		</td>			    
    		</tr>
    
  				  
  				  <tr>
  				  
  				  <td>
  				  <div id="datalist1_acc" class="easyui-datalist" title="已有搭售精品考核规则" style="width:800px;height:250px" data-options="
						url: 'datalist_data1.json',
						method: 'get',
						checkbox: true,
						selectOnCheck: false,
						onBeforeSelect: function(){return false;}
						">
				  </div>
  				  </td>
  				  <td>
  				  <a href="javascript:void(0);" onclick="delAccessoryTypeRule()"  class="btn btn-default">删除规则</a>
  				  </td>
  				  </tr>
    			   
    			   
    			   <tr>
  				<td colspan="2"> 
  				<div align="center" style="width:80%;height:0px;border-top:1px black dashed;" />
  				</td>
  				</tr>
  	<!-- ================================================================================================ -->	
    			  <!-- 非搭售精品考核 -->
  				 
  				 <tr>
  				 		<td colspan="2"> <label>非搭售精品考核<br></label></td>
  				  </tr>
			<tr>
			<td>
			
			当月非搭售精品总额<select id="condition1_notacc" name="condition1_notacc" class="easyui-combobox" style="width:90px;" data-options="editable: false " >
					 <option value="0" selected>条件1</option>
					 <option value="lt">小于</option>
    		     	 <option value="le">小于等于</option>
   					 <option value="gt">大于</option>
   					 <option value="ge">大于等于</option>
    
				</select>
				<input id="value1_notacc" name="value1_notacc" class="easyui-numberspinner" data-options="min:0,max:50000" style="width:80px;"></input>元，
				<select id="condition2_notacc" name="condition2_notacc" class="easyui-combobox" style="width:90px;" data-options="editable: false " >
					 <option value="0" selected>条件2</option>
					 <option value="lt">小于</option>
    		     	 <option value="le">小于等于</option>
   					 <option value="gt">大于</option>
   					 <option value="ge">大于等于</option>
    
				</select>
			    <input id="value2_notacc" name="value2_notacc" class="easyui-numberspinner" data-options="min:0,max:50000" style="width:80px;"></input>元时，记
			    <input id="points_notacc" name="points_notacc" class="easyui-numberbox" style="width:50px;" data-options="min:-100,max:100">分
    		</td>
    		<td>
    		<a href="javascript:void(0);" onclick="addNotAccessoryTypeRule()"  class="btn btn-default">增加规则</a>
    		<a href="javascript:void(0);" onclick="delNotAccessoryTypeRule()"  class="btn btn-default">删除规则</a>
    		</td>			    
    		</tr>
    
  				  
  				  <tr>
  				  
  				  <td>
  				  <div id="datalist1_notacc" class="easyui-datalist" title="已有非搭售精品考核规则" style="width:800px;height:250px" data-options="
						url: 'datalist_data1.json',
						method: 'get',
						checkbox: true,
						selectOnCheck: false,
						onBeforeSelect: function(){return false;}
						">
				  </div>
  				  </td>
  				  <td>
  				  <a href="javascript:void(0);" onclick="delNotAccessoryTypeRule()"  class="btn btn-default">删除规则</a>
  				  </td>
  				  </tr>
  				  
  				  
  			<!-- ================================================================================================ -->		  
  				    <!-- 金融考核项目 -->
  				 
  				 <tr>
  				 		<td colspan="2"> <label>金融考核<br></label></td>
  				  </tr>
			<tr>
			<td>
			
			如果车辆是<select id="condition1_paymode" name="condition1_paymode" class="easyui-combobox" style="width:100px;" data-options="editable: false " >
					 <option value="0" selected>条件1</option>
					 <option value="1">先付后贷车辆</option>
    		     	 <option value="2">正常贷款车辆</option>
   					 <option value="3">一次性车辆</option>
    
				</select>
				时，记
			    <input id="points_paymode" name="points_paymode" class="easyui-numberbox" style="width:50px;" data-options="min:-100,max:100">分
    		</td>
    		<td>
    		<a href="javascript:void(0);" onclick="addPayModeTypeRule()"  class="btn btn-default">增加规则</a>
    		<a href="javascript:void(0);" onclick="delPayModeTypeRule()"  class="btn btn-default">删除规则</a>
    		</td>			    
    		</tr>
    
  				  
  				  <tr>
  				  
  				  <td>
  				  <div id="datalist1_paymode" class="easyui-datalist" title="已有金融考核规则" style="width:800px;height:250px" data-options="
						url: 'datalist_data1.json',
						method: 'get',
						checkbox: true,
						selectOnCheck: false,
						onBeforeSelect: function(){return false;}
						">
				  </div>
  				  </td>
  				  <td>
  				  <a href="javascript:void(0);" onclick="delPayModeTypeRule()"  class="btn btn-default">删除规则</a>
  				  </td>
  				  </tr>
  		<!-- ================================================================================================ -->			  
  					    <!-- 二手车业务收购考核项目 -->
  				 
  				 <tr>
  				 		<td colspan="2"> <label>二手车收购业务考核<br></label></td>
  				  </tr>
			<tr>
			<td>
			
			如果收购二手车辆品牌是保时捷时，每台记
			    <input id="value1_secondhand" name="value1_secondhand" class="easyui-numberbox" style="width:50px;" data-options="min:-100,max:100">分，收购其他品牌二手车1台或以上，记
			    <input id="value2_secondhand" name="value2_secondhand" class="easyui-numberbox" style="width:50px;" data-options="min:-100,max:100">分。
    		</td>
    		<td>
    		<a href="javascript:void(0);" onclick="addSecondHandTypeRule()"  class="btn btn-default">增加规则</a>
    		<a href="javascript:void(0);" onclick="delSecondHandTypeRule()"  class="btn btn-default">删除规则</a>
    		</td>			    
    		</tr>
    
  				  
  				  <tr>
  				  
  				  <td>
  				  <div id="datalist1_secondhand" class="easyui-datalist" title="已有二手车收购业务考核规则" style="width:800px;height:250px" data-options="
						url: 'datalist_data1.json',
						method: 'get',
						checkbox: true,
						selectOnCheck: false,
						onBeforeSelect: function(){return false;}
						">
				  </div>
  				  </td>
  				  <td>
  				  <a href="javascript:void(0);" onclick="delSecondHandTypeRule()"  class="btn btn-default">删除规则</a>
  				  </td>
  				  </tr>  
  				  
				
		
	</table>
	
				</div>
				<div align="center"><button type="submit" class="btn" onsubmit="updateRules()" >提交</button></div>
			</fieldset>  
		</form>
	</div>


</body>

<script type="text/javascript">

	var retJson = null;  
	var data1,data2,data3;
	data1 = [];
	data2 = [];
	data3 = [];
	data4 = [];
	data5 = [];
	var allRulesArr = [];
	var i = 0;
	var data;
	var selectedCarType;
	
	function addCarTypeRule() {
		
	 	var condition1 = document.getElementsByName("condition1")[0].value;
		var value1 = document.getElementsByName("value1")[0].value;
		var condition2 = document.getElementsByName("condition2")[0].value;
		var value2 = document.getElementsByName("value2")[0].value;
		var points = document.getElementsByName("points")[0].value; 
		data = $('#datalist1').datalist("getData");
		var flag = check1(condition1,value1,condition2,value2,points,data);
		if(!flag){
			return;
		}
		
		
		var i = data.total + 1;
		
		//var strDisplay = "";
		var strDisplay =  "月销售" + $('#condition1').combobox("getText") + $('#value1').numberspinner('getValue') + "辆";
		if((condition2 != "0" && (value2 != ""))) {
			
			strDisplay +=  "且" + $('#condition2').combobox("getText") + $('#value2').numberspinner('getValue') + "辆";
		}
		
		strDisplay += "时，记" + $('#points').numberbox("getValue") + "分";
		
		data1.push({"id":i,"text":strDisplay,"cartype": selectedCarType,"ruletype":"carTypeRule","condition1":condition1,"value1":value1,"condition2":condition2,"value2":value2,"points":points});
		$('#datalist1').datalist("loadData",data1);
		
	}
	
	function delCarTypeRule() {
		var tmpArr = new Array();
		var delArr = $('#datalist1').datalist("getChecked");
		for(var i=0;i < data1.length;i++){
			if(!delArr.includes(data1[i])){
				tmpArr.push(data1[i]);
			}
		}
		data1 = tmpArr.slice();
		$('#datalist1').datalist("loadData",data1);
		
	}
	
	function addAccessoryTypeRule() {
		
	 	var condition1 = document.getElementsByName("condition1_acc")[0].value;
		var value1 = document.getElementsByName("value1_acc")[0].value;
		var condition2 = document.getElementsByName("condition2_acc")[0].value;
		var value2 = document.getElementsByName("value2_acc")[0].value;
		var points = document.getElementsByName("points_acc")[0].value; 
		data = $('#datalist1_acc').datalist("getData");
		var flag = check1(condition1,value1,condition2,value2,points,data);
		if(!flag){
			return;
		}
		
		
		var i = data.total + 1;
		
		//var strDisplay = "";
		var strDisplay =  "均车计搭售精品" + $('#condition1_acc').combobox("getText") + $('#value1_acc').numberspinner('getValue') + "元";
		if((condition2 != "0" && (value2 != ""))) {
			
			strDisplay +=  "且" + $('#condition2_acc').combobox("getText") + $('#value2_acc').numberspinner('getValue') + "元";
		}
		
		strDisplay += "时，记" + $('#points_acc').numberbox("getValue") + "分";
		
		data2.push({"id":i,"text":strDisplay,"cartype": selectedCarType,"ruletype":"AccessoryTypeRule","condition1":condition1,"value1":value1,"condition2":condition2,"value2":value2,"points":points});
		$('#datalist1_acc').datalist("loadData",data2);
		
	}
	
	function delAccessoryTypeRule() {
		var tmpArr = new Array();
		var delArr = $('#datalist1_acc').datalist("getChecked");
		for(var i=0;i < data2.length;i++){
			if(!delArr.includes(data2[i])){
				tmpArr.push(data2[i]);
			}
		}
		data2 = tmpArr.slice();
		$('#datalist1_acc').datalist("loadData",data2);
		
	}
	
	
	function addNotAccessoryTypeRule() {
		
	 	var condition1 = document.getElementsByName("condition1_notacc")[0].value;
		var value1 = document.getElementsByName("value1_notacc")[0].value;
		var condition2 = document.getElementsByName("condition2_notacc")[0].value;
		var value2 = document.getElementsByName("value2_notacc")[0].value;
		var points = document.getElementsByName("points_notacc")[0].value; 
		data = $('#datalist1_notacc').datalist("getData");
		var flag = check1(condition1,value1,condition2,value2,points,data);
		if(!flag){
			return;
		}
		
		
		var i = data.total + 1;
		
		//var strDisplay = "";
		var strDisplay =  "当月非搭售精品总额" + $('#condition1_notacc').combobox("getText") + $('#value1_notacc').numberspinner('getValue') + "元";
		if((condition2 != "0" && (value2 != ""))) {
			
			strDisplay +=  "且" + $('#condition2_notacc').combobox("getText") + $('#value2_notacc').numberspinner('getValue') + "元";
		}
		
		strDisplay += "时，记" + $('#points_notacc').numberbox("getValue") + "分";
		
		data3.push({"id":i,"text":strDisplay,"cartype": selectedCarType,"ruletype":"NotAccessoryTypeRule","condition1":condition1,"value1":value1,"condition2":condition2,"value2":value2,"points":points});
		$('#datalist1_notacc').datalist("loadData",data3);
		
	}
	
	function delNotAccessoryTypeRule() {
		var tmpArr = new Array();
		var delArr = $('#datalist1_notacc').datalist("getChecked");
		for(var i=0;i < data3.length;i++){
			if(!delArr.includes(data3[i])){
				tmpArr.push(data3[i]);
			}
		}
		data3 = tmpArr.slice();
		$('#datalist1_notacc').datalist("loadData",data3);
		
	}
	
	function addPayModeTypeRule() {
		
	 	var condition1 = document.getElementsByName("condition1_paymode")[0].value;
		var points = document.getElementsByName("points_paymode")[0].value; 
		data = $('#datalist1_paymode').datalist("getData");
		var flag = check2(condition1,points,data);
		if(!flag){
			return;
		}
		
		
		var i = data.total + 1;
		
		//var strDisplay = "";
		var strDisplay =  "如果车辆是" + $('#condition1_paymode').combobox("getText");
		
		strDisplay += "时，记" + $('#points_paymode').numberbox("getValue") + "分";
		
		data4.push({"id":i,"text":strDisplay,"cartype": selectedCarType,"ruletype":"PayModeTypeRule","condition1":condition1,"value1":0,"condition2":"","value2":0,"points":points});
		$('#datalist1_paymode').datalist("loadData",data4);
		
	}
	
	function delPayModeTypeRule() {
		var tmpArr = new Array();
		var delArr = $('#datalist1_paymode').datalist("getChecked");
		for(var i=0;i < data4.length;i++){
			if(!delArr.includes(data4[i])){
				tmpArr.push(data4[i]);
			}
		}
		data4 = tmpArr.slice();
		$('#datalist1_paymode').datalist("loadData",data4);
		
	}
	
	
	
	function addSecondHandTypeRule() {
		
	 	var value1 = document.getElementsByName("value1_secondhand")[0].value;
	 	var value2 = document.getElementsByName("value2_secondhand")[0].value;
		data = $('#datalist1_secondhand').datalist("getData");
		
		var dataArray = data.rows;
		if(dataArray.length == 1){
			alert("新增条件与已有条件存在冲突，无法添加");
			return;	
		}
		
		
		
		
		var i = data.total + 1;
		
		//var strDisplay = "";
		var strDisplay =  "如果收购二手车辆品牌是保时捷时，每台记" + $('#value1_secondhand').numberbox("getValue") ;
		
		strDisplay += "分，收购其他品牌二手车1台或以上，记" + $('#value2_secondhand').numberbox("getValue") + "分";
		
		data5.push({"id":i,"text":strDisplay,"cartype": selectedCarType,"ruletype":"SecondHandTypeRule","condition1":"","value1":value1,"condition2":"","value2":value2,"points":0});
		$('#datalist1_secondhand').datalist("loadData",data5);
		
	}
	
	function delSecondHandTypeRule() {
		var tmpArr = new Array();
		var delArr = $('#datalist1_secondhand').datalist("getChecked");
		for(var i=0;i < data5.length;i++){
			if(!delArr.includes(data5[i])){
				tmpArr.push(data5[i]);
			}
		}
		data5 = tmpArr.slice();
		$('#datalist1_secondhand').datalist("loadData",data5);
		
	}
	
	function check1(c1,v1,c2,v2,p1,data) {
		var condition1 = c1;
		var value1Str = v1;
		var condition2 = c2;
		var value2Str = v2;
		var pointsStr = p1;
		var value1 = parseInt(value1Str);
		var value2 = parseInt(value2Str);
		var points = parseInt(pointsStr);
		
		if(condition1 == "0" || (value1Str == "")){
			alert("条件1 和 值1 必须输入");
			return false;
		}
		
		
		if((condition2 == "0" && (value2Str != "")) || 
		   (condition2 != "0" && (value2Str == ""))){
			alert("条件2 和 值2 必须同时输入或同时不输");
			return false;
		} 
		
		if(pointsStr == ""){
			alert("计分不能为空，请输入计分");
			return false;
		}
		
		if((condition1 == "lt" || condition1 == "le") && (condition2 == "lt" || condition2 == "le")){
			alert("条件1 与 条件2 只有一个有效，无法添加");
			return false;
		}
		
		if((condition1 == "gt" || condition1 == "ge") && (condition2 == "gt" || condition2 == "ge")){
			alert("条件1 与 条件2 只有一个有效，无法添加");
			return false;
		}
		
		if((condition1 == "gt" || condition1 == "ge") && (condition2 == "lt" || condition2 == "le")){
			if(value1 >= value2){
				alert("条件1 与 条件2没有交集，无法添加");	
				return false;
			}
			
		}
		
		if((condition1 == "lt" || condition1 == "le") && (condition2 == "gt" || condition2 == "ge")){
			if(value1 <= value2){
				alert("条件1 与 条件2没有交集，无法添加");	
				return false;
			}
			
		}
		
		var dataArray = data.rows;
		
		if(dataArray.length > 0){
			for(var i=0 ; i<dataArray.length ; i++){
				var row = dataArray[i];
				var list_condition1 = row.condition1;
				var list_value1Str     = row.value1;
				var list_condition2 = row.condition2;
				var list_value2Str  = row.value2;
				var list_value1     = parseInt(list_value1Str);
				var list_value2     = parseInt(list_value2Str);
				
				if((condition1 == "lt" || condition1 == "le") && condition2 == "0"){
					
					if((list_condition1 == "lt" || list_condition1 == "le" ) && list_condition2 == "0"){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if(condition1 == "le" && list_condition1 == "ge" && value1 == list_value1){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if(condition1 == "le" && list_condition2 == "ge" && value1 == list_value2){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if((list_condition1 == "ge" || list_condition1 == "gt") && list_value1 < value1){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if((list_condition2 == "ge" || list_condition2 == "gt") && list_value2 < value1){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
						
				
				
				} else if((condition1 == "gt" || condition1 == "ge") && condition2 == "0"){
					
					if((list_condition1 == "gt" || list_condition1 == "ge" ) && list_condition2 == "0"){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if(condition1 == "ge" && list_condition1 == "le" && value1 == list_value1){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if(condition1 == "ge" && list_condition2 == "le" && value1 == list_value2){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if((list_condition1 == "le" || list_condition1 == "lt") && list_value1 > value1){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
					if((list_condition2 == "le" || list_condition2 == "lt") && list_value2 > value1){
						alert("新增条件与已有条件存在冲突，无法添加");
						return false;
					}
					
						
				} else if(condition2 != "0"){
					var less_condition = (condition1 == "lt" || condition1 == "le") ? condition1 : condition2; 
					var less_value     = (condition1 == "lt" || condition1 == "le") ? value1 : value2; 
					
					var greater_condition = (less_condition == condition1) ? condition2 : condition1;
					var greater_value     = (less_value     == value1) ? value2 : value1;
					
					if(list_condition2 == "0" ){
						if(list_condition1 == "le") {
							if(greater_condition == "gt" && list_value1 > greater_value){
								alert("新增条件与已有条件存在冲突，无法添加");
								return false;
							}
							
							if(greater_condition == "ge" && list_value1 >= greater_value)
								alert("新增条件与已有条件存在冲突，无法添加");
								return false;
						}
						
						if(list_condition1 == "lt" && list_value > greater_value){
							alert("新增条件与已有条件存在冲突，无法添加");
							return false;
						}
						
						if(list_condition1 == "ge") {
							if(less_condition == "le" && list_value1 <= less_value ){
								alert("新增条件与已有条件存在冲突，无法添加");
								return false;
							}
							
							if(less_condition = "lt" && list_value < less_value) {
								alert("新增条件与已有条件存在冲突，无法添加");
								return false;
								
							}
							
						}
						
					}else {
						var less_list_condition = (list_condition1 == "lt" || list_condition1 == "le") ? list_condition1 : list_condition2;
						var less_list_value     = (list_condition1 == "lt" || list_condition1 == "le") ? list_value1 : list_value2;
						
						var greater_list_condition = (less_list_condition == list_condition1) ? list_condition2 : list_condition1;
						var greater_list_value     = (less_list_condition == list_condition1) ? list_value2 : list_value1;
						
						if(!((less_list_condition == "le" && greater_condition == "gt" && less_list_value <= greater_value) || 
						(less_list_condition == "le" && greater_condition == "ge" && less_list_value < greater_value) ||
						(less_list_condition == "lt" && greater_condition == "ge" && less_list_value <= greater_value) ||
						(less_list_condition == "lt" && greater_condition == "gt" && less_list_value <= greater_value) ||
						
						(greater_list_condition == "ge" && less_condition == "le" && greater_list_value > less_value) ||
						(greater_list_condition == "ge" && less_condition == "lt" && greater_list_value >= less_value) ||
						(greater_list_condition == "gt" && less_condition == "lt" && greater_list_value >= less_value) ||
						(greater_list_condition == "gt" && less_condition == "le" && greater_list_value >= less_value)
						)){
							alert("新增条件与已有条件存在冲突，无法添加");
							return false;
						}
					}
					
				}
			}
			
		}
		
		//alert("正确");
		return true;
		
		
	}

	function check2(c1,p1,data) {
		var condition1 = c1;
		var pointsStr = p1;
		var points = parseInt(pointsStr);
		
		if(condition1 == "0"){
			alert("条件1 必须输入");
			return false;
		}
		
		if(pointsStr == ""){
			alert("计分不能为空，请输入计分");
			return false;
		}
		
				
		var dataArray = data.rows;
		
		if(dataArray.length > 0){
			for(var i=0 ; i<dataArray.length ; i++){
				var row = dataArray[i];
				var list_condition1 = row.condition1;
				
				if(list_condition1 == condition1) {
					alert("新增条件与已有条件存在冲突，无法添加");
					return false;
					
				}
				
			}
			
		}
		
		//alert("正确");
		return true;
		
		
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
	
	
	function updateRules(){
		
		data = $('#datalist1').datalist("getData");
		var dataArr = data.rows;
		
		if(dataArr.length > 0){
			
			for(var i=0 ; i<dataArr.length ; i++){
				allRulesArr.push(dataArr[i]);
			}
			
		}
		
		data = $('#datalist1_acc').datalist("getData");
		var dataArr = data.rows;
		
		if(dataArr.length > 0){
			
			for(var i=0 ; i<dataArr.length ; i++){
				allRulesArr.push(dataArr[i]);
			}
			
		}
		
		data = $('#datalist1_notacc').datalist("getData");
		var dataArr = data.rows;
		
		if(dataArr.length > 0){
			
			for(var i=0 ; i<dataArr.length ; i++){
				allRulesArr.push(dataArr[i]);
			}
			
		}
		
		data = $('#datalist1_paymode').datalist("getData");
		var dataArr = data.rows;
		
		if(dataArr.length > 0){
			
			for(var i=0 ; i<dataArr.length ; i++){
				allRulesArr.push(dataArr[i]);
			}
			
		}
		
		data = $('#datalist1_secondhand').datalist("getData");
		
		var dataArr = data.rows;
		
		if(dataArr.length > 0){
			
			for(var i=0 ; i<dataArr.length ; i++){
				allRulesArr.push(dataArr[i]);
			}
			
		}
		
		//alert(allRulesArr);
		
		$.ajax({
		    type:'POST',
		    url:'updateRules',
		    data:JSON.stringify(allRulesArr),
		    dataType:'json',
		    contentType:"application/json",
		    beforeSend: function () {
		      　　$.messager.progress({ 
		         　　title: '提示', 
		         　　msg: '数据加载中，请稍候……', 
		         　　text: '' 
		      　　});
		      },
		      complete: function () {
		           $.messager.progress('close');
		      },
		      success:function(data){
		    	  
		    	  alert('保存成功！');
		      }
			
		});
		
	}
	
	function init(){
		
		//var carRulesArr = new Array();
		//$('#modelId').combobox('select',3364);
		<%
			String modelId = (String)request.getParameter("modelId");
			if(modelId == null){
				modelId = "";
			}
		%>
		  var modelId = '<%=modelId %>';
		  
		  //alert(modelId);
		  $(function(){
		    $('#modelId').combobox({
		    	
		        onChange:function(n,o){
		        	
		        	selectedCarType = n;
		        	
		        	refreshData(selectedCarType); 
		        	//显示蒙版
		        	/*
		        	　$.messager.progress({ 
		              　　title: '提示', 
		              　　msg: '数据加载中，请稍候……', 
		              　　text: '' 
		           　　});
		        	
		        	alert('test');
		        	// 结束后消失蒙版
		        	//$.messager.progress('close');
		        	
		        	*/
		        }
		        
		        
		        
		    });
		    
		    $('#ruleForm').submit(updateRules);
		    
		    refreshData(modelId); 
		    
		    
		    
		});  
		  
		 
		
	}
	
	function refreshData(modelId){
		
		if(modelId != null && modelId != '' && modelId != 'null' ){
     		
	    	$('#modelId').combobox('select',modelId);
	    	
	    	var data_carTypeRule = [];
	    	var data_AccessoryTypeRule = [];
	    	var data_NotAccessoryTypeRule = [];
	    	var data_PayModeTypeRule = [];
	    	var data_SecondHandTypeRule = [];
	    	//重新加载数据显示datalist
	    	$('#datalist1').datalist("loadData",data_carTypeRule);
	    	$('#datalist1_acc').datalist("loadData",data_AccessoryTypeRule);
	    	$('#datalist1_notacc').datalist("loadData",data_NotAccessoryTypeRule);
	    	$('#datalist1_paymode').datalist("loadData",data_PayModeTypeRule);
	    	$('#datalist1_secondhand').datalist("loadData",data_SecondHandTypeRule);
	    		
	    		
	    		
	    	//获取modelId对应的全部规则
	    	var url = 'getRulesByCarType?cartype=' + modelId;
	    	$.ajax({
			    type:'GET',
			    url:url,
     		    success:function(data){
     		    	//alert('data!' + JSON.stringify(data));
     		    	var jsonDataArr = JSON.parse(JSON.stringify(data));
     		    	//alert(jsonDataArr);
     		    	
     		    	if(jsonDataArr.length > 0) {
     		    		
     		    		
     		    		for(var i=0; i < jsonDataArr.length; i++){
     		    			var tmp_rule = jsonDataArr[i];
     		    			if(tmp_rule.ruletype == "carTypeRule"){
     		    				data_carTypeRule.push(tmp_rule);
     		    			}else if(tmp_rule.ruletype == "AccessoryTypeRule"){
     		    				data_AccessoryTypeRule.push(tmp_rule);
     		    			}else if(tmp_rule.ruletype == "NotAccessoryTypeRule"){
     		    				data_NotAccessoryTypeRule.push(tmp_rule);
     		    			}else if(tmp_rule.ruletype == "PayModeTypeRule"){
     		    				data_PayModeTypeRule.push(tmp_rule);
     		    			}else if(tmp_rule.ruletype == "SecondHandTypeRule"){
     		    				data_SecondHandTypeRule.push(tmp_rule);
     		    			}
     		    			
     		    		}
     		    		
     		    		//重新加载数据显示datalist
     		    		$('#datalist1').datalist("loadData",data_carTypeRule);
     		    		$('#datalist1_acc').datalist("loadData",data_AccessoryTypeRule);
     		    		$('#datalist1_notacc').datalist("loadData",data_NotAccessoryTypeRule);
     		    		$('#datalist1_paymode').datalist("loadData",data_PayModeTypeRule);
     		    		$('#datalist1_secondhand').datalist("loadData",data_SecondHandTypeRule);
     		    		
     		    	}
			    
			    }
				
			});
	    }
		
		
	}
</script>

</html>