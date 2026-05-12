package java07;

abstract class Transporte {
    protected double valor;

    public Transporte (double valor){
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }

    public abstract double calcularFrete();
}


class Caminhao extends Transporte{

    public Caminhao (double valor){
        super(valor);
    }

    @Override
    public double calcularFrete(){
        return valor + 100; 
    }
}

class Moto extends Transporte{

    public Moto (double valor){
        super(valor);
    }

    @Override
    public double calcularFrete(){
        return valor + 20;
    }
}

class Drone extends Transporte{

    public Drone (double valor){
        super(valor);
    }

    @Override
    public double calcularFrete(){
        return valor + 50;
    }
}

public class Main4 {
    public static void main(String[] args) {
        
        Transporte caminhao = new Caminhao(500);
        Transporte moto = new Moto(600);
        Transporte drone = new Drone(150);

        System.out.println("Transporte de carro com frete: R$" + caminhao.calcularFrete());
        System.out.println("Transporte de moto com frete: R$" + moto.calcularFrete());
        System.out.println("Transporte de drone com frete: R$" + drone.calcularFrete());
       
    }
}
