package utils;

import exceptions.ValorInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceCasa extends InterfaceUsuario {
    public static double pedirTamanhoTerreno() {
        double tamanhoTerreno;

        while (true) {
            try {
                System.out.print("Digite o tamanho do terreno em metros quadrados: ");
                tamanhoTerreno = scanner.nextDouble();

                if (tamanhoTerreno > 80000) {
                    throw new ValorInvalidoException("Valor muito alto: " + tamanhoTerreno);
                }
                if (tamanhoTerreno <= 25) {
                    throw new ValorInvalidoException("Valor do imóvel deve ser maior: " + tamanhoTerreno);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return tamanhoTerreno;
    }

    public static double pedirTamanhoConstruido() {
        double tamanhoConstruido;

        while (true) {
            try {
                System.out.print("Digite o tamanho construído no terreno em metros quadrados: ");
                tamanhoConstruido = scanner.nextDouble();

                if (tamanhoConstruido > 79000) {
                    throw new ValorInvalidoException("Valor muito alto: " + tamanhoConstruido);
                }
                if (tamanhoConstruido <= 15) {
                    throw new ValorInvalidoException("Valor do imóvel deve ser maior: " + tamanhoConstruido);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return tamanhoConstruido;
    }
}
