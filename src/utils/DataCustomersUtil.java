package utils;

import models.Customer;

import java.io.*;
import java.util.List;

public class DataCustomersUtil {

    public void writeDataToCustomerFile(List<Customer> customerList) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\customer.csv"));
            StringBuilder dataString = new StringBuilder();
            for(Customer customer: customerList) {
                dataString.append(customer.toString() + "\n");
            }
            bufferedWriter.write(String.valueOf(dataString));
        } catch (IOException e) {
            System.err.println("Can not write file !! Try again ...");
        } finally {
            bufferedWriter.close();
        }
    }
    public void readDataFromCustomerFile() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\customer.csv"));
            String line;
            while ((line = bufferedReader.readLine())!= null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println("Can not read file !! Try again ...");
        }
    }
}
