package action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.CartService;
import service.ProductInfoService;
import service.ProductSortService;
import service.UserService;
import domain.CartVo;
import domain.ProductInfoVo;
import domain.ProductSortVo;
import domain.UserVo;
import domain.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class CartProductSelect extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private UserVo uservo;
	private ProductInfoVo productInfovo;
	private ProductInfoService productInfoService;
	private ProductSortVo productsortvo;
	private ProductSortService productSortService;
	private CartVo cart;
	private CartService cartService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserVo getUservo() {
		return uservo;
	}
	public void setUservo(UserVo uservo) {
		this.uservo = uservo;
	}
	public ProductInfoVo getProductInfovo() {
		return productInfovo;
	}
	public void setProductInfovo(ProductInfoVo productInfovo) {
		this.productInfovo = productInfovo;
	}
	public ProductInfoService getProductInfoService() {
		return productInfoService;
	}
	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}
	public ProductSortVo getProductsortvo() {
		return productsortvo;
	}
	public void setProductsortvo(ProductSortVo productsortvo) {
		this.productsortvo = productsortvo;
	}
	public ProductSortService getProductSortService() {
		return productSortService;
	}
	public void setProductSortService(ProductSortService productSortService) {
		this.productSortService = productSortService;
	}
	public CartVo getCart() {
		return cart;
	}
	public void setCart(CartVo cart) {
		this.cart = cart;
	}
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		List<Cart> cart=new ArrayList<Cart>();
		Map session = ActionContext.getContext().getSession();
		
		//*****************************δ�����
	
		UserVo userVo=(UserVo)session.get("userVo");
		if (userVo == null) {
			return "pleaseLogin";
		}
		//*****************************
		List<CartVo> cartvo=cartService.showCartByUserId(userVo.getUserID());
		double totalPrice=0.0;
		for(int i=0;i<cartvo.size();i++){
			Cart newCart=new Cart();	//����һ��Cart����
			newCart.setCartId(cartvo.get(i).getId());		//��¼��ǰ�Ĺ��ﳵid
			int userID=cartvo.get(i).getUserId();
			newCart.setUserID(userID);	//��¼�û�Id
			int productId=cartvo.get(i).getProductId();		//��ȡ��ƷId
			newCart.setProductId(productId);
			ProductInfoVo pi=productInfoService.findByID(productId);
			newCart.setProductName(pi.getProductName());	//��ȡ��Ʒ����
			newCart.setPrice(pi.getPrice());				//��ȡ��Ʒ�۸�
			newCart.setDiscount(pi.getDiscount()); 			//��ȡ�ۿ���Ϣ
			newCart.setDiscription(pi.getDiscription());	//��ȡ������Ϣ
			int productSortId=pi.getSortId();				//��ȡ��Ʒ����Id
			newCart.setSortId(productSortId);
			ProductSortVo ps=productSortService.findByID(productSortId);
			newCart.setSortName(ps.getSortName());			//��¼��Ʒ��������
			newCart.setUserName(userVo.getUserName());		//��ȡ�û�����Ϣ
			newCart.setCount(cartvo.get(i).getCount());
			cart.add(newCart);			//���뵽cart�б���
			totalPrice += newCart.getPrice() * newCart.getCount()*newCart.getDiscount()*0.1;
		}
		if(cart.size()>0){
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("cart",cart);
			request.put("totalPrice", totalPrice);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}