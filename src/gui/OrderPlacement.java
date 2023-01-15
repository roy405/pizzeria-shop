package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import enums.pizza_size;
import enums.pizza_base;
import enums.pizza_sauce;
import enums.pizza_topping;
import enums.pasta;
import enums.add_Ons;
import enums.pizza_cheese;
import javax.swing.JList;
import enums.order_type;

import models.Customer;
import models.Order;
import models.Menu;

import repoImplementation.CustomerRepoImplementation;
import repoImplementation.OrderRepoImplementation;
import repoImplementation.MenuRepoImplementation;

public class OrderPlacement extends JFrame{

	private JFrame frmOrderPlacement;
	private JTextField text_customer_name;
	private JTextField text_customer_email;
	private JTextField text_customer_contact_no;
	private JTextField text_customer_address;
	private JTextField text_order_desc;
	private JTextField text_order_total_amount;
	private JComboBox combo_pizza_size;
	private JComboBox combo_pizza_base;
	private JComboBox combo_pizza_sauce;
	private JComboBox combo_pizza_cheese;
	private JComboBox combo_pizza_topping;
	private JComboBox combo_add_ons;
	private JComboBox combo_pasta;
	private JComboBox combo_order_type;
	private JList list_selected_order_items;
	private DefaultListModel<String> model;
	private JTable table;
	private float total_price, value_order_total;
	private String value_customer_name, value_customer_email, value_customer_contact_no, 
					value_customer_address, value_pizza_size, value_pizza_base, value_pizza_sauce, 
					value_pizza_cheese,	value_pizza_topping, value_pasta, value_add_ons, value_order_type, value_order_desc;
	private List<Float> priceList = new ArrayList<Float>();
	private List<Menu> menuItemsList = new ArrayList<Menu>();
	
	
	private CustomerRepoImplementation customerRepoImpl;
	private OrderRepoImplementation orderRepoImpl;
	private MenuRepoImplementation menuRepoImpl;
	private Customer customer;
	private Order order;
	private Menu menu_item;
	
	
	
	public static void unfoldWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPlacement window = new OrderPlacement();
					window.frmOrderPlacement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OrderPlacement() {
		initialize();
	}


	
	private void initialize() {
		
		frmOrderPlacement = new JFrame();
		frmOrderPlacement.setTitle("Order Placement");
		frmOrderPlacement.setBounds(100, 100, 982, 702);
		frmOrderPlacement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOrderPlacement.getContentPane().setLayout(null);
		
		text_customer_name = new JTextField();
		text_customer_name.setBounds(136, 71, 203, 20);
		frmOrderPlacement.getContentPane().add(text_customer_name);
		text_customer_name.setColumns(10);
		
		text_customer_email = new JTextField();
		text_customer_email.setBounds(136, 102, 203, 20);
		frmOrderPlacement.getContentPane().add(text_customer_email);
		text_customer_email.setColumns(10);
		
		text_customer_contact_no = new JTextField();
		text_customer_contact_no.setBounds(136, 133, 203, 20);
		frmOrderPlacement.getContentPane().add(text_customer_contact_no);
		text_customer_contact_no.setColumns(10);
		
		text_customer_address = new JTextField();
		text_customer_address.setBounds(136, 164, 203, 20);
		frmOrderPlacement.getContentPane().add(text_customer_address);
		text_customer_address.setColumns(10);
		
		text_order_desc = new JTextField();
		text_order_desc.setBounds(706, 410, 227, 20);
		frmOrderPlacement.getContentPane().add(text_order_desc);
		text_order_desc.setColumns(10);
		
		text_order_total_amount = new JTextField();
		text_order_total_amount.setEditable(false);
		text_order_total_amount.setBounds(706, 441, 227, 20);
		frmOrderPlacement.getContentPane().add(text_order_total_amount);
		text_order_total_amount.setColumns(10);
		
		
		
		//Dropboxes
		combo_pizza_size = new JComboBox();
		combo_pizza_size.setModel(new DefaultComboBoxModel(pizza_size.values()));
		combo_pizza_size.setBounds(555, 70, 84, 22);
		frmOrderPlacement.getContentPane().add(combo_pizza_size);
		
		combo_pizza_base = new JComboBox();
		combo_pizza_base.setModel(new DefaultComboBoxModel(pizza_base.values()));
		combo_pizza_base.setBounds(760, 70, 74, 22);
		frmOrderPlacement.getContentPane().add(combo_pizza_base);
		
		combo_pizza_sauce = new JComboBox();
		combo_pizza_sauce.setModel(new DefaultComboBoxModel(pizza_sauce.values()));
		combo_pizza_sauce.setBounds(555, 101, 84, 22);
		frmOrderPlacement.getContentPane().add(combo_pizza_sauce);
		
		combo_pizza_cheese = new JComboBox();
		combo_pizza_cheese.setModel(new DefaultComboBoxModel(pizza_cheese.values()));
		combo_pizza_cheese.setBounds(760, 101, 74, 22);
		frmOrderPlacement.getContentPane().add(combo_pizza_cheese);
		
		combo_pizza_topping = new JComboBox();
		combo_pizza_topping.setModel(new DefaultComboBoxModel(pizza_topping.values()));
		combo_pizza_topping.setBounds(555, 132, 84, 22);
		frmOrderPlacement.getContentPane().add(combo_pizza_topping);
		
		combo_pasta = new JComboBox();
		combo_pasta.setModel(new DefaultComboBoxModel(pasta.values()));
		combo_pasta.setBounds(500, 196, 106, 22);
		frmOrderPlacement.getContentPane().add(combo_pasta);
		
		combo_add_ons = new JComboBox();
		combo_add_ons.setModel(new DefaultComboBoxModel(add_Ons.values()));
		combo_add_ons.setBounds(712, 196, 90, 22);
		frmOrderPlacement.getContentPane().add(combo_add_ons);
		
		combo_order_type = new JComboBox();
		combo_order_type.setModel(new DefaultComboBoxModel(order_type.values()));
		combo_order_type.setBounds(706, 373, 158, 22);
		frmOrderPlacement.getContentPane().add(combo_order_type);
		
		
		
		
		
		
		//SEPARATORS		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 310, 946, 14);
		frmOrderPlacement.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(420, 0, 22, 276);
		frmOrderPlacement.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(441, 182, 492, 2);
		frmOrderPlacement.getContentPane().add(separator_2);
		
		
		
		
		//LABELS 
		JLabel lblNewLabel_6 = new JLabel("Customer Information");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_6.setBounds(112, 28, 174, 32);
		frmOrderPlacement.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setBounds(52, 74, 46, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(52, 105, 46, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No");
		lblNewLabel_2.setBounds(52, 136, 74, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(52, 167, 46, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Order Items");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_7.setBounds(676, 28, 98, 23);
		frmOrderPlacement.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("Pizza Size");
		lblNewLabel.setBounds(468, 74, 72, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Pizza Base");
		lblNewLabel_4.setBounds(649, 74, 101, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("Pizza Sauce");
		lblNewLabel_8.setBounds(468, 105, 61, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Pizza Cheese");
		lblNewLabel_9.setBounds(649, 105, 101, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Pizza Topping");
		lblNewLabel_10.setBounds(468, 136, 72, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Pasta");
		lblNewLabel_11.setBounds(452, 196, 46, 22);
		frmOrderPlacement.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Add Ons");
		lblNewLabel_12.setBounds(651, 200, 51, 14);
		frmOrderPlacement.getContentPane().add(lblNewLabel_12);
		
		JLabel label_order_information = new JLabel("Order Information");
		label_order_information.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		label_order_information.setBounds(660, 335, 174, 14);
		frmOrderPlacement.getContentPane().add(label_order_information);
		
		JLabel label_order_type = new JLabel("Order Type");
		label_order_type.setBounds(570, 377, 84, 14);
		frmOrderPlacement.getContentPane().add(label_order_type);
		
		JLabel label_order_description = new JLabel("Order Description");
		label_order_description.setBounds(570, 413, 115, 14);
		frmOrderPlacement.getContentPane().add(label_order_description);
		
		JLabel label_order_total_amount = new JLabel("Total Amount");
		label_order_total_amount.setBounds(570, 444, 115, 14);
		frmOrderPlacement.getContentPane().add(label_order_total_amount);
		
		
		
		//LIST TO SHOW ALL ITEM SELECTIONS
		model = new DefaultListModel<>();
		list_selected_order_items = new JList(model);
		list_selected_order_items.setBounds(25, 333, 504, 298);
		frmOrderPlacement.getContentPane().add(list_selected_order_items);
		
		
		
		//BUTTONS
		
		//Button to select Pizza 
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Clearing priceList for previous stored values and creating a fresh, empty list.
				priceList.clear();
				
				//Pizza processing, getting values and identifying prices
				String pizza_title = "Pizza";
				float pizza_price = 0;
				
				value_pizza_size = String.valueOf(combo_pizza_size.getSelectedItem());
				value_pizza_base = String.valueOf(combo_pizza_base.getSelectedItem());
				value_pizza_sauce = String.valueOf(combo_pizza_sauce.getSelectedItem());
				value_pizza_cheese = String.valueOf(combo_pizza_cheese.getSelectedItem());
				value_pizza_topping = String.valueOf(combo_pizza_topping.getSelectedItem());
				
				if(value_pizza_size == "SMALL") {
					pizza_price = 13;
					priceList.add(pizza_price);
				}else if (value_pizza_size == "LARGE") {
					pizza_price = 19;
					priceList.add(pizza_price);
				}else {
					pizza_price = 24;
					priceList.add(pizza_price);
				}
				
				
				String [] pizza = {pizza_title, "Size -" + value_pizza_size, "Base -" + value_pizza_base, 
									"Sauce -" + value_pizza_sauce, "Cheese -" + value_pizza_cheese, 
									"Topping -" + value_pizza_topping};
				
				//Adding pizza info to the list model to display to user
				for(int i = 0; i < pizza.length; i++) {
					model.add(i, pizza[i]);
				}
				
				//Pasta processing, getting values and identifying prices
				String pasta_title = "Pasta";
				float pasta_price = 0;
				
				value_pasta = String.valueOf(combo_pasta.getSelectedItem());
				
				if(value_pasta == "CREAMY_MUSHROOM" || value_pasta == "BOLOGNESE") {
					pasta_price = 16;
					priceList.add(pasta_price);
				}
				
				
				String [] pasta = {pasta_title, value_pasta};
				
				//Adding pasta info to the list model to display to user
				for(int i = 0; i<pasta.length; i++) {
					if(pasta[i] != "NONE") {
					model.add(i, pasta[i]);
					}
				}
				
				//Add ons processing, getting values and identifying prices
				String add_on_title = "Add On";
				float add_on_price = 0;
				
				value_add_ons = String.valueOf(combo_add_ons.getSelectedItem());
				
				if(value_add_ons == "CHICKEN_WINGS") {
					add_on_price = 10;
					priceList.add(add_on_price);
				}else if(value_add_ons == "GARLIC_BREAD") {
					add_on_price = 7;
					priceList.add(add_on_price);
				}else {
					add_on_price = 5;
					priceList.add(add_on_price);
				}
				
				System.out.println(priceList.size());
				String [] add_on = {add_on_title, value_add_ons};
				
				//Adding add-ons to the list model to display to user
				for(int i = 0; i<add_on.length; i++) {
					model.add(i, add_on[i]);
				}
				
				//Setting menu items to menu item object 
				menu_item = new Menu(value_pizza_size, value_pizza_base, value_pizza_sauce, value_pizza_cheese, value_pizza_topping, value_pasta, value_add_ons, priceList.get(0), priceList.get(1), priceList.get(2));
				System.out.println(menu_item.toString());
				
				//Since multiple items can be selected for a single order, menu_item objects are added to a List<Menu> menuItemsList
				menuItemsList.add(menu_item);		
				
			}
		});
		btnAddItem.setBounds(816, 245, 104, 40);
		frmOrderPlacement.getContentPane().add(btnAddItem);
		
		//Button to traverse to payment window
		JButton btnPaymentInfo = new JButton("Payment Info");
		btnPaymentInfo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnPaymentInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				placeOrder();
				
			}
		});
		btnPaymentInfo.setBounds(803, 586, 130, 51);
		frmOrderPlacement.getContentPane().add(btnPaymentInfo);
		
		
		
		//Button to cancel
		JButton button_cancelOrder = new JButton("Cancel");
		button_cancelOrder.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		button_cancelOrder.setBounds(663, 585, 130, 52);
		frmOrderPlacement.getContentPane().add(button_cancelOrder);
		
	}
	
	//Method to calculate total price from List with item prices
	public static float total_price_calc(List <Float> priceList) {
		float total_price = 0;
		for(float i: priceList) {
			total_price += i;
		}
		return total_price;
	}
	
	public void placeOrder() {
		System.out.println(menuItemsList.size());
		
		//Getting customer information from JTextFields
		value_customer_name = text_customer_name.getText();
		value_customer_email = text_customer_email.getText();
		value_customer_contact_no = text_customer_contact_no.getText();
		value_customer_address = text_customer_address.getText();
		
		//Setting customer info to Customer object via constructor
		customer = new Customer(value_customer_name, value_customer_email, value_customer_contact_no, value_customer_address);
		
		//Calculating total cost by invoking total_price_calc method and passing priceList into it
		total_price = total_price_calc(priceList);
		
		
		//Getting order information from JTextFields
		value_order_type = String.valueOf(combo_order_type.getSelectedItem());
		System.out.println(value_order_type);
		value_order_desc = text_order_desc.getText();
		value_order_total = total_price;
		text_order_total_amount.setText(String.valueOf(value_order_total));
		
		//Setting order info to Order object via constructor
		//order = new Order(value_order_total, value_order_desc, value_order_type);
		
		customerRepoImpl = new CustomerRepoImplementation();
		orderRepoImpl = new OrderRepoImplementation();
		menuRepoImpl = new MenuRepoImplementation();
		//Using Repositories to add into to database for persistence. Using try catch block to handle SQLException errors
		try {
			customerRepoImpl.add(customer);
			System.out.println(customer.getCustomer_id());
			order = new Order(value_order_total, value_order_desc, value_order_type, customer);
			orderRepoImpl.add(order);
			for(Menu menu : menuItemsList) {
				menu.setOrder(order);
			}
			menuRepoImpl.add(menuItemsList);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
