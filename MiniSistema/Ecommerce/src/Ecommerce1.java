import java.util.ArrayList;

class Produto {
    public String nome;
    public double preco;
}

class Pedido {
    public String nome;
    public double Qntd;
    public int Npedido = 0;
    
};

class Carrinho {
    ArrayList<Produto>produtos = new ArrayList<>();

    void adicionarProdutos(Produto produto){
        produtos.add(produto);
    }

    void listarProdutos(){
        System.out.println("Produtos no caminho!");

        for(Produto p : produtos){
            System.out.println(p.nome + " - R$ " + p.preco);
        }
    }
    
    void calcularTotal1(){
        double total = 0;

        for(Produto p : produtos){
            total += p.preco;
        }

        System.out.println("Total da compra: R$ " + total);
    }
}



public class Ecommerce1 {
   public static void main(String[] args) {
    
    Produto p1 = new Produto();
    p1.nome = "Notebook";
    p1.preco = 3000;

    Produto p2 = new Produto();
    p2.nome = "Mouse";
    p2.preco = 200; 

    Carrinho carrinho = new Carrinho();

    
    carrinho.adicionarProdutos(p1);
    carrinho.adicionarProdutos(p2);
    carrinho.listarProdutos();
    carrinho.calcularTotal1();

   }

}

