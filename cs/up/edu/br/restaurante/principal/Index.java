package cs.up.edu.br.restaurante.principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.menus.cardapio.Cardapio;


public class Index {

    
    
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {

            System.out.println("[1]Acessar cardapio");
            System.out.println("[2]Acessar pedidos");
            System.out.println("[4]Acessar Funcionarios");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                       Cardapio.CardapioMenu();
                    break;
            
                default:
                    break;
            }
        } while (opcao == 0);
        scanner.close();
    }
}
