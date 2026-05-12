package java08;

public class Main {
    public static void main(String[] args) {
        final double PI = 3.14;

        System.out.println(PI);

        double raio = 10;

        PI = 10;

        double area = PI * raio * raio;

        System.out.println("Área do circulo: " + area);
    }
}
