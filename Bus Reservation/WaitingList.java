class WaitingList{
	WaitingNode head,tail;

	void add(String no, String mobileNumber){
		WaitingNode n1=new WaitingNode(no,mobileNumber);
		if(head==null){
			head=n1;
			tail=n1;
			tail.next=null;
		}
		else{
			tail.next=n1;
			n1.next=null;
			tail=n1;
		}
	}//End Register

	public void show(){
		WaitingNode n=head;
		System.out.println("Bus No"+"\t"+"Mobile \n Number"+"\t");
		while(n !=null)
		{
			System.out.println(n.busNumber+"\t"+n.mobileNumber+"\t");
			n=n.next;
		}
	}//End Show Method

	public WaitingNode deleteWaiting(){
		if(head==null)
		{
			return null;
		}
		else
		{
			WaitingNode p=head;
			head=head.next;
			return p;
		}
	}
}
