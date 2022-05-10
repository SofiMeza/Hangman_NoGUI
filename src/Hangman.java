import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        char guess = 0;
        boolean keepGoing = true;
        boolean isInWord;
        boolean isVerified;
        int lives = 5;
        StringBuilder guessedWord = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert string  for your friend to guess: ");
        final String wordToGuess = scanner.nextLine();

        for (int i = 0; i < 50; i++) {
            System.out.println("*****************************************");
        }
        System.out.println();
        System.out.println("Welcome to Hangman non GUI version !!!");
        System.out.println("You have 5 lives ! Don't kill the lil man");
        System.out.println();

        guessedWord.append("_".repeat(wordToGuess.length()));

        System.out.println(guessedWord.toString());
        System.out.println();

        while(keepGoing) {
            isVerified = true;
            isInWord = false;
            while (isVerified) {
                System.out.print("Enter the character you want to guess: ");
                String verificationTemp = scanner.nextLine();
                System.out.println();

                if (verificationTemp.length() != 1) {
                    System.out.println("Error, please make sure you only enter one character");
                } else {
                    guess = verificationTemp.charAt(0);
                    isVerified = false;
                }
            }

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    isInWord = true;
                }
            }

            System.out.println(guessedWord.toString());
            System.out.println();

            if (!isInWord) {
                lives--;
                if (lives <= 0) {
                    System.out.println("You killed lil guy !!!!");
                    System.out.println("Game Over");
                    System.out.println("The word was " + wordToGuess);
                    keepGoing = false;
                } else {
                    System.out.println("You have " + lives + " remaining lives");
                    System.out.println("Try again");
                    System.out.println();
                }
            } else {
                if (!guessedWord.toString().contains("_")) {
                    System.out.println("You got it !!!");
                    keepGoing = false;
                } else {
                    System.out.println("Great!!! Keep going");
                }
            }

        } //end while
    } //end main
} //end class
