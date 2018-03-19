package dao;
import domain.ProductSortVo;
public interface ProductSortDAO {
	public ProductSortVo findByID(int id);
	public int findBySortName(String sortName);
}
