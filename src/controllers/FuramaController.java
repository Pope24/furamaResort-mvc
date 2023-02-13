package controllers;

import models.Employee;
import models.Facility;
import models.Villa;
import services.*;

import java.awt.print.Book;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static com.sun.javafx.geom.Curve.next;

public class FuramaController {
    Scanner sc = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();
    CustomerController customerController = new CustomerController();
    FacilityController facilityController = new FacilityController();
    BookingController bookingController = new BookingController();
    PromotionController promotionController = new PromotionController();

    public void subMenu(int chooseUser) {
        switch (chooseUser) {
            case 1:
                employeeController.displayMenuOfEmployee();
                break;
            case 2:
                customerController.displayMenuOfCustomer();
                break;
            case 3:
                facilityController.displayMenuOfFacility();
                break;
            case 4:
                bookingController.displayMenuOfBooking();
                break;
            case 5:
                promotionController.displayMenuOfPromotion();
                break;
        }
    }

    public void displayMainMenu() throws NumberFormatException {
        int chooseUser = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Employee Management.");
            System.out.println("2. Customer Management.");
            System.out.println("3. Facility Management.");
            System.out.println("4. Booking Management.");
            System.out.println("5. Promotion Management.");
            System.out.println("6. Exit.");
            try {
                chooseUser = Integer.parseInt(sc.nextLine());
                switch (chooseUser) {
                    case 1:
                        subMenu(1);
                        break;
                    case 2:
                        subMenu(2);
                        break;
                    case 3:
                        subMenu(3);
                        break;
                    case 4:
                        subMenu(4);
                        break;
                    case 5:
                        subMenu(5);
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Khong co muc nay !! Xin moi ban nhap lai...");
                        displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ky tu ban nhap khong phai la so.");
                displayMainMenu();
            }
        } while (chooseUser > 0 && chooseUser < 6);
    }
}
