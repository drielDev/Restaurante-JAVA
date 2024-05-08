package cs.up.edu.br.restaurante.principal;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.classes.Funcionario;
import cs.up.edu.br.restaurante.classes.FileManager;
import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;
import cs.up.edu.br.restaurante.menus.funcionario.PrincipalFuncionario;
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
     private static List<Funcionario> funcionarios = PrincipalFuncionario.getFuncionarios();
    public static void main(String[] args) {

        FileManager.carregarEntradas(entradas);
        FileManager.carregarPratros_principais(principais);
        FileManager.carregarSobremesa(sobremesas);
        FileManager.carregarFuncionario(funcionarios);

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opcao1 = -1;


        // Loop principal que permite ao usuário interagir com o sistema
        do {
            // Exibe o menu de opções
            System.out.println("[1]Acessar cardapio");
            System.out.println("[2]Acessar pedidos");
            System.out.println("[3]Acessar Funcionarios");
            System.out.println("[4]Sair");
            System.out.print("Opcao: ");
            opcao1 = scanner.nextInt();

            // Executa a opção escolhida pelo usuário
            switch (opcao1) {
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
                   PrincipalFuncionario.FuncionarioMenu();
                    break;
                case 4:
                // Mensagem avisando o fim do programa
                   System.out.println("Saindo...");
                   opcao1 = 4;
                    break;
                default:
                    break;
            }
        } while (opcao1 != 4); // Repete o loop enquanto a nao for 4
    }
}
