package service;
import java.util.List;
import domain.CartVo;
public interface CartService {
	public List<CartVo>  showCart();
	public List<CartVo>  showCartByUserId(int userId);
	public void save(CartVo newCart);
	public void delete(int cartId);
}
