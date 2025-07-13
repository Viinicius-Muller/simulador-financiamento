package utils;

import exceptions.InvalidValueException;

import java.util.InputMismatchException;

public class HouseUserInterface extends UserInterface {
    public static double askLotSize() {
        double lotSize;

        while (true) {
            try {
                System.out.print("Lot size in square meters: ");
                lotSize = scanner.nextDouble();

                if (lotSize > 80000) {
                    throw new InvalidValueException("Value too high: " + lotSize);
                }
                if (lotSize <= 25) {
                    throw new InvalidValueException("Value too little: " + lotSize);
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

        return lotSize;
    }

    public static double askBuiltSize() {
        double builtSize;

        while (true) {
            try {
                System.out.print("Built size in square meters: ");
                builtSize = scanner.nextDouble();

                if (builtSize > 79000) {
                    throw new InvalidValueException("Value too high: " + builtSize);
                }
                if (builtSize <= 15) {
                    throw new InvalidValueException("Value too little: " + builtSize);
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

        return builtSize;
    }
}
