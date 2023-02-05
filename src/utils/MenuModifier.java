package utils;

import java.lang.reflect.Member;
import java.util.Scanner;

public class MenuModifier {
    static Scanner sc = new Scanner(System.in);

    public String getCustomerType() {
        int chooseType = 0;
        String customerType = null;
        System.out.println("1. Diamond");
        System.out.println("2. Platinum");
        System.out.println("3. Gold");
        System.out.println("4. Silver");
        System.out.println("5. Member");
        System.out.println("Moi ban chon: ");
        try {
            chooseType = Integer.parseInt(sc.nextLine());
            switch (chooseType) {
                case 1:
                    customerType = "Diamond";
                    break;
                case 2:
                    customerType = "Platinum";
                    break;
                case 3:
                    customerType = "Gold";
                    break;
                case 4:
                    customerType = "Silver";
                    break;
                case 5:
                    customerType = "Member";
                    break;
                default:
                    System.out.println("Khong co muc nay !! Moi ban chon lai: ");
                    return getCustomerType();
            }
        } catch (NumberFormatException e) {
            System.err.println("Ban nhap sai quy dinh !!! Moi ban nhap lai : ");
            return getCustomerType();
        }
        return customerType;
    }

    public String getAcademicLevelOfEmployee() {
        int chooseType = 0;
        String academicLevel = null;
        System.out.println("1. Intermediate");
        System.out.println("2. College");
        System.out.println("3. University");
        System.out.println("4. Graduate");
        System.out.println("Moi ban chon trinh do hoc van: ");
        try {
            chooseType = Integer.parseInt(sc.nextLine());
            switch (chooseType) {
                case 1:
                    academicLevel = "Intermediate";
                    break;
                case 2:
                    academicLevel = "College";
                    break;
                case 3:
                    academicLevel = "University";
                    break;
                case 4:
                    academicLevel = "Graduate";
                    break;
                default:
                    System.out.println("Khong co muc nay !! Moi ban chon lai: ");
                    return getAcademicLevelOfEmployee();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ban nhap sai quy dinh !!! Moi ban nhap lai : ");
            return getAcademicLevelOfEmployee();
        }
        return academicLevel;
    }

    public String getEmployeePosition() {
        int chooseType;
        String position = null;
        System.out.println("1. Receptionist");
        System.out.println("2. Waitress");
        System.out.println("3. Restaurant specialist");
        System.out.println("4. Supervisor");
        System.out.println("5. Manager");
        System.out.println("6. CEO");
        System.out.println("Moi ban vi tri: ");
        try {
            chooseType = Integer.parseInt(sc.nextLine());
            switch (chooseType) {
                case 1:
                    position = "Receptionist";
                    break;
                case 2:
                    position = "Waitress";
                    break;
                case 3:
                    position = "Restaurant specialist";
                    break;
                case 4:
                    position = "Supervisor";
                    break;
                case 5:
                    position = "Manager";
                    break;
                case 6:
                    position = "CEO";
                    break;
                default:
                    System.out.println("Khong co muc nay !! Moi ban chon lai: ");
                    return getEmployeePosition();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ban nhap sai quy dinh !!! Moi ban nhap lai : ");
            return getEmployeePosition();
        }
        return position;
    }
}
