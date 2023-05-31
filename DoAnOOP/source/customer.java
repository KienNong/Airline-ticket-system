package source;
import java.util.Scanner;
public class customer {
    protected String ID, surname, name, cmnd, phone;
    public customer(String id, String sn, String n, String cmnd, String p){
        this.ID = id;
        this.surname = sn;
        this.name = n;
        this.cmnd = cmnd;
        this.phone = p;
    }
    public customer(){
        this.ID = "Will be generated";
        this.surname = "N/A";
        this.name = "N/A";
        this.cmnd = "N/A";
        this.phone = "N/A";
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCmnd() {
        return cmnd;
    }
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println ("- Customer information -");
        System.out.print ("Surname: ");
        this.surname = in.nextLine();
        System.out.print ("Name: ");
        this.name = in.nextLine();
        System.out.print ("Identity card: ");
        this.cmnd = in.nextLine();
        System.out.print ("Phone number: ");
        this.phone = in.nextLine();
    }
    public void output(){
        System.out.print("|"+ID+outputTable(ID,17)+surname + " " + name + outputTable(surname + " " + name,20) + cmnd + outputTable(cmnd,23) + phone + outputTable(phone,20));
    }
    public String outputTable(String m, int n){
        String s = "";
		for(int i=0;i<n-m.length();i++){
			s = s + " ";
		}
		s = s + "|";
		return s;
    }
}
