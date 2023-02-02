package models;

import java.time.LocalDate;

public class Booking {
    private String codeBooking;
    private LocalDate startDateBooking;
    private LocalDate endDateBooking;
    private String codeCustomer;
    private String nameService;

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public LocalDate getStartDateBooking() {
        return startDateBooking;
    }

    public void setStartDateBooking(LocalDate startDateBooking) {
        this.startDateBooking = startDateBooking;
    }

    public LocalDate getEndDateBooking() {
        return endDateBooking;
    }

    public void setEndDateBooking(LocalDate endDateBooking) {
        this.endDateBooking = endDateBooking;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", startDateBooking=" + startDateBooking +
                ", endDateBooking=" + endDateBooking +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                '}';
    }
}
