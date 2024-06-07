package practice.mvc.rgbcolors.model;

public class RGBColorsData {
    public int red;
    public int green;
    public int blue;
    public int sum;

    public RGBColorsData( int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.sum = red + green + blue;
    }

    @Override
    public String toString() {
        return "RGBColorsData{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", sum=" + sum +
                '}';
    }
}
