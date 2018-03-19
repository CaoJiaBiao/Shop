package dao;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import domain.UserVo;
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{
	public UserVo findByID(int userID){
		UserVo user = (UserVo) getHibernateTemplate().get(UserVo.class,userID);
		return user;
	}
	public UserVo findByProperty(String propertyName, String propertyPsw) {
		// TODO Auto-generated method stub
		UserVo result=new UserVo();
		String queryString = "from UserVo user where user.userName='"+ propertyName + "' and user.passWord='"+propertyPsw+"'";
		System.out.println(queryString);
		List<UserVo> userList = this.getHibernateTemplate().find(queryString);
		if(userList.size()!=0)
		{
			result=userList.get(0);
		}
		else
		{
			result=null;
		}
		return result;
	}
	public void save(UserVo newUser) {
		// TODO Auto-generated method stub
		if(newUser==null)
			return;
		getHibernateTemplate().save(newUser);
	}
}