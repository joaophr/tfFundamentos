import java.util.*;

public class Main {
    public static Scanner teclado = new Scanner(System.in);

    public static void main (String []Args) {
        menuDisplay();
    }

    //region [Metodos de tratamento de dados]
    public static boolean serInt(String pergunta){
        try{
            System.out.println(pergunta);
            int x = teclado.nextInt();
            System.out.println("Verdadeiro");
            return true;
        }catch(InputMismatchException e){
            System.out.println("Falso");
            return false;
        }
    }

//endregion

//region [Metodos do Menu]

    public static void menuDisplay(){
        System.out.println("O que vai querer hoje?\n" + // quebra de linha em todas opções pra melhor visualização no código
                "1 - Cadastrar aluno\n" +
                "2 - Cadastrar bolsista de IC\n" +
                "3 - Registrar acompanhamento do uso de IA\n" +
                "4 - Listar todos os alunos\n" +
                "5 - Listar bolsistas de IC\n" +
                "6 - Mostrar nome mais longo\n" +
                "7 - Contar vogais nos nomes cadastrados\n" +
                "8 - Percentual de alunos por curso\n" +
                "9 - Média de idade dos alunos\n" +
                "10 - Criar ou atualizar lista de chamada\n" +
                "11 - Exibir lista de chamada\n" +
                "12 - Calcular risco pedagógico relacionado ao uso de IA\n" +
                "13 - Exibir relatório geral de risco por aluno\n" +
                "14 - Exibir alunos em risco alto\n" +
                "15 - Inovação do grupo\n" +
                "16 - Sair");
        int menu = teclado.nextInt();
        teclado.nextLine();
        menuOpcao(menu);
    }

    public static void menuOpcao(int x){
        switch (x){
            case 1:
                cadastrarAluno();
                break;

            case 2:
                cadastrarBolsistaIC();
                break;

            case 3:
                System.out.println("Registrar acompanhamento de IA");
                break;

            case 4:
                listarAlunos();
                break;

            case 5:
                System.out.println("Listar todos os bolsistas de IC");
                break;

            case 6:
                System.out.println("Mostrar nome mais longo");
                break;

            case 7:
                System.out.println("Contar vogais nos nomes cadastrados");
                break;

            case 8:
                System.out.println("Percentual de alunos por curso");
                break;

            case 9:
                System.out.println("Média de idade dos alunos");
                break;

            case 10:
                System.out.println("Criar ou atualizar lista de chamada");
                break;

            case 11:
                System.out.println("Exibir lista de chamada em ordem alfabética com nome, matrícula e curso");
                break;

            case 12:
                System.out.println("Calcular risco pedagógico por IA");
                break;

            case 13:
                System.out.println("Exibir relatório geral de risco por aluno");
                break;

            case 14:
                System.out.println("Exibir alunos em risco alto");
                break;

            case 15:
                System.out.println("Inovação do grupo");
                break;

            case 16:
                System.out.println("Até mais");
                break;

            default:
                System.out.println("Essa opção não existe, tente novamente!");
                menuDisplay();
        }
    }

    public static void listarAlunos(){
        System.out.println("Aqui está a lista de todos os alunos cadastrados: ");
        for (int i = 0; i < Aluno.qtdAlunos; i++) {
            System.out.println(i + "- " + Aluno.alunos[i]);
        }
    }

//endregion
    //region [Metodos Funções]

    public static void menuAlunos () {
        for (int i = 0; i < Aluno.qtdAlunos; i++) {
            System.out.print (i + " - " + Aluno.alunos[i]);
        }
    }

    public static void cadastrarAluno(){
        Pessoa a;
        String c, m, aux;
        int ano, s;
        boolean ic = false;

        System.out.print("Qual pessoa você deseja cadastrar como aluno? ");
        // usar menu pra escolher a pessoa
        // a = teclado.nextLine();
        System.out.print("O curso do aluno que deseja cadastrar: ");
        c = teclado.nextLine();
        System.out.print("O número de matrícula do aluno que deseja cadastrar: ");
        m = teclado.nextLine();
        System.out.print("O ano que o aluno que você deseja cadastrar está na faculdade: ");
        ano = teclado.nextInt();
        System.out.println("O semestre que o aluno que você deseja cadastrar está na faculdade: ");
        s = teclado.nextInt();
        System.out.println("O aluno que você deseja cadastrar é bolsista de Iniciação científica? (s/n) ");
        aux = teclado.nextLine().toLowerCase().strip();
        if (aux.equals("s")) {
            ic = true;
        } else if (aux.equals("n")) {
            ic = false;
        } else {
            System.out.println("Opção inválida, tente novamente!");
            cadastrarAluno();
        }

        Aluno aluno1 = new Aluno(a, c, m, ano, s, ic);
        // inserirAluno(aluno1);

        System.out.println("Muito obrigado pelo cadastro!\n");
        int aux2;
        do {
            System.out.println("Se você deseja voltar ao menu, digite 1, se você deseja sair digite 0.");
            aux2 = teclado.nextInt();
            if (aux2 == 1) {
                menuDisplay();
            }
            else if(aux2 == 0){
                System.out.println("Até mais");
                break;
            }
        } while (aux2 != 1);
    }
    public static void cadastrarBolsistaIC(){
        String p, o;
        int x;
        System.out.print("Qual aluno você deseja cadastrar?\n");
        menuAlunos();
        //x = teclado.nextInt();
        System.out.print("O nome do projeto que você deseja cadastrar: ");
        p = teclado.nextLine();
        System.out.print("O nome do orientador do aluno que você deseja cadastrar: ");
        o = teclado.nextLine();

        //AlunoBolsistaIC alunoIc1 = new AlunoBolsistaIC(x, p, o); // arrumar erro

        System.out.println("Muito obrigado pelo cadastro!\n");
        int aux;
        do {
            System.out.println("Se você deseja voltar ao menu, digite 1, se você deseja sair digite 0.");
            aux = teclado.nextInt();
            if (aux == 1) {
                menuDisplay();
            }
            else if(aux == 0){
                System.out.println("Até mais");
                break;
            }
        } while (aux != 1);
    }
}
//endregion