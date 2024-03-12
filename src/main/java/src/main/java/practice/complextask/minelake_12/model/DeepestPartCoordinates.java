package practice.complextask.minelake_12.model;

public class DeepestPartCoordinates {
    public int row;
    public int column;

    public DeepestPartCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeepestPartCoordinates that = (DeepestPartCoordinates) o;

        if (row != that.row) return false;
        return column == that.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }

    @Override
    public String toString() {
        return
                 "(" + row +
                ";" + column + ")";
    }
}
