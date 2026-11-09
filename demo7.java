import java.util.Random;
import java.util.Scanner;

//EXTENSION
class Scoreboard {
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;

    public void recordWin() {
        wins++;
    }

    public void recordLoss() {
        losses++;
    }

    public void recordTie() {
        ties++;
    }

    public void printScore() {
        System.out.println("\n--- Final Scoreboard ---");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
        System.out.println("------------------------\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"rock", "paper", "scissors"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes";
        
        //EXTENSION
        Scoreboard scoreboard = new Scoreboard();
        
        do {
            System.out.print("Enter your move (rock, paper, scissors): ");
            playerChoice = scanner.nextLine().toLowerCase();
            
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice");
                continue;
            }
            
            computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer choice: " + computerChoice);
            
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
                //EXTENSION
                scoreboard.recordTie();
            } else if (
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("You win!");
                // EXTENSION
                scoreboard.recordWin();
            } else {
                System.out.println("You lose!");
                // EXTENSION
                scoreboard.recordLoss();
            }
            
            System.out.print("Play again (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();
            
        } while (playAgain.equals("yes"));
        
        // EXTENSION
        scoreboard.printScore();
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
