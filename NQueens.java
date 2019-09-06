public class NQueens {
    private int[][] board;
    private int size;

    //Constructor
    public NQueens(int n) {//Constructor
        this.size = n;
        this.board = new int[n][n];
    }

    public boolean isSafe(int row, int col){
        if(board[row][col]==0){
            //Checks the vertical and horizontal
            for (int i = 0; i < this.board.length; i++) {
                if(this.board[row][i] != 0 || this.board[i][col] != 0)
                    return false;
            }
            //This checks the up-right diagonal
            for(int i=(row - 1), j=(col + 1); i>=0 && j<this.board[i].length; i--, j++){
                if (this.board[i][j] != 0)
                    return false;
            }
            //This checks the up-left diagonal
            for(int i=(row - 1), j=(col - 1); i>=0 && j>=0; i--, j--){
                if (this.board[i][j] != 0)
                    return false;
            }
            //This checks the down-right diagonal
            for(int i=(row + 1), j=(col + 1); i<this.board.length && j<this.board[i].length; i++, j++){
                if (this.board[i][j] != 0)
                    return false;
            }
            //This checks the down-left diagonal
            for(int i=(row + 1), j=(col - 1); i<this.board.length && j>=0; i++, j--){
                if (this.board[i][j] != 0)
                    return false;
            }
            return true;
        }
        return false;
    }


    public boolean FindingSolution(int row){
        //This checks if the function passed through all the rows successfully
        if(row >= board.length)
            return true;
        //This for loop allows a Queen to be placed in every column in the row
        for(int col=0; col < board.length; col++){
            //This checks if the queen is safe to be placed in that square
            if(isSafe(row, col)){
                //This places the queen in that space
                board[row][col] = 1;

                /*This is the recursive function that checks and places queens in all the next safe
                squares in those rows. If all the rows are satisified, then it will have a solution.*/
                if(FindingSolution(row+1) == true)
                    return true;
                /*If all rows are not satisfied, then this next statement will go back to the
                original row and place the queen in the next available column.*/
                board[row][col] = 0;
            }
        }
        return false;

    }

    public boolean placeNQueens() throws Exception{
        try {
            if (this.size <= 0)
                throw new Exception("Invalid size");
            else
                return (FindingSolution(0) == true);
        }
        catch(Exception e){
            System.out.println(e);
            throw e;
        }
    }

    public void printToConsole() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if(this.board[row][col]==1)
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
                System.out.println();
            }
            System.out.println();
        }
    }

}