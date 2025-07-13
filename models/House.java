package models;

import exceptions.IncreaseHigherThanTaxException;

public class House extends Finance {
    private double builtSize;
    private double lotSize;
    private double increase = 80;

    public House(double valorImovel, int prazoFinanciamento, double taxaJuros, double tamanhoConstruido, double lotSize) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.builtSize = tamanhoConstruido;
        this.lotSize = lotSize;
    }

    private void validateIncrease(double valorJuros, double valorAcrescimo) throws IncreaseHigherThanTaxException {
        if (valorAcrescimo > valorJuros) {
            throw new IncreaseHigherThanTaxException("Increased value ("+valorAcrescimo+") is higher than tax value ("+valorJuros+")");
        }
    }

    public double getBuiltSize() {
        return builtSize;
    }

    public double getLotSize() {
        return lotSize;
    }

    public double getIncrease() {
        return increase;
    }

    //Casa | Adiciona R$80 a cada parcela
    @Override
    public double calcMonthlyPayment() {
        double totalWithTaxes = super.calcMonthlyPayment();
        double taxValue = totalWithTaxes - (totalWithTaxes / (1 + super.getInterestRate()));

        try {
            this.validateIncrease(taxValue,this.increase);
        } catch (IncreaseHigherThanTaxException e) {
            System.out.println(e.getMessage());
            this.increase = taxValue;
            System.out.println("Changing increased value to equal tax value: "+this.increase);
        }

        return totalWithTaxes + increase;
    }

    @Override
    public String toString() {
        return "[House value: "+this.getPropertyValue()+
                " | Finance total: "+this.calcTotalPayment()+
                " | Interest rate: "+this.getInterestRate()* 100+
                "% | Time: "+this.getFinanceTime()+" years | Lot size: "+this.getLotSize()+"m² | Built size: "+this.getBuiltSize()+"m²]";
    }
}
