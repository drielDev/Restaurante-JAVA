package cs.up.edu.br.restaurante.classes;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


// Classe representando as sobremesas no restaurante
public class Sobremesa extends Comida {

    // Construtores
    public Sobremesa() {
    }

    public Sobremesa(String nome, Double preco) {
        super(nome, preco);
    }

    // Getters e setters herdados da superclasse Comida

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Preço: " + getPreco();
    }

    // Método para criar uma nova sobremesa e adicioná-la à lista de sobremesas
    public static void Cria_Sobremesa(List<Sobremesa> sobremesas) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preco: ");
        Double preco = scanner.nextDouble();

        Sobremesa novaSobremesa = new Sobremesa();
        novaSobremesa.setNome(nome);
        novaSobremesa.setPreco(preco);
        sobremesas.add(novaSobremesa);

        // Mensagem de confirmação
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("Sobremesa adicionada com sucesso!");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        
        // Chamada ao FileManager para salvar os dados da sobremesa criada
        String dados = "Nova sobremesa: " + nome + ", Preço: " + preco;
        FileManager.salvarDados(dados, "sobremesa.txt");
    }

    // Método para remover uma sobremesa da lista
    public static void RemoveSobremesa(List<Sobremesa> sobremesas) {
        @SuppressWarnings("resource")
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
            // Mensagem de erro se a sobremesa não for encontrada
            System.out.println("Sobremesa '" + exclui + "' não encontrada (verifique letras maiúsculas e minúsculas)");
        } else {
            // Mensagem de confirmação após a exclusão bem-sucedida
            System.out.println("Sobremesa excluída com sucesso!");
        }
        
        // Chamada ao FileManager para salvar o nome da sobremesa removida
        String dados = "Sobremesa removida: " + exclui;
        FileManager.salvarDados(dados, "sobremesa.txt");
    }

    // Método para listar todas as sobremesas do cardápio
    public static void ListarSobremesa(List<Sobremesa> sobremesas) {
        if (!sobremesas.isEmpty()) {
            // Ordena a lista de sobremesas em ordem alfabética
            Collections.sort(sobremesas, (e1, e2) -> e1.getNome().compareTo(e2.getNome()));
            System.out.println("___________SOBREMESAS___________");
            for (Sobremesa sobremesa : sobremesas) {
                System.out.println(sobremesa);
            }
            System.out.println();
        } else {
            // Mensagem informando que o cardápio de sobremesas está vazio
            System.out.println("Cardápio de sobremesas está vazio!");
        }

        // Chamada ao FileManager para salvar os dados de todas as sobremesas listadas
        for (Sobremesa sobremesa : sobremesas) {
            String dados = "Sobremesa: " + sobremesa.getNome() + ", Preço: " + sobremesa.getPreco();
            FileManager.salvarDados(dados, "sobremesa.txt");
        }
    } 
}
