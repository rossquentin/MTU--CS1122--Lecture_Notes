package week2.part3and4;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;

public class InstanceOf {


    /**
     * Returns a list that has all integers in it moved to the front and all strings in it moved to the back.
     *
     * @param foo   List that contains both integers and strings
     * @return      List that has all integers in the front and all strings in the back.,
     */
    public static ArrayList<Object> seperate(ArrayList<Object> foo) {
        ArrayList<Object> first = new ArrayList<Object>();
        ArrayList<Object> second = new ArrayList<Object>();
        ArrayList<Object> last = new ArrayList<Object>();

        // Object ELEMENT : LIST is a for each statement
        for (Object e : foo) {
            if (e instanceof Integer) {
                first.add(e);
            } else if (e instanceof String) {
                last.add(e);
            } else {
                second.add(e);
            }
        }

        first.addAll(second);
        first.addAll(last);

        return first;
    }

    public static void main(String[] args) {
        ArrayList<Object> foo = new ArrayList<Object>();
        foo.add(1);
        foo.add(0.5);
        foo.add("Stuff");

        Collections.shuffle(foo);

        System.out.println(foo);
        System.out.println(seperate(foo));
    }

}
