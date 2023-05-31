package source;
import java.util.Scanner;

public class flightManagement {
    public static void main(String[] args) {
        flightManagementMenu();
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
    public static void flightManagementMenu(){
        Scanner in =new Scanner(System.in);
	    System.out.println("---------------Flight Management Menu-----------------");
    	System.out.println("| 1. Flight management                               |");
	    System.out.println("| 2. Plane management                                |");
	    System.out.println("| 3. Airport management                              |");
	    System.out.println("| 4. Journey management                              |");
	    System.out.println("| 5. Seat management                                 |");
	    System.out.println("| 0. Back to System Management Menu                  |");
	    System.out.println("------------------------------------------------------");
	    System.out.println("");
	    System.out.print("Your selection: ");
	    int choose = in.nextInt();
        choose = checkChoose(choose, 0, 5);
	    switch(choose){
		    case 1:{
			    flightManagement();
			    break;
		    }
		    case 2:{
			    planeManagement();
			    break;
		    }
		    case 3:{
			    airportManagement();
			    break;
		    }
		    case 4:{
		    	journeyManagement();
			    break;
		    }
		    case 5:{
			    seatManagement();
			    break;
		    }
		    case 0:{
		    	systemManagement sysM = new systemManagement();
		    	sysM.systemManagement();
			    break;
	    	}
	    }
    }
    public static void flightManagement(){
        flightList fll =new flightList();
	    fll.openFile();
	    fll.emptySeatsCalculation();
	    Scanner in =new Scanner(System.in);
	    System.out.println("---------------Flight Management Menu----------------");
    	System.out.println("| 1. Full list of flight                            |");
	    System.out.println("| 2. Search flight                                  |");
    	System.out.println("| 3. Add flight                                     |");
	    System.out.println("| 4. Edit flight                                    |");
	    System.out.println("| 5. Delete flight                                  |");
	    System.out.println("| 0. Back to Flight Management Menu                 |");
	    System.out.println("-----------------------------------------------------");
	    System.out.println("");
	    System.out.print("Your selection: ");
	    int choose = in.nextInt();
        choose = checkChoose(choose, 0, 5);
		switch(choose){
			case 1:{
				fll.output();
				returnBack();
				flightManagement();
				break;
			}
			case 2:{
				fll.search();
				returnBack();
				flightManagement();
				break;
			}
			case 3:{
				fll.addition();
				returnBack();
				flightManagement();
				break;
			}
			case 4:{
				fll.edition();
				returnBack();
				flightManagement();
				break;
			}
			case 5:{
				fll.deletion();
				returnBack();
				flightManagement();
				break;
			}
			case 0:{
				flightManagementMenu();
				break;
			}
		}
    }
    public static void planeManagement(){
        Scanner in =new Scanner(System.in);
	    planeList pl=new planeList();
	    pl.openFile();
	    System.out.println("----------------Plane Management Menu----------------");
	    System.out.println("| 1. Full list of planes                            |");
	    System.out.println("| 2. Search plane                                   |");
	    System.out.println("| 3. Add plane                                      |");
	    System.out.println("| 4. Edit plane                                     |");
	    System.out.println("| 5. Delete plane                                   |");
	    System.out.println("| 0. Back to Flight Management Menu                 |");
	    System.out.println("-----------------------------------------------------");
	    System.out.println("");
	    System.out.print("Your selection: ");
	    int choose = in.nextInt();
        choose = checkChoose(choose, 0, 5);
		switch(choose){
			case 1:{
				pl.output();
				returnBack();
				planeManagement();
				break;
			}
			case 2:{
				pl.search();
				returnBack();
				planeManagement();
				break;
			}
			case 3:{
				pl.addition();
				returnBack();
				planeManagement();
				break;
			}
			case 4:{
				pl.edition();
				returnBack();
				planeManagement();
				break;
			}
			case 5:{
				pl.deletion();
				returnBack();
				planeManagement();
				break;
			}
			case 0:{
				flightManagementMenu();
				break;
			}
		}
    }
    public static void airportManagement(){
        Scanner in =new Scanner(System.in);
	    airportList apl = new airportList();
    	apl.openFile();
    	System.out.println("---------------Airport Management Menu---------------");
    	System.out.println("| 1. Full list of airports                          |");
    	System.out.println("| 2. Search airport                                 |");
    	System.out.println("| 3. Add airport                                    |");
       	System.out.println("| 4. Edit airport                                   |");
    	System.out.println("| 5. Delete airport                                 |");
    	System.out.println("| 0. Back to Flight Management Menu                 |");
    	System.out.println("-----------------------------------------------------");
    	System.out.println("");
    	System.out.print("Your selection: ");
    	int choose = in.nextInt();
        choose = checkChoose(choose, 0, 5);
		switch(choose){
			case 1:{
				apl.output();
				returnBack();
				airportManagement();
				break;
			}
			case 2:{
				apl.search();
				returnBack();
				airportManagement();
				break;
			}
			case 3:{
				apl.addition();
				returnBack();
				airportManagement();
				break;
			}
			case 4:{
				apl.edition();
				returnBack();
				airportManagement();
				break;
			}
			case 5:{
				apl.deletion();
				returnBack();
				airportManagement();
				break;
			}
			case 0:{
				flightManagementMenu();
				break;
			}
		}
    }
    public static void journeyManagement(){
        Scanner in =new Scanner(System.in);
    	journeyList jl=new journeyList();
    	jl.openFile();
    	System.out.println("--------------Journey Management Menu----------------");
    	System.out.println("| 1. Full list of journey                           |");
    	System.out.println("| 2. Search journey                                 |");
    	System.out.println("| 3. Add journey                                    |");
    	System.out.println("| 4. Edit journey                                   |");
    	System.out.println("| 5. Delete journey                                 |");
	    System.out.println("| 6. Journey statistic                              |");
    	System.out.println("| 0. Back to Flight Management Menu                 |");
    	System.out.println("-----------------------------------------------------");
    	System.out.println("");
    	System.out.print("Your selection: ");
    	int choose = in.nextInt();
        choose = checkChoose(choose, 0, 6);
		switch(choose){
			case 1:{
				jl.output();
				returnBack();
				journeyManagement();
				break;
			}
			case 2:{
				jl.search();
				returnBack();
				journeyManagement();
				break;
			}
			case 3:{
				jl.addition();
				returnBack();
				journeyManagement();
				break;
			}
			case 4:{
				jl.edition();
				returnBack();
				journeyManagement();
				break;
			}
			case 5:{
				jl.deletion();
				returnBack();
				journeyManagement();
				break;
			}
			case 6:{
				jl.statistic();
				returnBack();
				journeyManagement();
				break;
			}
			case 0:{
				flightManagementMenu();
				break;
			}
		}
    }
    public static void seatManagement(){
        seatList sl = new seatList();
	    sl.openFile();
    	Scanner in = new Scanner(System.in);
       	System.out.println("-----------------Seat Management Menu----------------");
    	System.out.println("| 1. Full list of seats                             |");
    	System.out.println("| 2. Search seat                                    |");
    	System.out.println("| 3. Add seat                                       |");
    	System.out.println("| 4. Edit seat                                      |");
    	System.out.println("| 5. Delete seat                                    |");
	    System.out.println("| 0. Back to Flight Management Menu                 |");
	    System.out.println("-----------------------------------------------------");
	    System.out.println("");
	    System.out.print("Your selection: ");
	    int choose = in.nextInt();
        choose = checkChoose(choose, 0, 5);
		switch(choose){
			case 1:{
				sl.output();
				returnBack();
				seatManagement();
				break;
			}
			case 2:{
				sl.search();
				returnBack();
				seatManagement();
				break;
			}
			case 3:{
				sl.addition();
				returnBack();
				seatManagement();
				break;
			}
			case 4:{
				sl.edition();
				returnBack();
				seatManagement();
				break;
			}
			case 5:{
				sl.deletion();
				returnBack();
				seatManagement();
				break;
			}
			case 0:{
				flightManagementMenu();
				break;
			}
		}
    }
}
