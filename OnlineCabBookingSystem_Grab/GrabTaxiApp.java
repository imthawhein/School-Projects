// Importing necessary packages
import javax.swing.JOptionPane;

//Main application class
public class GrabTaxiApp {

 public static void main(String[] args) {
     String customerName = JOptionPane.showInputDialog("Enter your name:");
     if(customerName == null) {
    	 return;
     }
     while(customerName.equals("")) {
    	 customerName = JOptionPane.showInputDialog("Please do not leave blank.\nEnter your name:");
     }
     String customerPhone = JOptionPane.showInputDialog("Enter your phone number:");
     if(customerPhone == null) {
    	 return;
     }
     while(customerPhone.equals("")) {
    	 customerPhone = JOptionPane.showInputDialog("Please do not leave blank.\nEnter your phone number:");
     }
     
     String[] locations = {
         "Siam Paragon", "Central World", "MBK Center", "Chatuchak Market", "Khaosan Road",
         "Asiatique", "Terminal 21", "Baiyoke Tower", "Grand Palace", "Lumpini Park",
         "Wat Arun", "Erawan Shrine"
     };
     String pickupLocation = (String) JOptionPane.showInputDialog(null, "Select your pick-up location:", "Pick-up Location", JOptionPane.QUESTION_MESSAGE, null, locations, locations[0]);
     String dropoffLocation = (String) JOptionPane.showInputDialog(null, "Select your drop-off location:", "Drop-off Location", JOptionPane.QUESTION_MESSAGE, null, locations, locations[0]);

     Customer customer = new Customer(customerName, customerPhone, pickupLocation, dropoffLocation);

     String[] options = {"Standard Ride", "Premium Ride", "Bike Ride"};
     int rideType = JOptionPane.showOptionDialog(null, "Welcome to Grab Taxi!\nSelect your ride type:", "Ride Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
     
     String waitMessage = "Please wait for a moment.\nYour ride will be arriving soon.";

     Ride ride;
     PremiumRide pride;
     BikeRide bride;
     
     if (rideType == 1) {
    	 Driver pdriver = new Driver("John Doe", "3P 9028", 4.7);
         pride = new PremiumRide(customer, pdriver, 10.0);
         pride.bookRide();
         JOptionPane.showMessageDialog(null, waitMessage);
         pride.displayRideDetails();

         for (int i = 0; i < 3; i++) {
             System.out.println("Ride in progress...");
         }
         pride.completeRide();

         double rate = (rideType == 0) ? 50.0 : (rideType == 1) ? 75.0 : 30.0; // rates in THB
         double distance = Ride.getDistance(pickupLocation, dropoffLocation);
         double fare = pride.calculateFare(rate, distance);
         
         JOptionPane.showMessageDialog(null, "Total Fare: " + fare +" Baht");
     } else if (rideType == 2) {
    	 Driver bdriver = new Driver("David Korr", "1B 3260", 4.5);
         bride = new BikeRide(customer, bdriver, 5.0);
         bride.bookRide();
         JOptionPane.showMessageDialog(null, waitMessage);
         bride.displayRideDetails();

         for (int i = 0; i < 3; i++) {
             System.out.println("Ride in progress...");
         }
         bride.completeRide();

         double rate = (rideType == 0) ? 50.0 : (rideType == 1) ? 75.0 : 30.0; // rates in THB
         double distance = Ride.getDistance(pickupLocation, dropoffLocation);
         double fare = bride.calculateFare(rate, distance);
         
         JOptionPane.showMessageDialog(null, "Total Fare: " + fare +" Baht");
     } else {
    	 Driver driver = new Driver("Brian Smith", "7N 9910", 4.8);
         ride = new Ride(customer, driver);
         ride.bookRide();
         JOptionPane.showMessageDialog(null, waitMessage);
         ride.displayRideDetails();

         for (int i = 0; i < 3; i++) {
             System.out.println("Ride in progress...");
         }
         ride.completeRide();

         double rate = (rideType == 0) ? 50.0 : (rideType == 1) ? 75.0 : 30.0; // rates in THB
         double distance = Ride.getDistance(pickupLocation, dropoffLocation);
         double fare = ride.calculateFare(rate, distance);
         
         JOptionPane.showMessageDialog(null, "Total Fare: " + fare +" Baht");
     }
 }
}
