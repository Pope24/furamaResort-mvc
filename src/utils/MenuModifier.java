package utils;

import models.Booking;
import models.Customer;
import models.Room;
import models.Villa;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.*;

public class MenuModifier {
    static Scanner sc = new Scanner(System.in);
    RegexAddFacility regexAddFacility = new RegexAddFacility();
    DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();
    DataBookingUtil dataBookingUtil = new DataBookingUtil();

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
            String codeService;
            do {
                System.out.println("Nhap ma dich vu theo format (SVVL-YYYY): ");
                codeService = sc.nextLine();
            } while (!regexAddFacility.checkCodeVillaServiceRegex(codeService));
            String nameService;
            do {
                System.out.println("Nhap ten dich vu (Chu cai dau viet hoa):");
                nameService = sc.nextLine();
            } while (!regexAddFacility.checkNameServiceRegex(nameService));
            double usableArea;
            do {
                System.out.println("Nhap dien tich su dung (>= 30 m^2): ");
                usableArea = Double.parseDouble(sc.nextLine());
            } while (usableArea < 30);
            double rentalCosts;
            do {
                System.out.println("Nhap gia muon thue dich vu ( >0 ): ");
                rentalCosts = Double.parseDouble(sc.nextLine());
            } while (rentalCosts <= 0);
            int maximumPeople;
            do {
                System.out.println("Nhap so nguoi su dung dich vu: ");
                maximumPeople = Integer.parseInt(sc.nextLine());
            } while (maximumPeople < 1 || maximumPeople >= 20);
            String rentalType = getRentalType();
            int roomStandard;
            do {
                System.out.println("Nhap tieu chuan phong tu 1 - > 5 sao: ");
                roomStandard = Integer.parseInt(sc.nextLine());
            } while ((roomStandard < 1 || roomStandard > 5));
            double poolArea;
            do {
                System.out.println("Nhap dien tich ho boi (>= 30 m^2): ");
                poolArea = Double.parseDouble(sc.nextLine());
            } while (poolArea < 30);
            int numberOfFloor;
            do {
                System.out.println("Ban muon o tang bao nhieu: ");
                numberOfFloor = Integer.parseInt(sc.nextLine());
            } while (numberOfFloor <= 0);
            villaService = new Villa(codeService, nameService, usableArea, rentalCosts, maximumPeople, rentalType, roomStandard, poolArea, numberOfFloor);
        } catch (NumberFormatException e) {
            System.out.println("Ban nhap sai format !! Moi ban nhap lai ...");
            return getInfoVillaService();
        }
        return villaService;
    }

    public Room getInfoRoomService() {
        Room roomService = null;
        try {
            String codeService;
            do {
                System.out.println("Nhap ma dich vu theo format (SVRO-YYYY): ");
                codeService = sc.nextLine();
            } while (!regexAddFacility.checkCodeRoomServiceRegex(codeService));
            String nameService;
            do {
                System.out.println("Nhap ten dich vu (Chu cai dau viet hoa):");
                nameService = sc.nextLine();
            } while (!regexAddFacility.checkNameServiceRegex(nameService));
            double usableArea;
            do {
                System.out.println("Nhap dien tich su dung (>= 30 m^2): ");
                usableArea = Double.parseDouble(sc.nextLine());
            } while (usableArea < 30);
            double rentalCosts;
            do {
                System.out.println("Nhap gia muon thue dich vu ( >0 ): ");
                rentalCosts = Double.parseDouble(sc.nextLine());
            } while (rentalCosts <= 0);
            int maximumPeople;
            do {
                System.out.println("Nhap so nguoi su dung dich vu: ");
                maximumPeople = Integer.parseInt(sc.nextLine());
            } while (maximumPeople < 1 || maximumPeople >= 20);
            String rentalType = getRentalType();
            String freeService = getFreeService();
            roomService = new Room(codeService, nameService, usableArea, rentalCosts, maximumPeople, rentalType, freeService);
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

    public String getCodeCustomer() {
        String codeCustomerChosen = null;
        boolean flag = false;
        try {
            List<Customer> customerList = new LinkedList<>();
            DataCustomersUtil dataCustomersUtil = new DataCustomersUtil();
            customerList = dataCustomersUtil.readDataFromCustomerFile();
            System.out.println("Danh sach ma khach hang: ");
            for (Customer customer : customerList) {
                System.out.println(customer.getCodeCustomer());
            }
            System.out.println("Moi ban chon ma khach hang: ");
            codeCustomerChosen = sc.nextLine();
            for (Customer customer : customerList) {
                if (codeCustomerChosen.equals(customer.getCodeCustomer())) {
                    flag = true;
                    return codeCustomerChosen;
                }
            }
        } catch (IOException e) {
            System.out.println("Can not get code customer !!!");
        }
        if (!flag) {
            System.out.println("Ban nhap sai format !! Moi ban nhap lai...");
            return getCodeCustomer();
        }
        return codeCustomerChosen;
    }

    public String getCodeService() {
        Map<Room, Integer> dataRoomService = new LinkedHashMap<>();
        Map<Villa, Integer> dataVillaService = new LinkedHashMap<>();
        String codeService = null;
        boolean flag = false;
        try {
            dataVillaService = dataFacilityUtil.readDataVillaFromFile();
            dataRoomService = dataFacilityUtil.readDataRoomFromFile();
            System.out.println("Danh sach ma dich vu: ");
            for (Map.Entry<Room, Integer> entry : dataRoomService.entrySet()) {
                System.out.println(entry.getKey().getCodeService());
            }
            for (Map.Entry<Villa, Integer> entry : dataVillaService.entrySet()) {
                System.out.println(entry.getKey().getCodeService());
            }
            System.out.println("Moi ban chon ma dich vu: ");
            codeService = sc.nextLine();
            for (Map.Entry<Room, Integer> entry : dataRoomService.entrySet()) {
                if (codeService.equals(entry.getKey().getCodeService())) {
                    flag = true;
                    return codeService;
                }
            }
            for (Map.Entry<Villa, Integer> entry : dataVillaService.entrySet()) {
                if (codeService.equals(entry.getKey().getCodeService())) {
                    flag = true;
                    return codeService;
                }
            }
        } catch (IOException e) {
            System.out.println("Can not get data !!");
        }
        if (!flag) {
            return getCodeService();
        }
        return codeService;
    }
    public Stack<Integer> getAmountVoucher(int amountCustomers) {
        Stack<Integer> amountVoucher = new Stack<>();
        System.out.println("Moi ban nhap so luong voucher ( tong = " + amountCustomers + " )" );
        int voucher10Percent;
        int voucher20Percent;
        int voucher50Percent;
        do {
            System.out.println("Nhap so luong voucher 10%: ");
            voucher10Percent = sc.nextInt();
            System.out.println("Nhap so luong voucher 20%:");
            voucher20Percent = sc.nextInt();
            System.out.println("Nhap so luong voucher 50%:");
            voucher50Percent = sc.nextInt();
        } while ((voucher10Percent + voucher20Percent + voucher50Percent) != amountCustomers);
        for (int i = 1; i <= voucher50Percent; i++) {
            amountVoucher.push(50);
        }
        for (int i = 1; i <= voucher20Percent; i++) {
            amountVoucher.push(20);
        }
        for (int i = 1; i <= voucher10Percent; i++) {
            amountVoucher.push(10);
        }
        return amountVoucher;
    }
    public Map<Room, Integer> updateTimeUsedOfRoomService() {
        TreeSet<Booking> bookingTreeSet = dataBookingUtil.readDataBookingFromFile();
        Map<Room, Integer> dataRoomFacility = null;
        try {
            dataRoomFacility = dataFacilityUtil.readDataRoomFromFile();
            for (Map.Entry<Room, Integer> entry: dataRoomFacility.entrySet()) {
                for (Booking booking: bookingTreeSet) {
                    if (entry.getKey().getCodeService().equals(booking.getNameService())) {
                        dataRoomFacility.put(entry.getKey(), entry.getValue() + 1);
                    }
                }
            }
            return dataRoomFacility;
        } catch (IOException e) {
            System.err.println("Can not get data from database !! Try again ...");
        }
        return dataRoomFacility;
    }
    public Map<Villa, Integer> updateTimeUsedOfVillaService() {
        TreeSet<Booking> bookingTreeSet = dataBookingUtil.readDataBookingFromFile();
        Map<Villa, Integer> dataVillaFacility = null;
        try {
            dataVillaFacility = dataFacilityUtil.readDataVillaFromFile();
            for (Map.Entry<Villa, Integer> entry: dataVillaFacility.entrySet()) {
                for (Booking booking: bookingTreeSet) {
                    if (entry.getKey().getCodeService().equals(booking.getNameService())) {
                        dataVillaFacility.put(entry.getKey(), entry.getValue() + 1);
                    }
                }
            }
            return dataVillaFacility;
        } catch (IOException e) {
            System.err.println("Can not get data from database !! Try again ...");
        }
        return dataVillaFacility;
    }
}
