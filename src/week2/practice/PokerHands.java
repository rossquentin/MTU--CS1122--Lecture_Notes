package week2.practice;

import java.util.ArrayList;
import java.util.Collections;

public class PokerHands implements Comparable{

    private int handRank;
    private String handName;

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
        }
    }

    public int compareTo(Object o) throws NullPointerException, ClassCastException{
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof PokerHands) {
            PokerHands temp = (PokerHands) o;
            if (!this.handName.equals(temp.handName)) {
                return this.handRank - temp.handRank;
            }
            return 0;
        }
        throw new ClassCastException();
    }


    public String toString() {
        return handName;
    }

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
