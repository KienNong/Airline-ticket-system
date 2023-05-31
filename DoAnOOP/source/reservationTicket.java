package source;
import java.util.Scanner;

public class reservationTicket {
    private String reservationTicketID;
    private String customerID;
    private String ticketClassID;
    private int numberOfSeats;
    public reservationTicket(){}
    public reservationTicket(String rtID, String cID, String tcID, int nos){
        this.reservationTicketID = rtID;
        this.customerID = cID;
        this.ticketClassID = tcID;
        this.numberOfSeats = nos;
    }
    public reservationTicket(reservationTicket rt){
        this.reservationTicketID = rt.reservationTicketID;
        this.customerID = rt.customerID;
        this.ticketClassID = rt.ticketClassID;
        this.numberOfSeats = rt.numberOfSeats;
    }
    public String getReservationTicketID() {
        return reservationTicketID;
    }
    public void setReservationTicketID(String reservationTicketID) {
        this.reservationTicketID = reservationTicketID;
    }
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getTicketClassID() {
        return ticketClassID;
    }
    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public void input(){
		Scanner in = new Scanner(System.in);
		System.out.print("Input reservation ticket ID: ");
	    reservationTicketID = in.nextLine();
		System.out.print("Input customer's ID: ");
		customerID = in.nextLine();
		System.out.print("Input ticket class ID: ");
		ticketClassID = in.nextLine();
		System.out.print("Input number of seats: ");
		numberOfSeats = in.nextInt();
	}
    public void output(){
        System.out.println("|" + reservationTicketID + outputTable(reservationTicketID,12) + customerID + outputTable(customerID,14) + ticketClassID + outputTable(ticketClassID,11) + numberOfSeats + outputTable(Integer.toString(numberOfSeats),13));
		System.out.println("|------------|---------------|------------|--------------|");
    }
    public String outputTable(String m,int n){
		String s = "";
		for(int i=0;i<n-m.length();i++){
		    s = s + " ";
        }
		s = s + "|" + " ";
		return s;
	}
}
