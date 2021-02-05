import java.util.*;

/**
 * App that handles bets for blackjack and runs the program.
 */
public class BlackJackApp {
    /**
     * Main methdod that runs the game. Prompts the user for a bet, starts the game, and tells the player if they won/lost
     * and their winnings.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char keepgoing;
        int totalmoney = 0;
        while (true) {
            System.out.println("Enter the amount of money you want to bet.");
            int bet = scanner.nextInt();
            //makes new game object
            BlackJack blackjack = new BlackJack();
            boolean gameresult = blackjack.PlayBlackJack();
            if (gameresult) {
                System.out.println("You won: $" + bet);
                totalmoney += bet;
                System.out.println("For a total winnings of:$" + totalmoney);
            } else {
                System.out.println("Better luck next time champ");
                System.out.println("You lost: $" + bet);
                totalmoney -= bet;
                System.out.println("For a total winnings of:$" + totalmoney);
            }
            System.out.println("Play again? [Y] [N]");
            keepgoing = scanner.next().toUpperCase().charAt(0);
            if (keepgoing != 'Y') {
                System.out.println("See you again soon");
            }
        }
    }
}
