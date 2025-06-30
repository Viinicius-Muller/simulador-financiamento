package utils;

import exceptions.PrazoInvalidoException;
import exceptions.TaxaInvalidaException;
import exceptions.ValorInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    public static Scanner scanner = new Scanner(System.in);

    public static double pedirValorImovel() {
        double valorImovel;

        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorImovel = scanner.nextDouble();

                if (valorImovel > 99999999) {
                    throw new ValorInvalidoException("Valor muito alto: "+valorImovel);
                }
                if (valorImovel <= 0) {
                    throw new ValorInvalidoException("Valor do imóvel deve ser positivo: "+valorImovel);
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

        return valorImovel;
    }

    public static int pedirPrazoFinanciamento() {
        int prazoFinanciamento;

        while (true) {
            try {
                System.out.print("Digite o prazo de financiamento em anos: ");
                prazoFinanciamento = scanner.nextInt();

                if (prazoFinanciamento > 25) {
                    throw new PrazoInvalidoException("Prazo muito alto: "+prazoFinanciamento+" anos");
                }
                if (prazoFinanciamento <= 0) {
                    throw new PrazoInvalidoException("Prazo deve ser positivo: "+prazoFinanciamento);
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
            } catch (PrazoInvalidoException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return prazoFinanciamento;
    }

    public static double pedirTaxaJuros() {
        double taxaDeJuros;

        while (true) {
            try {
                System.out.print("Digite a taxa de juros do financiamento: ");
                taxaDeJuros = scanner.nextDouble();

                if (taxaDeJuros > 1000) {
                    throw new TaxaInvalidaException("Porcentagem de juros muito alta: "+taxaDeJuros);
                }
                if (taxaDeJuros <= 0) {
                    throw new TaxaInvalidaException("Porcentagem de juros deve ser positiva: "+taxaDeJuros);
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
            } catch (TaxaInvalidaException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return taxaDeJuros;
    }
}
