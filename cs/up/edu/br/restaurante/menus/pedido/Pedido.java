package cs.up.edu.br.restaurante.menus.pedido;

import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.menus.cliente.Cliente;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private Cliente cliente;
    private Integer mesa;
    private List<Entrada> entrada;
    private List<Prato_principal> pratoPrincipal;
    private List<Sobremesa> sobremesa;
    private Double totalConta;

    public Pedido() {
        
    }

    public Pedido(Cliente cliente, Integer mesa, List<Entrada> entrada, List<Prato_principal> pratoPrincipal, List<Sobremesa> sobremesa) {
        this(cliente, mesa, entrada, pratoPrincipal, sobremesa, null);
    }

    public Pedido(Cliente cliente, Integer mesa, List<Entrada> entrada, List<Prato_principal> pratoPrincipal, List<Sobremesa> sobremesa, Double totalConta) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.entrada = entrada;
        this.pratoPrincipal = pratoPrincipal;
        this.sobremesa = sobremesa;
        this.totalConta = totalConta;
    }

    public Pedido(Cliente cliente, Integer mesa, Entrada entrada, Prato_principal pratoPrincipal, Sobremesa sobremesa, Double totalConta) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.entrada = new ArrayList<>();
        this.entrada.add(entrada);
        this.pratoPrincipal = new ArrayList<>();
        this.pratoPrincipal.add(pratoPrincipal);
        this.sobremesa = new ArrayList<>();
        this.sobremesa.add(sobremesa);
        this.totalConta = totalConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public List<Entrada> getEntrada() {
        return entrada;
    }

    public void setEntrada(List<Entrada> entrada) {
        this.entrada = entrada;
    }

    public List<Prato_principal> getPratoPrincipal() {
        return pratoPrincipal;
    }

    public void setPratoPrincipal(List<Prato_principal> pratoPrincipal) {
        this.pratoPrincipal = pratoPrincipal;
    }

    public List<Sobremesa> getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(List<Sobremesa> sobremesa) {
        this.sobremesa = sobremesa;
    }

    public Double getTotalConta() {
        return totalConta;
    }

    public void setTotalConta(Double totalConta) {
        this.totalConta = totalConta;
    }

    
    public static void adicionarPedido(List<Cliente>clientes, List<Pedido> pedidos, List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas){
        Scanner scanner = new Scanner(System.in);

        System.out.print("informe o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);

        System.out.print("informe a mesa do cliente: ");
        Integer mesa = scanner.nextInt();

        System.out.print("informe o prato de entrada (digite 0 caso nao queira): ");
        String entradaUsuario = scanner.next();
        Entrada entrada = null;
        int encontrou = 0;

        Double valorTotal = 0.0;

        while (!"0".equals(entradaUsuario)) {

            for (Entrada entrada2 : entradas) {     
                if (entrada2.getNome().equals(entradaUsuario)) {
        
                    Double preco = entrada2.getPreco();
                    valorTotal += preco;
        
                    entrada = entrada2;
        
                    encontrou = 1;
                    break;
                }
            }   
            if (entradaUsuario == "0") {
                encontrou = 1;
            }
            else if (encontrou == 0) {
                System.out.println("Entrada nao encontrada no cardapio!");
            } else {
                System.out.println("Entrada selecionada: " + entrada.getNome());
                entradaUsuario = "0";
            }
            if (entrada == null) {
                
                System.out.print("Informe o prato de entrada (digite 0 caso nao queira): ");
                entradaUsuario = scanner.next();
            }
        }
        
        if (entrada == null) {
            System.out.println("Nenhuma entrada selecionada.");
        }
        
        System.out.print("informe o prato principal (digite 0 caso nao queira): ");
        String principalUsuario = scanner.next();
        Prato_principal principal = null;

        encontrou = 0;

        while (principalUsuario != "0") {

            for (Prato_principal principal2 : principais) {     
                if (principal2.getNome().equals(principalUsuario)) {
        
                    Double preco = principal2.getPreco();
                    valorTotal += preco;
        
                    principal = principal2;
        
                    encontrou = 1;
                    break;
                }
            }   
            if (principalUsuario == "0") {
                encontrou = 1;
            }
            else if (encontrou == 0) {
                System.out.println("Prato principal nao encontrado no cardapio!");
            } else {
                System.out.println("Prato principal selecionado: " + principal.getNome());
                principalUsuario = "0";
            }
            if (principal == null) {
                
                System.out.print("Informe o prato principal (digite 0 caso nao queira): ");
                principalUsuario = scanner.next();
            }
        }
        
        if (principal == null) {
            System.out.println("Nenhum prato principal selecionado.");
        }

        System.out.print("informe a sobremesa (digite 0 caso nao queira): ");
        String sobremesaUsuario = scanner.next();
        Sobremesa sobremesa = null;

        encontrou = 0;

        while (!"0".equals(sobremesaUsuario)) {

            for (Sobremesa sobremesa2 : sobremesas) {     
                if (sobremesa2.getNome().equals(sobremesaUsuario)) {
        
                    Double preco = sobremesa2.getPreco();
                    valorTotal += preco;
        
                    sobremesa = sobremesa2;
        
                    encontrou = 1;
                    break;
                }
            }   
        
            if (encontrou == 0) {
                System.out.println("Sobremesa nao encontrada no cardapio!");
            } else {
                System.out.println("Sobremesa selecionada: " + sobremesa.getNome());
                sobremesaUsuario = "0";
            }
            if (sobremesa == null) {
                
                System.out.print("Informe a sobremesa (digite 0 caso nao queira): ");
                sobremesaUsuario = scanner.next();
            }
        }
        
        if (sobremesa == null) {
            System.out.println("Nenhuma sobremesa selecionada.");
        }

        System.out.println("________PEDIDO________ ");

        pedidos.add(new Pedido(cliente, mesa, entrada, principal, sobremesa, 2.9));
        
    
    }    
}
