package week1.part2;

import week2.part2.*;

public class Main {

    public static void main(String[] args) {

        // Abstract Classes can be an Object type
        // Can replace Vehicle with Car or Unicycle
        Vehicle car = new Car("Taurus", "Ford", 26, 34);
        Vehicle unicycle = new Unicycle("Retro Red", "Schwinn");

        System.out.printf("Car is a %s%n", car.getType());
        System.out.printf("Unicycle is a %s%n", unicycle.getType());

        System.out.println(car.toString());
        System.out.println(unicycle.toString());

    }
}
