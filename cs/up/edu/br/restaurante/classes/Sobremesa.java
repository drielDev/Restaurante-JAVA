package cs.up.edu.br.restaurante.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Classe representando as sobremesas no restaurante
public class Sobremesa {
    private String nome;
    private Double preco;
    
    // Construtores
    public Sobremesa() {
    }

    public Sobremesa(String nome, Double preco) {
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

        // Exibe uma mensagem de sucesso
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Sobremesa adicionada com sucesso!");
        System.out.println("+++++++++++++++++++++++++++++++");
        
        // Salva os dados da Sobremesa em um arquivo
        String dados =  nome + ", Preço: " + preco;
        FileManager.salvarDados(dados, "sobremesas.txt");
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
            System.out.println(); 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Sobremesa '" + exclui + "' não encontrada (verifique letras maiúsculas e minúsculas)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("Sobremesa excluída com sucesso!");
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println();
            // Salva os dados da remoção em um arquivo
            salvarSobremesa(sobremesas);
        }
    }

        private static void salvarSobremesa(List<Sobremesa> sobremesas) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Sobremesas.txt"))) {
                for (Sobremesa sobremesa : sobremesas) {
                    String dados = sobremesa.getNome() + ", Preço: " + sobremesa.getPreco();
                    writer.write(dados);
                    writer.newLine(); // Adicione uma nova linha após cada conjunto de dados
                }
            } catch (IOException e) {
                System.err.println("Erro ao salvar os dados das Sobremesas no arquivo: " + e.getMessage());
        }
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
            System.out.println();
            System.out.println("=====================================");
            System.out.println("Cardápio de sobremesas está vazio!");
            System.out.println("=====================================");
            System.out.println(); 
        }
    } 
}
