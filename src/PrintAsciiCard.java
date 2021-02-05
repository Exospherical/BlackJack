/**
 * simple class to print ASCII representations of playing cards. reads the cards value and suit and puts on card.
 *
 * @author ryan.woodford
 */

public class PrintAsciiCard {
    private String topofcard = " ________\n";
    private String middleofcard = "|/\t\t/|\n" + "|/\t\t/|\n" + "|/\t\t/|\n";
    private String bottomofcard = " --------\n";
    private int value;
    private int suit;
    private String playingCardValue;
    private final String spades = "\u2660";
    private final String hearts = "\u2665";
    private final String diamonds = "\u2666";
    private final String clubs = "\u2663";

    /**
     * constructor reads value and suit. also sets string value to change width of cards.
     *
     * @param card
     */
    PrintAsciiCard(PlayingCard card) {
        this.value = card.getValueInt();
        this.suit = card.getSuitInt();
        this.playingCardValue = card.getValueString();
    }

    /**
     * Prints an ASCII representation of a card that gets passed in
     */
    public void printCard() {
        if (suit == PlayingCard.HEARTS) {
            if (value >= 2 && value <= 9) {
                System.out.println(topofcard + "|" + hearts + "\t\t |\n" + "| \t" + playingCardValue + "\t |\n" + "| \t\t" + hearts + "|\n"
                        + bottomofcard);
            } else if ((value == PlayingCard.KING) || (value == PlayingCard.ACE) || (value == PlayingCard.TEN) || (value == PlayingCard.JACK)) {
                System.out.println(topofcard + "|" + hearts + "\t\t |\n" + "|  " + playingCardValue + "\t |\n" + "| \t\t" + hearts + "|\n"
                        + bottomofcard);
            } else if (value == PlayingCard.QUEEN) {
                System.out.println(topofcard + "|" + hearts + "\t\t |\n" + "| " + playingCardValue + "  |\n" + "| \t\t" + hearts + "|\n"
                        + bottomofcard);
            }
        } else if (suit == PlayingCard.SPADES) {
            if (value >= 2 && value <= 9) {
                System.out.println(topofcard + "|" + spades + "\t\t |\n" + "| \t" + playingCardValue + "\t |\n" + "| \t\t" + spades + "|\n"
                        + bottomofcard);
            } else if ((value == PlayingCard.KING) || (value == PlayingCard.ACE) || (value == PlayingCard.TEN) || (value == PlayingCard.JACK)) {
                System.out.println(topofcard + "|" + spades + "\t\t |\n" + "|  " + playingCardValue + "\t |\n" + "| \t\t" + spades + "|\n"
                        + bottomofcard);
            } else if (value == PlayingCard.QUEEN) {
                System.out.println(topofcard + "|" + spades + "\t\t |\n" + "| " + playingCardValue + "  |\n" + "| \t\t" + spades + "|\n"
                        + bottomofcard);
            }
        } else if (suit == PlayingCard.DIAMONDS) {
            if (value >= 2 && value <= 9) {
                System.out.println(topofcard + "|" + diamonds + "\t\t |\n" + "| \t" + playingCardValue + "\t |\n" + "| \t\t" + diamonds + "|\n"
                        + bottomofcard);
            } else if ((value == PlayingCard.KING) || (value == PlayingCard.ACE) || (value == PlayingCard.TEN) || (value == PlayingCard.JACK)) {
                System.out.println(topofcard + "|" + diamonds + "\t\t |\n" + "|  " + playingCardValue + "\t |\n" + "| \t\t" + diamonds + "|\n"
                        + bottomofcard);
            } else if (value == PlayingCard.QUEEN) {
                System.out.println(topofcard + "|" + diamonds + "\t\t |\n" + "| " + playingCardValue + "  |\n" + "| \t\t" + diamonds + "|\n"
                        + bottomofcard);
            }
        } else if (suit == PlayingCard.CLUBS) {
            if (value >= 2 && value <= 9) {
                System.out.println(topofcard + "|" + clubs + "\t\t |\n" + "| \t" + playingCardValue + "\t |\n" + "| \t\t" + clubs + "|\n"
                        + bottomofcard);
            } else if ((value == PlayingCard.KING) || (value == PlayingCard.ACE) || (value == PlayingCard.TEN) || (value == PlayingCard.JACK)) {
                System.out.println(topofcard + "|" + clubs + "\t\t |\n" + "|  " + playingCardValue + "\t |\n" + "| \t\t" + clubs + "|\n"
                        + bottomofcard);
            } else if (value == PlayingCard.QUEEN) {
                System.out.println(topofcard + "|" + clubs + "\t\t |\n" + "| " + playingCardValue + "  |\n" + "| \t\t" + clubs + "|\n"
                        + bottomofcard);
            }
        }
    }

    /**
     * prints a blank card
     */
    public void printBlankCard() {
        System.out.println(topofcard + middleofcard + bottomofcard);
    }

    /**
     * gets card value as an int from 1-14
     *
     * @return
     */
    public int getValue() {
        return this.value;
    }
}
