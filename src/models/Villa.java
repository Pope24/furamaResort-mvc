package models;

import java.lang.String;

public class Villa extends Facility {
    private int roomStandard;
    private double poolArea;
    private int numberOfFloor;

    public Villa(String nameService, double usableArea, double rentalCosts, int maximumPeople, String rentalType, int roomStandard, double poolArea, int numberOfFloor) {
        super(nameService, usableArea, rentalCosts, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + roomStandard +
                ", " + poolArea +
                ", " + numberOfFloor;
    }
}
