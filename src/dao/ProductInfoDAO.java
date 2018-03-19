package dao;
import java.util.List;

import domain.ProductInfoVo;
public interface ProductInfoDAO {
	public ProductInfoVo findByID(int id);
	public List<ProductInfoVo> findBySortId(int sortId);
}
