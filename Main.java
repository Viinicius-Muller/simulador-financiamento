import models.Apartamento;
import models.Casa;
import models.Financiamento;
import models.Terreno;
import utils.*;

import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {

        /* //Código exemplo
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            double valor = InterfaceUsuario.pedirValorImovel();
            double taxa = InterfaceUsuario.pedirTaxaJuros();
            int prazo = InterfaceUsuario.pedirPrazoFinanciamento();

           if (i == 0) { //Interface para criação de Ap
               int andar = InterfaceApartamento.pedirAndar();
               int vagas = InterfaceApartamento.pedirNumVagas();
               financiamentos.add(new Apartamento(valor,prazo,taxa,vagas,andar));
           }
           if (i == 1) { //Interface para criação de Casa
                double terreno = InterfaceCasa.pedirTamanhoTerreno();
                double construido = InterfaceCasa.pedirTamanhoConstruido();
                financiamentos.add(new Casa(valor,prazo,taxa,terreno,construido));
            }
           if (i == 2) { //Interface para criação de Terreno
                String zona = InterfaceTerreno.pedirZona();
                financiamentos.add(new Terreno(valor,prazo,taxa,zona));
           }
        }
        //Salvamento e carregamento/leitura dos objetos serializados na Array
        ArmazenamentoDeDados.salvarArrayFinanciamentos(financiamentos);
        ArrayList<Financiamento> novaLista = ArmazenamentoDeDados.carregarArrayFinanciamentos();
        System.out.println(novaLista);

        System.out.println("------------------");
        System.out.println("Dados em texto");

        //Salvamento e leitura dos dados em texto
        ArmazenamentoDeDados.salvarDadosFinanciamentos(novaLista);
        ArmazenamentoDeDados.lerDadosFinanciamentos();
        */

    }
}
