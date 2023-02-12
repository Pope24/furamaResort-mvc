package services;

import models.Employee;
import services.IEmployeeService;
import utils.DataEmployeeUtil;
import utils.MenuModifier;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static DataEmployeeUtil dataEmployeeUtil = new DataEmployeeUtil();
    static MenuModifier menuModifier = new MenuModifier();

    static {
        employeeList.add(new Employee("Nguyen Hoang Hai", "07/06/1993", "Nam", "2038748290", "09384839383", "haihoangbk@gmail.com", "75H1", "Graduate", "Manager", "10000000"));
        employeeList.add(new Employee("Nguyen Minh Lanh", "01/11/1990", "Nam", "2293874849", "0917364929", "minhlanh@gmail.com", "92C1", "Graduate", "Receptionist", "7500000"));
        employeeList.add(new Employee("Nguyen Van Minh", "12/04/1998", "Nam", "8384594399", "0938783622", "minhnguyenbk@gmail.com", "37N3", "College", "Restaurant specialist", "7000000"));
        employeeList.add(new Employee("Chau To Trinh", "30/07/1996", "Nu", "7387005934", "09848493092", "totrinhchau@gmail.com", "77G2", "College", "Waitress", "5000000"));
        employeeList.add(new Employee("Nguyen Quoc Anh", "06/03/1996", "Nam", "9384458758", "0938293873", "quocanh@gmail.com", "74C1", "University", "Supervisor", "7000000"));
        employeeList.add(new Employee("Le Van Chinh", "24/02/2003", "Nam", "8383688463", "09999999999", "chinhpope@gmail.com", "73H1", "Graduate", "CEO", "90000000"));
        try {
            dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
        } catch (IOException e) {
        }
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void displayList() {
        try {
            dataEmployeeUtil.readDataEmployeeFromFile();
        } catch (IOException e) {

        }
    }

    @Override
    public boolean add() {

        if (employeeList.add(getInfoEmployee())) {
            try {
                dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
            } catch (IOException e) {
            }
            return true;
        }
        return false;
    }

    public boolean delete() throws ClassNotFoundException {
        System.out.println("Nhap ma code cua nhan vien can xoa: ");
        boolean flag = false;
        String codeEmployeeDelete = sc.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCodeEmployee().equals(codeEmployeeDelete)) {
                employeeList.remove(i);
                try {
                    dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
                } catch (IOException e) {
                }
                System.out.println("Deleted");
                flag = true;
            }
        }
        if (!flag) {
            throw new ClassNotFoundException();
        }
        return flag;
    }

    public boolean edit() {
        System.out.println("Nhap ma code cua nhan vien can sua: ");
        String codeEmployeeEdit = sc.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCodeEmployee().equals(codeEmployeeEdit)) {
                chooseAndEditAttributeEmployee(employeeList.get(i));
                try {
                    dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
                } catch (IOException e) {
                }
                return true;
            }
        }
        return false;
    }

    public Employee getInfoEmployee() {
        System.out.println("Nhap ten nhan vien moi: ");
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
        System.out.println("Nhap newCode cua nhan vien: ");
        String code = sc.nextLine();
        System.out.println("Nhap trinh do hoc van: ");
        String academicLevel = menuModifier.getAcademicLevelOfEmployee();
        System.out.println("Nhap vi tri trong cong ty: ");
        String position = menuModifier.getEmployeePosition();
        System.out.println("Nhap luong khoi diem: ");
        String salary = sc.nextLine();
        return new Employee(name, dateOfBirth, gender, citizenIdentification, phoneNumber, email, code, academicLevel, position, salary);
    }
    public void chooseAndEditAttributeEmployee(Employee employee) {
        System.out.println("Lua chon muc can sua:");
        System.out.println("1. Ten nhan vien");
        System.out.println("2. Ngay sinh");
        System.out.println("3. Gioi tinh:");
        System.out.println("4. CCCD ");
        System.out.println("5. So dien thoai");
        System.out.println("6. Email");
        System.out.println("7. NewCode cua nhan vien ");
        System.out.println("8. Trinh do hoc van ");
        System.out.println("9. Vi tri trong cong ty ");
        System.out.println("10. luong khoi diem ");
        try {
            int chooseUser = Integer.parseInt(sc.nextLine());
            switch (chooseUser) {
                case 1:
                    System.out.println("Nhap ten moi:");
                    String name = sc.nextLine();
                    employee.setName(name);
                    break;
                case 2:
                    String dateOfBirth = menuModifier.checkDateOfBirth();
                    employee.setDateOfBirth(dateOfBirth);
                    break;
                case 3:
                    System.out.println("Nhap gioi tinh:");
                    String gender = sc.nextLine();
                    employee.setGender(gender);
                    break;
                case 4:
                    System.out.println("Nhap CCCD: ");
                    String citizenIdentification = sc.nextLine();
                    employee.setCitizenIdentification(citizenIdentification);
                    break;
                case 5:
                    System.out.println("Nhap so dien thoai: ");
                    String phoneNumber = sc.nextLine();
                    employee.setPhoneNumber(phoneNumber);
                    break;
                case 6:
                    System.out.println("Nhap email moi:");
                    String email = sc.nextLine();
                    employee.setEmail(email);
                    break;
                case 7:
                    System.out.println("Nhap newCode cua nhan vien: ");
                    String code = sc.nextLine();
                    employee.setCodeEmployee(code);
                case 8:
                    System.out.println("Nhap trinh do hoc van: ");
                    String academicLevel = menuModifier.getAcademicLevelOfEmployee();
                    employee.setAcademicLevel(academicLevel);
                    break;
                case 9:
                    System.out.println("Nhap vi tri trong cong ty: ");
                    String position = menuModifier.getEmployeePosition();
                    employee.setPosition(position);
                    break;
                case 10:
                    System.out.println("Nhap luong khoi diem: ");
                    String salary = sc.nextLine();
                    employee.setSalary(salary);
                    break;
                default:
                    System.out.println("Khong co muc nay !! Moi nhap lai ...");
                    chooseAndEditAttributeEmployee(employee);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ban da nhap sai format !! Moi nhap lai ...");
            chooseAndEditAttributeEmployee(employee);
        }
    }
}
