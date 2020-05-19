package week2.part2;

public abstract class Vehicle {
    // Constant to convert MPG to KPL
    private static final double MPG_TO_KPL = 0.425144;

    // Want subclasses the be able to access these!  PROTECTED: SUBCLASSES CAN ACCESS. PRIVATE: SUBCLASSES CANNOT ACCESS.
    protected double MPG;
    protected String model;
    protected String manufacturer;


    /**
     * A constructor for a generic vehicle
     *
     * @param model         Model name for the vehicle
     * @param manufacturer  Company that manufactures the vehicle
     */
    public Vehicle(String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
        MPG = 0;
    }

    /**
     * Return the models name
     *
     * @return      Model name
     */
    public String getModel() { return model;}

    /**
     * Returns the manufacturer name of the car
     *
     * @return      Manufacturer name
     */
    public String getManufacturer() { return manufacturer; }

    /**
     * Returns the efficiency of the vehicle in miles-per-gallon or kilometers-per-litre
     *
     * @param inMPG         Whether the units are in MPG or not
     * @return              Efficiency in MPG or KPL
     */

    // Ternary operator (CONDITION) ? CONDITION TRUE : CONDITION FALSE;
    public double getEfficiency (boolean inMPG) { return (inMPG) ? MPG : (MPG * MPG_TO_KPL); }

    public String toString() {
        return "I am a " + getManufacturer() + " " + getType() + " with MPG " + getEfficiency(true)
                        + ", KPL "+ getEfficiency(false) + " that seats " + numSeats() + ".";

    }

    /**
     * Abstract methods
     * We'll need to implement these later...
     */
    public abstract int numSeats();
    public abstract String getType();

}