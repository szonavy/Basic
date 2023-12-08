package practice.complextask.fence;

public class FenceData {
    int houseNumber;
    int oddOrEven;
    int meter;
    String fenceColor;

    public static int oddNumber = -1;
    public static int evenNumber = 0;

    public FenceData(int oddOrEven, int meter, String fenceColor) {
        this.oddOrEven = oddOrEven;
        this.meter = meter;
        this.fenceColor = fenceColor;

        if(oddOrEven == 0){
            evenNumber+=2;
            this.houseNumber = evenNumber;
        }else{
            oddNumber+=2;
            this.houseNumber = oddNumber;
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
