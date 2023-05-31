package source;
import java.util.Scanner;

public class ticketClass {
    private String ticketClassID;
    private String ticketClassName;
    public ticketClass(){}
    public ticketClass(String ticketClassID, String ticketClassName){
        this.ticketClassID = ticketClassID;
        this.ticketClassName = ticketClassName;
    }
    public ticketClass(ticketClass tc){
        this.ticketClassID = tc.ticketClassID;
        this.ticketClassName = tc.ticketClassName;
    }
    public String getTicketClassID() {
        return ticketClassID;
    }
    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }
    public String getTicketClassName() {
        return ticketClassName;
    }
    public void setTicketClassName(String ticketClassName) {
        this.ticketClassName = ticketClassName;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("- Select ticket class ID and ticket class name -");
        System.out.println("1. FC\tFirst Class");
        System.out.println("2. BC\tBusiness Class");
        System.out.println("3. PC\tPremium Class");
        System.out.println("4. EC\tEconomy Class");
        System.out.println("Input your selection: ");
        int choose = in.nextInt();
        while (choose < 1 || choose > 4){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch (choose) {
            case 1:{
                ticketClassID = "FC";
                ticketClassName = "First Class";
                break;
            }
            case 2:{
                ticketClassID = "BC";
                ticketClassName = "Business Class";
                break;
            }
            case 3:{
                ticketClassID = "PC";
                ticketClassName = "Premium Class";
                break;
            }
            case 4:{
                ticketClassID = "EC";
                ticketClassName = "Economy Class";
                break;
            }
        }
    }
    public void output(){
        System.out.println("|" + ticketClassID + outputTable(ticketClassID,12) + ticketClassName + outputTable(ticketClassName,15));
		System.out.println("|------------|----------------|");
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
