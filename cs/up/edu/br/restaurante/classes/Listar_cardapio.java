package cs.up.edu.br.restaurante.classes;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;

// Classe responsável por listar o cardápio do restaurante
public class Listar_cardapio {

    // Método para exibir o menu de listagem do cardápio
    public static void MenuListagem(List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas){

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
    
        // Loop para manter o menu ativo até que o usuário escolha sair
        do {
            System.out.println("-----------------------------------");
            System.out.println("[1] Listar entradas");
            System.out.println("[2] Listar pratos principais");
            System.out.println("[3] Listar sobremesas");
            System.out.println("[4] Listar tudo");
            System.out.println("[5] Voltar");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            System.out.println("-----------------------------------");

            // Switch para executar a ação correspondente à escolha do usuário
            switch (opcao) {
                case 1:
                    Entrada.ListarEntrada(entradas);
                    break;
                case 2:
                    Prato_principal.ListaPrato_principal(principais);
                    break;
                case 3:
                    Sobremesa.ListarSobremesa(sobremesas);
                    break;
                case 4:
                    // Listar todos os itens do cardápio
                    Entrada.ListarEntrada(entradas);
                    System.out.println();
                    Prato_principal.ListaPrato_principal(principais);
                    System.out.println();
                    Sobremesa.ListarSobremesa(sobremesas);
                    System.out.println();
                    break;
                case 5:
                    // Voltar ao menu do cardápio principal
                    Cardapio.CardapioMenu();
                    break;
                default:
                    // Mensagem de erro para opção inválida
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("Escolha uma opcao valida!");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    break;
            }
        } while (opcao != 5); // O loop continua até que a opção de voltar seja escolhida
    }
}
