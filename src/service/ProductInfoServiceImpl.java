package service;
import java.util.List;

import dao.ProductInfoDAO;
import domain.ProductInfoVo;
public class ProductInfoServiceImpl implements ProductInfoService{
	private ProductInfoDAO productInfoDAO;
	public ProductInfoDAO getProductInfoDAO() {
		return productInfoDAO;
	}
	public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
		this.productInfoDAO = productInfoDAO;
	}
	public ProductInfoVo findByID(int id) {

		return productInfoDAO.findByID(id);
	}
	public List<ProductInfoVo> findBySortId(int sortId) {
		// TODO Auto-generated method stub
		return productInfoDAO.findBySortId(sortId);
	}
}
