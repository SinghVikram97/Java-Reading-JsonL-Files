import java.time.Instant;

public class Address {
    private String houseName;
    private int floor;
    private String city;
    private String state;
    private int pinCode;
    private Instant instantVar;


    public Address(String houseName, int floor, String city, String state, int pinCode, Instant instantVar) {
        this.houseName = houseName;
        this.floor = floor;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.instantVar = instantVar;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", floor=" + floor +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", instantVar=" + instantVar +
                '}';
    }
}
