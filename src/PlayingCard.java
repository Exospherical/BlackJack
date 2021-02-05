import java.util.Random;

/**
 * This class is a companion to the playing card deck. Creates a playing card object with suit and value passed in as
 * parameters
 *
 * @author ryan.woodford
 */
public class PlayingCard {
    //suits
    public final static int HEARTS = 0;
    public final static int SPADES = 1;
    public final static int CLUBS = 2;
    public final static int DIAMONDS = 3;
    //non numeric values and 10 because it has 2 digits
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    public final static int ACE = 14;
    //attributes for object suit and value
    private int suit;
    private int value;

    /**
     * This constructor takes in suit and value numbers and generates that card
     */
    public PlayingCard(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * gets  suit of the card
     *
     * @return
     */
    public String getSuitString() {
        if (this.suit == HEARTS) {
            return "Hearts";
        } else if (this.suit == SPADES) {
            return "Spades";
        } else if (this.suit == CLUBS) {
            return "Clubs";
        } else {
            return "Diamonds";
        }
    }

    /**
     * gets the integer value of the card
     *
     * @return
     */
    public int getSuitInt() {
        return this.suit;
    }

    /**
     * gets the value of the card
     *
     * @return
     */
    public int getValueInt() {
        return value;
    }

    /**
     * Returns a string representation of the value of each card, for printing purposes
     *
     * @return
     */
    public String getValueString() {
        if (this.value == 2) {
            return "2";
        } else if (this.value == 3) {
            return "3";
        } else if (this.value == 4) {
            return "4";
        } else if (this.value == 5) {
            return "5";
        } else if (this.value == 6) {
            return "6";
        } else if (this.value == 7) {
            return "7";
        } else if (this.value == 8) {
            return "8";
        } else if (this.value == 9) {
            return "9";
        } else if (this.value == 10) {
            return "10";
        } else if (this.value == JACK) {
            return "Jack";
        } else if (this.value == QUEEN) {
            return "Queen";
        } else if (this.value == KING) {
            return "King";
        } else if (this.value == ACE) {
            return "Ace";
        }
        return null;
    }

    /**
     * returns the blackjack values of cards. does not account for changing ace.
     *
     * @return
     */
    public int getBlackJackValue() {
        if (this.value == 2) {
            return 2;
        } else if (this.value == 3) {
            return 3;
        } else if (this.value == 4) {
            return 4;
        } else if (this.value == 5) {
            return 5;
        } else if (this.value == 6) {
            return 6;
        } else if (this.value == 7) {
            return 7;
        } else if (this.value == 8) {
            return 8;
        } else if (this.value == 9) {
            return 9;
        } else if (this.value == 10) {
            return 10;
        } else if (this.value == JACK) {
            return 10;
        } else if (this.value == QUEEN) {
            return 10;
        } else if (this.value == KING) {
            return 10;
        } else if (this.value == ACE) {
            return 11;
        }
        return 15;
    }
}
