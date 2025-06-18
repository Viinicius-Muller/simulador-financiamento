package models;

public class Apartamento extends  Financiamento{
    private int numVagas; //vagas na garagem
    private int numAndar; //andar onde o ap está situado

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJuros, int numVagas, int numAndar) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.numVagas = numVagas;
        this.numAndar = numAndar;
    }

    //De acordo com as regras do banco, todos os financiamentos de apartamentos deverão usar um sistema de amortização chamado PRICE.
    // Este sistema já é usado por vários bancos.
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
}
