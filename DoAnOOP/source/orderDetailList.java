package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class orderDetailList implements list{
    private int n;
    public orderDetail[] od = new orderDetail[1000];
    public orderDetailList(){}
    public void insertFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\orderDetail.txt"));
            for(int i=0; i<n-1; i++){
                bw.write(od[i].getOrderID());
				bw.newLine();
				bw.write(od[i].getTicketID());
				bw.newLine();
				bw.write(od[i].getTicketClassID());
				bw.newLine();
				bw.write(Integer.toString(od[i].getOneTicketPrice()));
				bw.newLine();
            }
                bw.write(od[n-1].getOrderID());
				bw.newLine();
				bw.write(od[n-1].getTicketID());
				bw.newLine();
				bw.write(od[n-1].getTicketClassID());
				bw.newLine();
				bw.write(Integer.toString(od[n-1].getOneTicketPrice()));
				bw.close();
        } catch(IOException e){}
    }
    public void openFile(){
        try{
            int i=0;
            Scanner in = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\orderDetail.txt"));
            try{
                while(in.hasNextLine()){
                    String orderID = in.nextLine();
                    String ticketID = in.nextLine();
                    String ticketClassID = in.nextLine();
                    int price = Integer.parseInt(in.nextLine());
                    od[i] = new orderDetail(orderID, ticketID, ticketClassID, price);
                    i++;
                }
            } catch(Exception e){
                // Do nothing;
            }
            finally{
                n = i;
                in.close();
            }
        } catch(IOException e){
            // Do nothing;
        }
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public orderDetail[] getOd() {
        return od;
    }
    public void setOd(orderDetail[] od) {
        this.od = od;
    }
    public void createOrderDetailList(){
		n=0;
		orderDetailList odl = new orderDetailList();
		ticketList tl = new ticketList();
		odl.openFile();
		tl.openFile();
		for(int i=0;i<odl.getN();i++)
			for(int j=0;j<tl.getN();j++){
					if(odl.od[i].getOrderID().equals(tl.tt[j].getOrderID())){
							od[n]= new orderDetail();
							od[n].setOrderID(odl.od[i].getOrderID());
							od[n].setTicketID(tl.tt[i].getTicketID());
							od[n].setTicketClassID(tl.tt[i].getTicketTypeID());
							od[n].setOneTicketPrice(tl.tt[i].getPrice());
							n++;
						}
				}
		    insertFile();
	}
    public void output(){
        System.out.println("-------------------------------Order detail list------------------------");
		System.out.println("|--------------|--------------|----------------|-----------------------|");
		System.out.println("|   Order ID   |  Ticket ID   |   TicketC ID   |  One ticket's price   |");
		System.out.println("|--------------|--------------|----------------|-----------------------|");
		for(int i=0;i<n;i++){
			od[i].output();
		}
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
    public void addition(){
        ticketList tkl = new ticketList();
	    tkl.openFile();
	    orderList orl = new orderList();
	    orl.openFile();
	    reservationTicketList rtl =new reservationTicketList();
	    rtl.openFile();
	    Scanner in =new Scanner(System.in);
	    System.out.print("Input order ID:");
	    String orID=in.nextLine();
	    String tkID="";
	    String rtlID="";
	    String cusID="";
	    int price = 0;
	    int check = 0;
	    for(int i=0;i<orl.getN();i++)
		    if(orl.or[i].getOrderID().equals(orID)){
				rtlID=orl.or[i].getReservationTicketID();
				cusID=orl.or[i].getCustomerID();
				check = 1;
			}
		    if(check == 0)
			    System.out.println("No order addition!");
	        if(check == 1){
		        check = 0;
		        System.out.print("Input ticket ID:");
		        tkID=in.nextLine();
		        for(int i=0;i<tkl.getN();i++)
			        if(tkl.tt[i].getTicketID().equals(tkID))
				        check = 1;
		            if(check==0)
			            System.out.println("No ticket ID addition!");
	        }
	        if(check == 1){
		        System.out.println("Input ticket class ID:");
		        String tcID=in.nextLine();
			    for(int i=0;i<tkl.getN();i++){
				    if(tkl.tt[i].getTicketID().equals(tkID))
					    price=tkl.tt[i].getPrice();			
			    }
			    od[n] = new orderDetail(orID,tkID,tcID,price);
			    n++;
		        rtl.rt[rtl.getN()]= new reservationTicket(rtlID,cusID,tcID,1);
		        rtl.setN(rtl.getN()+1);
		        rtl.insertFile();
		        insertFile();
		        System.out.println("Addition was succesful!");
	        }
    }
    public void edition(){
        Scanner in = new Scanner(System.in);
    	System.out.println("-------Order detail edition-------");
	    System.out.println("1. Edit ticket class ID");
	    System.out.println("2. Edit customer");
	    System.out.print("Your selection: ");
	    int choose = in.nextInt();
	    choose = checkChoose(choose,1,2);
	    switch(choose){
		case 1:{
			orderList orl = new orderList();
			orl.openFile();
			ticketList tkl = new ticketList();
			tkl.openFile();
			reservationTicketList rtl=new reservationTicketList();
			rtl.openFile();
			in = new Scanner(System.in);
			System.out.print("Input order ID: ");
			String orID=in.nextLine();
			System.out.print("Input ticket ID: ");
			String tkID=in.nextLine();
			System.out.print("Input ticket class ID: ");
			String tcID=in.nextLine();
			System.out.print("Input new ticket class ID: ");
			String newtcID=in.nextLine();
			String rt="";
			for(int i=0;i<orl.getN();i++)
				if(orID.equals(orl.or[i].getOrderID())){
					rt=orl.or[i].getReservationTicketID();
					break;
				}
			
			for(int i=0;i<rtl.getN();i++)
				if(rt.equals(rtl.rt[i].getReservationTicketID()) && tcID.equals(rtl.rt[i].getTicketClassID())){ 
					rtl.rt[i].setTicketClassID(newtcID);
					break;
				}
			String seatID="";
			String flightID="";
			for(int i=0;i<tkl.getN();i++)
				if(tkID.equals(tkl.tt[i].getTicketID())){
					in=new Scanner(System.in);
					tkl.tt[i].setTicketTypeID(newtcID);
					flightID = tkl.tt[i].getFlightID();
					switch (newtcID) {
			        case "EC": {
			            tkl.tt[i].setType("Economy Class");
			            System.out.println("-------New row-------");
			        	System.out.println("1. A");
			           	System.out.println("2. B");
			        	System.out.println("3. C");
			        	System.out.print("Your selection: ");
		            	choose = in.nextInt();
		            	choose = checkChoose(choose, 1, 3);
			            switch(choose){
			                case 1:{
			                	in = new Scanner(System.in);
			                	seatID="A";
			                	System.out.println("Input seat ID number: ");
			                	String seatNum=in.nextLine();
			                	seatID=seatID.concat(seatNum);
			                	for(int j=0;j<tkl.getN();j++)
			                		if(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID()))
			                			while(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID())){
		                					in=new Scanner(System.in);
		                					System.out.println("Seat number already in the data!");
		                					System.out.print("Input seat ID number:");
	                					    seatNum=in.nextLine();
		                					seatID="A";
			                					seatID.concat(seatNum);
			                				}
			                		tkl.tt[i].setSeatID(seatID);
			                		break;
			                	}
			                	case 2:{
			                		in=new Scanner(System.in);
			                		seatID="B";
			                		System.out.print("Input seat ID number: ");
			                		String seatNum=in.nextLine();
			                		seatID=seatID.concat(seatNum);
			                		for(int j=0;j<tkl.getN();j++)
			                			if(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID()))
			                				while(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID())){
			                					in=new Scanner(System.in);
			                					System.out.println("Seat number already in the data!");
		                					    System.out.print("Input seat ID number:");
			                				    seatNum=in.nextLine();
			                					seatID="B";
			                					seatID.concat(seatNum);
			                				}
			                		tkl.tt[i].setSeatID(seatID);
			                		break;
			                	}
			                	case 3:{
			                		in=new Scanner(System.in);
			                		seatID="C";
			                		System.out.print("Input seat ID number: ");
			                		String seatNum=in.nextLine();
			                		seatID=seatID.concat(seatNum);
			                		for(int j=0;j<tkl.getN();j++)
			                			if(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID()))
			                				while(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID())){
			                					in=new Scanner(System.in);
			                					System.out.println("Seat ID number already in the data!");
			                					System.out.print("Input seat ID number:");
			                					seatNum=in.nextLine();
			                					seatID="C";
			                					seatID.concat(seatNum);
			                				}
			                		tkl.tt[i].setSeatID(seatID);
			                		break;
			                	}
			                }
			                break;
			            }
			            case "BC":{
			            	tkl.tt[i].setType("Business Class");
			            	seatID="T";
			            	in = new Scanner(System.in);
			            	System.out.println("You choose Business (T)");
		                	System.out.print("Input seat ID number: ");
		                	String seatNum = in.nextLine();
		                	seatID = seatID.concat(seatNum);
		                	for(int j=0;j<tkl.getN();j++)
		                		if(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID()))
		                			while(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID())){
		                				in=new Scanner(System.in);
                                        System.out.println("Seat ID number already in the data!");
                                        System.out.print("Input seat ID number:");
		                				seatNum=in.nextLine();
		                				seatID="T";
		                				seatID.concat(seatNum);
		                			}
		                		tkl.tt[i].setSeatID(seatID);
			                break;
			            }
			            case "PC": {
			            	in=new Scanner(System.in);
			            	tkl.tt[i].setType("Premium Class");
			            	seatID="P";
			            	System.out.println("You choose Premium (P)");
		                	System.out.print("Input seat ID number: ");
		                	String seatNum=in.nextLine();
		                	seatID=seatID.concat(seatNum);
		                	for(int j=0;j<tkl.getN();j++)
		                		if(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID()))
		                			while(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID())){
		                				in=new Scanner(System.in);
                                        System.out.println("Seat ID number already in the data!");
                                        System.out.print("Input seat ID number:");
		                				seatNum=in.nextLine();
		                				seatID="P";
		                				seatID.concat(seatNum);
		                			}
		                		tkl.tt[i].setSeatID(seatID);
			                break;
			            }
			            case "FC":{
			            	in=new Scanner(System.in);
			            	tkl.tt[i].setType("First Class");
			            	seatID="F";
			            	System.out.println("You choose First (F)");
		                	System.out.print("Input seat ID number: ");
		                	String seatNum=in.nextLine();
		                	seatID=seatID.concat(seatNum);
		                	for(int j=0;j<tkl.getN();j++)
		                		if(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID()))
		                			while(flightID.equals(tkl.tt[j].getFlightID()) && seatID.equals(tkl.tt[j].getSeatID())){
		                				in=new Scanner(System.in);
                                        System.out.println("Seat ID number already in the data!");
                                        System.out.print("Input seat ID number:");
		                				seatNum=in.nextLine();
		                				seatID="F";
		                				seatID.concat(seatNum);
		                			}
		                		tkl.tt[i].setSeatID(seatID);
			                break;
                        }
                }
                break;
            }
			rtl.insertFile();
			tkl.insertFile();
			createOrderDetailList();
			System.out.println("Edition was succesful!");
			break;
        }
		case 2:{
			in = new Scanner(System.in);
			orderList orl =new orderList();
			orl.openFile();
			ticketList tkl=new ticketList();
			tkl.openFile();
			System.out.print("Input order ID: ");
			String orID=in.nextLine();
			System.out.print("Input ticket ID: ");
			String tkID=in.nextLine();
			System.out.print("Input new customer ID: ");
			String newcID = in.nextLine();
			for(int i=0;i<tkl.getN();i++)
				if(orID.equals(tkl.tt[i].getOrderID()) && newcID.equals(tkl.tt[i].getCustomerID()))
					while(orID.equals(tkl.tt[i].getOrderID()) && newcID.equals(tkl.tt[i].getCustomerID())){
						System.out.println("Customer ID already existed in the data!");
						System.out.print("Input new customer ID: ");
						newcID=in.nextLine();
					}
			for(int i = 0; i<tkl.getN();i++)
				if(tkID.equals(tkl.tt[i].getTicketID())){ 
					tkl.tt[i].setCustomerID(newcID);
					break;
				}
			tkl.insertFile();
			createOrderDetailList();
			System.out.println("Edition was succesful!!");
			break;
		}
        }
    }
    public void deletion(){
        Scanner in=new Scanner(System.in);
        System.out.println("-------Delete ticket of order detail by ticket ID");
        ticketList tkl = new ticketList();
		tkl.openFile();
		reservationTicketList rtl=new reservationTicketList();
		rtl.openFile();
		orderList orl=new orderList();
		orl.openFile();
		in=new Scanner(System.in);
		System.out.println("Input order ID: ");
		String orID=in.nextLine();
		System.out.println("Input ticket ID: ");
		String tkID=in.nextLine();
		String rtID="";
		String tcID="";
		for(int i=0;i<tkl.getN();i++)
			if(orID.equals(tkl.tt[i].getOrderID()) && tkID.equals(tkl.tt[i].getTicketID())){
				tcID=tkl.tt[i].getTicketTypeID();
				for(int j=i;j<tkl.getN();j++)
					tkl.tt[j]=tkl.tt[j+1];
					tkl.setN(tkl.getN()-1);	
			}
			for(int i=0;i<orl.getN();i++)
				if(orID.equals(orl.or[i].getOrderID()))
					rtID=orl.or[i].getReservationTicketID();
				for(int i=0;i<rtl.getN();i++)
					if(rtID.equals(rtl.rt[i].getReservationTicketID()) && tcID.equals(rtl.rt[i].getTicketClassID())){
						for(int j=i;j<rtl.getN();j++)
							rtl.rt[j]=rtl.rt[j+1];
						    rtl.setN(rtl.getN()-1);	
						break;
					}
		System.out.println("Deletion was succesful!");
		rtl.insertFile();
		tkl.insertFile();
		createOrderDetailList();
    }
    public void search(){
        ticketList tkl=new ticketList();
	    tkl.openFile();
	    customerList cusl=new customerList();
	    cusl.openFileCustomer();
	    Scanner in = new Scanner(System.in);
	    System.out.print("Input order ID: ");
	    String s = in.nextLine();
	    int t = 0;
	    String cusID = "";
	    String tkID = "";
	    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.println("|--------------|--------------|----------------|-----------------------|-----------------|--------------------|-----------------------|--------------------|");
	    System.out.println("|   Order ID   |   Ticket ID  |   TicketC ID   |    One ticket price   |    Customer ID  |       Full name    |          CMND         |         Phone      |");
	    System.out.println("|--------------|--------------|----------------|-----------------------|-----------------|--------------------|-----------------------|--------------------|");
		for(int i=0;i<n;i++){	
			if(s.equals(od[i].getOrderID())){
				t=1;
                System.out.println("| " + od[i].getOrderID() + outputTable(od[i].getOrderID(),14) + od[i].getTicketID() + outputTable(od[i].getTicketID(),13) + od[i].getTicketClassID() + outputTable(od[i].getTicketClassID(),15) + od[i].getOneTicketPrice() + outputTable(Integer.toString(od[i].getOneTicketPrice()),22));
				tkID = od[i].getTicketID();
				for(int j=0;j<tkl.getN();j++)
					if(tkID.equals(tkl.tt[j].getTicketID()))
						cusID=tkl.tt[j].getCustomerID();
					for(int j=0;j<cusl.getN();j++)
						if(cusID.equals(cusl.cus[j].getID())){
							System.out.println(cusl.cus[j].getID() +outputTable(cusl.cus[j].getID(),16)+ cusl.cus[j].getSurname()+" "+cusl.cus[j].getName() +outputTable(cusl.cus[j].getSurname()+cusl.cus[j].getName(),18)+ cusl.cus[j].getCmnd()+outputTable(cusl.cus[j].getCmnd(),22) +cusl.cus[j].getPhone()+outputTable(cusl.cus[j].getPhone(),19));
					    }
				System.out.println("|--------------|--------------|----------------|-----------------------|-----------------|--------------------|-----------------------|--------------------|");
			}
		}
	    if(t==0)
		    System.out.println("Ticket ID not existed in the data!");
    }
    public String outputTable(String m, int n){
        String s = "";
		for(int i=0;i<n-m.length();i++)
			s=s+" ";
		s = s + "|" + " ";
		return s;
    }
}

