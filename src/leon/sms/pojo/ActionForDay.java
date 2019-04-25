package leon.sms.pojo;

import java.sql.Date;
/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����12:39:49
* @version 1.0
* ��˵�� :
* 
*/
public class ActionForDay
{
	private Date saleDate;
	private int number;
	public ActionForDay()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public ActionForDay(Date saleDate, int number)
	{
		super();
		this.saleDate = saleDate;
		this.number = number;
	}
	public ActionForDay(Date saleDate)
	{
		super();
		this.saleDate = saleDate;
	}
	
	@Override
	public String toString()
	{
		return "actionForDay [saleDate=" + saleDate + ", number=" + number + "]";
	}
	public Date getSaleDate()
	{
		return saleDate;
	}
	public void setSaleDate(Date saleDate)
	{
		this.saleDate = saleDate;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
}
