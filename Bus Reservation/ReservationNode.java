public class ReservationNode {
    String busNumber;
    String mobileNumber;
    String name;
    float fare;
    ReservationNode next;

    public ReservationNode(String busNumber, String mobileNumber, String name, float fare) {
        this.busNumber = busNumber;
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.fare = fare;
        this.next = null;
    }
}
