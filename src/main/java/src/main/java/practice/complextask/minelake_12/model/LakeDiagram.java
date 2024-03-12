package practice.complextask.minelake_12.model;

public class LakeDiagram {
    public String row;
    public String depth;

    public LakeDiagram(String row, String depth) {
        this.row = row;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "LakeDiagram{" +
                "row='" + row + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
