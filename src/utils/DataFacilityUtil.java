package utils;

import java.io.*;
import java.util.Map;

public class DataFacilityUtil {
    BufferedWriter bufferedWriterRoom = null;
    BufferedReader bufferedReaderRoom = null;
    public void writeDataRoomToFile(String key, int value) {
        try {
            bufferedWriterRoom = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\room.csv"));
            bufferedWriterRoom.write(key +", " + value);
        } catch (IOException e) {
            System.err.println("Can not write file !!!");
        }
    }
    public void readDataRoomFromFile() {
        try {
            bufferedReaderRoom = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\room.csv"));
            System.out.println(bufferedReaderRoom.read());
        } catch (IOException e) {
            System.err.println("Can not read file !!");
        }
    }
}
