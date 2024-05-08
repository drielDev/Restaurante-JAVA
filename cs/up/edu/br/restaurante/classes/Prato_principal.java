package cs.up.edu.br.restaurante.classes;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


// Classe representando os pratos principais no restaurante
public class Prato_principal extends Comida{

    // Construtores
    public Prato_principal(){ }

    public Prato_principal(String nome, Double preco){
        super(nome, preco);
    }

    // Getters e setters herdados da superclasse Comida

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

        System.out.print("Informe o preco: ");
        Double preco = scanner.nextDouble();
        
        Prato_principal novoPrato = new Prato_principal();
        novoPrato.setNome(nome);
        novoPrato.setPreco(preco);
        pratos_principais.add(novoPrato);

        // Mensagem de confirmação
        System.out.println("Prato principal adicionado com sucesso!");
        
        // Chamada ao FileManager para salvar os dados do prato principal criado
        String dados = "Novo prato principal: " + nome + ", Preço: " + preco;
        FileManager.salvarDados(dados, "prato_principal.txt");
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
            // Mensagem de confirmação após a exclusão bem-sucedida
            System.out.println("Prato principal excluído com sucesso!");
        }
        
        // Chamada ao FileManager para salvar o nome do prato principal removido
        String dados = "Prato principal removido: " + exclui;
        FileManager.salvarDados(dados, "prato_principal.txt");
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
            System.out.println("Cardápio de pratos principais está vazio!");
        }

        // Chamada ao FileManager para salvar os dados de todos os pratos principais listados
        for (Prato_principal principal : pratos_principais) {
            String dados = "Entrada: " + principal.getNome() + ", Preço: " + principal.getPreco();
            FileManager.salvarDados(dados, "prato_principal.txt");
        }
    }
}
