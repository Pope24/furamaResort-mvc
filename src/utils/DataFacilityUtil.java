package utils;

import models.Room;
import models.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataFacilityUtil {
    BufferedWriter bufferedWriterRoom = null;
    BufferedReader bufferedReaderRoom = null;
    BufferedReader bufferedReaderVilla = null;
    BufferedWriter bufferedWriterVilla = null;

    public void writeDataRoomToFile(Map<Room, Integer> dataRoomService) throws IOException {
        try {
            bufferedWriterRoom = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\room.csv"));
            StringBuilder dataString = new StringBuilder();
            for (Room room : dataRoomService.keySet()) {
                dataString.append(room);
                dataString.append(", " + dataRoomService.get(room) + "\n");
            }
            bufferedWriterRoom.write(String.valueOf(dataString));
        } catch (IOException e) {
            System.out.println("Can not write to file !! Try again...");
        } finally {
            bufferedWriterRoom.close();
        }
    }

    public Map<Room, Integer> readDataRoomFromFile() throws IOException {
        Map<Room, Integer> dataRoomService = new LinkedHashMap<Room, Integer>();
        try {
            bufferedReaderRoom = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\room.csv"));
            String line;
            while ((line = bufferedReaderRoom.readLine()) != null) {
                String[] data = line.split(", ");
                dataRoomService.put(new Room(
                        data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5], data[6]), Integer.parseInt(data[7]));
            }
            return dataRoomService;
        } catch (IOException e) {
            System.out.println("Can not read data from file");
        } finally {
            bufferedReaderRoom.close();
        }
        return dataRoomService;
    }

    public void writeDataVillaToFile(Map<Villa, Integer> dataVillaService) throws IOException {
        try {
            bufferedWriterVilla = new BufferedWriter(new FileWriter("C:\\CodeGym\\FuramaResort\\src\\data\\villa.csv"));
            StringBuilder dataString = new StringBuilder();
            for (Villa villa : dataVillaService.keySet()) {
                dataString.append(villa);
                dataString.append(", " + dataVillaService.get(villa) + "\n");
            }
            bufferedWriterVilla.write(String.valueOf(dataString));
        } catch (IOException e) {
            System.out.println("Can not write to file !! Try again...");
        } finally {
            bufferedWriterVilla.close();
        }
    }

    public Map<Villa, Integer> readDataVillaFromFile() throws IOException {
        Map<Villa, Integer> dataVillaService = new LinkedHashMap<Villa, Integer>();
        try {
            bufferedReaderVilla = new BufferedReader(new FileReader("C:\\CodeGym\\FuramaResort\\src\\data\\villa.csv"));
            String line;
            while ((line = bufferedReaderVilla.readLine()) != null) {
                String[] data = line.split(", ");
                dataVillaService.put(new Villa(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5], Integer.parseInt(data[6]), Double.parseDouble(data[7]), Integer.parseInt(data[8])), Integer.parseInt(data[9]));
            }
            return dataVillaService;
        } catch (IOException e) {
            System.out.println("Can not read data from file");
        } finally {
            bufferedReaderVilla.close();
        }
        return dataVillaService;
    }
}
