package utils;

import exceptions.InvalidDeadlineException;
import exceptions.InvalidTaxRateException;
import exceptions.InvalidValueException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);

    public static double askPropertyValue() {
        double propertyValue;

        while (true) {
            try {
                System.out.print("Property value: ");
                propertyValue = scanner.nextDouble();

                if (propertyValue > 99999999) {
                    throw new InvalidValueException("Value too high: "+propertyValue);
                }
                if (propertyValue <= 0) {
                    throw new InvalidValueException("Property value can't be negative: "+propertyValue);
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

        return propertyValue;
    }

    public static int pedirPrazoFinanciamento() {
        int financeTime;

        while (true) {
            try {
                System.out.print("Finance time in years: ");
                financeTime = scanner.nextInt();

                if (financeTime > 25) {
                    throw new InvalidDeadlineException("Time too high: "+financeTime+" years");
                }
                if (financeTime <= 0) {
                    throw new InvalidDeadlineException("Finance time needs to be positive: "+financeTime);
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
                scanner.nextLine();
            } catch (InvalidDeadlineException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return financeTime;
    }

    public static double askInterestRate() {
        double interestRate;

        while (true) {
            try {
                System.out.print("Finance interest rate: ");
                interestRate = scanner.nextDouble();

                if (interestRate > 1000) {
                    throw new InvalidTaxRateException("Interest rate too high: "+interestRate);
                }
                if (interestRate <= 0) {
                    throw new InvalidTaxRateException("Interest rate needs to be positive: "+interestRate);
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
                scanner.nextLine();
            } catch (InvalidTaxRateException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return interestRate;
    }
}
