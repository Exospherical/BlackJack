import java.util.*;

/**
 * This cclass relies on the CardDeck, PlayingCard and Hand methods.
 * Uses them to run a game of blackjack. Returns true if player wins, and false if not.
 *
 * @author ryan.woodford
 */
public class BlackJack {
    private Hand dealerhand = new Hand();
    private Hand playerhand = new Hand();
    private PlayingCardDeck deck = new PlayingCardDeck();
    private char userinput;

    /**
     * Constructor creates a shuffled deck and add 2 cards to the dealers hand and 2 to the players hand
     */
    public BlackJack() {
        deck.shuffleDeck();
        dealerhand.addCard(deck.drawCard());
        dealerhand.addCard(deck.drawCard());
        playerhand.addCard(deck.drawCard());
        playerhand.addCard(deck.drawCard());
    }

    /**
     * Main method that runs the game. returns true if the player win, and false if not.
     */
    public Boolean PlayBlackJack() {
        //check to see if either player or dealer gets blackjack in first hand
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the famous game of blackjack");
        if (dealerhand.checkHandValue() == 21) {
            System.out.println("Dealer got blackjack and won");
            return false;
        } else if (playerhand.checkHandValue() == 21) {
            System.out.println("Player got blackjack and won");
            return true;
        }
        System.out.println("This is your hand:");
        playerhand.getHand();
        System.out.println("The value of your hand is:" + playerhand.checkHandValue());
        System.out.println("The dealer starts with these cards:");
        dealerhand.getDealersStart();
        new PrintAsciiCard(deck.getDeck().get(0)).printBlankCard();
        System.out.println("The dealers start value is:" + dealerhand.getFirstValue());
        //The player hitting loop starts. Keeps adding cards to until until stay is entered.
        while (true) {
            System.out.println("Hit or stand?");
            System.out.println("");
            userinput = scanner.next().toUpperCase().charAt(0);
            if (userinput == 'S') {
                break;
            }
            if (userinput == 'H') {
                playerhand.addCard(deck.drawCard());
                System.out.println("You draw a card");
                System.out.println("This is your hand now:");
                playerhand.getHand();
                System.out.println("The value of your hand is: " + playerhand.checkHandValue());
                if (playerhand.checkHandValue() > 21) {
                    System.out.println("You lose, because you busted");
                    return false;
                }
            }
        }
        //executes if player stays before they bust.
        System.out.println("Player stands.");
        System.out.println("This is the dealers hand now");
        dealerhand.getHand();
        //dealer hit loop. Loops until the dealer has at least 17
        while (dealerhand.checkHandValue() <= 16) {
            dealerhand.addCard(deck.drawCard());
            dealerhand.getHand();
            System.out.println("Dealer hits.  Dealers hand now has  value of:" + dealerhand.checkHandValue());
            //check to see if dealer busted
            if (dealerhand.checkHandValue() > 21) {
                System.out.println("Dealer busts with a value of:" + dealerhand.checkHandValue());
                return true;
            }
        }
        //situation if player stands and dealer doesnt get blackjack.
        if (dealerhand.checkHandValue() == playerhand.checkHandValue()) {
            System.out.println("Dealer wins on tie.");
            return false;
        }
        //situation if dealer AND player stands and dealer has higher card value
        else if (dealerhand.checkHandValue() > playerhand.checkHandValue()) {
            System.out.println("Dealer wins with a value of " + dealerhand.checkHandValue());
            System.out.println("Compared to your value of " + playerhand.checkHandValue());
            return false;
        }
        //situation if dealer AND player stand and player has a higher hand
        else {
            System.out.println("You win! with a value of " + playerhand.checkHandValue());
            System.out.println("Compared to the dealers value of " + dealerhand.checkHandValue());
            return true;
        }
    }
}