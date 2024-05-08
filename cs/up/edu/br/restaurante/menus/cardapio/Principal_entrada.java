package cs.up.edu.br.restaurante.menus.cardapio;

import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Entrada;

// Classe para editar as entradas do cardápio
public class Principal_entrada {
    
    // Método para editar as entradas do cardápio
    public static void EditarEntrada(List<Entrada> entradas) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;

        // Menu de opções para edição das entradas
        do {
            System.out.println("-----------------------------------");
            System.out.println("[1] Adicionar entrada");
            System.out.println("[2] Remover entrada");
            System.out.println("[3] Listar entradas");
            System.out.println("[4] Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            System.out.println("-----------------------------------");

            // Seleção da opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Adição de uma nova entrada
                    Entrada.Cria_entrada(entradas);
                    break;
                case 2:
                    // Remoção de uma entrada existente
                    Entrada.RemoveEntrada(entradas);
                    break;
                case 3:
                    // Listagem de todas as entradas
                    Entrada.ListarEntrada(entradas);
                    break;
                case 4:
                    // Retorno ao menu do cardápio
                    Cardapio.CardapioMenu();
                    break;
                default:
                    System.out.println("Informe uma opção válida");
                    break;
            }
        } while (opcao != 4);

    }
}
