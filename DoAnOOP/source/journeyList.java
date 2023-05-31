package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class journeyList implements list{
    private int n;
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public journey[] getJ() {
        return j;
    }
    public void setJ(journey[] j) {
        this.j = j;
    }
    public journey[] j = new journey[100];
    public void insertFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\journey.txt"));
            for(int i=0; i < n-1; i++){
                bw.write(j[i].getJourneyID());
                bw.newLine();
                bw.write(j[i].getJourneyName());
                bw.newLine();
                bw.write(Integer.toString(j[i].getPrice()));
                bw.newLine();
            }
            bw.write(j[n-1].getJourneyID());
			bw.newLine();
			bw.write(j[n-1].getJourneyName());
			bw.newLine();
			bw.write(Integer.toString(j[n-1].getPrice()));
			bw.close();
        } catch (IOException e) {
            //Do nothing;
        }
    }
    public void openFile(){
        int i = 0;
        try {
            Scanner fo = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\journey.txt"));
            try {
                while(fo.hasNextLine()){
                    String journeyID = fo.nextLine();
                    String journeyName = fo.nextLine();
                    int price = Integer.parseInt(fo.nextLine());
                    j[i] = new journey(journeyID, journeyName, price);
                    i++;
                }
            }
            finally{
                n = i;
                fo.close();
            }
        } catch (IOException e) {
            //Do nothing;
        }
    }
    public void output(){
        System.out.println("====================Journey list===================");
		System.out.println("-------------|-----------------------|----------------");
		System.out.println("| Journey ID |      Journey name     |     Price     |");
		System.out.println("|------------|-----------------------|---------------|");
        for(int i=0;i<n;i++)
			j[i].output();
    }
    public void addition(){
        Scanner in = new Scanner(System.in);
        System.out.println("Journey addition");
        System.out.println("Input number of journey you want to add: ");
        int x = in.nextInt();
        int check = 0;
        for (int i = n; i < n + x; i++){
            in = new Scanner(System.in);
            System.out.println("Input journey ID: ");
            String jID = in.nextLine();
            do{
                check = 0;
                for(int b=0; b < n;b++){
                    if(jID.equalsIgnoreCase(j[b].getJourneyID())){
                        System.out.println("Invalid! This journey ID already in the data");
                        check = 1;
                    }
                }
                if (check == 1){
                    System.out.println("Input another journey ID: ");
                    jID = in.nextLine();
                }
            }while (check == 1);
            if(check == 0){
                in = new Scanner(System.in);
                System.out.println("Input journey name: ");
                String jName = in.nextLine();
                System.out.println("Input price: ");
                int p = in.nextInt();
                j[i] = new journey(jID, jName, p);
            }
        }
        n = n + x;
        insertFile();
        System.out.println("Journey addition was succesful!");
        System.out.println();
    }
    public void edition(){
        Scanner in = new Scanner(System.in);
        System.out.println("Select action:");
        System.out.println("1. Edit journey name");
        System.out.println("2. Edit price");
        System.out.println("Your selection: ");
        int choose = in.nextInt();
        while (choose < 1 || choose > 2){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch (choose) {
            case 1:{
                in = new Scanner(System.in);
                System.out.println("Input journey ID you want to edit: ");
                String jID = in.nextLine();
                System.out.println("Input new journey name: ");
                String newjName = in.nextLine();
                for(int i=0; i<n; i++){
                    if(jID.equalsIgnoreCase(j[i].getJourneyID())){
                        j[i].setJourneyName(newjName);
                    }
                }
                System.out.println("Journey name edition was succesful!");
                insertFile();
                break;
            }
            case 2:{
                in = new Scanner(System.in);
                System.out.println("Input journey ID you want to edit: ");
                String jID = in.nextLine();
                System.out.println("Input new price: ");
                Integer newPrice = in.nextInt();
                for(int i=0; i<n; i++){
                    if(jID.equalsIgnoreCase(j[i].getJourneyID())){
                        j[i].setPrice(newPrice);
                    }
                }
                System.out.println("Journey price edition was succesful!");
                insertFile();
                break;
            }
        }
    }
    public void deletion(){
        Scanner in = new Scanner(System.in);
        System.out.println("Journey deletion");
        System.out.println("Do you wanna delete journey ID? [y/n]: ");
        String choose = in.nextLine();
        switch (choose){
            case "y":{
                in = new Scanner(System.in);
                System.out.println("Input journey ID that you want to delete: ");
                String jID = in.nextLine();
                for(int i=0; i<n; i++){
                    if(jID.equals(j[i].getJourneyID())){
                        for(int k=i;k<n;k++){
                            j[k] = j[k+1];
                            n--;
                        }
                        if(j[i] == null)
                            break;
                    }
                }
                System.out.println("Journey deletion was succesful!");
                insertFile();
                break;
            }
            case "n":{
                System.out.println("Not delete journey!");
                break;
            }
            default:{
                System.out.println("Invalid input!");
                break;
            }
        }
    }
    public void search(){
        Scanner in = new Scanner(System.in);
        System.out.println("Select action");
        System.out.println("1. Search by journey ID: ");
        System.out.println("2. Search by journey name: ");
        int choose = in.nextInt();
        while(choose < 1 || choose > 2){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch (choose) {
            case 1:{
                int check = 0;
                in = new Scanner(System.in);
                System.out.println("Input journey ID you want to search: ");
                String jID = in.nextLine();
                System.out.println("-------------|-----------------------|----------------");
				System.out.println("| Journey ID |      Journey name     |      Price    |");
				System.out.println("|------------|-----------------------|---------------|");
                for(int i=0; i<n; i++){
                    if(jID.equalsIgnoreCase(j[i].getJourneyID())){
                        j[i].output();
                        check = 1;
                    }
                }
                if (check == 0){
                    System.out.println("Can't find your journey ID!");
                }
                break;
            }
            case 2:{
                int check = 0;
                in = new Scanner(System.in);
                System.out.println("Input journey name you want to search: ");
                String jName = in.nextLine();
                System.out.println("-------------|-----------------------|----------------");
				System.out.println("| Journey ID |      Journey name     |      Price    |");
				System.out.println("|------------|-----------------------|---------------|");
                for(int i=0; i<n; i++){
                    if(j[i].getJourneyName().toLowerCase().indexOf(jName.toLowerCase()) != -1){
                        j[i].output();
                        check = 1;    
                    }
                }
                if (check ==0){
                    System.out.println("Can't find your journey name!");
                }
                break;
            }
        }
    }
    public String outputTable(String m, int n){
        String s = "";
        for(int i=0; i< n - m.length(); i++){
            s = s + " ";
        }
        return s;
    }
    public void statistic(){
		int temp[] = new int[100];
		for(int i=0;i<n;i++)
			temp[i]=0;
		for(int i=0;i<n-1;i++){
			int d=1;
			for(int k=i+1;k<n;k++){
				if(j[i].getJourneyName().equals(j[k].getJourneyName()) && temp[k]==0){
					d++;
					temp[k]=1;
				}
			}
			if(temp[i]==0)
				System.out.println("Journey from "+ j[i].getJourneyName() + outputTable(j[i].getJourneyName(),21) + " has " + d);
		}
	}
}
