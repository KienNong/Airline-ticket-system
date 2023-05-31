package source;
import java.util.Scanner;
public class foreignTicket extends ticket{
    private String visa;
    public void notification(){
        System.out.println("Please! Passengers booking flight tickets need to bring their passports for immigration procedures!");
    }
    public foreignTicket(String ticketID, String seatID, String customerID, String flightID, String type, String brand, String orderID, String visa){
        super(ticketID, seatID, customerID, flightID,type, brand, orderID);
        this.visa = visa;
    }
    public foreignTicket(){}
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
        visa = in.nextLine();
    }
    @Override
    public void output(){
        System.out.println("|" + ticketID + outputTable(ticketID,10) + customerID + outputTable(customerID,17) + seatID + outputTable(seatID,8) + orderID + outputTable(orderID,12)+flightID + outputTable(flightID,16) + brand + outputTable(brand,25) + type + outputTable(type,17) + visa + outputTable(visa,23));
    	System.out.println("|----------|-----------------|--------|------------|----------------|-------------------------|-----------------|-----------------------|");
    }
    public String outputTable(String m,int n){
		String s = "";
		for(int i=0; i < n-m.length(); i++){
			s = s + " ";
		}
		s = s + "|";
		return s;
	}

}
