public class WaitingNode {
    String busNumber;
    String mobileNumber;
    WaitingNode next;

    public WaitingNode(String busNumber, String mobileNumber) {
        this.busNumber = busNumber;
        this.mobileNumber = mobileNumber;
        this.next = null;
    }
}
