package action;
import java.util.List;
import java.util.Map;
import service.CartService;
import service.OrdersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.CartVo;
import domain.OrdersVo;
import domain.UserVo;
public class Account extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String  address;
	private String  e_mail;
	private String  telNum;
	private CartService cartService;
	private OrdersService ordersService;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public OrdersService getOrdersService() {
		return ordersService;
	}
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		UserVo userVo=(UserVo)session.get("userVo");
		List<CartVo> cartvo=cartService.showCartByUserId(userVo.getUserID());
		for(int i=0;i<cartvo.size();i++){
			OrdersVo newOrder=new OrdersVo();
			newOrder.setAddress(address);
			newOrder.setE_Mail(e_mail);
			newOrder.setTelNum(telNum);
			newOrder.setUserId(userVo.getUserID());
			newOrder.setProductId(cartvo.get(i).getProductId());
			ordersService.save(newOrder);
			cartService.delete(cartvo.get(i).getId());
		}
		return SUCCESS;
	}
}
