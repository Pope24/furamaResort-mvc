package models;

import java.time.LocalDate;

public class Employee extends Person {
    private String codeEmployee;
    private String academicLevel;
    private String position;
    private long salary;

    public Employee(String name, LocalDate dateOfBirth, String gender, String citizenIdentification, String phoneNumber, String email, String codeEmployee, String academicLevel, String position, long salary) {
        super(name, dateOfBirth, gender, citizenIdentification, phoneNumber, email);
        this.codeEmployee = codeEmployee;
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "codeEmployee='" + codeEmployee + '\'' +
                super.toString() +
                ", academicLevel='" + academicLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                "} ";
    }
}
