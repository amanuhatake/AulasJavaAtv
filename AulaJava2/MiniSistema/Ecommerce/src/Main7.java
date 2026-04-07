class Carro {
    public String marca;
    public String modelo;

    public Carro() {

    }

    

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}

public class Main7 {
    public static void main(String[] args) {
        
        Carro car = new Carro("Tesla", "Model 3");

        System.out.println("A marca do carro é: " + car.marca);
        System.out.println("O modelo do carro é: " + car.modelo);

        
    }
}
