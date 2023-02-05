package models;

import java.time.LocalDate;

public class Room extends Facility {
    private String freeService;

    public Room(String codeService, String nameService, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String freeService) {
        super(codeService, nameService, usableArea, rentalCosts, maximumPeople, rentalType);
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
        return super.toString() +
                ", " + freeService;
    }
}
