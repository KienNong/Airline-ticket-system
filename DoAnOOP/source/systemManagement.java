package source;
import java.util.Scanner;

public class systemManagement {
    public systemManagement(){}
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
    public static void MainMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------");
		System.out.println("|     Air Ticket Booking System Management   |");
		System.out.println("----------------------------------------------");
		System.out.println("");
		System.out.println("------------------Menu ATBSM-----------------");
		System.out.println("| 1. System management                      |");
		System.out.println("| 2. Sell ticket                            |");
		System.out.println("| 3. Search                                 |");
		System.out.println("| 4. Statistic                              |");
		System.out.println("| 0. Exit                                   |");
		System.out.println("---------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
        int choose = in.nextInt();
        choose = checkChoose(choose, 0, 4);
        switch(choose){
            case 1:{
                systemManagement();
				break;
            }
			case 2:{
				sellTicket();
				break;
			}
			case 3:{
				search();
				break;
			}
			case 4:{
				statistic();
				break;
			}
			case 0:{
				System.out.println("-------Exit code-------");
				break;
			}
        }
    }
	public static void systemManagement(){
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("--------------System Management Menu-----------");
		System.out.println("| 1. Flight management                        |");
		System.out.println("| 2. Sell ticket management                   |");
		System.out.println("| 3. Order and staff management               |");
		System.out.println("| 0. Back to menu ATBSM                       |");
		System.out.println("-----------------------------------------------");
		System.out.println("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose, 0, 3);
		switch(choose){
			case 1:{
				flightManagement flightM = new flightManagement();
				flightM.flightManagementMenu();
				break;
			}
			case 2:{
				sellTicketManagement stM = new sellTicketManagement();
				stM.sellTicketManagementMenu();
				break;
			}
			case 3:{
				orderAndStaffManagement oasM = new orderAndStaffManagement();
				oasM.orderAndStaffManagementMenu();
				break;
			}
			case 0:{
				MainMenu();
				break;
			}
		}
	}
	public static void returnBack(){
		Scanner in = new Scanner(System.in);
		System.out.println("-------Press ENTER to back-------");
		String s = in.nextLine();
		System.out.println("");
	}
	public static void sellTicket(){
		Scanner in = new Scanner(System.in);
		customerList cusl = new customerList();
		cusl.openFileCustomer();
		reservationTicketList rtl = new reservationTicketList();
		rtl.openFile();
		orderList orl = new orderList();
		orl.openFile();
		flightList fll = new flightList();
		fll.openFile();
		fll.emptySeatsCalculation();
		ticketList tkl = new ticketList();
		tkl.openFile();
		orderDetailList odl = new orderDetailList();
		odl.openFile();
		System.out.println("-------Add customer information-------");
		cusl.addition();
		rtl.addition();
		orl.addition();
		System.out.println("-------Add customer go information--------");
		cusl.addition();
		System.out.print("Input departure station: ");
		String destation = in.nextLine();
		System.out.print("Input arrival station: ");
		String arrstation = in.next();
		System.out.println("---------------------------------------------------Flight list-------------------------------------------------------------");
		System.out.println("-----------|-------------|-------------|-------------|----------------|----------------|-----------------|-----------------");
		System.out.println("| Plane ID |  Flight ID  |  Journey ID |  DeStation  |   ArrStation   |     DeTime     |      ArrTime    |   Empty seats  |");
		System.out.println("|----------|-------------|-------------|-------------|----------------|----------------|-----------------|----------------|");
		for(int i=0;i<fll.getN();i++)
			if(fll.f[i].getDepartureStation().toLowerCase().indexOf(destation.toLowerCase()) != -1 && fll.f[i].getArrivalStation().toLowerCase().indexOf(arrstation.toLowerCase()) != -1){
				fll.f[i].output();
			}
		tkl.addition();
		odl.createOrderDetailList();
		fll.emptySeatsCalculation();
		fll.insertFile();
		returnBack();
		MainMenu();
	}
	public static void search(){
		Scanner in=new Scanner(System.in);
		System.out.println("");
		System.out.println("-----------------Search menu-----------------");
		System.out.println("| 1. Search ticket                          |");
		System.out.println("| 2. Search customer                        |");
		System.out.println("| 3. Search flight                          |");
		System.out.println("| 4. Search order                           |");
		System.out.println("| 5. Search staff                           |");
		System.out.println("| 6. Search journey                         |");
		System.out.println("| 7. Search airport                         |");
		System.out.println("| 8. Search plane                           |");
		System.out.println("| 9. Search seat                            |");
		System.out.println("| 10. Search ticket class                   |");
		System.out.println("| 11. Search price                          |");
		System.out.println("| 12. Search order detail                   |");
		System.out.println("| 13. Search reservation ticket             |");
		System.out.println("| 0. Back to menu ATBSM                     |");
		System.out.println("---------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose,0,13);
		switch(choose){
			case 1:{
				ticketList tkl = new ticketList();
				tkl.openFile();
				tkl.search();
				returnBack();
				search();
				break;
			}
			case 2:{
				customerList cusl = new customerList();
				cusl.openFileCustomer();
				cusl.search();
				returnBack();
				search();
				break;
			}
			case 3:{
				flightList fll = new flightList();
				fll.openFile();
				fll.emptySeatsCalculation();
				fll.search();
				returnBack();
				search();
				break;
			}
			case 4:{
				orderList orl = new orderList();
				orl.openFile();
				orl.search();
				returnBack();
				search();
				break;
			}
			case 5:{
				staffList sfl = new staffList();
				sfl.openFile();
				sfl.search();
				returnBack();
				search();
				break;
			}
			case 6:{
				journeyList jl = new journeyList();
				jl.openFile();
				jl.search();
				returnBack();
				search();
				break;
			}
			case 7:{
				airportList apl = new airportList();
				apl.openFile();
				apl.search();
				returnBack();
				search();
				break;
			}
			case 8:{
				planeList pll = new planeList();
				pll.openFile();
				pll.search();
				returnBack();
				search();
				break;
			}
			case 9:{
				seatList stl = new seatList();
				stl.openFile();
				stl.search();
				returnBack();
				search();
				break;
			}
			case 10:{
				ticketClassList tcl = new ticketClassList();
				tcl.openFile();
				tcl.search();
				returnBack();
				search();
				break;
			}
			case 11:{
				priceList pl = new priceList();
				pl.openFile();
				pl.search();
				returnBack();
				search();
				break;
			}
			case 12:{
				orderDetailList odl = new orderDetailList();
				odl.openFile();
				odl.search();
				returnBack();
				search();
				break;
			}
			case 13:{
				reservationTicketList rtl = new reservationTicketList();
				rtl.openFile();
				rtl.search();
				returnBack();
				search();
				break;
			}
			case 0:{
				MainMenu();
				break;
			}
		}
	}
	public static void statistic(){
		Scanner in=new Scanner(System.in);
		System.out.println("");
		System.out.println("----------------Statistic menu--------------|");
		System.out.println("| 1. Ticket statistic                       |");
		System.out.println("| 2. Customer statistic                     |");
		System.out.println("| 3. Flight statistic                       |");
		System.out.println("| 4. Order statistic                        |");
		System.out.println("| 5. Staff statistic                        |");
		System.out.println("| 6. Journey statistic                      |");
		System.out.println("| 0. Back to menu ATBSM                     |");
		System.out.println("---------------------------------------------");
		System.out.println("");
		System.out.print("Your selection: ");
		int choose = in.nextInt();
		choose = checkChoose(choose,0,6);
		switch(choose){
			case 1:{
				ticketList tkl = new ticketList();
				tkl.openFile();
				tkl.statistic();
				returnBack();
				statistic();
				break;
			}
			case 2:{
				customerList cusl = new customerList();
				cusl.openFileCustomer();
				cusl.statistic();
				returnBack();
				statistic();
				break;
			}
			case 3:{
				flightList fll = new flightList();
				fll.openFile();
				fll.emptySeatsCalculation();
				fll.statistic();
				returnBack();
				statistic();
				break;
			}
			case 4:{
				orderList orl = new orderList();
				orl.openFile();
				orl.statistic();
				returnBack();
				statistic();
				break;
			}
			case 5:{
				staffList sfl = new staffList();
				sfl.openFile();
				sfl.statistic();
				returnBack();
				statistic();
				break;
			}
			case 6:{
				journeyList jll = new journeyList();
				jll.openFile();
				jll.statistic();
				returnBack();
				statistic();
				break;
			}
			case 0:{
				MainMenu();
				break;
			}
		}
	}
}
