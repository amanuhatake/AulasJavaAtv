public class Produto {
    String nome;
    double preco;
    int quantidade;

    void imprimir() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println(); // só pra separar a saída
    }

    public class Main {
    public static void main(String[] args) {
        // Criando objetos da classe Produto
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        // Preenchendo os dados do produto1
        produto1.nome = "Teclado";
        produto1.preco = 800;
        produto1.quantidade = 50;

        // Preenchendo os dados do produto2
        produto2.nome = "Monitor";
        produto2.preco = 2400;
        produto2.quantidade = 35;

        // Chamando métodos para imprimir informações
        produto1.imprimir();
        produto2.imprimir();
    }
}
}