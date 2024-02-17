public class Configurations {
    private int boardSize, lengthToWin, max_levels;
    private char[][] boardState;

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
                    for (int col = 0; col < boardSize; col++){
                        boardState[row][col] = ' ';
                    }
                }
        }
    
    //Creates an empty hashDictionary and returns it 
        public HashDictionary createDictionary(){
            return new HashDictionary(9371);
        }

    /**This Helper method converts the current boardState to a 
     * string that can be hashed and stored in a hash dictionary
     * @return formattedConfiguration */
        private String formatBoardConfig(){
            //declaring and initializing local variables
                String formattedConfig = new String();

            //String conversion
                for(int row = 0; row < boardSize; row++){
                    for(int col = 0; col < boardSize; col++){
                        formattedConfig += boardState[row][col];
                    }
                }
            //returning the formatted string
                return formattedConfig;
        }
    
    /**Helper method that calls the get() function from HashDictionary,
     * and returns a score of the board state if it exists already,
     * otherwise, it returns -1.
     * @param hashTable
     * @return score */
        public int repeatedConfiguration(HashDictionary hashTable){
            return hashTable.get(formatBoardConfig());
        }

    /**This Accessor method stores the current state of the board
     * as a string in the provided dictionary along with its 
     * corresponding score.
     * @param hashDictionary
     * @param score */
        public void addConfiguration(HashDictionary hashDictionary, int score){
            hashDictionary.put(new Data(formatBoardConfig(), score));

        }
    
    //Accessor method that saves a player's move into the board
        public void savePlay(int row, int col, char symbol){
            boardState[row][col] = symbol;
        }
    //Helper method that determines whether a space on the board is empty or not
        public boolean squareIsEmpty(int row, int col){
            return (boardState[row][col] == ' ');
        }

    /**Helper method that scans the entire board to see if there is a
     * continuous sequence of a symbol that is lengthToWin long in
     * a vertical, horizontal, or diagonal line.
     * @param symbol
     * @return */
        public boolean wins(char symbol){
            //declaring and initializing local variables
                int sequence = 0;

            //checking for a horizontal/vertical line
                for(int row = 0; row < boardSize; row++){
                    for(int col = 0; col < boardSize; col++){
                        if(symbol == boardState[row][col]){
                            sequence++;
                            if(sequence == lengthToWin)
                                return true;
                        }
                        else
                            sequence = 0;
                    }   
                    sequence = 0;
                }
                for(int col = 0; col < boardSize; col++){
                    for(int row = 0; row < boardSize; row++){
                        if(symbol == boardState[row][col]){
                            sequence++;
                            if(sequence == lengthToWin)
                                return true;
                        }
                        else
                            sequence = 0;
                    }
                    sequence = 0;
                }
            //checking for a diagonal line (diagonials starting from bottom left heading to top right)
                sequence = 0;
                for(int dLen = 0; dLen < boardSize; dLen++){
                    for(int col = 0, row = dLen; col <= dLen; col++, row--){
                        if(symbol == boardState[row][col]){
                            sequence++;
                            if(sequence == lengthToWin)
                                return true;
                        }
                        else
                            sequence = 0;
                    }
                    sequence = 0;
                }
                sequence = 0;
                for(int offset = 1; offset < boardSize; offset++){
                    for(int col = offset, row = boardSize-1; col < boardSize; col++, row--){
                        if(symbol == boardState[row][col]){
                            sequence++;
                            if(sequence == lengthToWin)
                                return true;
                        }
                        else
                            sequence = 0;
                    }
                    sequence = 0;
                }

            //checking for a diagonal line (Diagonals starting from bottom right heading to top left)
                sequence = 0;
                for(int dLen = 0; dLen < boardSize; dLen++){
                    for(int row = dLen, col = boardSize-1; row >= 0; row--, col--){
                        if(symbol == boardState[row][col]){
                            sequence++;
                            if(sequence == lengthToWin)
                                return true;
                        }
                        else
                            sequence = 0; 
                    }
                    sequence = 0;
                }
                sequence = 0;
                for(int startPos = boardSize-2; startPos >= 0; startPos--){
                    for(int row = boardSize-1, col  = startPos; col >= 0; row--, col--){
                        if(symbol == boardState[row][col]){
                            sequence++;
                            if(sequence == lengthToWin)
                                return true;
                        }
                        else
                            sequence = 0;
                    }
                    sequence = 0;
                }
            //Returning false if and only if there is no sequence of a symbol that is of length lengthToWin
                return false;
        }

    /**Helper method that scans the entire board for empty spaces, and determines 
     * a draw when all spaces are occuppied. It will only be called after a wins()
     * function call, so it will only run when there is no winner
     * @return */
        public boolean isDraw(){
            for(int row = 0; row < boardSize; row++){
                for(int col = 0; col < boardSize; col++){
                    if(boardState[row][col] == ' ')
                        return false;
                }
            }
            //returns true if and only if boardState[row][col] != ' ' for all spaces
                if(wins('X'))
                    return false;
                else if(wins('O'))
                    return false;
                else 
                    return true;
        }

    /**Helper method that asseses the board state and returns an integer score
     * for the computer to use. This method relies on other methods in Configurations
     * to calculate a score for a current boardState
     * @return
     */
        public int evalBoard(){
            if(wins('X'))
                return 0;
            else if(wins('O'))
                return 3;
            else if(isDraw())
                return 2;
            else
                return 1;
        }
}
