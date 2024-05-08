package cs.up.edu.br.restaurante.menus.funcionario;

import java.util.Scanner;

import cs.up.edu.br.restaurante.principal.Index;

// Classe Funcionario representa os funcionários do restaurante
public class Funcionario {
    // Atributos da classe
    private String nome;
    private String cargo;
    // outros atributos, como salário, data de contratação, etc.

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

    // Método para exibir o menu de funcionário
    public static void FuncionarioMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("-----------------------------------");
            System.out.println("Lista dos funcionários:");
            System.out.println("João - Garçom");
            System.out.println("Maria - Atendente");
            System.out.println("Carlos - Cozinheiro");
            System.out.println("Ana - Garçonete");
            System.out.println("Pedro - Atendente");
            System.out.println("Juliana - Cozinheira");
            System.out.println("Marcos - Garçom");
            System.out.println("Fernanda - Atendente");
            System.out.println("José - Cozinheiro");
            System.out.println("Renata - Garçom");
            System.out.println("-----------------------------------");
            System.out.println("[1] Voltar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            System.out.println("-----------------------------------");

            switch (opcao) {
                case 1:
                    Index.main(null);
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }
    }
}
