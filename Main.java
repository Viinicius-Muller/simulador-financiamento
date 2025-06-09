import models.Apartamento;
import models.Casa;
import models.Financiamento;
import models.Terreno;

public class Main {
    public static void main(String[] args) {
        Terreno financiamento = new Terreno();

        System.out.println(financiamento.calcularPagamentoMensal());
    }
}
