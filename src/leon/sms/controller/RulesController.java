package leon.sms.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import leon.sms.pojo.Rules;
import leon.sms.service.RulesService;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:24:27
* @version 1.0
* 类说明 :
* 
*/
@Controller
@RequestMapping("")
public class RulesController
{
	@Autowired
	RulesService rulesService;
	
	@RequestMapping(value="updateRules",method={RequestMethod.POST})
	//@ResponseBody
	public String updateRules(
								  @RequestBody ArrayList<Rules> rules
								   )
	{
		String cartype = "";
		
		if(rules.size() > 0){
			Rules tmpRule = rules.get(0);
			cartype = tmpRule.getCartype();
			
			// 删除车型的全部规则
			rulesService.deleteRulesByCarType(cartype);
			
			for (Rules rule : rules) {
				System.out.println(rule);
				rulesService.addRules(rule.getCartype(), rule.getRuletype(), rule.getCondition1(), rule.getValue1(), rule.getCondition2(), rule.getValue2(), rule.getPoints(), rule.getText());
			}
			
			
		}
		
		return "redirect:rulesManage?cartype=" + cartype;
	}
	
	@RequestMapping("ruleRedirect")
	public String ruleRedirect(@RequestParam(value="modelId",required=false) String cartype){
		
		return "redirect:rulesManage?modelId=" + cartype;
		
	}
	
	/*@RequestMapping("getRulesByCarType")
	public ModelAndView getRulesByCarType(@RequestParam(value="cartype",required=false) String cartype
			)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/rulesManage");
		mav.addObject("list", rulesService.getRulesByCarType(cartype));
		return mav;
	}*/
	
	@RequestMapping("getRulesByCarType")
	public @ResponseBody ArrayList<Rules>  getRulesByCarType(@RequestParam(value="cartype",required=false) String cartype
			)
	{
		System.out.println("hello~~~" + cartype);
		ArrayList<Rules> rulesByCarType = rulesService.getRulesByCarType(cartype);
		
		return rulesByCarType;
		//return JSON.toJSONString(rulesByCarType);
	}

}
