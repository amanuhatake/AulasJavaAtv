import java.util.ArrayList;
// Classe pai
class Produto {
    String nome;
    double preco;
}
// Classe filha
class ProdutoFisico extends Produto {
    double peso;
}

// Classe filha
class ProdutoDigital extends Produto {
    double tamanhoArquivo;
}

// Carrinho
class Carrinho {
    ArrayList<Produto> produtos = new ArrayList<>();
    void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.nome);
            System.out.println("Preço: R$ " + p.preco);

            // Verificando o tipo do produto
            if (p instanceof ProdutoFisico) {
                ProdutoFisico pf = (ProdutoFisico) p;
                System.out.println("Peso: " + pf.peso + " kg");
            }

            if (p instanceof ProdutoDigital) {
                ProdutoDigital pd = (ProdutoDigital) p;
                System.out.println("Tamanho: " + pd.tamanhoArquivo + " MB");
            }
            System.out.println("-------------------");
        }
    }

    void calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.preco;
        }
        System.out.println("Total da compra: R$ " + total);
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        ProdutoFisico p1 = new ProdutoFisico();
        p1.nome = "Notebook";
        p1.preco = 3000;
        p1.peso = 2.5;

        ProdutoDigital p2 = new ProdutoDigital();
        p2.nome = "Curso de Java";
        p2.preco = 200;
        p2.tamanhoArquivo = 1500;
        
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(p1);
        carrinho.adicionarProduto(p2);
        carrinho.listarProdutos();
        carrinho.calcularTotal();

    }

}
