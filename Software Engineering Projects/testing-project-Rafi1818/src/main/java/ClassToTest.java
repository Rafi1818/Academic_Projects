import java.util.*;

public class ClassToTest {

    /**
     * Add numbers
     * @param numbers A list of numbers
     * @return The sum
     */
    public static double add(final double... numbers) {
        double sum = 0;
        for ( double number : numbers) {
            sum += number;
        }
        return sum;
    }

    /**
     * Divide two numbers
     * @param first Number to divide
     * @param second Number to divide by
     * @return The result
     */
    public static double divide(final double first, final double second) {
        return first / second;
    }

    /**
     * Verifies that the given number is exactly 3 digits
     *
     * @param number Any integer
     * @return True if the number is three digits
     */
    public static boolean isThreeDigits(final int number) {
        return (number >= 100) && (number < 1000);
    }

    /**
     * Adds "Hi, " to whatever you pass
     * @param base String to prepend to
     * @return String with "Hi, " prepended
     */
    public static String hiExtension(final String base) {
        return "Hi, " + base;
    }

    /**
     * Calculates for 5x+3y
     * @param x What is says :)
     * @param y What is says :)
     * @return Result of the calculation
     */
    public static int algebraCalculation(final int x, final int y) {
        return 5*x + 3*y;
    }

    /**
     * Find the average of a list of numbers.
     * @param numbers The list of numbers
     * @return Average of these numbers
     */
    public static double average(double... numbers) {
        double average = 0;
        for ( double number : numbers) {
            average += number;
        }
        return average / numbers.length;
    }


    public static List<String> sortIgnoreCase(String... values) {
        List<String> returnList = new ArrayList<>();
        returnList.addAll(Arrays.asList(values));

        // This sorts the string by ignoring the case, simplified via a method reference
        returnList.sort(String::compareToIgnoreCase);
        return returnList;
    }

}
