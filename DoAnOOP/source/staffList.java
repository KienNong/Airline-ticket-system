package source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class staffList implements list{
    private int n;
    public staff[] sf = new staff[100];
    public staffList(){}
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public staff[] getSf() {
        return sf;
    }
    public void setSf(staff[] sf) {
        this.sf = sf;
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
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\staff.txt"));
			for(int i=0;i<n-1;i++){
				bw.write(sf[i].getStaffID());
				bw.newLine();
				bw.write(sf[i].getSurname());
				bw.newLine();
				bw.write(sf[i].getName());
				bw.newLine();
				bw.write(sf[i].getShift());
				bw.newLine();
				bw.write(Integer.toString(sf[i].getSalary()));
				bw.newLine();
			}
			bw.write(sf[n-1].getStaffID());
			bw.newLine();
			bw.write(sf[n-1].getSurname());
			bw.newLine();
			bw.write(sf[n-1].getName());
			bw.newLine();
			bw.write(sf[n-1].getShift());
			bw.newLine();
			bw.write(Integer.toString(sf[n-1].getSalary()));
			bw.close();
		} catch(Exception e){}
    }
    public void openFile(){
        try	{	
			int i=0;
			Scanner in = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\staff.txt"));
			try{
				while(in.hasNextLine()){
					String sfID = in.nextLine();
					String surname = in.nextLine();
					String name = in.nextLine();
					String shift = in.nextLine();
					int salary = Integer.parseInt(in.nextLine());
					sf[i] = new staff(sfID, surname, name, shift, salary);
					i++;
				}
			} catch(Exception e){}
			finally{
				n = i;
				in.close();
			}
		} catch(IOException e){}
    }
    public void output(){
		System.out.println("-------------------------------------------------Staff list------------------------------------------");
		System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
		System.out.println("|   Staff ID   |      Surname     |         Name        |         Shift       |       Salary        |");
		System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
		for(int i=0;i<n;i++)
			sf[i].output();
	}
    public void addition(){
        Scanner in = new Scanner(System.in);
		System.out.print("Input staff ID: ");		
		String sfID = in.nextLine();
		int check = 0;
		do {
			check = 0;
			for(int i=0; i < n; i++)
				if(sfID.equals(sf[i].getStaffID())){
					System.out.println("Staff ID already in the data!");
					check = 1;
				}
			if(check == 1){
				System.out.print("Pre-enter staff ID: ");	
				sfID = in.nextLine();
			}
		} while(check == 1);
		if(check == 0){
			System.out.println("Input staff surname: ");
			String surname = in.nextLine();
			System.out.println("Input staff name: ");
			String name = in.nextLine();
			System.out.println("Input shift: ");
			String shift = in.nextLine();
			System.out.println("Nhap luong : ");
			int salary = in.nextInt();
			sf[n] = new staff(sfID, surname, name, shift, salary);
			System.out.println("Staff addition succesful!");
			n++;
			insertFile();
		}
    }
    public void edition(){
        Scanner in = new Scanner(System.in);
		System.out.println("-------Select action-------");
		System.out.println("1. Edit staff surname");
		System.out.println("2. Edit staff name");
		System.out.println("3. Edit staff salary");
		System.out.println("4. Edit staff shift");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 4);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input staff ID: ");
				String sfID = in.nextLine();
				System.out.println("Input new staff surname: ");
				String newSurname = in.nextLine();
				for(int i=0; i < n; i++)
					if(sfID.equals(sf[i].getStaffID()))
						sf[i].setSurname(newSurname);
				System.out.println("Surname edition was succesful!");
				insertFile();
				break;
			}
			case 2:{
				in = new Scanner(System.in);
				System.out.println("Input staff ID: ");
				String sfID = in.nextLine();
				System.out.println("Input new staff name: ");
				String newName = in.nextLine();
				for(int i=0; i < n; i++)
					if(sfID.equals(sf[i].getStaffID()))
						sf[i].setName(newName);
				System.out.println("Name edition was succesful!");
				insertFile();
				break;
			}
			case 3:{
				in = new Scanner(System.in);
				System.out.println("Input staff ID: ");
				String sfID = in.nextLine();
				System.out.println("Input new staff salary: ");
				int newSalary = in.nextInt();
				for(int i=0; i < n; i++)
					if(sfID.equals(sf[i].getStaffID()))
						sf[i].setSalary(newSalary);
				System.out.println("Salary edition was succesful!");
				insertFile();
				break;
			}
			case 4:
			{
				in=new Scanner(System.in);
				System.out.println("Input staff ID: ");
				String sfID = in.nextLine();
				System.out.println("Input new staff shift: ");
				String newShift = in.nextLine();
				for(int i=0; i<n; i++)
					if(sfID.equals(sf[i].getStaffID()))
						sf[i].setShift(newShift);
				System.out.println("Shift edition was succesful!");
				insertFile();
				break;
			}
		}
    }
    public void deletion(){
        Scanner in=new Scanner(System.in);
		System.out.println("-------Staff deletion-------");
		System.out.print("Input the staff ID: ");
		String sfID=in.nextLine();
			for(int i=0;i<n;i++)
				if(sfID.equals(sf[i].getStaffID())){
					for(int j=i;j<n;j++)
						sf[j]=sf[j+1];
					n--;
				}
			System.out.println("Staff deletion was succesful!");
			insertFile();
    }
    public void search(){
        Scanner in=new Scanner(System.in);
		System.out.println("-------Select action-------");
		System.out.println("1. Search staff by ID");
		System.out.println("2. Search staff by surname");
		System.out.println("3. Search staff by name");
		System.out.println("4. Search staff by shift");
		System.out.println("Your selection: ");
		int choose = in.nextInt();
        choose = checkChoose(choose, 1, 4);
		switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input staff ID: ");
				String sfID = in.nextLine();
				int check = 0;
				System.out.println("-------------------------------------------------Staff list------------------------------------------");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
		        System.out.println("|   Staff ID   |      Surname     |         Name        |         Shift       |       Salary        |");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
				for(int i=0;i<n;i++)
					if(sfID.equals(sf[i].getStaffID())){
						sf[i].output();
						check = 1;
					}
				if(check == 0) 
                    System.out.println("Staff ID not existed in the data");
				break;
			}
			case 2:{
		    	in = new Scanner(System.in);
				System.out.print("Input staff surname: ");
				String surname = in.nextLine();
				int check = 0;
				System.out.println("-------------------------------------------------Staff list------------------------------------------");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
		        System.out.println("|   Staff ID   |      Surname     |         Name        |         Shift       |       Salary        |");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
				for(int i=0;i<n;i++)
					if((sf[i].getSurname().toLowerCase()).indexOf(surname.toLowerCase()) != -1){
						sf[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Staff surname not existed in the data!");
				break;
			}
			case 3:{
				in = new Scanner(System.in);
				System.out.println("Input staff name: ");
				String name = in.nextLine();
				int check = 0;
				System.out.println("-------------------------------------------------Staff list------------------------------------------");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
		        System.out.println("|   Staff ID   |      Surname     |         Name        |         Shift       |       Salary        |");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
				for(int i=0;i<n;i++)
					if((sf[i].getName().toLowerCase()).indexOf(name.toLowerCase()) != -1){
						sf[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Staff name not existed in the data!");
				break;
			}
			case 4:{
				in = new Scanner(System.in);
				System.out.println("Input staff shift: ");
				String shift = in.nextLine();
				int check = 0;
				System.out.println("-------------------------------------------------Staff list------------------------------------------");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
		        System.out.println("|   Staff ID   |      Surname     |         Name        |         Shift       |       Salary        |");
		        System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
				for(int i=0;i<n;i++)
					if(shift.equals(sf[i].getShift())){
						sf[i].output();
						check = 1;
					}
				if(check == 0)
                    System.out.println("Staff shift not existed in the data!");
				break;
			}
		}
    }
    public void statistic(){
		int num = 0, sumSalary = 0;
        for(int i=0; i < n; i++){
			num++;
			sumSalary = sumSalary + sf[i].getSalary();
		}
        System.out.println("-------------------------Staff list--------------------------");
		System.out.println("|----------------------|------------------------------------|");
		System.out.println("|     Total staffs     |           Total salary             |");
		System.out.println("|----------------------|------------------------------------|");
		System.out.println("| " + num + outputTable(Integer.toString(num),21) + sumSalary + outputTable(Integer.toString(sumSalary),35));
		System.out.println("|----------------------|------------------------------------|");
    }
    public String outputTable(String m, int n){
        String s = "";
        for(int i = 0; i <n-m.length(); i++){
            s = s + " ";
        }
        s = s + "|" + " ";
        return s;
    }
}
