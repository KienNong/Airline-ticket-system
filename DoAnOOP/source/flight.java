package source;
import java.util.Scanner;
public class flight{
		private String planeID;
        private String flightID;
		private String journeyID;
		private	String departureTime;
		private String arrivalTime;
		private String departureStation;
		private String arrivalStation;
		private int numberOfEmptySeats;
		public flight(){
			planeID =" ";
			flightID = " ";
			journeyID = " ";
			departureTime = " ";
			arrivalTime = " ";
		}
		public flight(String pID, String fID, String jID, String dt, String at){
			planeID = pID;
			flightID = fID;
			journeyID = jID;
			departureTime = dt;
			arrivalTime = at;
		}
		public flight(flight f){
			planeID = f.planeID;
			flightID = f.flightID;
			journeyID = f.journeyID;
			departureTime = f.departureTime;
			arrivalTime= f.arrivalTime;
		}
		public void input(){
			Scanner in = new Scanner(System.in);
			System.out.println("Input plane ID: ");
			planeID = in.nextLine();
			System.out.println("Input flight ID: ");
			flightID = in.nextLine();
			System.out.println("Input journey ID: ");
			journeyID = in.nextLine();
			System.out.println("Input departure station: ");
			departureStation = in.nextLine();
			System.out.println("Input arrival station: ");
			arrivalStation = in.nextLine();
			System.out.println("Input departure time: ");
			departureTime = in.nextLine();
			System.out.println("Input arrival time: ");
			arrivalTime = in.nextLine();
		}
        public String getPlaneID() {
            return planeID;
        }
        public void setPlaneID(String planeID) {
            this.planeID = planeID;
        }
        public String getFlightID() {
            return flightID;
        }
        public void setFlightID(String flightID) {
            this.flightID = flightID;
        }
        public String getJourneyID() {
            return journeyID;
        }
        public void setJourneyID(String journeyID) {
            this.journeyID = journeyID;
        }
        public String getDepartureTime() {
            return departureTime;
        }
        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }
        public String getArrivalTime() {
            return arrivalTime;
        }
        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }
        public String getDepartureStation() {
            return departureStation;
        }
        public void setDepartureStation(String departureStation) {
            this.departureStation = departureStation;
        }
        public String getArrivalStation() {
            return arrivalStation;
        }
        public void setArrivalStation(String arrivalStation) {
            this.arrivalStation = arrivalStation;
        }
        public int getnumberOfEmptySeats() {
            return numberOfEmptySeats;
        }
        public void setnumberOfEmptySeats(int numberOfEmptySeats) {
            this.numberOfEmptySeats = numberOfEmptySeats;
        }
		public void output(){	
			System.out.println("|"+planeID+outputTable(planeID,10)+flightID+outputTable(flightID,13)+journeyID+outputTable(journeyID,13)+departureStation + outputTable(departureStation,13)+arrivalStation+outputTable(arrivalStation,16)+departureTime+outputTable(departureTime,16)+arrivalTime+outputTable(arrivalTime,17)+numberOfEmptySeats+outputTable(Integer.toString(numberOfEmptySeats),16));
			System.out.println("|----------|-------------|-------------|-------------|----------------|----------------|-----------------|----------------|");
		}		
		public String outputTable(String m,int n){
			String s = "";
			for(int i=0;i<n-m.length();i++){
				s = s + " ";
			}
			s = s + "|";
			return s;
		}
}
