import models.Financiamento;
import utils.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void salvarDados(Financiamento financiamento, FileWriter escritor) throws IOException {
        try {
            escritor.write(financiamento.toString());
            escritor.write("\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void salvarDados(ArrayList<Financiamento> listaFinanciamentos) {
        try (FileOutputStream fileOut = new FileOutputStream("lista_financiamentos.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(listaFinanciamentos); // Escreve a lista toda no arquivo
    } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Financiamento> carregarDados() throws IOException {
        try (FileInputStream fileIn = new FileInputStream("lista_financiamentos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {

            return (ArrayList<Financiamento>) in.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void ler(BufferedReader leitor) throws IOException {
        String linha;

        while ((linha = leitor.readLine()) != null) {
            System.out.println(linha);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Double valor = InterfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
        Double taxa = InterfaceUsuario.pedirTaxaJuros();
    }
}
