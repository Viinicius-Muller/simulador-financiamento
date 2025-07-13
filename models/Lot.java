package models;

public class Lot extends Finance {
    private String residentialZone; //comercial, residencial, industrial, etc

    public Lot(double propertyValue, int financeTime, double interestRate) {
        super(propertyValue, financeTime, interestRate);
        this.residentialZone = "Residencial";
    }

    public Lot(double propertyValue, int financeTime, double interestRate, String residentialZone) {
        super(propertyValue, financeTime, interestRate);
        this.residentialZone = residentialZone;
    }

    public String getResidentialZone() {
        return residentialZone;
    }

    @Override
    public double calcMonthlyPayment() {
        return (getPropertyValue() / (getFinanceTime() * 12)) * (1+ (getInterestRate() / 12)) * 1.02 ;
    }

    @Override
    public String toString() {
        return "[Lot value: "+this.getPropertyValue()+
                " | Finance total: "+this.calcTotalPayment()+
                " | Tax rate: "+this.getInterestRate()* 100+
                "% | Time: "+this.getFinanceTime()+" years | Zone: "+this.getResidentialZone()+"]";
    }
}
