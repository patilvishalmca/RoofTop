package testPro.dto;

//Customer Order Class
public class Order {
	private int id;
	private String name;
	private int orderTime;

	public Order() {

	}

	public Order(int id, String name, int time) {
		super();
		this.id = id;
		this.name = name;
		this.orderTime = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	// Constructor, getters, setters, etc.

}