package action;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginOut extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map  session = ActionContext.getContext().getSession();
		session.remove("userVo");
		return SUCCESS;
	}
}
