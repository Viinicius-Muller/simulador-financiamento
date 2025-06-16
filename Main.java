import models.Apartamento;
import models.Casa;
import models.Financiamento;
import models.Terreno;
import utils.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        Double valor = InterfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
        Double taxa = InterfaceUsuario.pedirTaxaJuros();
    }
}
