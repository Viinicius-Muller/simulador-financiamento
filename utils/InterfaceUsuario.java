package utils;

import exceptions.PrazoInvalido;
import exceptions.TaxaInvalida;
import exceptions.ValorInvalido;

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
                    throw new ValorInvalido("Valor muito alto: "+valorImovel);
                }
                if (valorImovel <= 0) {
                    throw new ValorInvalido("Valor do imóvel deve ser positivo: "+valorImovel);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
            } catch (ValorInvalido e) {
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
                    throw new PrazoInvalido("Prazo muito alto: "+prazoFinanciamento+" anos");
                }
                if (prazoFinanciamento <= 0) {
                    throw new PrazoInvalido("Prazo deve ser positivo: "+prazoFinanciamento);
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
            } catch (PrazoInvalido e) {
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

                if (taxaDeJuros > 100) {
                    throw new TaxaInvalida("Porcentagem de juros muito alta: "+taxaDeJuros);
                }
                if (taxaDeJuros <= 0) {
                    throw new TaxaInvalida("Porcentagem de juros deve ser positiva: "+taxaDeJuros);
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido.");
                scanner.nextLine();
            } catch (TaxaInvalida e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        return taxaDeJuros;
    }
}
