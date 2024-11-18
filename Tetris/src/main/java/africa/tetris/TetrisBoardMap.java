package africa.tetris;

public class TetrisBoardMap {

    private int row = 0;
    private int col = 0;
    private int [][] bigBoard = new int[20][20];

    public void setCoordinate(int row, int col,char value) {
        this.row = row;
        this.col = col;

        if(value=='u') mapUpTriangle();
        else if(value=='s')mapSquare();
        else if(value=='d') mapDownTriangle();
        else if(value=='c') clear();
    }

    public void mapSquare(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                bigBoard[4 * row +i][4 * col + j] = 1;
            }
        }
    }

    public void mapUpTriangle(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                bigBoard[4 * row +i][4 * col + j] = 1;
            }
        }
    }

    public void mapDownTriangle(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                bigBoard[4 * row +j][4 * col + i] = 1;
            }
        }
    }

    public void clear(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                bigBoard[4 * row +i][4 * col + j] = 0;
            }
        }
    }

    public void display(){
        for (int i = 0; i < bigBoard.length; i++) {
            for (int j = 0; j < bigBoard[i].length; j++) {
                if(bigBoard[i][j]==1){System.out.print("* ");}
                else System.out.print("  ");
            }

            System.out.println();
        }

        for(int i = 0; i<20;i++){
            System.out.print("==");
        }

        System.out.println("\n\n\n");
    }

    public String[][] initialize(String [][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "";
            }
        }

        return board;
    }

    public String[][] clearLine(int row,String [][] board){
        for (int i = 0; i < board.length; i++) {
            board[row][i] = "c";
        }

        return board;
    }
}