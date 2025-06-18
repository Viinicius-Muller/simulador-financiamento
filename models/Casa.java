package models;

import models.Financiamento;

public class Casa extends Financiamento {
    private double tamanhoConstruido;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJuros, double tamanhoConstruido, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.tamanhoConstruido = tamanhoConstruido;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    //Casa | Adiciona R$80 a cada parcela
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1+ (getTaxaJuros() / 12)) + 80;
    }
}
