package services;

import models.Customer;
import models.Employee;
import services.ICustomerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    static List<Customer> customerList = new LinkedList<>();

    static {
        customerList.add(new Customer("Tran Van Y", LocalDate.of(1998, 01, 23), "Nam", "9384757929", "0927463782", "vany@gmail.com", "92C3", "Silver", "Quang Nam"));
        customerList.add(new Customer("Nguyen Thi Hong", LocalDate.of(2003, 10, 12), "Nu", "8938748993", "0927839094", "hognnguye@gmail.com", "73V1", "Diamond", "Quang Binh"));
        customerList.add(new Customer("Doan Thanh Hai", LocalDate.of(1999, 12, 01), "Nam", "8372673949", "0372937489", "thanhhai@gmail.com", "43G2", "Member", "Da Nang"));
        customerList.add(new Customer("Ho Thi Nuong", LocalDate.of(2002, 01, 30), "Nu", "9284749293", "09157283987", "thinuong@gmail.com", "77C2", "Gold", "Binh Dinh"));
        customerList.add(new Customer("Tran Thi Ngoc Lan", LocalDate.of(2004, 07, 05), "Nu", "0028492847", "09306526765", "ngocnan@gmail.com", "73H1", "Diamond", "Quang Binh"));
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void displayList() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i));
        }
    }

    @Override
    public boolean add() {
        customerList.add(getInfoCustomer());
        return true;
    }

    public boolean edit() {
        System.out.println("Nhap ma code cua khach hang can sua: ");
        String codeCustomerEdit = sc.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCodeCustomer().equals(codeCustomerEdit)) {
                Customer customerEdited = getInfoCustomer();
                customerList.set(i, customerEdited);
                return true;
            }
        }
        return false;
    }

    public Customer getInfoCustomer() {
        System.out.println("Nhap ten khach hang moi: ");
        String name = sc.nextLine();
        System.out.println("Nhap ngay sinh them format (dd/mm/yy): ");
        String dateString = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateString, formatter);
        System.out.println("Nhap gioi tinh:");
        String gender = sc.nextLine();
        System.out.println("Nhap CCCD: ");
        String citizenIdentification = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhap email:");
        String email = sc.nextLine();
        System.out.println("Nhap newCode cua khach hang: ");
        String codeCustomer = sc.nextLine();
        System.out.println("Nhap loai khach hang: ");
        String customerType = sc.nextLine();
        System.out.println("Nhap dia chi khach hang: ");
        String address = sc.nextLine();
        return new Customer(name, dateOfBirth, gender, citizenIdentification, phoneNumber, email, codeCustomer, customerType, address);
    }
}
