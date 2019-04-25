package leon.sms.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import leon.sms.mapper.CarsMapper;
import leon.sms.mapper.GoodsMapper;
import leon.sms.pojo.Car;
import leon.sms.pojo.Goods;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:28:31
* @version 1.0
* 类说明 :
* 
*/
@Service
public class CarsService
{
	@Autowired
	CarsMapper carsMapper;
	
	public ArrayList<HashMap<String,String>> getCarBrands()
	{
		ArrayList<HashMap<String, String>> carBrands = carsMapper.getCarBrands();
		if (carBrands != null)
		{
			return carBrands;
		}
		else
		{
			return new ArrayList<>();
		}
	}
	
	public ArrayList<Car> getCarsByBrandId(String id)
	{
		ArrayList<Car> carTypesByBrand = carsMapper.getCarTypesByBrand(id);
		if (carTypesByBrand != null) {
			return carTypesByBrand;
		}else{
			
			return new ArrayList<>();
		}
	}
	
	public String getCarBrandNameById(String id){
		
		String brandName = carsMapper.getCarBrandNameById(id);
		if (!StringUtils.isEmpty(brandName)) {
			
			return brandName;
		}else {
			return id;
		}
	}
	
	
	public String getCarTypeNameById(String id){
		String typeName = carsMapper.getCarTypeNameById(id);
		if (!StringUtils.isEmpty(typeName)) {
			
			return typeName;
		}else {
			return id;
		}
	}
	
}
