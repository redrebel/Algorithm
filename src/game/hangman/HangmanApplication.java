package game.hangman;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 7. 11..
 * Hangman
 */
public class HangmanApplication {
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to hangman!");
    System.out.println("I will pick a word and you will try to guess it chatacter by character.");
    System.out.println("If you guess wrong 6 times, then I win.");
    System.out.println("If you can guess before then, you win.");
    System.out.println("Are you ready? I hope so because I am.");
    System.out.println();
    System.out.println("I have picked my word. Below is a picture, "
            + "and below that is your current guess, which starts off as nothing.\n"
            + "Every time you guess incorrectly. I add a body part to the picture. "
            + "when there is a full person, you lost.");

    // Allows for multiple games
    boolean doYouWantToPlay = true;
    while(doYouWantToPlay){
      // setting up the game
      System.out.println();
      System.out.println("Alright! Let's play!");

      Hangman game = new Hangman();
      do{
        // Draw the things...
        System.out.println();
        System.out.println(game.drawPicture());
        System.out.println();
        System.out.println(game.getFormalCurrentGuess());
        System.out.print(game.mysteryWord);
        System.out.println();

        // Get the guess
        System.out.println("Enter a character that you think is in the word");
        char guess = sc.next().toLowerCase().charAt(0);
        System.out.println();

        // Check if the character is guessed already
        while(game.isGuessedAlready(guess)){
          System.out.println("Try again! You've already guessed that character.");
          guess = sc.next().toLowerCase().charAt(0);
        }

        // Play the guess
        if(game.playGuess(guess)){
          System.out.println("Greate guess! That character is in the word!");
        }
        else{
          System.out.println("Unfortunately that character isn't in the word");
        }

      } while (!game.gameOver()); // keep playing untili the game is over.

      // Play again or no?
      System.out.println();
      System.out.println("Do you want to play another game? Enter Y if you do.");
      Character response = sc.next().toUpperCase().charAt(0);
      doYouWantToPlay = (response == 'Y');
    }

  }
}
