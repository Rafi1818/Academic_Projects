

public class Faculty extends Employee{
    int officeHours = 0;
    String rank = "";
    Faculty(String name, String address, String phoneNumber, String emailId, String office, double salary, int month, int date, int year, int officeHoursIn, String rankIn){
        super(name, address, phoneNumber, emailId, office, salary, month, date, year);
        officeHours = officeHoursIn;
        rank = rankIn;
    }
    public String toString(){
        return "Faculty: " + super.getName();
    }
}