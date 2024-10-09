package Produto;

public abstract class Produto {
    private String nome;
    private float preco;
    private String codigoLegado;

    public Produto(String nome, float preco, String codigoLegado) {
        this.nome = nome;
        this.preco = preco;
        this.codigoLegado = codigoLegado;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getCodigoLegado() {
        return codigoLegado;
    }

    public abstract String getDetalhes();
}
