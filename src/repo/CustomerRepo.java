package repo;

import java.sql.SQLException;
import java.util.List;

import models.Customer;

public interface CustomerRepo {
	
	public int add(Customer customer)
		throws SQLException;
	public void delete(int id)
		throws SQLException;
	public Customer getCustomer(int id)
		throws SQLException;
	public List<Customer> getCustomers()
		throws SQLException;
	public void update(Customer customer)
		throws SQLException;
}
