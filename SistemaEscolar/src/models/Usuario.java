package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String login;
    private String senha;
    private int tentativasErradas;
    private boolean bloqueadoParaReset;
    private List<String> historicoSenhas; 

    // Construtor
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.tentativasErradas = 0;
        this.bloqueadoParaReset = false;
        this.historicoSenhas = new ArrayList<>();
        this.historicoSenhas.add(senha);
    }

   
    public boolean autenticar(String loginInformado, String senhaInformada) {
        if (this.bloqueadoParaReset) {
            System.out.println("Erro: Usuário bloqueado! Você precisa cadastrar uma nova senha.");
            return false;
        }

        if (this.login.equals(loginInformado) && this.senha.equals(senhaInformada)) {
            this.tentativasErradas = 0; 
            return true;
        } else {
            this.tentativasErradas++;
            System.out.println("Login ou senha incorretos! Tentativas: " + this.tentativasErradas + "/3");

            if (this.tentativasErradas >= 3) {
                this.bloqueadoParaReset = true;
                System.out.println("Limite de tentativas excedido! Usuário bloqueado para alteração de senha.");
            }
            return false;
        }
    }

   
    public boolean cadastrarNovaSenha(String novaSenha) {
        
        if (historicoSenhas.contains(novaSenha)) {
            System.out.println("Erro: A nova senha não pode ser igual a nenhuma das suas últimas 3 senhas!");
            return false;
        }

        
        this.senha = novaSenha;
        this.tentativasErradas = 0;   
        this.bloqueadoParaReset = false; 

        
        historicoSenhas.add(novaSenha);
        if (historicoSenhas.size() > 3) {
            historicoSenhas.remove(0); 
        }

        System.out.println("Senha alterada com sucesso!");
        return true;
    }

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isBloqueadoParaReset() {
        return bloqueadoParaReset;
    }

    public int getTentativasErradas() {
        return tentativasErradas;
    }

    
    @Override
    public String toString() {
        return "Usuário: " + login + " | Status: " + (bloqueadoParaReset ? "Bloqueado para Reset" : "Ativo");
    }
}