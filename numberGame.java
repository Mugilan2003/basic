import java.util.Scanner;
import java.util.Random;

public class NumberGame {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();
                int minRange = 1;
                int maxRange = 100;
                int maxAttempts = 10;
                int score = 0;

                System.out.println("Welcome to the Number Guessing Game!");
                boolean playAgain = true;

                while (playAgain) {
                    int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
                    int attempts = 0;
                    boolean hasGuessedCorrectly = false;

                    System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");

                    while (attempts < maxAttempts && !hasGuessedCorrectly) {
                        System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                        int userGuess = scanner.nextInt();

                        if (userGuess == numberToGuess) {
                            System.out.println("Congratulations! You've guessed the correct number: " + numberToGuess);
                            hasGuessedCorrectly = true;
                        } else if (userGuess < numberToGuess) {
                            System.out.println("Your guess is too low. Try again.");
                        } else {
                            System.out.println("Your guess is too high. Try again.");
                        }

                        attempts++;
                    }

                    if (!hasGuessedCorrectly) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + numberToGuess);
                    } else {
                        score++;
                    }

                    System.out.print("Would you like to play again? (yes/no): ");
                    String playAgainResponse = scanner.next().toLowerCase();
                    playAgain = playAgainResponse.equals("yes");
                }

                System.out.println("Thanks for playing! Your score: " + score);
                scanner.close();
            }
        }
