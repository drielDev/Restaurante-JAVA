package cs.up.edu.br.restaurante.classes;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sobremesa extends Comida {

    public Sobremesa() {
    }

    public Sobremesa(String nome, Double preco) {
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

    public void setPreco(Double preco) {
        super.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Preço: " + getPreco();
    }

    public static void Cria_Sobremesa(List<Sobremesa> sobremesas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preco: ");
        Double preco = scanner.nextDouble();

        Sobremesa novaSobremesa = new Sobremesa();
        novaSobremesa.setNome(nome);
        novaSobremesa.setPreco(preco);
        sobremesas.add(novaSobremesa);

        System.out.println("Sobremesa adicionada com sucesso!");
        
    }

    public static void RemoveSobremesa(List<Sobremesa> sobremesas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome da sobremesa que deseja excluir: ");
        String exclui = scanner.nextLine();

        boolean exist = false;

        for (int i = 0; i < sobremesas.size(); i++) {
            if (sobremesas.get(i).getNome().equals(exclui)) {
                sobremesas.remove(i);
                exist = true;
                break;
            }
        }
        if (!exist) {
            System.out.println("Sobremesa '" + exclui + "' não encontrada (verifique letras maiúsculas e minúsculas)");
        } else {
            System.out.println("Sobremesa excluída com sucesso!");
        }
        
    }

    public static void ListarSobremesa(List<Sobremesa> sobremesas) {
        if (!sobremesas.isEmpty()) {
            // Ordena a lista de entradas em ordem alfabética
            Collections.sort(sobremesas, (e1, e2) -> e1.getNome().compareTo(e2.getNome()));
            for (Sobremesa sobremesa : sobremesas) {
                System.out.println(sobremesa);
            }
        } else {
            System.out.println("Cardápio de sobremesas está vazio!");
        }
    }
}
