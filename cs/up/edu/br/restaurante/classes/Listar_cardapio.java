package cs.up.edu.br.restaurante.classes;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;

public class Listar_cardapio {
    public static void  MenuListagem(List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas){

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
    
            do {
                System.out.println("[1]Listar entradas");
                System.out.println("[2]Listar pratos principais");
                System.out.println("[3]Listar sobremesas");
                System.out.println("[4]Listar tudo");
                System.out.println("[5]Voltar");
                System.out.print("Opcao: ");
                opcao = scanner.nextInt();
    
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
                        System.out.println("________ENTRADAS________");
                        Entrada.ListarEntrada(entradas);
                        System.out.println("________PRINCIPAIS________");
                        Prato_principal.ListaPrato_principal(principais);
                        System.out.println("________SOBREMESAS________");
                        Sobremesa.ListarSobremesa(sobremesas);
                        break;
                    case 5:
                        Cardapio.CardapioMenu();
                        break;
                    default:
                    System.out.println("Escolha uma opcao valida!");
                        break;
                }
            } while (opcao != 5);
    }
}


