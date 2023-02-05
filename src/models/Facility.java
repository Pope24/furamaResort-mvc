package models;

import java.lang.String;

public abstract class Facility {
    private String codeService;
    private String nameService;
    private double usableArea;
    private double rentalCosts;
    private int maximumPeople;
    private String rentalType;

    public Facility(String codeService, String nameService, double usableArea, double rentalCosts, int maximumPeople, String rentalType) {
        this.codeService = codeService;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return
                        codeService +
                        ", " + nameService +
                        ", " + usableArea +
                        ", " + rentalCosts +
                        ", " + maximumPeople +
                        ", " + rentalType;
    }
}
