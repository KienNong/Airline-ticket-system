package source;
import java.util.Scanner;

public class orderAndStaffManagement {
    public static void main(String[] args) {
        orderAndStaffManagementMenu();
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
    public static void orderAndStaffManagementMenu(){
        Scanner in =new Scanner(System.in);
		System.out.println("-----------------Order And Staff Management Menu--------------");
		System.out.println("| 1. Order management                                        |");
		System.out.println("| 2. Price management                                        |");
		System.out.println("| 3. Reservation ticket management                           |");
		System.out.println("| 4. Ticket class management                                 |");
		System.out.println("| 5. Order detail management                                 |");
		System.out.println("| 6. Staff management                                        |");
		System.out.println("| 0. Back to System Management Menu                          |");
		System.out.println("--------------------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose,0,6);
		switch(choose){
			case 1:{
				orderManagement();
				break;
			}
			case 2:{
				priceManagement();
				break;
			}
			case 3:{
				reservationTicketManagement();
				break;
			}
			case 4:{
				ticketClassManagement();
				break;
			}
			case 5:{
				orderDetailManagement();
				break;
			}
			case 6:{
				staffManagement();
				break;
			}
			case 0:{
				systemManagement sysM = new systemManagement();
				sysM.systemManagement();
				break;
			}
		}
    }
    public static void orderManagement(){
        orderList orl  = new orderList();
		orl.openFile();
		Scanner in =new Scanner(System.in);
		System.out.println("---------Order & Order Detail Management Menu--------");
		System.out.println("| 1. Full list of orders                            |");
		System.out.println("| 2. Search order detail                            |");
		System.out.println("| 3. Add order                                      |");
		System.out.println("| 4. Edit order                                     |");
		System.out.println("| 5. Delete order                                   |");
		System.out.println("| 0. Back to Order and Staff Management Menu        |");
		System.out.println("-----------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose =in.nextInt();
		choose = checkChoose(choose,0,5); 
		switch(choose){
			case 1:{
				orl.output();
				returnBack();
				orderManagement();
				break;
			}
			case 2:{
				orl.search();
				returnBack();
				orderManagement();
				break;
			}
			case 3:{
				orl.addition();
				returnBack();
				orderManagement();
				break;
			}
			case 4:{
				orl.edition();
				returnBack();
				orderManagement();
				break;
			}
			case 5:{
				orl.deletion();
				returnBack();
				orderManagement();
				break;
			}
			case 0:{
				orderAndStaffManagementMenu();
				break;
			}
		}
    }
    public static void priceManagement(){
        Scanner in =new Scanner(System.in);
		priceList pl = new priceList();
		pl.openFile();
		System.out.println("--------------Price Management Menu------------------");
		System.out.println("| 1. Full list of price                             |");
		System.out.println("| 2. Search price                                   |");
		System.out.println("| 3. Edit price                                     |");
		System.out.println("| 4. Delete price                                   |");
		System.out.println("| 0. Back to Order and Staff Management Menu        |");
		System.out.println("-----------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose,0,4); 
		switch(choose){
			case 1:{
		    	pl.output();
				returnBack();
				priceManagement();
				break;
			}
			case 2:{
				pl.search();
				returnBack();
				priceManagement();
				break;
			}
			case 3:{
				pl.edition();
				returnBack();
				priceManagement();
				break;
			}
			case 4:{
				pl.deletion();
				returnBack();
				priceManagement();
				break;
			}
			case 0:{
				orderAndStaffManagementMenu();
				break;
            }
		}
    }
    public static void reservationTicketManagement(){
        Scanner in =new Scanner(System.in);
		reservationTicketList rtl = new reservationTicketList();
		rtl.openFile();
		System.out.println("---------Reservation Ticket Management Menu----------");
		System.out.println("| 1. Full list of reservation tickets               |");
		System.out.println("| 2. Search reservation ticket                      |");
		System.out.println("| 3. Add reservation ticket                         |");
		System.out.println("| 4. Edit reservation ticket                        |");
		System.out.println("| 5. Delete reservation ticket                      |");
		System.out.println("| 0. Back to Order and Staff Management Menu        |");
		System.out.println("-----------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose,0,5); 
		switch(choose){
			case 1:{
				rtl.output();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 2:{
				rtl.search();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 3:{
			    rtl.addition();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 4:{
				rtl.edition();
				returnBack();
				reservationTicketManagement();
	    		break;
			}
			case 5:{
				rtl.deletion();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 0:{
				orderAndStaffManagementMenu();
				break;
			}
		}
    }
    public static void ticketClassManagement(){
        Scanner in =new Scanner(System.in);
		ticketClassList tcl = new ticketClassList();
		tcl.openFile();
		System.out.println("------------Ticket Class Management Menu------------");
		System.out.println("| 1. Full list of ticket class                     |");
		System.out.println("| 2. Search ticket class                           |");
		System.out.println("| 3. Add ticket class                              |");
		System.out.println("| 4. Edit ticket class                             |");
		System.out.println("| 5. Delete ticket class                           |");
		System.out.println("| 0. Back to Order and Staff Management Menu       |");
		System.out.println("----------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose,0,5); 
		switch(choose){
			case 1:{
				tcl.output();
				returnBack();
				ticketClassManagement();
				break;
			}
			case 2:{
		    	tcl.search();
			    returnBack();
				ticketClassManagement();
				break;
			}
			case 3:{
				tcl.addition();
				returnBack();
				ticketClassManagement();
				break;
			}
			case 4:{
				tcl.edition();
				returnBack();
				ticketClassManagement();
				break;
			}
			case 5:{
				tcl.deletion();
				returnBack();
				ticketClassManagement();
				break;
			}
			case 0:{
				orderAndStaffManagementMenu();
				break;
			}
		}
    }
    public static void orderDetailManagement(){
        orderDetailList odl = new orderDetailList();
		odl.openFile();
		Scanner in = new Scanner(System.in);
		System.out.println("--------------Order Detail Management Menu-------------");
		System.out.println("| 1. Full list of order detail                        |");
		System.out.println("| 2. Search order detail                              |");
		System.out.println("| 3. Add order detail                                 |");
		System.out.println("| 4. Edit order detail                                |");
		System.out.println("| 5. Delete order detail                              |");
		System.out.println("| 0. Back to Order and Staff Management Menu          |");
		System.out.println("-----------------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose,0,5); 
		switch(choose){
			case 1:{
				odl.output();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 2:{
				odl.search();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 3:{
				odl.addition();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 4:{
				odl.edition();
				returnBack();
				reservationTicketManagement();
				break;
			}
			case 5:{
				odl.deletion();
				returnBack();
		    	reservationTicketManagement();
				break;
			}
		    case 0:{
				orderAndStaffManagementMenu();
				break;
			}
		}
    }
    public static void staffManagement(){
        staffList sfl = new staffList();
	    sfl.openFile();
	    Scanner in =new Scanner(System.in);
	    System.out.println("----------------Staff Management Menu----------------");
	    System.out.println("| 1. Full list of staffs                            |");
	    System.out.println("| 2. Search staff                                   |");
	    System.out.println("| 3. Add staff                                      |");
	    System.out.println("| 4. Edit staff                                     |");
	    System.out.println("| 5. Delete staff                                   |");
	    System.out.println("| 0. Back to Order and Staff Management Menu        |");
	    System.out.println("-----------------------------------------------------");
	    System.out.println("");
	    System.out.print("Your selection: ");
	    int choose=in.nextInt();
	    choose = checkChoose(choose,0,5); 
	    switch(choose){
		    case 1:{
			    sfl.output();
			    returnBack();
			    staffManagement();
		        break;
            }
		    case 2:{
			    sfl.search();
			    returnBack();
			    staffManagement();
			    break;
	    	}
		    case 3:{
			    sfl.addition();
			    returnBack();
			    staffManagement();
			    break;
		    }
		    case 4:{
			    sfl.edition();
			    returnBack();
		        staffManagement();
			    break;
		    }
		    case 5:{
			    sfl.deletion();
			    returnBack();
			    staffManagement();
			    break;
	    	}
		    case 0:{
			    orderAndStaffManagementMenu();
		    	break;
		    }
	    }
    }
}
