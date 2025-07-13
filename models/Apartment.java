package models;

public class Apartment extends Finance {
    private int parkingSpaces; //vagas na garagem
    private int floor; //andar onde o ap está situado

    public Apartment(double valorImovel, int prazoFinanciamento, double taxaJuros, int parkingSpaces, int floor) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.parkingSpaces = parkingSpaces;
        this.floor = floor;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public double calcMonthlyPayment() {
        // 1. Calculate monthly tax
        double monthlyTax = getInterestRate() / 12;

        // 2. Calculate number of months
        int months = getFinanceTime() * 12;

        // 3. Apply "PRICE" formula
        double factor = Math.pow(1 + monthlyTax, months);
        return (getPropertyValue() * factor * monthlyTax) / (factor - 1);
    }


    @Override
    public String toString() {
        return "[Appartment value: "+this.getPropertyValue()+
                " | Finance total: "+this.calcTotalPayment()+
                " | Interest rate: "+this.getInterestRate()* 100+
                "% | Time: "+this.getFinanceTime()+" years | Floor: "+this.getFloor()+" | Parking spaces: "+this.getParkingSpaces()+"]";
    }
}
