package leon.sms.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import leon.sms.pojo.Car;
import leon.sms.pojo.Goods;

/** 
* @author Leon
* @date 创建时间：2018年4月7日 下午2:04:25
* @version 1.0
* 类说明 :
* 
*/
public interface CarsMapper
{

	public ArrayList<HashMap<String, String>> getCarBrands();

	public ArrayList<Car> getCarTypesByBrand(String id);
	
	public String getCarBrandNameById(String id);
	
	public String getCarTypeNameById(String id);

}
