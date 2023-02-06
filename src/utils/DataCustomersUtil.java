package utils;

import models.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataCustomersUtil {

    public void writeDataToCustomerFile(List<Customer> customerList) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\customer.csv"));
            StringBuilder dataString = new StringBuilder();
            for (Customer customer: customerList) {
                dataString.append(customer);
                dataString.append("\n");
            }
            bufferedWriter.write(String.valueOf(dataString));
        } catch(IOException e) {
            System.err.println("Can not write to file !!!");
        } finally {
            bufferedWriter.close();
        }
    }
    public List<Customer> readDataFromCustomerFile() throws IOException{
        BufferedReader bufferedReader = null;
        List<Customer> customerList = new LinkedList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\customer.csv"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] customer = line.split(", ");
                customerList.add(new Customer(customer[0],customer[1],customer[2],customer[3],customer[4],customer[5],customer[6],customer[7],customer[8]));
            }
            return customerList;
        } catch (FileNotFoundException e) {
            System.err.println("Can not find file !!!");
        } catch (IOException e) {
            System.err.println("Can not read data from file !!!");
        } finally {
            bufferedReader.close();
            return customerList;
        }
    }
}
