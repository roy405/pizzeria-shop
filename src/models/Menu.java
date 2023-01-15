package models;

public class Menu {
	private int menu_id;
	private String pizza_size;
	private String pizza_base;
	private String pizza_sauce;
	private String pizza_cheese;
	private String pizza_topping;
	private String pasta;
	private String add_Ons;
	private float pizza_price;
	private float pasta_price;
	private float add_on_price;

	private Order order;

	public Menu() {

	}

	public Menu(String pizza_size, String pizza_base, String pizza_sauce, String pizza_cheese, String pizza_topping,
			String pasta, String add_Ons, float pizza_price, float pasta_price, float add_on_price) {
		super();
		this.pizza_size = pizza_size;
		this.pizza_base = pizza_base;
		this.pizza_sauce = pizza_sauce;
		this.pizza_cheese = pizza_cheese;
		this.pizza_topping = pizza_topping;
		this.pasta = pasta;
		this.add_Ons = add_Ons;
		this.pizza_price = pizza_price;
		this.pasta_price = pasta_price;
		this.add_on_price = add_on_price;
	}

	public Menu(String pizza_size, String pizza_base, String pizza_sauce, String pizza_cheese, String pizza_topping,
			String pasta, String add_Ons, float pizza_price, float pasta_price, float add_on_price, Order order) {
		super();
		this.pizza_size = pizza_size;
		this.pizza_base = pizza_base;
		this.pizza_sauce = pizza_sauce;
		this.pizza_cheese = pizza_cheese;
		this.pizza_topping = pizza_topping;
		this.pasta = pasta;
		this.add_Ons = add_Ons;
		this.pizza_price = pizza_price;
		this.pasta_price = pasta_price;
		this.add_on_price = add_on_price;
		this.order = order;
	}

	public Menu(int menu_id, String pizza_size, String pizza_base, String pizza_sauce, String pizza_cheese,
			String pizza_topping, String pasta, String add_Ons, float pizza_price, float pasta_price,
			float add_on_price) {
		super();
		this.menu_id = menu_id;
		this.pizza_size = pizza_size;
		this.pizza_base = pizza_base;
		this.pizza_sauce = pizza_sauce;
		this.pizza_cheese = pizza_cheese;
		this.pizza_topping = pizza_topping;
		this.pasta = pasta;
		this.add_Ons = add_Ons;
		this.pizza_price = pizza_price;
		this.pasta_price = pasta_price;
		this.add_on_price = add_on_price;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getPizza_size() {
		return pizza_size;
	}

	public void setPizza_size(String pizza_size) {
		this.pizza_size = pizza_size;
	}

	public String getPizza_base() {
		return pizza_base;
	}

	public void setPizza_base(String pizza_base) {
		this.pizza_base = pizza_base;
	}

	public String getPizza_sauce() {
		return pizza_sauce;
	}

	public void setPizza_sauce(String pizza_sauce) {
		this.pizza_sauce = pizza_sauce;
	}

	public String getPizza_cheese() {
		return pizza_cheese;
	}

	public void setPizza_cheese(String pizza_cheese) {
		this.pizza_cheese = pizza_cheese;
	}

	public String getPizza_topping() {
		return pizza_topping;
	}

	public void setPizza_topping(String pizza_topping) {
		this.pizza_topping = pizza_topping;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}

	public String getAdd_Ons() {
		return add_Ons;
	}

	public void setAdd_Ons(String add_Ons) {
		this.add_Ons = add_Ons;
	}

	public float getPizza_price() {
		return pizza_price;
	}

	public void setPizza_price(float pizza_price) {
		this.pizza_price = pizza_price;
	}

	public float getPasta_price() {
		return pasta_price;
	}

	public void setPasta_price(float pasta_price) {
		this.pasta_price = pasta_price;
	}

	public float getAdd_on_price() {
		return add_on_price;
	}

	public void setAdd_on_price(float add_on_price) {
		this.add_on_price = add_on_price;
	}

	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", pizza_size=" + pizza_size + ", pizza_base=" + pizza_base
				+ ", pizza_sauce=" + pizza_sauce + ", pizza_cheese=" + pizza_cheese + ", pizza_topping=" + pizza_topping
				+ ", pasta=" + pasta + ", add_Ons=" + add_Ons + ", pizza_price=" + pizza_price + ", pasta_price="
				+ pasta_price + ", add_on_price=" + add_on_price + "]";
	}

}
