public class Exercicio2 {//Criando a classe

    String nome;
    double preco;
    int quantidade;

    void imprimir(){ //Metodo 
        System.out.println("Esses são os produtos:" + nome);
        System.out.println("Esses são os preço:" + preco);
        System.out.println("Essas são as quantidades:" + quantidade);
        System.out.println();
    }

    public static void main(String[] args) {
        //Instancia o produto 
        Exercicio2 produto1 = new Exercicio2();
        Exercicio2 produto2 = new Exercicio2();

        //Objetvo real 1
        produto1.nome = "Teclado";
        produto1.preco = 800;
        produto1.quantidade = 50;

        //Objetvo real 2
        produto2.nome = "Monitor";
        produto2.preco = 2400;
        produto2.quantidade = 35;

        produto1.imprimir(); //Chamando metodo 
        produto2.imprimir(); //Chamando metodo 
    }
}
