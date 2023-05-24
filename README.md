# RoofTop
-To Run the project import from eclipse> General>Existing Project into workspace>finish

-Define the necessary classes:
1. Order: Represents an item with attributes such as ID, name, orderTime, etc.
2. Delivery: Represents a delivery with attributes including a orders, delivery time, assigned delivery partner, etc.
3. DeliveryPartner: Represents a delivery partner with attributes like ID, name, capacity, etc.

-Create a method to assign deliveries to the delivery partners. This method can accept a list of deliveries, as well as a list of available delivery partners. It should iterate over the deliveries and assign them to the available partners based on their availability and delivery times.

-Sort the Orders as per time to assign DeliveryPartners to achive first come first serve basis.

-In main program or entry point, create instances of items, delivery partners, and deliveries, populate them with data, and call the assignDeliveries method to assign deliveries to the available partners.

-This approach iterates over the deliveries and finds the first available delivery partner with specific time availability to handle the delivery. If a partner is found, the delivery is assigned to them, and their time is being register in map(also we can maintain logs in Database). You can customize the logic within the findAvailablePartner method to incorporate any additional criteria or constraints.

-To adjust the logic based on your specific requirements and handle scenarios such as capacities, when no available partner is found or when the partners' capacities are fully utilized' etc.
