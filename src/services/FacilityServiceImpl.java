package services;

import services.IFacilityService;
import utils.DataFacilityUtil;

import java.io.IOException;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    static Map<String, Integer> serviceUsed = new LinkedHashMap<>();
    static DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();

    static {
        serviceUsed.put("Rental villa service", 0);
        serviceUsed.put("Rental room service", 0);
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void displayList() {
        dataFacilityUtil.readDataRoomFromFile();
    }

    @Override
    public boolean add() {
        try {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New Room");
            System.out.println("3. Back to menu");
            int chooseUserServiceType = sc.nextInt();
            switch (chooseUserServiceType) {
                case 1:
                    if (serviceUsed.get("Rental villa service") >= 5) {
                        System.err.println("This service need to maintain !!!");
                        System.out.println("Moi ban nhap lai: ");
                    } else {
                        serviceUsed.put("Rental villa service", serviceUsed.get("Rental villa service") + 1);
                        System.out.println("Added 1 more rental villa service!!");
                    }
                    break;
                case 2:
                    if (serviceUsed.get("Rental room service") >= 5) {
                        System.err.println("This service need to maintain !!!");
                        System.out.println("Moi ban nhap lai: ");
                    } else {
                        serviceUsed.put("Rental room service", serviceUsed.get("Rental room service") + 1);
                        System.out.println("Add 1 more rental room service");
                    }
                    break;
                default:
                    System.out.println("Khong co muc nay !! Moi chon lai ...");
                    add();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ban nhap sai lua chon trong menu !! Moi ban nhap lai ...");
            add();
        } catch (InputMismatchException e) {
            System.out.println("Ban nhap sai lua chon trong menu !! Moi ban nhap lai ...");
            add();
        }
        return true;
    }

    public void displayListFacilityMaintenance() {

    }
}
