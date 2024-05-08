package cs.up.edu.br.restaurante.menus.cardapio;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Prato_principal;

// Classe para editar os pratos principais do cardápio
public class Principal_prato_principal {
    
    // Método para editar os pratos principais do cardápio
    public static void EditarPrincipal(List<Prato_principal> principais){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
            
        int opcao = 0;

        // Menu de opções para edição dos pratos principais
        do {
            System.out.println();
            System.out.println("-----------------------------------");
            System.out.println("[1]Adicionar prato principal");
            System.out.println("[2]Remover prato principal");
            System.out.println("[3]Listar pratos principais");
            System.out.println("[4]voltar");
            System.out.print("opcao: ");
            opcao = scanner.nextInt();
            System.out.println("-----------------------------------");
            System.out.println();

            // Seleção da opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Adição de um novo prato principal
                    Prato_principal.CriaPrato_principal(principais);
                    break;
                case 2:
                    // Remoção de um prato principal existente
                    Prato_principal.RemovePrato_principal(principais);
                    break;
                case 3:
                    // Listagem de todos os pratos principais
                    Prato_principal.ListaPrato_principal(principais);
                    break;
                case 4:
                    // Retorno ao menu do cardápio
                    Cardapio.CardapioMenu();
                    break;
                default:
                    System.out.println("informe uma opção válida");
                    break;
            }
        } while (opcao != 4);
        
    }
}
