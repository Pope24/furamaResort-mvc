package services;

import models.Customer;
import utils.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    static List<Customer> customerList = new LinkedList<>();
    static DataCustomersUtil dataCustomersUtil = new DataCustomersUtil();
    static DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();
    static MenuModifier menuModifier = new MenuModifier();
    static RegexAddFacility regex = new RegexAddFacility();

    static {
        customerList.add(new Customer("Tran Van Y", "23/01/1998", "Nam", "9384757929", "0927463782", "vany@gmail.com", "92C3", "Silver", "Quang Nam"));
        customerList.add(new Customer("Nguyen Thi Hong", "12/10/2003", "Nu", "8938748993", "0927839094", "hognnguye@gmail.com", "73V1", "Diamond", "Quang Binh"));
        customerList.add(new Customer("Doan Thanh Hai", "01/12/2000", "Nam", "8372673949", "0372937489", "thanhhai@gmail.com", "43G2", "Member", "Da Nang"));
        customerList.add(new Customer("Ho Thi Nuong", "30/01/2002", "Nu", "9284749293", "09157283987", "thinuong@gmail.com", "77C2", "Gold", "Binh Dinh"));
        customerList.add(new Customer("Tran Thi Ngoc Lan", "05/07/2004", "Nu", "0028492847", "09306526765", "ngocnan@gmail.com", "73H1", "Diamond", "Quang Binh"));
        try {
            dataCustomersUtil.writeDataToCustomerFile(customerList);
        } catch (IOException e) {

        }
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void displayList() {
        try {
            List<Customer> customerList = dataCustomersUtil.readDataFromCustomerFile();
            for (Customer customer: customerList) {
                System.out.println(customer);
            }
        } catch (IOException e) {
        }
    }

    @Override
    public boolean add() {
        customerList.add(getInfoCustomer());
        try {
            dataCustomersUtil.writeDataToCustomerFile(customerList);
        } catch (IOException e) {

        }
        return true;
    }

    public boolean edit() {
        System.out.println("Nhap ma code cua khach hang can sua: ");
        String codeCustomerEdit = sc.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCodeCustomer().equals(codeCustomerEdit)) {
                Customer customerEdited = getInfoCustomer();
                customerList.set(i, customerEdited);
                try {
                    dataCustomersUtil.writeDataToCustomerFile(customerList);
                } catch (IOException e) {

                }
                return true;
            }
        }
        return false;
    }

    public Customer getInfoCustomer() {
        System.out.println("Nhap ten khach hang moi: ");
        String name = sc.nextLine();
        String dateOfBirth = menuModifier.checkDateOfBirth();
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
        String customerType = menuModifier.getCustomerType();
        System.out.println("Nhap dia chi khach hang: ");
        String address = sc.nextLine();
        return new Customer(name, dateOfBirth, gender, citizenIdentification, phoneNumber, email, codeCustomer, customerType, address);
    }
}
