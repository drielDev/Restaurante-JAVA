package cs.up.edu.br.restaurante.classes;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Classe Entrada
public class Entrada extends Comida{

    // Construtor vazio
    public Entrada(){ }

    // Construtor com parâmetros
    public Entrada(String nome, Double preco){
        super(nome, preco);
    }

    // Métodos getters e setters para nome e preço
    public void setNome(String nome) {
        super.setNome(nome);
    }   

    public String getNome() {
        return super.getNome();
    }  

    public Double getPreco() {
       return super.getPreco();
    }

    public void setPreco(Double preco){
        super.setPreco(preco);
    }

    // Método para exibir a representação textual de uma entrada
    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Preço: " + getPreco();
    }

    // Método para criar uma nova entrada
    public static void Cria_entrada(List<Entrada> entradas) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome e o preço da entrada ao usuário
        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preço: ");
        Double preco = scanner.nextDouble();
        
        // Cria uma nova entrada e a adiciona à lista de entradas
        Entrada novaEntrada = new Entrada();
        novaEntrada.setNome(nome);
        novaEntrada.setPreco(preco);
        entradas.add(novaEntrada);

        // Exibe uma mensagem de sucesso
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Entrada adicionada com sucesso!");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println();

        // Salva os dados da entrada em um arquivo
        String dados = "Nova entrada: " + nome + ", Preço: " + preco;
        FileManager.salvarDados(dados, "entradas.txt");
    }

    // Método para remover uma entrada
    public static void RemoveEntrada(List<Entrada> entradas){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome da entrada que deseja excluir
        System.out.print("Informe o nome da entrada que deseja excluir: ");
        String exclui = scanner.nextLine();

        Boolean exist = false;
        
        // Percorre a lista de entradas em busca da entrada a ser removida
        for (Entrada entrada : entradas) {
             if (entrada.getNome().equals(exclui)) {
                entradas.remove(entrada);
                exist = true;
                break;
             }
        }
        // Exibe uma mensagem de sucesso ou erro, caso a entrada não seja encontrada
        if(!exist){
            System.out.println(); 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Entrada '" + exclui + "' não encontrada (verifique letras maiúsculas e minúsculas)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("Entrada excluída com sucesso!");
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println();
        }

        // Salva os dados da remoção em um arquivo
        String dados = "Entrada removida: " + exclui;
        FileManager.salvarDados(dados, "entradas.txt");

        System.out.println("Entrada excluída com sucesso!");
    }

    // Método para listar as entradas disponíveis
    public static void ListarEntrada(List<Entrada> entradas){
        if (!entradas.isEmpty()) {
            // Ordena a lista de entradas em ordem alfabética
            Collections.sort(entradas, (e1, e2) -> e1.getNome().compareTo(e2.getNome()));
            System.out.println("___________ENTRADAS___________");
            for (Entrada entrada : entradas) {
                System.out.println(entrada);
            }
            System.out.println();
        } else {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("Cardápio de entradas está vazio!");
            System.out.println("=====================================");
            System.out.println(); 
        }

        // Salva os dados das entradas em um arquivo
        for (Entrada entrada : entradas) {
            String dados = "Entrada: " + entrada.getNome() + ", Preço: " + entrada.getPreco();
            FileManager.salvarDados(dados, "entradas.txt");
        }
    }
}
