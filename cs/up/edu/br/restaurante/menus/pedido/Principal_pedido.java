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

public class Principal_pedido {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Prato_principal> principais = Cardapio.getPrincipais();
    private static List<Sobremesa> sobremesas = Cardapio.getSobremesas();
    private static List<Entrada> entradas = Cardapio.getEntradas();


    public static void PedidoMenu(){
        if (entradas.isEmpty()) {
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

            do {
                System.out.println("-----------------------------------");
                System.out.println("[1]Adicionar pedido");
                System.out.println("[2]Remover pedido");
                System.out.println("[3]Listar pedidos");
                System.out.println("[4]Voltar");
                System.out.print("Opcao: ");
                opcao = scanner.nextInt();
                System.out.println("-----------------------------------");

                switch (opcao) {
                    case 1:
                       Pedido.adicionarPedido(clientes, pedidos, entradas, principais, sobremesas);
                        break;
                    case 2:
                        Pedido.RemovePedido(pedidos);
                        break;
                    case 3:
                        Pedido.ListarPedido(pedidos);
                        break;
                    case 4:
                        Index.main(null);
                        break;
                    default:
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("Escolha uma opcao valida!");
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        break;
                }
            } while (opcao == 5);
    }
}
