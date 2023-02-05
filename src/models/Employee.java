package models;

import java.lang.String;

public class Employee extends Person {
    private String codeEmployee;
    private String academicLevel;
    private String position;
    private String salary;

    public Employee(String name, String dateOfBirth, String gender, String citizenIdentification, String phoneNumber, String email, String codeEmployee, String academicLevel, String position, String salary) {
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                ", " + codeEmployee +
                ", " + academicLevel +
                ", " + position +
                ", " + salary;
    }
}
