/*Enunciado
• Crie uma classe Usuario com:
– nome
– email
– senha
• Construtor deve:
– validar senha com pelo menos 6 caracteres */
import java.util.Scanner;
class Usuario{
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        if(senha.length() >= 6){
            System.out.println("Senha Válida!");
            this.senha = senha;
        }else{
            System.out.println("================");
            System.out.println("Senha muito curta");
            this.senha = "";
        }
    }

    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        if(senha.length() >=6){
            this.senha = senha;
        }else {
            System.out.println("Favor informar senha Válida!");
        }
    }

    public void exibirUsuario(){
        System.out.println("=====================");
        System.out.println("Nome do Usuario: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Senha cadastrada: " + senha);
        System.out.println("======================");
    }

}
public class Exercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine(); 

        System.out.println("Digite seu e-mail: ");
        String email = entrada.nextLine(); 

        System.out.println("Digite sua senha de no mínimo 6 caracteres: ");
        String senha = entrada.nextLine();

        Usuario usuario = new Usuario(nome, email, senha);

        usuario.exibirUsuario();
        entrada.close();


    }
}
