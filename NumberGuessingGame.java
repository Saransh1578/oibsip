import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxNumber = 100;
        int attempts = 5;
        int totalRounds = 3;
        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int randomNumber = random.nextInt(maxNumber) + 1; // Generate random number between 1 and 100

            System.out.println("Round " + round + ": Guess the number between 1 and " + maxNumber);

            int guessesLeft = attempts;
            boolean guessedCorrect = false;

            while (guessesLeft > 0 && !guessedCorrect) {
                System.out.println("Attempts remaining: " + guessesLeft);
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + (attempts - guessesLeft + 1) + " attempts.");
                    score += (attempts - guessesLeft + 1); // More attempts = less points
                    guessedCorrect = true;
                } else if (guess > randomNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                guessesLeft--;
            }

            if (!guessedCorrect) {
                System.out.println("You ran out of guesses. The number was: " + randomNumber);
            }
        }

        System.out.println("Total Score: " + score);
        System.out.println("Thanks for playing!");
    }
}
