package exercicio2.src.view;

import exercicio2.src.model.Produto;

public class ProdutoView {
    public void mostrarProduto(Produto produto){
        System.out.println(produto.getNome()+ " - R$" + produto.getPreco());
    }
}
