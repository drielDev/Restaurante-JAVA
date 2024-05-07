package cs.up.edu.br.restaurante.classes;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;

public class Listar_cardapio {
    public static void  MenuListagem(List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas){

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
    
            do {
                System.out.println("-----------------------------------");
                System.out.println("[1]Listar entradas");
                System.out.println("[2]Listar pratos principais");
                System.out.println("[3]Listar sobremesas");
                System.out.println("[4]Listar tudo");
                System.out.println("[5]Voltar");
                System.out.print("Opcao: ");
                opcao = scanner.nextInt();
                System.out.println("-----------------------------------");

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

                        Entrada.ListarEntrada(entradas);
                        System.out.println();
 
                        Prato_principal.ListaPrato_principal(principais);
                        System.out.println();

                        Sobremesa.ListarSobremesa(sobremesas);
                        System.out.println();
                        break;
                    case 5:
                        Cardapio.CardapioMenu();
                        break;
                    default:
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("Escolha uma opcao valida!");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        break;
                }
            } while (opcao != 5);
    }
}


