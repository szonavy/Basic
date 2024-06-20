package practice.mvc.sudoku.model;

public class PlayerDecision {
    public int value;
    public int row;
    public int column;
    public String status;

    public PlayerDecision(int value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;

    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PlayerDecision{" +
                "value=" + value +
                ", row=" + row +
                ", column=" + column +
                ", status='" + status + '\'' +
                '}';
    }
}
