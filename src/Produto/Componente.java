package Produto;

public class Componente extends Produto {
    private String tipoMaterial;
    private boolean importado;

    public Componente(String nome, float preco, String codigoLegado, String tipoMaterial, boolean importado) {
        super(nome, preco, codigoLegado);
        this.tipoMaterial = tipoMaterial;
        this.importado = importado;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public boolean isImportado() {
        return importado;
    }

    @Override
    public String getDetalhes() {
        return String.format("Nome: %s | Preço: %.2f | Código Legado: %s | Tipo Material: %s | Importado: %s",
                getNome(), getPreco(), getCodigoLegado(), tipoMaterial, importado ? "Sim" : "Não");
    }
}
