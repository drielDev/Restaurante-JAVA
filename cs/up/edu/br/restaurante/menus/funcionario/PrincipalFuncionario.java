package cs.up.edu.br.restaurante.menus.funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.classes.Funcionario;
import cs.up.edu.br.restaurante.principal.Index;

public class PrincipalFuncionario {

    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static void FuncionarioMenu(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
         int opcao = 0;
    
            // Menu de opções para edição das entradas
            do {
                System.out.println("-----------------------------------");
                System.out.println("[1] cadastrar funcionario");
                System.out.println("[2] Remover funcionario");
                System.out.println("[3] Listar funcionarios");
                System.out.println("[4] Voltar");
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                System.out.println("-----------------------------------");
    
                // Seleção da opção escolhida pelo usuário
                switch (opcao) {
                    case 1:
                        Funcionario.Cria_Funcionario(funcionarios);
                        break;
                    case 2:
                        Funcionario.RemoveFuncionarios(funcionarios);
                        break;
                    case 3:
                        Funcionario.Listarfuncionario(funcionarios);
                        break;
                    case 4:
                        Index.main(null);
                        break;
                    default:
                        System.out.println("Informe uma opção válida");
                        break;
                }
            } while (opcao != 4);
    }
    }
        

