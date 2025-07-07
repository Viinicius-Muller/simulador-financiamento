package models;


import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJuros;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJuros = taxaJuros / 100;
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

    @Override
    public String toString() {
        return "[Valor do ímovel: "+this.getValorImovel()+
                " | Total do financiamento: "+this.calcularPagamentoTotal()+
                " | Taxa de juros: "+this.getTaxaJuros()* 100+
                "% | Prazo: "+this.getPrazoFinanciamento()+" anos]";
    }
}
