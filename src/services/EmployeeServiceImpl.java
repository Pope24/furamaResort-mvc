package services;

import models.Employee;
import services.IEmployeeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    Scanner sc = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("Nguyen Hoang Hai", LocalDate.of(1993, 06, 07), "Nam", 203874829, "09384839383", "haihoangbk@gmail.com", "75H1", "university", "Manager", 10000000));
        employeeList.add(new Employee("Nguyen Minh Lanh", LocalDate.of(1990, 11, 01), "Nam", 229384849, "0917364929", "minhlanh@gmail.com", "92C1", "university", "Receptionist", 7500000));
        employeeList.add(new Employee("Nguyen Van Minh", LocalDate.of(1998, 04, 12), "Nam", 83849439, "0938783622", "minhnguyenbk@gmail.com", "37N3", "university", "Maid", 7000000));
        employeeList.add(new Employee("Chau To Trinh", LocalDate.of(1996, 07, 30), "Nu", 73875934, "09848493092", "totrinhchau@gmail.com", "77G2", "university", "Waitress", 5000000));
        employeeList.add(new Employee("Nguyen Quoc Anh", LocalDate.of(2001, 03, 06), "Nam", 93848758, "0938293873", "quocanh@gmail.com", "74C1", "university", "Maid", 7000000));
        employeeList.add(new Employee("Le Van Chinh", LocalDate.of(2003, 02, 24), "Nam", 83838463, "09999999999", "chinhpope@gmail.com", "73H1", "university", "CEO", 90000000));
    }

    @Override
    public void displayList() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i).toString());
        }
    }

    @Override
    public boolean add() {

        if (employeeList.add(getInfoEmployee())) {
            return true;
        }
        return false;
    }
    public boolean delete() {
        System.out.println("Nhap ma code cua nhan vien can xoa: ");
        String codeEmployeeDelete = sc.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCodeEmployee().equals(codeEmployeeDelete)) {
                employeeList.remove(i);
                System.out.println("Deleted");
                return true;
            }
        }
        return false;
    }
    public boolean edit() {
        System.out.println("Nhap ma code cua nhan vien can sua: ");
        String codeEmployeeEdit = sc.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCodeEmployee().equals(codeEmployeeEdit)) {
                Employee newEmployee = getInfoEmployee();
                employeeList.set(i, newEmployee);
                return true;
            }
        }
        return false;
    }
    public Employee getInfoEmployee() {
        System.out.println("Nhap ten nhan vien moi: ");
        String name = sc.nextLine();
        System.out.println("Nhap ngay sinh them format (dd/mm/yy): ");
        String dateString = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateString, formatter);
        System.out.println("Nhap gioi tinh:");
        String gender = sc.nextLine();
        System.out.println("Nhap CCCD: ");
        long citizenIdentification = Long.parseLong(sc.nextLine());
        System.out.println("Nhap so dien thoai: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhap email:");
        String email = sc.nextLine();
        System.out.println("Nhap newCode cua nhan vien: ");
        String code = sc.nextLine();
        System.out.println("Nhap trinh do hoc van: ");
        String academicLevel = sc.nextLine();
        System.out.println("Nhap vi tri trong cong ty: ");
        String position = sc.nextLine();
        System.out.println("Nhap luong khoi diem: ");
        long salary = Long.parseLong(sc.nextLine());
        return new Employee(name, dateOfBirth, gender, citizenIdentification, phoneNumber, email, code, academicLevel, position, salary);
    }
}
