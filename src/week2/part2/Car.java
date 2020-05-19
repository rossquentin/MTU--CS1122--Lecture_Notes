package week2.part2;

import week2.part2.Vehicle;

public class Car extends Vehicle {

    private int seatCount;

    /**
     * A constructor for a generic vehicle
     *
     * @param model         Model name for the vehicle
     * @param manufacturer  Company that manufactures the vehicle
     * @param MPG           Miles per gallon efficiency of the car
     * @param numSeats      Number of people the car can seat
     */
    public Car(String model, String manufacturer, double MPG, int numSeats) {

        // Call the constructor of the class I inherit from
        super(model, manufacturer);
        this.MPG = MPG;  // Overwrites something done in the superclass
        seatCount = numSeats;
    }

    /**
     * Method is not defined in superclass Vehicle
     * Change the seat cunt in the vehicle
     *
     * @param numSeats  New seat count
     */
    public void setSeats(int numSeats) {
        seatCount = numSeats;
    }

    /**
     * Returns the number of seats
     *
     * @return  Number of seats
     */
    public int numSeats() {
        return seatCount;
    }

    /**
     * Returns the fact I'm a car
     *
     * @return the string "car"
     */
    public String getType() {
        return "car";
    }
}
