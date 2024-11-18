package africa.tetris;


public class TetrisShape {

    private final int size;
    private String shape;

    public TetrisShape(int size) {
        this.size = size;

    }
    public String drawUpTriangle() {

        shape = "";

        for(int i = 0; i < size; i++){
            for(int j = 0; j < i; j++){
                shape+="* ";
            }

            shape += "\n";
        }

        return shape;
    }

    public String drawDownTriangle() {
        String space = "  ";
        shape = "";

        for(int i = 0; i < size -1; i++){

            for(int j = 0; j < i; j++){
                shape += space;
            }

            for(int j = 0; j < (size -i)-1; j++){
                shape += "* ";
            }
            shape += "\n";
        }

        return shape;
    }

    public String drawSquare() {
        shape = "";
        for(int i = 1; i < size; i++){
            for(int j = 1; j < size; j++){
                shape += "* ";
            }

            shape += "\n";
        }

        return shape;
    }
}
