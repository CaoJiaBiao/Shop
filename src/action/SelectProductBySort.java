package action;
import java.util.List;
import java.util.Map;
import service.ProductInfoService;
import service.ProductSortService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.ProductInfoVo;
import domain.ProductSortVo;
public class SelectProductBySort extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int sortId=1;
	private ProductInfoVo productInfovo;
	private ProductInfoService productInfoService;
	private ProductSortVo productsortvo;
	private ProductSortService productSortService;
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
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

	public String execute() throws Exception{
		List<ProductInfoVo> productInfo=productInfoService.findBySortId(sortId);
		if(productInfo!=null){
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("productInfo",productInfo);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}
