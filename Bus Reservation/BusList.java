public class BusList {
    BusNode head, tail;

    public void registerBus(String busNumber, int totalSeats, String startingPoint, String endingPoint, float startingTime, float fare, int availableSeats) {
        BusNode n1 = new BusNode(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare, availableSeats);
        if (head == null) {
            head = n1;
            tail = n1;
            tail.next=null;
        } else {
            tail.next = n1;
            n1.next=null;
            tail = n1;
        }
    }// End Register

    public void showBuses() {
        BusNode current = head;
        System.out.println("Bus Number \t Total Seats \t Starting Point \t Ending Point \t Starting Time \t Fare \t availableSeats");
        while (current != null) {
            System.out.println(current.busNumber + "\t\t" + current.totalSeats + "\t\t" + current.startingPoint + "\t\t" +
                               current.endingPoint + "\t\t" + current.startingTime + "\t\t" + current.fare +"\t\t" + current.availableSeats);
            current = current.next;
        }
    }//End Show Method 

    public float searchFare(String busNumber){
        BusNode n = head;
        boolean found;
        found = false;
        while(n != null && found==false)
        {
            if (busNumber.equals(n.busNumber))
                found = true;
            else
                n=n.next;
        }//End While
        if (found==true){
            return n.fare;
        }
        else
            return 0;
    }

    public int searchSeats(String busNumber)
    {
        BusNode n;
        n = head;
        boolean found;
        found = false;
        while(n != null && found==false)
        {
            if(busNumber.equals(n.busNumber))
                found = true;
            else
                n=n.next;
        } //End While 
        if (found==true){
            if (n.availableSeats!=0){
                n.availableSeats--;
                return 1;
            }
            else{
                return 0;
            }
        }
        else
            return -1;
    }

public void searchBus(String busNumber) {
    BusNode current = head;
    boolean found = false;

    while (current != null) {
        if (busNumber.equals(current.busNumber)) {
            found = true;
            break;
        }
        current = current.next;
    }

    if (found) {
        System.out.println("Total Seats: " + current.totalSeats);
        System.out.println("Starting Position: " + current.startingPoint);
        System.out.println("Ending Position: " + current.endingPoint);
        System.out.println("Starting Time: " + current.startingTime);
        System.out.println("Available Seats: " + current.availableSeats);
    } else {
        System.out.println("Bus Not Found");
    }
}

    public void requestSeat(String busNumber) {
        BusNode n = head;
        boolean found = false;
        while (n != null && !found) {
            if (busNumber.equals(n.busNumber)) {
                found = true;
            } else {
                n = n.next;
            }
        }
        if (found) {
            if (n.availableSeats > 0) {
                n.availableSeats--;
                System.out.println("Seat requested successfully. Remaining available seats: " + n.availableSeats);
            } else {
                System.out.println("No available seats on this bus.");
            }
        } else {
            System.out.println("Bus Not Found");
        }
    }

    public BusNode getHead() {
        return head;
    }

    public void setHead(BusNode head) {
        this.head = head;
    }

}