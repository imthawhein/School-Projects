import javax.swing.JOptionPane;

// Base class Ride
public class Ride {
    private Customer customer;
    private Driver driver;
    private boolean isCompleted;
	private double rate;

    // Constructor
    public Ride(Customer customer, Driver driver) {
        this.customer = customer;
        this.driver = driver;
        this.isCompleted = false;
    }

    // Book ride method
    public void bookRide() {
        JOptionPane.showMessageDialog(null, "Ride booked for customer: " + customer.getName());
    }

    // Complete ride method
    public void completeRide() {
        this.isCompleted = true;
        JOptionPane.showMessageDialog(null, "Ride completed.");
    }

    // Calculate fare method
    public double calculateFare(double rate, double distance) {
        this.rate = rate;
        return rate * distance;
    }

    // Display ride details method
    public void displayRideDetails() {
        String message = "Driver: " + driver.getName() + " (Rating: " + driver.getRating() + ")\n"
                       + "Customer: " + customer.getName() + " (Phone: " + customer.getPhone() + ")\n"
                       + "Pickup Location: " + customer.getPickupLocation() + "\n"
                       + "Dropoff Location: " + customer.getDropoffLocation();
        JOptionPane.showMessageDialog(null, message);
    }

    // Get distance between locations
    public static double getDistance(String pickup, String dropoff) {
        if (pickup.equals(dropoff)) {
            return 0.0;
        }

        // Define distances between locations
        double[][] distances = {
            // Siam Paragon distances to other locations
            {0.0, 1.0, 1.2, 8.5, 6.0, 6.5, 4.2, 3.8, 6.2, 2.5, 5.5, 1.8},
            // Central World distances to other locations
            {1.0, 0.0, 1.5, 8.0, 5.5, 6.0, 4.0, 3.5, 6.0, 2.0, 5.0, 1.5},
            // MBK Center distances to other locations
            {1.2, 1.5, 0.0, 8.3, 5.8, 6.2, 4.5, 4.0, 6.3, 2.2, 5.3, 1.7},
            // Chatuchak Market distances to other locations
            {8.5, 8.0, 8.3, 0.0, 7.5, 13.0, 10.0, 9.5, 11.0, 9.0, 12.0, 8.5},
            // Khaosan Road distances to other locations
            {6.0, 5.5, 5.8, 7.5, 0.0, 8.5, 6.5, 6.0, 1.5, 5.5, 1.0, 5.2},
            // Asiatique distances to other locations
            {6.5, 6.0, 6.2, 13.0, 8.5, 0.0, 4.0, 3.5, 8.7, 6.2, 9.0, 5.8},
            // Terminal 21 distances to other locations
            {4.2, 4.0, 4.5, 10.0, 6.5, 4.0, 0.0, 1.5, 7.2, 2.5, 6.5, 3.2},
            // Baiyoke Tower distances to other locations
            {3.8, 3.5, 4.0, 9.5, 6.0, 3.5, 1.5, 0.0, 6.8, 2.0, 6.0, 2.8},
            // Grand Palace distances to other locations
            {6.2, 6.0, 6.3, 11.0, 1.5, 8.7, 7.2, 6.8, 0.0, 6.3, 2.2, 5.5},
            // Lumpini Park distances to other locations
            {2.5, 2.0, 2.2, 9.0, 5.5, 6.2, 2.5, 2.0, 6.3, 0.0, 5.7, 2.2},
            // Wat Arun distances to other locations
            {5.5, 5.0, 5.3, 12.0, 1.0, 9.0, 6.5, 6.0, 2.2, 5.7, 0.0, 5.0},
            // Erawan Shrine distances to other locations
            {1.8, 1.5, 1.7, 8.5, 5.2, 5.8, 3.2, 2.8, 5.5, 2.2, 5.0, 0.0}
        };

        // Location indices
        String[] locations = {
            "Siam Paragon", "Central World", "MBK Center", "Chatuchak Market", "Khaosan Road",
            "Asiatique", "Terminal 21", "Baiyoke Tower", "Grand Palace", "Lumpini Park",
            "Wat Arun", "Erawan Shrine"
        };

        int pickupIndex = -1, dropoffIndex = -1;
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].equals(pickup)) {
                pickupIndex = i;
            }
            if (locations[i].equals(dropoff)) {
                dropoffIndex = i;
            }
        }

        if (pickupIndex != -1 && dropoffIndex != -1) {
            return distances[pickupIndex][dropoffIndex];
        }

        return 0.0;
    }
}