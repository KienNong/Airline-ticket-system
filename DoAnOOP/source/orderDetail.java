package source;
import java.util.Scanner;

public class orderDetail {
    private String ticketClassID;
    private String orderID;
    private String ticketID;
    private int oneTicketPrice;
    public orderDetail(){}
    public orderDetail(String orderID, String ticketID, String ticketClassID, int oneTicketPrice){
        this.ticketClassID = ticketClassID;
        this.orderID = orderID;
        this.ticketID = ticketID;
        this.oneTicketPrice = oneTicketPrice;
    }
    public orderDetail(orderDetail od){
        this.orderID = od.orderID;
        this.ticketClassID = od.ticketClassID;
        this.ticketID = od.ticketID;
        this.oneTicketPrice = od.getOneTicketPrice();
    }
    public String getTicketClassID() {
        return ticketClassID;
    }
    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }
    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public String getTicketID() {
        return ticketID;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public int getOneTicketPrice() {
        return oneTicketPrice;
    }
    public void setOneTicketPrice(int oneTicketPrice) {
        this.oneTicketPrice = oneTicketPrice;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input order ID: ");
        orderID = in.nextLine();
        System.out.println("Input ticket ID: ");
        ticketID = in.nextLine();
        System.out.println("Input ticket class ID: ");
        ticketClassID = in.nextLine();
    }
    public void output(){
        System.out.println("|" + orderID + outputTable(orderID,14) + ticketID + outputTable(ticketID,13) + ticketClassID + outputTable(ticketClassID,15)+ oneTicketPrice + outputTable(Integer.toString(oneTicketPrice),22));
		System.out.println("|--------------|--------------|----------------|-----------------------|");
    }
    public String outputTable(String m, int n){
        String s = "";
        for(int i=0; i < n-m.length(); i++){
            s = s + " ";
        }
        s = s + "|" + " ";
        return s;
    }
}
