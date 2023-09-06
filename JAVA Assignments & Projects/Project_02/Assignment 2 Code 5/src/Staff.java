

public class Staff extends Employee{
    String title = "";

    //arg contructor
    Staff(String name, String address, String phoneNumber, String emailId, String office, double salary, int month, int date, int year, String titleIn){
        super(name, address, phoneNumber, emailId, office, salary, month, date, year);
        title = titleIn;
    }

    //overriding toString() method
    @Override
    public String toString(){
        return "Staff: " + super.getName();
    }
}