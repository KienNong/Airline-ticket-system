package source;
import java.util.Scanner;

public class domesticTicket extends ticket{
    private String coupon, ticketClassID;
    private double discount;
    public void notification(){
        System.out.println("Please! Passengers traveling within the country will receive a discount on the ticket price depending on the discount code entered!");
    }
    public domesticTicket(String tID, String sID, String cID, String fID, String type, String brand, String oID, String discount){
        super(tID, sID, cID, fID, type, brand, oID);
        this.coupon = discount;
    }
    public domesticTicket(){}
    
    public String getCoupon() {
        return coupon;
    }
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
    public String getTicketClassID() {
        return ticketClassID;
    }
    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    @Override
    public void input(){
        Scanner in = new Scanner (System.in);
        super.input();
        String hasCoupon;
        System.out.println("Co ma giam gia (Y/N)?");
        hasCoupon = in.nextLine();
        if (hasCoupon.equals("Y") || hasCoupon.equals("y")){
            in = new Scanner (System.in);
            System.out.println("Input discount: ");
            coupon = in.nextLine();
            if(this.coupon.equals("GIAM10") || this.coupon.equals("GIAM20") || this.coupon.equals("GIAM50"))
                this.setPrice(this.price - (this.price * (int)discount()));
            else{
                System.out.println("Invalid discount code");
                this.coupon = "N/A";
            }
        }
        else{
            System.out.println("- No discount code -");
            this.coupon = "N/A";
        }
    }
    private double discount(){
        switch (coupon) {
            case "N/A" :{
                discount = 0;
                break;
            }
            case "GIAM10":{
                discount = 0.1;
                break;
            }
            case "GIAM20":{
                discount = 0.2;
                break;
            }
            case "GIAM50":{
                discount = 0.5;
                break;
            }
        }
        return discount;
    }
    public void discountCalculation(){
        this.setPrice(this.price - (int)(this.price * discount()));
    }
    @Override
    public void output(){
        System.out.println("|" + ticketID + outputTable(ticketID,10) + customerID + outputTable(customerID,17) + seatID + outputTable(seatID,8) + orderID + outputTable(orderID,12) + flightID + outputTable(flightID,16) + brand + outputTable(brand,25) + type + outputTable(type,17) + coupon + outputTable(coupon,23));
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
