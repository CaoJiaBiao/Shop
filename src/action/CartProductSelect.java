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
		
		//*****************************未整理好
	
		UserVo userVo=(UserVo)session.get("userVo");
		if (userVo == null) {
			return "pleaseLogin";
		}
		//*****************************
		List<CartVo> cartvo=cartService.showCartByUserId(userVo.getUserID());
		double totalPrice=0.0;
		for(int i=0;i<cartvo.size();i++){
			Cart newCart=new Cart();	//构建一个Cart对象
			newCart.setCartId(cartvo.get(i).getId());		//记录当前的购物车id
			int userID=cartvo.get(i).getUserId();
			newCart.setUserID(userID);	//记录用户Id
			int productId=cartvo.get(i).getProductId();		//获取商品Id
			newCart.setProductId(productId);
			ProductInfoVo pi=productInfoService.findByID(productId);
			newCart.setProductName(pi.getProductName());	//获取商品名称
			newCart.setPrice(pi.getPrice());				//获取商品价格
			newCart.setDiscount(pi.getDiscount()); 			//获取折扣信息
			newCart.setDiscription(pi.getDiscription());	//获取描述信息
			int productSortId=pi.getSortId();				//获取商品分类Id
			newCart.setSortId(productSortId);
			ProductSortVo ps=productSortService.findByID(productSortId);
			newCart.setSortName(ps.getSortName());			//记录商品分类名称
			newCart.setUserName(userVo.getUserName());		//获取用户名信息
			newCart.setCount(cartvo.get(i).getCount());
			cart.add(newCart);			//加入到cart列表中
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