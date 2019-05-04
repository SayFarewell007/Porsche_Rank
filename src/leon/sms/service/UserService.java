package leon.sms.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
/** 
* @author Leon
* @date 创建时间：2018年4月5日 下午3:54:51
* @version 1.0
* 类说明 :
* 
*/
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xerces.internal.util.NamespaceContextWrapper;

import leon.sms.mapper.UserMapper;
import leon.sms.pojo.User;

@Service
public class UserService
{
	@Autowired
	UserMapper userMapper;
	
	private static Logger logger = Logger.getLogger(UserService.class);
	
	public User search(User user)
	{
		List<User> list = userMapper.list();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).equals(user))
			{
				user = userMapper.get(user.getName());
				return user;
			}
		}
		return null;
	}

	public boolean addUser(User user)
	{
		if (userMapper.get(user.getName()) == null)
		{
			//System.out.println("hello");
			userMapper.add(user);
			logger.info("新增用户" + user.toString());
			return true;
		}
		return false;
	}

	public ArrayList<User> list(){
		
		System.out.println("调用userservice 的list()");
		ArrayList<User> list = userMapper.list();
		if (list.size() > 0 ) {
			return list;
		}else {
			return new ArrayList<>();
		}
	}
	public String getMD5(String str)
	{
		try
		{
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
