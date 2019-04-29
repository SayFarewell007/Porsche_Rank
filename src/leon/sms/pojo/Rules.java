package leon.sms.pojo;


public class Rules {
	
	private int id;
	private String cartype;
	private String ruletype;
	private String condition1;
	private int value1;
	private String condition2;
	private int value2;
	private int points;
	private String text;
	
	public Rules() {
		super();
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getRuletype() {
		return ruletype;
	}
	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}
	public String getCondition1() {
		return condition1;
	}
	public void setCondition1(String condition1) {
		this.condition1 = condition1;
	}
	public int getValue1() {
		return value1;
	}
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	public String getCondition2() {
		return condition2;
	}
	public void setCondition2(String condition2) {
		this.condition2 = condition2;
	}
	public int getValue2() {
		return value2;
	}
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Rules [id=" + id + ", cartype=" + cartype + ", ruletype="
				+ ruletype + ", condition1=" + condition1 + ", value1=" + value1
				+ ", condition2=" + condition2 + ", value2=" + value2
				+ ", points=" + points + ", text=" + text + "]";
	}
	
	
}
