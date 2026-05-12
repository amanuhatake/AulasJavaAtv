package java08;

class ContaBancaria {
    private String titular; 
    private double saldo;

    final double TAXA = 2;

    public ContaBancaria(String titular, double saldo){
        this.titular = titular; 
        this.saldo = saldo;
    }
    
    public void sacar(double valor){
        if(saldo > valor + TAXA){ //verificação do saldo caso o valor seja inferior
        saldo -= valor;
        saldo -= TAXA;
        }else{
            System.out.println("Saldo insuficiente!");
        }

        System.out.println("Saldo: " + saldo);
    }
}

public class Main3 {
    public static void main(String[] args) {
        
        ContaBancaria conta = new ContaBancaria("Manu", 2);
        conta.sacar(100);
        
    }
}
