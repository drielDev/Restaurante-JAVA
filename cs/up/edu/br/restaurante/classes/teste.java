package cs.up.edu.br.restaurante.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class teste {
    public static void carregarSobremesa(List<Sobremesa> sobremesas) {
        try (BufferedReader reader = new BufferedReader(new FileReader("sobremesas.txt"))) {
            String linha;
            // Lê cada linha do arquivo até chegar ao fim
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em nome e preço usando a vírgula como delimitador
                String[] partes = linha.split(", Preço: ");
                // Extrai o nome e o preço da sobremesa
                String nome = partes[0];
                Double preco = Double.parseDouble(partes[1]);
                // Verifica se a sobremesa já existe na lista antes de adicioná-la
                if (!existeSobremesa(sobremesas, nome)) {
                    // Se a sobremesa não existir na lista, cria uma nova sobremesa e a adiciona à lista de sobremesas
                    Sobremesa novaSobremesa = new Sobremesa();
                    novaSobremesa.setNome(nome);
                    novaSobremesa.setPreco(preco);
                    sobremesas.add(novaSobremesa);
                }
            }
        } catch (IOException e) {
            // Se ocorrer um erro ao ler o arquivo, exibe uma mensagem de erro
            System.err.println("Erro ao ler o arquivo de pratos sobremesas: " + e.getMessage());
        }
    }

    // Método auxiliar para verificar se um sobremesa já existe na lista
    private static boolean existeSobremesa(List<Sobremesa> sobremesas, String nome) {
        for (Sobremesa sobremesa : sobremesas) {
            // Compara o nome da sobremesa com o nome fornecido
            if (sobremesa.getNome().equals(nome)) {
                // Se o nome da sobremesa for encontrado na lista, retorna true
                return true;
            }
        }
        // Se o nome da sobremesa não for encontrado na lista, retorna false
        return false;
    }
}
