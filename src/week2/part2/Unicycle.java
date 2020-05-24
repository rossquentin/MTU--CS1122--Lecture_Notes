package week2.part2;

import week2.part2.Vehicle;

public class Unicycle extends Vehicle {


    /**
     * A constructor for a generic vehicle
     *
     * @param model        Model name for the vehicle
     * @param manufacturer Company that manufactures the vehicle
     */
    public Unicycle(String model, String manufacturer) {
        super(model, manufacturer);
    }

    /**
     * Returns the number of seats on the unicycle.
     *
     * @return  A single seat
     */
    public int numSeats() {
        return 1;
    }

    /**
     * Returns the fact it's a unicycle
     *
     * @return  The string "unicycle"
     */
    public String getType() {
        return "unicycle";
    }

    /**
     *
     * @param inMPG         Whether the units are in MPG or not
     * @return              Positive infinity for MPG.
     */
    public double getEfficiency(boolean inMPG) {
        return Double.POSITIVE_INFINITY;
    }
}
