package source;
import java.util.Scanner;

public class staff {
    String staffID;
    String surname;
    String name;
    String shift;
    static int salary = 10000000;
    public staff(){}
    public staff(String stID, String s, String n, String sh, int sal){
        this.staffID = stID;
        this.surname= s;
        this.name = n;
        this.shift = sh;
        this.salary = sal;
    }
    public staff(staff s){
        this.staffID = s.staffID;
        this.surname = s.surname;
        this.name = s.name;
        this.shift = s.shift;
        this.salary = s.salary;
    }
    public String getStaffID() {
        return staffID;
    }
    public void setStaffID(String staffID) {
        this.staffID = staffID;
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
    public String getShift() {
        return shift;
    }
    public void setShift(String shift) {
        this.shift = shift;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void input(){
		Scanner in = new Scanner(System.in);
		System.out.print("Input staff ID: ");
		staffID = in.nextLine();
		System.out.print("Input staff's surname: ");
		surname = in.nextLine();
		System.out.print("Input staff's name: ");
		name = in.nextLine();
		System.out.print("Input staff's shift: ");
		shift = in.nextLine();
		System.out.print("Input staff's salary: ");
		salary = in.nextInt();
	}
    public void output(){
        System.out.println("|" + staffID + outputTable(staffID,14) + surname + outputTable(surname,17) + name + outputTable(name,20) + shift + outputTable(shift,20) + salary + outputTable(Integer.toString(salary),20));
		System.out.println("|--------------|------------------|---------------------|---------------------|---------------------|");
    }
    public String outputTable(String m, int n){
        String s = "";
        for(int i=0; i < n-m.length(); i++){
            s = s + " ";
        }
        s = s + "|" + " ";
        return s;
    }
}
