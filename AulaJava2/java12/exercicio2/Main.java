package exercicio2;

import exercicio2.src.controller.ProdutoController;
import exercicio2.src.view.ProdutoView;
import exercicio2.src.model.Produto;

public class Main {
    public static void main(String[] args) {
        ProdutoController controller = new ProdutoController();
        ProdutoView view = new ProdutoView();

        Produto produto = controller.cadastrar("Mouse", 2);
    }
}
