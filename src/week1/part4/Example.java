package week1.part4;

public class Example {
    private String stored = "I printed correctly";

    public String toString() {
        return stored;
    }

    public static void main(String[] args) {
        Example stuff = new Example();
        System.out.println(stuff);
    }
}
