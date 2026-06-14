package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String login;
    private String senha;
    private int tentativasErradas;
    private boolean bloqueadoParaReset;
    private List<String> historicoSenhas; // Guarda as últimas 3 senhas

    // Construtor
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.tentativasErradas = 0;
        this.bloqueadoParaReset = false;
        this.historicoSenhas = new ArrayList<>();
        // Adiciona a senha inicial ao histórico
        this.historicoSenhas.add(senha);
    }

    // Regra de Negócio: Autenticação de Login
    public boolean autenticar(String loginInformado, String senhaInformada) {
        if (this.bloqueadoParaReset) {
            System.out.println("Erro: Usuário bloqueado! Você precisa cadastrar uma nova senha.");
            return false;
        }

        if (this.login.equals(loginInformado) && this.senha.equals(senhaInformada)) {
            this.tentativasErradas = 0; // Reseta as tentativas se acertar
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

    // Regra de Negócio: Alterar/Resetar Senha
    public boolean cadastrarNovaSenha(String novaSenha) {
        // Verifica se a nova senha já está no histórico das últimas 3
        if (historicoSenhas.contains(novaSenha)) {
            System.out.println("Erro: A nova senha não pode ser igual a nenhuma das suas últimas 3 senhas!");
            return false;
        }

        // Se passar na validação, atualiza a senha atual
        this.senha = novaSenha;
        this.tentativasErradas = 0;   // Reseta o contador de erros
        this.bloqueadoParaReset = false; // Desbloqueia o usuário

        // Gerencia o histórico para manter apenas as últimas 3 senhas
        historicoSenhas.add(novaSenha);
        if (historicoSenhas.size() > 3) {
            historicoSenhas.remove(0); // Remove a mais antiga se passar de 3
        }

        System.out.println("Senha alterada com sucesso!");
        return true;
    }

    // Getters e Setters básicos
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

    // toString() obrigatório pelo PDF
    @Override
    public String toString() {
        return "Usuário: " + login + " | Status: " + (bloqueadoParaReset ? "Bloqueado para Reset" : "Ativo");
    }
}