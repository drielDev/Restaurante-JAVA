package cs.up.edu.br.restaurante.menus.cliente;

public class Cliente implements Comparable<Cliente>{
    private String nome;

    public Cliente () { }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Cliente outroCliente) {
        return this.nome.compareTo(outroCliente.getNome());
    }

    
  
}
