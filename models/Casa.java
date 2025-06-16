package models;

import models.Financiamento;

public class Casa extends Financiamento {
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
    }

    //Casa | Adiciona R$80 a cada parcela
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1+ (getTaxaJuros() / 12)) + 80;
    }
}
