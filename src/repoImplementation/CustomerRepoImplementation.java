package repoImplementation;

import dbconnection.JDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Customer;
import repo.CustomerRepo;


public class CustomerRepoImplementation implements CustomerRepo {
	
	static Connection con = JDBConnection.getConnection();

	@Override
	public int add(Customer customer) throws SQLException {
		System.out.println(customer.getCustomer_name());
		String query = "INSERT into Customers(customer_name, customer_email, customer_phone_no, customer_address)"
				+ "VALUES (?, ?, ?, ?)";	
		PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,  customer.getCustomer_name());
		ps.setString(2, customer.getCustomer_email());
		ps.setString(3, customer.getCustomer_contact_no());
		ps.setString(4, customer.getCustomer_address());
		int affectedRows = ps.executeUpdate();
		if(affectedRows == 0) {
			throw new SQLException("Creating customer failed, no rows affected.");
		}
		try(ResultSet generatedKeys = ps.getGeneratedKeys()){
			if(generatedKeys.next()) {
				Long l = generatedKeys.getLong(1);
				int idValue = l.intValue();
				customer.setCustomer_id(idValue);
				return idValue;
			}
			else {
				throw new SQLException("Creating customer failed, no ID obtained");
			}
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String query = "DELETE from Customers WHERE customer_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	}

	@Override
	public Customer getCustomer(int id) throws SQLException {
		String query = "SELECT * FROM Customers where customer_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,  id);
		Customer customer = new Customer();
		ResultSet rs = ps.executeQuery();
		boolean check = false;
		while(rs.next()) {
			check = true;
			customer.setCustomer_name("customer_name");
			customer.setCustomer_email("customer_email");
			customer.setCustomer_contact_no("customer_contact_no");
			customer.setCustomer_address("customer_address");
		}
		if(check == true) {
			return customer;
		}else{
			return null;
		}
	}
	
	@Override
	public List<Customer> getCustomers() throws SQLException {
		String query = "SELECT * FROM Customers";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Customer> customers = new ArrayList();
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setCustomer_id(rs.getInt("customer_id"));
			customer.setCustomer_name(rs.getString("customer_name"));
			customer.setCustomer_email(rs.getString("customer_email"));
			customer.setCustomer_contact_no(rs.getString("customer_contact_no"));
			customer.setCustomer_address(rs.getString("customer_address"));
			customers.add(customer);
		}
		return customers;
	}

	
	@Override
	public void update(Customer customer) throws SQLException {
		String query = "UPDATE Customers set customer_name= ?, "
				+ "customer_email= ?, customer_contact_no= ?, customer_address= ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, customer.getCustomer_name());
		ps.setString(2, customer.getCustomer_email());
		ps.setString(3, customer.getCustomer_contact_no());
		ps.setString(4, customer.getCustomer_address());
		ps.executeUpdate();
	}

	

}
