public class Employee extends Person{
    String office = "";
    double salary = 0.00;
    int month = 0;
    int date = 0;
    int year = 0;

    Employee(String name, String address, String phoneNumber, String emailId, String officeIn, double salaryIn, int monthIn, int dateIn, int yearIn){
        super(name, address, phoneNumber, emailId);
        office = officeIn;
        salary = salaryIn;
        month = monthIn;
        date = dateIn;
        year = yearIn;
    }
    public void dateHired(){
        MyDate hired = new MyDate(month, date, year);
        hired.toString();
    }
    public String toString(){
        return "Employee: " + super.getName();
    }
}