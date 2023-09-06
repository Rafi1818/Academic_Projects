

public class Staff extends Employee{
    String title = "";
    Staff(String name, String address, String phoneNumber, String emailId, String office, double salary, int month, int date, int year, String titleIn){
        super(name, address, phoneNumber, emailId, office, salary, month, date, year);
        title = titleIn;
    }
    public String toString(){
        return "Staff: " + super.getName();
    }
}