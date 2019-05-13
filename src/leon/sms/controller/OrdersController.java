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
* @date ����ʱ�䣺2018��5��4�� ����10:24:27
* @version 1.0
* ��˵�� :
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
		logger.info("������id=" + id + "�Ķ���");
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
		
		// ��ȡ���е�rules��allRules
		ArrayList<Rules> allRules = new ArrayList<>();
		ArrayList<Car> carsModelIds = carsService.getCarsByBrandId("189");  // 189-��ʱ��
		for (Car car : carsModelIds) {
			System.out.println(car);
			ArrayList<Rules> rulesByCarType = rulesService.getRulesByCarType(car.getId());
			if(rulesByCarType.size() > 0){
				allRules.addAll(rulesByCarType);
			}
		}
		
		// ��ȡ�����û�name��allUsernames
		ArrayList<String> allUsernames = new ArrayList<>();
		
		
		//logger.info("testetstetstetstes");
		
		ArrayList<User> userList = userService.list();
		if (null != userList && userList.size() > 0) {
			for (User user : userList) {
				//System.out.println(user);
				allUsernames.add(user.getName());
				
			}
		}
		
		// ��ȡ�������ж�����allOrders
		String beginDate = yyyymm + "-01";
		String endDate = yyyymm + "-31";
		ArrayList<Orders> allOrders = ordersService.getAllOrders(beginDate, endDate, null);
		
		// �洢�����˵��¶������ͻ��ֵ�List
		ArrayList<HashMap<String, Object>> reportList = new ArrayList<>();
		
		// ���������û���ÿ���û����Ҷ�Ӧ�����ж������Զ���������ͳ�ƣ���������ÿ���ͺ��������ܴ��۾�Ʒ���������۾�Ʒ���ܴ��۾�Ʒ���/����������
		// �ܷǴ��۾�Ʒ��ÿ���ͺŵĸ��ʽ����ʱ�ݶ��ֳ��������Ǳ�ʱ�ݶ��ֳ�����
		for (String name : allUsernames) {
			
			// �洢���û���name��totalPoints��orders��pointsRemarks��map
			HashMap<String, Object> singleMap = new HashMap<>();
			// �洢���û��ĵ÷ֱ�ע��list
			ArrayList<HashMap<String, String>> pointsRemarkList = new ArrayList<>(); 
			
			// ��ȡ���û������ж���
			ArrayList<Orders> ordersOfName = new ArrayList<>();
			// ������
			int orderCount = 0;
			// �ܼƷ�
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
			
			int secondPorscheCountByNameNum = 0;   // ���ֱ�ʱ���չ�����
			if (secondPorscheCountByName.size() > 0 && secondPorscheCountByName.get(0) != null) {
				HashMap<String, Object> hashMap = secondPorscheCountByName.get(0);
				long tmpNum = (Long)hashMap.get("secondHandPorscheCount");
				secondPorscheCountByNameNum = Long.valueOf(tmpNum).intValue();
				
			}
			
			System.out.println("����������secondPorscheCountByNameNum����������" + secondPorscheCountByNameNum);
			
			int secondNotPorscheCountByNameNum = 0;   // ���ַǱ�ʱ���չ�����
			if (secondNotPorscheCountByName.size() > 0 && secondNotPorscheCountByName.get(0) != null) {
				HashMap<String, Object> hashMap = secondNotPorscheCountByName.get(0);
				long tmpNum = (Long)hashMap.get("secondHandNotPorscheCount");
				secondNotPorscheCountByNameNum = Long.valueOf(tmpNum).intValue();
			}
			
			System.out.println("����������secondNotPorscheCountByNameNum����������" +secondNotPorscheCountByNameNum);
			
			Integer totalAccessoryNum = 0;
			Integer totalNotAccessoryNum = 0;
			
			if (modelTotalAccAndNotAccByName.size() > 0 && modelTotalAccAndNotAccByName.get(0) != null) {
				
				HashMap<String, Object> hashMap = modelTotalAccAndNotAccByName.get(0);
				
				Double totalAccessory = (Double)hashMap.get("totalAccessory");
				Double totalNotAccessory = (Double)hashMap.get("totalNotAccessory");
				totalAccessoryNum = totalAccessory.intValue();	// �����ܽ��
				totalNotAccessoryNum = totalNotAccessory.intValue();	// �Ǵ����ܽ��
			}
			
			
			// ƥ�䳵�����۹���ͳ�Ƶ÷�
			int carSalesPoint = 0;
			//ordersOfName = null;
			for (Orders orders : ordersOfName ) {
				
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("carTypeRule")&& intesect(rule,orderCount)) {
						System.out.println(orders + "���г������۹���" + rule.getText() + "����" + rule.getPoints() + "��");
						
						carSalesPoint += rule.getPoints();
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "����" + orders.getModel() + "�������۹��򣺡�" + rule.getText() + "��");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
						
					}
					
				}
				
			}
			
			// ƥ����۹���ͳ�Ƶ÷�
			int aveAccessory = orderCount == 0 ? 0 : (totalAccessoryNum / orderCount);
			int accessoryPoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("AccessoryTypeRule")&& intesect(rule,aveAccessory)) {
						System.out.println(orders + "���д��۹���" + rule.getText() + "����" + rule.getPoints() + "��");
						accessoryPoint += rule.getPoints();
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "����" + orders.getModel() + "���۾�Ʒ���򣺡�" + rule.getText() + "��");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
						
					}
					
				}			
			}
						
			// ƥ��Ǵ��۹���ͳ�Ƶ÷�
			int notAccessoryPoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("NotAccessoryTypeRule")&& intesect(rule,totalNotAccessoryNum)) {
						
						notAccessoryPoint += rule.getPoints();
						System.out.println(orders + "���зǴ��۹���" + rule.getText() + "����" + rule.getPoints() + "��");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "����" + orders.getModel() + "�Ǵ��۾�Ʒ���򣺡�" + rule.getText() + "��");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
					}
					
				}			
			}
						
			// ƥ�丶�ʽ����ͳ�Ƶ÷�
			int payModePoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("PayModeTypeRule")&& rule.getCondition1().equals(orders.getPayMode())) {
						
						payModePoint += rule.getPoints();
						System.out.println(orders + "���и��ʽ����" + rule.getText() + "����" + rule.getPoints() + "��");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "����" + orders.getModel() + "���ʽ���򣺡�" + rule.getText() + "��");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
					}
					
				}			
			}

			// ƥ���Դ����ͳ�Ƶ÷�
			int sourcePoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("SourceTypeRule")&& rule.getCondition1().equals(orders.getSource())) {
						
						sourcePoint += rule.getPoints();
						System.out.println(orders + "���л�Դ����" + rule.getText() + "����" + rule.getPoints() + "��");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "����" + orders.getModel() + "��Դ���򣺡�" + rule.getText() + "��");
						tMap.put("point", Integer.valueOf(rule.getPoints()).toString());
						pointsRemarkList.add(tMap);
					}
					
				}			
			}
			
			
						
			// ƥ����ֳ�����ͳ�Ƶ÷�
			// ����չ����ֳ�Ϊ��ʱ�ݣ�ÿ̨���Ʒ֣�����Ƕ��ֱ�ʱ�ݣ�ֻ��һ��
			int secondHandPorschePoint = 0;
			int secondHandNotPorschePoint = 0;
			int secondHandNonePoint = 0;
			for (Orders orders : ordersOfName ) {
				for (Rules rule  : allRules) {
					if (rule.getCartype().equals(orders.getModelId()) && rule.getRuletype().equals("SecondHandTypeRule")) {
						
						secondHandPorschePoint = secondHandPorschePoint + rule.getValue1() * secondPorscheCountByNameNum;
						secondHandNotPorschePoint = secondHandNotPorschePoint + rule.getValue2() * (secondNotPorscheCountByNameNum > 0 ? 1 : 0);
						secondHandNonePoint = secondHandNonePoint + rule.getPoints() * (((secondPorscheCountByNameNum == 0)&&(secondNotPorscheCountByNameNum == 0)) ? 1 : 0);
						System.out.println(orders + "���ж��ֳ�����" + rule.getText() + "����" + (rule.getValue1() * secondPorscheCountByNameNum + rule.getValue2() * (secondNotPorscheCountByNameNum > 0 ? 1 : 0) + (((secondPorscheCountByNameNum == 0)&&(secondNotPorscheCountByNameNum == 0)) ? 1 : 0)*rule.getPoints()) + "��");
						
						HashMap<String, String> tMap = new HashMap<>();
						tMap.put("text", "����" + orders.getModel() + "���ֳ����򣺡�" + rule.getText() + "��");
						int value = (rule.getValue1() * secondPorscheCountByNameNum) + (rule.getValue2() * (secondNotPorscheCountByNameNum > 0 ? 1 : 0)) + ((((secondPorscheCountByNameNum == 0)&&(secondNotPorscheCountByNameNum == 0)) ? 1 : 0)*rule.getPoints());
						tMap.put("point", String.valueOf(value));
						pointsRemarkList.add(tMap);
					}
					
				}			
			}
			
			singleMap.put("pointsRemark", pointsRemarkList);
			
			// �û���name ���ܷ�Ϊ��
			totalPoints = carSalesPoint + accessoryPoint + notAccessoryPoint + payModePoint + sourcePoint + secondHandPorschePoint + secondHandNotPorschePoint + secondHandNonePoint;
			System.out.println("======================");
			System.out.println("�û�" + name + "�ܷ�Ϊ��" + totalPoints);
			
			singleMap.put("totalPoints", totalPoints);
			
					
					
			// ��������С���򣬲����
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
			
			// ��singleMap�ŵ�reportList��totalPoints�Ӵ�С���е�λ��
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
		
		//��������
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
