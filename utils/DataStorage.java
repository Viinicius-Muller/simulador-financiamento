package utils;

import exceptions.EmptyFinanceList;
import models.Finance;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataStorage {
    static Path dataPath = Paths.get("financeData.txt"); //arquivo com os dados em texto
    static Path serArrayData = Paths.get("finances.ser"); //arquivo com objetos serializados

    //saves arrayList into a .ser file
    public static void saveSerializedArray(ArrayList<Finance> finList) {
        try (FileOutputStream fileOut = new FileOutputStream(serArrayData.toFile()); //create finances.ser
             ObjectOutputStream ous = new ObjectOutputStream(fileOut)) {
            ous.writeObject(finList); //saves serialized objects into .ser
            ous.flush(); //cleans writing data
        } catch (Exception e) {
            System.out.println("Failed to save array file: "+e.getMessage());
        }
    }

    //loads .ser file into an arrayList
    public static ArrayList<Finance> loadSerializedArray() {
        try (FileInputStream fileIn = new FileInputStream(serArrayData.toFile());
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            return (ArrayList<Finance>) in.readObject();
        } catch (Exception e) {
            System.out.println("Failed to load array file: "+e.getMessage());
            return null; //if wrong, returns null
        }
    }

    //saves all data into .txt
    public static void saveFinanceData(ArrayList<Finance> finList) throws IOException {
        try ( FileWriter fw = new FileWriter(dataPath.toFile())) {
            if (finList == null) throw new EmptyFinanceList("The finance list is empty");

            for (Finance fin : finList) {
                fw.write(fin.toString()+"\n");
            }

            fw.flush();
        } catch (EmptyFinanceList e) {
            System.out.println("Error: "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed to save data: "+e.getMessage());
        }

    }

    //reads .txt data
    public static void readFinanceData() throws FileNotFoundException {
        try (BufferedReader fr = new BufferedReader(new FileReader(dataPath.toFile()))) { //try-with-resource
            String line;

            while ((line = fr.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException  e) {
            System.out.println("Failed to read data: "+e.getMessage());
        }
    }
}
