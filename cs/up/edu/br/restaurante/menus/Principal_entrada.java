package cs.up.edu.br.restaurante.menus;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Entrada;

public class Principal_entrada {
    public static void EditarEntrada(List<Entrada> entradas) {
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;

        do {
            System.out.println("[1] Adicionar entrada");
            System.out.println("[2] Remover entrada");
            System.out.println("[3] Listar entradas");
            System.out.println("[4] Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Entrada.Cria_entrada(entradas);
                    break;
                case 2:
                    Entrada.RemoveEntrada(entradas);
                    break;
                case 3:
                    Entrada.ListarEntrada(entradas);
                    break;
                case 4:
                    Cardapio.CardapioMenu();
                    break;
                default:
                    System.out.println("Informe uma opção válida");
                    break;
            }
        } while (opcao != 4);

    }
}
