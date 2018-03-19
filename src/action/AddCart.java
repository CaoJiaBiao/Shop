package action;
import java.util.Map;
import service.CartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.CartVo;
import domain.UserVo;
public class AddCart extends ActionSupport{
	int productId;
	private int count;
	private CartService cartService;
	private CartVo cartVo;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public CartVo getCartVo() {
		return cartVo;
	}
	public void setCartVo(CartVo cartVo) {
		this.cartVo = cartVo;
	}
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		//获取用户ID
		Map session = ActionContext.getContext().getSession();
		UserVo userVo=(UserVo)session.get("userVo");
		if (userVo == null) {
			addFieldError("pleaseLoginIn", getText("pleaseLoginIn"));
			return "pleaseLoginIn";
		}
		CartVo cartVo=new CartVo();
		cartVo.setUserId(userVo.getUserID());
		cartVo.setProductId(productId);
		cartVo.setCount(count);
		cartService.save(cartVo);
		return SUCCESS;
	}
}
