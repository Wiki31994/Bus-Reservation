public class BusNode {
    String busNumber;
    int totalSeats;
    String startingPoint;
    String endingPoint;
    float startingTime;
    float fare;
    int availableSeats;
    BusNode next;

    public BusNode(String busNumber, int totalSeats, String startingPoint, String endingPoint,
                float startingTime, float fare, int availableSeats) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.availableSeats = availableSeats;
        this.next = null;
    }
}
