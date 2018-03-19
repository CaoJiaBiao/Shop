package service;
import domain.ProductSortVo;
public interface ProductSortService {
	public ProductSortVo findByID(int id);
	public int findBySortName(String sortName);
}
