package cs.up.edu.br.restaurante.metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Entrada;

public class Principal_entrada {
    public static void EditarEntrada(){
        try (Scanner scanner = new Scanner(System.in)) {
            List<Entrada> entradas = new ArrayList<>();
            int opcao = 0;

            do {
                System.out.println("[1]Adicionar entrada");
                System.out.println("[2]Remover entrada");
                System.out.println("[3]Listar entradas");
                System.out.println("[4]voltar");
                System.out.print("opcao: ");
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
                    default:
                        break;
                }
            } while (opcao != 4);
        }
    }
}
