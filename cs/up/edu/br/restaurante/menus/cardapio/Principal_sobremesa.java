package cs.up.edu.br.restaurante.menus.cardapio;

import java.util.List;
import java.util.Scanner;


import cs.up.edu.br.restaurante.classes.Sobremesa;

public class Principal_sobremesa {
    public static void EditarSobremesa(List<Sobremesa> sobremesas){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
            
            int opcao = 0;

            do {
                System.out.println("-----------------------------------");
                System.out.println("[1]Adicionar sobremesa");
                System.out.println("[2]Remover sobremesa");
                System.out.println("[3]Listar sobremesas");
                System.out.println("[4]voltar");
                System.out.print("opcao: ");
                opcao = scanner.nextInt();
                System.out.println("-----------------------------------");

                switch (opcao) {
                    case 1:
                        Sobremesa.Cria_Sobremesa(sobremesas);
                        break;
                    case 2:
                        Sobremesa.RemoveSobremesa(sobremesas);
                        break;
                    case 3:
                        Sobremesa.ListarSobremesa(sobremesas);
                        break;
                    case 4:
                        Cardapio.CardapioMenu();
                        break;
                    default:
                    System.out.println("informe uma opção válida");
                        break;
                }
            } while (opcao != 4);
        
    }
}
