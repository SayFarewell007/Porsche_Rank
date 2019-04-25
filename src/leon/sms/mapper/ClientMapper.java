package leon.sms.mapper;

import java.util.List;
import leon.sms.pojo.Client;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:03:22
* @version 1.0
* ��˵�� :
* 
*/
public interface ClientMapper
{
	public void add(Client client);

	public void delete(String name);

	public Client get(String name);

	public void update(String name);

	public List<Client> list();

	public int count();
}
