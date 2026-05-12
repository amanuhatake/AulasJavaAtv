package java08;

import java.util.ArrayList;

class Produto {
    private String nome;
    private double preco;

    final double IMPOSTO = 10;
    public Produto (String nome, double preco){
        this.nome = nome; 
        this.preco = preco;
    }
    
    public void calcularImposto(){
        double total = preco + (preco * IMPOSTO / 100);
        System.out.println("Produto: " + nome);
        System.out.println("Valor com imposto: R$ " + total);
    }
}

public class Main4 {
    public static void main(String[] args) {
        
        ArrayList<Produto> lista = new ArrayList<>();

        lista.add(new Produto("Monitor", 1200));
        lista.add(new Produto("Mouse", 200));
        lista.add(new Produto("Teclado", 500));

        for(Produto l:lista){
            l.calcularImposto();
            System.out.println("=======");
        }
    }
}
