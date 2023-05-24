package testPro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import testPro.dto.Delivery;
import testPro.dto.DeliveryPartner;
import testPro.dto.Order;

public class Main {
	public static void main(String[] args) {

		// get no of orders and delivery partners
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(",\\s*");
		System.out.println(":: Welcome To RoofTop Dine :: ");
		System.out.print("Enter number of customer orders and Number of delivery partners: ");
		String totalInput = scanner.nextLine();

		int orders = Integer.parseInt(totalInput.split(",")[0]);
		int drivers = Integer.parseInt(totalInput.split(",")[1]);

		// if orders or delivery partners count is less than zero
		if (orders < 0 || drivers < 0) {
			scanner.close();
			throw (new RuntimeException(
					"Invalid Input for number of customer orders and Number of delivery partners."));
		}
		// Create deliveries with input
		List<Delivery> deliveries = new ArrayList<Delivery>();
		for (int i = 1; i <= orders; i++) {
			System.out.print("Enter customer order Time and Duration of Delivery for C" + i + " : ");
			String orderDetails = scanner.nextLine();
			deliveries.add(new Delivery(new Order(1, "C" + i, Integer.parseInt(orderDetails.split(",")[0])),
					Integer.parseInt(orderDetails.split(",")[1])));
		}
		scanner.close();

		// sort all orders with order time
		Collections.sort(deliveries, Comparator.comparingInt(d -> d.getItems().getOrderTime()));

		// Create delivery partners
		List<DeliveryPartner> availablePartners = new ArrayList<DeliveryPartner>();
		for (int i = 1; i <= drivers; i++) {
			availablePartners.add(new DeliveryPartner(i, "D" + i, i));
		}

		// Assign deliveries to the available partners and generate output
		DeliveryPartnerService service = new DeliveryPartnerService(
				availablePartners.stream().collect(Collectors.toMap(item -> item.getName(), item -> new Long(0))));

		service.assignDeliveries(deliveries, availablePartners);

	}
}
