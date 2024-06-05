package practice.mvc.rgbcolors.model;

public class RGBColorsData {
    public int row;
    public int column;
    public int red;
    public int green;
    public int blue;

    public RGBColorsData(int row, int column, int red, int green, int blue) {
        this.row = row;
        this.column = column;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "RGBColorsData{" +
                "row=" + row +
                ", column=" + column +
                ", red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
