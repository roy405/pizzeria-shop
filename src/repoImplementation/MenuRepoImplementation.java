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
import models.Menu;
import repo.MenuRepo;

public class MenuRepoImplementation implements MenuRepo {
	
	static Connection con = JDBConnection.getConnection();

	@Override
	public void add(List<Menu> menuItemList) throws SQLException {
		String query = "INSERT INTO MENU_ITEMS(pizza, pasta, add_on, pizza_price, pasta_price, add_on_price, order_id)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		for(Menu menu: menuItemList){
			ps.setString(1, menu.getPizza_size() + " - " + menu.getPizza_base() + " - " + menu.getPizza_sauce() 
								+ " - " + menu.getPizza_cheese() + " - " + menu.getPizza_topping());
			ps.setString(2, menu.getPasta());
			ps.setString(3, menu.getAdd_Ons());
			ps.setFloat(4, menu.getPizza_price());
			ps.setFloat(5, menu.getPasta_price());
			ps.setFloat(6, menu.getAdd_on_price());
			ps.setInt(7, menu.getOrder().getOrder_id());
			ps.executeUpdate();
		}
		
	}

	@Override
	public void delete(int id) throws SQLException {
		String query = "DELETE from Menu_Items WHERE menu_item_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	}

	@Override
	public Menu getMenu(int id) throws SQLException {
		return null;
	}
	
	@Override
	public List<Menu> getMenus(int order_id) throws SQLException {
		return null;
	}



	@Override
	public void update(Menu menu) throws SQLException {
		String query = "UPDATE MENU_ITEMS set"
				+ "pizza= ?, pasta= ?, add_on= ?, pizza_price= ?, pasta_price= ?, "
				+ "add_on_price= ? WHERE menu_item_id= ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, menu.getPizza_size()+menu.getPizza_base()+menu.getPizza_sauce()+
							menu.getPizza_cheese()+menu.getPizza_topping());
		ps.setString(2, menu.getPasta());
		ps.setString(3, menu.getAdd_Ons());
		ps.setFloat(4, menu.getPizza_price());
		ps.setFloat(5, menu.getPasta_price());
		ps.setFloat(6, menu.getAdd_on_price());
		ps.setInt(7,  menu.getMenu_id());
		ps.executeQuery();
	}

	
	

}
