package source;
import java.util.Scanner;

public class customerGo extends customer{
    private String ticketID;
    private String seatID;
    private String flightID;
    private String visa;
    public customerGo(){
        super();
        this.ticketID = "N/A";
        this.seatID = "N/A";
        this.flightID = "N/A";
        this.visa = "N/A";
    }
    public customerGo(String id, String sn, String n, String cmnd, String p, String v){
        super(id, sn, n, cmnd, p);
        this.visa = v;
    }
    public String getTicketID() {
        return ticketID;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public String getSeatID() {
        return seatID;
    }
    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }
    public String getFlightID() {
        return flightID;
    }
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    public String getVisa() {
        return visa;
    }
    public void setVisa(String visa) {
        this.visa = visa;
    }
    @Override
    public void input(){
        Scanner in = new Scanner(System.in);
        super.input();
        System.out.println("Input visa: ");
        this.visa = in.nextLine();
    }
    @Override
    public void output(){
        System.out.println("|" + ID + outputTable(ID,17) + surname + " " + name + outputTable(surname + " " + name,20) + cmnd + outputTable(cmnd,23) + phone + outputTable(phone,20) + visa + outputTable(visa,13));
    }
    public String outputTable(String m, int n){
        String s = "";
        for(int i=0; i< n - m.length(); i++){
            s = s + " ";
        }
        s = s + "|";
        return s;
    }
}
