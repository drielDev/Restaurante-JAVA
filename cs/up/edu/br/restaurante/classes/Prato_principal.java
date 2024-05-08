package cs.up.edu.br.restaurante.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;




// Classe representando os pratos principais no restaurante
public class Prato_principal{
    private String nome;
    private Double preco;

    // Construtores
    public Prato_principal(){ }

    public Prato_principal(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Preço: " + getPreco();
    }

    // Método para criar um novo prato principal e adicioná-lo à lista de pratos principais
    public static void CriaPrato_principal(List<Prato_principal> pratos_principais) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preço: ");
        Double preco = scanner.nextDouble();
        
        Prato_principal novoPrato = new Prato_principal();
        novoPrato.setNome(nome);
        novoPrato.setPreco(preco);
        pratos_principais.add(novoPrato);

        // Exibe uma mensagem de sucesso
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Prato principal adicionada com sucesso!");
        System.out.println("+++++++++++++++++++++++++++++++");
        
        // Salva os dados ddo prato principal em um arquivo
        String dados =  nome + ", Preço: " + preco;
        FileManager.salvarDados(dados, "principais.txt");
    }

    // Método para remover um prato principal da lista
    public static void RemovePrato_principal(List<Prato_principal> pratos_principais){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome do prato principal que deseja excluir: ");
        String exclui = scanner.nextLine();

        Boolean exist = false;
        
        for (int i = 0; i < pratos_principais.size(); i++) {
             if (pratos_principais.get(i).getNome().equals(exclui)) {
                pratos_principais.remove(i);
                exist = true;
                break;
             }
        }
        if(!exist){
            // Mensagem de erro se o prato principal não for encontrado
            System.out.println("Prato principal '" + exclui + "' não encontrado (verifique letras maiúsculas e minúsculas)");
        } else {
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("Prato principal excluída com sucesso!");
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println();
            // Salva os dados da remoção em um arquivo
            salvarPrato_principal(pratos_principais);
        }
    }    

        private static void salvarPrato_principal(List<Prato_principal> principais) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("principais.txt"))) {
                for (Prato_principal principal : principais) {
                    String dados =  principal.getNome() + ", Preço: " + principal.getPreco();
                    writer.write(dados);
                    writer.newLine(); // Adicione uma nova linha após cada conjunto de dados
                }
            } catch (IOException e) {
                System.err.println("Erro ao salvar os dados de pato principal no arquivo: " + e.getMessage());
            }     
        }

    // Método para listar todos os pratos principais do cardápio
    public static void ListaPrato_principal(List<Prato_principal> pratos_principais){
        if (!pratos_principais.isEmpty()) {
            // Ordena a lista de pratos principais em ordem alfabética
            Collections.sort(pratos_principais, (e1, e2) -> e1.getNome().compareTo(e2.getNome()));
            System.out.println("___________PRINCIPAIS___________");
            for (Prato_principal prato_principal : pratos_principais) {
                System.out.println(prato_principal);
            }
            System.out.println();
        } else {
            // Mensagem informando que o cardápio de pratos principais está vazio
            System.out.println();
            System.out.println("=====================================");
            System.out.println("Cardápio de Prato principal está vazio!");
            System.out.println("=====================================");
            System.out.println(); 
        }
    }
}


    
        

