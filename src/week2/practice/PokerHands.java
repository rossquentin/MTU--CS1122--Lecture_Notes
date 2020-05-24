package week2.practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Sorts a series of different poker hands by best to worst.
 *
 * @author Quentin Ross
 */
public class PokerHands implements Comparable{

    private int handRank;
    private String handName;


    /**
     * Constructor to set name and value of a poker hand
     *
     * @param hand  Name of the poker hand
     */
    public PokerHands(String hand) {
        this.handName = hand;

        switch (handName.toLowerCase()) {
            case "royal flush" :
                handRank = 1;
                break;
            case "straight flush" :
                handRank = 2;
                break;
            case "four of a kind" :
                handRank = 3;
                break;
            case "full house" :
                handRank = 4;
                break;
            case "flush" :
                handRank = 5;
                break;
            case "straight" :
                handRank = 6;
                break;
            case "three of a kind" :
                handRank = 7;
                break;
            case "two pair" :
                handRank = 8;
                break;
            case "pair" :
                handRank = 9;
                break;
            case "high card" :
                handRank = 10;
                break;
            default:
                handRank = -1;
                break;
        }
    }

    /**
     * Compares two objects bases on the name and value of the poker hands given
     *
     * @param o     Object given
     * @return      Value to sort the hands in.
     */
    public int compareTo(Object o) throws NullPointerException, ClassCastException{
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof PokerHands) {
            PokerHands temp = (PokerHands) o;
            if (temp.handRank == -1) {
                throw new NullPointerException("Hand does not exist.");
            }
            else if (!this.handName.equals(temp.handName)) {
                return this.handRank - temp.handRank;
            }
            return 0;
        }
        throw new ClassCastException();
    }

    /**
     * toString method to format the ArrayList when printing to the console.
     *
     * @return  The handName string.
     */
    public String toString() {
        return handName;
    }

    /**
     * Main method to test the program.
     */
    public static void main(String[] args) {
        ArrayList<PokerHands> hands = new ArrayList<>();
        hands.add(new PokerHands("Full House"));
        hands.add(new PokerHands("Straight"));
        hands.add(new PokerHands("Straight"));
        hands.add(new PokerHands("Three of a Kind"));
        hands.add(new PokerHands("High Card"));
        hands.add(new PokerHands("Flush"));
        hands.add(new PokerHands("Royal Flush"));

        Collections.shuffle(hands);

        System.out.println(hands);

        Collections.sort(hands);

        System.out.println(hands);

    }
}
