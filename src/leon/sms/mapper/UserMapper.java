package leon.sms.mapper;
/** 
* @author Leon
* @date ����ʱ�䣺2018��4��5�� ����3:46:17
* @version 1.0
* ��˵�� :
* 
*/

import java.util.List;
import leon.sms.pojo.User;

public interface UserMapper
{
	public void add(User user);

	public void delete(String name);

	public User get(String name);

	public void update(User user);

	public List<User> list();

	public int count();
}
