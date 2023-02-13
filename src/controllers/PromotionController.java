package controllers;

import services.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    Scanner sc = new Scanner(System.in);
    PromotionServiceImpl promotionService = new PromotionServiceImpl();

    public void displayMenuOfPromotion() {
        int chooseUserFromCase5 = 0;
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            try {
                chooseUserFromCase5 = Integer.parseInt(sc.nextLine());
                switch (chooseUserFromCase5) {
                    case 1:
                        promotionService.displayCustomerListUsedService();
                        break;
                    case 2:
                        promotionService.displayCustomerReceiveVoucher();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Khong co muc nay !! Moi ban chon lai ...");
                        displayMenuOfPromotion();
                }
            } catch (NumberFormatException e) {
                System.out.println("Ban nhap sai format !! Moi ban chon lai ...");
                displayMenuOfPromotion();
            }
        } while (chooseUserFromCase5 > 0 && chooseUserFromCase5 < 3);
    }
}
