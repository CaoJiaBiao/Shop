package dao;
import java.util.List;
import domain.CartVo;
public interface CartDAO {
	public List<CartVo> findALL();
	public List<CartVo> findByUserId(int userId);
	public void save(CartVo newCart);
	public void delete(int cartId);
}
