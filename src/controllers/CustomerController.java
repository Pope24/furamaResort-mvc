package controllers;

import services.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    Scanner sc = new Scanner(System.in);
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    public void displayMenuOfCustomer() {
        int chooseUserFromCase2 = 0;
        do {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            try {
                chooseUserFromCase2 = Integer.parseInt(sc.nextLine());
                switch (chooseUserFromCase2) {
                    case 1:
                        customerService.displayList();
                        System.out.println("Completed !!!");
                        break;
                    case 2:
                        customerService.add();
                        System.out.println("Added !!");
                        break;
                    case 3:
                        customerService.edit();
                        System.out.println("Edited !!");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Khong co muc nay!!! moi ban chon muc khac...");
                        displayMenuOfCustomer();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ky tu ban nhap khong phai la so !! Moi ban nhap lai ...");
                displayMenuOfCustomer();
            }
        } while (chooseUserFromCase2 > 0 && chooseUserFromCase2 < 4);
    }
}
