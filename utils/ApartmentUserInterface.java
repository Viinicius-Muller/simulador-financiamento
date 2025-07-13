package utils;

import exceptions.InvalidValueException;

import java.util.InputMismatchException;

public class ApartmentUserInterface extends UserInterface {
    public static int askParkingSpaces() {
        int parkingSpaces;

        while (true) {
            try {
                System.out.print("How many parking spaces: ");
                parkingSpaces = scanner.nextInt();

                if (parkingSpaces > 20) {
                    throw new InvalidValueException("Value too high: " + parkingSpaces);
                }
                if (parkingSpaces < 0) {
                    throw new InvalidValueException("Parking spaces value can't be negative: " + parkingSpaces);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
                scanner.nextLine();
            } catch (InvalidValueException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return parkingSpaces;
    }

    public static int askFloors() {
        int floor;

        while (true) {
            try {
                System.out.print("Appartment floor: ");
                floor = scanner.nextInt();

                if (floor > 99) {
                    throw new InvalidValueException("Value too high: " + floor);
                }
                if (floor <= 0) {
                    throw new InvalidValueException("Floor value needs to be positive: " + floor);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
                scanner.nextLine();
            } catch (InvalidValueException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return floor;
    }
}
