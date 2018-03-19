package service;
import domain.UserVo;
public interface UserService {
	public UserVo findByID(int userID);
	public UserVo findByProperty(String propertyName,String propertyPsw);
	public void save(UserVo newUser);
}
