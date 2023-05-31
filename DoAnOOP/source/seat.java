package source;
import java.util.Scanner;

public class seat {
    private String seatID;
    private String planeID;
    private String ticketClassID;
    public seat(){
        planeID = " ";
        ticketClassID = " ";
        seatID = " ";
    }
    public seat(String sID, String pID, String tcID){
        planeID = pID;
        ticketClassID = tcID;
        seatID = sID;
    }
    public seat(seat s){
        planeID = s.planeID;
        ticketClassID = s.ticketClassID;
        seatID = s.seatID;
    }
    public String getSeatID() {
        return seatID;
    }
    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }
    public String getPlaneID() {
        return planeID;
    }
    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }
    public String getTicketClassID() {
        return ticketClassID;
    }
    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
		System.out.print("Input plane ID: ");
		planeID = in.nextLine();
		System.out.print("Input ticket class ID: ");
		ticketClassID = in.nextLine();
		System.out.print("Input seat ID: ");
		seatID = in.nextLine();
    }
    public void output(){
        System.out.println("|" + seatID + outputTable(seatID,12) + planeID + outputTable(planeID,18) + ticketClassID + outputTable(ticketClassID,17));
		System.out.println("|------------|------------------|-----------------|");
    }
    public String outputTable(String m, int n){
        String s = "";
        for(int i=0;i < n - m.length(); i++){
            s = s + " ";
        }
        s = s + "|";
        return s;
    }
}
