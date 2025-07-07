package models;

import exceptions.AumentoMaiorDoQueJurosException;
import models.Financiamento;

public class Casa extends Financiamento {
    private double tamanhoConstruido;
    private double tamanhoTerreno;
    private double acrescimo = 80;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJuros, double tamanhoConstruido, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.tamanhoConstruido = tamanhoConstruido;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    private void validarJuros(double valorJuros, double valorAcrescimo) throws AumentoMaiorDoQueJurosException {
        if (valorAcrescimo > valorJuros) {
            throw new AumentoMaiorDoQueJurosException("Acrescimo ("+valorAcrescimo+") maior que juros ("+valorJuros+")");
        }
    }

    public double getTamanhoConstruido() {
        return tamanhoConstruido;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    //Casa | Adiciona R$80 a cada parcela
    @Override
    public double calcularPagamentoMensal() {
        double totalComJuros = super.calcularPagamentoMensal();
        double juros = totalComJuros - (totalComJuros / (1 + super.getTaxaJuros()));

        try {
            this.validarJuros(juros,this.acrescimo);
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage());
            this.acrescimo = juros;
            System.out.println("Alterando o valor do acréscimo para o de juros: "+this.acrescimo);
        }

        return totalComJuros + acrescimo;
    }

    @Override
    public String toString() {
        return "[Valor da casa: "+this.getValorImovel()+
                " | Total do financiamento: "+this.calcularPagamentoTotal()+
                " | Taxa de juros: "+this.getTaxaJuros()* 100+
                "% | Prazo: "+this.getPrazoFinanciamento()+" anos | Terreno: "+this.getTamanhoTerreno()+"m² | Construido: "+this.getTamanhoConstruido()+"m²]";
    }
}
