package models;

public class Produto {
    private String nome;
    private int quantidade;
    private int id;
    private String validade;
    private double preco;

    public Produto(){
        
    }

    public Produto(String nome,  int quantidade, String validade, double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.validade = validade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
