package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBConnection {
	
	private static Connection connection = null;
	
	static
	{
		String url = "jdbc:mysql://localhost:3306/yummypizza";
		String user = "root";
		String password = "1234";
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
//    public static void getConnection() {
//    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nofreeride", "root", "1234");
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from student");
//        while(rs.next())
//        {
//            System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " "+ rs.getString(3));
//        }
//        rs.close();
//        stmt.close();
//        conn.close();
//    }
//    catch(ClassNotFoundException | SQLException e){
//    	System.out.println(e);
//    	e.printStackTrace();
//    	}
//    }
    
    
    
}