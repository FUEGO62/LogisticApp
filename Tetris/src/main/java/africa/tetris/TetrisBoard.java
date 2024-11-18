package africa.tetris;

public class TetrisBoard {

    public static void mapBoard(String[][] board, TetrisBoardMap map) {
        for (int count = 0; count < board.length; count++) {
            for (int counter = 0; counter < board[count].length; counter++) {
                if (!board[count][counter].isEmpty()) {
                    map.setCoordinate(count, counter, board[count][counter].charAt(0));
                }
            }
        }
    }
    public static void mergeTriangles(String[][] board,int col, TetrisBoardMap map) {
        for(int count = 4; count > 0; count--) {

            if (board[count][col].equals("u") & board[count - 1][col].equals("d")) {
                board[count][col] = "s";
                board[count - 1][col] = "";
                map.setCoordinate(count, col, 's');
                map.setCoordinate(count - 1, col, 'c');
            }
        }
    }

    public static void setBlock(String[][] board, int col, int index, TetrisBoardMap map) {
        char [] shapes = {'s','u','d'};
        for (int count = 4; count >= 0; count--) {
            if (board[count][col].isEmpty()||board[count][col].equals("c")) {
                board[count][col]=shapes[index]+"";
                map.setCoordinate(count, col, shapes[index]);
                break;
            }
        }
    }
    public static void addGravityEffect(String[][] board) {

        for (int count = 4; count>0; count--) {
            for (int counter = 0; counter < 5; counter++) {
                if(board[count][counter].isEmpty() ||board[count][counter].equals("c")) {
                    if(!board[count-1][counter].equals("c")&& !board[count - 1][counter].isEmpty()) {
                        board[count][counter] = board[count-1][counter];
                        board[count-1][counter] = "c";
                    }
                }
            }
        }
    }

    public static boolean isGameOver(String [][] board) {

        boolean continueGame = true;
        for (int count = 0; count < board.length; count++) {
            if (!board[0][count].isEmpty() || board[0][count].equals("c")) {
                continueGame = false;
                System.out.println("GAME OVER!!!");
                break;
            }
        }

        return continueGame;
    }

    public static void clearLine(String[][] board,  TetrisBoardMap map) {
        int lineClearer;

        for(int count = 0; count < board.length; count++) {
            lineClearer = 0;

            for (int counter = 0; counter < board[count].length; counter++) {
                if (board[count][counter].equals("s")) {
                    lineClearer++;
                }
            }

            if (lineClearer == 5) {
                System.out.println("LINE CLEARED");
                board = map.clearLine(count,board);
            }
        }
    }
}
