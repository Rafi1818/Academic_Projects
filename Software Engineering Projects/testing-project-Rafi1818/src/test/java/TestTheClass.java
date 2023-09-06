import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTheClass {

    /**
     * Tests ClassToTest.add() in various ways
     * Given as an example for you to imitate :)
     */
    @Test
    void add() {
        assertEquals(0, ClassToTest.add());
        assertEquals(1, ClassToTest.add(1));
        assertEquals(4, ClassToTest.add(2, 2));
        assertEquals(6, ClassToTest.add(1, 2, 3));
        assertEquals(50, ClassToTest.add(20, 15, 5, 10));
        assertEquals(-3, ClassToTest.add(4, -7));
        assertEquals(5.0, ClassToTest.add(3.499898, 1.500102), 0.0001);
    }

    @Test
    void divide(){
        assertEquals(0.92308, ClassToTest.divide(12, 13), 0.00001);
        assertEquals(0.90254, ClassToTest.divide(12.345, 13.678), 0.00001);
        assertEquals(Double.POSITIVE_INFINITY, ClassToTest.divide(10, 0));
    }

    /*
       Test ClassToTest.divide()
       * Standard division (integers)
       * Standard division (floating-point--remember to use bounds--see above)
       * Divide by 0 (figure out what it does and match that :) )
     */

    @Test
    void isThreeDigits(){
        assertFalse(ClassToTest.isThreeDigits(4));
        assertTrue(ClassToTest.isThreeDigits(456));
        assertFalse(ClassToTest.isThreeDigits(876548));
    }

    /*
       Test ClassToTest.isThreeDigits()
       * Number clearly less than 100, number clearly in the range 100-999, number clearly above 1000
       * Edge cases: both sides of each boundary (100 & 999)
     */

    @Test
    void hiExtension(){
        assertEquals("Hi, Rafi", ClassToTest.hiExtension("Rafi"));
        assertEquals("Hi, I am Rafi", ClassToTest.hiExtension("I am Rafi"));
        assertEquals("Hi, ", ClassToTest.hiExtension(""));
    }

    /*
       Test ClassToTest.hiExtension
       * With a short string
       * With a longer string
       * With a blank string
     */

    @Test
    void algebraCalculation(){
        assertEquals(12, ClassToTest.algebraCalculation(0, 4));
        assertEquals(30, ClassToTest.algebraCalculation(6, 0));
        assertEquals(0, ClassToTest.algebraCalculation(0, 0));
        assertEquals(62, ClassToTest.algebraCalculation(7, 9));
        assertEquals(-3, ClassToTest.algebraCalculation(3, -6));
        assertEquals(-25, ClassToTest.algebraCalculation(-2, -5));
    }
    /*
       Test ClassToTest.algebraCalculation()
       * x is 0
       * y is 0
       * Both are 0
       * Both are positive
       * One positive, one negative
       * Both negative
     */

    @Test
    void sortIgnoreCase(){
        assertEquals(0, ClassToTest.sortIgnoreCase().size());

        assertEquals(1, ClassToTest.sortIgnoreCase("rafi").size());
        assertEquals("rafi", ClassToTest.sortIgnoreCase("rafi").get(0));

        assertEquals(2, ClassToTest.sortIgnoreCase("rafi", "mohiv").size());
        assertEquals("mohiv", ClassToTest.sortIgnoreCase("rafi", "mohiv").get(0));
        assertEquals("rafi", ClassToTest.sortIgnoreCase("rafi", "mohiv").get(1));

        assertEquals(2, ClassToTest.sortIgnoreCase("JIBON", "PRITHIBI").size());
        assertEquals("JIBON", ClassToTest.sortIgnoreCase("JIBON", "PRITHIBI").get(0));
        assertEquals("PRITHIBI", ClassToTest.sortIgnoreCase("JIBON", "PRITHIBI").get(1));

        assertEquals(2, ClassToTest.sortIgnoreCase("jibon", "PRITHIBI").size());
        assertEquals("jibon", ClassToTest.sortIgnoreCase("jibon", "PRITHIBI").get(0));
        assertEquals("PRITHIBI", ClassToTest.sortIgnoreCase("jibon", "PRITHIBI").get(1));

        assertEquals(2, ClassToTest.sortIgnoreCase("JIBON", "prithibi").size());
        assertEquals("JIBON", ClassToTest.sortIgnoreCase("JIBON", "prithibi").get(0));
        assertEquals("prithibi", ClassToTest.sortIgnoreCase("JIBON", "prithibi").get(1));

        assertEquals(3, ClassToTest.sortIgnoreCase("JIBON", "KAHINI", "prithibi").size());
        assertEquals("JIBON", ClassToTest.sortIgnoreCase("JIBON", "KAHINI", "prithibi").get(0));
        assertEquals("KAHINI", ClassToTest.sortIgnoreCase("JIBON", "KAHINI", "prithibi").get(1));
        assertEquals("prithibi", ClassToTest.sortIgnoreCase("JIBON", "KAHINI", "prithibi").get(2));
    }
    /*
       Test ClassToTest.sortIgnoreCase()
       * Verify BOTH the size of the returned list (size()) AND each element (get(0), get(1), ...)
       * No argument
       * 1 String
       * 2 Strings, both lowercase
       * 2 Strings, both uppercase
       * 2 Strings, 1 lowercase, 1 uppercase, lowercase one should come first
       * 2 Strings, 1 uppercase, 1 lowercase, uppercase one should come first
       * 3 Strings, any variety
     */

}
