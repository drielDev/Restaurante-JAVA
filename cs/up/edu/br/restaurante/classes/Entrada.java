package cs.up.edu.br.restaurante.classes;

import java.util.ArrayList;
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preco: ");
        Double preco = scanner.nextDouble();
        
        
        Entrada novaEntrada = new Entrada();
        novaEntrada.setNome(nome);
        novaEntrada.setPreco(preco);
        entradas.add(novaEntrada);

        System.out.println("Entrada adicionada com sucesso!");
    }

    public static void RemoveEntrada(List<Entrada> entradas){
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
            System.out.println("entrada '" + exclui + "' nao encontrada (verifique letras maiusculas e minusculas)");
        } else {
            System.out.println("entrada Excluida com sucesso!");
        }
        
    }

    public static void ListarEntrada(List<Entrada> entradas){
        
        if (!entradas.isEmpty()) {
            for (Entrada entrada : entradas) {
            System.out.println(entrada);
            }
        } else {
            System.out.println("cardapio de entradas esta vazio!");
        }
        
        
    }
}
