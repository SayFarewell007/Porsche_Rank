package leon.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import leon.sms.mapper.ClientMapper;
import leon.sms.mapper.ProjectMapper;
import leon.sms.pojo.Client;
import leon.sms.pojo.Project;

/** 
* @author Leon
* @date ����ʱ�䣺2018��5��4�� ����10:56:58
* @version 1.0
* ��˵�� :
* 
*/
@Controller
@RequestMapping("")
public class ClientController
{
	@Autowired
	ProjectMapper projectMapper;
	@Autowired
	ClientMapper clientMapper;
	
	@RequestMapping("findProjectByClient")
	public ModelAndView findProjectByClient(@RequestParam("clientName") String clientName)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/others");
		
		List<Project> list = projectMapper.findProjects(clientName);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("addClient")
	public ModelAndView addClient(@RequestParam("ClientName1") String clientName,@RequestParam("ClientPhone") String ClientPhone)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/others");
		
		Client client = new Client(clientName,ClientPhone);
		clientMapper.add(client);
		return mav;
	}
}
