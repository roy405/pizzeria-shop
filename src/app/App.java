package app;

import dbconnection.JDBConnection;
import java.awt.EventQueue;
import gui.OrderPlacement;
import gui.OrderList;
public class App {
	
	public static void main(String [] args) {
	
		OrderPlacement.unfoldWindow();
		OrderList.unfoldWindow();
		
		String[] destinations = {"destination 1", "destination 2", "destination 3"};
		
		int i=0 ;

		do {
		    //do stuff with destinations[i]
			System.out.println(destinations[i]);
		    i++;
		} while (i<destinations.length) ;
		
	}
	
}
