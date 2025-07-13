package models;


import java.io.Serializable;

public abstract class Finance implements Serializable {

    private static final long serialVersionUID = 1L;

    private double propertyValue;
    private int financeTime;
    private double interestRate;

    public Finance(double propertyValue, int financeTime, double interestRate) {
        this.propertyValue = propertyValue;
        this.financeTime = financeTime;
        this.interestRate = interestRate / 100;
    }

    //Métodos próprios
    public double calcMonthlyPayment() {
        return ((this.propertyValue / (this.financeTime * 12)) * (1 + (this.interestRate / 12)));
    }

    public double calcTotalPayment() {
        return this.calcMonthlyPayment() * this.financeTime * 12;
    }

    public void mostrarDados() {
        System.out.println(
                "Property value: "+this.getPropertyValue()+"\n" +
                        "Total finance price: "+this.calcTotalPayment()
        );
    }

    //Getters
    public double getPropertyValue() {
        return propertyValue;
    }

    public int getFinanceTime() {
        return financeTime;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "[Valor do ímovel: "+this.getPropertyValue()+
                " | Total do financiamento: "+this.calcTotalPayment()+
                " | Taxa de juros: "+this.getInterestRate()* 100+
                "% | Prazo: "+this.getFinanceTime()+" anos]";
    }
}
