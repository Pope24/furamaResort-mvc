package controllers;

import services.*;

import java.util.Scanner;

public class EmployeeController {
    Scanner sc = new Scanner(System.in);
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    public void displayMenuOfEmployee() {
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
                        return;
                    default:
                        System.out.println("Khong co muc nay!!! moi ban chon muc khac...");
                        displayMenuOfEmployee();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ky tu nay khong phai la so !! Moi ban nhap lai ...");
                displayMenuOfEmployee();
            }
        } while (chooseUserFromCase1 > 0 && chooseUserFromCase1 < 5);
    }

}
