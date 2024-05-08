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

// Classe que define o menu do cardápio e suas funcionalidades
public class Cardapio {
    // Listas de itens do cardápio
    private static List<Entrada> entradas = new ArrayList<>();
    private static List<Prato_principal> principais = new ArrayList<>();
    private static List<Sobremesa> sobremesas = new ArrayList<>();

    // Métodos para retornar as listas de itens do cardápio
    public static List<Prato_principal> getPrincipais() {
        return principais;
    }

    public static List<Sobremesa> getSobremesas() {
        return sobremesas;
    }

    public static List<Entrada> getEntradas() {
        return entradas;
    }

    // Método para exibir o menu do cardápio
    public static void CardapioMenu() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            // Exibição do menu
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
                    // Edição das entradas do cardápio
                    Principal_entrada.EditarEntrada(entradas);
                    break;
                case 2:
                    // Edição dos pratos principais do cardápio
                    Principal_prato_principal.EditarPrincipal(principais);
                    break;
                case 3:
                    // Edição das sobremesas do cardápio
                    Principal_sobremesa.EditarSobremesa(sobremesas);
                    break;
                case 4:
                    // Listagem completa do cardápio
                    Listar_cardapio.MenuListagem(entradas, principais, sobremesas);
                    break;
                case 5:
                    // Busca por item específico
                    Busca.BuscarItem(entradas, principais, sobremesas);
                    break;
                case 6:
                    // Retorno ao menu principal
                    Index.main(null);
                    break;
                default:
                    System.out.println("Escolha uma opcao valida!");
                    break;
            }
        } while (opcao == 5);
    }
}
