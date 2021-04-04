import java.beans.Transient;
import java.util.Date;

public class Staff {
    private String name;
    private int age;
    private Address address;
    private Date dateOfJoining;

    public Staff(String name, int age, Address address, Date dataOfJoining) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.dateOfJoining = dataOfJoining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDataOfJoining() {
        return dateOfJoining;
    }


    public void setDataOfJoining(Date dataOfJoining) {
        this.dateOfJoining = dataOfJoining;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
