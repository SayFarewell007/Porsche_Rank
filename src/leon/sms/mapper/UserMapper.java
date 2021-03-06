package leon.sms.mapper;
/** 
* @author Leon
* @date 创建时间：2018年4月5日 下午3:46:17
* @version 1.0
* 类说明 :
* 
*/

import java.util.ArrayList;
import java.util.List;
import leon.sms.pojo.User;

public interface UserMapper
{
	public void add(User user);

	public void delete(String name);

	public User get(String name);

	public void update(User user);

	public ArrayList<User> list();

	public int count();
	
	
}
