package dao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import domain.OrdersVo;
public class OrdersDAOImpl extends HibernateDaoSupport implements OrdersDAO{
	public void save(OrdersVo newOrder) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(newOrder);
	}
}
