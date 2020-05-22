package week2.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This object gets and sets a hypothetical person's height in feet and inches,
 * then allows the object the ability to use the compareTo method from
 * the Comparable interface. The toString method formats the otherwise useless
 * numbers to the imperial format of F'I".
 */

public class PeopleHeight implements Comparable {
    private int heightFeet;
    private int heightInches;

    /**
     * Gets and sets the hypothetical person's height in feet and the remaining inches.
     *
     * @param heightFeet    Height in feet
     * @param heightInches  Remaining height in inches
     */
    public PeopleHeight(int heightFeet, int heightInches) {
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
    }

    /**
     * Allows the PeopleHeight object the ability to use the compareTo method from
     * the Comparable interface.
     *
     * @param o                         Object to use
     * @return                          Either the height in feet or inches
     * @throws NullPointerException     Thrown when object is null
     * @throws ClassCastException       Thrown when the object is not an instance of PeopleHeight
     */
    public int compareTo(Object o) throws NullPointerException, ClassCastException {
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof PeopleHeight) {
            PeopleHeight temp = (PeopleHeight) o;
            if (this.heightFeet != temp.heightFeet) {
                return this.heightFeet - temp.heightFeet;
            }
            return this.heightInches - temp.heightInches;
        }
        throw new ClassCastException();
    }

    /**
     * Formats the height in the imperial format F'I"
     *
     * @return  A height in the imperial format F'I"
     */
    public String toString() {
        return "" + heightFeet + "'" + heightInches + "\"";
    }

    /**
     * Used for testing of the compareTo and toString method.
     */
    public static void main(String[] args) {
        // Creates a new PeopleHeight ArrayList and Random object for later use.
        ArrayList<PeopleHeight> heights = new ArrayList<>();
        Random random = new Random();

        // Add two numbers for the measurements of feet and inches between 4 to 6 feet and 0 to 11 inches
        // to heights.
        for (int i = 0; i < 20 ; i++) {
            heights.add(new PeopleHeight(Math.max(Math.min(random.nextInt(7) + 1, 6),4), random.nextInt(12)));
        }

        // Prints the randomized sorting of the heights
        System.out.println(heights);

        // Sort the heights list and then reverse it to show the tallest hypothetical person at the first
        // index and the shortest one at the last index.
        Collections.sort(heights);
        Collections.reverse(heights);

        // Prints the sorted heights
        System.out.println(heights);

    }
}
