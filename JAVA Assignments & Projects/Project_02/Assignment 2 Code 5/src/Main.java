public class Main
{
    public static void main(String[] args){
        Person p = new Person ("Rafi", "222B Baker Street", "682-323-4567", "123@gmail.com");
        Student s = new Student("Jafor", "140 Sunflower Dr","848-748-8499","jaforuddin@gmail.com");
        //setting student s's class status to Junior
        s.isJunior();
        Employee e = new Employee("Jabbar", "234 Huckleberry Dr", "567-345-5678", "absdf@gmail.com", "Office", 45341.89, 3, 11, 1994);
        Faculty f = new Faculty("Zamir", "123 Registry Ln", "9294903135", "tlakdj@gamil.com", "Office", 65582.86, 4, 12, 1987, 40, "Doctor");
        Staff st = new Staff("Wayes", "123 Rosemeade Pkwy", "6823203794", "wayes@gmail.com", "Janitor", 32876.54, 12, 18, 2001, "Head Janitor");

        //displaying class and name
        System.out.println(p.toString());
        System.out.println(s.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
        System.out.println(st.toString());
    }
}
