package practice.complextask.minelake_12.model;

public class MineLakeData {
    public int row;
    public int column;
    public int value;
    public boolean isLake;

    public MineLakeData(int row, int column, int value, boolean isLake) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.isLake = isLake;
    }

    @Override
    public String toString() {
        return "MineLakeData{" +
                "row=" + row +
                ", column=" + column +
                ", value=" + value +
                ", isLake=" + isLake +
                '}';
    }
}
