public class CustomerNode {
    String name;
    String mobileNumber;
    String email;
    String city;
    int age;
    CustomerNode next;

    public CustomerNode(String name, String mobileNumber, String email, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
        this.age = age;
        this.next = null;
    }
}
