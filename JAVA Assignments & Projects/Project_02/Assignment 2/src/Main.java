import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args){
        Person p = new Person ("Rafi", "222B Baker Street", "6823", "123@gmail.com");
        Student s = new Student("Jafor", "Kahini","84874884","dkmniwonveuovbv");
        Faculty f = new Faculty("Zamir", "123 Registry Ln", "9294903135", "tlakdj@gamil.com", "Office", 65582.86, 4, 12, 1987, 40, "Doctor");
        Staff st = new Staff("Wayes", "123 Rosemade Pkwy", "6823203794", "wayes@gmail.com", "Janitor", 32876.54, 12, 18, 2001, "Head Janitor");
        s.isSophomore();
        System.out.println(p.toString());
        System.out.println(f.toString());
        System.out.println(st.toString());
    }
}
