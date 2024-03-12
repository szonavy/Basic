package practice.complextask.minelake_12.model;

public class LakeDiagram {
    public String row;
    public String depth;

    public LakeDiagram(String row, String depth) {
        this.row = row;
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LakeDiagram that = (LakeDiagram) o;

        if (row != null ? !row.equals(that.row) : that.row != null) return false;
        return depth != null ? depth.equals(that.depth) : that.depth == null;
    }

    @Override
    public int hashCode() {
        int result = row != null ? row.hashCode() : 0;
        result = 31 * result + (depth != null ? depth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LakeDiagram{" +
                "row='" + row + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
