package utils;

import models.Room;
import models.Villa;

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

    public Villa getInfoVillaService() {
        Villa villaService = null;
        try {
            System.out.println("Nhap ten dich vu:");
            String nameService = sc.nextLine();
            System.out.println("Nhap dien tich co the su dung: ");
            double usableArea = Double.parseDouble(sc.nextLine());
            System.out.println("Nhap gia muon thue dich vu: ");
            double rentalCosts = Double.parseDouble(sc.nextLine());
            System.out.println("Nhap so nguoi su dung dich vu: ");
            int maximumPeople = Integer.parseInt(sc.nextLine());
            String rentalType = getRentalType();
            System.out.println("Nhap tieu chuan phong tu 1 - > 5 sao: ");
            int roomStandard = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap dien tich ho boi: ");
            double poolArea = Double.parseDouble(sc.nextLine());
            System.out.println("Ban muon o tang bao nhieu: ");
            int numberOfFloor = Integer.parseInt(sc.nextLine());
            villaService = new Villa(nameService, usableArea, rentalCosts, maximumPeople, rentalType, roomStandard, poolArea, numberOfFloor);
        } catch (NumberFormatException e) {
            return getInfoVillaService();
        }
        return villaService;
    }

    public Room getInfoRoomService() {
        Room roomService = null;
        try {
            System.out.println("Nhap ten dich vu: ");
            String nameService = sc.nextLine();
            System.out.println("Nhap dien tich co the su dung: ");
            double usableArea = Double.parseDouble(sc.nextLine());
            System.out.println("Nhap gia muon thue dich vu: ");
            double rentalCosts = Double.parseDouble(sc.nextLine());
            System.out.println("Nhap so nguoi su dung dich vu: ");
            int maximumPeople = Integer.parseInt(sc.nextLine());
            String rentalType = getRentalType();
            String freeService = getFreeService();
            roomService = new Room(nameService, usableArea, rentalCosts, maximumPeople, rentalType, freeService);
        } catch (NumberFormatException e) {
            return getInfoRoomService();
        }
        return roomService;
    }

    public String getRentalType() {
        int chooseType;
        String rentalType = null;
        try {
            System.out.println("Ban muon thue theo kieu nao: ");
            System.out.println("1. Thue theo ngay.");
            System.out.println("2. Thue theo thang.");
            System.out.println("3. Thue theo nam.");
            System.out.println("Nhap kieu ban muon thue: ");
            chooseType = Integer.parseInt(sc.nextLine());
            switch (chooseType) {
                case 1:
                    rentalType = "Thue theo ngay";
                    break;
                case 2:
                    rentalType = "Thue theo thang";
                    break;
                case 3:
                    rentalType = "Thue theo nam";
                    break;
                default:
                    System.out.println("Khong co muc nay !! Xin moi ban nhap lai: ");
                    return getRentalType();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ban nhap sai quy dinh !! Xin moi ban nhap lai: ");
            return getRentalType();
        }
        return rentalType;
    }

    public String getFreeService() {
        int chooseType;
        System.out.println("Ban muon theo kem dich vu mien phi nao ?");
        System.out.println("1. Nuoc uong mien phi");
        System.out.println("2. Phuc vu com mien phi");
        System.out.println("3. Xong hoi mien phi");
        try {
            chooseType = Integer.parseInt(sc.nextLine());
            switch (chooseType) {
                case 1:
                    return "Nuoc uong mien phi";
                case 2:
                    return "Phuc vu com mien phi";
                case 3:
                    return "Xong hoi mien phi";
                default:
                    System.out.println("Khong co muc nay!! Moi quy khach chon lai...");
                    return getFreeService();
            }
        } catch (NumberFormatException e) {
            System.out.println("Khong co muc nay!! Moi quy khach chon lai...");
            return getFreeService();
        }
    }

}
