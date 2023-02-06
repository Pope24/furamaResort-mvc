package utils;

import models.Booking;

import java.io.*;
import java.time.LocalDate;
import java.util.TreeSet;

public class DataBookingUtil {
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    public TreeSet<Booking> readDataBookingFromFile() {
        TreeSet<Booking> bookingTreeSet = new TreeSet<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\booking.csv"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");
                bookingTreeSet.add(new Booking(data[0], LocalDate.parse(data[1]),LocalDate.parse(data[2]),data[3],data[4]));
            }
            return bookingTreeSet;
        } catch (FileNotFoundException e) {
            System.out.println("Can not get data from file !! Try again ...");
        } catch (IOException e) {
            System.err.println("We are having some problem !! We hope you waiting a minute...");
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("We are having some problem !! We hope you waiting a minute...");
            }
        }
        return bookingTreeSet;
    }
    public void writeDataBookingToFile(TreeSet<Booking> bookingTreeSet) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\booking.csv"));
            StringBuilder dataString = new StringBuilder();
            for (Booking booking: bookingTreeSet) {
                dataString.append(booking);
                dataString.append("\n");
            }
            bufferedWriter.write(String.valueOf(dataString));
        } catch (IOException e) {
            System.out.println("Can not write to file !!!");
        }
        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.err.println("We are having some problem !! We hope you waiting a minute...");
            }
        }
    }
}
