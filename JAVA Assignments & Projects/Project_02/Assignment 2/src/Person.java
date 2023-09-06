import java.util.Date;

public class Person{
    String name = "";
    String address = "";
    String phoneNumber = "";
    String emailId = "";
    Person(){
    }
    Person(String nameIn, String addressIn, String phoneNumberIn, String emailIdIn){
        name = nameIn;
        address = addressIn;
        phoneNumber = phoneNumberIn;
        emailId = emailIdIn;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmailId(){
        return emailId;
    }
    public String toString(){
        return "Person: " + name;
    }
}