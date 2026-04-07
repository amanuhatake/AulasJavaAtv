
class Veiculo{
    String marca;
    String modelo;
}

class Carro extends Veiculo{
    int portas;
}

class Moto extends Veiculo{
    int cilindradas;
}


public class Main4 {
    public static void main(String[] args) {
        
       Carro carro1 = new Carro();

        carro1.marca = "Onix";
        carro1.modelo = "algum";
        carro1.portas = 4; 

        Moto moto1 = new Moto();

        moto1.marca = "Honda";
        moto1.modelo = "POP100";
        moto1.cilindradas = 1000;

        
        System.out.println("Marca: " + carro1.marca);
        System.out.println("Modelo: " + carro1.modelo);
        System.out.println("Portas: " + carro1.portas);

        System.out.println("Marca: " + moto1.marca);
        System.out.println("Modelo: " + moto1.modelo);
        System.out.println("Cilindro: " + moto1.cilindradas);
    }


}

