package service;
import dao.UserDAO;
import domain.UserVo;
public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public UserVo findByID(int userID) {
		// TODO Auto-generated method stub
		return userDAO.findByID(userID);
	}
	public UserVo findByProperty(String propertyName, String propertyPsw) {
		// TODO Auto-generated method stub
		return userDAO.findByProperty(propertyName, propertyPsw);
	}
	public void save(UserVo newUser) {
		// TODO Auto-generated method stub
		userDAO.save(newUser);
	}
}