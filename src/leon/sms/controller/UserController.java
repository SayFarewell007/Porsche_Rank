package leon.sms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import leon.sms.pojo.User;
import leon.sms.service.UserService;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��6�� ����12:45:38
* @version 1.0
* ��˵�� :
* 
*/
@Controller
@RequestMapping("")
public class UserController
{
	@Autowired
	UserService userService;
	
	@RequestMapping("login")
	public ModelAndView loginUser(@RequestParam("name")String name,  
            @RequestParam("password")String password, HttpSession httpSession)
	{
		//System.out.println(name + " "+ password);
		
		User user= new User(name,userService.getMD5(password));
		
		ModelAndView mav = new ModelAndView();
		if(userService.search(user)!=null)
		{
			//�����ݴ洢��session��
			httpSession.setAttribute("user",userService.search(user));
			
			System.out.println(userService.search(user).toString());
			mav.setViewName("home/fmain");
			return mav;
		}
		
		mav.setViewName("user/loginFailure");
		return mav;
	}
	
	@RequestMapping("registe")
	public ModelAndView registeUser(@RequestParam("name")String name,  
            @RequestParam("password")String passWord,@RequestParam("identity")String identity)
	{
		boolean isAdmin = false;
		if("manager".equals(identity))
		{
			isAdmin=true;
		}
		User user= new User(name,passWord,isAdmin);
		ModelAndView mav = new ModelAndView();
		
		if(userService.addUser(user))
		{
			System.out.println("ע��ɹ�");
			mav.setViewName("user/registeSuccess");
		}
		else
		{
			System.out.println("ע��ʧ��");
			mav.setViewName("user/registeFailure");
		}
		
		return mav;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession httpSession,HttpServletResponse response, HttpServletRequest request) 
			throws ServletException, IOException
	{
		System.out.println("����ע������");
		
		httpSession.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/logout");
		return mav;
	}
}
