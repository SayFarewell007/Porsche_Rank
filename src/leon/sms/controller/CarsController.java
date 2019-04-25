package leon.sms.controller;


import java.util.ArrayList;
import java.util.HashMap;

import javax.el.ArrayELResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;

import leon.sms.pojo.Car;
import leon.sms.pojo.Goods;
import leon.sms.service.CarsService;
import leon.sms.service.GoodsService;
import sun.security.action.GetBooleanAction;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:24:27
* @version 1.0
* 类说明 :
* 
*/
@Controller
@RequestMapping("")
public class CarsController
{
	@Autowired
	CarsService carsService;
	
	@RequestMapping("getCarsBrands")
	public @ResponseBody ArrayList<HashMap<String, String>> getCarsBrands()
	{
		ArrayList<HashMap<String, String>> carBrands = carsService.getCarBrands();
		
		if (carBrands != null) {
			return carBrands;
		}else{
			
			return new ArrayList<>();
		}

	}
	
	@RequestMapping("getCarsByBrandId")
	public @ResponseBody ArrayList<HashMap<String, String>> GetCarsByBrandId(@RequestParam("brand_id") String id){
		
		ArrayList<HashMap<String, String>> retList = new ArrayList<>();
		ArrayList<Car> carsByBrandId = carsService.getCarsByBrandId(id);
		if (carsByBrandId != null) {
			 for (Car car : carsByBrandId) {
				HashMap<String,String> tmpMap = new HashMap<>();
				tmpMap.put("id", car.getId());
				tmpMap.put("text", car.getName());
				retList.add(tmpMap);
			}
			 
			 return retList;
		}else{
			return new ArrayList<>();
			
		}
		
		
	}
	
	@RequestMapping(value="getCarBrandNameByBrandId", produces="application/json;charset=utf-8")
	public @ResponseBody String getCarBrandNameById(@RequestParam("id") String id ){
		String carBrandName = carsService.getCarBrandNameById(id);
		return carBrandName;
		
		
	}
	
	@RequestMapping(value="getCarTypeNameById", produces="application/json;charset=utf-8")
	public @ResponseBody String getCarTypeNameById(@RequestParam("id") String id){
		
		String carTypeName = carsService.getCarTypeNameById(id);
		return carTypeName;
	}
	
}
