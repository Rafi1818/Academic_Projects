public class Student extends Person{
    String status = "";
    Student(String name, String address, String phoneNumber, String emailId){
        super(name, address, phoneNumber, emailId);
    }
    //saves class status to freshman, sophomore, junior or senior
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

    //getter for class status
    public String getClassStatus(){
        return status;
    }

    //overrides toString() method
    @Override
    public String toString(){
        return "Student: " + super.getName();
    }
}