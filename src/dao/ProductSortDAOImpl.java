package dao;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import domain.ProductSortVo;
public class ProductSortDAOImpl  extends HibernateDaoSupport implements ProductSortDAO{
	public ProductSortVo findByID(int id) {
		ProductSortVo ps = (ProductSortVo) getHibernateTemplate().get(ProductSortVo.class,id);
		return ps;
	}
	@SuppressWarnings("unchecked")
	public int findBySortName(String sortName) {
		// TODO Auto-generated method stub
		String queryString = "from ProductSortVo ps where ps.sortName='"+ sortName + "'";
		System.out.println(queryString);
		List<ProductSortVo> psList = getHibernateTemplate().find(queryString);
		return psList.get(0).getId();
	}
}
