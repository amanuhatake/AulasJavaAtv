class Pessoa{
    String nome;
    int idade;

    public Pessoa (String nome, int idade){ //construtor
        this.nome = nome;
        this.idade = idade;
    }
}



public class Main5{
    public static void main(String [] args){
        
        Pessoa p = new Pessoa ("Maria", 25);
        System.out.println(p.nome + "-"+ p.idade);
        
        
    }
}



