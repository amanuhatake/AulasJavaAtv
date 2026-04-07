/*Crie uma classe ContaBancaria com:
– titular
– saldo
• Construtor deve iniciar saldo com valor
informado */

class ContaBancaria {
    String titular;
    double saldo;

    public ContaBancaria (String titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
    }
    
}

class Main {
    public static void main(String[] args) {
        ContaBancaria p = new ContaBancaria("Manu",15000);
        System.out.println("Titular da conta: " + p.titular);
        System.out.println("Saldo da conta: " + p.saldo);
    }
}