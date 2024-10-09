package Produto;

public class ProdutoAcabado extends Produto {
    private int garantia;
    private int quantidadePorPalete;

    public ProdutoAcabado(String nome, float preco, String codigoLegado, int garantia, int quantidadePorPalete) {
        super(nome, preco, codigoLegado);
        this.garantia = garantia;
        this.quantidadePorPalete = quantidadePorPalete;
    }

    public int getGarantia() {
        return garantia;
    }

    public int getQuantidadePorPalete() {
        return quantidadePorPalete;
    }

    @Override
    public String getDetalhes() {
        return String.format("Nome: %s | Preço: %.2f | Código Legado: %s | Garantia: %d meses | Quantidade por Palete: %d",
                getNome(), getPreco(), getCodigoLegado(), garantia, quantidadePorPalete);
    }
}
