package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class priceList implements list{
    private int n;
    public price[] p = new price[50];
    public priceList(){}
    public void insertFile(){
        try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\price.txt"));
			for(int i=0;i<n-1;i++){
					bw.write(p[i].getTicketClassID());
					bw.newLine();
					bw.write(Integer.toString(p[i].getTicketClassPrice()));
					bw.newLine();
				}
			bw.write(p[n-1].getTicketClassID());
			bw.newLine();
			bw.write(Integer.toString(p[n-1].getTicketClassPrice()));
			bw.close();
		}catch(IOException e){}
    }
    public void openFile(){
        try{
			int i = 0;
			Scanner fo = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\price.txt"));
			try {
					while(fo.hasNextLine()){
						String tickClassID = fo.nextLine();
						int price = Integer.parseInt(fo.nextLine());
						p[i]= new price(tickClassID, price);
						i++;
					}
				}catch(Exception e) {}
			finally {
					n = i;
					fo.close();
				}
		} catch(IOException e) {}
    }
    public void output(){
        System.out.println("---Price list---");
        System.out.println("|------------|----------------|");
		System.out.println("|  Class ID  |   Class price  |");
		System.out.println("|------------|----------------|");
        for(int i=0; i<n; i++){
            p[i].output();
        }
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public price getP(int i) {
        return p[i];
    }
    public void setP(price[] p) {
        this.p = p;
    }
    public void addition(){
    }
    public void addition1(String ticketClassID, int ticketClassPrice){
        p[n] = new price(ticketClassID, ticketClassPrice);
        n++;
        insertFile();
    }
    public void edition(){
        Scanner in = new Scanner(System.in);
		output();
		System.out.println("=======Price edition=======");
		System.out.println("Input ticket class ID: ");
		String tcID = in.nextLine();
		System.out.println("Input ticket class price: ");
		int newp = in.nextInt();
		for(int i=0; i<n; i++)
		{
			if(tcID.equals(p[i].getTicketClassID()))
				p[i].setTicketClassPrice(newp);
		}
		System.out.println("Price edition was succesful!");
		insertFile();
    }
    public void deletion(){
        System.out.println("You can't delete price!");
    }
    public void search(){
        Scanner in = new Scanner(System.in);
		System.out.println("Input ticket class ID:");
		String tcID = in.nextLine();
		System.out.println("---Price list---");
        System.out.println("|------------|----------------|");
		System.out.println("|  Class ID  |   Class price  |");
		System.out.println("|------------|----------------|");
		int check = 0;
		for(int i=0;i<n;i++)
			if(p[i].getTicketClassID().equals(tcID)){
					p[i].output();
					check = 1;
				}
		if(check == 0)
            System.out.println("Your ticket class ID not in the data!");
    }
}
