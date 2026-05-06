package java07;

abstract class Produto {//Classe Pai 

    public abstract double calcularPreco(); //representa algo incompleto 
}

class ProdutoFisico extends Produto { //Herança
    @Override
    public double calcularPreco(){ //implementa a regra aqui 
        return 10 + 20;
    }
}

class ProdutoDigital extends Produto { //Herança
    @Override
    public double calcularPreco(){//implementa a regra aqui 
        return 100;
    }
    
}

public class Main {
    public static void main(String [] args){

        Produto prod1 =  new ProdutoFisico();
        Produto prod2 = new ProdutoDigital();

        System.out.println(prod1.calcularPreco());
        System.out.println(prod2.calcularPreco());

    }
    
}
