package practice.mvc.buildingtax.model;

public class BuildingTaxDetail {
    public int ownerId;
    public String street;
    public String houseNumber;
    public Character section;
    public int square;

    public BuildingTaxDetail(int ownerId, String street, String houseNumber, Character section, int square) {
        this.ownerId = ownerId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.section = section;
        this.square = square;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Character getSection() {
        return section;
    }

    public int getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "BuildingTaxDetail{" +
                "ownerId=" + ownerId +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", section=" + section +
                ", square=" + square +
                '}';
    }
}
