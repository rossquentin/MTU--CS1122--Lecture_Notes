package week2.part2;

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

    public int numSeats() {
        return 0;
    }

    public String getType() {
        return null;
    }
}
