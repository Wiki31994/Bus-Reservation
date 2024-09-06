import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerList c1 = new CustomerList();
        BusList b1 = new BusList();
        ReservationList r1 = new ReservationList();
        WaitingList w1 = new WaitingList();
        Scanner obj = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== BUS SEAT RESERVATION SYSTEM =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Show Registered Customers");
            System.out.println("3. Register Bus");
            System.out.println("4. Show Registered Buses");
            System.out.println("5. Search for a Bus");
            System.out.println("6. Add Reservation");
            System.out.println("7. Show Reservations");
            System.out.println("8. Cancel Reservation");
            System.out.println("9. Request for a Seat");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = obj.nextInt();
            obj.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = obj.nextLine();
                    System.out.print("Enter mobile number: ");
                    String mobileNumber = obj.nextLine();
                    System.out.print("Enter email: ");
                    String email = obj.nextLine();
                    System.out.print("Enter city: ");
                    String city = obj.nextLine();
                    System.out.print("Enter age: ");
                    int age = obj.nextInt();
                    obj.nextLine(); // Consume newline
                    c1.registerCustomer(name, mobileNumber, email, city, age);
                    break;

                case 2:
                    System.out.println("*******CUSTOMER DETAILS*******");
                    c1.showRegisteredCustomers();
                    break;

                case 3:
                    System.out.print("Enter bus number: ");
                    String busNumber = obj.nextLine();
                    System.out.print("Enter total seats: ");
                    int totalSeats = obj.nextInt();
                    obj.nextLine(); // Consume newline
                    System.out.print("Enter starting point: ");
                    String startingPoint = obj.nextLine();
                    System.out.print("Enter ending point: ");
                    String endingPoint = obj.nextLine();
                    System.out.print("Enter starting time: ");
                    float startingTime = obj.nextFloat();
                    System.out.print("Enter fare: ");
                    float fare = obj.nextFloat();
                    System.out.print("Enter available seats: ");
                    int availableSeats = obj.nextInt();
                    obj.nextLine(); // Consume newline
                    b1.registerBus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare, availableSeats);
                    break;

                case 4:
                    System.out.println("*******RESERVATION DETAILS*******");
                    b1.showBuses();
                    break;

                case 5:
                    System.out.print("Enter bus number to search: ");
                    String searchBusNumber = obj.nextLine();
                    b1.searchBus(searchBusNumber);
                    break;

                case 6:
                    System.out.print("Enter mobile number: ");
                    String tel = obj.next();
                    String na = c1.searchCustomer(tel);
                    if (na=="null") {
                        System.out.println("Invalid Customer");
                    } else {
                        System.out.print("Enter bus number: ");
                        String busNo = obj.next();
                        float fareVal = b1.searchFare(busNo);
                        if (fareVal > 0) {
                            int val = b1.searchSeats(busNo);
                            if (val == 0) {
                                System.out.println("All Seats are Booked");
                                w1.add(busNo, tel);
                                System.out.println("Your Reservation is Added to the Waiting List");
                                w1.show();
                            } else if (val == -1) {
                                System.out.println("Wrong Bus Number");
                            } else {
                                r1.addReservation(busNo, tel, na, fareVal);
                                System.out.println("Reservation is Added");
                            }
                        } else {
                            System.out.println("Invalid Bus Number");
                        }
                    }
                    break;

                case 7:
                    System.out.println("*******RESERVATION DETAILS*******");
                    r1.showReservation();
                    break;

                case 8:
                    System.out.print("Enter mobile number: ");
                    String mobile = obj.next();
                    boolean searchMobile = r1.searchMobile(mobile);
                    if (!searchMobile) {
                        System.out.println("No Reservations for this Mobile Number");
                    } else {
                        System.out.print("Enter bus number: ");
                        String busNo = obj.next();
                        boolean searchBus = r1.searchBus(busNo);
                        if (!searchBus) {
                            System.out.println("No Reservations for this Bus Number");
                        } else {
                            ReservationNode r = r1.deleteReservation(busNo);
                            if (r == null) {
                                System.out.println("Reservation List is Empty");
                            } else {
                                System.out.println("Reservation Cancelled");
                            }
                            WaitingNode w = w1.deleteWaiting();
                            if (w == null) {
                                System.out.println("Waiting List is Empty");
                            } else {
                                System.out.println("Bus Number " + w.busNumber + " and Mobile Number " + w.mobileNumber + " Deleted from Waiting List");
                                float fareValue = b1.searchFare(w.busNumber);
                                String nameValue = c1.searchCustomer(w.mobileNumber);
                                r1.addReservation(w.busNumber, w.mobileNumber, nameValue, fareValue);
                                System.out.println("Reservation is Added");
                            }
                        }
                    }
                    break;

                case 9:
                    System.out.print("Enter Bus Number: ");
                    busNumber = obj.nextLine();
                    b1.requestSeat(busNumber);
                    break;

                case 10:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 10);
        obj.close();
    }
}
