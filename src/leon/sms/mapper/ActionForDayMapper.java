package leon.sms.mapper;

import java.sql.Date;
import java.util.List;

import leon.sms.pojo.ActionForDay;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:02:21
* @version 1.0
* ��˵�� :
* 
*/
public interface ActionForDayMapper
{
	public void add(ActionForDay actionForDay);

	public void delete(Date date);

	public ActionForDay get(Date date);

	public void update(ActionForDay actionForDay);

	public List<ActionForDay> list();

	public int count();
}
