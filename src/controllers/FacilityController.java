package controllers;

import services.FacilityServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class FacilityController {
    Scanner sc = new Scanner(System.in);
    FacilityServiceImpl facilityService = new FacilityServiceImpl();

    public void displayMenuOfFacility() {
        int chooseUserFromCase3 = 0;
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            try {
                chooseUserFromCase3 = Integer.parseInt(sc.nextLine());
                switch (chooseUserFromCase3) {
                    case 1:
                        facilityService.displayList();
                        System.out.println("Completed !!");
                        break;
                    case 2:
                        facilityService.add();
                        System.out.println("Added !!");
                        break;
                    case 3:
                        facilityService.displayListFacilityMaintenance();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Khong co muc nay!!! moi ban chon muc khac...");
                        displayMenuOfFacility();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ky tu ban nhap khong phai la so !! Moi ban nhap lai ...");
                displayMenuOfFacility();
            } catch (IOException e) {
            }
        } while (chooseUserFromCase3 > 0 && chooseUserFromCase3 < 4);
    }
}
