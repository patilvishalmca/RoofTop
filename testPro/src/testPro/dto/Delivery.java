package testPro.dto;

public class Delivery {
	private Order items;
	private long deliveryTime;
	private DeliveryPartner assignedPartner;

	public Delivery() {

	}

	public Delivery(Order items, long deliveryTime// , DeliveryPartner assignedPartner
	) {
		super();
		this.items = items;
		this.deliveryTime = deliveryTime;
		// this.assignedPartner = assignedPartner;
	}

	public Order getItems() {
		return items;
	}

	public void setItems(Order items) {
		this.items = items;
	}

	public long getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public DeliveryPartner getAssignedPartner() {
		return assignedPartner;
	}

	public void setAssignedPartner(DeliveryPartner assignedPartner) {
		this.assignedPartner = assignedPartner;
	}

	// Constructor, getters, setters, etc.

}