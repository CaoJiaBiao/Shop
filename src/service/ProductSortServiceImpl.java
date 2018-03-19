package service;

import dao.ProductSortDAO;
import domain.ProductSortVo;

public class ProductSortServiceImpl implements ProductSortService{
	private ProductSortDAO productSortDAO;
	public ProductSortDAO getProductSortDAO() {
		return productSortDAO;
	}
	public void setProductSortDAO(ProductSortDAO productSortDAO) {
		this.productSortDAO = productSortDAO;
	}
	public ProductSortVo findByID(int id) {
		return productSortDAO.findByID(id);
	}
	public int findBySortName(String sortName) {
		// TODO Auto-generated method stub
		return productSortDAO.findBySortName(sortName);
	}
}
