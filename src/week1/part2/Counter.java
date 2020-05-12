package week1.part2;

public class Counter {

    private int value;

    public Counter() {
        //this.value is not important as the objects's value is the only value referenced of the same name.
        this.value = 0;
    }

    //Overloaded constructor
    public Counter(int value) {
        //this.value important as it references the methods's value and assigns it to the objects's value.
        this.value = value;
    }

    //Getter method
    public int getVal() {
        return value;
    }

    //Setter/Mutator method
    public void incVal() {
        value++;
    }

    public static void main(String[] args) {

    }
}