package source;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class flightList implements list{
    private int n;
    public flight[] f = new flight[100];
    public flightList(){}
    public int getN() {
        return n;
    }
    public void setN(int n){
        this.n = n;
    }
    public void insertFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\flight.txt"));
            for(int i=0; i<n-1; i++){
                bw.write(f[i].getPlaneID());
		        bw.newLine();
		        bw.write(f[i].getFlightID());
		        bw.newLine();
		        bw.write(f[i].getJourneyID());
		        bw.newLine();
		        bw.write(f[i].getDepartureTime());
		        bw.newLine();
		        bw.write(f[i].getArrivalTime());
		        bw.newLine();
            }
                bw.write(f[n-1].getPlaneID());
		        bw.newLine();
		        bw.write(f[n-1].getFlightID());
		        bw.newLine();
		        bw.write(f[n-1].getJourneyID());
		        bw.newLine();
		        bw.write(f[n-1].getDepartureTime());
		        bw.newLine();
		        bw.write(f[n-1].getArrivalTime());
		        bw.close();
        } catch (Exception e) {
            //Do nothing;
        }
    }
    public void openFile(){
        int i = 0;
		ticketList tkl = new ticketList();
        planeList pll = new planeList();
		pll.openFile();
        journeyList jl = new journeyList();
        jl.openFile();
        try {
            Scanner fo = new Scanner(new File("C:\\Users\\KN\\Downloads\\Code\\DoAnOOP\\flight.txt"));
            try {
                while(fo.hasNextLine()){
                    String planeID = fo.nextLine();
                    String flightID = fo.nextLine();
                    String journeyID = fo.nextLine();
                    String departureTime = fo.nextLine();
                    String arrivalTime = fo.nextLine();
                    f[i] = new flight(planeID, flightID, journeyID, departureTime, arrivalTime);
                    String []s = new String[10];
                    for(int k=0; k<jl.getN(); k++){
						if(jl.j[k].getJourneyID().equals(f[i].getJourneyID()))
							s=jl.j[k].getJourneyName().split("->");
					}
					f[i].setDepartureStation(s[0]);
					f[i].setArrivalStation(s[1]);
					//---------------------------------------
					for(int k=0; k<pll.getN(); k++)
						if(pll.pl[k].getPlaneID().equals(f[i].getPlaneID()))
							f[i].setnumberOfEmptySeats(pll.pl[k].getNumberOfSeats());
					i++;
                }
            } catch (Exception e) {
                //Do nothing;
            }
            finally{
                n = i;
                fo.close();
            }
        } catch (IOException e){
            // Do nothing;
        }
    }
    public void emptySeatsCalculation(){
        ticketList tl = new ticketList();
        tl.openFile();
        for(int i=0; i<n; i++)
            for(int k = 0; k<tl.getN();k++)
                if(tl.tt[k].getFlightID().equals(f[i].getFlightID()))
                    f[i].setnumberOfEmptySeats(f[i].getnumberOfEmptySeats()-1);
    }
    public void output(){
		System.out.println("----------------------------------------------------Flight list------------------------------------------------------------");
		System.out.println("-----------|-------------|-------------|-------------|----------------|----------------|-----------------|-----------------");
		System.out.println("| Plane ID |  Flight ID  |  Journey ID |  DeStation  |    ArStation   |     DeTime     |      ArTime     |   Empty seats  |");
		System.out.println("|----------|-------------|-------------|-------------|----------------|----------------|-----------------|----------------|");
		for(int i=0;i<n;i++)
			f[i].output();
	}
    public void addition(){
		Scanner in = new Scanner(System.in);
		System.out.println("-----Flight addition-----");
		System.out.print("How much flights you want to add: ");
		int h = in.nextInt();
		int check = 0;	
		for(int i=n;i<n+h;i++){
			in = new Scanner(System.in);
			System.out.println("Input flight ID: ");
			String fID = in.nextLine();
				do{
				check = 0;
				for(int k=0; k<n; k++)
					if(fID.equals(f[k].getFlightID())){
						System.out.println("Invaild! This flight ID already in the data");
						check = 1;
					}
				if(check == 1){
						System.out.print("Input another flight ID: ");
						fID = in.nextLine();
					}
				} while(check == 1);
				if(check == 0){
						in = new Scanner(System.in);
						System.out.println("Input journey ID in the data: ");
						String jID = in.nextLine();
						System.out.println("Input plane ID: ");
						String pID = in.nextLine();
						System.out.println("Input departure time: ");
						String deTime = in.nextLine();
						System.out.println("Input arrival time: ");
						String arTime = in.nextLine();
						f[i] = new flight(fID,jID,pID,deTime,arTime);
				}
		}
		n = n + h;
		insertFile();
		System.out.println("Flight addition was successful!");
    }
    public void edition(){
        Scanner in = new Scanner(System.in);
        System.out.println("---Select action---");
        System.out.println("1. Edit plane ID");
        System.out.println("2. Edit flight ID");
        System.out.println("3. Edit journey ID");
        System.out.println("4. Edit departure time");
        System.out.println("5. Edit arrival time");
        System.out.println("Your selection: ");
        int choose = in.nextInt();
        while (choose < 1 || choose > 5){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch(choose){
            case 1:{
                in = new Scanner(System.in);
				System.out.println("Input flight ID: ");
				String fID = in.nextLine();
				System.out.println("Input new plane ID: ");
				String newpID = in.nextLine();
				for(int i=0;i<n;i++){
					if(fID.equals(f[i].getFlightID()))
						f[i].setPlaneID(newpID);
				}
				System.out.println("Plane ID edition was succesful!");
				insertFile();
				break;
            }
            case 2:{
				in = new Scanner(System.in);
				System.out.println("Input flight ID: ");
				String fID = in.nextLine();
				System.out.print("Input new flight ID: ");
				String newfID = in.nextLine();
				for(int i=0; i<n; i++)
				{
					if(fID.equals(f[i].getFlightID()))
						f[i].setFlightID(newfID);
				}
				System.out.println("Flight ID edition was succesful!");
				insertFile();
				break;
			}
            case 3:{
				journeyList jl = new journeyList();
				jl.openFile();
				int check = 0;
				in = new Scanner(System.in);
				System.out.print("Input flight ID: ");
				String fID = in.nextLine();
				System.out.print("Input new journey ID in the data: ");
				String newjID = in.nextLine();
				for(int i=0;i<jl.getN();i++){
					if(newjID.equals(jl.j[i].getJourneyID()))
						check = 1;
				}
				if(check == 1){
					for(int i=0; i<n; i++){
						if(fID.equals(f[i].getFlightID()))
							f[i].setJourneyID(newjID);
					}
					System.out.println("Journey ID edition was succesful!");
					insertFile();
				}
				if(check == 0)
					System.out.println("Your new journey ID not existed in the data!");
				break;
			}
            case 4:{
                in = new Scanner(System.in);
				System.out.println("Input flight ID: ");
				String fID = in.nextLine();
				System.out.println("Input new departure time: ");
				String newDeTime = in.nextLine();
				for(int i=0;i<n;i++){
					if(fID.equals(f[i].getFlightID()))
						f[i].setDepartureTime(newDeTime);
				}
				System.out.println("Departure time edition was succesful!");
				insertFile();
				break;
            }
            case 5:{
                in = new Scanner(System.in);
			    System.out.println("Insert flight ID: ");
			    String fID = in.nextLine();
			    System.out.println("Input new arrival time: ");
			    String newArTime=in.nextLine();
			    for(int i=0; i<n; i++){
				    if(fID.equals(f[i].getFlightID()))
					    f[i].setArrivalTime(newArTime);
			    }
			    System.out.println("Arrival time edition was succesful!");
			    insertFile();
		        break;
            }
        }
    }
    public void deletion(){
        Scanner in = new Scanner(System.in);
        System.out.println("---Select action---");
        System.out.println("1. Delete plane ID");
        System.out.println("2. Delete flight ID");
        System.out.println("3. Delete journey ID");
        System.out.println("Your selection: ");
        int choose = in.nextInt();
        while (choose < 1 || choose > 3){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch(choose){
            case 1:{
                in = new Scanner(System.in);
				System.out.println("Input flight ID: ");
				String fID=in.nextLine();
				for(int i=0;i<n;i++)
					if(fID.equals(f[i].getFlightID())){
						while(fID.equals(f[i].getFlightID()) == true){
							for(int k=i;k<n;k++)
								f[k] = f[k+1];
							n--;
							if(f[i]==null)
								break;
						}
					}
				System.out.println("Plane ID deletion was succesful!");
				insertFile();
                break;
            }
            case 2:{
                in = new Scanner(System.in);
                System.out.println("Do you want to delete flight ID? [y/n]: ");
                String s = in.nextLine();
                switch(s){
                    case "y":{
                        in = new Scanner(System.in);
                        System.out.println("Input flight ID");
                        String fID = in.nextLine();
                        for(int i=0;i<n;i++)
							if(fID.equals(f[i].getFlightID())){
								while(fID.equals(f[i].getFlightID())==true){
									for(int k=i; k<n; k++)
										f[k] = f[k+1];
									n--;
									if(f[i] == null)
										break;
								}
							}
						System.out.println("Flight ID deletion was succesful");
						insertFile();
						break;
                    }
                    case "n":{
						System.out.println("No deletion!");
						break;
					}
                }
                break;
            }
            case 3:{
                in = new Scanner(System.in);
				System.out.println("Input journey ID: ");
				String jID = in.nextLine();
				for(int i=0; i<n; i++)
					if(jID.equals(f[i].getJourneyID())){
						while(jID.equals(f[i].getJourneyID()) == true){
							for(int k=i; k<n; k++)
								f[k]=f[k+1];
							n--;
							if(f[i]==null)
								break;
						}
					}
				System.out.println("Journey ID deletion was succesful!");
				insertFile();
				break;
            }
        }
    }
    public void search(){
        Scanner in = new Scanner(System.in);
        System.out.println("---Select action---");
		System.out.println("1. Search by plane ID");
		System.out.println("2. Search by flight ID");
		System.out.println("3. Search by journey ID");
		System.out.print("Your selection: ");
        int choose = in.nextInt();
        while (choose < 1 || choose > 3){
            System.out.println("Invalid selection! Please re-enter");
            System.out.println("Your re-enter: ");
            choose = in.nextInt();
        }
        switch(choose){
			case 1:{
				in = new Scanner(System.in);
				System.out.println("Input plane ID: ");
				String pID = in.nextLine();
				System.out.println("-----------|-------------|-------------|-------------|----------------|----------------|-----------------|-----------------");
				System.out.println("|  PlaneID |  Flight ID  | Journey ID  |  DeStation  |    ArStation   |     DeTime     |     ArTime      |   Empty Seats  |");
				System.out.println("|----------|-------------|-------------|-------------|----------------|----------------|-----------------|----------------|");
				for(int i=0; i<n; i++)
					if(f[i].getPlaneID().equals(pID))
						f[i].output();
				break;
			}
			case 2:{
				in = new Scanner(System.in);
				System.out.println("Input flight ID: ");
				String fID = in.nextLine();
				System.out.println("-----------|-------------|-------------|-------------|----------------|----------------|-----------------|-----------------");
				System.out.println("|  PlaneID |  Flight ID  | Journey ID  |  DeStation  |    ArStation   |     DeTime     |     ArTime      |   Empty Seats  |");
				System.out.println("|----------|-------------|-------------|-------------|----------------|----------------|-----------------|----------------|");
				for(int i=0;i<n;i++)
					if(f[i].getFlightID().equals(fID))
						f[i].output();
				break;
			}
			case 3:{
				in = new Scanner(System.in);
				System.out.println("Input journey ID: ");
				String jID = in.nextLine();
				System.out.println("-----------|-------------|-------------|-------------|----------------|----------------|-----------------|-----------------");
				System.out.println("|  PlaneID |  Flight ID  | Journey ID  |  DeStation  |    ArStation   |     DeTime     |     ArTime      |   Empty Seats  |");
				System.out.println("|----------|-------------|-------------|-------------|----------------|----------------|-----------------|----------------|");
				for(int i=0;i<n;i++)
					if(f[i].getJourneyID().equals(jID))
						f[i].output();
				break;
			}
		}
    }
    public void statistic(){
	    int d = 0;
	    for(int i=0;i<n;i++)
	        d++;
	    System.out.println("|----------------------|------------|");
	    System.out.println("|   Number of flights  |"+ d + outputTable(Integer.toString(d),12) + "|");
	    System.out.println("|----------------------|------------|");
	}
    public String outputTable(String m, int n){
        String s = "";
		for(int i=0; i < n-m.length(); i++){
			s = s + " ";
		}
		return s;
    }
}
