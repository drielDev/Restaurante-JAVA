package cs.up.edu.br.restaurante.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Classe responsável por operações de gerenciamento de arquivos
public class FileManager {

    // Método para salvar os dados em um arquivo de texto
    public static void salvarDados(String dados, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(dados);
            writer.newLine(); // Adicione uma nova linha após cada conjunto de dados
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }
}
