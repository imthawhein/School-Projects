// Customer class
class Customer {
    private String name;
    private String phone;
    private String pickupLocation;
    private String dropoffLocation;

    public Customer(String name, String phone, String pickupLocation, String dropoffLocation) {
        this.name = name;
        this.phone = phone;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }
}