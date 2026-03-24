public class Exercicio3 {//Cria a classe
    String marca;
    String modelo;
    double velocidade;

    void acelerar(){//Cria o metodo
        System.out.println("O carro está acelerando: " + marca + ", " + modelo + ", "+ velocidade + " km/h");
    }

    
    public static void main(String[] args) {
        //Instanciando a classe/carro
        Exercicio3 carro1 = new Exercicio3();
        Exercicio3 carro2 = new Exercicio3();

        //Criando objeto
        carro1.marca = "Toyota";
        carro1.modelo = "Corola"; 
        carro1.velocidade = 200;

        //Criando objeto
        carro2.marca = "Chevrolet";
        carro2.modelo = "Onix";
        carro2.velocidade = 150;

        //Chamando o metodo
        carro1.acelerar();
        carro2.acelerar();
    }
}
