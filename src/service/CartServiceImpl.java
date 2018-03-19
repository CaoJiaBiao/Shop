package service;
import java.util.List;
import domain.CartVo;
import dao.CartDAO;
public class CartServiceImpl implements CartService{
	private CartDAO cartDAO;
	public CartDAO getCartDAO() {
		return cartDAO;
	}
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	//显示购物车中的全部信息
	public List<CartVo> showCart() {
		if (cartDAO.findALL().size()>0){
			return cartDAO.findALL();
		}
		else {
			return null;
		}
	}
	public void save(CartVo newCart) {
		// TODO Auto-generated method stub
		cartDAO.save(newCart);
	}
	public List<CartVo> showCartByUserId(int userId) {
		// TODO Auto-generated method stub
		if (cartDAO.findByUserId(userId).size()>0){
			return cartDAO.findByUserId(userId);
		}
		else {
			return null;
		}
	}
	public void delete(int cartId) {
		// TODO Auto-generated method stub
		cartDAO.delete(cartId);
	}
	
}