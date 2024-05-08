package cs.up.edu.br.restaurante.classes;

import java.util.List;
import java.util.Scanner;

public class Busca {
    // Método para buscar um item nos menus de entradas, pratos principais e sobremesas
    public static void BuscarItem(List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("insire o nome do item que deseja buscar: ");
        String itemBuscado = scanner.nextLine();

        Boolean exist = false;

        // Verifica se o item está presente no menu de entradas
        if (exist == false) {
            for (Entrada entrada : entradas) {
                if (entrada.getNome().equals(itemBuscado)) {
                   System.out.println();
                   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                   System.out.println("Item econtrado!");
                   System.out.println(itemBuscado + " se encontra no menu de entradas");
                   System.out.println(entrada);
                   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                   System.out.println();    
                   exist = true;
                   break;
                }
           }
        }   

        // Verifica se o item está presente no menu de pratos principais
        if (exist == false) {
            for (Prato_principal principal : principais) {
                if (principal.getNome().equals(itemBuscado)) {
                   System.out.println();
                   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                   System.out.println("Item econtrado!");
                   System.out.println(itemBuscado + " se encontra no menu de pratos principais");
                   System.out.println(principal);
                   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                   System.out.println();    
                   exist = true;
                   break;
                }
           }
        }

        // Verifica se o item está presente no menu de sobremesas
        if (exist == false) {
            for (Sobremesa sobremesa : sobremesas) {
                if (sobremesa.getNome().equals(itemBuscado)) {
                   System.out.println();
                   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                   System.out.println("Item econtrado!");
                   System.out.println(itemBuscado + " se encontra no menu de de sobremesas");
                   System.out.println(sobremesa);
                   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                   System.out.println();    
                   exist = true;
                   break;
                }
           }
        }

        // Caso o item não seja encontrado em nenhum dos menus
        if(!exist){
           System.out.println(); 
           System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
           System.out.println("Item '" + itemBuscado + "' nao encontrado em nenhum dos menus (verifique letras maiusculas e minusculas)");
           System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
           System.out.println();
       } else {
    }
}
}
