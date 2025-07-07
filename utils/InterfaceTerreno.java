package utils;

import exceptions.ValorInvalidoException;
import exceptions.ZonaInexistenteException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceTerreno extends InterfaceUsuario {
    public static String pedirZona() {
        String tipoZona;

        while (true) {
            try {
                System.out.print("Digite a zona do apartamento: ");
                tipoZona = scanner.next();

                if (!tipoZona.equalsIgnoreCase("rural") && !tipoZona.equalsIgnoreCase("urbana")  && !tipoZona.toLowerCase().equalsIgnoreCase("comercial")) {
                    throw new ZonaInexistenteException("Zona inexistente: " + tipoZona+"\n Tipos de zona: Rural, Urbana e Comercial");
                }
                break;
            } catch (ZonaInexistenteException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        Character primeiraLetraGrande = Character.toUpperCase(tipoZona.charAt(0));
        String resto = tipoZona.substring(1);

        return primeiraLetraGrande + resto;
    }
}
