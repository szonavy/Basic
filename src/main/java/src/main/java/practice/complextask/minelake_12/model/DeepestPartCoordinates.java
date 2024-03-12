package practice.complextask.minelake_12.model;

public class DeepestPartCoordinates {
    public int row;
    public int column;

    public DeepestPartCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return
                 "(" + row +
                ";" + column + ")";
    }
}
