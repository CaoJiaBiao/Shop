package service;
import java.util.List;
import domain.ProductInfoVo;
public interface ProductInfoService {
	public ProductInfoVo findByID(int id);
	public List<ProductInfoVo> findBySortId(int sortId);
}
