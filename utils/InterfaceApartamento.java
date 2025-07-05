package utils;

import exceptions.ValorInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceApartamento extends InterfaceUsuario{
    public static int pedirNumVagas() {
        int numVagas;

        while (true) {
            try {
                System.out.print("Digite o número de vagas no apartamento: ");
                numVagas = scanner.nextInt();

                if (numVagas > 20) {
                    throw new ValorInvalidoException("Valor muito alto: " + numVagas);
                }
                if (numVagas < 0) {
                    throw new ValorInvalidoException("Número de vagas não pode ser negativo: " + numVagas);
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

        return numVagas;
    }

    public static int pedirAndar() {
        int andar;

        while (true) {
            try {
                System.out.print("Digite o andar do apartamento: ");
                andar = scanner.nextInt();

                if (andar > 80) {
                    throw new ValorInvalidoException("Valor muito alto: " + andar);
                }
                if (andar <= 0) {
                    throw new ValorInvalidoException("Número do andar deve ser positivo: " + andar);
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

        return andar;
    }
}
