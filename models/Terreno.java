package models;

public class Terreno extends Financiamento{
    private String tipoZona; //comercial, residencial, industrial, etc

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.tipoZona = "Residencial";
    }

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.tipoZona = tipoZona;
    }

    //Cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1+ (getTaxaJuros() / 12)) * 1.02 ;
    }
}
