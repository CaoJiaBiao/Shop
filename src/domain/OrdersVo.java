package domain;

public class OrdersVo {
	private int id;
	private int userId;
	private int productId;
	private String address;
	private String telNum;
	private String e_Mail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getE_Mail() {
		return e_Mail;
	}
	public void setE_Mail(String mail) {
		e_Mail = mail;
	}
}
