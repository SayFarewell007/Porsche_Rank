package leon.sms.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.ws.api.message.StreamingSOAP;

import leon.sms.mapper.CarsMapper;
import leon.sms.mapper.OrdersMapper;
import leon.sms.pojo.Orders;

/** 
* @author Leon
* @date ����ʱ�䣺2018��5��4�� ����10:28:31
* @version 1.0
* ��˵�� :
* 
*/
@Service
public class OrdersService
{
	@Autowired
	OrdersMapper ordersMapper;
	
	@Autowired
	CarsMapper carsMapper;
	
	public void addOrder(String name , String model , String modelId, String accessory , 
						 String notAccessory , String payMode , String secondHandCarType, String secondHandCarTypeId,
						 String secondHandCarDetail , String secondHandCarDetailId, String tranDate )
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String inputDate = dateFormat.format(new Date());
		String modDate = null;
		
		String carModelName = carsMapper.getCarTypeNameById(modelId);
		String secondHandBrand = carsMapper.getCarBrandNameById(secondHandCarTypeId);
		String secondHandCarTypeName = carsMapper.getCarTypeNameById(secondHandCarDetailId);
		Orders orders = new Orders(name, carModelName, modelId, accessory, notAccessory, payMode, secondHandBrand, secondHandCarTypeId, secondHandCarTypeName, secondHandCarDetailId, tranDate, inputDate, modDate);
		
		ordersMapper.add(orders);
		
	}
	
	public void updateOrder(Integer id, String name , String model , String modelId, String accessory , 
			 String notAccessory , String payMode , String secondHandCarType, String secondHandCarTypeId,
			 String secondHandCarDetail , String secondHandCarDetailId, String tranDate )
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String modDate = dateFormat.format(new Date());
		
		String carTypeName = carsMapper.getCarTypeNameById(modelId);
		String secondBrandName = carsMapper.getCarBrandNameById(secondHandCarTypeId);
		String secondCarTypeName = carsMapper.getCarTypeNameById(secondHandCarDetailId);
		System.out.println("before new order:" + secondCarTypeName);
		Orders orders = new Orders(id, name, carTypeName, modelId, accessory, notAccessory, payMode, secondBrandName, secondHandCarTypeId, secondCarTypeName, secondHandCarDetailId, tranDate, tranDate, modDate);
		System.out.println("update===" + orders);
		ordersMapper.update(orders);
		
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
		
	}
	
}
