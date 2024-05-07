package cs.up.edu.br.restaurante.classes;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Entrada extends Comida{

    public Entrada(){ }

    public Entrada(String nome, Double preco){
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

    public static void Cria_entrada(List<Entrada> entradas) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preco: ");
        Double preco = scanner.nextDouble();
        
        Entrada novaEntrada = new Entrada();
        novaEntrada.setNome(nome);
        novaEntrada.setPreco(preco);
        entradas.add(novaEntrada);

        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Entrada adicionada com sucesso!");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println();
    }

    public static void RemoveEntrada(List<Entrada> entradas){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("informe o nome da entrada que deseja excluir: ");
        String exclui = scanner.nextLine();

        Boolean exist = false;
        
        for (Entrada entrada : entradas) {
             if (entrada.getNome().equals(exclui)) {
                entradas.remove(entrada);
                exist = true;
                break;
             }
        }
        if(!exist){
            System.out.println(); 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("entrada '" + exclui + "' nao encontrada (verifique letras maiusculas e minusculas)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("entrada Excluida com sucesso!");
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

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
            System.out.println("cardapio de entradas está vazio!");
            System.out.println("=====================================");
            System.out.println();
        }
    }
}
