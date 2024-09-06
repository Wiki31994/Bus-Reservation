public class ReservationList {
	ReservationNode head, tail;

public void init()
{
	head = null;
	tail = null;
}
public void addReservation(String busNumber, String mobileNumber, String name, float fare){
	ReservationNode r1 = new ReservationNode(busNumber, mobileNumber, name, fare);
	if(head ==null){
		head=r1;
		tail=r1;
		tail.next=null;
	}
	else {
		tail.next=r1;
		r1.next=null;
		tail=r1;
	}
	
} //End Add Reservation

public void showReservation(){
	ReservationNode r1 = head;
	System.out.println("Bus Number \t Mobile No \t Name \t Fare\t");
	while (r1 != null)
	{
		System.out.println(r1.busNumber +"\t" +r1.mobileNumber +"\t" +r1.name +"\t" +r1.fare +"\t");
		r1 = r1.next;
	}

}//End Show Method 

public boolean searchMobile(String mobileNumber){
	ReservationNode n;
	n=head;
	boolean found=false;
	while(n !=null && found==false){
		if (mobileNumber.equals(n.mobileNumber))
			found=true;
	else
		n=n.next;
	}
	if (found==true)
		return true;
	else
		return false;
}

public boolean searchBus(String busNumber){
	ReservationNode n;
	n=head;
	boolean found=false;
	while(n !=null && found==false){
		if (busNumber.equals(busNumber))
			found=true;
		else
			n=n.next;
	}
	if (found==true)
		return true;
	else
		return false;
}

public ReservationNode deleteReservation(String busNumber)
{
	if(head==null)
	{
		return null;
	}
	else //Some Other Node
	{
		ReservationNode p=head;
		head=head.next;
		return p;
	}
}
}
