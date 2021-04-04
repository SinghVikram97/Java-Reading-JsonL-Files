public class Address {
    private String houseName;
    private int floor;
    private String city;
    private String state;
    private int pinCode;

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
