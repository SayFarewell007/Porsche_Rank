package leon.sms.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.xml.internal.ws.resources.StreamingMessages;

import leon.sms.pojo.Goods;
import leon.sms.pojo.Orders;

/** 
* @author Leon
* @date 创建时间：2018年4月7日 下午2:04:25
* @version 1.0
* 类说明 :
* 
*/
public interface OrdersMapper
{
	public void add(Orders orders);

	public void delete(int id);

	public Orders get(int id);

	public void update(Orders orders);

	public List<Orders> list();

	public int count();
	
	public ArrayList<String> getAvailableMonths();
	
	public ArrayList<Orders> getAllOrders(HashMap<String, String> param);
	
	public ArrayList<HashMap<String, String>> getSummaryReport(String yyyymm);
	
	public ArrayList<HashMap<String, String>> getModelSalesCount(String yyyymm);
	public ArrayList<HashMap<String, Object>> getModelTotalAccAndNotAcc(String yyyymm);
	public ArrayList<HashMap<String, String>> getModelPayModeCount(String yyyymm);
	public ArrayList<HashMap<String, Object>> getSecondPorscheCount(String yyyymm);
	public ArrayList<HashMap<String, Object>> getSecondNotPorscheCount(String yyyymm);
}
