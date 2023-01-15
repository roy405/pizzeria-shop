package repo;

import java.sql.SQLException;
import java.util.List;

import models.Order;

public interface OrderRepo {
	public int add(Order order)
		throws SQLException;
	public void delete(int id)
		throws SQLException;
	public Order getOrder(int id)
		throws SQLException;
	public List<Order> getOrders()
		throws SQLException;
	public void update(Order order)
		throws SQLException;
}
