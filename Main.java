import models.Apartment;
import models.Finance;
import models.House;
import models.Lot;
import utils.*;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Finance simulator");
        System.out.println("------------------------------");
        ArrayList<Finance> userList = new ArrayList<>();

        while (true) {
            System.out.println("Finance type:\n Apartment(1) | House(2) | Lot(3)");
            System.out.print("Choose your finance type (0 to quit): ");
            String userInput = scanner.nextLine();

            if (userInput.equals("0")) break;

            double propertyValue = UserInterface.askPropertyValue();
            int financeTime = UserInterface.askFinanceTime();
            double interestRate = UserInterface.askInterestRate();

            Finance finance = null;
            switch (userInput) {
                case "1":
                    int parkingSpaces = ApartmentUserInterface.askParkingSpaces();
                    int floor = ApartmentUserInterface.askFloor();
                    finance = new Apartment(propertyValue,financeTime,interestRate,parkingSpaces,floor);
                    break;
                case "2":
                    double lotSize = HouseUserInterface.askLotSize();
                    double builtSize = HouseUserInterface.askBuiltSize();
                    finance = new House(propertyValue,financeTime,interestRate,builtSize,lotSize);
                    break;
                case "3":
                    String zoneType = LotUserInterface.askZoneType();
                    finance = new Lot(propertyValue,financeTime,interestRate,zoneType);
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            if (finance != null) {
                userList.add(finance);
            }
        }

        //saves user arrayList
        DataStorage.saveSerializedArray(userList);

        //creates a copy by importing serialized data
        ArrayList<Finance> importedList = null;
        importedList = DataStorage.loadSerializedArray();
        
        if (importedList.isEmpty()) {
            System.out.println("Empty list.");
        }

        //saves data into readable text file
        DataStorage.saveFinanceData(importedList);

        //prints the txt file information
        DataStorage.readFinanceData();

        scanner.close();
    }
}
