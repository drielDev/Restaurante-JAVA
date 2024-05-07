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
            
        clientes.add(new Cliente("adriel"));
        clientes.add(new Cliente("dri"));

        Cliente adriel = clientes.get(0);
        Prato_principal lasanha = principais.get(0);
        Sobremesa sorvete = sobremesas.get(0);

        pedidos.add(new Pedido(adriel, 123, null, lasanha, sorvete, 25.50));

        Scanner scanner = new Scanner(System.in);
            int opcao = -1;

            do {
                System.out.println("[1]Adicionar pedido");
                System.out.println("[2]Remover pedido");
                System.out.println("[3]Listar pedidos");
                System.out.println("[4]Listagem de cardapio");
                System.out.println("[5]Voltar");
                System.out.print("Opcao: ");
                opcao = scanner.nextInt();

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
                        
                        break;
                    case 5:
                        Index.main(null);
                        break;
                    default:
                        System.out.println("Escolha uma opcao valida!");
                        break;
                }
            } while (opcao == 5);
    }
}
