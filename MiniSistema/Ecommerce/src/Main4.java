
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

        Moto moto1 = new Carro();

        moto1.marca = "Honda";
        moto01.modelo = "POP100";
        moto01.cilindradas = 1000;

        
        System.out.println("Marca: " + veiculo1.nome);
        System.out.println("Modelo: " + veiculo1.modelo);
    }


    }
}
