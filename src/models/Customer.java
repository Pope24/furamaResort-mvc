package models;

import java.time.LocalDate;

public class Customer extends Person {
    private String codeCustomer;
    private String customerType;
    private String address;

    public Customer(String name, LocalDate dateOfBirth, String gender, String citizenIdentification, String phoneNumber, String email, String codeCustomer, String customerType, String address) {
        super(name, dateOfBirth, gender, citizenIdentification, phoneNumber, email);
        this.codeCustomer = codeCustomer;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "codeCustomer='" + codeCustomer + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'';
    }
}
