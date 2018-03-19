package action;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import domain.UserVo;
public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String psw1;
	private String psw2;
	private int age;
	private String sex;
	private String telNum;
	private String email;
	private UserService userService;

/*	public void validate() {
		if(getUserName() == null || getUserName().length() == 0) {
			this.addFieldError("error1", getText("username.required"));
		}
		if(getUserName().length() >20 ) {
			this.addFieldError("error2", getText("psw.maxlength"));
		}
		if(getPsw1() == null || getPsw1().length() <1) {
			this.addFieldError("password", getText("psw.required"));
		}
		if (!getPsw1().equals(getPsw2())) {
			this.addFieldError("error4", getText("errors.validwhen"));
		}
		if (getAge()>200||getAge()<0) {
			this.addFieldError("error5", getText("age.error"));
		}
		String regTelNum="[0-9][7,15]$";
		Pattern e = Pattern.compile(regTelNum);
		Matcher em = e.matcher(telNum);
		if(!(getTelNum().equals(""))&&!em.matches()){
			this.addFieldError("error6", getText("tel.error"));
		}
		String regEmailString = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern=Pattern.compile(regEmailString);
		Matcher matcher=pattern.matcher(email);
		if (email=="") {
			this.addFieldError("error7", getText("email.required"));
		}
		if (email!=""&&!matcher.matches()) {
			this.addFieldError("error7", getText("email.error"));
		}
		System.out.println("到了RegisterAction.validate()的最后");
	}*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPsw1() {
		return psw1;
	}
	public void setPsw1(String psw1) {
		this.psw1 = psw1;
	}
	public String getPsw2() {
		return psw2;
	}
	public void setPsw2(String psw2) {
		this.psw2 = psw2;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("到了RegisterAction.execute()的SUCCESS之前");
		UserVo result = userService.findByProperty(userName, psw1);
		if (result != null) {
			addFieldError("error0", getText("username.exist"));
			return SUCCESS;
		} else {
			UserVo newUser = new UserVo();
			newUser.setUserName(userName);
			newUser.setPassWord(psw1);
			newUser.setSex(sex);
			newUser.setAge(age);
			newUser.setTelNum(telNum);
			newUser.setE_Mail(email);
			userService.save(newUser);
			return SUCCESS;
		}
	}
}
