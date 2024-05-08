package cs.up.edu.br.restaurante.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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

    public static void carregarEntradas(List<Entrada> entradas) {
        try (BufferedReader reader = new BufferedReader(new FileReader("entradas.txt"))) {
            String linha;
            // Lê cada linha do arquivo até chegar ao fim
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em nome e preço usando a vírgula como delimitador
                String[] partes = linha.split(", Preço: ");
                // Extrai o nome e o preço da entrada
                String nome = partes[0];
                Double preco = Double.parseDouble(partes[1]);
                // Verifica se a entrada já existe na lista antes de adicioná-la
                if (!existeEntrada(entradas, nome)) {
                    // Se a entrada não existir na lista, cria uma nova entrada e a adiciona à lista de entradas
                    Entrada novaEntrada = new Entrada();
                    novaEntrada.setNome(nome);
                    novaEntrada.setPreco(preco);
                    entradas.add(novaEntrada);
                }
            }
        } catch (IOException e) {
            // Se ocorrer um erro ao ler o arquivo, exibe uma mensagem de erro
            System.err.println("Erro ao ler o arquivo de entradas: " + e.getMessage());
        }
    }

    // Método auxiliar para verificar se uma entrada já existe na lista
    private static boolean existeEntrada(List<Entrada> entradas, String nome) {
        for (Entrada entrada : entradas) {
            // Compara o nome da entrada com o nome fornecido
            if (entrada.getNome().equals(nome)) {
                // Se o nome da entrada for encontrado na lista, retorna true
                return true;
            }
        }
        // Se o nome da entrada não for encontrado na lista, retorna false
        return false;
    }


    public static void carregarPratros_principais(List<Prato_principal> principais) {
        try (BufferedReader reader = new BufferedReader(new FileReader("principais.txt"))) {
            String linha;
            // Lê cada linha do arquivo até chegar ao fim
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em nome e preço usando a vírgula como delimitador
                String[] partes = linha.split(", Preço: ");
                // Extrai o nome e o preço do prato principal
                String nome = partes[0];
                Double preco = Double.parseDouble(partes[1]);
                // Verifica se o prato principal já existe na lista antes de adicioná-la
                if (!existePrato_principal(principais, nome)) {
                    // Se o prato principal não existir na lista, cria uma novo prato principal e a adiciona à lista de principais
                    Prato_principal novoPrincipal = new Prato_principal();
                    novoPrincipal.setNome(nome);
                    novoPrincipal.setPreco(preco);
                    principais.add(novoPrincipal);
                }
            }
        } catch (IOException e) {
            // Se ocorrer um erro ao ler o arquivo, exibe uma mensagem de erro
            System.err.println("Erro ao ler o arquivo de pratos principais: " + e.getMessage());
        }
    }

    // Método auxiliar para verificar se um prato principal já existe na lista
    private static boolean existePrato_principal(List<Prato_principal> principais, String nome) {
        for (Prato_principal principal : principais) {
            // Compara o nome do prato principal com o nome fornecido
            if (principal.getNome().equals(nome)) {
                // Se o nome do prato principal for encontrado na lista, retorna true
                return true;
            }
        }
        // Se o nome do prato principal não for encontrado na lista, retorna false
        return false;
    }

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
            System.err.println("Erro ao ler o arquivo de sobremesas: " + e.getMessage());
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

    public static void carregarFuncionario(List<Funcionario> funcionarios) {
        try (BufferedReader reader = new BufferedReader(new FileReader("funcionarios.txt"))) {
            String linha;
            // Lê cada linha do arquivo até chegar ao fim
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em nome e preço usando a vírgula como delimitador
                String[] partes = linha.split(" Cargo: ");
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


