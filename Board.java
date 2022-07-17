// class to print the board and add the functionality to the board in terms of placing a token or checking a win
public class Board {

    //variable board is initialized and is set to private
    private Token[][] board;

    //Constructor: this is the board size by default
    public Board() {
        board = new Token[6][7];
    }

    //Constructor overload: if the board size is different than the default board size
    //It can be set using this constructor
    public Board(int row, int column) {
        board = new Token[row][column];
    }

    //method to calculate the last empty row available in an input column
    public int lastEmptyRow(int inputColumn) {
      //set the empty rows to board.length
        int emptyRow = board.length;
        //set the filled variable to false
        //such that it is an empty tile
        boolean rowFilled = false;
        //the for loop will iterate over the board rows of the board.
        for (int row = board.length; row >= 0; row--) {
            //if a row is  filled then the next row is checked
            if (!rowFilled) {
                if (board[row - 1][inputColumn - 1] != null) { 
                //else if statement for when an empty row is found
                } else if (board[row - 1][inputColumn - 1] == null) { 
                  // value of row empty row derived from the iteration
                    emptyRow = row;
                    //this row will now be filled
                    rowFilled = true;
                }
            }
        }
        //this is the value of the empty row in integer form
        return emptyRow;
    }


    //checks if the move can be made or not based on the parameters of input column and
    // the associated empty row with it
    public boolean checkMove(int emptyRow, int inputColumn) {
        //if statement to check input is greater than 0
        //and to check input is till the board length of 7.
        if (inputColumn> 0 && inputColumn <= 7) {
            //the empty row must be between till 6 as per the
            //dimensions of our board
            if (emptyRow <= 6) {
                //checks if the tile on this position is empty or not
                //returns equivalent of a true boolean
                return (board[emptyRow - 1][inputColumn - 1] == null);
            }
        }
        //return a boolean false if the move is not valid
        return false;
    }

    //Method to insert the token into the relevant column based on the last empty row position
    public void insertToken(int emptyRow, int inputColumn, Token player) {

        /* To insert the token in the relevant position on the the board
        the board based on the input column selected and the last empty row calculated */
        board[emptyRow-1][inputColumn - 1] = player;
    }


    //method to print the board
    public String toString() {
        String boardTiles = "";
        // the following prints a board with the dimensions [i][j-1]
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                //if there is not input then empty tile will be printed
                if (board[row][column] == null) {
                    boardTiles += "|   ";
                } else {
                    //statement to replace empty tiles with tokens
                    boardTiles += "| " + board[row][column].getToken() + " ";
                }
            }
            // the following code adds an extra column to the board tile design such that dimensions are [i][j]
            boardTiles += "|";
            //skip a line
            boardTiles += "\n";

        }
        //the following iterative for loop is used to print out a number line in the bottom row starting from '1'.
        for (int numberLine = 0; numberLine < board[0].length; numberLine++) {
            boardTiles += "  " + (numberLine + 1) + " " + "";
        }
        return boardTiles;
    }

    //method to check for a draw
    public boolean checkDraw() {
        //initially the draw scenario is set to false
        //initially the draw scenario is set to false
        //iteration loop to iterate over the entire rows of the board tiles
        for (int row = 0; row < board.length; row++) {
            //iteration loop to iterate over the entire columns of the board tiles
            for (int column = 0; column < board[row].length; column++) {
                //if statement clarifies if the tiles are empty or not
                if (board[row][column] != null) {
                    //if all tiles are filled then it is a draw
                }
                else {
                    //return of a false boolean if not all tiles are filled
                    return false;
                }
            }
        }
        // return of a true boolean in case of a draw
        return true;
    }

    //method that returns true if there is a win either vertically, diagonally or horizontally
    public boolean checkWin(Token player) {
        // check for a win through vertical, horizontal or diagonal pattern
        return (checkVertical(player) || checkHorizontal(player) || checkDiagonal(player));
    }

    //method to check for horizontal tokens
    private boolean checkHorizontal(Token player) {
        // counter is initiliasied at zero
        int count = 0;
        //iteration over the rows
        for (int  row = 0; row < board.length; row++) {
            //iteration over the columns
            //the row is kept as constant
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == player) {
                  // a token match is found and counter increases
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                  //counter is set to 0 as pattern is broken.
                    count = 0;
                }
            }
            //counter is set to zero as pattern is broken.
            count = 0;
        }
        return false;
    }

    //method to check for vertical token win pattern
    private boolean checkVertical(Token player) {
        int count = 0;
        //iteration over the columns
        for (int column = 0; column < board[0].length; column++) {
            //iteration over the rows
            for (int row= 0; row < board.length; row++) {
                if (board[row][column] == player) {
                  //when a match of column takes place:
                    // the counter increases by 1
                    count = count + 1;
                    //if the counter reaches the game condition set, such as 4 in Connect4
                    //then boolean true is returned such that it is a win
                    if (count >= 4) {
                        return true;
                    }
                    //if the pattern is broken before reaching the game condition or 4 in the case of Connect4:
                    // then the counter is reset to 0.
                } else {
                    count = 0;
                }
            }
            //counter is reset to 0 due to different tokens breaking the pattern.
            count = 0;
        }
        return false;
    }


    // method to check for upward diagonal win
    private boolean checkDiagonal(Token player) {
        //iteration over the rows
        for (int row = 0; row < this.board.length; row++) {
            //iteration over the columns
            for (int column = 0; column < this.board[row].length; column++) {
                try {
                    // the following if statement assumes that the last token is [row][column]
                    //from this position it checks for all the upward and downward diagonal patterns
                    if ((this.board[row][column] == player && this.board[row + 1][column - 1] == player &&
                            this.board[row + 2][column - 2] == player && this.board[row + 3][column - 3] == player) ||
                            (this.board[row][column] == player && this.board[row + 1][column + 1] == player
                                    && this.board[row + 2][column + 2] == player && this.board[row + 3][column + 3] == player)) {
                        //if pattern matches true boolean is returned
                        return true;
                    }
                    // for exceptional handling in case our algorithm goes out of bound from the array index
                } catch (Exception e) {
                }
            }
        }
        //if pattern does not match then false boolean is returned
        return false;
    }
}

