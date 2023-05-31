package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ticketClassList implements list{
    private int n;
    public ticketClass[] tc = new ticketClass[100];
    public ticketClassList(){}
    public void insertFile(){
        try{
			BufferedWriter bw =new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\ticketClass.txt"));
			for(int i=0;i<n-1;i++){
				bw.write(tc[i].getTicketClassID());
				bw.newLine();
				bw.write(tc[i].getTicketClassName());
				bw.newLine();
			}
			bw.write(tc[n-1].getTicketClassID());
			bw.newLine();
			bw.write(tc[n-1].getTicketClassName());
			bw.newLine();
			bw.close();
		} catch(IOException e) {}
    }
    public void openFile(){
		try{
			int i = 0;
			Scanner in = new Scanner(new File("ticketClass.txt"));
			try {
				while(in.hasNextLine()){
					String tcID = in.nextLine();
					String tcName = in.nextLine();
					tc[i] = new ticketClass(tcID, tcName);
					i++;
				}
			} catch(Exception e) {}
		    finally{
				n = i;
				in.close();
			}
        } catch(IOException e) {}
	}
    public void output(){
        System.out.println("-------Ticket class list-------");
		System.out.println("|------------|----------------|");
		System.out.println("| TicketC ID |  TicketC Name  |");
		System.out.println("|------------|----------------|");
        for(int i=0; i<n; i++){
            tc[i].output();
        }
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public ticketClass[] getTc() {
        return tc;
    }
    public void setTc(ticketClass[] tc) {
        this.tc = tc;
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
        System.out.println("-------Ticket class addition-------");
		Scanner in = new Scanner(System.in);
		System.out.print("Input ticket class ID:");
		String tcID = in.nextLine();
		System.out.print("Input ticket class name:");
		String tcName = in.nextLine();
		int check = 0;
		for(int i=0;i<n;i++){
			if(tcID.equals(tc[i].getTicketClassID()) || tcName.equals(tc[i].getTicketClassName())){
					System.out.println("Ticket class ID or name already in the data!");
					check = 1;
				}
		}
		if(check ==0){
			tc[n] = new ticketClass(tcID,tcName);
			n++;
			priceList pl = new priceList();
			pl.openFile();
			System.out.println("Input price of your new ticket class: ");
			int price = in.nextInt();
			pl.addition1(tcID,price);
			System.out.println("Ticket class addition was succesful!");
			insertFile();
		}
    }
    public void edition(){
        System.out.println("-------Select action-------");
		System.out.println("1. Edit ticket class ID");
		System.out.println("2. Edit ticket class name");
		Scanner in = new Scanner(System.in);
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 1, 2);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input ticket class ID: ");
				String tcID = in.nextLine();
				System.out.println("Input new ticket class ID: ");
				String newtcID = in.nextLine();
				int check=0;
				for(int i=0;i<n;i++){
					if(newtcID.equals(tcID)){
						System.out.println("Ticket class ID already in the data!");
						check = 1;
					}
				}
				if(check == 0){
					System.out.println("Can't not edit ticket class ID!");
					insertFile();
				}
				break;
			}
			case 2:{
				in = new Scanner(System.in);
				System.out.println("Input ticket class name: ");
				String tcName = in.nextLine();
				System.out.println("Input new ticket class name: ");
				String newtcName = in.nextLine();
				int check = 0;
				for(int i=0;i<n;i++){
					if(newtcName.equals(tcName)){
						System.out.println("Ticket class name already in the data!");
						check = 1;
					}
				}
				if(check == 0){
					for(int i=0;i<n;i++){
						if(tcName.equals(tc[i].getTicketClassName()))
							tc[i].setTicketClassName(newtcName);
					}
					System.out.println("Ticket class edition was succesful!");
					insertFile();
				}
				break;
			}
			
		}
    }
    public void deletion(){
        System.out.println("-------Chon muc ban muon xoa-------");
		System.out.println("1. Delete ticket class ID");
		System.out.println("2. Delete ticket class name");
		Scanner in = new Scanner(System.in);
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 1, 2);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input ticket class ID:");
				String tcID = in.nextLine();
				System.out.println("Can't delete because" + tcID + "is being ordered by another customer!");
                break;
			}
			case 2:
			{
				in=new Scanner(System.in);
				System.out.print("Input the ticket class name:");
				String tcName = in.nextLine();
				System.out.println("Can't delete because" + tcName + "is being ordered by another customer!");
			    break;
			}
		}
    }
    public void search(){
        Scanner in = new Scanner(System.in);
        System.out.println("-------Chon muc ban muon tim-------");
	    System.out.println("1. Tim theo ma hang ve");
	    System.out.println("2. Tim theo ten hang ve");
	    System.out.print("Your selection: ");
        int choose = in.nextInt();
		choose = checkChoose(choose, 1, 2);
        switch(choose){
		    case 1:{
			    in = new Scanner(System.in);
			    int check = 0;
			    System.out.print("Input ticket class ID: ");
			    String tcID = in.nextLine();
			    System.out.println("-------Ticket class list-------");
		        System.out.println("|------------|----------------|");
		        System.out.println("| TicketC ID |  TicketC Name  |");
		        System.out.println("|------------|----------------|");
			    for(int i=0;i<n;i++)
			        if(tc[i].getTicketClassID().equals(tcID)){
						tc[i].output();
						check = 1;
					}
			    if(check == 0)
                    System.out.println("Your ticket class ID is not existed in the data!");
		            break;
		    }
	    	case 2:{
			    in=new Scanner(System.in);
			    int check = 0;
			    System.out.print("Nhap ten hang ve muon tim :");
			    String tcName = in.nextLine();
			    System.out.println("-------Ticket class list-------");
		        System.out.println("|------------|----------------|");
		        System.out.println("| TicketC ID |  TicketC Name  |");
		        System.out.println("|------------|----------------|");
			    for(int i=0;i<n;i++)
				    if((tc[i].getTicketClassName().toLowerCase()).indexOf(tcName.toLowerCase()) != -1){
						tc[i].output();
						check = 1;
					}
		        if(check == 0)
                    System.out.println("khong co hang ve ban can tim!");
			        break;
		    }
	    }
    }
}
