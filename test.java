import java.util.Scanner;
import java.util.Random;


public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        
        String[] words = {"apple", "banana", "cherry", "orange", "pear", "grape", "watermelon", "pineapple", "strawberry", "blueberry"};
        String wordToGuess = words[random.nextInt(words.length)];
        char[] guessedLetters = new char[wordToGuess.length()];
        int numGuesses = 0;
        int maxGuesses = 6;
        
        System.out.println("Welcome to Wordle!");
        System.out.println("The word to guess has " + wordToGuess.length() + " letters.");
        System.out.println("You have " + maxGuesses + " guesses to get it right.");
        
        while (numGuesses < maxGuesses) {
            System.out.println();
            System.out.print("Guess a letter: ");
            char guess = input.next().charAt(0);
            
            if (wordToGuess.indexOf(guess) != -1) {
                System.out.println("Good guess!");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedLetters[i] = guess;
                    }
                }
                if (wordToGuess.equals(new String(guessedLetters))) {
                    System.out.println("Congratulations, you won!");
                    input.close();                    
                    return;
                }
            } else {
                System.out.println("Sorry, that letter is not in the word.");
                numGuesses++;
            }
            
            System.out.println("You have " + (maxGuesses - numGuesses) + " guesses left.");
            System.out.println("Current progress: " + new String(guessedLetters));
        }
        
        System.out.println("Sorry, you lost! The word was " + wordToGuess + ".");
        //close scanner
        input.close();
    }

}
