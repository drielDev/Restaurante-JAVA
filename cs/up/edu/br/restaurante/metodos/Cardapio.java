package cs.up.edu.br.restaurante.metodos;

import java.util.Scanner;

public class Cardapio {
    public static void CardapioMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("[1]Editar Entradas");
            System.out.println("[2]Editar pratos principais");
            System.out.println("[3]Editar sobremesas");
            System.out.println("[0]Voltar");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
        } while (opcao == 0);
    }
}
