package leon.sms.pojo;
/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����12:14:58
* @version 1.0
* ��˵�� :
* 
*/
public class Client
{
	private String name;
	private String phoneNumber;
	public Client()
	{
		super();
	}
	
	public Client(String name, String phoneNumber)
	{
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString()
	{
		return "Client [name=" + name + ", phoneNumber=" + phoneNumber + ", projectsNum="  + "]";
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
