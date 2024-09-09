import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5; 
    private static final int LOWER_BOUND = 1; 
    private static final int UPPER_BOUND = 100; 
    private static int score = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = generateRandomNumber(random);
            boolean isGuessedCorrectly = false;
            int attempts = 0;

            System.out.println("A new number has been generated between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    isGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    score += (MAX_ATTEMPTS - attempts + 1); 
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                if (attempts == MAX_ATTEMPTS) {
                    System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
                }
            }

            System.out.println("Current Score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String userInput = scanner.next().toLowerCase();
            playAgain = userInput.equals("yes");
        }

        System.out.println("Thanks for playing! Final Score: " + score);
        scanner.close();
    }

    private static int generateRandomNumber(Random random) {
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
    }
}
