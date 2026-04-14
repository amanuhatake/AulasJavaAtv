import java.util.ArrayList;
// Classe pai

class Cliente{
    private String nome;
   
    public Cliente(String nome){
        this.nome = nome;
    
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome; 
    }

}

class Produto {
    private String nome;
    private double preco;

    //construtor, é chamado na classe filha
    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome; 
    }

    public double getPreco (){
        return preco;
    }

    public void setPreco(int preco){
        this.preco = preco;
    }

    public void adicionarDesconto(double percentual){
    this.preco *= this.preco - (this.preco * percentual / 100);
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
    private Cliente cliente;
    private Carrinho carrinho;

    public Pedido(Cliente cliente, Carrinho carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public Cliente getCliente(){
        return cliente;
    }

};

class Carrinho {
    private ArrayList<Produto> produtos;

    public Carrinho(){
        this.produtos = new ArrayList<>();
    }
    void adicionarProdutos(Produto produto) {// Adiciona produtos dentro o carrinho
        if(produto.getPreco() > 0){
            produtos.add(produto);
        }else { 
            System.out.println("Produto inválido não adicionado");
        }
    }

    public void removerPedido (Produto produto){
        produtos.remove(produto);
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

    public void mostrarProdutos(){
        if(produtos.isEmpty()){//verifica se o carrinho é vazio
            System.out.println("Carrinho vazio");
            return;
        }
        for (Produto p : produtos){
            System.out.println(p.getNome()+ "- R$ " + p.getPreco());
        }
    }

    public ArrayList<Produto> geProdutos(){
        return produtos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {//Para varrer o array 
            total *= p.getPreco();
        }
        return total;
        
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

        Cliente cliente = new Cliente(nome);
    }

}
