package leon.sms.pojo;


public class Orders {
	
	private int id;
	private String name;
	private String model;
	private String modelId;
	private Float accessory;
	private Float notAccessory;
	private String payMode;
	private String secondHandCarType;
	private String secondHandCarTypeId;
	private String secondHandCarDetail;
	private String secondHandCarDetailId;
	private String tranDate;
	private String inputDate;
	private String modDate;	

	
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", name=" + name + ", model=" + model
				+ ", modelId=" + modelId + ", accessory=" + accessory
				+ ", notAccessory=" + notAccessory + ", payMode=" + payMode
				+ ", secondHandCarType=" + secondHandCarType
				+ ", secondHandCarTypeId=" + secondHandCarTypeId
				+ ", secondHandCarDetail=" + secondHandCarDetail
				+ ", secondHandCarDetailId=" + secondHandCarDetailId
				+ ", tranDate=" + tranDate + ", inputDate=" + inputDate
				+ ", modDate=" + modDate + "]";
	}




	public Orders() {
		super();
	}
	
	


	public Orders(String name, String model, String modelId,
			String accessory, String notAccessory, String payMode,
			String secondHandCarType, String secondHandCarTypeId,
			String secondHandCarDetail, String secondHandCarDetailId,
			String tranDate, String inputDate, String modDate) {
		super();

		this.name = name;
		this.model = model;
		this.modelId = modelId;
		this.accessory = Float.valueOf(accessory);
		this.notAccessory = Float.valueOf(notAccessory);
		this.payMode = payMode;
		this.secondHandCarType = secondHandCarType;
		this.secondHandCarTypeId = secondHandCarTypeId;
		this.secondHandCarDetail = secondHandCarDetail;
		this.secondHandCarDetailId = secondHandCarDetailId;
		this.tranDate = tranDate;
		this.inputDate = inputDate;
		this.modDate = modDate;
	}
	
	public Orders(Integer id, String name, String model, String modelId,
			String accessory, String notAccessory, String payMode,
			String secondHandCarType, String secondHandCarTypeId,
			String secondHandCarDetail, String secondHandCarDetailId,
			String tranDate, String inputDate, String modDate) {
		super();

		this.id = id;
		this.name = name;
		this.model = model;
		this.modelId = modelId;
		this.accessory = Float.valueOf(accessory);
		this.notAccessory = Float.valueOf(notAccessory);
		this.payMode = payMode;
		this.secondHandCarType = secondHandCarType;
		this.secondHandCarTypeId = secondHandCarTypeId;
		this.secondHandCarDetail = secondHandCarDetail;
		this.secondHandCarDetailId = secondHandCarDetailId;
		this.tranDate = tranDate;
		this.inputDate = inputDate;
		this.modDate = modDate;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getModelId() {
		return modelId;
	}


	public void setModelId(String modelId) {
		this.modelId = modelId;
	}


	public Float getAccessory() {
		return accessory;
	}


	public void setAccessory(Float accessory) {
		this.accessory = accessory;
	}


	public Float getNotAccessory() {
		return notAccessory;
	}


	public void setNotAccessory(Float notAccessory) {
		this.notAccessory = notAccessory;
	}


	public String getPayMode() {
		return payMode;
	}


	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}


	public String getSecondHandCarType() {
		return secondHandCarType;
	}


	public void setSecondHandCarType(String secondHandCarType) {
		this.secondHandCarType = secondHandCarType;
	}


	public String getSecondHandCarTypeId() {
		return secondHandCarTypeId;
	}


	public void setSecondHandCarTypeId(String secondHandCarTypeId) {
		this.secondHandCarTypeId = secondHandCarTypeId;
	}


	public String getSecondHandCarDetail() {
		return secondHandCarDetail;
	}


	public void setSecondHandCarDetail(String secondHandCarDetail) {
		this.secondHandCarDetail = secondHandCarDetail;
	}


	public String getSecondHandCarDetailId() {
		return secondHandCarDetailId;
	}


	public void setSecondHandCarDetailId(String secondHandCarDetailId) {
		this.secondHandCarDetailId = secondHandCarDetailId;
	}


	public String getTranDate() {
		return tranDate;
	}


	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}


	public String getInputDate() {
		return inputDate;
	}


	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}


	public String getModDate() {
		return modDate;
	}


	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	

}
