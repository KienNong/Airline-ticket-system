package source;
import java.util.Scanner;

public class order {
    private String orderID;
    private String reservationTicketID;
    private String customerID;
    private String staffID;
    private String day;
    private int intoMoney;
    private int totalNumberOfSeats;
    public order(){}
    public order(String oID, String rtID, String cID, String stID, String day){
        this.orderID = oID;
        this.reservationTicketID = rtID;
        this.customerID = cID;
        this.staffID = stID;
        this.day = day;
    }
    public order(order o){
        this.orderID = o.orderID;
        this.reservationTicketID = o.reservationTicketID;
        this.customerID = o.customerID;
        this.staffID = o.staffID;
        this.day = o.day;
    }
    
    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
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
    public String getStaffID() {
        return staffID;
    }
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public int getIntoMoney() {
        return intoMoney;
    }
    public void setIntoMoney(int intoMoney) {
        this.intoMoney = intoMoney;
    }
    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }
    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }
    public void input(){
		Scanner in = new Scanner(System.in);
		System.out.println("Input order ID: ");
		orderID = in.nextLine();
		System.out.println("Input reservation ticket ID: ");
		reservationTicketID = in.nextLine();
		System.out.println("Input customer ID: ");
		customerID = in.nextLine();
		System.out.println("Input staff ID: ");
		staffID = in.nextLine();
		System.out.println("Input day: ");
		day = in.nextLine();
	}
    public void output() {
        System.out.print("|" + orderID + outputTable(orderID,12) + reservationTicketID + outputTable(reservationTicketID,17) + customerID + outputTable(customerID,14) + staffID + outputTable(staffID,13) + day + outputTable(day,19));
        System.out.println(totalNumberOfSeats + outputTable(Integer.toString(totalNumberOfSeats),12) + intoMoney + outputTable(Integer.toString(intoMoney),18));
        System.out.println("|------------|------------------|---------------|--------------|--------------------|-------------|-------------------|");
    }
    public String outputTable(String m, int n){
        String s="";
		for(int i=0;i<n-m.length();i++){
			s = s + " ";
        }		
		s = s + "|" + " ";
		return s;
    }
}
