package week1.part2;

public class Example {

    private String name;
    private int calls;

    // Constructor setting variables
    public Example(String name, int start) {
        this.name = name;
        calls = start;
    }

    // Increments call and returns the old value
    public int call() {
        int temp = calls;
        calls += 1;

        return temp;
    }

    // Returns the current value of calls
    public int check() {
        return calls;
    }

    // Returns the current value of name
    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        // Creates two new objects "foo" and "bar"
        Example foo = new Example("foo", 10);
        Example bar = new Example("bar", 10);

        Example stuff = new Example("place", 11);

        // Call foo four times
        for (int i = 0; i < 4; i++) {
            foo.call();
        }

        // Print both foo and bar for testing
        System.out.println(foo.getName() + ": " + foo.check());
        System.out.println(bar.getName() + ": " + bar.check());

    }

}