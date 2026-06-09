package exercicio2.src.controller;
import exercicio2.src.model.Produto;

public class ProdutoController {

    public Produto cadastrar(String nome, double preco){
        return new Produto(nome, preco);
    }
}
