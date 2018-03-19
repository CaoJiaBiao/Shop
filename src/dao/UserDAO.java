package dao;
import domain.UserVo;
public interface UserDAO {
	public UserVo findByID(int userID);
	public UserVo findByProperty(String propertyName,String propertyPsw);
	public void save(UserVo newUser);
}