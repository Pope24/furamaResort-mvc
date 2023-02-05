package models;

import java.time.LocalDate;

public abstract class Facility {
    private String nameService;
    private double usableArea;
    private double rentalCosts;
    private int maximumPeople;
    private LocalDate rentalType;

    public Facility(String nameService, double usableArea, double rentalCosts, int maximumPeople, LocalDate rentalType) {
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
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

    public LocalDate getRentalType() {
        return rentalType;
    }

    public void setRentalType(LocalDate rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return
                nameService +
                ", " + usableArea +
                ", " + rentalCosts +
                ", " + maximumPeople +
                ", " + rentalType;
    }
}
