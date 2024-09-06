public class CustomerList {
    CustomerNode head, tail;

    public void registerCustomer(String name, String mobileNumber, String email, String city, int age) {
        CustomerNode n1 = new CustomerNode(name, mobileNumber, email, city, age);
        if (head == null) {
            head = n1;
            tail = n1;
            tail.next=null;
        } else {
            tail.next = n1;
            n1.next=null;
            tail = n1;
        }
        
    }//End Register

    public void showRegisteredCustomers() {
        CustomerNode current = head;
        System.out.println("Name "+"\t"+"Mobile Number "+"\t"+"Email "+"\t"+"City "+"\t"+"Age "+"\t");
        while (current != null) {
            System.out.println(current.name+"\t" +current.mobileNumber+"\t" +current.email+"\t" +current.city+"\t" +current.age+"\t");
            current = current.next;
        }
    }//End Show Method

    public String searchCustomer(String mobileNumber)
    {
        CustomerNode n;
        n = head;
        boolean found;
        found = false;
        while (n !=null && found==false)
        {
            if(mobileNumber.equals( n.mobileNumber))
                found=true;
            else 
                n=n.next;
        }//End While 
        if(found==true){
            return n.name;
        }
        else{
            return("null");
        }
    }

}