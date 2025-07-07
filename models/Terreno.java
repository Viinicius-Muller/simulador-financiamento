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

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1+ (getTaxaJuros() / 12)) * 1.02 ;
    }

    @Override
    public String toString() {
        return "[Valor do terreno: "+this.getValorImovel()+
                " | Total do financiamento: "+this.calcularPagamentoTotal()+
                " | Taxa de juros: "+this.getTaxaJuros()* 100+
                "% | Prazo: "+this.getPrazoFinanciamento()+" anos | Zona: "+this.getTipoZona()+"]";
    }
}
