package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class reservationTicketList implements list{
    private int n = 0;
    public reservationTicket[] rt = new reservationTicket[1000];
    public reservationTicketList(){}
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public reservationTicket[] getRt() {
        return rt;
    }
    public void setRt(reservationTicket[] rt) {
        this.rt = rt;
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
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\reservationTicket.txt"));
			for(int i=0;i<n-1;i++){
				bw.write(rt[i].getReservationTicketID());
				bw.newLine();
				bw.write(rt[i].getCustomerID());
				bw.newLine();
				bw.write(rt[i].getTicketClassID());
				bw.newLine();
				bw.write(Integer.toString(rt[i].getNumberOfSeats()));
				bw.newLine();
			}
			bw.write(rt[n-1].getReservationTicketID());
			bw.newLine();
			bw.write(rt[n-1].getCustomerID());
			bw.newLine();
			bw.write(rt[n-1].getTicketClassID());
			bw.newLine();
			bw.write(Integer.toString(rt[n-1].getNumberOfSeats()));
		    bw.close();
		} catch(IOException e){}
    }
    public void openFile(){
        int i = 0;
		try{
			Scanner in = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\reservationTicket.txt"));
			try{
				while(in.hasNextLine()){
					String rtID = in.nextLine();
					String cID = in.nextLine();
					String tcID = in.nextLine();
					int nos = Integer.parseInt(in.nextLine());
					rt[i] = new reservationTicket(rtID, cID, tcID, nos);
					i++;
                }	
			} catch(Exception e) {}
			finally{
				n=i;
				in.close();	
			}
		} catch(IOException e) {}
    }
    public void output(){
		System.out.println("-------------------Reservationticket List-----------------");
		System.out.println("|------------|---------------|------------|--------------|");
		System.out.println("| ReTicketID |  Customer ID  | TicketC ID | Num of seats |");
		System.out.println("|------------|---------------|------------|--------------|");
		for(int i=0; i < n; i++)
			rt[i].output();
	}
    public void addition(){
		Scanner in = new Scanner(System.in);
		System.out.println("-------Select action-------");
		System.out.println("1. Input new reservation ticket for new customer");
		System.out.println("2. Input new reservation ticket for old customer");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 2);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.print("Input new reservation ticket ID:");
				String rtID = in.nextLine();
				int flag = 0;
				for(int i = 0; i < n; i++)
					if(rt[i].getReservationTicketID().equals(rtID)){
						System.out.println("Reservation ticket ID already in the data!");
						flag = 1;
						break;
					}
				if(flag == 0){
					System.out.print("Input customer ID: ");
					String cID = in.nextLine();
					System.out.print("Input ticket class ID: ");
					String tcID = in.nextLine();
					System.out.print("Input number of seats: ");
					int nos = in.nextInt();
					rt[n] = new reservationTicket(rtID,cID,tcID,nos);
					n++;
					System.out.println("Addition was succesful!");
					insertFile();
				}
				break;
			}
			case 2:{
				in=new Scanner(System.in);
				System.out.println("Input old reservation ticket ID:");
				String rtID = in.nextLine();
				int flag = 0;
				for(int i=0; i < n; i++)
					if(rt[i].getReservationTicketID().equals(rtID)){
						flag = 1;
						break;
					}
				if(flag == 1){
					for(int i=0;i<n;i++)
						if(rt[i].getReservationTicketID().equals(rtID)){
							System.out.print("Input ticket class ID: ");
							String tcID = in.nextLine();
							System.out.print("Input number of seats: ");
							int nos = in.nextInt();
							rt[n] = new reservationTicket(rtID,rt[i].getCustomerID(),tcID,nos);
							n++;
							System.out.println("Addition was succesful!");
							insertFile();
							break;			
							
						}					
				}
				else System.out.println("Reservation ticket ID not existed in the data!");
				break;
			}
		}
		insertFile();
    }
    public void edition(){
		System.out.println("-------Select action--------");
		System.out.println("1. Edit reservation ticket ID");
		System.out.println("2. Edit customer ID");
		System.out.println("3. Edit ticket class ID");
		System.out.println("4. Edit number of seats");
        Scanner in=new Scanner(System.in);
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 4);
        switch(choose){
			case 1:{
				int flag = 0;
				in = new Scanner(System.in);
				System.out.print("Input old reservation ticket ID: ");
				String rtID = in.nextLine();
				System.out.print("Input new reservation ticket ID: ");
				String newrtID = in.nextLine();
				for(int i=0; i<n; i++){
					if(rt[i].getReservationTicketID().equals(rtID)){
						System.out.println("Reservation ticket ID already in the data!");
						flag=1;
					}
				}
				if(flag == 0){
				    System.out.println("Can't edit" + newrtID + "because this customer didn't book this ticket");
				}
				insertFile();
				break;
			}
			case 2:{
				int flag=0;
				in = new Scanner(System.in);
				System.out.println("Input reservation ticket ID: ");
				String rtID = in.nextLine();
				System.out.println("Input new customer ID: ");
				String newcID = in.nextLine();
				for(int i=0;i<n;i++){
					if(rt[i].getCustomerID().equals(newcID)){
						System.out.print("Customer ID already existed in the data!");
						flag = 1;
					}
				}
				if(flag == 0){
					for(int i=0;i<n;i++)
						if(rtID.equals(rt[i].getReservationTicketID()))
							rt[i].setCustomerID(newcID);
					System.out.println("Edition was succesful!");
					insertFile();
                }
				break;
			}
			case 3:{
				in = new Scanner(System.in);
				System.out.println("Input reservation ticket ID: ");
				String rtID = in.nextLine();
				System.out.println("Input old ticket class ID: ");
				String tcID = in.nextLine();
				System.out.println("Input new ticket class ID: ");
				String newtcID = in.nextLine();
				for(int i=0; i < n; i++)
					if(rtID.equals(rt[i].getReservationTicketID()) && tcID.equals(rt[i].getTicketClassID()))
					{
						rt[i].setTicketClassID(newtcID);
					}
				System.out.println("Edition was succesful!");
				insertFile();
				break;
			}
			case 4:{
				in = new Scanner(System.in);
				System.out.println("Input reservation ticket ID: ");
				String rtID = in.nextLine();
				System.out.println("Input ticket class ID: ");
				String tcID = in.nextLine();
				System.out.println("Input new number of seats: ");
				int newnos = in.nextInt();
				for(int i=0;i<n;i++)
					if(rtID.equals(rt[i].getReservationTicketID()) && tcID.equals(rt[i].getTicketClassID())){
						rt[i].setNumberOfSeats(newnos);
					}
				System.out.println("Edition was succesful!");
				insertFile();
				break;
			}
		}
    }
    public void deletion(){
        System.out.println("-------Select action-------");
		System.out.println("1. Delete reservation ticket");
		System.out.println("2. Delete ticket class");
		Scanner in = new Scanner(System.in);
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 2);
		switch(choose){
			case 1:{
			    in=new Scanner(System.in);
				System.out.print("Input reservation ticket ID: ");
				String rtID = in.nextLine();
				for(int i=0; i < n; i++)
					if(rtID.equals(rt[i].getReservationTicketID())){
						while(rtID.equals(rt[i].getReservationTicketID()) == true){
							for(int j=i; j < n; j++){
								rt[j] = rt[j+1];
							}
							n--;
							if(rt[i]==null)
								break;
						}
					}
				System.out.println("Deletion was succesful!");
				insertFile();
				break;
			}
			case 2:{
				in = new Scanner(System.in);
				System.out.print("Input reservation ticket ID: ");
				String rtID = in.nextLine();
				System.out.print("Input ticket class ID: ");
				String tcID = in.nextLine();
				for(int i=0; i < n; i++)
					if(rtID.equals(rt[i].getReservationTicketID()) && tcID.equals(rt[i].getTicketClassID())){
						for(int j=i;j<n;j++)
							rt[j]=rt[j+1];
						n--;
					}
				System.out.println("Deletion was succesful!");
				insertFile();
				break;
			}
		}
    }
    public void search(){
        Scanner in=new Scanner(System.in);
		System.out.println("-------Select action-------");
		System.out.println("1. Search by reservation ticket ID");
		System.out.println("2. Search by customer ID");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 2);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.print("Input reservation ticket ID: ");
				String rtID = in.nextLine();
				int check = 0;
				System.out.println("-------------------Reservationticket List-----------------");
		        System.out.println("|------------|---------------|------------|--------------|");
		        System.out.println("| ReTicketID |  Customer ID  | TicketC ID | Num of seats |");
		        System.out.println("|------------|---------------|------------|--------------|");
				for(int i=0;i<n;i++)
					if(rtID.equals(rt[i].getReservationTicketID())){
						rt[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Reservation ticket ID not existed in data!");
				break;
			}
			case 2:{
				in = new Scanner(System.in);
				System.out.println("Input customer ID: ");
				String cID = in.nextLine();
				int check = 0;
				System.out.println("-------------------Reservationticket List-----------------");
		        System.out.println("|------------|---------------|------------|--------------|");
		        System.out.println("| ReTicketID |  Customer ID  | TicketC ID | Num of seats |");
		        System.out.println("|------------|---------------|------------|--------------|");
				for(int i=0;i<n;i++)
					if(cID.equals(rt[i].getCustomerID())){
						rt[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Customer ID not existed in the data!");
				break;
			}
		}
    }

}
