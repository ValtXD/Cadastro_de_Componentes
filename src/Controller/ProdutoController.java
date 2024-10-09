package Controller;

import Produto.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> listaProdutos;

    public ProdutoController() {
        listaProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return listaProdutos;
    }
}
