package leon.sms.pojo;
/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����12:20:57
* @version 1.0
* ��˵�� :
* 
*/
public class Goods
{
	private String name;
	private int number;
	private float unitPrice;

	public Goods()
	{
		super();
	}
	public Goods(String name, int number, float unitPrice)
	{
		super();
		this.name = name;
		this.number = number;
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString()
	{
		return "Goods [name=" + name + ", number=" + number + ", unitPrice=" + unitPrice + "]";
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public float getUnitPrice()
	{
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice)
	{
		this.unitPrice = unitPrice;
	}
}
