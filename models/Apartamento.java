package models;

public class Apartamento extends Financiamento{
    private int numVagas; //vagas na garagem
    private int numAndar; //andar onde o ap está situado

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJuros, int numVagas, int numAndar) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.numVagas = numVagas;
        this.numAndar = numAndar;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public int getNumAndar() {
        return numAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        // 1. Calcular a taxa mensal
        double taxaMensal = getTaxaJuros() / 12;

        // 2. Calcular o número de meses
        int meses = getPrazoFinanciamento() * 12;

        // 3. Aplicar a fórmula PRICE
        double fator = Math.pow(1 + taxaMensal, meses);
        return (getValorImovel() * fator * taxaMensal) / (fator - 1);
    }


    @Override
    public String toString() {
        return "[Valor do apartamento: "+this.getValorImovel()+
                " | Total do financiamento: "+this.calcularPagamentoTotal()+
                " | Taxa de juros: "+this.getTaxaJuros()* 100+
                "% | Prazo: "+this.getPrazoFinanciamento()+" anos | Andar: "+this.getNumAndar()+" | Vagas: "+this.getNumVagas()+"]";
    }
}
