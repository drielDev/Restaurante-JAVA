package cs.up.edu.br.restaurante.classes;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prato_principal extends Comida{

    public Prato_principal(){ }

    public Prato_principal(String nome, Double preco){
        super(nome, preco);
    }

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

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Preço: " + getPreco();
    }

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

        System.out.println("Prato principal adicionado com sucesso!");
        
    }

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
            System.out.println("Prato principal '" + exclui + "' não encontrado (verifique letras maiúsculas e minúsculas)");
        } else {
            System.out.println("Prato principal excluído com sucesso!");
        }
        
    }

    public static void ListaPrato_principal(List<Prato_principal> pratos_principais){
        if (!pratos_principais.isEmpty()) {
            // Ordena a lista de entradas em ordem alfabética
            Collections.sort(pratos_principais, (e1, e2) -> e1.getNome().compareTo(e2.getNome()));
            System.out.println("___________PRINCIPAIS___________");
            for (Prato_principal prato_principal : pratos_principais) {
                System.out.println(prato_principal);
            }
            System.out.println();
        } else {
            System.out.println("Cardápio de pratos principais está vazio!");
        }
    }
}
