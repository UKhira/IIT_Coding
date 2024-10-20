public interface DeliveryService {

        double calculateDeliveryCost(double weight, double distance);
        void trackDelivery(String trackingNumber);
}
