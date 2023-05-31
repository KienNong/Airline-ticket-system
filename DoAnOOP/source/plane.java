package source;
import java.util.Scanner;

public class plane {
    private String planeID;
    private int numberOfSeats;
    private String brand;
    private String type;
    public plane(){
        planeID = " ";
        numberOfSeats = 0;
        brand = " ";
        type = " ";
    }
    public plane(String pID, int nos, String b, String t){
        planeID = pID;
        numberOfSeats = nos;
        brand = b;
        type = t;
    }
    public plane(plane p){
        planeID = p.planeID;
        numberOfSeats = p.numberOfSeats;
        brand = p.brand;
        type = p.type;
    }
    public String getPlaneID() {
        return planeID;
    }
    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
		System.out.print("Input plane ID: ");
		planeID = in.nextLine();
		System.out.print("Input plane's brand: ");
		brand=in.nextLine();
		System.out.print("Input plane's type: ");
		type=in.nextLine();
		System.out.print("Input number of seats: ");
		numberOfSeats=in.nextInt();
    }
    public void output(){
        System.out.println("|" + planeID + outputTable(planeID,12) + brand + outputTable(brand,32) + type + outputTable(type,14) + numberOfSeats + outputTable(Integer.toString(numberOfSeats),14));
		System.out.println("|------------|--------------------------------|--------------|--------------|");
    }
    public String outputTable(String m,int n)
	{
		String s = "";
		for(int i=0; i < n - m.length(); i++){
			s = s + " ";
		}
		s = s + "|";
		return s;  
	}
}
