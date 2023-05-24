package testPro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testPro.dto.Delivery;
import testPro.dto.DeliveryPartner;

//Delivery Service
public class DeliveryPartnerService {

	Map<String, Long> deliveryPartnerMap = new HashMap<String, Long>();

	public DeliveryPartnerService(Map<String, Long> deliveryPartnerMap) {
		this.deliveryPartnerMap = deliveryPartnerMap;
	}

	public void assignDeliveries(List<Delivery> deliveries, List<DeliveryPartner> availablePartners) {
		for (Delivery delivery : deliveries) {
			DeliveryPartner partner = findAvailablePartner(delivery, availablePartners);
			if (partner != null) {
				delivery.setAssignedPartner(partner);
				partner.setCapacity(partner.getCapacity() - 1);
			} else {
				// case when no available partner is found for the delivery
				System.out.println(delivery.getItems().getName() + " - No Food :-(");
			}
		}
	}

	private DeliveryPartner findAvailablePartner(Delivery delivery, List<DeliveryPartner> availablePartners) {

		long deliveryTime = delivery.getDeliveryTime() + delivery.getItems().getOrderTime();

		for (DeliveryPartner partner : availablePartners) {
//			System.out.println(" ::::: " + deliveryPartnerMap.get(partner.getName()) + " :: " + partner.getName()
//					+ " :: " + delivery.getItems().getOrderTime());
			if (deliveryPartnerMap.get(partner.getName()) <= delivery.getItems().getOrderTime()) {
				deliveryPartnerMap.put(partner.getName(), deliveryTime);
				System.out.println(delivery.getItems().getName() + " - " + partner.getName());
				return partner;
			}
		}

		return null; // No available partner found
	}

}
