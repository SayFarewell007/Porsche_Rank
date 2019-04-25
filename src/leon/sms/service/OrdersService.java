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
	
	public void addOrder(String name , String model , String modelId, String accessory , 
						 String notAccessory , String payMode , String secondHandCarType, String secondHandCarTypeId,
						 String secondHandCarDetail , String secondHandCarDetailId, String tranDate )
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String inputDate = dateFormat.format(new Date());
		String modDate = null;
		Orders orders = new Orders(name, model, modelId, accessory, notAccessory, payMode, secondHandCarType, secondHandCarTypeId, secondHandCarDetail, secondHandCarDetailId, tranDate, inputDate, modDate);
		
		ordersMapper.add(orders);
		
	}
	
	public void updateOrder(Integer id, String name , String model , String modelId, String accessory , 
			 String notAccessory , String payMode , String secondHandCarType, String secondHandCarTypeId,
			 String secondHandCarDetail , String secondHandCarDetailId, String tranDate )
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String modDate = dateFormat.format(new Date());
		Orders orders = new Orders(id, name, model, modelId, accessory, notAccessory, payMode, secondHandCarType, secondHandCarTypeId, secondHandCarDetail, secondHandCarDetailId, tranDate, tranDate, modDate);
		
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
