package java09;
import java.util.ArrayList;
import java.util.Scanner;


class Cliente{

    private String nome;
    private int cpf;

    public Cliente (String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

     public String getNome() {
        return nome;
    }
}

class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void aplicarDesconto(double percentual) {
        this.preco = this.preco - (this.preco * percentual / 100);
    }

}

class ProdutoFisico extends Produto{

    double peso;

    public ProdutoFisico(double peso, String nome, double preco){
        super(nome, preco);
        this.peso = peso;
    }
}

class ProdutoDigital extends Produto {

    double tamanhoArquivo;

    public ProdutoDigital(String nome, double preco, double tamanhoArquivo) {
        super(nome, preco);
        this.tamanhoArquivo = tamanhoArquivo;
    }
}

abstract class ProdutoPromocional { ///continuar
    
    protected 

}


class Carrinho {
    private ArrayList<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (produto.getPreco() > 0) {
            produtos.add(produto);
        } else {
            System.out.println("Produto inválido não adicionado.");
        }
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;

    }

    public void mostrarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - R$ " + p.getPreco());
        }

    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

}

class Pedido {
    private Cliente cliente;
    private Carrinho carrinho;

    public Pedido(Cliente cliente, Carrinho carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void mostrarResumo() {
        System.out.println("===== RESUMO DO PEDIDO =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");
        carrinho.mostrarProdutos();
        System.out.println("Total: R$ " + carrinho.calcularTotal());
    }
}

public class Ecommerce {
    public class MeuEcommerce {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Cliente
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        // Produtos
        Produto p1 = new Produto("Notebook", 3000);
        Produto p2 = new Produto("Mouse", 100);
        Produto p3 = new Produto("Teclado", 200);

        // Aplicando desconto
        p1.aplicarDesconto(10);

        // Carrinho
        Carrinho carrinho = new Carrinho();

        // Menu de produtos
        boolean continuarComprando = true;

        while (continuarComprando) {
            System.out.println("\n===== MENU DE PRODUTOS =====");
            System.out.println("1 - Notebook - R$ " + p1.getPreco());
            System.out.println("2 - Mouse - R$ " + p2.getPreco());
            System.out.println("3 - Teclado - R$ " + p3.getPreco());
            System.out.println("4 - Remover produto do carrinho");
            System.out.println("5 - Aplicar desconto em um produto");
            System.out.println("0 - Finalizar compra");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    carrinho.adicionarProduto(p1);
                    System.out.println("Notebook adicionado ao carrinho!");
                    break;
                case 2:
                    carrinho.adicionarProduto(p2);
                    System.out.println("Mouse adicionado ao carrinho!");
                    break;
                case 3:
                    carrinho.adicionarProduto(p3);
                    System.out.println("Teclado adicionado ao carrinho!");
                    break;
                case 4:
                    System.out.println("Produtos no carrinho:");
                    carrinho.mostrarProdutos();
                    System.out.print("Digite o nome do produto a remover: ");
                    scanner.nextLine(); // Limpar buffer
                    String nomeRemover = scanner.nextLine();
                    boolean removido = false;

                    for (Produto p : carrinho.getProdutos()) {
                        if (p.getNome().equalsIgnoreCase(nomeRemover)) {
                            carrinho.removerProduto(p);
                            System.out.println("Produto removido do carrinho!");
                            removido = true;
                            break;
                        }
                    }

                    if (!removido) {
                        System.out.println("Produto não encontrado no carrinho.");
                    }
                    break;
                case 5:
                    System.out.println("Produtos disponíveis:");
                    System.out.println("1 - Notebook - R$ " + p1.getPreco());
                    System.out.println("2 - Mouse - R$ " + p2.getPreco());
                    System.out.println("3 - Teclado - R$ " + p3.getPreco());
                    System.out.print("Digite o nome do produto para aplicar desconto: ");
                    scanner.nextLine(); // Limpar buffer

                    String nomeDesconto = scanner.nextLine();
                    Produto produtoDesconto = null;

                    if (nomeDesconto.equalsIgnoreCase("Notebook")) {
                        produtoDesconto = p1;
                    } else if (nomeDesconto.equalsIgnoreCase("Mouse")) {
                        produtoDesconto = p2;
                    } else if (nomeDesconto.equalsIgnoreCase("Teclado")) {
                        produtoDesconto = p3;
                    }

                    if (produtoDesconto != null) {
                        System.out.print("Digite o percentual de desconto: ");
                        double percentual = scanner.nextDouble();
                        produtoDesconto.aplicarDesconto(percentual);
                        System.out.println("Desconto aplicado! Novo preço: R$ " + produtoDesconto.getPreco());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 0:
                    continuarComprando = false;
                    System.out.println("Finalizando compra...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        }
        scanner.nextLine(); // Limpar buffer

        // Pedido
        Pedido pedido = new Pedido(cliente, carrinho);

        // Resumo
        pedido.mostrarResumo();
        scanner.close();

    }

}
}
