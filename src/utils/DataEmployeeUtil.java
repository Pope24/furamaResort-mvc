package utils;

import models.Customer;
import models.Employee;

import java.io.*;
import java.util.List;

public class DataEmployeeUtil {
    BufferedWriter bufferedWriter = null;
    BufferedReader bufferedReader = null;
    public void writeDataEmployeeToFile(List<Employee> employeeList) throws IOException {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\employee.csv"));
            StringBuilder dataString = new StringBuilder();
            for (Employee employee: employeeList) {
                dataString.append(employee + "\n");
            }
            bufferedWriter.write(String.valueOf(dataString));
        }catch(IOException e) {
            System.out.println("Can not write file !!");
        }
        finally {
            bufferedWriter.close();
        }
    }
    public void readDataCustomerFromFile() throws IOException {
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\employee.csv"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Can not read data from file !!!");
        }finally {
            bufferedReader.close();
        }
    }
}
