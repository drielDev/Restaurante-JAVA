package cs.up.edu.br.restaurante.menus.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;
import cs.up.edu.br.restaurante.menus.cliente.Cliente;
import cs.up.edu.br.restaurante.principal.Index;

/**
 * Esta classe representa o menu de pedidos do restaurante.
 */
public class Principal_pedido {
    
    // Listas de clientes, pedidos, pratos principais, sobremesas e entradas
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Prato_principal> principais = Cardapio.getPrincipais();
    private static List<Sobremesa> sobremesas = Cardapio.getSobremesas();
    private static List<Entrada> entradas = Cardapio.getEntradas();

    /**
     * Método que exibe o menu de pedidos e permite a interação do usuário.
     */
    public static void PedidoMenu(){
        // Verifica se as listas de entradas, pratos principais e sobremesas estão vazias
        if (entradas.isEmpty()) {
            // Se estiverem vazias, adiciona itens padrão
            entradas.add(new Entrada("pao", 2.99));
            entradas.add(new Entrada("biscoito", 1.99));  
        }
        if (principais.isEmpty()) {
            principais.add(new Prato_principal("lasanha", 20.0));
            principais.add(new Prato_principal("picanha", 50.0));
        }
        if (sobremesas.isEmpty()) {
            sobremesas.add(new Sobremesa("sorvete", 5.50));
            sobremesas.add(new Sobremesa("pudim", 10.50));
        }
            
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Loop principal que permite ao usuário interagir com o menu
        do {
            // Exibe as opções do menu
            System.out.println("-----------------------------------");
            System.out.println("[1]Adicionar pedido");
            System.out.println("[2]Remover pedido");
            System.out.println("[3]Listar pedidos");
            System.out.println("[4]Voltar");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            System.out.println("-----------------------------------");

            // Executa a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Adiciona um novo pedido
                    Pedido.adicionarPedido(clientes, pedidos, entradas, principais, sobremesas);
                    break;
                case 2:
                    // Remove um pedido existente
                    Pedido.RemovePedido(pedidos);
                    break;
                case 3:
                    // Lista todos os pedidos
                    Pedido.ListarPedido(pedidos);
                    break;
                case 4:
                    // Volta para o menu principal
                    Index.main(null);
                    break;
                default:
                    // Exibe uma mensagem de erro para opções inválidas
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("Escolha uma opcao valida!");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    break;
            }
        } while (opcao == 5); // Repete o loop enquanto a opção for 5
    }
}
