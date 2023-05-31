package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class planeList implements list{
    private int n;
    public plane[] pl = new plane[200];
    public void insertFile(){
        try {
		    BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\plane.txt"));
		    for(int i=0; i < n-1; i++){
		        bw.write(pl[i].getPlaneID());
		        bw.newLine();
		        bw.write(pl[i].getBrand());
		        bw.newLine();
		        bw.write(pl[i].getType());
		        bw.newLine();
		        bw.write(Integer.toString(pl[i].getNumberOfSeats()));
		        bw.newLine();
		    }
			bw.write(pl[n-1].getPlaneID());
			bw.newLine();
			bw.write(pl[n-1].getBrand());
			bw.newLine();
			bw.write(pl[n-1].getType());
			bw.newLine();
			bw.write(Integer.toString(pl[n-1].getNumberOfSeats()));
			bw.close();
		}
		catch(IOException e) {}
    }
    public void openFile(){
        int i=0;
		try{
			Scanner in = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\plane.txt"));
			try{
				while(in.hasNextLine()){
					String plID = in.nextLine();
					String brand = in.nextLine();
					String type = in.nextLine();
					int numberOfSeats=Integer.parseInt(in.nextLine());
					pl[i]=new plane(plID, numberOfSeats, brand, type);
					i++;
				}
			}
			finally{
				n = i;
				in.close();
			}
		}catch(IOException e) {}
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
    public void output(){
        System.out.println("------------------------------Plane list-------------------------------------");
		System.out.println("-------------|--------------------------------|--------------|---------------");
		System.out.println("|  Plane ID  |              Brand             |     Type     | Num of seats |");
		System.out.println("|------------|--------------------------------|--------------|--------------|");
        for(int i=0;i<n;i++)
			pl[i].output();
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public plane[] getPl() {
        return pl;
    }
    public void setPl(plane[] pl) {
        this.pl = pl;
    }
    public void addition(){
        Scanner in = new Scanner(System.in);
		System.out.println("-----Plane addition-----");
		System.out.print("Number of planes: ");
		int h = in.nextInt();
		int check = 0;
		for(int i = n; i< n+h; i++){
			in = new Scanner(System.in);
			System.out.println("Input plane ID: ");
			String plID=in.nextLine();
			do{
			    check = 0;
			    for(int j = 0; j < n; j++)
				    if(plID.equals(pl[j].getPlaneID())){
					    System.out.println("Plane ID already in the data!");
					    check = 1;
				    }
				if(check == 1){
					System.out.print("Pre-enter plane ID: ");
					plID=in.nextLine();
				}
			} while(check == 1);
			if(check == 0){
				in=new Scanner(System.in);
				System.out.print("Input brand:");
				String brand = in.nextLine();
				System.out.print("Input type:");
				String type = in.nextLine();
				System.out.print("Input number of seats:");
				int nos = in.nextInt();
				pl[i]=new plane(plID, nos, brand, type);
			}			
		}
		n = n + h;
		insertFile();
		System.out.println("Plane addition was succesful!");
		System.out.println("-------------------------");
    }
    public void edition(){
        Scanner in=new Scanner(System.in);
		System.out.println("-------Select action-------");
		System.out.println("1. Edit brand");
		System.out.println("2. Edit type");
		System.out.println("3. Edit number of seats");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 3);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input plane ID: ");
				String plID = in.nextLine();
				System.out.println("Input new brand: ");
				String brand = in.nextLine();
				for(int i=0;i<n;i++){
					if(plID.equals(pl[i].getPlaneID()))
						pl[i].setBrand(brand);
				}
				System.out.println("Brand edition was succesful!");
				insertFile();
				break;
			}
			case 2:{
				in = new Scanner(System.in);
				System.out.println("Input plane ID: ");
				String plID = in.nextLine();
				System.out.println("Input new type: ");
				String type = in.nextLine();
				for(int i=0; i < n; i++){
					if(plID.equals(pl[i].getPlaneID()))
						pl[i].setType(type);
				}
				System.out.println("Type edition was successful!");
				insertFile();
				break;
			}
			case 3:{
				in = new Scanner(System.in);
				System.out.println("Input plane ID: ");
				String plID=in.nextLine();
				System.out.println("Input new number of seats: ");
				int nos = in.nextInt();
				for(int i=0;i<n;i++){
					if(plID.equals(pl[i].getPlaneID()))
						pl[i].setNumberOfSeats(nos);
				}
				System.out.println("Number of seats edition was succesful!");
				insertFile();
				break;
			}
		}
    }
    public void deletion(){
        Scanner in = new Scanner(System.in);
		System.out.println("-----Plane deletion-----");
		System.out.print("Do you want to delete plane? [y/n]: ");
		String k = in.nextLine();
		switch(k){
			case "y":{
			System.out.println("Input plane ID: ");
			String plID=in.nextLine();
			for(int i=0; i < n; i++)
				if(plID.equals(pl[i].getPlaneID())){
					for(int j=i;j<n;j++)
						pl[j]=pl[j+1];
					n--;
					if(pl[i]==null)
					    break;
				}
				System.out.println("Da xoa ma may bay");
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
		System.out.println("1. Search by plane ID");
		System.out.println("2. Search by brand");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 1, 2);
		switch(choose){
			case 1:{
				int check = 0;
				in = new Scanner(System.in);
				System.out.println("Input plane ID: ");
				String plID = in.nextLine();
				System.out.println("-------------|--------------------------------|--------------|---------------");
		        System.out.println("|  Plane ID  |              Brand             |     Type     | Num of seats |");
		        System.out.println("|------------|--------------------------------|--------------|--------------|");
				for(int i=0;i<n;i++)
					if(pl[i].getPlaneID().equals(plID)){
                        pl[i].output();
						check = 1;
                    }
				if(check == 0)
                    System.out.println("Plane ID not existed in the data!");
				break;
			}
			case 2:{
				int check = 0;
				in = new Scanner(System.in);
				System.out.println("Input brand: ");
				String brand = in.nextLine();
				System.out.println("-------------|--------------------------------|--------------|---------------");
		        System.out.println("|  Plane ID  |              Brand             |     Type     | Num of seats |");
		        System.out.println("|------------|--------------------------------|--------------|--------------|");
				for(int i=0;i<n;i++)
					if((pl[i].getBrand().toLowerCase()).indexOf(brand.toLowerCase()) != -1){
						pl[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Brand not existed in the data!");
				break;
			}
        }
    }
}
