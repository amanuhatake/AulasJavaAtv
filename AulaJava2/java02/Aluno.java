public class Aluno { //classe criada

        //ABSTRAÇÃO, representar apenas caracteristicas essenciais de um objeto, ignorando detalhes desncessários
        String nome;
        int idade;
        String curso; 
        String cpf;

        void apresentar(){ //este é o metodo e tem que ser chamado
            System.out.println("Meu nome é: " + nome);
            System.out.println("Minha idade é: " + idade);
            System.out.println("Meu curso é: " + curso);
            System.out.println("O número do meu CPF é: " + cpf);
        }

        void estudar(){// este é o metodo e tem que ser chamado
            System.out.println("O aluno está estudando!");
        }

        public static void main(String[] args) {

        //instanciou o objeto Aluno 
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();


        //Objeto real 1
        aluno1.nome ="Manu";
        aluno1.idade = 25;
        aluno1.curso = "ADS";
        aluno1.cpf = "123123123";

        //Objeto real 2
        aluno2.nome ="Joao";
        aluno2.idade = 24;
        aluno2.curso = "ADS";
        aluno2.cpf = "147147147";

        aluno1.apresentar();//retornando o metodo na main (imprime)
        aluno1.estudar();//retornando o metodo na main (imprime)
        
        aluno2.apresentar();//retornando o metodo na main (imprime)
        aluno2.estudar();//retornando o metodo na main (imprime)


    }
    }


    

