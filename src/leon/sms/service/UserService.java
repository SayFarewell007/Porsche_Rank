package leon.sms.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
/** 
* @author Leon
* @date ����ʱ�䣺2018��4��5�� ����3:54:51
* @version 1.0
* ��˵�� :
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
			logger.info("�����û�" + user.toString());
			return true;
		}
		return false;
	}

	public ArrayList<User> list(){
		
		System.out.println("����userservice ��list()");
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
			// ����һ��MD5���ܼ���ժҪ
			MessageDigest md = MessageDigest.getInstance("MD5");
			// ����md5����
			md.update(str.getBytes());
			// digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
			// BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
			return new BigInteger(1, md.digest()).toString(16);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
