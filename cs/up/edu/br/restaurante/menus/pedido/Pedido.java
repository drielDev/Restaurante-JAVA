package cs.up.edu.br.restaurante.menus.pedido;

import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.menus.cliente.Cliente;

import java.util.ArrayList;
import java.util.Collections;
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
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("informe o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);

        System.out.print("informe a mesa do cliente: ");
        Integer mesa = scanner.nextInt();

        System.out.print("informe o prato de entrada (digite 'nao' caso nao queira): ");
        String entradaUsuario = scanner.next();
        System.out.println();
        Entrada entrada = null;
        int encontrou = 0;

        Double valorTotal = 0.0;

        while (!"nao".equals(entradaUsuario)) {

            for (Entrada entrada2 : entradas) {     
                if (entrada2.getNome().equals(entradaUsuario)) {
        
                    Double preco = entrada2.getPreco();
                    valorTotal += preco;
        
                    entrada = entrada2;
        
                    encontrou = 1;
                    break;
                }
            }   
            if (entradaUsuario == "nao") {
                encontrou = 1;
            }
            else if (encontrou == 0) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Entrada nao encontrada no cardapio!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Entrada selecionada: " + entrada.getNome());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                entradaUsuario = "nao";
            }
            if (entrada == null) {
                System.out.println();
                System.out.print("Informe o prato de entrada (digite 'nao' caso nao queira): ");
                entradaUsuario = scanner.next();
                System.out.println();
            }
        }
        
        if (entrada == null) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Nenhuma entrada selecionada.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.println();
        System.out.print("informe o prato principal (digite 'nao' caso nao queira): ");
        String principalUsuario = scanner.next();
        System.out.println();
        Prato_principal principal = null;

        encontrou = 0;

        while (!"nao".equals(principalUsuario)) {

            for (Prato_principal principal2 : principais) {     
                if (principal2.getNome().equals(principalUsuario)) {
        
                    Double preco = principal2.getPreco();
                    valorTotal += preco;
        
                    principal = principal2;
        
                    encontrou = 1;
                    break;
                }
            }   
            if (principalUsuario == "nao") {
                encontrou = 1;
            }
            else if (encontrou == 0) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Prato principal nao encontrado no cardapio!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Prato principal selecionado: " + principal.getNome());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                principalUsuario = "nao";
            }
            if (principal == null) {
                System.out.println();
                System.out.print("Informe o prato principal (digite 'nao' caso nao queira): ");
                principalUsuario = scanner.next();
                System.out.println();
            }
        }
        
        if (principal == null) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Nenhum prato principal selecionado.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        
        System.out.println();
        System.out.print("informe a sobremesa (digite 'nao' caso nao queira): ");
        String sobremesaUsuario = scanner.next();
        System.out.println();
        Sobremesa sobremesa = null;

        encontrou = 0;

        while (!"nao".equals(sobremesaUsuario)) {

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
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Sobremesa nao encontrada no cardapio!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Sobremesa selecionada: " + sobremesa.getNome());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
                sobremesaUsuario = "nao";
            }
            if (sobremesa == null) {
                System.out.println();
                System.out.print("Informe a sobremesa (digite 'nao' caso nao queira): ");
                sobremesaUsuario = scanner.next();
                System.out.println();
            }
        }
        
        if (sobremesa == null) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Nenhuma sobremesa selecionada.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            
        }

        System.out.println();
        System.out.println("_____________PEDIDO_____________ ");
        System.out.println("Nome: " + nome);
        System.out.println("Mesa: " + mesa);
        System.out.println("Entrada: " + entrada);
        System.out.println("Prato principal: " + principal);
        System.out.println("Sobremesa: " + sobremesa);
        System.out.println("Valor total a ser pago: " + valorTotal + "$ reais");
        System.out.println("_____________PEDIDO_____________ ");
        System.out.println();


        pedidos.add(new Pedido(cliente, mesa, entrada, principal, sobremesa, valorTotal));

        Principal_pedido.PedidoMenu();
        
    }    


    public static void ListarPedido(List<Pedido> pedidos){
        
        if (!pedidos.isEmpty()) {
            // Ordena a lista de entradas em ordem alfabética
            Collections.sort(pedidos, (e1, e2) -> e1.getCliente().compareTo(e2.getCliente()));
            
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        } else {
            System.out.println("Sem pedidos!");
        }

        Principal_pedido.PedidoMenu();
    }


    public static void RemovePedido(List<Pedido> pedidos) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome e sobrenome do cliente que deseja excluir o pedido: ");
        String exclui = scanner.nextLine();
    
        boolean encontrado = false;
    
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getCliente().getNome().equals(exclui)) {
                pedidos.remove(i);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Pedido para o cliente '" + exclui + "' não encontrado.");
        } else {
            System.out.println("Pedido excluído com sucesso!");
        }
        Principal_pedido.PedidoMenu();
    }




    @Override
    public String toString() {
        return "________PEDIDO________\n" +
        "Nome: " + cliente.getNome() + "\n" +
        "Mesa: " + mesa + "\n" +
        "Entrada: " + entrada + "\n" +
        "Prato principal: " + pratoPrincipal + "\n" +
        "Sobremesa: " + sobremesa + "\n" +
        "Valor total a ser pago: " + totalConta + "$\n";
    }

    
}