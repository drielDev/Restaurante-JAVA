package cs.up.edu.br.restaurante.classes;

// Classe Cliente representa um cliente do restaurante
public class Cliente implements Comparable<Cliente> {
    private String nome;

    // Construtores
    public Cliente() { }

    public Cliente(String nome) {
        this.nome = nome;
    }

    // Getters e setters para o nome do cliente
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método compareTo para comparar clientes com base em seus nomes
    @Override
    public int compareTo(Cliente outroCliente) {
        return this.nome.compareTo(outroCliente.getNome());
    }
}
