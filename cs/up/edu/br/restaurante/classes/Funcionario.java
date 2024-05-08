package cs.up.edu.br.restaurante.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Classe Funcionario representa os funcionários do restaurante
public class Funcionario {
    // Atributos da classe
    private String nome;
    private String cargo;

    // Construtor vazio
    public Funcionario(){ }

    // Construtor da classe
    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para exibir a representação textual de um Funcionario
    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Cargo: " + getCargo();
    }

    // Método para cadastar um novo funcionario
    public static void Cria_Funcionario(List<Funcionario> funcionarios) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

    // Solicita o nome e o cargo da funcionario ao usuário
    System.out.print("Informe o nome: ");
    String nome = scanner.nextLine();

    System.out.print("Informe o cargo: ");
    String cargo = scanner.nextLine();
    
    // Cadastra um novo funcionario e o adiciona à lista de funcionarios
    Funcionario novoFuncionario = new Funcionario();
    novoFuncionario.setNome(nome);
    novoFuncionario.setCargo(cargo);
    funcionarios.add(novoFuncionario);

    // Exibe uma mensagem de sucesso
    System.out.println();
    System.out.println("+++++++++++++++++++++++++++++++");
    System.out.println("Funcionario adicionado com sucesso!");
    System.out.println("+++++++++++++++++++++++++++++++");
    String dados =  nome + " Cargo: " + cargo;
    FileManager.salvarDados(dados, "funcionarios.txt");
    }


    // Método para remover uma funcionario
    public static void RemoveFuncionarios(List<Funcionario> funcionarios){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome da funcionario que deseja excluir
        System.out.print("Informe o nome da funcionario que deseja excluir: ");
        String exclui = scanner.nextLine();

        Boolean exist = false;
        
        // Percorre a lista de funcionarios em busca do funcionario a ser removido
        for (Funcionario funcionario : funcionarios) {
             if (funcionario.getNome().equals(exclui)) {
                funcionarios.remove(funcionario);
                exist = true;
                break;
             }
        }
        // Exibe uma mensagem de sucesso ou erro, caso o funcionario não seja encontrada
        if(!exist){
            System.out.println(); 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("funcionario '" + exclui + "' não encontrada (verifique letras maiúsculas e minúsculas)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("funcionario excluído com sucesso!");
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println();
            salvarFuncionarios(funcionarios);
        }
    }

     // Método para listar os funcionarios disponíveis
    public static void Listarfuncionario(List<Funcionario> funcionarios){
        if (!funcionarios.isEmpty()) {
            // Ordena a lista de funcionarios em ordem alfabética
            Collections.sort(funcionarios, (e1, e2) -> e1.getNome().compareTo(e2.getNome()));
            System.out.println("___________funcionarios___________");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
            System.out.println();
        } else {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("Lista de funcionarios está vazia!");
            System.out.println("=====================================");
            System.out.println(); 
            
        }
    }

    private static void salvarFuncionarios(List<Funcionario> funcionarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("funcionarios.txt"))) {
            for (Funcionario funcionario : funcionarios) {
                String dados = funcionario.getNome() + " Cargo: " + funcionario.getCargo();
                writer.write(dados);
                writer.newLine(); // Adicione uma nova linha após cada conjunto de dados
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados dos funcionarios no arquivo: " + e.getMessage());
        }
    }

}



