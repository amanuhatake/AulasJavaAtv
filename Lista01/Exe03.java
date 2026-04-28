package Lista01;

import java.util.ArrayList;

class Produto{
    private String nome; 
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void exibirInfo(){
        System.out.println("=============");
        System.out.println("Produto: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("=============");
    }
}

public class Exe03 {
    public static void main(String[] args) {
        
        /*Produto[] produto = new Produto[3];

        produto[0] = new Produto("Mouse", 500, 5);
        produto[1] = new Produto("Monitos", 500, 5);
        produto[2] = new Produto("Mesa", 500, 5);*/

        ArrayList<Produto> produto = new ArrayList<>();

        produto.add(new Produto("Mouse", 50, 10));
        produto.add(new Produto("Teclado", 120, 5));
        produto.add(new Produto("Monitor", 900, 2));

        

        for(Produto a : produto){
            a.exibirInfo();
        }
    }
}
