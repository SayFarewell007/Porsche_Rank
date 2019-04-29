package leon.sms.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import leon.sms.pojo.Rules;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:04:25
* @version 1.0
* ��˵�� :
* 
*/
public interface RulesMapper
{
	public void add(Rules rules);

	public void deleteRulesByCarType(String cartype);

	public List<Rules> list();

	public ArrayList<Rules> getRulesByCarType(HashMap<String, String> param);
}
