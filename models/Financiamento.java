package models;

import java.util.Scanner;
import utils.InterfaceUsuario;

public class Financiamento implements InterfaceUsuario {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJuros;

    Scanner scanner = new Scanner(System.in);

    public Financiamento() {
        valorImovel = this.pedirValorImovel();
        prazoFinanciamento = this.pedirPrazoFinanciamento();
        taxaJuros =this.pedirTaxaJuros();
        scanner.close();
    }

    //Métodos próprios
    public double calcularPagamentoMensal() {
        return ((this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJuros / 12)));
    }

    public double calcularPagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void mostrarDados() {
        System.out.println(
                "Valor do imóvel: "+this.getValorImovel()+"\n" +
                        "Valor total do financiamento: "+this.calcularPagamentoTotal()
        );
    }

    //Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    //Interface Usuario
    @Override
    public double pedirValorImovel() {
        while (true) {
            System.out.print("Dígite o valor do imóvel: ");
            double valorDigitado = scanner.nextDouble();

            if (valorDigitado <= 0 || valorDigitado > 99999999) {
                System.out.println("Valor incorreto, tente novamente.");
                continue;
            }
            return valorDigitado;
        }

    }

    @Override
    public int pedirPrazoFinanciamento() {
        while (true) {
            System.out.print("Dígite o prazo do financiamento em anos: ");
            int valorDigitado = scanner.nextInt();

            if (valorDigitado <= 0 || valorDigitado > 30) {
                System.out.println("Valor incorreto, tente novamente.");
                continue;
            }
            return valorDigitado;
        }
    }

    @Override
    public double pedirTaxaJuros() {
        while (true) {
            System.out.print("Dígite a taxa de juros anual: ");
            double valorDigitado = scanner.nextDouble();

            if (valorDigitado <= 0 || valorDigitado > 100) {
                System.out.println("Valor incorreto, tente novamente.");
                continue;
            }
            return valorDigitado / 100;
        }
    }
}
