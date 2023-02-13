package controllers;

import services.BookingServiceImpl;

import java.util.Scanner;

public class BookingController {
    Scanner sc = new Scanner(System.in);
    BookingServiceImpl bookingService = new BookingServiceImpl();

    public void displayMenuOfBooking() {
        int chooseUserFromCase4 = 0;
        do {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Return main menu");
            try {
                chooseUserFromCase4 = Integer.parseInt(sc.nextLine());
                switch (chooseUserFromCase4) {
                    case 1:
                        bookingService.add();
                        break;
                    case 2:
                        bookingService.displayList();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Khong co muc nay !! Moi ban chon lai ...");
                        displayMenuOfBooking();
                }
            } catch (NumberFormatException e) {
                System.out.println("Ban nhap sai format !! Moi ban chon lai ...");
                displayMenuOfBooking();
            }
        } while (chooseUserFromCase4 > 0 && chooseUserFromCase4 < 3);
    }
}
