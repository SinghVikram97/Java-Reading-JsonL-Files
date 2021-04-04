public class Address {
    private String houseName;
    private int floor;
    private String city;
    private String state;
    private int pinCode;

    public Address(String houseName, int floor, String city, String state, int pinCode) {
        this.houseName = houseName;
        this.floor = floor;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", floor=" + floor +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
