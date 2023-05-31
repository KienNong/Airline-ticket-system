package source;
import java.util.Scanner;
public abstract class ticket {
    protected String ticketID;
    protected String seatID;
    protected String customerID;
    protected String flightID;
    protected String type;
    protected String brand;
    protected String orderID;
    protected String ticketTypeID;
    protected int price;
    public ticket(){}
    public abstract void notification();
    public ticket(String ticketID, String seatID, String customerID, String flightID, String type, String brand, String orderID){
        this.ticketID = ticketID;
        this.seatID = seatID;
        this.customerID = customerID;
        this.flightID = flightID;
        this.type = type;
        this.brand = brand;
        this.orderID = orderID;
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
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getFlightID() {
        return flightID;
    }
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public String getTicketTypeID() {
        return ticketTypeID;
    }
    public void setTicketTypeID(String ticketTypeID) {
        this.ticketTypeID = ticketTypeID;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("- Ticket's information -");
        System.out.println("- Select airline -");
        System.out.println("1. Vietname Airlines");
        System.out.println("2. VietJet Airlines");
        System.out.println("3. JetStar Pacific Airlines");
        int choose = in.nextInt();
        while (choose < 1 || choose > 3){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch (choose){
            case 1:{
                this.brand = "Vietnam Airlines";
                break;
            }
            case 2:{
                this.brand = "VietJet Air";
                break;
            }
            case 3:{
                this.brand= "JetStar Pacific Airlines";
                break;
            }
        }
        in = new Scanner(System.in);
        System.out.println("Input customer's ID: ");
        this.customerID=in.nextLine();
        System.out.print("Input flight's ID: ");
        this.flightID=in.nextLine();
        System.out.println("- Select ticket class -");
        System.out.println("1. Economy Class");
        System.out.println("2. Business Class");
        System.out.println("3. Premium Class");
        System.out.println("4. First Class");
        System.out.print("Moi ban nhap lua chon: ");
        choose = in.nextInt();
        while (choose < 1 || choose > 4){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch (choose){
            case 1:{
                this.type = "Economy Class";
                break;
            }
            case 2:{
                this.type = "Business Class";
                break;
            }
            case 3:{
                this.type = "Premium Class";
                break;
            }
            case 4:{
                this.type = "First Class";
                break;
            }
        }
        createSeatID();
        in = new Scanner(System.in);
        System.out.println("Input order's ID: ");
        this.orderID=in.nextLine();
        createOrderID();
    }
    public void output(){
        System.out.println("|" + ticketID + outputTable(ticketID,10) + customerID + outputTable(customerID,17) + seatID + outputTable(seatID,8) + orderID + outputTable(orderID,12) + flightID + outputTable(flightID,16) + brand + outputTable(brand,25) + type + outputTable(type,17));
    	System.out.println("|----------|-----------------|--------|------------|----------------|-------------------------|-----------------|-----------------------|");
    }
    public String outputTable(String m,int n){
		String s = "";
		for(int i=0;i<n-m.length();i++){
			s = s + " ";
		}
		s = s + "|";
		return s;
	}
    public String createBrandName(String brand){
        String brandName = "N/A";
        switch(brand){
            case "Vietnam Airlines":{
                brandName = "VNA";
                break;
            }
            case "VietJet Air":{
                brandName = "VJA";
                break;
            }
            case "JetStar Pacific Airlines":{
                brandName = "JSP";
                break;
            }
        }
        return brandName;
    }
    public void createTicketClass(){
        switch (this.type) {
            case "Economy Class": {
                this.ticketTypeID = "EC";
                break;
            }
            case "Business Class": {
                this.ticketTypeID = "BC";
                break;
            }
            case "Premium Class": {
                this.ticketTypeID = "PC";
                break;
            }
            case "First Class": {
                this.ticketTypeID = "FC";
                break;
            }
        }
    }
    public void createTicketID(){
        int rand = (int)(Math.random()*(50-1)+1);
        String strrand = Integer.toString(rand);
        this.ticketID = createBrandName(brand)+strrand;
    }
    public void createSeatID(){
        Scanner in = new Scanner(System.in);
        char seatType = '/';
        int numberOfSeats;
        String strNumberOfSeats;
        switch(type){
            case "Economy Class": {
                char row;
                System.out.println("- Select row A, B or C -");
                row = in.next().charAt(0);
                if (row == 'A'){
                    seatType = 'A';
                }
                else
                    if (row == 'B'){
                        seatType = 'B';
                    }
                    else
                        if(row == 'C'){
                            seatType = 'C';
                        }
                numberOfSeats = (int)(Math.random()*(5-1)+1);
                strNumberOfSeats = Integer.toString(numberOfSeats);
                this.seatID = Character.toString(seatType) + strNumberOfSeats;
                break;
            }
            case "Business Class": {
                seatType = 'T';
                numberOfSeats = (int)(Math.random()*(10-1)+1);
                strNumberOfSeats = Integer.toString(numberOfSeats);
                this.seatID = Character.toString(seatType) + strNumberOfSeats;
                break;
            }
            case "Premium Class": {
                seatType = 'P';
                numberOfSeats = (int)(Math.random()*(10-1)+1);
                strNumberOfSeats = Integer.toString(numberOfSeats);
                this.seatID = Character.toString(seatType) + strNumberOfSeats;
                break;
            }
            case "First Class": {
                seatType = 'F';
                numberOfSeats = (int)(Math.random()*(5-1)+1);
                strNumberOfSeats = Integer.toString(numberOfSeats);
                this.seatID = Character.toString(seatType) + strNumberOfSeats;
                break;
            }
        }
    }
    public void createCustomerID(){
        int rand = (int)(Math.random()*(1000-1)+1);
        this.customerID = "KHM" + Integer.toString(rand);
    }
    public void createFlightID(){
        this.flightID = "N/A";
    }
    public void createOrderID(){
        this.orderID = "HD" + this.customerID;
    }
    public void intoMoney(){
    	priceList prl = new priceList();
		prl.openFile();
		flightList fll = new flightList();
		fll.openFile();
		journeyList jnl = new journeyList();
		jnl.openFile();
		int ticketPrice = 0, journeyPrice = 0;
		for(int j=0;j<prl.getN();j++)
		{
			if(prl.p[j].getTicketClassID().equals(ticketTypeID)){
				ticketPrice = prl.p[j].getTicketClassPrice();			
			}
		}
		String journeyID = "";
		for(int i=0;i<fll.getN();i++)
			if(flightID.equals(fll.f[i].getFlightID()))
				journeyID = fll.f[i].getJourneyID();
		for(int i=0;i<jnl.getN();i++)
			if(journeyID.equals(jnl.j[i].getJourneyID()))
				journeyPrice = jnl.j[i].getPrice();
		this.price=ticketPrice + journeyPrice;
    }


}
