import javax.swing.*;

// Separate class BikeRide
class BikeRide {
    private Customer customer;
    private Driver driver;
    private double discount;
    private boolean isCompleted;
	private double rate;

    // Constructor
    public BikeRide(Customer customer, Driver driver, double discount) {
        this.customer = customer;
        this.driver = driver;
        this.discount = discount;
        this.isCompleted = false;
    }

    // Book ride method
    public void bookRide() {
        JOptionPane.showMessageDialog(null, "Bike ride booked for customer: " + customer.getName());
    }

    // Complete ride method
    public void completeRide() {
        this.isCompleted = true;
        JOptionPane.showMessageDialog(null, "Bike ride completed.");
    }

    // Calculate fare method
    public double calculateFare(double rate, double distance) {
        this.rate = rate;
        return (rate - discount) * distance;
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