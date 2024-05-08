package cs.up.edu.br.restaurante.classes;

// Classe Comida
public class Comida {
    // Atributos da classe
    private String nome;
    private Double preco;

    // Construtor vazio
    public Comida(){ }

    // Construtor com parâmetros
    public Comida(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
