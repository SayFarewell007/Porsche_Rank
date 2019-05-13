package leon.sms.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.transform.Source;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import leon.sms.mapper.CarsMapper;
import leon.sms.mapper.OrdersMapper;
import leon.sms.pojo.Orders;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:28:31
* @version 1.0
* 类说明 :
* 
*/
@Service
public class OrdersService
{
	@Autowired
	OrdersMapper ordersMapper;
	
	@Autowired
	CarsMapper carsMapper;
	
	private static Logger logger = Logger.getLogger(OrdersService.class);
	
	private static ArrayList<HashMap<String, String>> modelSalesCount = null;
	private static ArrayList<HashMap<String, Object>> modelTotalAccAndNotAcc = null;
	private static ArrayList<HashMap<String, String>> modelPayModeCount = null;
	private static ArrayList<HashMap<String, Object>> secondPorscheCount = null;
	private static ArrayList<HashMap<String, Object>> secondNotPorscheCount = null;
	private static String monthOfModelSalesCount = null;
	private static String monthOfModelTotalAccAndNotAcc = null;
	private static String monthOfModelPayModeCount = null;
	private static String monthOfSecondPorscheCount = null;
	private static String monthOfSecondNotPorscheCount = null;
	
	
	public void addOrder(String name , String model , String modelId, String accessory , 
						 String notAccessory , String payMode , String source, String secondHandCarType, String secondHandCarTypeId,
						 String secondHandCarDetail , String secondHandCarDetailId, String tranDate )
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String inputDate = dateFormat.format(new Date());
		String modDate = null;
		
		String carModelName = carsMapper.getCarTypeNameById(modelId);
		String secondHandBrand = carsMapper.getCarBrandNameById(secondHandCarTypeId);
		String secondHandCarTypeName = carsMapper.getCarTypeNameById(secondHandCarDetailId);
		Orders orders = new Orders(name, carModelName, modelId, accessory, notAccessory, payMode, source, secondHandBrand, secondHandCarTypeId, secondHandCarTypeName, secondHandCarDetailId, tranDate, inputDate, modDate);
		
		ordersMapper.add(orders);
		logger.info("新增订单：" + orders.toString());
	}
	
	public void updateOrder(Integer id, String name , String model , String modelId, String accessory , 
			 String notAccessory , String payMode , String source , String secondHandCarType, String secondHandCarTypeId,
			 String secondHandCarDetail , String secondHandCarDetailId, String tranDate )
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String modDate = dateFormat.format(new Date());
		
		String carTypeName = carsMapper.getCarTypeNameById(modelId);
		String secondBrandName = carsMapper.getCarBrandNameById(secondHandCarTypeId);
		String secondCarTypeName = carsMapper.getCarTypeNameById(secondHandCarDetailId);
		//System.out.println("before new order:" + secondCarTypeName);
		Orders orders = new Orders(id, name, carTypeName, modelId, accessory, notAccessory, payMode, source, secondBrandName, secondHandCarTypeId, secondCarTypeName, secondHandCarDetailId, tranDate, tranDate, modDate);
		//System.out.println("update===" + orders);
		ordersMapper.update(orders);
		logger.info("修改订单：" + orders.toString());
	}
	
	public ArrayList<Orders> getAllOrders(String beginDate, String endDate, String name){
		
		HashMap<String, String> param = new HashMap<>();
		if (!StringUtils.isEmpty(beginDate)) {
			param.put("beginDate", beginDate);
		}
		 
		if (!StringUtils.isEmpty(endDate)) {
			param.put("endDate", endDate); 
		}
		
		if (!StringUtils.isEmpty(name)) {
			param.put("name", name); 
		}
		 
		ArrayList<Orders> allOrders = ordersMapper.getAllOrders(param);
		
		if (allOrders != null) {
			
			for (Orders orders : allOrders) {
				String modelId = orders.getModelId();
				String carType = carsMapper.getCarTypeNameById(modelId);
				
				orders.setModel(carType);
				
				String secondHandCarDetailId = orders.getSecondHandCarDetailId();
				String carDetail = carsMapper.getCarTypeNameById(secondHandCarDetailId);
				orders.setSecondHandCarDetail(carDetail);
				
				String secondHandCarTypeId = orders.getSecondHandCarTypeId();
				String carBrand = carsMapper.getCarBrandNameById(secondHandCarTypeId);
				orders.setSecondHandCarType(carBrand);
				
				System.out.println(orders);
			}
			
			return allOrders;
		}else {
			return new ArrayList<Orders>();
		}
		
	}
	
	public void delete(int id) {
		
		ordersMapper.delete(id);
		logger.info("删除订单，id=" + id);
	}
	
	public ArrayList<HashMap<String, String>> getAvailableMonths(){
		
		ArrayList<String> availableMonths = ordersMapper.getAvailableMonths();
		if (null == availableMonths || availableMonths.size() == 0) {
			return new ArrayList<>();
		}else {
			
			ArrayList<HashMap<String, String>> retArrList = new ArrayList<>();
			for (String string : availableMonths) {
				HashMap<String, String> tMap = new HashMap<>();
				tMap.put("id", string); 
				tMap.put("text", string); 
				retArrList.add(tMap);
			}
			return retArrList;
		}

	}
	
	public ArrayList<HashMap<String, String>> getModelSalesCount(String yyyymm){
		
		ArrayList<HashMap<String, String>> modelSalesCount = ordersMapper.getModelSalesCount(yyyymm);
		if (null == modelSalesCount || modelSalesCount.size() == 0) {
			return new ArrayList<>();
		}else {
			return modelSalesCount;
		}
		
	}
	
	public ArrayList<HashMap<String, String>> getModelSalesCountByName(String yyyymm, String name){
		//if (modelSalesCount == null || (!yyyymm.equals(monthOfModelSalesCount))) {
			modelSalesCount = getModelSalesCount(yyyymm);
		//	monthOfModelSalesCount = yyyymm;
		//}
		
		ArrayList<HashMap<String, String>> tmpArrayList = new ArrayList<>();
		for (HashMap<String, String> hashMap : modelSalesCount) {
			if (name.equals(hashMap.get("name"))) {
				tmpArrayList.add(hashMap);
			}
		}
			
		return tmpArrayList;
		
	}
	
	
	
	public ArrayList<HashMap<String, Object>> getModelTotalAccAndNotAcc(String yyyymm) {
		
		ArrayList<HashMap<String, Object>> modelTotalAccAndNotAcc = ordersMapper.getModelTotalAccAndNotAcc(yyyymm);
		if (null == modelTotalAccAndNotAcc || modelTotalAccAndNotAcc.size() == 0) {
			return new ArrayList<>();
		}else {
			return modelTotalAccAndNotAcc;
		}
	}
	
	public ArrayList<HashMap<String, Object>> getModelTotalAccAndNotAccByName(String yyyymm, String name) {
		//if (modelTotalAccAndNotAcc == null || (!yyyymm.equals(monthOfModelTotalAccAndNotAcc))) {
			
			modelTotalAccAndNotAcc = getModelTotalAccAndNotAcc(yyyymm);
		//	monthOfModelTotalAccAndNotAcc = yyyymm;
		//}
		
		ArrayList<HashMap<String, Object>> tmpArrayList = new ArrayList<>();
		for (HashMap<String, Object> hashMap : modelTotalAccAndNotAcc) {
			if (name.equals(hashMap.get("name"))) {
				tmpArrayList.add(hashMap);
			}
			
		}
		
		return tmpArrayList;
	}
	
	public ArrayList<HashMap<String, String>> getModelPayModeCount(String yyyymm) {
		ArrayList<HashMap<String, String>> modelPayModeCount = ordersMapper.getModelPayModeCount(yyyymm);
		if (null == modelPayModeCount || modelPayModeCount.size() == 0) {
			return new ArrayList<>();
		}else {
			return modelPayModeCount;
		}
	}
	
	public ArrayList<HashMap<String, String>> getModelPayModeCountByName(String yyyymm, String name){
		
		//if (modelPayModeCount == null || (!yyyymm.equals(monthOfModelPayModeCount))) {
			modelPayModeCount = getModelPayModeCount(yyyymm);
		//	monthOfModelPayModeCount = yyyymm;
		//}
		
		ArrayList<HashMap<String, String>> tmpArrayList = new ArrayList<>();
		for (HashMap<String, String> hashMap : modelPayModeCount) {
			if (name.equals(hashMap.get("name"))) {
				tmpArrayList.add(hashMap);
				
			}
		}
		
		return tmpArrayList;
		
	}
	
	
	public ArrayList<HashMap<String, Object>> getSecondPorscheCount(String yyyymm) {
		ArrayList<HashMap<String,Object>> secondPorscheCount = ordersMapper.getSecondPorscheCount(yyyymm);
		if (null == secondPorscheCount || secondPorscheCount.size() == 0) {
			return new ArrayList<>();
		}else {
			return secondPorscheCount;
		}
		
	}
	
	public ArrayList<HashMap<String, Object>> getSecondPorscheCountByName(String yyyymm, String name){
		//if (secondPorscheCount == null || (!yyyymm.equals(monthOfSecondPorscheCount))) {
			secondPorscheCount = getSecondPorscheCount(yyyymm);
		//	monthOfSecondPorscheCount = yyyymm;
		//}
		
		ArrayList<HashMap<String, Object>> tmpArrayList = new ArrayList<>();
		for (HashMap<String, Object> hashMap : secondPorscheCount) {
			if (name.equals(hashMap.get("name"))) {
				tmpArrayList.add(hashMap);
			}
		}
		
		return tmpArrayList;
		
		
	}
	
	
	public ArrayList<HashMap<String, Object>> getSecondNotPorscheCount(String yyyymm) {
		ArrayList<HashMap<String, Object>> secondNotPorscheCount = ordersMapper.getSecondNotPorscheCount(yyyymm);
		if (null == secondNotPorscheCount || secondNotPorscheCount.size() == 0) {
			return new ArrayList<>();
		}else {
			return secondNotPorscheCount;
		}
		
	}
	
	public ArrayList<HashMap<String, Object>> getSecondNotPorscheCountByName(String yyyymm, String name) {
		
		//if (secondNotPorscheCount == null || (!yyyymm.equals(monthOfSecondNotPorscheCount))) {
			secondNotPorscheCount = getSecondNotPorscheCount(yyyymm);
		//	monthOfSecondNotPorscheCount = yyyymm;
		//}
		
		ArrayList<HashMap<String, Object>> tmpArrayList = new ArrayList<>();
		for (HashMap<String, Object> hashMap : secondNotPorscheCount) {
			if (name.equals(hashMap.get("name"))) {
				tmpArrayList.add(hashMap);
			}
		}
		
		return tmpArrayList;
	}
	
	
}
