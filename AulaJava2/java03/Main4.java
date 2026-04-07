/*Crie uma classe Produto com:
– nome
– preco
• Se preço for negativo no construtor → mostrar
erro. */

class Produto {
    String nome;
    double preco;

    public Produto (String nome, double preco){
        this.nome = nome;
        if(preco < 0){
            System.out.println("Preço negativo ERRO");
            this.preco = 0; 
        }else {
            this.preco = preco;
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        Produto produto = new Produto("Monitor", -2);

        System.out.println("Nome da Produto " + produto.nome);
        System.out.println("Preco: " + produto.preco);
    }
}
