class Animal{
    String nome;
}

class Cachorro extends Animal{
    String raca;
}
public class Main3 {
    public static void main(String[] args) {
        Cachorro cachorro1 = new Cachorro();

        cachorro1.nome = "Magalu";
        cachorro1.raca = "Vira-lata";

        System.out.println("O nome do cachorro: " + cachorro1.nome);
        System.out.println("A raça é: " + cachorro1.raca);
    }
}
