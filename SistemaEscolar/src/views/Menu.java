package views;

import controllers.Sistema;
import java.time.LocalDate;
import java.util.Scanner;
import models.Aluno;
import models.Chamada;
import models.Curso;
import models.Professor;
import models.Usuario;

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
                Usuario u = sistema.buscarUsuario(login);
                if (u != null && u.isBloqueadoParaReset()) {
                    boolean redefiniu = false;
                    while (!redefiniu) {
                        System.out.print("\nDigite a NOVA senha para redefinir: ");
                        String novaSenha = scanner.nextLine();
                        redefiniu = sistema.redefinirSenha(login, novaSenha);
                        if (!redefiniu) {
                            System.out.println("Tente novamente com uma senha diferente.");
                        }
                    }
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
            System.out.println("6 - Consultar Aluno");
            System.out.println("7 - Alterar Aluno");
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
                    case 6:
                        menuConsultarAluno();
                        break;
                    case 7:
                        menuAlterarAluno();
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

    private void menuConsultarAluno() {
        System.out.println("\n--- CONSULTA DE ALUNO ---");
        System.out.println("1 - Buscar por Nome");
        System.out.println("2 - Buscar por Matrícula");
        System.out.print("Escolha: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            Aluno aluno = sistema.buscarAlunoPorNome(nome);
            if (aluno != null)
                System.out.println(aluno);
            else
                System.out.println("Aluno não encontrado!");
        } else if (opcao == 2) {
            System.out.print("Digite a matrícula: ");
            String matricula = scanner.nextLine();
            Aluno aluno = sistema.buscarAlunoPorMatricula(matricula);
            if (aluno != null)
                System.out.println(aluno);
            else
                System.out.println("Aluno não encontrado!");
        }
    }

    private void menuCadastrarAluno() {
        System.out.println("\n--- CADASTRO DE ALUNO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

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

        if (sistema.getCursos().isEmpty()) {
            System.out.println("Aviso: Nenhum curso cadastrado. Aluno será cadastrado sem curso.");
            sistema.cadastrarAluno(new Aluno(nome, cpf, idade, matricula, null));
            return;
        }

        System.out.println("Escolha o Curso pelo número:");
        for (int i = 0; i < sistema.getCursos().size(); i++) {
            System.out.println(i + " - " + sistema.getCursos().get(i).getNomeCurso());
        }

        int indiceCurso = -1;
        while (indiceCurso < 0 || indiceCurso >= sistema.getCursos().size()) {
            System.out.print("Digite o número do curso: ");
            try {
                indiceCurso = Integer.parseInt(scanner.nextLine());
                if (indiceCurso < 0 || indiceCurso >= sistema.getCursos().size()) {
                    System.out.println("Erro: Índice inválido!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
            }
        }

        Curso cursoEscolhido = sistema.getCursos().get(indiceCurso);
        Aluno aluno = new Aluno(nome, cpf, idade, matricula, cursoEscolhido);
        sistema.cadastrarAluno(aluno);
    }

   private void menuAlterarAluno() {
    System.out.println("\n--- ALTERAR ALUNO ---");
    System.out.print("Digite a matrícula do aluno: ");
    String matricula = scanner.nextLine();

    Aluno aluno = sistema.buscarAlunoPorMatricula(matricula);
    if (aluno == null) {
        System.out.println("Aluno não encontrado!");
        return;
    }

    System.out.println("Aluno encontrado: " + aluno);
    System.out.println("\nO que deseja alterar?");
    System.out.println("1 - Nome");
    System.out.println("2 - Idade");
    System.out.println("3 - Curso");
    System.out.print("Escolha: ");
    int opcao = Integer.parseInt(scanner.nextLine());

    switch (opcao) {
        case 1:
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            sistema.alterarAluno(matricula, novoNome, aluno.getIdade(), aluno.getCurso());
            break;
        case 2:
            System.out.print("Nova idade: ");
            int novaIdade = Integer.parseInt(scanner.nextLine());
            sistema.alterarAluno(matricula, aluno.getNome(), novaIdade, aluno.getCurso());
            break;
        case 3:
            // igual ao cadastro de aluno - lista os cursos e deixa escolher
            if (sistema.getCursos().isEmpty()) {
                System.out.println("Nenhum curso cadastrado!");
                return;
            }
            for (int i = 0; i < sistema.getCursos().size(); i++) {
                System.out.println(i + " - " + sistema.getCursos().get(i).getNomeCurso());
            }
            System.out.print("Escolha o curso: ");
            int indiceCurso = Integer.parseInt(scanner.nextLine());
            sistema.alterarAluno(matricula, aluno.getNome(), aluno.getIdade(), sistema.getCursos().get(indiceCurso));
            break;
        default:
            System.out.println("Opção inválida!");
    }
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

        System.out.println("Escolha o Curso pelo número:");
        for (int i = 0; i < sistema.getCursos().size(); i++) {
            System.out.println(i + " - " + sistema.getCursos().get(i).getNomeCurso());
        }
        System.out.print("Nome do Curso: ");
        String nomeCurso = scanner.nextLine();

        System.out.println("Escolha o Professor Responsável pelo número:");
        for (int i = 0; i < sistema.getProfessors().size(); i++) {
            System.out.println(i + " - " + sistema.getProfessors().get(i).getNome());
        }

        // TRATAMENTO DE ERRO: Impede números inválidos ou letras ao escolher o
        // professor
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
        if (sistema.getAlunos().isEmpty())
            System.out.println("Nenhum aluno cadastrado.");
        for (Aluno a : sistema.getAlunos()) {
            a.gerarRelatorio();
        }

        System.out.println("\n[Lista de Professores Cadastrados]");
        if (sistema.getProfessors().isEmpty())
            System.out.println("Nenhum professor cadastrado.");
        for (Professor p : sistema.getProfessors()) {
            p.gerarRelatorio();
        }

        System.out.println("\n[Histórico de Chamadas Realizadas]");
        if (sistema.getChamadas().isEmpty())
            System.out.println("Nenhuma chamada realizada.");
        for (Chamada c : sistema.getChamadas()) {
            System.out.println(c.toString());
        }
    }
}