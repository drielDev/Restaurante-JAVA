package cs.up.edu.br.restaurante.menus.pedido;

import cs.up.edu.br.restaurante.classes.Entrada;
import cs.up.edu.br.restaurante.classes.Prato_principal;
import cs.up.edu.br.restaurante.classes.Sobremesa;
import cs.up.edu.br.restaurante.menus.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

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

    
    public static void adicionarPedido(){
        
    }




    
}
