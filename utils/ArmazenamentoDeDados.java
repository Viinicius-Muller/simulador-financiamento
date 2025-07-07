package utils;

import models.Financiamento;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArmazenamentoDeDados {
    static Path pathDados = Paths.get("dadosFinanciamentos.txt"); //arquivo com os dados em texto
    static Path pathArraySer = Paths.get("financiamentos.ser"); //arquivo com objetos serializados

    //salva a arraylist de objs serializados no arquivo financiamentos.ser
    public static void salvarArrayFinanciamentos(ArrayList<Financiamento> finList) {
        try (FileOutputStream fileOut = new FileOutputStream(pathArraySer.toFile()); //cria o arquivo financiamentos.ser
             ObjectOutputStream ous = new ObjectOutputStream(fileOut)) {
            ous.writeObject(finList); //escreve os objetos serializados no .ser
            ous.flush(); //limpa e fecha a escritura de dados
        } catch (Exception e) {
            System.out.println("Falha ao tentar salvar ArrayList: "+e.getMessage());
        }
    }

    //carrega a arraylist dentro da .ser e retorna ela em outra arraylist
    public static ArrayList<Financiamento> carregarArrayFinanciamentos() {
        try (FileInputStream fileIn = new FileInputStream(pathArraySer.toFile());
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            return (ArrayList<Financiamento>) in.readObject(); //Lê o objeto e faz casting para a arraylist
        } catch (Exception e) {
            System.out.println("Falha ao carregar arquivo da ArrayList: "+e.getMessage());

            return null; //em caso de erro, retorna nulo
        }
    }

    //salva os dados da arraylist em um texto
    public static void salvarDadosFinanciamentos(ArrayList<Financiamento> finList) throws IOException {
        try ( FileWriter fw = new FileWriter(pathDados.toFile())) {

            for (Financiamento fin : finList) {
                fw.write(fin.toString()+"\n");
            }

            fw.flush();
        } catch (Exception e) {
            System.out.println("Erro ao tentar salvar dados em texto: "+e.getMessage());
        }

    }

    public static void lerDadosFinanciamentos() throws FileNotFoundException {
        try (BufferedReader fr = new BufferedReader(new FileReader(pathDados.toFile()))) { //try-with-resource (Automatiza o fechamento do reader)
            String linha;

            while ((linha = fr.readLine()) != null) { //enquanto houver linha, leia
                System.out.println(linha);
            }

        } catch (IOException  e) {
            System.out.println("Erro ao ler dados do texto: "+e.getMessage());
        }
    }
}
