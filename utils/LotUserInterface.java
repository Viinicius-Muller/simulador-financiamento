package utils;

import exceptions.InvalidZoneException;

public class LotUserInterface extends UserInterface {
    public static String askZoneType() {
        String zoneType;

        while (true) {
            try {
                System.out.print("Type of land zone: ");
                zoneType = scanner.next();

                if (!zoneType.equalsIgnoreCase("residential") && !zoneType.equalsIgnoreCase("commercial")  && !zoneType.toLowerCase().equalsIgnoreCase("industrial")) {
                    throw new InvalidZoneException("Invalid zone: " + zoneType+"\n Tipos of zones: Residential, Commercial or Industrial");
                }
                break;
            } catch (InvalidZoneException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        Character firstLetterUpper = Character.toUpperCase(zoneType.charAt(0));
        String rest = zoneType.substring(1);

        return firstLetterUpper + rest;
    }
}
