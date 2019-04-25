package leon.sms.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import leon.sms.pojo.Goods;
import leon.sms.pojo.Orders;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:04:25
* @version 1.0
* ��˵�� :
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
	
	public ArrayList<Orders> getAllOrders(HashMap<String, String> param);
}
