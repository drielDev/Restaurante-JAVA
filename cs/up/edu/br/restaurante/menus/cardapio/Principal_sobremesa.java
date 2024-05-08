package cs.up.edu.br.restaurante.menus.cardapio;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Sobremesa;

// Classe para editar as sobremesas do cardápio
public class Principal_sobremesa {
    
    // Método para editar as sobremesas do cardápio
    public static void EditarSobremesa(List<Sobremesa> sobremesas){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
            
        int opcao = 0;

        // Menu de opções para edição das sobremesas
        do {
            System.out.println("-----------------------------------");
            System.out.println("[1]Adicionar sobremesa");
            System.out.println("[2]Remover sobremesa");
            System.out.println("[3]Listar sobremesas");
            System.out.println("[4]voltar");
            System.out.print("opcao: ");
            opcao = scanner.nextInt();
            System.out.println("-----------------------------------");

            // Seleção da opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Adição de uma nova sobremesa
                    Sobremesa.Cria_Sobremesa(sobremesas);
                    break;
                case 2:
                    // Remoção de uma sobremesa existente
                    Sobremesa.RemoveSobremesa(sobremesas);
                    break;
                case 3:
                    // Listagem de todas as sobremesas
                    Sobremesa.ListarSobremesa(sobremesas);
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
