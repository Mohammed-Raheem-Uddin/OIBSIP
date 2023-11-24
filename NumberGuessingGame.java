import java.util.Random;
import java.util.Scanner;

class Game {
    public int randomNumber;
    public int inputNumber;
    public int noOfGuesses = 0;
    public int maxAttempts = 10;
    public int score = 100; // Assuming a maximum score of 100, deducting 10 points for each unsucessful attempt

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    Game() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(100);
    }

    void takeUserInput() {
        System.out.print("Guess the Random Number:");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }

    boolean isCorrectNumber() {
        noOfGuesses++;
        if (inputNumber == randomNumber) {
            System.out.printf("Congratulations you guessed it right,Yes it was %d.\nYou guessed it in %d attempts..\nYour score: %d",
                    randomNumber, noOfGuesses, score);
            return true;
        } else if (inputNumber < randomNumber) {
            System.out.println("No,The entered number is Too low...");
        } else if (inputNumber > randomNumber) {
            System.out.println("No,The entered number is Too high...");
        }

        // Deduct 10 points for each unsucessful attempt
        score -= 10;

        // Check if the maximum number of attempts is reached
        if (noOfGuesses == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts.");
            System.out.println("The correct number was: " + randomNumber);
            System.out.println("Your final score is: " + score);
            return true;
        }

        return false;
    }
}

public class NumberGuessingGame {
    public static void main(String[] args) {
        /*
            1. Constructor to generate the random number
            2. takeUserInput() to take a user input of number
            3. isCorrectNumber() to detect whether the number entered by the user is true
            4. getter and setter for noOfGuesses
        */

        System.out.println("***Welcome to NUMBER_GUESSING_GAME***");
        Game g = new Game();
        boolean b = false;
        while (!b) {
            g.takeUserInput();
            b = g.isCorrectNumber();
        }
    }
}
