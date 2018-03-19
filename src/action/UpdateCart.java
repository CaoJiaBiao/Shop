package action;
import service.CartService;
import com.opensymphony.xwork2.ActionSupport;
public class UpdateCart extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int cartId;
	private CartService cartService;
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String execute() throws Exception{
		System.out.println("update cart");
		System.out.println(cartId);
		cartService.delete(cartId);
		
		return SUCCESS;
	}
}