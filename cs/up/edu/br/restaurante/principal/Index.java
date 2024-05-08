package cs.up.edu.br.restaurante.principal;

import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Funcionario;
import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;
import cs.up.edu.br.restaurante.menus.pedido.Principal_pedido;

/**
 * Esta classe representa o ponto de entrada do programa.
 */
public class Index {

    /**
     * Método principal que inicia a execução do programa.
     * @param args os argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Loop principal que permite ao usuário interagir com o sistema
        do {
            // Exibe o menu de opções
            System.out.println("[1]Acessar cardapio");
            System.out.println("[2]Acessar pedidos");
            System.out.println("[3]Acessar Funcionarios");
            System.out.println("[4]Sair");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();

            // Executa a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Acessa o menu do cardápio
                    Cardapio.CardapioMenu();
                    break;
                case 2:
                    // Acessa o menu de pedidos
                    Principal_pedido.PedidoMenu();
                    break;
                case 3:
                    Funcionario.FuncionarioMenu();
                    break;
                case 4:
                System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha uma opcao valida!");
                    break;
            }
        } while (opcao != 4); // Repete o loop enquanto a opção for 0
        scanner.close(); // Fecha o scanner para evitar vazamentos de recursos

    }
}
