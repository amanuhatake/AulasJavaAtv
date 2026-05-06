package java07;
import java.util.ArrayList;

abstract class  Funcionario {
    protected double salario;

    public Funcionario (double salario){
        this.salario = salario;
    }

    public double getSalario(){
        return salario;
    }

    public abstract double calcularPreco();
}

class Gerente extends Funcionario {

    public Gerente (double salario){
        super(salario);
    }

    @Override
    public double calcularPreco(){
        return salario + 1000;
    }

}

class Desenvolvedor extends Funcionario{

    public Desenvolvedor(double salario){
        super(salario);
    }

    @Override
    public double calcularPreco(){
        return salario + 500;
    }
}

class Estagiario extends Funcionario {

    public Estagiario (double salario){
        super(salario);
    }

    @Override
    public double calcularPreco(){
        return salario;
    }
}

public class Main3 {
    public static void main(String[] args) {
        
        Funcionario gerente = new Gerente(8000);
        Funcionario desenvolvedor = new Desenvolvedor(15000);
        Funcionario estagiario = new Estagiario(1600);
        
        System.out.println("Gerente:\nSalario + Bônus: R$ " + gerente.calcularPreco());
        System.out.println("Desenvolvedor:\nSalario + Bônus: R$ " + desenvolvedor.calcularPreco());
        System.out.println("Estagiario:\nSalario + Bônus: R$ " + estagiario.calcularPreco());
       
    }
}
