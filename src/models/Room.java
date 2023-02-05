package models;

import java.time.LocalDate;

public class Room extends Facility {
    private String freeService;

    public Room(String nameService, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String freeService) {
        super(nameService, usableArea, rentalCosts, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", " + freeService;
    }
}
