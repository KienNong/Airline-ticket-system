package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class seatList implements list{
    private int n;
    public seat[] st = new seat[1000];
    public void insertFile(){
        try {
		    BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\seat.txt"));
		    for(int i=0;i<n-1;i++){
		        bw.write(st[i].getPlaneID());
		        bw.newLine();
		        bw.write(st[i].getTicketClassID());
		        bw.newLine();
		        bw.write(st[i].getSeatID());
		        bw.newLine();
		    }
		    bw.write(st[n-1].getPlaneID());
		    bw.newLine();
		    bw.write(st[n-1].getTicketClassID());
		    bw.newLine();
		    bw.write(st[n-1].getSeatID());
		    bw.close();
		}catch(IOException e) {}
    }
    public void openFile(){
        int i = 0;
        try{
			Scanner in = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\seat.txt"));
			try{
				while(in.hasNextLine()){
					String pID = in.nextLine();
					String tcID = in.nextLine();
					String sID = in.nextLine();
					st[i] = new seat(sID,pID,tcID);
					i++;
				}
			} finally{
				n=i;
				in.close();
			}
		} catch(IOException e) {}
	}
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public seat getSt(int i) {
        return st[i];
    }
    public void setSt(seat[] st) {
        this.st = st;
    }
    public void output(){
        System.out.println("-------------------Seat list-----------------------");
		System.out.println("-------------|------------------|------------------");
		System.out.println("|   Seat ID  |     Plane ID     | Ticket class ID |");
		System.out.println("|------------|------------------|-----------------|");
        for(int i=0; i<n; i++){
            st[i].output();
        }
    }
    public void addition(){
        System.out.println("Can't add seat because seat is fixed!");
    }
    public void edition(){
        System.out.println("Can't edit seat because seat is fixed!");
    }
    public void deletion(){
        System.out.println("Can't delete seat because seat is fixed!");
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
    public void search(){
        Scanner in = new Scanner(System.in);
        System.out.println("-----Select action-----");
		System.out.println("1. Search by seat ID");
		System.out.println("2. Search by ticket class ID");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 2);
        switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input seat ID: ");
				String sID = in.nextLine();
				System.out.println("-------------|------------------|------------------");
		        System.out.println("|   Seat ID  |     Plane ID     | Ticket class ID |");
		        System.out.println("|------------|------------------|-----------------|");
				for(int i=0;i<n;i++)
					if(st[i].getSeatID().equals(sID))
						st[i].output();
				break;
			}
			case 2:
			{
				in = new Scanner(System.in);
				System.out.println("Nhap ma hang ve tim: ");
				String tcID=in.nextLine();
				System.out.println("-------------|------------------|------------------");
		        System.out.println("|   Seat ID  |     Plane ID     | Ticket class ID |");
		        System.out.println("|------------|------------------|-----------------|");
				for(int i=0;i<n;i++)
					if(st[i].getTicketClassID().equals(tcID))
						st[i].output();
				break;
			}
		}
    }

}
