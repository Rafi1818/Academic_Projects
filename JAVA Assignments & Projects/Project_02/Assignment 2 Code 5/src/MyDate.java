import java.util.*;
public class MyDate{
    int year = 0;
    int month = 0;
    int day = 0;

    //arg constructor
    MyDate(int monthIn, int dayIn, int yearIn){
        year = yearIn;
        month = monthIn - 1;
        day = dayIn;
    }

    //overriding toString() method
    @Override
    public String toString(){

        //getting date and time hired from Gregorian Calendar class available in java.util library
        GregorianCalendar g = new GregorianCalendar(year, month, day);

        //using getTime() method to display date and time
        System.out.println(g.getTime());

        //return nothing because it is already printing the date and time from here
        return "";
    }
}