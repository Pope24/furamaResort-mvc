package utils;

import models.Customer;
import models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataEmployeeUtil {
    BufferedWriter bufferedWriter = null;
    BufferedReader bufferedReader = null;

    public void writeDataEmployeeToFile(List<Employee> employeeList) throws IOException {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\employee.csv"));
            StringBuilder dataString = new StringBuilder();
            for (Employee employee : employeeList) {
                dataString.append(employee);
                dataString.append("\n");
            }
            bufferedWriter.write(String.valueOf(dataString));
        } catch (IOException e) {
            System.err.println("Can not write to file !!!");
        } finally {
            bufferedWriter.close();
        }
    }

    public void readDataEmployeeFromFile() throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\employee.csv"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] employee = line.split(", ");
                employeeList.add(new Employee(employee[0], employee[1], employee[2], employee[3], employee[4], employee[5], employee[6], employee[7], employee[8], employee[9]));
            }
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can not find file !!!");
        } catch (IOException e) {
            System.err.println("Can not read data from file !!!");
        } finally {
            bufferedReader.close();
        }
    }
}
