package controllers;

import models.Employee;
import models.Facility;
import models.Villa;
import services.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static com.sun.javafx.geom.Curve.next;

public class FuramaController {
    Scanner sc = new Scanner(System.in);
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    PromotionServiceImpl promotionService = new PromotionServiceImpl();

    public void subMenu(int chooseUser) {
        switch (chooseUser) {
            case 1:
                int chooseUserFromCase1 = 0;
                do {
                    System.out.println("1. Display list employees");
                    System.out.println("2. Add new employee");
                    System.out.println("3. Delete employee");
                    System.out.println("4. Edit employee");
                    System.out.println("5. Return main menu");
                    System.out.println("Nhap lua chon cua ban: ");
                    try {
                        chooseUserFromCase1 = Integer.parseInt(sc.nextLine());
                        switch (chooseUserFromCase1) {
                            case 1:
                                employeeService.displayList();
                                System.out.println("Completed !!");
                                break;
                            case 2:
                                employeeService.add();
                                System.out.println("Added !!");
                                break;
                            case 3:
                                try {
                                    employeeService.delete();
                                } catch (ClassNotFoundException e) {
                                    System.err.println("Khong the tim thay nhan vien !!");
                                }
                                break;
                            case 4:
                                employeeService.edit();
                                System.out.println("Edited !!");
                                break;
                            case 5:
                                displayMainMenu();
                                break;
                            default:
                                System.out.println("Khong co muc nay!!! moi ban chon muc khac...");
                                subMenu(chooseUser);
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ky tu nay khong phai la so !! Moi ban nhap lai ...");
                        subMenu(chooseUser);
                    }
                } while (chooseUserFromCase1 > 0 && chooseUserFromCase1 < 5);
                break;
            case 2:
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
                                displayMainMenu();
                                break;
                            default:
                                System.out.println("Khong co muc nay!!! moi ban chon muc khac...");
                                subMenu(chooseUser);
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ky tu ban nhap khong phai la so !! Moi ban nhap lai ...");
                        subMenu(chooseUser);
                    }
                } while (chooseUserFromCase2 > 0 && chooseUserFromCase2 < 4);
                break;
            case 3:
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
                                displayMainMenu();
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ky tu ban nhap khong phai la so !! Moi ban nhap lai ...");
                        subMenu(chooseUser);
                    } catch (IOException e) {
                    }
                } while (chooseUserFromCase3 > 0 && chooseUserFromCase3 < 4);
                break;
            case 4:
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
                                displayMainMenu();
                                break;
                            default:
                                System.out.println("Khong co muc nay !! Moi ban chon lai ...");
                                subMenu(chooseUser);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ban nhap sai format !! Moi ban chon lai ...");
                        subMenu(chooseUser);
                    }
                } while (chooseUserFromCase4 > 0 && chooseUserFromCase4 < 3);
                break;
            case 5:
                int chooseUserFromCase5 = 0;
                do {
                    System.out.println("1. Display list customers use service");
                    System.out.println("2. Display list customers get voucher");
                    System.out.println("3. Return main menu");
                    chooseUserFromCase5 = Integer.parseInt(sc.nextLine());
                    switch (chooseUserFromCase5) {
                        case 1:
                            promotionService.displayCustomerListUsedService();
                            break;
                        case 2:
                            promotionService.displayCustomerReceiveVoucher();
                            break;
                        case 3:
                            displayMainMenu();
                            break;
                    }
                } while (chooseUserFromCase5 > 0 && chooseUserFromCase5 < 3);
                break;
        }
    }

    public void displayMainMenu() throws NumberFormatException {
        int chooseUser;
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
    }
}
