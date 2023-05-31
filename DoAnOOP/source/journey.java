package source;
import java.util.Scanner;
public class journey{
    private String journeyID;
    private String journeyName;
    private int price;
    public journey(){
        journeyID = " ";
        journeyName = " ";
        price = 0;
    }
    public journey(String jID, String jName, int p){
        journeyID = jID;
        journeyName = jName;
        price = p;
    }
    public journey(journey j){
        journeyID = j.journeyID;
        journeyName = j.journeyName;
        price = j.price;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input journey's ID: ");
        journeyID = in.nextLine();
        System.out.print("Input journey's name: ");
        journeyName = in.nextLine();
        System.out.println("Input price: ");
        price = in.nextInt();
    }
    public String getJourneyID() {
        return journeyID;
    }
    public void setJourneyID(String journeyID) {
        this.journeyID = journeyID;
    }
    public String getJourneyName() {
        return journeyName;
    }
    public void setJourneyName(String journeyName) {
        this.journeyName = journeyName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void output(){
		System.out.println("|"+journeyID+outputTable(journeyID,12)+journeyName+outputTable(journeyName,23)+price+outputTable(Integer.toString(price),15));
		System.out.println("|------------|-----------------------|---------------|");
	}
    public String outputTable(String m, int n){
        String s = "";
        for(int i=0; i< n - m.length(); i++){
            s = s + " ";
        }
        s = s + "|";
        return s;
    }
}