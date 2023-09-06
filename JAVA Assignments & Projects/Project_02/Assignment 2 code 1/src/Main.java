import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) {
        Rectangle rct = new Rectangle(4, 40);                           //rectangle width 4, height 40
        Rectangle rct1 = new Rectangle(3.5, 35.9);                      //rectangle width 3.5, height 35.9
        System.out.println(rct.getWidth() + "\n" + rct.getHeight());    //displaying width and height (1st rectangle)
        System.out.printf("%.2f", rct.getArea());                       //displaying area (1st rectangle)
        System.out.println();                                           //newLine
        System.out.printf("%.2f", rct.getPerimeter());                  //displaying perimeter (1st rectangle)
        System.out.println();
        System.out.println(rct1.getWidth() + "\n" + rct1.getHeight());  //displaying width and height (2nd rectangle)
        System.out.printf("%.2f", rct1.getArea());                      //displaying area (2nd rectangle)
        System.out.println();
        System.out.printf("%.2f", rct1.getPerimeter());                 //displaying perimeter (2nd rectangle)
        System.out.println();
    }
}
