package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class airportList implements list{
    private int n;
    public airport[] ap = new airport[200];
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public airport[] getAp() {
        return ap;
    }
    public void setAp(airport[] ap) {
        this.ap = ap;
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
        try {
		    BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\airport.txt"));
		    for(int i=0;i<n-1;i++){
		        bw.write(ap[i].getAirportID());
		        bw.newLine();
		        bw.write(ap[i].getAirportName());
		        bw.newLine();
		        bw.write(ap[i].getCity());
		        bw.newLine();
		    }
			bw.write(ap[n-1].getAirportID());
			bw.newLine();
			bw.write(ap[n-1].getAirportName());
			bw.newLine();
			bw.write(ap[n-1].getCity());
			bw.close();
		} catch(IOException e) {}
    }
    public void openFile(){
        int i=0;
		try{
			Scanner in = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\airport.txt"));
			try{
				while(in.hasNextLine()){
					String apID = in.nextLine();
					String apName = in.nextLine();
					String city = in.nextLine();
					ap[i]=new airport(apID,apName,city);
					i++;
				}
			}
			finally{
				n = i;
				in.close();
			}
		} catch(IOException e) {}
    }
    public void output(){
		System.out.println("------------------Airport list--------------------");
		System.out.println("-------------|-------------------|----------------");
		System.out.println("| Airport ID |    Airport name   |      City     |");
		System.out.println("|------------|-------------------|---------------|");
		for(int i=0;i<n;i++)
			ap[i].output();
	}
    public void addition(){
        Scanner in=new Scanner(System.in);
		System.out.println("-------Airport addition-------");
		System.out.println("Number of airports: ");
		int h = in.nextInt();
		int check = 0;
		for(int i = n; i<n+h; i++){
			in = new Scanner(System.in);
			System.out.println("Input airport ID: ");
			String apID = in.nextLine();
				do{
				    check = 0;
				    for(int j=0;j<n;j++)
					    if(apID.equals(ap[j].getAirportID())){
						    System.out.println("Airport ID already existed in the data!");
						    check = 1;
					    }
				    if(check == 1){
						System.out.println("Pre-enter airport ID: ");
						apID = in.nextLine();
					}
				} while(check == 1);
				if(check == 0){
					in = new Scanner(System.in);
					System.out.println("Input airport name:");
					String apName = in.nextLine();
					System.out.println("Input airport city:");
					String city = in.nextLine();
					ap[i] = new airport(apID, apName, city);
				}
		}
		n = n + h;
		insertFile();
		System.out.println("Airport addition was succesful!");
    }
    public void edition(){
        Scanner in = new Scanner(System.in);
		System.out.println("-------Select action-------");
		System.out.println("1. Edit airport name");
		System.out.println("2. Edit city");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 1, 2);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input airport ID: ");
				String apID = in.nextLine();
				System.out.println("Input new airport name: ");
				String newapName = in.nextLine();
				for(int i=0; i < n; i++){
					if(apID.equals(ap[i].getAirportID()))
						ap[i].setAirportName(newapName);
				}
				System.out.println("Airport name edition was succesful!");
				insertFile();
				break;
			}
			case 2:{
				in = new Scanner(System.in);
				System.out.println("Input airport ID: ");
				String apID = in.nextLine();
				System.out.println("Input new city: ");
				String newcity = in.nextLine();
				for(int i=0;i<n;i++)
				{
					if(apID.equals(ap[i].getAirportID()))
						ap[i].setCity(newcity);
				}
				System.out.println("City edition was succesful!");
				insertFile();
				break;
			}
		}
    }
    public void deletion(){
        Scanner in=new Scanner(System.in);
		System.out.println("-------Airport deletion-------");
		System.out.println("Do you want to delete airport ID? [y/n]:");
		String k = in.nextLine();
		switch(k){
			case "y":{
			in = new Scanner(System.in);
			System.out.println("Input airport ID: ");
			String apID = in.nextLine();
			for(int i=0;i<n;i++)
				if(apID.equals(ap[i].getAirportID()))
				{
					for(int j=i;j<n;j++)
						ap[j]=ap[j+1];
					n--;
					if(ap[i]==null)
						break;
				}
				System.out.println("Delete airport was succesful!");
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
        Scanner in = new Scanner(System.in);
		System.out.println("-------Select action-------");
		System.out.println("1. Search by airport ID");
		System.out.println("2. Search by airport name");
		System.out.println("3. Search by city");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 3);
		switch(choose){
			case 1:{
				int check = 0;
				in = new Scanner(System.in);
				System.out.println("Input airport ID: ");
				String apID = in.nextLine();
				System.out.println("------------------Airport list--------------------");
		        System.out.println("-------------|-------------------|----------------");
		        System.out.println("| Airport ID |    Airport name   |      City     |");
		        System.out.println("|------------|-------------------|---------------|");
				for(int i=0;i<n;i++)
					if(ap[i].getAirportID().equals(apID)){
						ap[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Airport ID not existed in the data!");
				break;
			}
			case 2:{
				int check = 0;
				in = new Scanner(System.in);
				System.out.println("Input airport name: ");
				String apName = in.nextLine();
				System.out.println("------------------Airport list--------------------");
		        System.out.println("-------------|-------------------|----------------");
		        System.out.println("| Airport ID |    Airport name   |      City     |");
		        System.out.println("|------------|-------------------|---------------|");
				for(int i=0;i<n;i++)
					if(ap[i].getAirportName().toLowerCase().indexOf(apName.toLowerCase()) != -1){
						ap[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Airport name not existed in the data!");
				break;
			}
			case 3:{
				int check = 0;
				in = new Scanner(System.in);
				System.out.println("Input city: ");
				String city = in.nextLine();
				System.out.println("------------------Airport list--------------------");
		        System.out.println("-------------|-------------------|----------------");
		        System.out.println("| Airport ID |    Airport name   |      City     |");
		        System.out.println("|------------|-------------------|---------------|");
				for(int i=0;i<n;i++)
					if(ap[i].getCity().toLowerCase().indexOf(city.toLowerCase()) != -1){
						ap[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("City not existed in the data!");
				break;
			}
		}
    }
}
