class Pessoa{

    private String nome;
    private int idade;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
    this.idade = idade;

    if(idade >= 0){
        this.idade = idade;
        System.out.println("A idade é: " + idade);
    }else{
        System.out.println("Idade Inválida!");
    }
}
}


public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setIdade(23);

        System.out.println(pessoa.getNome());
    }
}
