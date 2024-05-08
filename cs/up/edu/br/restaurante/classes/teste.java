package cs.up.edu.br.restaurante.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class teste {
     public static void carregarFuncionario(List<Funcionario> funcionarios) {
        try (BufferedReader reader = new BufferedReader(new FileReader("funcionarios.txt"))) {
            String linha;
            // Lê cada linha do arquivo até chegar ao fim
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em nome e preço usando a vírgula como delimitador
                String[] partes = linha.split(", Preço: ");
                // Extrai o nome e o cargo da Funcionario
                String nome = partes[0];
                String cargo = (partes[1]);
                // Verifica se o Funcionario já existe na lista antes de adicioná-la
                if (!existeFuncionario(funcionarios, nome)) {
                    // Se o Funcionario não existir na lista, cria um novo Funcionario e a adiciona à lista de funcionarios
                    Funcionario novoFuncionario = new Funcionario();
                    novoFuncionario.setNome(nome);
                    novoFuncionario.setCargo(cargo);
                    funcionarios.add(novoFuncionario);
                }
            }
        } catch (IOException e) {
            // Se ocorrer um erro ao ler o arquivo, exibe uma mensagem de erro
            System.err.println("Erro ao ler o arquivo de funcionarios: " + e.getMessage());
        }
    }

    // Método auxiliar para verificar se um Funcionario já existe na lista
    private static boolean existeFuncionario(List<Funcionario> funcionarios, String nome) {
        for (Funcionario Funcionario : funcionarios) {
            // Compara o nome do Funcionario com o nome fornecido
            if (Funcionario.getNome().equals(nome)) {
                // Se o nome do Funcionario for encontrado na lista, retorna true
                return true;
            }
        }
        // Se o nome do Funcionario não for encontrado na lista, retorna false
        return false;
    }
}
