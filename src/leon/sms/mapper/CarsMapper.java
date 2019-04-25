package leon.sms.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import leon.sms.pojo.Car;
import leon.sms.pojo.Goods;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:04:25
* @version 1.0
* ��˵�� :
* 
*/
public interface CarsMapper
{

	public ArrayList<HashMap<String, String>> getCarBrands();

	public ArrayList<Car> getCarTypesByBrand(String id);
	
	public String getCarBrandNameById(String id);
	
	public String getCarTypeNameById(String id);

}
