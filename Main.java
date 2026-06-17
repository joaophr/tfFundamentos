import java.util.Scanner;

public class Main {
    public static Scanner teclado = new Scanner(System.in);
    public static Turma turmaGiraffa = new Turma(10);
    public static void main (String []Args) {
        boolean cont;
        turmaGiraffa.cadastrarPessoa("Marcos", "Porto Alegre", 20);
        System.out.print("\f");
        do{
            cont = menuDisplay();
        }while(cont);
    }

    public static boolean menuDisplay(){
        System.out.print("============================================\n" +
                "O que vai querer hoje?\n" + // quebra de linha em todas opções pra melhor visualização no código
                "1 - Cadastrar pessoa\n" +
                "2 - Modificar pessoa\n" +
                "3 - Cadastrar aluno\n" +
                "4 - Modificar Aluno\n" +
                "5 - Cadastrar bolsista de IC\n" +
                "6 - Modificar bolsista de IC\n" +
                "7 - Registrar acompanhamento do uso de IA\n" +
                "8 - Modificar acompanhamento do uso de IA\n" +
                "9 - Listar\n" + //perguntar: listar o que, pessoas, alunos, bolsistas...
                "10 - Mostrar nome mais longo\n" +
                "11 - Contar vogais nos nomes cadastrados\n" +
                "12 - Percentual de alunos por curso\n" +
                "13 - Média de idade dos alunos\n" +
                "14 - Criar ou atualizar lista de chamada\n" +
                "15 - Exibir lista de chamada\n" +
                "16 - Calcular risco pedagógico relacionado ao uso de IA\n" +
                "17 - Exibir relatório geral de risco por aluno\n" +
                "18 - Exibir alunos em risco alto\n" +
                "19 - Inovação do grupo\n" +
                "0 - Sair\n" +
                "> "
        );
        int menu = teclado.nextInt();
        teclado.nextLine();
        return menuOpcao(menu);
    }

    public static boolean menuOpcao(int x) {
        switch (x) {
            case 1:
                System.out.print("============================================\n");
                System.out.print("Digite o nome da pessoa que deseja cadastrar: ");
                String n = teclado.nextLine();
                System.out.print("Digite o lugar que a pessoa nasceu: ");
                String l = teclado.nextLine();
                System.out.print("Digite a idade da pessoa: ");
                int i = teclado.nextInt();
                turmaGiraffa.cadastrarPessoa(n, l, i);
                return true;

            case 2:
                System.out.print("============================================\n");
                System.out.println("Modificar pessoa");
                return true;

            case 3:
                System.out.print("============================================\n");
                Pessoa p;
                String c, m;
                int ano, s;
                char aux;
                boolean ic = false;

                System.out.print("Qual pessoa você deseja cadastrar como aluno?\n Digite o número correspondente a ele.");
                int nome;
                do {
                    turmaGiraffa.listarPessoas();
                    nome = teclado.nextInt();
                    p = turmaGiraffa.pessoaExiste(turmaGiraffa.pessoas[nome - 1].getNome());
                } while (p == null);
                System.out.print("O curso do aluno que deseja cadastrar: ");
                teclado.nextLine();
                c = teclado.nextLine();
                System.out.print("O número de matrícula do aluno que deseja cadastrar: ");
                m = teclado.nextLine();
                System.out.print("O ano que o aluno que você deseja cadastrar está na faculdade: ");
                ano = teclado.nextInt();
                System.out.print("O semestre que o aluno que você deseja cadastrar está na faculdade: ");
                s = teclado.nextInt();
                teclado.nextLine();
                do {
                    System.out.println("IC: (s/n)");
                    aux = teclado.nextLine().toLowerCase().charAt(0);
                    if (aux == 's') {
                        ic = true;
                    } else if (aux == 'n') {
                        ic = false;
                    }
                } while (aux != 's' && aux != 'n');
                turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[nome - 1], c, m, ano, s, ic);
                return true;

            case 4:
                System.out.print("============================================\n");
                System.out.println("Modificar aluno");
                return true;

            case 5:
                System.out.print("============================================\n");
                String pr, o;
                int aux2;
                System.out.println("Qual aluno você deseja cadastrar?\n Digite o número correspondente a ele.");
                do {
                    turmaGiraffa.listarAluno();
                    aux2 = teclado.nextInt();
                    if (turmaGiraffa.alunos[aux2 - 1].getEIc() == false) {
                        System.out.println("Esse aluno não é bolsista, não pode ser cadastrado.\n");
                        break;
                    }
                } while ((aux2 > turmaGiraffa.alunos.length) || (turmaGiraffa.alunos[aux2 - 1] == null));
                System.out.print("O nome do projeto que você deseja cadastrar: ");
                teclado.nextLine();
                pr = teclado.nextLine();
                System.out.print("O nome do orientador do aluno que você deseja cadastrar: ");
                o = teclado.nextLine();
                turmaGiraffa.cadastrarBolsistaIC(turmaGiraffa.alunos[aux2 - 1], pr, o);
                return true;

            case 6:
                System.out.print("============================================\n");
                System.out.println("Modificar bolsista de IC");
                return true;

            case 7:
                System.out.print("============================================\n");
                System.out.println("Registrar acompanhamento de IA");
                return true;

            case 8:
                System.out.print("============================================\n");
                System.out.println("Modificar acompanhamento de IA");
                return true;

            case 9:
                int y;
                System.out.print("============================================\n");
                System.out.println("Qual lista você deseja?\n" +
                        "1 - Pessoas\n" +
                        "2 - Alunos\n" +
                        "3 - Bolsistas\n" +
                        "4 - Sair");
                y = teclado.nextInt();
                switch (y) {
                    case 1:
                        turmaGiraffa.listarPessoas();

                    case 2:
                        turmaGiraffa.listarAluno();

                    case 3:
                        turmaGiraffa.listarBolsistas();

                    case 4:
                        System.out.println("Até mais!");
                        return true;
                    default:
                        System.out.println("Falso");
                    }
            case 10:
                System.out.print("============================================\n");
                System.out.println(turmaGiraffa.nomeLongo());
                return true;

            case 11:
                System.out.print("============================================\n");
                System.out.println("Contar vogais nos nomes cadastrados");
                return true;

            case 12:
                System.out.print("============================================\n");
                System.out.println("Percentual de alunos por curso");
                return true;

            case 13:
                System.out.print("============================================\n");
                System.out.println("Média de idade dos alunos");
                return true;

            case 14:
                System.out.print("============================================\n");
                System.out.println("Criar ou atualizar lista de chamada");
                return true;

            case 15:
                System.out.print("============================================\n");
                System.out.println("Exibir lista de chamada em ordem alfabética com nome, matrícula e curso");
                return true;

            case 16:
                System.out.print("============================================\n");
                System.out.println("Calcular risco pedagógico por IA");
                return true;

            case 17:
                System.out.print("============================================\n");
                System.out.println("Exibir relatório geral de risco por aluno");
                return true;

            case 18:
                System.out.print("============================================\n");
                System.out.println("Exibir alunos em risco alto");
                return true;

            case 19:
                System.out.print("============================================\n");
                System.out.println("Inovação do grupo");
                return true;

            case 0:
                System.out.println("Até mais");
                return false;

            default:
                System.out.println("Essa opção não existe, tente novamente!");
                return true;
        }
    }
}
//endregion