/*Exercício 1 - Crie uma classe Veiculo com atributos como modelo e ano. 
Em seguida, crie duas subclasses, Carro e Moto, que herdam de Veiculo, 
cada um deve possuir pelo menos 2 atributos e um metodo a mais.*/
package Lista01;

class Veiculo {
    private String modelo;
    private int ano;

    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public void exibirInfo() {
        System.out.println("Modelo: " + modelo);
        System.err.println("Ano: " + ano);
    }

}

class Carro extends Veiculo {
    private String cor;
    private int numPortas;

    public Carro(String modelo, int ano, String cor, int numPortas) {
        super(modelo, ano);
        this.cor = cor;
        this.numPortas = numPortas;
    }

    public String getCor() {
        return cor;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void exibirDados1() {
        System.out.println("===================");
        super.exibirInfo();
        System.out.println("Cor: " + cor);
        System.out.println("Número de portas: " + numPortas);
        System.out.println("=====================");
    }
}

class Moto extends Veiculo {
    private int cilindradas;
    private String tipo;

    public Moto(String modelo, int ano, int cilindradas, String tipo) {
        super(modelo, ano);
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }

    /*public int getCilindradas() {
        return cilindradas;
    }

    public String getTipo() {
        return tipo;
    }*/

    public void exibirDados2() {
        super.exibirInfo();
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("Tipo: " + tipo);
        System.out.println("=====================");
    }
}

public class Exe01 {
    public static void main(String[] args) {
        Carro carro = new Carro("Civic", 2025, "Branco", 4);
        Moto moto = new Moto("Biz", 2025, 3000, "Biz");

        carro.exibirDados1();
        moto.exibirDados2();
    }
}