package game.TicTacToeApplication;

/**
 * Created by cjred77@gmail.com on 2016. 7. 11..
 * TicTacToe
 */
public class TicTacToe {
  // Picture of Game with Index:
  // FOR STORAGE:
  // 0 | 1 | 2
  // -----------
  // 3 | 4 | 5
  // -----------
  // 6 | 7 | 8
  // WHAT THE USER THINKS:
  // 1 | 2 | 3
  // 4 | 5 | 6
  // 7 | 8 | 9


  // UI Picture of Game
  // INIT:
  // | - | - | -
  // ------------
  // | - | - | -
  // ------------
  // | - | - | -
  // GAMEPLAY
  // | O | - | O
  // | - | X | -
  // | - | - | X

  protected char[] board;
  protected char userMarker;
  protected char aiMarker;
  protected char winner;
  protected char currentMarker;

  public TicTacToe(char userMarker, char aiMarker){
    this.userMarker = userMarker;
    this.aiMarker = aiMarker;
    this.winner = '-';
    this.board = setBoard();
    this.currentMarker = userMarker;
  }

  public char[] setBoard(){
    char[] b  = new char[9];

    for(int i=0; i<b.length; i++){
      b[i] = '-';
    }
    return b;
  }

  public boolean playTurn(int spot){
    boolean isValid = withinRange(spot) && !isSpotTaken(spot);
    if(isValid){
      board[spot-1] = currentMarker;
      currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
    }
    return isValid;
  }

  // check if our spot is in range
  public boolean withinRange(int spot){
    return spot > 0 && spot <= board.length;
  }

  // check if the spot is taken
  public boolean isSpotTaken(int spot){
    return board[spot-1] != '-';
  }

  // print playboard
  public void printBoard(){
    // Attempting to create...
    // | - | - | -
    // ------------
    // | - | - | -
    // ------------
    // | - | - | -
    //
    System.out.println();
    for(int i=1; i<=board.length; i++){
      System.out.print(" | " + board[i-1] );
      if(i%3==0 && i!=board.length){
        System.out.println("\n ------------");
      }
    }
    System.out.println();


  }

  public void printIndexBoard(){
    System.out.println();
    for(int i=1; i<= board.length; i++){
      System.out.print(" | " + i);
      if(i%3==0 && i!=board.length){
        System.out.println("\n ------------");
      }
    }
    System.out.println();
  }

  public boolean rightDi(){
    return (board[0] == board[4] && board[4] == board[8]);
  }

  public boolean leftDi(){
    return (board[2] == board[4] && board[4] == board[6]);
  }

  public boolean middleRow(){
    return (board[3] == board[4] && board[4] == board[5]);
  }

  public boolean secondCol(){
    return (board[1] == board[4] && board[4] == board[7]);
  }

  public boolean topRow(){
    return (board[0]==board[1] && board[1]==board[2]);
  }

  public boolean firstCol(){
    return (board[0]==board[3] && board[3]==board[6]);
  }

  public boolean bottomRow(){
    return (board[6]==board[7] && board[7]==board[8]);
  }

  public boolean thirdCol(){
    return (board[2]==board[5] && board[5]==board[8]);
  }


  public boolean isThereAWinner(){
    boolean diagonalsAndMiddles = board[4] != '-' && (rightDi() || leftDi() || middleRow() || secondCol());
    boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
    boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';

    if(diagonalsAndMiddles){
      this.winner=board[4];
    }
    else if(topAndFirst){
      this.winner=board[0];
    }
    else if(bottomAndThird){
      this.winner=board[8];
    }

    return diagonalsAndMiddles||topAndFirst||bottomAndThird;
  }

  public boolean isTheBoardFilled(){
    for(int i=0; i< board.length; i++){
      if(board[i] == '-'){
        return false;
      }
    }
    return true;
  }

  public String gameOver(){
    boolean didSomeoneWin = isThereAWinner();
    if(didSomeoneWin){
      return "We have a winner! The winner is " + this.winner + "'s";
    } else if(isTheBoardFilled()){
      return "Draw: Game Over!";
    } else {
      return "notOver";
    }
  }
}
