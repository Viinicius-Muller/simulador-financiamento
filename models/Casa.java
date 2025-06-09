package models;
import java.util.Scanner;

public class Casa extends Financiamento{
    //Casa | Adiciona R$80 a cada parcela
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1+ (getTaxaJuros() / 12)) + 80;
    }
}
