package service;
import dao.OrdersDAO;
import domain.OrdersVo;
public class OrdersServiceImpl implements OrdersService{
	private OrdersDAO ordersDAO;
	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	public void save(OrdersVo newOrder) {
		// TODO Auto-generated method stub
		ordersDAO.save(newOrder);
	}
}
