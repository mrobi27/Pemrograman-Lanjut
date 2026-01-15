public class Job {
    public static final double TAX_RATE = 0.10;
    // (R1 belum) Field masih public (belum Encapsulate Field)
    private String customerName;
    private String pickupAddress;
    private String serviceName;
    private double basePrice;

    public Job(String customerName, String pickupAddress, String serviceName, double basePrice) {
        this.customerName = customerName;
        this.pickupAddress = pickupAddress;
        this.serviceName = serviceName;
        this.basePrice = basePrice;
    }

    // (R2 belum) Nama masih singkat: dI (belum Rename Method -> displayInfo)
    public void displayInfo() {
        System.out.println("Customer Name  : " + getCustomerName());
        System.out.println("Pickup Address : " + getPickupAddress());
        System.out.println("Service        : " + getServiceName());
        System.out.println("Base Price     : " + getBasePrice());

        // (R3 & R4 belum) Magic number 0.10 & hitung final price masih inline (belum Extract Method) dan ada inline variable
        System.out.println("Final Price    : " + calculateFinalPrice());
    }

    private double calculateFinalPrice() {
        return getBasePrice() + getBasePrice() * TAX_RATE;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
