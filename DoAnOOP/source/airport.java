package source;
import java.util.Scanner;

public class airport {
    private String airportID;
    private String airportName;
    private String city;
    public airport(){
        airportID = " ";
        airportName = " ";
        city = " ";
    }
    public airport(String apID, String apn, String c){
        airportID = apID;
        airportName = apn;
        city = c;
    }
    public String getAirportID() {
        return airportID;
    }
    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }
    public String getAirportName() {
        return airportName;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public airport(airport ap){
        airportID = ap.airportID;
        airportName = ap.airportName;
        city = ap.city;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
		System.out.println("Input airport's ID: ");
		airportID = in.nextLine();
		System.out.println("Input airport's name: ");
		airportName = in.nextLine();
		System.out.println("Input city: ");
		city = in.nextLine();
    }
    public void output(){
        System.out.println("|" + airportID + outputTable(airportID,12) + airportName + outputTable(airportName,19) + city + outputTable(city,15));
		System.out.println("|------------|-------------------|---------------|");
    }
    public String outputTable(String m, int n){
        String s = "";
		for(int i=0; i < n-m.length(); i++){
			s = s + " ";
		}
		s = s + "|";
		return s;
    }
}
