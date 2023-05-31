package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class orderList implements list{
    Scanner in = new Scanner(System.in);
    private int n;
    public order[] or = new order[1000];
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public order[] getOr() {
		return or;
	}
	public void setOr(order[] or) {
		this.or = or;
	}
	public void insertFile(){
        try 
		{
			BufferedWriter bw =new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\order.txt"));
			for(int i=0;i<n-1;i++)
			{
				bw.write(or[i].getOrderID());
				bw.newLine();
				bw.write(or[i].getReservationTicketID());
				bw.newLine();
				bw.write(or[i].getCustomerID());
				bw.newLine();
				bw.write(or[i].getStaffID());
				bw.newLine();
				bw.write(or[i].getDay());
				bw.newLine();
			}
			bw.write(or[n-1].getOrderID());
			bw.newLine();
			bw.write(or[n-1].getReservationTicketID());
			bw.newLine();
			bw.write(or[n-1].getCustomerID());
			bw.newLine();
			bw.write(or[n-1].getStaffID());
			bw.newLine();
			bw.write(or[n-1].getDay());
		    bw.close();
		} catch(IOException e) {}
    }
    public void openFile(){
        int s = 0;
        reservationTicketList rtl = new reservationTicketList();
        rtl.openFile();
        int t = 0;
        orderDetailList ordl = new orderDetailList();
        ordl.openFile();
        try{
            int i = 0;
            Scanner in = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\order.txt"));
            try{
                while(in.hasNextLine()){
                    String orID = in.nextLine();
					String rtID = in.nextLine();
					String cID = in.nextLine();
					String stID = in.nextLine();
					String d = in.nextLine();
                    or[i] = new order(orID,rtID,cID,stID,d);
					for(int j=0; j < rtl.getN(); j++){
						if(rtl.rt[j].getReservationTicketID().equals(or[i].getReservationTicketID())){
							s = s + rtl.rt[j].getNumberOfSeats();
						}
					}
					or[i].setTotalNumberOfSeats(s);
					s = 0;
					for(int j=0;j<ordl.getN();j++){
						if(ordl.od[j].getOrderID().equals(or[i].getOrderID()))
						{
							t = t + ordl.od[j].getOneTicketPrice();
						}
					}
					or[i].setIntoMoney(t);
					t=0;
					i++;
                }
            } catch(Exception e){}
			finally{
				n = i;
				in.close();
			}
        } catch (IOException e){}
    }
	public void output(){
		System.out.println("|================================================== Order list =======================================================|");
		System.out.println("|------------|------------------|---------------|--------------|--------------------|-------------|-------------------|");
		System.out.println("|  Order ID  |    ReTicket ID   |  Customer ID  |   Staff ID   |      Book date     | num Of Seats|     Into money    |");
		System.out.println("|------------|------------------|---------------|--------------|--------------------|-------------|-------------------|");
		for(int i=0;i<n;i++)
			or[i].output();
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
	public void totalNumOfSeats(){
		int s = 0;
		reservationTicketList rtl = new reservationTicketList();
		rtl.openFile();
		for(int i=0;i<this.n;i++){
			for(int j=0;j<rtl.getN();j++){
				if(rtl.rt[j].getReservationTicketID().equals(or[i].getReservationTicketID())){
					s=s+rtl.rt[j].getNumberOfSeats();
				}
			}
			or[i].setTotalNumberOfSeats(s);
			System.out.println(or[i].getTotalNumberOfSeats());
			s=0;
		}		
	}
	public void intoMoney(){
		int t = 0;
		orderDetailList odl =new orderDetailList();
		odl.openFile();
		for(int i=0;i<this.n;i++){
			for(int j=0;j<odl.getN();j++){
				if(odl.od[j].getOrderID().equals(or[i].getOrderID())){
					t = t+odl.od[j].getOneTicketPrice();
				}
			}
			or[i].setIntoMoney(t);
			System.out.println(or[i].getIntoMoney());
			t=0;
		}
	}
	public void addition(){
		Scanner in=new Scanner(System.in);
		String rtID = "";
		System.out.println("=======Order addition=======");
		System.out.print("Input order ID: ");
		String orID=in.nextLine();
		int t = 0;
		for(int i=0;i<n;i++){
			t=0;
			if(orID.equals(or[i].getOrderID())){
				System.out.println("Order ID already existed in the data!");
				t=1;
			}
			if(t==1){
				System.out.print("Input order ID: ");
				orID=in.nextLine();
			}
		}
		if(t==0){
			System.out.print("Input reservation ticket ID: ");
			rtID = in.nextLine();
			for(int i=0;i<n;i++){
				t=0;
				if(rtID.equals(or[i].getReservationTicketID())){
					System.out.println("Reservation ticket ID already booked by another customer!");
					t=1;
				}
				if(t==1){
					System.out.print("Input reservation ticket ID: ");
					orID=in.nextLine();
				}
			}
		}
		if(t==0){
			System.out.print("Input customer ID: ");
			String cusID=in.nextLine();
			System.out.print("Input staff ID: ");
			String stID=in.nextLine();
			System.out.print("Input date: ");
			String date=in.nextLine();
			or[n] = new order(orID,rtID,cusID,stID,date);
			n++;
			insertFile();
		}
	}
	public void edition(){
		System.out.println("-------Order edition-------");
		System.out.print("Input order ID: ");
		String orID=in.nextLine();
		System.out.println("-------Order detail-------");
		for(int i=0;i<n;i++)
			if(orID.equals(or[i].getOrderID())){
				or[i].output();
			}
		System.out.println("-------Select action-------");
		System.out.println("1. Edit order ID");
		System.out.println("2. Edit reservation ticket ID");
		System.out.println("3. Edit customer ID");
		System.out.println("4. Edit staff ID");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 1, 4);
		switch(choose){
			case 1:{
				Scanner in=new Scanner(System.in);
		 		System.out.print("Input new order ID: ");
				String neworID=in.nextLine();
				int t=0;
				for(int i=0;i<n;i++)
					if(neworID.equals(or[i].getOrderID())){
						System.out.print("Order ID already existed in the data!");
						t=1;
					}
				if(t==0){
					for(int i=0;i<n;i++)
						if(orID.equals(or[i].getOrderID())){
							or[i].setOrderID(neworID);
							System.out.println("Order ID edition was succesful!");
							insertFile();
						}
				}
		 		break;
	 		}
	 		case 2:{
				Scanner in=new Scanner(System.in);
				System.out.println("Input reservation ticket ID: ");
				String newrtID=in.nextLine();
		 		int t=0;
				for(int i=0;i<n;i++)
					if(newrtID.equals(or[i].getReservationTicketID())){
						System.out.print("Reservation ticket ID already existed in the data!");
						t=1;
					}
				if(t==0){
					System.out.print("Reservation ticket is unavailable!");
				}	
		 		break;
	 		}
	 		case 3:{
		 		Scanner in=new Scanner(System.in);
		 		System.out.println("Input customer ID: ");
		 		String newcusID=in.nextLine();
		 		int t=0;
				for(int i=0;i<n;i++)
					if(newcusID.equals(or[i].getCustomerID())){
						System.out.print("Customer ID already existed in the data!");
						t=1;
					}
				if(t==0){
					System.out.print("Customer ID is unavailable!");
				}
				break;
	 		}
	 		case 4:{
		 		Scanner in=new Scanner(System.in);
		 		System.out.println("Input staff ID: ");
		 		String newstID=in.nextLine();	
				for(int i=0;i<n;i++)
					if(orID.equals(or[i].getOrderID())){
						or[i].setStaffID(newstID);
						System.out.println("Staff ID edition was succesful!");
						insertFile();
					}
				break;
	 		}
		}
	}
	public void deletion(){
		System.out.println("-------Order deletion-------");
		System.out.print("Input order ID: ");
		Scanner in = new Scanner(System.in);
		String orID = in.nextLine();
		for(int i=0;i<n;i++)
			if(or[i].getOrderID().equals(orID)){
				for(int j=i;j<n;j++)
					or[j]=or[j+1];
				n--;
			}
		System.out.println("Deletion was succesful!");
		insertFile();
	}
	public void search(){
		orderDetailList odl =new orderDetailList();
		odl.openFile();
		customerList cusl = new customerList();
		cusl.openFileCustomer();
		ticketList tkl = new ticketList();
		tkl.openFile();
		staffList stl =new staffList();
		stl.openFile();
		Scanner in = new Scanner(System.in);
		System.out.print("Input order ID: ");
		String s = in.nextLine();
		int t = 0;
		String orID="";
		for(int i=0;i<n;i++){
			if(s.equals(or[i].getOrderID())){
				orID=or[i].getOrderID();
				t=1;
				System.out.println("====================================================================Order detail list: " + or[i].getOrderID() + "=================================================================||");
				for(int j=0;j<cusl.getN();j++)
					if(or[i].getCustomerID().equals(cusl.cus[j].getID())){
						System.out.println("||"+space("",158)+"||");
						System.out.println("|| Customer name : "+ cusl.cus[j].getSurname() + " " + cusl.cus[j].getName() + space(cusl.cus[j].getSurname() + " " + cusl.cus[j].getName(),137) + "||");
						System.out.println("||" + space("",158) + "||");
					}
				System.out.println("|| Book date: " + or[i].getDay() + space(or[i].getDay(),143) + "||");
				System.out.println("||"+space("",158)+"||");
				System.out.println("|| Total num of tickets: " + or[i].getTotalNumberOfSeats() + space(Integer.toString(or[i].getTotalNumberOfSeats()),144) + "||");
				System.out.println("||" + space("",158)+"||");
				for(int j=0;j<stl.getN();j++)
					if(or[i].getStaffID().equals(stl.sf[j].getStaffID())){
						System.out.println("|| Staff name: " + stl.sf[j].getSurname() + " " + stl.sf[j].getName() + space(stl.sf[j].getSurname() + " " + stl.sf[j].getName(),138) + "||");
						System.out.println("||" + space("",158) + "||");
					}
				System.out.println("|| Into money: " + or[i].getIntoMoney() + " VND" + space(or[i].getIntoMoney() + " VND",144) + "||");
				System.out.println("||" + space("",158) + "||");
				String cID="";
				String tkID="";
				System.out.println("|| |=================================================================Danh Sach ve cua hoa don ================================================================| ||");
				System.out.println("|| |--------------|--------------|----------------|-----------------------|-----------------|--------------------|-----------------------|--------------------| ||");
				System.out.println("|| |  Ma hoa don  |     Ma ve    |   Ma hang ve   |      Gia cua 1 ve     |  Ma khach hang  |       Ho Ten       |  Chung minh nhan dan  |    So dien thoai   | ||");
				System.out.println("|| |--------------|--------------|----------------|-----------------------|-----------------|--------------------|-----------------------|--------------------| ||");
				for(int j=0;j<odl.getN();j++){	
					if(s.equals(odl.od[j].getOrderID())){
						t=1;
						System.out.print("|| |" + odl.od[j].getOrderID() + outputTable(odl.od[j].getOrderID(),14)+odl.od[j].getTicketID() + outputTable(odl.od[j].getTicketID(),13) + odl.od[j].getTicketClassID() + outputTable(odl.od[j].getTicketClassID(),15) + odl.od[j].getOneTicketPrice() + outputTable(Integer.toString(odl.od[j].getOneTicketPrice()),22));
						tkID=odl.od[j].getTicketID();
						for(int k=0;k<tkl.getN();k++)
							if(tkID.equals(tkl.tt[k].getTicketID()))
								cID=tkl.tt[k].getCustomerID();
								for(int k=0;k<cusl.getN();k++)
									if(cID.equals(cusl.cus[k].getID())){
										System.out.println(cusl.cus[k].getID() + outputTable(cusl.cus[k].getID(),16) + cusl.cus[k].getSurname() + " " + cusl.cus[k].getName() + outputTable(cusl.cus[k].getSurname() + cusl.cus[k].getName(),18)+ cusl.cus[k].getCmnd() + outputTable(cusl.cus[k].getCmnd(),22) + cusl.cus[k].getPhone() + outputTable(cusl.cus[k].getPhone(),19) + "||");
									}
									System.out.println("|| |--------------|--------------|----------------|-----------------------|-----------------|--------------------|-----------------------|--------------------| ||");
									}
				}
			}
		}
		if(t==1){
			System.out.println("||                                                                                                                                                              ||");
			System.out.println("||==============================================================================================================================================================||");
		}
		if(t==0)
			System.out.println("Ticket ID not existed in the data!!");
	}
	public String outputTable(String m, int n){
		String s = "";
		for(int i=0; i < n-m.length(); i++)
				s = s + " ";	
		s=s + "|" + " ";
		return s;
	}
	public String space(String m, int n){
		String s="";
		for(int i=0; i < n-m.length(); i++)
				s = s + " ";
		return s;
	}
	public void statistic(){
		int totalMoney = 0, totalSeat = 0;
		for(int i=0; i < n; i++){
			totalMoney = totalMoney+or[i].getIntoMoney();
			totalSeat = totalSeat+or[i].getTotalNumberOfSeats();
		}
		System.out.println("------------------Statistic---------------");
		System.out.println("|---------------|------------------------|");
		System.out.println("| Total tickets |        Total Money     |");
		System.out.println("|---------------|------------------------|");
		System.out.println("|" + totalSeat + outputTable(Integer.toString(totalSeat),15) + totalMoney + outputTable(Integer.toString(totalMoney),23));
		System.out.println("|---------------|------------------------|");
	}
}