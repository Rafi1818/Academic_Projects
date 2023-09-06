public class Person{
    String name = "";
    String address = "";
    String phoneNumber = "";
    String emailId = "";
    Person(){
    }

    //arg constructor
    Person(String nameIn, String addressIn, String phoneNumberIn, String emailIdIn){
        name = nameIn;
        address = addressIn;
        phoneNumber = phoneNumberIn;
        emailId = emailIdIn;
    }

    //getter for name
    public String getName(){
        return name;
    }

    //getter for affress
    public String getAddress(){
        return address;
    }

    //getter for phone number
    public String getPhoneNumber(){
        return phoneNumber;
    }

    //getter for e-mail address
    public String getEmailId(){
        return emailId;
    }

    //overriding toString() method
    @Override
    public String toString(){
        return "Person: " + name;
    }
}