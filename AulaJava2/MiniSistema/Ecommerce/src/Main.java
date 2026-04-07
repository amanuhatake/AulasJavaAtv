
class Pessoa{
    String nome;
    int idade;
}

class Aluno extends Pessoa{ //classes e atributos que sao iguais, cadastro de pessoas, veiculos, classe animal. 
    String curso;
}

public class Main {

public static void main(String[] args) {
    
    Aluno aluno01 = new Aluno();

    aluno01.nome ="Ana";
    aluno01.idade = 20;
    aluno01.curso ="ADS";

    System.out.println(aluno01.nome);
    System.out.println(aluno01.idade);
    System.out.println(aluno01.curso);
}


}

