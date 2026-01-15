public class LaundryJob extends Job {
    public static final int MIN_RPM = 200;
    public static final double SLOWDOWN_DURATION_FACTOR = 0.2;
    public static final int MAX_RPM = 1200;
    // (R5 belum) Field masih non-private (belum Encapsulate Field)
    private double estimatedMinutes;
    private double machineRpm;

    public LaundryJob(String customerName, String pickupAddress, String serviceName,
                      double basePrice, double estimatedMinutes, double machineRpm) {
        super(customerName, pickupAddress, serviceName, basePrice);
        this.estimatedMinutes = estimatedMinutes;
        this.machineRpm = machineRpm;
        clampRpm();
    }

    // (R2 belum) Nama method masih singkat
    public void checkStatus() { // check status kurir
        System.out.println("Courier is heading to " + getPickupAddress());
    }

    public void displayRoute() { // tampilkan rute
        System.out.println("Route: Warehouse -> " + getPickupAddress());
    }

    public void displayEstimatedDuration() { // estimasi durasi
        System.out.println("Estimated wash duration: " + estimatedMinutes + " minutes");
    }

    private void clampRpm() {
        if (machineRpm < MIN_RPM) {
            machineRpm = MIN_RPM;
        }
        if (machineRpm > MAX_RPM) {  // MAX_RPM (belum jadi konstanta)
            machineRpm = MAX_RPM;
        }
    }

    // (R6 belum) Magic numbers masih dipakai langsung: 200, 1200, 0.2
    public void slowDown(double rpmReduction) {
        machineRpm -= rpmReduction; // MIN_RPM (belum jadi konstanta)
        clampRpm();
        estimatedMinutes += rpmReduction * SLOWDOWN_DURATION_FACTOR; // SLOWDOWN_DURATION_FACTOR (belum konstanta)
        System.out.println("Machine slowed down! Current RPM: " + machineRpm + " rpm");
    }

    public void speedUp(double rpmIncrease) {
        machineRpm += rpmIncrease;
        clampRpm();
        System.out.println("Machine sped up! Current RPM: " + machineRpm + " rpm");
    }

    public void detailedInfo() {
        displayInfo(); // panggil info dari induk (nama masih dI)
        System.out.println("Duration       : " + estimatedMinutes + " minutes");
        System.out.println("Machine Speed  : " + machineRpm + " rpm");
    }
}
