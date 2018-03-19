package dao;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import domain.CartVo;
public class CartDAOImpl extends HibernateDaoSupport implements CartDAO{
	@SuppressWarnings("unchecked")
	public List<CartVo> findALL() {
		String sql="from CartVo";
		List<CartVo> list = (List<CartVo>) getHibernateTemplate().find(sql);
		return list;
	}
	public void save(CartVo newCart) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(newCart);
	}
	@SuppressWarnings("unchecked")
	public List<CartVo> findByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql="from CartVo cartVo where cartVo.userId="+userId;
		List<CartVo> list = (List<CartVo>) getHibernateTemplate().find(sql);
		return list;
	}
	public void delete(int cartId) {
		// TODO Auto-generated method stub

		CartVo vo = (CartVo)getHibernateTemplate().get(CartVo.class, cartId);

		System.out.println("É¾³ýÁË" +vo.getId());
        getHibernateTemplate().delete(vo);
	}
}