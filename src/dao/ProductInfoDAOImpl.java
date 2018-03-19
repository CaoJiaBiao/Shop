package dao;
import java.util.List;
import domain.ProductInfoVo;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class ProductInfoDAOImpl extends HibernateDaoSupport implements ProductInfoDAO{
	public ProductInfoVo findByID(int id) {
		ProductInfoVo pi = (ProductInfoVo) getHibernateTemplate().get(ProductInfoVo.class,id);
		return pi;
	}
	@SuppressWarnings("unchecked")
	public List<ProductInfoVo> findBySortId(int sortId) {
		// TODO Auto-generated method stub
		String queryString = "from ProductInfoVo pi where pi.sortId="+ sortId ;
		System.out.println(queryString);
		List<ProductInfoVo> productList = getHibernateTemplate().find(queryString);
		return productList;
	}
}
