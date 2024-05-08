package cs.up.edu.br.restaurante.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import cs.up.edu.br.restaurante.menus.pedido.Principal_pedido;

public class Pedido {
    // Atributos da classe Pedido
    private Cliente cliente; // Cliente que fez o pedido
    private Integer mesa; // Número da mesa
    private List<Entrada> entrada; // Lista de itens de entrada
    private List<Prato_principal> pratoPrincipal; // Lista de pratos principais
    private List<Sobremesa> sobremesa; // Lista de sobremesas
    private Double totalConta; // Total a ser pago pelo pedido

    // Construtores da classe Pedido
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

    // Métodos getters e setters dos atributos
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



    
    // Este método adiciona um novo pedido com base nas informações fornecidas pelo usuário.

public static void adicionarPedido(List<Cliente>clientes, List<Pedido> pedidos, List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas){
    // Declaração do scanner para entrada de dados
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);

    // Solicitação do nome do cliente
    System.out.print("Informe o nome do cliente: ");
    String nome = scanner.nextLine();
    Cliente cliente = new Cliente(nome);

    // Solicitação do número da mesa
    System.out.print("Informe a mesa do cliente: ");
    Integer mesa = scanner.nextInt();

    // Solicitação do prato de entrada
    System.out.print("Informe o prato de entrada (digite 'nao' caso não queira): ");
    String entradaUsuario = scanner.next();
    System.out.println();
    Entrada entrada = null;
    int encontrou = 0;

    // Variável para armazenar o valor total do pedido
    Double valorTotal = 0.0;

    // Loop para selecionar o prato de entrada
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
        if (entradaUsuario.equals("nao")) {
            encontrou = 1;
        }
        else if (encontrou == 0) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Entrada não encontrada no cardápio!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Entrada selecionada: " + entrada.getNome());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            entradaUsuario = "nao";
        }
        if (entrada == null) {
            System.out.println();
            System.out.print("Informe o prato de entrada (digite 'nao' caso não queira): ");
            entradaUsuario = scanner.next();
            System.out.println();
        }
    }
    
    // Verifica se o usuário não selecionou nenhum prato de entrada
    if (entrada == null) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Nenhuma entrada selecionada.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Solicitação do prato principal
    System.out.println();
    System.out.print("Informe o prato principal (digite 'nao' caso não queira): ");
    String principalUsuario = scanner.next();
    System.out.println();
    Prato_principal principal = null;

    encontrou = 0;


       // Loop para selecionar o prato principal
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
    if (principalUsuario.equals("nao")) {
        encontrou = 1;
    }
    else if (encontrou == 0) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Prato principal não encontrado no cardápio!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    } else {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Prato principal selecionado: " + principal.getNome());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        principalUsuario = "nao";
    }
    if (principal == null) {
        System.out.println();
        System.out.print("Informe o prato principal (digite 'nao' caso não queira): ");
        principalUsuario = scanner.next();
        System.out.println();
    }
}

// Verifica se o usuário não selecionou nenhum prato principal
if (principal == null) {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Nenhum prato principal selecionado.");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}

// Solicitação da sobremesa
System.out.println();
System.out.print("Informe a sobremesa (digite 'nao' caso não queira): ");
String sobremesaUsuario = scanner.next();
System.out.println();
Sobremesa sobremesa = null;

encontrou = 0;

// Loop para selecionar a sobremesa
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
        System.out.println("Sobremesa não encontrada no cardápio!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    } else {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Sobremesa selecionada: " + sobremesa.getNome());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        sobremesaUsuario = "nao";
    }
    if (sobremesa == null) {
        System.out.println();
        System.out.print("Informe a sobremesa (digite 'nao' caso não queira): ");
        sobremesaUsuario = scanner.next();
        System.out.println();
    }
}

// Verifica se o usuário não selecionou nenhuma sobremesa
if (sobremesa == null) {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Nenhuma sobremesa selecionada.");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}

// Exibe o resumo do pedido
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

// Adiciona o pedido à lista de pedidos
pedidos.add(new Pedido(cliente, mesa, entrada, principal, sobremesa, valorTotal));

// Retorna ao menu principal
Principal_pedido.PedidoMenu();
}


   // Método para listar os pedidos
public static void ListarPedido(List<Pedido> pedidos){
    // Verifica se há pedidos na lista
    if (!pedidos.isEmpty()) {
        // Ordena os pedidos por nome do cliente
        Collections.sort(pedidos, (e1, e2) -> e1.getCliente().compareTo(e2.getCliente()));
        
        // Exibe os pedidos ordenados
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    } else {
        // Caso não haja pedidos na lista, exibe uma mensagem
        System.out.println("Sem pedidos!");
    }
    // Retorna ao menu principal
    Principal_pedido.PedidoMenu();
}

// Método para remover um pedido da lista
public static void RemovePedido(List<Pedido> pedidos) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe o nome e sobrenome do cliente que deseja excluir o pedido: ");
    String exclui = scanner.nextLine();

    boolean encontrado = false;

    // Percorre a lista de pedidos
    for (int i = 0; i < pedidos.size(); i++) {
        Pedido pedido = pedidos.get(i);
        // Verifica se o cliente do pedido atual é igual ao nome informado para exclusão
        if (pedido.getCliente().getNome().equals(exclui)) {
            // Remove o pedido da lista
            pedidos.remove(i);
            encontrado = true;
            break;
        }
    }
    
    // Verifica se o pedido foi encontrado e removido
    if (!encontrado) {
        System.out.println("Pedido para o cliente '" + exclui + "' não encontrado.");
    } else {
        System.out.println("Pedido excluído com sucesso!");
    }
    // Retorna ao menu principal
    Principal_pedido.PedidoMenu();
}

// Sobrescrita do método toString para exibir os detalhes do pedido
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