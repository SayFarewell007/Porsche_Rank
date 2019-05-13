package leon.sms.controller;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.javafx.css.Rule;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import leon.sms.pojo.Car;
import leon.sms.pojo.Orders;
import leon.sms.pojo.Rules;
import leon.sms.pojo.User;
import leon.sms.service.CarsService;
import leon.sms.service.GoodsService;
import leon.sms.service.OrdersService;
import leon.sms.service.RulesService;
import leon.sms.service.UserService;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:24:27
* @version 1.0
* 类说明 :
* 
*/
@Controller
@RequestMapping("")
public class OrdersController
{	
	private static Logger logger = Logger.getLogger(OrdersController.class);
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	RulesService rulesService;
	
	@Autowired
	CarsService carsService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("addOrder")
	public ModelAndView addOrders(@RequestParam("name") String name,
								  /*@RequestParam("model") String model , */
								  @RequestParam("modelId") String modelId , 
								  @RequestParam("accessory") String accessory , 
								  @RequestParam("notAccessory") String notAccessory , 
								  @RequestParam("payMode") String payMode , 
								  @RequestParam("source") String source , 
								  /*@RequestParam("secondHandCarType") String secondHandCarType ,*/
								  @RequestParam("secondHandCarTypeId") String secondHandCarTypeId , 
								  /*@RequestParam("secondHandCarDetail") String secondHandCarDetail ,*/
								  @RequestParam("secondHandCarDetailId") String secondHandCarDetailId , 
								  @RequestParam("tranDate") String tranDate  
								   )
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/orders");
		
		ordersService.addOrder(name, modelId, modelId,  accessory, notAccessory, payMode, source, secondHandCarTypeId, secondHandCarTypeId, secondHandCarDetailId, secondHandCarDetailId, tranDate);
		
		return mav;
	}
	
	
	@RequestMapping("updateOrder")
	public String updateOrders(
								  @RequestParam("id") String id,
			                      @RequestParam("name") String name,
								  @RequestParam("model") String model , 
								 // @RequestParam("modelId") String modelId ,  
								  @RequestParam("accessory") String accessory , 
								  @RequestParam("notAccessory") String notAccessory , 
								  @RequestParam("payMode") String payMode , 
								  @RequestParam("source") String source , 
								  @RequestParam("secondHandCarType") String secondHandCarType ,
								  /*@RequestParam("secondHandCarTypeId") String secondHandCarTypeId , */
								  @RequestParam("secondHandCarDetail") String secondHandCarDetail ,
								  /*@RequestParam("secondHandCarDetailId") String secondHandCarDetailId , */
								  @RequestParam("tranDate") String tranDate  
								   )
	{
		ordersService.updateOrder(Integer.valueOf(id), name, model, model,  accessory, notAccessory, payMode, source, secondHandCarType, secondHandCarType, secondHandCarDetail, secondHandCarDetail, tranDate);
		logger.info("更新了id=" + id + "的订单");
		logger.info("id:" + id + "controller====" + "name:" + name + " model:" +model + "accessory:"+ accessory + "notAccessory:" + notAccessory + "payMode:" + payMode  +"secondHandCarType:" + secondHandCarType + "secondHandCarDetail:" + secondHandCarDetail + "tranDate:" + tranDate);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/ordersManage");
		
		//mav.addObject("list", ordersService.getAllOrders(null, null, null));
		//return mav;
		return "redirect:ordersManage?beginDate=&endDate=&name=";
	}
	
	@RequestMapping("ordersManage")
	public ModelAndView ordersManage(@RequestParam(value="beginDate",required=false) String beginDate,
									 @RequestParam(value="endDate",required=false) String endDate,
									 @RequestParam(value="name",required=false) String name
			)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/ordersManage");
		mav.addObject("list", ordersService.getAllOrders(beginDate, endDate, name));
		return mav;
	}
	
	@RequestMapping("deleteOrder")
	public String delete(@RequestParam("id") int id){
		
		ordersService.delete(id);
		return "redirect:ordersManage?beginDate-&endDate=&name=";
	}
	
	
	@RequestMapping("getAvailableMonths")
	public @ResponseBody ArrayList<HashMap<String, String>> getAvailableMonths(){
		
		ArrayList<HashMap<String, String>> availableMonths = ordersService.getAvailableMonths();
		return availableMonths;
	}
	
	/*@RequestMapping("testStatic")
	public void testStatic(){
		ordersService.getModelPayModeCountByName("2019-04", "admin");
		//ordersService.getModelPayModeCountByName("2019-05", "admin2");
		ordersService.getModelPayModeCountByName("2019-04", "oo");
		ordersService.getModelPayModeCountByName("2019-04", "oo");
		ordersService.getModelPayModeCountByName("2019-05", "admin2");
		ordersService.getModelPayModeCountByName("2019-05", "admin");
		ordersService.getModelPayModeCountByName("2019-05", "oo");
		
	}*/
	
	public boolean intesect(Rules carTypeRule, int value){
		
		
		if (carTypeRule.getCondition2().equals("0")) {
			if (carTypeRule.getCondition1().equals("gt") && (value > carTypeRule.getValue1() )) {
				return true;
			}
			
			if (carTypeRule.getCondition1().equals("ge") && (value >= carTypeRule.getValue1() )) {
			    return true;
			}
			
			if (carTypeRule.getCondition1().equals("lt") && (value < carTypeRule.getValue1() )) {
				return true;
			}
			
			if (carTypeRule.getCondition1().equals("le") && (value <= carTypeRule.getValue1() )) {
				return true;
			}
		}else {
			
			String less_condition = (carTypeRule.getCondition1().equals("lt") || carTypeRule.getCondition1().equals("le")) ? carTypeRule.getCondition1() : carTypeRule.getCondition2(); 
			int less_value     = (carTypeRule.getCondition1().equals("lt") || carTypeRule.getCondition1().equals("le")) ? carTypeRule.getValue1() : carTypeRule.getValue2(); 
			
			String greater_condition = (less_condition.equals(carTypeRule.getCondition1())) ? carTypeRule.getCondition2() : carTypeRule.getCondition1();
			int greater_value     = (less_value  == carTypeRule.getValue1()) ? carTypeRule.getValue2(): carTypeRule.getValue1();
			
			if (((less_condition.equals("lt") && (value < less_value)) || (less_condition.equals("le") && (value <= less_value))) &&
			   ((greater_condition.equals("gt") && (value > greater_value)) || (greater_condition.equals("ge") && (value >= greater_value))))
			{
				return true;
			}
			
		}
		
		return false;
		
	}
		
	
	@RequestMapping("getSummaryReport")
	public @ResponseBody ArrayList<HashMap<String, Object>> getSummaryReport(@RequestParam(value="month") String yyyymm){
		
		// 获取所有的rules到allRules
		ArrayList<Rules> allRules = new ArrayList<>();
		ArrayList<Car> carsModelIds = carsService.getCarsByBrandId("189");  // 189-保时捷
		for (Car car : carsModelIds) {
			System.out.println(car);
			ArrayList<Rules> rulesByCarType = rulesService.getRulesByCarType(car.getId());
			if(rulesByCarType.size() > 0){
				allRules.addAll(rulesByCarType);
			}
		}
		
		// 获取所有用户name到allUsernames
		ArrayList<String> allUsernames = new ArrayList<>();
		
		
		//logger.info("testetstetstetstes");
		
		ArrayList<User> userList = userService.list();
		if (null != userList && userList.size() > 0) {
			for (User user : userList) {
				//System.out.println(user);
				allUsernames.add(user.getName());
				
			}
		}
		
		// 获取当月所有订单到allOrders
		String beginDate = yyyymm + "-01";
		String endDate = yyyymm + "-31";
		ArrayList<Orders> allOrders = ordersService.getAllOrders(beginDate, endDate, null);
		
		// 存储所有人当月订单，和积分的List
		ArrayList<HashMap<String, Object>> reportList = new ArrayList<>();
		
		// 遍历所有用户，每个用户查找对应的所有订单，对订单做下面统计：总销量，每个型号销量，总搭售精品金额，车均搭售精品金额（总搭售精品金额/总销量），
		// 总非搭售精品金额，每个型号的付款方式，保时捷二手车数量，非保时捷二手车数量
		for (String name : allUsernames) {
			
			// 存储该用户的name，totalPoints，orders，pointsRemarks的map
			HashMap<String, Object> singleMap = new HashMap<>();
			// 存储该用户的得分备注的list
			ArrayList<HashMap<String, String>> pointsRemarkList = new ArrayList<>(); 
			
			// 获取该用户的所有订单
			ArrayList<Orders> ordersOfName = new ArrayList<>();
			// 总销量
			int orderCount = 0;
			// 总计分
			int totalPoints = 0;
			
			for (Orders order : allOrders) {
				if (order.getName().equals(name)) {
					ordersOfName.add(order);
					if(!StringUtils.isEmpty(order.getModelId())) {
						orderCount++;
					}
				}
			}
			
			singleMap.put("username", name);
			singleMap.put("orders", ordersOfName);
			
			ArrayList<HashMap<String, String>> modelSalesCountByName = ordersService.getModelSalesCountByName(yyyymm, name);
			ArrayList<HashMap<String, Object>> modelTotalAccAndNotAccByName = ordersService.getModelTotalAccAndNotAccByName(yyyymm, name);
			ArrayList<HashMap<String, String>> modelPayModeCountByName = ordersService.getModelPayModeCountByName(yyyymm, name);
			ArrayList<HashMap<String, Object>> secondPorscheCountByName = ordersService.getSecondPorscheCountByName(yyyymm, name);
			ArrayList<HashMap<String, Object>> secondNotPorscheCountByName = ordersService.getSecondNotPorscheCountByName(yyyymm, name);
			
			int secondPorscheCountByNameNum = 0;   // 二手保时捷收购数量
			if (secondPorscheCountByName.size() > 0 && secondPorscheCountByName.get(0) != null) {
				HashMap<String, Object> hashMap = secondPorscheCountByName.get(0);
				long tmpNum = (Long)hashMap.get("secondHandPorscheCount");
				secondPorscheCountByNameNum = Long.valueOf(tmpNum).intValue();
				
			}
			
			System.out.println("【【【【【secondPorscheCountByNameNum】】】】】" + secondPorscheCountByNameNum);
			
			int secondNotPorscheCountByNameNum = 0;   // 二手非保时捷收购数量
			if (secondNotPorscheCountByName.size() > 0 && secondNotPorscheCountByName.get(0) != null) {
				HashMap<String, Object> hashMap = secondNotPorscheCountByName.get(0);
				long tmpNum = (Long)hashMap.get("secondHandNotPorscheCount");
				secondNotPorscheCountByNameNum = Long.valueOf(tmpNum).intValue();
			}
			
			System.out.println("【【【【【secondNotPorscheCountByNameNum】】】】】" +secondNotPorscheCountByNameNum);
			
			Integer totalAccessoryNum = 0;
			Integer totalNotAccessoryNum = 0;
			
			if (modelTotalAccAndNotAccByName.size() > 0 && modelTotalAccAndNotAccByName.get(0) != null) {
				
				HashMap<String, Object> hashMap = modelTotalAccAndNotAccByName.get(0);
				
				Double totalAccessory = (Double)hashMap.get("totalAccessory");
				Double totalNotAccessory = (Double)hashMap.get("totalNotAccessory");
				totalAccessoryNum = totalAccessory.intValue();	// 搭售总金额
				totalNotAccessoryNum = totalNotAccessory.intValue();	// 非搭售总金额
			}
			
			
			// 匹配车辆销售规则，统计得分
			int carSalesPoint = 0;
			//ordersOfName = null;
			for (Orders orders : ordersOfName ) {
				
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("carTypeRule")&& intesect(rule,orderCount)) {
						System.out.println(orders + "命中车辆销售规则：" + rule.getText() + "，记" + rule.getPoints() + "分");
						
						carSalesPoint += rule.getPoints();
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "命中" + orders.getModel() + "车辆销售规则：【" + rule.getText() + "】");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
						
					}
					
				}
				
			}
			
			// 匹配搭售规则，统计得分
			int aveAccessory = orderCount == 0 ? 0 : (totalAccessoryNum / orderCount);
			int accessoryPoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("AccessoryTypeRule")&& intesect(rule,aveAccessory)) {
						System.out.println(orders + "命中搭售规则：" + rule.getText() + "，记" + rule.getPoints() + "分");
						accessoryPoint += rule.getPoints();
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "命中" + orders.getModel() + "搭售精品规则：【" + rule.getText() + "】");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
						
					}
					
				}			
			}
						
			// 匹配非搭售规则，统计得分
			int notAccessoryPoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("NotAccessoryTypeRule")&& intesect(rule,totalNotAccessoryNum)) {
						
						notAccessoryPoint += rule.getPoints();
						System.out.println(orders + "命中非搭售规则：" + rule.getText() + "，记" + rule.getPoints() + "分");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "命中" + orders.getModel() + "非搭售精品规则：【" + rule.getText() + "】");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
					}
					
				}			
			}
						
			// 匹配付款方式规则，统计得分
			int payModePoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("PayModeTypeRule")&& rule.getCondition1().equals(orders.getPayMode())) {
						
						payModePoint += rule.getPoints();
						System.out.println(orders + "命中付款方式规则：" + rule.getText() + "，记" + rule.getPoints() + "分");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "命中" + orders.getModel() + "付款方式规则：【" + rule.getText() + "】");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
					}
					
				}			
			}

			// 匹配货源规则，统计得分
			int sourcePoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("SourceTypeRule")&& rule.getCondition1().equals(orders.getSource())) {
						
						sourcePoint += rule.getPoints();
						System.out.println(orders + "命中货源规则：" + rule.getText() + "，记" + rule.getPoints() + "分");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "命中" + orders.getModel() + "货源规则：【" + rule.getText() + "】");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
					}
					
				}			
			}
			
			
						
			// 匹配二手车规则，统计得分
			// 如果收购二手车为保时捷，每台都计分，如果非二手保时捷，只计一次
			int secondHandPorschePoint = 0;
			int secondHandNotPorschePoint = 0;
			int secondHandNonePoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("SecondHandTypeRule")) {
						
						secondHandPorschePoint = secondHandPorschePoint + rule.getValue1() * secondPorscheCountByNameNum;
						secondHandNotPorschePoint = secondHandNotPorschePoint + rule.getValue2() * (secondNotPorscheCountByNameNum > 0 ? 1 : 0);
						secondHandNonePoint = secondHandNonePoint + rule.getPoints() * (((secondPorscheCountByNameNum == 0)&&(secondNotPorscheCountByNameNum == 0)) ? 1 : 0);
						System.out.println(orders + "命中二手车规则：" + rule.getText() + "，记" + (rule.getValue1() * secondPorscheCountByNameNum + rule.getValue2() * (secondNotPorscheCountByNameNum > 0 ? 1 : 0) + (((secondPorscheCountByNameNum == 0)&&(secondNotPorscheCountByNameNum == 0)) ? 1 : 0)*rule.getPoints()) + "分");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "命中" + orders.getModel() + "二手车规则：【" + rule.getText() + "】");
						int value = (rule.getValue1() * secondPorscheCountByNameNum) + (rule.getValue2() * (secondNotPorscheCountByNameNum > 0 ? 1 : 0)) + ((((secondPorscheCountByNameNum == 0)&&(secondNotPorscheCountByNameNum == 0)) ? 1 : 0)*rule.getPoints());
						tMap.put("point", String.valueOf(value));
						pointsRemarkList.add(tMap);
					}
					
				}			
			}
			
			singleMap.put("pointsRemark", pointsRemarkList);
			
			// 用户名name 的总分为：
			totalPoints = carSalesPoint + accessoryPoint + notAccessoryPoint + payModePoint + sourcePoint + secondHandPorschePoint + secondHandNotPorschePoint + secondHandNonePoint;
			System.out.println("======================");
			System.out.println("用户" + name + "总分为：" + totalPoints);
			
			singleMap.put("totalPoints", totalPoints);
			
					
					
			// 按分数大小排序，并输出
			/*
			[
				{name:
				 totalPoints:
				 Orders: [
				 			{order...},
				 			{order...},
				 			{order...}
				 		 ]
				 
				 Remarks: [
				 			{text, point},
				 			{text, point},
				 			{text, point}
				 		  ]
				 
				 }
			 
			 
			 
			]
			 */	
			
			// 把singleMap放到reportList按totalPoints从大到小排列的位置
			int count = reportList.size();
			
			if (count == 0) {
				reportList.add(singleMap);
			}else {
				
				for(int i = 0; i <= count; i++){
					
					if(i == count){
						reportList.add(singleMap);
						break;
					}
					
					HashMap<String, Object> hashMap = reportList.get(i);
					Integer pointsOfIndex = (Integer)hashMap.get("totalPoints");
					
					if(totalPoints > pointsOfIndex){
						reportList.add(i, singleMap);
						break;
					}
				}
				
				
			}
			
			
		}
		
		//增加排名
		Integer lastRank = 0;
		Integer lastPoint = 0;
		for (int i = 0; i < reportList.size(); i++) {
			HashMap<String, Object> hashMap = reportList.get(i);
			if(i==0){
				
				hashMap.put("rank", 1);
				lastPoint = (Integer)hashMap.get("totalPoints");
				lastRank = 1;
			}else if ((Integer)hashMap.get("totalPoints")==lastPoint) {
				 
				hashMap.put("rank", lastRank);
					
			}else {
				
				hashMap.put("rank", i+1);
				lastRank = i+1;
				lastPoint = (Integer)hashMap.get("totalPoints");
			}
			
			
		}
				
		return reportList;
	}


}
