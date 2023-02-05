package services;

import models.Room;
import models.Villa;
import services.IFacilityService;
import utils.DataFacilityUtil;
import utils.MenuModifier;

import java.io.IOException;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    static Map<Villa, Integer> serviceVillaUsed = new LinkedHashMap<>();
    static Map<Room, Integer> serviceRoomUsed = new LinkedHashMap<>();
    static DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();
    static MenuModifier menuModifier = new MenuModifier();

    static {
        serviceVillaUsed.put(new Villa("SVVL-0001", "C1122G1", 100, 9000000, 12, "Thue theo thang", 5, 50, 4), 0);
        serviceVillaUsed.put(new Villa("SVVL-0003", "C0123L1", 65, 6500000, 15, "Thue theo ngay", 2, 60, 2), 5);
        serviceVillaUsed.put(new Villa("SVVL-0005", "A0722I1", 30, 3000000, 18, "Thue theo ngay", 4, 35, 8), 5);
        serviceRoomUsed.put(new Room("SVRO-0001", "C0822G1", 48, 4500000, 18, "Thue theo thang", "Nuoc uong mien phi"), 0);
        serviceRoomUsed.put(new Room("SVRO-0003", "C1022G1", 50, 4700000, 20, "Thue theo ngay", "Xong hoi mien phi"), 5);
        serviceRoomUsed.put(new Room("SVRO-0005", "C0622G1", 65, 6500000, 16, "Thue theo ngay", "Phuc vu com mien phi"), 0);
        try {
            dataFacilityUtil.writeDataVillaToFile(serviceVillaUsed);
            dataFacilityUtil.writeDataRoomToFile(serviceRoomUsed);
        } catch (IOException e) {
        }
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void displayList() throws IOException {
        dataFacilityUtil.readDataRoomFromFile();
        dataFacilityUtil.readDataVillaFromFile();
    }

    @Override
    public boolean add() {
        try {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New Room");
            System.out.println("3. Back to menu");
            int chooseUserServiceType = Integer.parseInt(sc.nextLine());
            switch (chooseUserServiceType) {
                case 1:
                    serviceVillaUsed.put(menuModifier.getInfoVillaService(), 0);
                    dataFacilityUtil.writeDataVillaToFile(serviceVillaUsed);
                    break;
                case 2:
                    serviceRoomUsed.put(menuModifier.getInfoRoomService(), 0);
                    dataFacilityUtil.writeDataRoomToFile(serviceRoomUsed);
                    break;
                case 3:
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
        } catch (IOException e) {
        }
        return true;
    }

    public void displayListFacilityMaintenance() {
        for (Map.Entry<Room, Integer> entry : serviceRoomUsed.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println("Room: " + entry.getKey().getNameService());
            }
        }
        for (Map.Entry<Villa, Integer> entry : serviceVillaUsed.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println("Villa: " + entry.getKey().getNameService());
            }
        }
    }
}
