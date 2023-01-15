package models;

public class Order {

	private int order_id;
	private String order_desc;
	private String order_type;
	private float order_cost;
	
	private Customer customer;

	public Order() {

	}

	public Order(float order_cost, String order_desc, String order_type) {
		super();
		this.order_cost = order_cost;
		this.order_desc = order_desc;
		this.order_type = order_type;
	}

	public Order(float order_cost, String order_desc, String order_type, Customer customer) {
		super();
		this.order_cost = order_cost;
		this.order_desc = order_desc;
		this.order_type = order_type;
		this.customer = customer;

	}

	public Order(int order_id, float order_cost, String order_desc, String order_type, Customer customer) {
		super();
		this.order_id = order_id;
		this.order_cost = order_cost;
		this.order_desc = order_desc;
		this.order_type = order_type;
		this.customer = customer;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public float getOrder_cost() {
		return order_cost;
	}

	public void setOrder_cost(float order_cost) {
		this.order_cost = order_cost;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [order_cost=" + order_cost + ", order_desc=" + order_desc + ", order_type=" + order_type + "]";
	}

}
