package leon.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import leon.sms.mapper.UserMapper;
import leon.sms.pojo.User;
import leon.sms.service.UserService;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��6�� ����6:59:16
* @version 1.0
* ��˵�� :
* 
*/
@Controller
@RequestMapping("")
public class TestConnection
{
	@Autowired
	UserService userService;
	@Autowired
	UserMapper userMapper;

	@RequestMapping("test")
	public ModelAndView listUser()
	{
		ModelAndView mav = new ModelAndView();
		List<User> list = userMapper.list();
		for(int i=0 ;i<list.size();i++)
		{
			System.out.println(list.get(i).toString());
		}
		
		mav.addObject("cs", list);
		mav.setViewName("user/loginFailure");
		return mav;
	}
}
