import java.util.*;
public class MyDate{
    int year = 0;
    int month = 0;
    int day = 0;
    MyDate(int monthIn, int dayIn, int yearIn){
        year = yearIn;
        month = monthIn - 1;
        day = dayIn;
    }
    public String toString(){
        GregorianCalendar g = new GregorianCalendar(year, month, day);
        System.out.println(g.getTime());
        return "";
    }
}