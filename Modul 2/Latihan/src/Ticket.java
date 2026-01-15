
public class Ticket {
    public String passengerName;
    public String startLocation;
    public String destination;
    public double price;

    public Ticket(String passengerName, String startLocation, String destination, double price) {
        this.passengerName = passengerName;
        this.startLocation = startLocation;
        this.destination = destination;
        this.price = price;
    }

    private double calculateFinalPrice() {
        return price + (price * TaxiTicket.TAX_RATE);
    }

    // Method to display basic info passenger and trip
    public void displayInfo() {
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Start Location : " + startLocation);
        System.out.println("Destination    : " + destination);
        System.out.println("Price          : " + price);
        System.out.println("Final Price    : " + calculateFinalPrice()); // Price including 10% tax
    }
}
