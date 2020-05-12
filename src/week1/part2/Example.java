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

    // Overrides the toString method and, if no other method is called, calls this method.
    // If this is not called and the object is called without any method, it will return memory location.
    public String toString() {
        return "Name: " + name + ". Val: " + calls;
    }

    public boolean equals(Object obj) {
        // Check if object obj is an Example object
        // If not, return false
         if(! (obj instanceof Example)) {
             return false;
         }

         // Cast obj as an Example object
         Example tmp = (Example) obj;

         // Checks if temporary object has the same number of calls
         return (tmp.check() == calls);
    }

    // Similarly, we can override compareTo() and equals() for use in our own objects

    public static void main(String[] args) {

        // Creates two new objects "foo" and "bar"
        Example foo = new Example("foo", 10);
        Example bar = new Example("bar", 9);

        // Call foo four times
//        for (int i = 0; i < 4; i++) {
//            foo.call();
//        }
//
//        // Print both foo and bar for testing
//        System.out.println(foo);
//        System.out.println(bar.toString());

        System.out.println(foo.equals(bar));
    }
}
