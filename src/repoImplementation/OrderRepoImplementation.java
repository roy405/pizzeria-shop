package repoImplementation;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dbconnection.JDBConnection;
import models.Customer;
import models.Order;
import repo.OrderRepo;

public class OrderRepoImplementation implements OrderRepo {

	static Connection con = JDBConnection.getConnection();

	@Override
	public int add(Order order) throws SQLException {
		String query = "Insert into Orders(order_desc, order_type, order_total, customer_id)" + "VALUES(?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, order.getOrder_desc());
		ps.setString(2, order.getOrder_type());
		ps.setFloat(3, order.getOrder_cost());
		ps.setInt(4, order.getCustomer().getCustomer_id());
		int affectedRows = ps.executeUpdate();
		if (affectedRows == 0) {
			throw new SQLException("Failed to place order, no rows affected!");
		}
		try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				Long l = generatedKeys.getLong(1);
				int idValue = l.intValue();
				order.setOrder_id(idValue);
				return idValue;
			} else {
				throw new SQLException("Failed to place order, no rows affected!");
			}
		}

	}

	@Override
	public void delete(int id) throws SQLException {
		String query = "DELETE from Orders WHERE order_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();

	}

	@Override
	public Order getOrder(int id) throws SQLException {
		String query = "SELECT * FROM Orders where order_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,  id);
		Order order = new Order();
		ResultSet rs = ps.executeQuery();
		boolean check = false;
		while(rs.next()) {
			check = true;
			order.setOrder_id(rs.getInt("order_id"));
			order.setOrder_desc(rs.getString("order_desc"));
			order.setOrder_type(rs.getString("order_type"));
			order.setOrder_cost(rs.getFloat("order_total"));
		}
		if(check == true) {
			return order;
		}else{
			return null;
		}
	}

	@Override
	public List<Order> getOrders() throws SQLException {
		String query = "SELECT * FROM Orders";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet res = ps.executeQuery();
		List<Order> orders = new ArrayList();
		while (res.next()) {
			Order order = new Order();
			order.setOrder_id(res.getInt("order_id"));
			order.setOrder_type(res.getString("order_type"));
			order.setOrder_desc(res.getString("order_desc"));
			order.setOrder_cost(res.getFloat("order_total"));
			orders.add(order);
		}

		return orders;
	}

	@Override
	public void update(Order order) throws SQLException {
		String query = "UPDATE Orders set order_desc= ?, order_type= ?, order_total= ? WHERE order_id= ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, order.getOrder_desc());
		ps.setString(2, order.getOrder_type());
		ps.setFloat(3, order.getOrder_cost());
		ps.setInt(1, order.getOrder_id());
		ps.executeUpdate();

	}

}
