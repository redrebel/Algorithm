package game.TicTacToeApplication;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 7. 11..
 * TicTacToe Application
 */
public class TicTacToeApplication {

  public static int getIntSpot(char c){
    int spot = -1;
    if(c >= '0' && c <='9'){
      spot = c - '0';
    }
    return spot;
  }
  public static void main(String[] args){
    // get input
    Scanner sc = new Scanner(System.in);

    boolean doYouWantToPlay = true;

    System.out.println("Welcome to Tic Tac Toe! You are about to go aginst "
    + "the master of Tic Tac Toe.\n Are you ready? I hope so!\n BUT FIRST, you "
    + " must pick what character you want to be and which character I will be");
    System.out.println();
    System.out.println("Enter a single character that will represent you on the board");
    char playerToken = sc.next().charAt(0);
    System.out.println("Enter a single character that will represent your opponent on the board");
    char opponentToken = sc.next().charAt(0);

    while(doYouWantToPlay){

      TicTacToe game = new TicTacToe(playerToken, opponentToken);
      AI ai = new AI();

      // Set up the game
      System.out.println();
      System.out.println("Now we can start the game. To play, enter a number and your token shall be put "
              + "in its place.\nThe numbers go from 1-9, left to right, we shall see who will win this round.");
      game.printIndexBoard();
      System.out.println();

      Random rand = new Random();
      if(rand.nextBoolean()){
        // user first
        game.currentMarker = playerToken;
      }
      else {
        // ai first
        game.currentMarker = opponentToken;
      }
      // Let's play!
      while(game.gameOver().equals("notOver")){

        if(game.currentMarker == game.userMarker){
          // user turn;
          System.out.println("It is your turn! Enter a spot for your token");
          int spot = getIntSpot(sc.next().charAt(0));

          while(!game.playTurn(spot)){
            System.out.println("Try again. " + spot + " is invalid. this spot is alread taken"
            + " or it is out of range");
            spot = getIntSpot(sc.next().charAt(0));
          }
          System.out.println("You picked " + spot + "!");
        } else {
          // AI turn
          System.out.println("It's my turn!");

          // pick spo
          int aiSpot = ai.pickSpot(game);
          game.playTurn(aiSpot);
          System.out.println("I Picked " + aiSpot +"!");
        }

        System.out.println();
        game.printBoard();
      }

      System.out.println(game.gameOver());
      System.out.println();

      // set up a new game.. or not depending on the response
      System.out.println("Do you want to play again? Enter Y if you do. "
      + "Enter anything else if you are tired of me.");

      char response = sc.next().charAt(0);
      doYouWantToPlay = (response == 'Y');
      System.out.println();
      System.out.println();
    }
  }
}
