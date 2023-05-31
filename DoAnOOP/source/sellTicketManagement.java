package source;
import java.util.Scanner;

public class sellTicketManagement {
    public static void main(String[] args) {
        sellTicketManagementMenu();
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
	public static void returnBack(){
		Scanner in = new Scanner(System.in);
		System.out.println("-------Press ENTER to back-------");
		String s = in.nextLine();
	}
	public static void sellTicketManagementMenu(){
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("--------------Sell Ticket Management Menu-------------");
		System.out.println("| 1. Ticket management                               |");
		System.out.println("| 2. Customer management                             |");
		System.out.println("| 0. Back to System Management Menu                  |");
		System.out.println("------------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 0, 2);
		switch(choose){
			case 1:{
				ticketManagement();
				break;
			}
			case 2:{
				customerManagement();
				break;
			}
			case 0:{
				systemManagement sysM = new systemManagement();
				sysM.systemManagement();
				break;
			}
		}
	}
	public static void ticketManagement(){
		ticketList tkl = new ticketList();
		tkl.openFile();
		Scanner in = new Scanner (System.in);
		System.out.println("----------------Ticket Management Menu---------------");
		System.out.println("| 1. Full list of tickets                           |");
		System.out.println("| 2. Search ticket                                  |");
		System.out.println("| 3. Add ticket                                     |");
		System.out.println("| 4. Edit ticket                                    |");
		System.out.println("| 5. Delete ticket                                  |");
		System.out.println("| 0. Back to Sell Ticket Management System          |");
		System.out.println("-----------------------------------------------------");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 0, 5);
		switch(choose){
			case 1:{
				tkl.output();
				returnBack();
				ticketManagement();
				break;
			}
			case 2:{
				tkl.search();
				returnBack();
				ticketManagement();
				break;
			}
			case 3:{
				tkl.addition();
				returnBack();
				ticketManagement();
				break;
			}
			case 4:{
				tkl.edition();
				returnBack();
				ticketManagement();
				break;
			}
			case 5:{
				tkl.deletion();
				returnBack();
				ticketManagement();
				break;
			}
			case 0:{
				sellTicketManagementMenu();
				break;
			}
		}
	}	
	public static void customerManagement(){
		Scanner in = new Scanner (System.in);
		customerList cusl = new customerList();
		cusl.openFileCustomer();
		System.out.println();
		System.out.println("--------------Customer Management Menu---------------");
		System.out.println("| 1. Full list of customers                         |");
		System.out.println("| 2. Search customer                                |");
		System.out.println("| 3. Add customer                                   |");
		System.out.println("| 4. Edit customer                                  |");
		System.out.println("| 5. Delete customer                                |");
		System.out.println("| 0. Back to Sell Ticket Management System          |");
		System.out.println("-----------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 0, 5);
		switch(choose){
			case 1:{
				cusl.output();
				returnBack();
				customerManagement();
				break;
			}
			case 2:{
				cusl.search();
				returnBack();
				customerManagement();
				break;
			}
			case 3:{
				cusl.addition();
				returnBack();
				customerManagement();
				break;
			}
			case 4:{
				cusl.edition();
				returnBack();
				customerManagement();
				break;
			}
			case 5:{
				cusl.deletion();
				returnBack();
				customerManagement();
				break;
			}
			case 0:{
				sellTicketManagementMenu();
				break;
			}
		}
	}
}