package cs.up.edu.br.restaurante.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Listar_cardapio;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.principal.Index;

public class Cardapio {
    private static List<Entrada> entradas = new ArrayList<>();
    private static List<Prato_principal> principais = new ArrayList<>();
    private static List<Sobremesa> sobremesas = new ArrayList<>();
    
    public static void CardapioMenu(){
        
        
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = -1;

            do {
                System.out.println("[1]Entradas");
                System.out.println("[2]pratos principais");
                System.out.println("[3]sobremesas");
                System.out.println("[4]Listagem de cardapio");
                System.out.println("[5]Voltar");
                System.out.print("Opcao: ");
                opcao = scanner.nextInt();

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
                        Index.main(null);
                        break;
                    default:
                        break;
                }
            } while (opcao == 5);
        }
    }
}
