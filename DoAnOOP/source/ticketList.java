package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ticketList implements list{
    private int n;
    public static ticket[] tt = new ticket[100];
    public void input(){
        int type;
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of tickets: ");
        this.n = in.nextInt();
        System.out.println("(1) Domestic ticket");
        System.out.println("(2) Foreign ticket");
        System.out.println("--------------------");
        for(int i=0; i < n; i++){
            System.out.println("--Input information of ticket " + i+1 + "--");
            System.out.println("Ticket type: ");
            type = in.nextInt();
            if (type == 1){
                tt[i] = new domesticTicket();
                ticket tk = new domesticTicket();
                tk.notification();
                tt[i].input();
            }
            else if (type == 2) {
                tt[i] = new foreignTicket();
                ticket tk = new foreignTicket();
                tk.notification();
                tt[i].input();
            }
            System.out.println("--------------------");
        }
    }
    public void output(){
        System.out.println("--------------------------------------------------Ticket list----------------------------------------------------------------------------");
		System.out.println("|----------|-----------------|--------|------------|----------------|-------------------------|-----------------|-----------------------|");
        System.out.println("|Ticket ID |   Customer ID   | SeatID |  OrderID   |    Flight ID   |          brand          |       Type      |      Coupon/VISA      |");
        System.out.println("|----------|-----------------|--------|------------|----------------|-------------------------|-----------------|-----------------------|");
        for (int i = 0; i < n; i++) {
            tt[i].output();
        }
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public static ticket[] getTt() {
        return tt;
    }
    public static void setTt(ticket[] tt) {
        ticketList.tt = tt;
    }
    public static int checkChoose(int choose, int m, int n){
		Scanner in = new Scanner(System.in);
		if(choose < m || choose > n)
		while(choose < m || choose > n){
			System.out.println("Invalid selection! Please re-enter");
			System.out.print("Your re-enter: ");
			choose = in.nextInt();
		}
		return choose;
	}
    public void insertFile(){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\ticket.txt"));
			for(int i=0 ;i<n-1;i++){
				bw.write(tt[i].getTicketID());
				bw.newLine();
				bw.write(tt[i].getSeatID());
				bw.newLine();
				bw.write(tt[i].getCustomerID());
				bw.newLine();
				bw.write(tt[i].getFlightID());
				bw.newLine();
				bw.write(tt[i].getType());
				bw.newLine();
				bw.write(tt[i].getBrand());
				bw.newLine();
				bw.write(tt[i].getOrderID());
				bw.newLine();
				if(tt[i] instanceof domesticTicket){	
					bw.write(((domesticTicket)tt[i]).getCoupon());
					bw.newLine();
				}
				else{	
					bw.write(((foreignTicket)tt[i]).getVisa());
					bw.newLine();
				}
			}
			bw.write(tt[n-1].getTicketID());
			bw.newLine();
			bw.write(tt[n-1].getSeatID());
			bw.newLine();
			bw.write(tt[n-1].getCustomerID());
			bw.newLine();
			bw.write(tt[n-1].getFlightID());
			bw.newLine();
			bw.write(tt[n-1].getType());
			bw.newLine();
			bw.write(tt[n-1].getBrand());
			bw.newLine();
			bw.write(tt[n-1].getOrderID());
			bw.newLine();
			if(tt[n-1] instanceof domesticTicket){	
			    bw.write(((domesticTicket)tt[n-1]).getCoupon());
			}
			else{	
				bw.write(((foreignTicket)tt[n-1]).getVisa());
			}
			bw.close();
		}catch(IOException e) {}
	}
    public void openFile(){    
        int i=0;
        try{
            Scanner sc = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\ticket.txt"));
            try{
                while(sc.hasNextLine()){
                    String []ticketType = new String[3];
                    String ticketID = sc.nextLine();
                    ticketType = ticketID.split("_");
                    String seatID = sc.nextLine();
                    String customerID = sc.nextLine();
                    String flightID = sc.nextLine();
                    String ticketClassName = sc.nextLine();
                    String brand = sc.nextLine();
                    String orderID = sc.nextLine();
                    if(ticketType[0].equals("TN")){
                        String coupon = sc.nextLine();
                        tt[i] = new domesticTicket(ticketID,seatID,customerID,flightID,ticketClassName,brand,orderID,coupon);
                        tt[i].createTicketClass();
                        tt[i].intoMoney();
                        ((domesticTicket)tt[i]).discountCalculation();
                        i++;
                    }
                    else{
                        String visa=sc.nextLine();
                        tt[i]=new foreignTicket(ticketID,seatID,customerID,flightID,ticketClassName,brand,orderID,visa);
                        tt[i].createTicketClass();
                        tt[i].intoMoney();
                        i++;
                    }
                }
            } catch(Exception e) {}
            finally
            {
                n = i;
                sc.close();
            }
        }
        catch(IOException e) {}
    }
    public void addition(){
        int type;
        String ticketID;
        Scanner in = new Scanner (System.in);
        flightList fll = new flightList();
    	fll.openFile();
        System.out.println("--Input information of ticket--");
        System.out.println("(1) Domestic ticket");
        System.out.println("(2) Foreign ticket");
        System.out.println("--------------------");
        System.out.println("Ticket type: ");
        type = in.nextInt();
        if (type==1) {
        	in = new Scanner (System.in);
        	ticket tk = new domesticTicket();
            tk.notification();
        	tt[n] = new domesticTicket();
        	System.out.print("Input ticket ID number: ");
        	ticketID = in.nextLine();
            tt[n].setTicketID("TN_" + ticketID);   
            System.out.println("Your ticket ID: " + tt[n].getTicketID());
            tt[n].input();
        }
        else if (type==2) {
        	in = new Scanner (System.in);
        	ticket tk=new foreignTicket();
            tk.notification();
        	tt[n] = new foreignTicket();
        	System.out.println("Input ticket ID number: ");
        	ticketID = in.nextLine();
            tt[n].setTicketID("NN_" + ticketID);
            System.out.println("Ma ve cua ban la: "+tt[n].getTicketID());
            tt[n].input();
        }
        n++;
        fll.emptySeatsCalculation();
        insertFile();
        System.out.println("Ticket addition was succesful!");
    }
    public void edition(){
        Scanner in = new Scanner (System.in);
        System.out.print("Input ticket ID: ");
        String tkID = in.nextLine();
        int choose;
        for (int i = 0; i < n; i++) {
            if (tkID.equals(tt[i].ticketID)) {
                if (tt[i] instanceof domesticTicket) {
                    System.out.println("-------Select action-------");
                    System.out.println("1. Edit ticket ID");
                    System.out.println("2. Edit ticket class");
                    System.out.println("3. Edit seat ID");
                    System.out.println("4. Edit flight");
                    System.out.println("5. Edit brand");
                    System.out.println("6. Edit coupon");
                    choose = in.nextInt();
                    choose = checkChoose(choose, 1, 6);
                    switch (choose) {
                        case 1: {
                        	in = new Scanner (System.in);
                            String ticketID;
                            System.out.println("Input new ticket ID: ");
                            ticketID = in.nextLine();
                            for (int j = 0; j < n; j++) {
                                if (ticketID.equals(tt[i].getTicketID())){
                                    System.out.println("Ticket ID already existed in the data");
                                    edition();
                                }
                                else {
                                    tt[i].setTicketID(ticketID);
                                    System.out.println("Ticket ID has cbranded to " + tt[i].ticketID);
                                }
                            }
                            insertFile();
                            break;
                        }
                        case 2: {
                        	in = new Scanner (System.in);
                            int ticketClass;
                            System.out.println("Input another ticket class");
                            System.out.println("1. Economy Class");
                            System.out.println("2. Business Class");
                            System.out.println("3. Premium Class");
                            System.out.println("4. First Class");
                            System.out.println("Your selection: ");
                            ticketClass = Integer.parseInt(in.nextLine());
                            ticketClass = checkChoose(ticketClass, 1, 4);
                            switch (ticketClass) {
                                case 1: {
                                    tt[i].type = "Economy Class";
                                    break;
                                }
                                case 2: {
                                    tt[i].type = "Business Class";
                                    break;
                                }
                                case 3: {
                                    tt[i].type = "Premium Class";
                                    break;
                                }
                                case 4: {
                                    tt[i].type = "First Class";
                                    break;
                                }
                            }
                            System.out.println("Ticket "+ tt[i].ticketID + " has changed the ticket class");
                            insertFile();
                            break;
                        }
                        case 3: {
                        	in = new Scanner (System.in);
                            String newSeatID, seatID;
                            char typeSeat = 'N';
                            switch (tt[i].type){
                                case "Economy Class":{
                                	in = new Scanner (System.in);
                                    char row;
                                    System.out.println("-------A, B or C-------");
                                    System.out.println("Your selection: ");
                                    row = in.next().charAt(0);
                                    if (row == 'A') 
                                        typeSeat = 'A';
                                    else 
                                        if (row == 'B') 
                                            typeSeat = 'B';
                                        else 
                                            if (row == 'C') 
                                                typeSeat = 'C';
                                    System.out.print("Input new seat: ");
                                    newSeatID = in.nextLine();
                                    seatID = typeSeat + newSeatID;
                                    for (int j = 0; j < n; j++) {
                                        if (seatID.equals(tt[i].getSeatID())) {
                                            System.out.println("Seats already registered!");
                                            edition();
                                        }
                                        else {
                                            tt[i].seatID = typeSeat + newSeatID;
                                        }
                                    }
                                    insertFile();
                                    break;
                                }
                                case "Business Class":{
                                	in = new Scanner (System.in);
                                    typeSeat = 'T';
                                    System.out.print("Input new seat ID: ");
                                    newSeatID = in.nextLine();
                                    seatID = typeSeat + newSeatID;
                                    for (int j = 0; j < n; j++) {
                                        if (seatID.equals(tt[i].getSeatID())) {
                                            System.out.println("Seats already registered!");
                                            edition();
                                        }
                                        else {
                                            tt[i].seatID = typeSeat + newSeatID;
                                        }
                                    }
                                    insertFile();
                                    break;
                                }
                                case "Premium Class": {
                                	in = new Scanner (System.in);
                                    typeSeat = 'P';
                                    System.out.print("Input new seat ID: ");
                                    newSeatID = in.nextLine();
                                    seatID = typeSeat + newSeatID;
                                    for (int j = 0; j < n; j++) {
                                        if (seatID.equals(tt[i].getSeatID())) {
                                            System.out.println("Seats already registered!");
                                            edition();
                                        }
                                        else {
                                            tt[i].seatID = typeSeat + newSeatID;
                                        }
                                    }
                                    insertFile();
                                    break;
                                }
                                case "First Class" : {
                                	in = new Scanner (System.in);
                                    typeSeat = 'F';
                                    System.out.print("Input new seat ID: ");
                                    newSeatID = in.nextLine();
                                    seatID = typeSeat + newSeatID;
                                    for (int j = 0; j < n; j++) {
                                        if (seatID.equals(tt[i].getSeatID())) {
                                            System.out.println("Seats already registered!");
                                            edition();
                                        }
                                        else {
                                            tt[i].seatID = typeSeat + newSeatID;
                                        }
                                    }
                                    insertFile();
                                    break;
                                }
                            }
                            System.out.println("Ticket " + tt[i].ticketID + " has changed seat ID!");
                            break;
                        }
                        case 4: {
                        	in = new Scanner (System.in);
                            System.out.println("Input new flight ID: ");
                            String newfID=in.nextLine();
                            for(int j=0;j<n;j++)
                            	if(tt[j].getTicketID().equals(tkID))
                            		tt[j].setFlightID(newfID);
                            System.out.println("Flight ID edition was succesful!");
                            insertFile();
                            break;
                        }
                        case 5: {
                        	in = new Scanner (System.in);
                            System.out.println("Select new brand");
                            System.out.println("1. Vietnam Airlines");
                            System.out.println("2. VietJet Air");
                            System.out.println("3. JetStar Pacific Airlines");
                            System.out.println("Your selection: ");
                            choose = Integer.parseInt (in.nextLine());
                            choose = checkChoose(choose, 1, 3);
                            switch (choose) {
                                case 1: {
                                    tt[i].brand = "Vietnam Airlines";
                                    break;
                                }
                                case 2: {
                                    tt[i].brand = "VietJet Air";
                                    break;
                                }
                                case 3: {
                                    tt[i].brand = "JetStar Pacific Airlines";
                                    break;
                                }
                            }
                            System.out.println("Brand edition was succesful to " + tt[i].brand +"!");
                            insertFile();
                            break;
                        }
                        case 6: {
                        	in = new Scanner (System.in);
                            String coupon;
                            System.out.println("Input new coupon: ");
                            coupon = in.nextLine();
                            ((domesticTicket)tt[i]).setCoupon(coupon);
                            System.out.println("Coupon edition was succesful!");
                            insertFile();
                            break;
                            }
                        }
                    }
                
                else if (tt[i] instanceof foreignTicket) {
                    System.out.println("-------Select action-------");
                    System.out.println("1. Edit ticket ID");
                    System.out.println("2. Edit ticket class");
                    System.out.println("3. Edit seat ID");
                    System.out.println("4. Edit flight");
                    System.out.println("5. Edit brand");
                    System.out.println("6. Edit visa");
                    choose = in.nextInt();
                    checkChoose(choose, 1, 6);
                    switch (choose) {
                        case 1: {
                        	in = new Scanner (System.in);
                            String ticketID;
                            System.out.println("Input new ticket ID: ");
                            ticketID = in.nextLine();
                            tt[i].setTicketID(ticketID);
                            System.out.println("Ticket ID has changed into "+tt[i].ticketID);
                            insertFile();
                            break;
                        }
                        case 2: {
                        	in = new Scanner (System.in);
                            int ticketClass;
                            System.out.println("-------Select new brand-------");
                            System.out.println("1. Economy Class");
                            System.out.println("2. Business Class");
                            System.out.println("3. Premium Class");
                            System.out.println("4. First Class");
                            ticketClass = Integer.parseInt (in.nextLine());
                            ticketClass = checkChoose(ticketClass, 1, 4);
                            switch (ticketClass) {
                                case 1: {
                                    tt[i].type = "Economy Class";
                                    break;
                                }
                                case 2: {
                                    tt[i].type = "Business Class";
                                    break;
                                }
                                case 3: {
                                    tt[i].type = "Premium Class";
                                    break;
                                }
                                case 4: {
                                    tt[i].type = "First Class";
                                    break;
                                }
                            }
                            System.out.println("Ticket " + tt[i].ticketID + " has changed ticket class");
                            insertFile();
                            break;
                        }
                        
                        case 3: {
                        	in = new Scanner (System.in);
                            String seatID;
                            char typeSeat = 'N';
                            switch (tt[i].type) {
                                case "Economy Class": {
                                    char row;
                                    System.out.println("-------A, B or C-------");
                                    row = in.next().charAt(0);
                                    if (row == 'A') 
                                        typeSeat = 'A';
                                    else 
                                        if (row == 'B') 
                                            typeSeat = 'B';
                                        else 
                                            if (row == 'C')
                                                typeSeat = 'C';
                                    System.out.println("Input new seat ID: ");
                                    seatID = in.nextLine();
                                    tt[i].seatID = typeSeat + seatID;
                                    insertFile();
                                    break;
                                }
                                case "Business Class": {
                                    typeSeat = 'T';
                                    System.out.print("Nhap ma ghe thay the: ");
                                    seatID = in.nextLine();
                                    tt[i].seatID = typeSeat + seatID;
                                    
                                    break;
                                }
                                case "Premium Class": {
                                    typeSeat = 'P';
                                    System.out.print("Nhap ma ghe thay the: ");
                                    seatID = in.nextLine();
                                    tt[i].seatID = typeSeat + seatID;
                                   
                                    break;
                                }
                                case "First Class" : {
                                    typeSeat = 'F';
                                    System.out.print("Nhap ma ghe thay the: ");
                                    seatID = in.nextLine();
                                    tt[i].seatID = typeSeat + seatID;
                                    
                                    break;
                                }
                            }
                            System.out.println("Da thay doi ma ghe cho ve "+tt[i].ticketID);
                            insertFile();
                            break;
                        }
                        case 4: {
                            //Thay doi chuyen bay
                        	in = new Scanner (System.in);
                            System.out.println("Input new flight ID: ");
                            String newfID=in.nextLine();
                            for(int j=0;j<n;j++)
                            	if(tt[j].getTicketID().equals(tkID))
                            		tt[j].setFlightID(newfID);
                            System.out.println("Da thay the ma chuyen bay!!!");
                            insertFile();
                            break;
                        }
                        case 5: {
                        	in = new Scanner (System.in);
                            System.out.println("Chon brand brand khong thay the");
                            System.out.println("| 1. Vietnam Airlines         ");
                            System.out.println("| 2. VietJet Air              ");
                            System.out.println("| 3. JetStar Pacific Airlines ");
                            choose = Integer.parseInt (in.nextLine());
                            switch (choose) {
                                case 1: {
                                    tt[i].brand = "Vietnam Airlines";
                                    break;
                                }
                                case 2: {
                                    tt[i].brand = "VietJet Air";
                                    break;
                                }
                                case 3: {
                                    tt[i].brand = "JetStar Pacific Airlines";
                                    break;
                                }
                            }
                            System.out.println("Da thay doi brand brand khong thanh "+tt[i].brand);
                            insertFile();
                            break;
                        }
                        case 6: {
                        	in = new Scanner (System.in);
                            String visa;
                            System.out.println("Nhap so ho chieu thay the: ");
                            visa = in.nextLine();
                            ((foreignTicket)tt[i]).setVisa(visa);
                            System.out.println("Da thay doi so ho chieu.");
                            insertFile();
                            break;
                        }
                    }
                }
            }
        }
    }
    public void deletion(){
        Scanner in = new Scanner (System.in);
        System.out.println("-----Ticket deletion-----");
		System.out.print("Do you want to delete ticket ID? [y/n]: ");
		String k=in.nextLine();
		switch(k){
		    case "y":{
                System.out.print("Nhap ma ve muon xoa: ");
                String ticketID = in.nextLine();
                for(int i=0;i<n;i++)
        	        if(tt[i].getTicketID().equals(ticketID)){
        		        for(int j=i;j<n;j++)
        			        tt[j]=tt[j+1];
        		        n--;
        	        }
                System.out.println("Ticket ID deletion was succesful!");
		        insertFile();
		        break;
		    }
		    case "n":{
			    System.out.println("No deletion!");
			    break;
		    }
		}
    }
    public void search(){
        Scanner in = new Scanner (System.in);
        System.out.println("-------Select action-------");
        System.out.println("1. Search by ticket ID");
        System.out.println("2. Search by brand");
        System.out.println("3. Search by ticket class");
        int choose = in.nextInt();
        choose = checkChoose(choose, 1, 3);
        switch (choose){
            case 1:{
            	in = new Scanner (System.in);
            	int check = 0;
                System.out.println("Input ticket ID: ");
                String tkID = in.nextLine();
                for (int i = 0; i < n; i++) {
                    if (tt[i].getTicketID().equals(tkID)){
                        tt[i].output();
                        check = 1;
                    }
                }
                if (check == 0)
                    System.out.println("Ticket ID not existed in the data!");
                break;
            }
            case 2: {
            	in = new Scanner (System.in);
                System.out.println("Select a brand to search: ");
                System.out.println("1. Vietnam Airlines");
                System.out.println("2. JetStar Pacific Airlines");
                System.out.println("3. VietJet Air");
                choose = in.nextInt();
                choose = checkChoose(choose, 1, 3);
                switch (choose) {
                    case 1: {
                        for (int i = 0; i < n; i++) {
                            if (tt[i].getBrand().equals("Vietnam Airlines"))
                                tt[i].output();
                        }
                        break;
                    }
                    case 2: {
                        for (int i = 0; i < n; i++) {
                            if (tt[i].getBrand().equals("JetStar Pacific Airlines"))
                                tt[i].output();
                        }
                        break;
                    }
                    case 3: {
                        for (int i = 0; i < n; i++) {
                            if (tt[i].getBrand().equals("VietJet Air"))
                                tt[i].output();
                        }
                        break;
                    }
                }
                break;
            }
            case 3: {
            	in = new Scanner (System.in);
                System.out.println("Select ticket class type ID [FC/PC/BC/EC]: ");
                System.out.println("FC: First Class");
                System.out.println("PC: Premium Class");
                System.out.println("BC: Business Class");
                System.out.println("EC: Economy Class");
                System.out.println("Your selection: ");
                String tctype = in.nextLine();
                switch (tctype) {
                    case "FC": {
                        for (int i = 0; i < n; i++) {
                            if (tt[i].getTicketTypeID().equals("FC"))
                                tt[i].output();
                        }
                        break;
                    }
                    case "PC": {
                        for (int i = 0; i < n; i++) {
                            if (tt[i].getTicketTypeID().equals("PC"))
                                tt[i].output();
                        }
                        break;
                    }
                    case "BC": {
                        for (int i = 0; i < n; i++) {
                            if (tt[i].getTicketTypeID().equals("BC")) 
                                tt[i].output();
                        }
                        break;
                    }
                    case "EC": {
                        for (int i = 0; i < n; i++) {
                            if (tt[i].getTicketTypeID().equals("EC")) 
                                tt[i].output();
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    public void statistic(){
        int numOfDomTicket = 0, numOfForeignTicket = 0, totalDomMoney = 0, totalForeignMoney = 0;
        for (int i = 0; i < n; i++) {
            String[] splitted = tt[i].ticketID.split("_");
            if (splitted[0].equals("TN")) {
                numOfDomTicket++;
                totalDomMoney += tt[i].price;
            }
            else if (splitted[0].equals("NN")) {
                numOfForeignTicket++;
                totalForeignMoney += tt[i].price;
            }
        }
        int totalTicket = numOfDomTicket + numOfForeignTicket;
        int totalMoney = totalDomMoney + totalForeignMoney;
        System.out.println("Total number of tickets sold: " + totalTicket);
        System.out.println("Total number of domestic ticket: " + numOfDomTicket);
        System.out.println("Total number of foreign ticket: " + numOfForeignTicket);
        System.out.println("Total money: " + totalMoney);
        System.out.println("Total money from domestic ticket: " + totalDomMoney);
        System.out.println("Total money from foreign ticket: " + totalForeignMoney);
    }
}
