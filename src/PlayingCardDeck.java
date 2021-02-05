import java.util.ArrayList;
import java.util.*;

/**
 * This class uses arraylists to create a deck of playingcard objects.
 * Has methods for randomly shuffling the deck, printing the contents of the deck
 * Reordering the deck so that it is from highest to lowest grouped by suit
 * Drawing the 5 cards on top of the deck and displaying them
 *
 * @author ryan.woodford
 */
public class PlayingCardDeck {
    private ArrayList<PlayingCard> deck;

    /**
     * Constructor that generates a 52 card deck
     */
    public PlayingCardDeck() {
        deck = new ArrayList<>();
        //generates the 4 suits
        for (int i = 0; 3 >= i; i++) {
            //generates 14 values for each suit
            for (int j = 2; 14 >= j; j++) {
                deck.add(new PlayingCard(i, j));
            }
        }
    }

    /**
     * This method prints the full deck of cards
     */
    public void getDeckContents() {
        for (int i = 0; deck.size() - 1 >= i; i++) {
            System.out.printf("This card is the %s of %s\n", deck.get(i).getValueString(), deck.get(i).getSuitString());
        }
    }

    /**
     * This method reorders the deck from highest to lowest, grouped by suit
     */
    public void reorderDeck() {
        //loops through deck and sorts by value grouped by suit
        PlayingCard swap;
        for (int i = 0; i < deck.size() - 1; i++) {
            for (int j = 0; j < deck.size() - 1 - i; j++) {
                if (deck.get(j).getValueInt() < deck.get(j + 1).getValueInt()) {
                    //if(newdeck.get(j).getSuit().equals(newdeck.get(j + 1).getSuit())){
                    swap = deck.get(j);
                    deck.set(j, deck.get(j + 1));
                    deck.set(j + 1, swap);
                }
            }
        }
        //loops through cards in deck again and sorts by suit
        for (int i = 0; i < deck.size() - 1; i++) {
            for (int j = 0; j < deck.size() - 1 - i; j++) {
                if (deck.get(j).getSuitInt() > deck.get(j + 1).getSuitInt()) {
                    swap = deck.get(j);
                    deck.set(j, deck.get(j + 1));
                    deck.set(j + 1, swap);
                }
            }
        }
    }

    /**
     * This method randomly shuffles the cards currently in the deck
     */
    public void shuffleDeck() {
        Random random = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = random.nextInt(i);
            PlayingCard holder = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, holder);
        }
    }

    /**
     * This method draws the top 5 cards from the deck and returns an array that contains them
     */
    public PlayingCard[] drawCards() {
        PlayingCard[] hand = new PlayingCard[5];
        int counter = 0;
        for (int i = deck.size() - 1; counter < 5; i--, counter++) {
            if (deck.size() > 0) {
                hand[counter] = deck.get(i);
                deck.remove(deck.size() - 1);
            }
        }
        return hand;
    }

    /**
     * Draws a single card from the deck arraylist and returns the playing card object at the end,
     * then removes from the deck
     *
     * @return
     */
    public PlayingCard drawCard() {
        PlayingCard drawncard = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return drawncard;
    }

    /**
     * Getter for the deck that returns an arraylist containing PlayingCard objects
     *
     * @return
     */
    public ArrayList<PlayingCard> getDeck() {
        return this.deck;
    }
}