package practice.complextask.minelake_12.solvewithlist.model;

public class MineLakeCoordinate {
    int row;
    int column;

    public MineLakeCoordinate(int row, int column) {
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
