package models;

public class Terreno extends Financiamento{
    //Cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
    @Override
    public double calcularPagamentoMensal() {
        double total = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1+ (getTaxaJuros() / 12));
        return total + total * .02 ;
    }
}
