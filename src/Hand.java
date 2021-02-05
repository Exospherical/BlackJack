import java.util.ArrayList;

/**
 * This class checks the blackjack value of a hand and accounts for aces changing value. It also stores a hand of PlayingCard objects
 * in an arraylist. It also adds cards, and uses the ASCIIPrinterCard class to print out the hand.
 */
public class Hand {
    private int handvalue;
    private String player;
    private boolean acecheck;

    private ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();

    /**
     * Adds the values of the cards in an arraylist to get the total
     *
     * @return
     */
    public int checkHandValue() {
        handvalue = 0;
        for (int i = 0; hand.size() > i; i++) {
            handvalue += hand.get(i).getBlackJackValue();
        }
        if (acecheck && handvalue > 21) {
            handvalue -= 10;
        }
        return handvalue;
    }

    /**
     * Adds a PlayingCard to the hand
     *
     * @param card
     */
    void addCard(PlayingCard card) {
        hand.add(card);
        if (card.getValueInt() == 14) {
            acecheck = true;
        }
    }

    /**
     * uses printAsciiCard Class to print the cards in the hand
     */
    public void getHand() {
        for (int i = 0; hand.size() > i; i++) {
            new PrintAsciiCard(this.hand.get(i)).printCard();
        }
    }

    /**
     * Gets the value of the dealers first card, when one is face down.
     *
     * @return
     */
    public int getFirstValue() {
        return this.hand.get(0).getBlackJackValue();
    }

    /**
     * print the dealers first card
     */
    public void getDealersStart() {
        new PrintAsciiCard(this.hand.get(0)).printCard();
    }
}
