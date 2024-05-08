package cs.up.edu.br.restaurante.principal;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.classes.FileManager;
import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;
import cs.up.edu.br.restaurante.menus.funcionario.Funcionario;
import cs.up.edu.br.restaurante.menus.pedido.Principal_pedido;

/**
 * Esta classe representa o ponto de entrada do programa.
 */
public class Index {
    /**
     * Método principal que inicia a execução do programa.
     * @param args os argumentos de linha de comando (não utilizados)
     */

     private static List<Entrada> entradas = Cardapio.getEntradas();
     private static List<Prato_principal> principais = Cardapio.getPrincipais();
     private static List<Sobremesa> sobremesas = Cardapio.getSobremesas();
    public static void main(String[] args) {

        FileManager.carregarEntradas(entradas);
        FileManager.carregarPratros_principais(principais);
        FileManager.carregarSobremesa(sobremesas);

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
                // Acessa o menu de funcionarios
                   Funcionario.FuncionarioMenu();
                    break;
                case 4:
                // Mensagem avisando o fim do programa
                   System.out.println("Saindo...");
                    break;
                default:
                    break;
            }
        } while (opcao != 4); // Repete o loop enquanto a nao for 4
    }
}
