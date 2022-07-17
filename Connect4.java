//import relevant modules
import java.util.ArrayList;

//class Connect4 that sets the logic and flow of the game
public class Connect4 {

    //board object initialized
    private Board board;
   

    //constructor for the Connect4 class
    public Connect4() {
        //board object from Board class created
        board = new Board();
    }



    //Method to print the game instructions for the players
    private void gameInstructions() {
        //All the relevant print statements relevant to the game
        System.out.println("Welcome to Connect 4");
        //Statement clarifying that the game player is up against a bot.
        System.out.println("You are up against a computer controlled bot");
        System.out.println("You are Red, and the CPU is Yellow");
        System.out.println("Token Red is represented as 'R' and Token Yellow as 'Y' ");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        //the only input that are allowed
        System.out.println("Only input integers 1 to 7 are allowed.");
        System.out.println("");
    }

    //Method to start the game and play
    public void playGame() {
        //Method called to print the game instructions
        gameInstructions();
        //The board is printed
        System.out.println(board);
        //Makes the user aware that an input is required
        System.out.println("Please input a token in any COLUMN 1 to 7 below:");

        //Creates a human player and a bot player using the HumanPlayer and ComputerPlayer class.
        HumanPlayer human = new HumanPlayer(new Token('R'));
        ComputerPlayer bot = new ComputerPlayer(new Token('Y'));
        //An ArrayList is created and called players
        ArrayList<Player> players = new ArrayList<>();
        //The players are added to this ArrayList
        players.add(human);
        players.add(bot);

        //currentPlayer is set as an integer type which initiates as zero
        int currentPlayer = 0;

        while (true) {
            //The total player size for connectN is 2 and by using the remainder function
            //When it human players turn, the currentPlayer variable is set to 0
            //When it is the bot player turn then the variable increases to 1
            //The remainder function is used so values only stay between 0 and 1.
            //So human and bot keep changing turns this way
            Player current = players.get(currentPlayer % players.size());

            //to check if there is a draw
            if (board.checkDraw()){
                //print statement in case of a draw
                System.out.println("ITS A DRAW!");
                //to break the loop once a draw occurs
                break;
            }

            //Robustness Adjustment: Try statement approach was used so that unusual input can be caught
            try {
                //asks the user for a suitable input column
                int input = Integer.parseInt(current.getUserInput()); //get input from the user
                //to calculate the last empty row based on the input column
                int lastEmptyRow = board.lastEmptyRow(input); //lastEmptyRow method from Board class is called
                //check to see if the move is valid or not using the checkMove method
                if (board.checkMove(lastEmptyRow, input)) {
                    //the token is place if the move is valid
                    board.insertToken(lastEmptyRow, input, current.getToken());
                    //to print the board
                    System.out.println(board);
                    //if statement to check if a win has occurred
                    //getToken() is used to get token assigned to a player
                    if (board.checkWin(current.getToken())) {
                        //if statement from the human players perspective
                        if (current == human) {
                            //if a WIN is from a human players turn then the following statement is printed
                            System.out.println("You have WON!");
                        } else {
                            //If a WIN is NOT from a human players turn then it is a LOSS
                            System.out.println("You Lost!");
                            //break the loop
                        }
                        //break the loop to end the game if:
                        //a win/loss situation has come about
                        break;
                    }
                        
                    } else{
                }
                //The currentPlayer value increases from 0 to 1 after every loop
                    //0 stands for human player
                    //1 stands for the bot
                    //this is achieved through the applying the remainder over the players.size()
                currentPlayer++;
                //Exception Handler
            } catch (NumberFormatException e) {
                //Robustness Adjustment 1: to guard against non integer input
                System.out.println("Please only input a number - try again!");
              //Exception Handler
            } catch (ArrayIndexOutOfBoundsException e) {
                //Robustness Adjustment 2: to guard against the situation when:
                // i) column is full and all rows are FILLED
                // ii) input more than the board size is
                // can be thrown at human and bot player both
                System.out.println("Column does not exist or Column is FULL - try again!");

            }

        }
        
    }

}







