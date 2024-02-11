public class Configurations {
    private int boardSize, lengthToWin, max_levels;
    private char[][] boardState;

    //Constructor method that requires no arguement
        public Configurations(){
            //undefined
        }

    /**Constructor method that requires 3 arguements:
     * board size, length to win, and max levels
     * @param boardSize
     * @param lengthToWin
     * @param max_levels */
        public Configurations(int boardSize, int lengthToWin, int max_levels){
            //Defining all the fields of Configurations and initializing boardState
                this.boardSize = boardSize;
                this.lengthToWin = lengthToWin;
                this.max_levels = max_levels;
                boardState = new char[boardSize][boardSize];

            //initializing every space in the board to ' '
                for (int row = 0; row < boardSize; row++){
                    for (int col = 0; col < boardSize; row++){
                        boardState[row][col] = ' ';
                    }
                }
        }
    
    //i have no clue man
        public HashDictionary createDictionary(){
            return null;
        }
}
