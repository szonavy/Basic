package practice.complextask.minelake_12.solvedifferentways.model;

public class MineLakeDiagram {
    String row;
    String depth;

    public MineLakeDiagram(String row, String depth) {
        this.row = row;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "MineLakeDiagram{" +
                "row='" + row + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
