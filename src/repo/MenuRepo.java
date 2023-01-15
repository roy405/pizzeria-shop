package repo;

import java.sql.SQLException;
import java.util.List;

import models.Menu;



public interface MenuRepo {
	
	public void add(List<Menu> menuItemList)
			throws SQLException;
		public void delete(int id)
			throws SQLException;
		public Menu getMenu(int id)
			throws SQLException;
		public List<Menu> getMenus(int order_id)
			throws SQLException;
		public void update(Menu menu)
			throws SQLException;

}
