package source;
import java.util.Scanner;

public class price{
    private String ticketClassID;
    private int ticketClassPrice;
    public price(){}
    public price(String ticketClassID, int ticketClassPrice){
        this.ticketClassID = ticketClassID;
        this.ticketClassPrice = ticketClassPrice;
    }
    public price(price p){
        this.ticketClassID = p.ticketClassID;
        this.ticketClassPrice = p.ticketClassPrice;
    }
    public String getTicketClassID() {
        return ticketClassID;
    }
    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }
    public int getTicketClassPrice() {
        return ticketClassPrice;
    }
    public void setTicketClassPrice(int ticketClassPrice) {
        this.ticketClassPrice = ticketClassPrice;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input ticket class ID: ");
        ticketClassID = in.nextLine();
        System.out.println("Input ticket class price: ");
        ticketClassPrice = in.nextInt();
        in.close();
    }
    public void output(){
        System.out.println("|" + ticketClassID + outputTable(ticketClassID,12) + ticketClassPrice + outputTable(Integer.toString(ticketClassPrice),15));
		System.out.println("|------------|----------------|");
    }
    public String outputTable(String m, int n){
        String s = " ";
        for(int i=0;i<n-m.length();i++){
			s=s+" ";
        }
		s = s + "|" + " ";
		return s;
    }
}
