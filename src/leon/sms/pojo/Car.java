package leon.sms.pojo;
/** 
* @author Leon
* @date 创建时间：2018年4月7日 下午12:20:57
* @version 1.0
* 类说明 :
* 
*/
public class Car
{
	private String id;
	private String initials;
	private String name;
	private String type;
	

	public Car()
	{
		super();
	}


	public Car(String id, String initials, String name, String type) {
		super();
		this.id = id;
		this.initials = initials;
		this.name = name;
		this.type = type;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getInitials() {
		return initials;
	}


	public void setInitials(String initials) {
		this.initials = initials;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", initials=" + initials + ", name=" + name
				+ ", type=" + type + "]";
	}

	
	

}
