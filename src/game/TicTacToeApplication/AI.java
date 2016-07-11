package game.TicTacToeApplication;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cjred77@gmail.com on 2016. 7. 11..
 */
public class AI {

  public int pickSpot(TicTacToe game){
    ArrayList<Integer> choices = new ArrayList<>();
    for(int i=1; i<=9;i++){
      // If the slot is not taken, add it as a choice
      if(!game.isSpotTaken(i)){
        choices.add(i);
      }
    }
    Random rand = new Random();
    int choice = choices.get(Math.abs(rand.nextInt()%choices.size()));
    return choice;
  }

}
