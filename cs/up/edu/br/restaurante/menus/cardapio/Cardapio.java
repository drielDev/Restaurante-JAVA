package cs.up.edu.br.restaurante.menus.cardapio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Busca;
import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Listar_cardapio;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.principal.Index;

public class Cardapio {
    private static List<Entrada> entradas = new ArrayList<>();
    private static List<Prato_principal> principais = new ArrayList<>();
    private static List<Sobremesa> sobremesas = new ArrayList<>();

    // Método para retornar a lista de pratos principais
    public static List<Prato_principal> getPrincipais() {
        return principais;
    }
    public static List<Sobremesa> getSobremesas() {
        return sobremesas;
    }
    public static List<Entrada> getEntradas() {
        return entradas;
    }

    public static void CardapioMenu(){
    
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
                System.out.println("-----------------------------------");;
                System.out.println("[1]Entradas");
                System.out.println("[2]pratos principais");
                System.out.println("[3]sobremesas");
                System.out.println("[4]Listagem de cardapio");
                System.out.println("[5]Procurar item especifico");
                System.out.println("[6]Voltar");
                System.out.print("Opcao: ");
                opcao = scanner.nextInt();
                System.out.println("-----------------------------------");

                switch (opcao) {
                    case 1:
                        Principal_entrada.EditarEntrada(entradas);
                        break;
                    case 2:
                        Principal_prato_principal.EditarPrincipal(principais);
                        break;
                    case 3:
                        Principal_sobremesa.EditarSobremesa(sobremesas);
                        break;
                    case 4:
                        Listar_cardapio.MenuListagem(entradas, principais, sobremesas);
                        break;
                    case 5:
                        Busca.BuscarItem(entradas, principais, sobremesas);
                        break;
                    case 6:
                        Index.main(null);
                        break;
                    default:
                        System.out.println("Escolha uma opcao valida!");
                        break;
                }
            } while (opcao == 5);
        
    }
}
