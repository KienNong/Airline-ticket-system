package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class customerList implements list{
    private int n;
    public customer[] cus = new customer[1000];
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void input(){
        Scanner in = new Scanner (System.in);
        int type;
        System.out.println("Input number of customers: ");
        this.n = in.nextInt();
        System.out.println("----------------------");
        System.out.println("(1) Customer buying ticket");
        System.out.println("(2) Customer go");
        System.out.println("----------------------");
        for (int i = 0; i < n; i++) {
            System.out.println("--Input information of the customer "+ i + 1 + "--");
            System.out.print("Customer type ");
            type = in.nextInt();
            if (type==1){
                cus[i].setID("KHM" + Integer.toString(i));
                cus[i] = new customer();
                cus[i].input();
            }
            else if (type==2){
                cus[i].setID("KHD" + Integer.toString(i));
                cus[i] = new customerGo();
                cus[i].input();
            }
        }
        System.out.println("----------------------");
    }
    public void openFileCustomer(){
        try{
    	    int i=0;
    	    Scanner sc = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\customer.txt"));
    	    try{
    		    while(sc.hasNextLine()){
    			    String []cusType = new String[2];
    			    String cusID = sc.nextLine();
    			    cusType = cusID.split("_");
    			    String surname = sc.nextLine();
    			    String name = sc.nextLine();
    			    String cmnd = sc.nextLine();
    			    String phone = sc.nextLine();
    			    if(cusType[0].equals("KHM")){
    				   cus[i]=new customer(cusID,surname,name,cmnd,phone);
    				   i++;
    			    }
    			    else if(cusType[0].equals("KHD")){
    				   String visa = sc.nextLine();
    				   cus[i]=new customerGo(cusID,surname,name,cmnd,phone,visa);
    				   i++;
    			    }
    		    }
    	    } catch(Exception e) {}
    	    finally{
    	        n=i;
    		    sc.close();
    	    }
       }
       catch(Exception e) {}
    }
    public void output(){
        System.out.println("|-----------------|--------------------|-----------------------|--------------------|-------------|");
    	System.out.println("|   Customer ID   |     Full name      |          CMND         |         Phone      |     Visa    |");
    	System.out.println("|-----------------|--------------------|-----------------------|--------------------|-------------|");
        for(int i=0; i < n; i++){
    		if(cus[i] instanceof customerGo){
    			cus[i].output();
    			System.out.println("|-----------------|--------------------|-----------------------|--------------------|-------------|");
    		}
    		else{
    			cus[i].output();
    			System.out.println("NONE         |");
    			System.out.println("|-----------------|--------------------|-----------------------|--------------------|-------------|");			
	    	}
    	}
    }
    public void insertFile(){
        try{
    		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\customer.txt"));	
    		for(int i=0; i < n-1; i++){
    		    String []cusType = new String[2];
    			cusType = cus[i].getID().split("_");
    			bw.write(cus[i].getID());
    			bw.newLine();
    			bw.write(cus[i].getSurname());
    			bw.newLine();
    			bw.write(cus[i].getName());
    			bw.newLine();
    			bw.write(cus[i].getCmnd());
    			bw.newLine();
    			bw.write(cus[i].getPhone());
    			bw.newLine();
    			if(cusType[0].equals("KHD")){
 				   bw.write(((customerGo)cus[i]).getVisa());
 				   bw.newLine();
 			    }
    		}
    		String []cusType = new String[2];
			cusType = cus[n-1].getID().split("_");
    		bw.write(cus[n-1].getID());
			bw.newLine();
			bw.write(cus[n-1].getSurname());
			bw.newLine();
			bw.write(cus[n-1].getName());
			bw.newLine();
			bw.write(cus[n-1].getCmnd());
			bw.newLine();
			bw.write(cus[n-1].getPhone());
			bw.newLine();
			if(cusType[0].equals("KHD")){
			    bw.write(((customerGo)cus[n-1]).getVisa());
		    }
			bw.close();
    	} catch(IOException e) {}
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
        int type, number;
        Scanner in = new Scanner(System.in);
        System.out.println("Input the number of customers: ");
        number = in.nextInt();
        if (number <= 0) {
            System.out.println("No addition!");
            return;
        }
        else{
            int count = n;
            n += number;
            while (count != n) {
                System.out.println("--Customer addition--");
                System.out.println("1. Customer buying ticket");
                System.out.println("2. Customer go");          
                System.out.println("Your selection: ");
                type = in.nextInt();
                if (type==1){
                	in = new Scanner(System.in);
                	cus[count] = new customer();
                	System.out.print("Input customer ID: ");
                	String id = in.nextLine();
                    cus[count].setID("KHM_" + id);
                    System.out.println("Your customer ID: " + cus[count].getID());
                    cus[count].input();
                    
                }
                else if (type==2) {
                	in = new Scanner(System.in);
                	cus[count] = new customerGo();
                	System.out.print("Input customer ID: ");
                	String id = in.nextLine();
                    cus[count].setID("KHD_"+id);
                    System.out.println("Your customer ID: " + cus[count].getID());
                    cus[count].input();
                }
                count++;
            }
            System.out.println("--- Add " + number + " customer");
            insertFile();
        }
    }
    public void edition(){
        String editID;
        int choose;
        Scanner in = new Scanner (System.in);
        System.out.println("Input customer ID: ");
        editID = in.nextLine();
        for (int i = 0; i < n; i++) {
            if (editID.equals(cus[i].getID())){
                if (cus[i] instanceof customer) {
                    System.out.println("Select action");
                    System.out.println("1. Edit customer ID");
                    System.out.println("2. Edit customer surname");
                    System.out.println("3. Edit customer name");
                    System.out.println("4. Edit CMND");
                    choose = in.nextInt();
                    choose = checkChoose(choose, 1, 4);
                    switch (choose){
                        case 1:{
                            String cusID;
                            System.out.println("Input new customer ID: ");
                            cusID = in.nextLine();
                            cus[i].setID(cusID);
                            break;
                        }
                        case 2:{
                            String surname;
                            System.out.println("Input new customer surname: ");
                            surname = in.nextLine();
                            cus[i].setSurname(surname);
                            break;
                        }
                        case 3:{ 
                            String name;
                            System.out.println("Input new customer name: ");
                            name = in.nextLine();
                            cus[i].setName(name);
                            break;
                        }
                        case 4:{
                            String CMND;
                            System.out.println("Input new CMND: ");
                            CMND = in.nextLine();
                            cus[i].setCmnd(CMND);
                            break;
                        }
                    }
                }
                else if (cus[i] instanceof customerGo) {
                    System.out.println("--Input selection--");
                    System.out.println("1. Edit customer ID");
                    System.out.println("2. Edit customer surname");
                    System.out.println("3. Edit customer name");
                    System.out.println("4. Edit CMND");
                    System.out.println("5. Edit visa");
                    choose = in.nextInt();
                    choose = checkChoose(choose, 1, 5);
                    switch (choose){
                        case 1:{
                        	in = new Scanner (System.in);
                            String cusID;
                            System.out.print("Input new customer ID: ");
                            cusID = in.nextLine();
                            cus[i].setID(cusID);
                            System.out.println("Customer ID edition was succesful!");
                            break;
                        }
                        case 2:{
                        	in = new Scanner (System.in);
                            String surname;
                            System.out.println("Input new customer surname: ");
                            surname = in.nextLine();
                            cus[i].setSurname(surname);
                            System.out.println("Customer surname edition was succesful!");
                            break;
                        }
                        case 3:{
                        	in = new Scanner (System.in);
                            String name;
                            System.out.println("Input new customer name: ");
                            name = in.nextLine();
                            cus[i].setName(name);
                            System.out.println("Customer name edition was succesful!");
                            break;
                        }
                        case 4:{
                        	in = new Scanner (System.in);
                            String CMND;
                            System.out.println("Input new CMND: ");
                            CMND = in.nextLine();
                            cus[i].setCmnd(CMND);
                            System.out.println("Customer CMND edition was succesful!");
                            break;
                        }
                        case 5:{
                        	in = new Scanner (System.in);
                            String visa;
                            System.out.println("Input new visa: ");
                            visa = in.nextLine();
                            ((customerGo)cus[i]).setVisa(visa);
                            System.out.println("Customer visa edition was succesful!");
                            break;
                        }
                    }
                }
            }
            else
                System.out.println("Your customer ID is incorrect!");
        }
    }
    public void deletion(){
        Scanner in = new Scanner (System.in);
        String deleteID;
        System.out.print("Input customer ID (press 0 to not delete): ");
        deleteID = in.nextLine();
        if (deleteID != "0") {
            for (int i = 0; i < n; i++) {
                if (deleteID.equals(cus[i].getID())) {
                    for (int j = i; j < n; j++){
                    cus[j]=cus[j+1];
                    }
                    n--;
                }
            }
        }
        else{
            System.out.println("No deletion!");
            return;
        }
        System.out.println("Customer deletion sucessful!");
    }
    public void search(){
        Scanner in = new Scanner (System.in);
        System.out.println("-------Select action-------");
        System.out.println("1. Search by customer ID");
        System.out.println("2. Search by customer name");
        System.out.println("3. Search by CMND");
        int choose = in.nextInt();
        choose = checkChoose(choose, 1, 3);
        switch (choose){
            case 1:{
            	in = new Scanner (System.in);
                System.out.println("Input customer ID: ");
                String id = in.nextLine();
                for (int i = 0; i < n; i++) {
                    if (cus[i].getID().equals(id))
                        cus[i].output();
                }
                break;
            }
            case 2:{
            	in = new Scanner (System.in);
                System.out.print("Input customer name: ");
                String name = in.nextLine();
                for (int i = 0; i < n; i++) {
                    if (cus[i].getName().toLowerCase().indexOf(name.toLowerCase()) != -1)
                        cus[i].output();
                }
                break;
            }
            case 3:{
            	in = new Scanner (System.in);
                System.out.print("Input CMND: ");
                String cmnd = in.nextLine();
                for (int i = 0; i < n; i++) {
                    if (cus[i].getCmnd().equals(cmnd)) 
                        cus[i].output();
                }
                break;
            }
        }
    }
    public void statistic(){
        int numCusGo = 0, numCusBuy = 0;
        for (int i = 0; i < n; i++) {
            String[] splitted = cus[i].getID().split("_");
            if (splitted[0].equals("KHM")) {
                numCusBuy++;
            }
            else if (splitted[0].equals("KHD")) {
                numCusGo++;
            }
        }
        int totalnum = numCusBuy + numCusGo;
        System.out.println("Total number of customers: " + totalnum);
        System.out.println("Number of customer buy: " + numCusBuy);
        System.out.println("Number of customer go: " + numCusGo);
    }
}
