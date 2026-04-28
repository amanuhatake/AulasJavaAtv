/*Exercício 2 - Desenvolva uma hierarquia de classes representando animais, começando com uma classe
base Animal e subclasses como Mamifero, Ave e Peixe. */
package Lista01;

class Animal {
    private String nome;
    private int idade;
    private double peso;
    private String alimentacao;

    public Animal(String nome, int idade, double peso, String alimentacao) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.alimentacao = alimentacao;
    }

    public void exibirInfo() {
        System.out.println("======ANIMAIS=========");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Pedo: " + peso);
        System.out.println("Alimentacao: " + alimentacao);
    }
}

class Mamifero extends Animal {
    private String pelo;
    private boolean amamenta;

    public Mamifero(String nome, int idade, double peso, String alimentacao, String pelo, boolean amamenta) {
        super(nome, idade, peso, alimentacao);
        this.pelo = pelo;
        this.amamenta = amamenta;
    }
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Pelo: " + pelo);
        System.out.println("Amamenta: " + amamenta);
        System.out.println("============");
    }

}

class Peixe extends Animal {
    private String tipoAgua;
    private double tamanhoAquario;

    public Peixe(String nome, int idade, double peso, String alimentacao, String tipoAgua, double tamanhoAquario) {
        super(nome, idade, peso, alimentacao);
        this.tipoAgua = tipoAgua;
        this.tamanhoAquario = tamanhoAquario;
    }
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo de Água " + tipoAgua);
        System.out.println("Tamanho do Aquário " + tamanhoAquario);
        System.out.println("============");
    }
}

class Ave extends Animal{
    private String cor;
    private boolean voar;

    public Ave (String nome, int idade, double peso, String alimentacao, String cor, boolean voar){
        super(nome, idade, peso, alimentacao);
        this.cor = cor; 
        this.voar = voar;
    }
    @Override
     public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Cor: " + cor);
        System.out.println("Voa?: " + voar);
        System.out.println("============");
    }
}

public class Exe02 {
    public static void main(String[] args) {

        Mamifero mamifero = new Mamifero ("Chimpanzé", 50, 15.0, "Frutas", "Sim", true);
        Peixe peixe = new Peixe("Carpa", 5, 3.0, "Ração", "Doce", 5.5);
        Ave ave = new Ave("Arara", 5, 2.5, "Ração e Frutas", "Colorida", false);

        mamifero.exibirInfo();
        peixe.exibirInfo();
        ave.exibirInfo();
    }
}
