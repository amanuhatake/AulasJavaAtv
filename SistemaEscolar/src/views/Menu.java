package views;

import controllers.Sistema;
import java.time.LocalDate;
import java.util.Scanner;
import models.Aluno;
import models.Chamada;
import models.Curso;
import models.Professor;

public class Menu {
    private Sistema sistema;
    private Scanner scanner;

    public Menu() {
        this.sistema = new Sistema();
        this.scanner = new Scanner(System.in);
    }

    // Ponto de entrada do menu
    public void iniciar() {
        System.out.println("=======================================");
        System.out.println("  BEM-VINDO AO SISTEMA ESCOLAR POO     ");
        System.out.println("=======================================");
        
        executarMenuLogin();
        executarMenuPrincipal();
    }

    // Tela de Login obrigatória
    private void executarMenuLogin() {
        while (sistema.getUsuarioLogado() == null) {
            System.out.println("\n--- TELA DE LOGIN ---");
            System.out.print("Usuário: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            boolean logou = sistema.realizarLogin(login, senha);

            if (!logou) {
                if (login.equals("admin")) { 
                    System.out.print("\nSe você excedeu 3 tentativas, digite a NOVA senha para redefinir: ");
                    String novaSenha = scanner.nextLine();
                    // Espaço para a lógica de reset se necessário
                }
            }
        }
    }

    // Menu Principal com as opções solicitadas no PDF
    private void executarMenuPrincipal() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=======================================");
            System.out.println("            MENU PRINCIPAL             ");
            System.out.println("=======================================");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Curso ");
            System.out.println("4 - Registrar Chamada Diária");
            System.out.println("5 - Emitir Relatórios do Sistema");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        menuCadastrarAluno();
                        break;
                    case 2:
                        menuCadastrarProfessor();
                        break;
                    case 3:
                        menuCadastrarCurso();
                        break;
                    case 4:
                        menuRegistrarChamada();
                        break;
                    case 5:
                        menuRelatorios();
                        break;
                    case 0:
                        sistema.realizarLogout();
                        System.out.println("Obrigado por utilizar o sistema!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido para a opção.");
            }
        }
    }

    private void menuCadastrarAluno() {
        System.out.println("\n--- CADASTRO DE ALUNO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        // TRATAMENTO DE ERRO: Garante que a idade seja um número válido
        int idade = -1;
        while (idade <= 0) {
            System.out.print("Idade: ");
            try {
                idade = Integer.parseInt(scanner.nextLine());
                if (idade <= 0) {
                    System.out.println("Erro: A idade deve ser maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido para a idade.");
            }
        }

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Aluno aluno = new Aluno(nome, cpf, idade, matricula);
        sistema.cadastrarAluno(aluno);
    }

    private void menuCadastrarProfessor() {
        System.out.println("\n--- CADASTRO DE PROFESSOR ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        // TRATAMENTO DE ERRO: Garante que a idade seja um número válido
        int idade = -1;
        while (idade <= 0) {
            System.out.print("Idade: ");
            try {
                idade = Integer.parseInt(scanner.nextLine());
                if (idade <= 0) {
                    System.out.println("Erro: A idade deve ser maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido para a idade.");
            }
        }

        System.out.print("Disciplina: ");
        String disciplina = scanner.nextLine();

        Professor prof = new Professor(nome, cpf, idade, disciplina);
        sistema.cadastrarProfessor(prof);
    }

    private void menuCadastrarCurso() {
        System.out.println("\n--- CADASTRO DE CURSO ---");
        if (sistema.getProfessors().isEmpty()) {
            System.out.println("Erro: Cadastre pelo menos um professor antes de criar um curso.");
            return;
        }
        System.out.print("Nome do Curso: ");
        String nomeCurso = scanner.nextLine();
        
        System.out.println("Escolha o Professor Responsável pelo número:");
        for (int i = 0; i < sistema.getProfessors().size(); i++) {
            System.out.println(i + " - " + sistema.getProfessors().get(i).getNome());
        }
        
        // TRATAMENTO DE ERRO: Impede números inválidos ou letras ao escolher o professor
        int indiceProf = -1;
        while (indiceProf < 0 || indiceProf >= sistema.getProfessors().size()) {
            System.out.print("Digite o número do professor escolhido: ");
            try {
                indiceProf = Integer.parseInt(scanner.nextLine());
                if (indiceProf < 0 || indiceProf >= sistema.getProfessors().size()) {
                    System.out.println("Erro: Índice inválido! Escolha um número da lista acima.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido correspondente ao professor.");
            }
        }

        Professor profResponsavel = sistema.getProfessors().get(indiceProf);
        Curso curso = new Curso(nomeCurso, profResponsavel);
        sistema.cadastrarCurso(curso);
    }

    private void menuRegistrarChamada() {
        System.out.println("\n--- REGISTRO DE CHAMADA ---");
        if (sistema.getAlunos().isEmpty()) {
            System.out.println("Erro: Não há alunos cadastrados para realizar a chamada.");
            return;
        }

        Chamada chamada = new Chamada(LocalDate.now());

        for (Aluno aluno : sistema.getAlunos()) {
            String resposta = "";
            // TRATAMENTO DE ERRO: Força o usuário a digitar estritamente 'S' ou 'N'
            while (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
                System.out.print("O aluno " + aluno.getNome() + " está presente? (S/N): ");
                resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
                    System.out.println("Erro: Entrada inválida. Digite apenas 'S' para Sim ou 'N' para Não.");
                }
            }

            if (resposta.equalsIgnoreCase("S")) {
                chamada.registrarPresenca(aluno);
            } else {
                chamada.registrarAusencia(aluno);
            }
        }
        sistema.registrarChamada(chamada);
    }

    private void menuRelatorios() {
        System.out.println("\n=======================================");
        System.out.println("        RELATÓRIOS DO SISTEMA          ");
        System.out.println("=======================================");
        
        System.out.println("\n[Lista de Alunos Cadastrados]");
        if (sistema.getAlunos().isEmpty()) System.out.println("Nenhum aluno cadastrado.");
        for (Aluno a : sistema.getAlunos()) {
            a.gerarRelatorio(); 
        }

        System.out.println("\n[Lista de Professores Cadastrados]");
        if (sistema.getProfessors().isEmpty()) System.out.println("Nenhum professor cadastrado.");
        for (Professor p : sistema.getProfessors()) {
            p.gerarRelatorio(); 
        }

        System.out.println("\n[Histórico de Chamadas Realizadas]");
        if (sistema.getChamadas().isEmpty()) System.out.println("Nenhuma chamada realizada.");
        for (Chamada c : sistema.getChamadas()) {
            System.out.println(c.toString()); 
        }
    }
}