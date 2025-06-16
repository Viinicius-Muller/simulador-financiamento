package models;

import java.util.Scanner;
import utils.InterfaceUsuario;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJuros;

    Scanner scanner = new Scanner(System.in);

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJuros = taxaJuros;
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

}
