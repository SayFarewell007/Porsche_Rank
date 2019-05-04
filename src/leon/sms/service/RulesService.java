package leon.sms.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leon.sms.mapper.RulesMapper;
import leon.sms.pojo.Rules;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:28:31
* @version 1.0
* 类说明 :
* 
*/
@Service
public class RulesService
{
	@Autowired
	RulesMapper rulesMapper;
	
	private static Logger logger = Logger.getLogger(RulesService.class);
	
	public void addRules(String cartype , String ruletype , String condition1, int value1 , 
						 String condition2 , int value2 , int points, String text)
	{
		
		Rules rules = new Rules();
		rules.setCartype(cartype);
		rules.setRuletype(ruletype);
		rules.setCondition1(condition1);
		rules.setValue1(value1);
		rules.setCondition2(condition2);
		rules.setValue2(value2);;
		rules.setPoints(points);
		rules.setText(text);
		
		rulesMapper.add(rules);
		logger.info("新增规则");
	}
	
	public void deleteRulesByCarType(String cartype)
	{
		rulesMapper.deleteRulesByCarType(cartype);
		logger.info("删除规则，cartytpe=" + cartype);
	}
	
	
	
	public ArrayList<Rules> getRulesByCarType(String cartype){
		
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("cartype", cartype);
		ArrayList<Rules> rulesByCarType = rulesMapper.getRulesByCarType(hashMap);
		
		if (rulesByCarType != null) {
			
			return rulesByCarType;
		}else {
			return new ArrayList<Rules>();
		}
		
	}
	
		
}
