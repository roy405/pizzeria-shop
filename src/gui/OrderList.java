package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import models.Order;
import repoImplementation.OrderRepoImplementation;

import javax.swing.JList;
import java.util.*;


public class OrderList extends JFrame {

	private JPanel contentPane;
	private Order order;
	private OrderRepoImplementation orderRepoImpl;
	private List<Order> orders;
	private JTable ordersTable;
	private static String [][] ordersArray;
	private JTable table;
	private JTable table_1;


	public static void unfoldWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderList frame = new OrderList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public OrderList() {
		initialize();
	}
	
	public void initialize() {
		
		orderRepoImpl  = new OrderRepoImplementation();
		try {
			orders = orderRepoImpl.getOrders();
			System.out.println(orders.get(0));
			ordersArray = ordersProcessing(orders);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] columnHeader = {"Order Cost", "Order Desc", "Order Type"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 859, 515);
		contentPane.add(scrollPane);
		
		table_1 = new JTable(ordersArray, columnHeader);
		scrollPane.setViewportView(table_1);
		
		
	}
	
	public String [][] ordersProcessing(List<Order> orders){
		String[][] ordersArray = new String[orders.size()][3]; 
		for(int i = 0; i < ordersArray.length;i++) {
			for(int j = 0; j < ordersArray[i].length; j++) {
				
				ordersArray[i][j]=String.valueOf(orders.get(i).getOrder_cost());
				ordersArray[i][j+1]=String.valueOf(orders.get(i).getOrder_desc());
				ordersArray[i][j+2]	=String.valueOf(orders.get(i).getOrder_type());	
				break;		
				
			}
		}
		return ordersArray;
		
	}
}
