

public class Student extends Person{
    String status = "";
    Student(String name, String address, String phoneNumber, String emailId){
        super(name, address, phoneNumber, emailId);
    }
    public void isFreshman(){
        status = "Freshman";
    }
    public void isSophomore(){
        status = "Sophomore";
    }
    public void isJunior(){
        status = "Junior";
    }
    public void isSenior(){
        status = "Senior";
    }

    public String toString(){
        return "Student: " + super.getName();
    }
}