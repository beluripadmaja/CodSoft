import java.util.Random;
import java.util.Scanner;

public class numbergame{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        String playAgain;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n=== Number Guessing Game ===");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;

                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;

                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Game Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}