import java.util.ArrayList;
// Classe pai
class Produto {
    public String nome;
    public double preco;

    // construtor, é chamado na classe filha
    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

// Classe filha
class ProdutoFisico extends Produto {
    double peso;

     //Chama o construtor da classe Pai.
    ProdutoFisico(String nome, double preco, double peso){
        super(nome, preco);
        this.peso = peso;
    }
}

// Classe filha
class ProdutoDigital extends Produto {
    double tamanhoArquivo;


    //chamando o construtor da classe Pai
    ProdutoDigital (String nome, double preco, double tamanhoArquivo){
        super(nome, preco); 
        this.tamanhoArquivo = tamanhoArquivo; 
    }
}

class Pedido {
    public String nome;
    public double Qntd;
    public int Npedido = 0;

    Pedido(String nome, double Qntd, int Npedido) {
        this.nome = nome;
        this.Qntd = Qntd;
        this.Npedido = Npedido;
    }

};

class Carrinho {
    ArrayList<Produto> produtos = new ArrayList<>();

    void adicionarProdutos(Produto produto) {// Adiciona produtos dentro o carrinho
        produtos.add(produto);
    }

    void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Produto p : produtos) { //foreach para -> Varrer o array 
            System.out.println("Nome: " + p.nome);
            System.out.println("Preço: R$ " + p.preco);
            // Verificando o tipo do produto
            // Como vai estar no mesmo array o instanceof ele verifica qual é o ProdutoFisico e ProdutoDigital
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
        for (Produto p : produtos) { // Para varrer o array 
            total += p.preco;
        }
        System.out.println("Total da compra: R$ " + total);
    }
}

public class EcommerceLoja {
    public static void main(String[] args) {

        ProdutoFisico p1 = new ProdutoFisico("Notebook", 3000, 2.5);
        ProdutoDigital p2 = new ProdutoDigital("Curso de Java", 500, 1500);
        Carrinho carrinho = new Carrinho();

    
        carrinho.adicionarProdutos(p1);
        carrinho.adicionarProdutos(p2);
        carrinho.listarProdutos();
        carrinho.calcularTotal();

    }

}
