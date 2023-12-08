package practice.complextask.fence;

public class FenceData {
    int houseNumber;
    int oddOrEven;
    int meter;
    int fenceColor;

    static int oddNumber = 0;
    static int evenNumber = 0;

    public FenceData(int houseNumber, int oddOrEven, int meter, int fenceColor) {
        this.houseNumber = houseNumber;
        this.oddOrEven = oddOrEven;
        this.meter = meter;
        this.fenceColor = fenceColor;

        if(oddOrEven == 0){
            evenNumber++;
            houseNumber = evenNumber;
        }else{
            oddNumber++;
            houseNumber = oddNumber;
        }
    }

    @Override
    public String toString() {
        return "FenceData{" +
                "houseNumber=" + houseNumber +
                ", oddOrEven=" + oddOrEven +
                ", meter=" + meter +
                ", fenceColor=" + fenceColor +
                '}';
    }
}
