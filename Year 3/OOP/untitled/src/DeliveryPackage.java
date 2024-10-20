public abstract class DeliveryPackage implements DeliveryService{

        protected String deliveryType;

        public DeliveryPackage(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        // Shared tracking behavior
        @Override
        public void trackDelivery(String trackingNumber) {
            System.out.println("Tracking " + deliveryType + " delivery. Tracking number: " + trackingNumber);
        }

        // Enforce each delivery type to implement its own cost calculation
        public abstract double calculateDeliveryCost(double weight, double distance);
    }

}
