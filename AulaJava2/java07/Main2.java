package java07;

import java.util.ArrayList;

abstract class Pagamento {

    protected double preco;

    public Pagamento(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return preco;
    }

    public abstract double processarPagamento();
} 

class Cartao extends Pagamento{
    
    public Cartao (double preco){
        super(preco);
    }

    @Override
    public double processarPagamento(){
        System.out.print("Cartao: R$ ");
        return preco * 0.5;
    }
}

class Pix extends Pagamento{
    public Pix (double preco){
        super(preco);
    }
   
    @Override
    public double processarPagamento(){
        System.out.print("Pix: R$ ");
        return preco;
    }

}


class Boleto extends Pagamento{

    public Boleto (double preco) {
        super(preco);
    }

    @Override
    public double processarPagamento(){
        System.out.print("Boleto: R$ ");
        return preco + 2;
    }
}

public class Main2 {
  public static void main(String[] args) {
      
    ArrayList<Pagamento> lista = new ArrayList<>();

    lista.add(new Cartao(100));
    lista.add(new Pix(50));
    lista.add(new Boleto(200));

    for(Pagamento p : lista){
        System.out.println(p.getPreco() + "\nTotal com taxas:" + p.processarPagamento());
        System.out.println("=================");
    }
  }
}
