public class Employee extends Person{
    String office = "";
    double salary = 0.00;
    int month = 0;
    int date = 0;
    int year = 0;

    //arg constructor
    Employee(String name, String address, String phoneNumber, String emailId, String officeIn, double salaryIn, int monthIn, int dateIn, int yearIn){
        super(name, address, phoneNumber, emailId);
        office = officeIn;
        salary = salaryIn;
        month = monthIn;
        date = dateIn;
        year = yearIn;
    }

    //getter for the date hired
    public void getDateHired(){
        MyDate hired = new MyDate(month, date, year);
        hired.toString();
    }

    //overriding toString() method
    @Override
    public String toString(){
        return "Employee: " + super.getName();
    }
}