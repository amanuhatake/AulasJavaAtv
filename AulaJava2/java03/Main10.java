class Usuario{
    String nome;
    String email;
    String senha; 

    public Usuario (String nome, String email, String senha){

        if(senha.length() >=6){
            this.nome = nome;
            this.email = email;
            this.senha = senha; 
        }else{
            System.out.println("Senha conter 6 caracteres no mínimo");
        }
    }
}

public class Main10 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Maria","maria@email.com","123@#$");
        System.out.println("Nome: " + usuario.nome);
        System.out.println("Email: " + usuario.email);
        System.out.println("Senha: " + usuario.senha);
    }
}