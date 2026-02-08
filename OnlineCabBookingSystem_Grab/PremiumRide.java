import javax.swing.*;

// Separate class PremiumRide
class PremiumRide {
    private Customer customer;
    private Driver driver;
    private double additionalCharge;
    private boolean isCompleted;
	private double rate;

    // Constructor
    public PremiumRide(Customer customer, Driver driver, double additionalCharge) {
        this.customer = customer;
        this.driver = driver;
        this.additionalCharge = additionalCharge;
        this.isCompleted = false;
    }

    // Book ride method
    public void bookRide() {
        JOptionPane.showMessageDialog(null, "Premium ride booked for customer: " + customer.getName());
    }

    // Complete ride method
    public void completeRide() {
        this.isCompleted = true;
        JOptionPane.showMessageDialog(null, "Premium ride completed.");
    }

    // Calculate fare method
    public double calculateFare(double rate, double distance) {
    	this.rate = rate;
        return (rate + additionalCharge) * distance;
    }

    // Display ride details method
    public void displayRideDetails() {
        String message = "Driver: " + driver.getName() + " (Rating: " + driver.getRating() + ")\n"
                       + "Customer: " + customer.getName() + " (Phone: " + customer.getPhone() + ")\n"
                       + "Pickup Location: " + customer.getPickupLocation() + "\n"
                       + "Dropoff Location: " + customer.getDropoffLocation();
        JOptionPane.showMessageDialog(null, message);
    }
}