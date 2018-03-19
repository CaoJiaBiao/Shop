package action;
import java.util.Map;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.UserVo;
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPsw;
	private UserService userService;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPsw() {
		return userPsw;
	}
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserVo result = userService.findByProperty(userName, userPsw);
		if (result !=null)
		{
			Map session = ActionContext.getContext().getSession();
			if(session.containsKey("userVo"))
				session.remove("userVo");
			session.put("userVo",result);
			return SUCCESS;
		}
		else
			return ERROR;
	}
}
