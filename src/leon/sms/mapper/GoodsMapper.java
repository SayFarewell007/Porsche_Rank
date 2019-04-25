package leon.sms.mapper;

import java.util.ArrayList;
import java.util.List;
import leon.sms.pojo.Goods;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:04:25
* @version 1.0
* ��˵�� :
* 
*/
public interface GoodsMapper
{
	public void add(Goods goods);

	public void delete(String name);

	public Goods get(String name);

	public void updateNum(Goods goods);
	
	public void update(Goods goods);

	public ArrayList<Goods> list();

	public int count();
}
