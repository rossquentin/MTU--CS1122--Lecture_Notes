package week5;

public class LinkedListDemo<E> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Node prev;
        Node next;
        E element;

        Node(E element) {
            this.element = element;
            prev = null;
            next = null;
        }
    }

    private Node getNthNode(int n) { // O(n)
        Node cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private Node getNodeByElement(E o) { // O(n)
        Node cur = head;
        for (int i = 0; i < size - 1; i++) {
            cur = cur.next;
            if (cur.element.equals(o)) {
                return cur;
            }
        }
        return null;
    }

    public LinkedListDemo() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E o) {
        Node temp = new Node(o);

        if(head == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }

    public void addFirst(E o) {
        Node temp = new Node(o);

        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void add(int n, E o ) throws IndexOutOfBoundsException {
        if (n > size || n < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (n==size) {
            add(o);
            return;
        }
        else if (n == 0) {
            addFirst(o);
            return;
        }

        Node temp = new Node(o);
        Node current = getNthNode(n);

        //Insert temp in front of the old nth node
        //1- update temp with current as next node, and
        //current's previous node as my previous node
        temp.prev = current.prev;
        temp.next = current;

        //2- Update the previous node to point to temp
        temp.prev.next = temp;

        //3- Update the next node to point to temp
        temp.next.prev = temp;

        //Increment size
        size++;
    }

    public E get(int n) throws IndexOutOfBoundsException{
        if (n > size || n < 0) {
            throw new IndexOutOfBoundsException();
        }
        return getNthNode(n).element;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.element;
    }

    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.element;
    }


    public E removeFirst() {
        if (head == null) {
            return null;
        }

        Node temp = head;

        if(size == 1) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return temp.element;
    }

    public E removeLast() {
        if (tail == null) {
            return null;
        }

        Node temp = head;

        if(size == 1) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return temp.element;
    }

    public E remove(int n) {
        if (n > size || n < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n == 0) {
            return removeFirst();
        }
        else if (n == size - 1) {
            return removeLast();
        }

        Node temp = getNthNode(n);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;
        return temp.element;
    }

    public boolean remove(E o) {
        Node temp = getNodeByElement(o);
        if(temp == null) {
            return false;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        size--;
        return true;
    }

    public boolean contains(E o) {
        return getNodeByElement(o) != null;
    }

    public void set(int n, E o ) throws IndexOutOfBoundsException {
        if (n > size || n < 0) {
            throw new IndexOutOfBoundsException();
        }

        getNthNode(n).element = o;
    }

    public String toString() {
        if (head == null) {
            return "[ ]";
        }

        String str = "[ ";
        Node curNode = head;

        while(curNode.next != null) {
            str += curNode.element.toString() + ", ";
            curNode = curNode.next;
        }

        str += curNode.element.toString() + " ]";
        return str;
    }

    public static void main(String[] args) {

        LinkedListDemo<String> foo = new LinkedListDemo<>();

        foo.add("two");
        foo.add("four");
        foo.addFirst("one");
        foo.add(2,"three");

        System.out.println("Starting with... " + foo);

        foo.remove(1);
        System.out.println("After removing index 1... " + foo);

        System.out.println("0th element is " + foo.get(0));
        System.out.println("2nd element is " + foo.get(2));

        System.out.println("Removed head and got " + foo.removeFirst());

        System.out.println("Remaining is " + foo);

        System.out.println("Size is " + foo.getSize());

        foo.add("Scott");
        if(foo.contains("Scott")) {
            System.out.println("String \"Scott\" was added to foo, and verified by contains()");
        }

        foo.remove("Scott");
        if(!foo.contains("Scott")) {
            System.out.println("String \"Scott\" was removed from foo, and verified by contains()");
        }

        foo.set(0, "NANANANANANANA");
        foo.set(1, "BATMAN");
        System.out.println("Set foo[0] and foo[1] to new strings " + foo);


    }

}
