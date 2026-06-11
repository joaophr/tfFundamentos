import java.util.*;

public class Main {
    public static Scanner teclado = new Scanner(System.in);
    public static Turma turmaGiraffa = new Turma(10);
    public static void main (String []Args) {
        boolean cont;
        turmaGiraffa.cadastrarPessoa("marcos", "poa", 20);
        do{
            cont = menuDisplay();
        }while(cont);
    }

    public static boolean menuDisplay(){
        System.out.println("O que vai querer hoje?\n" + // quebra de linha em todas opções pra melhor visualização no código
                "1 - Cadastrar pessoa\n" +
                "2 - Modificar pessoa\n" +
                "3 - Cadastrar aluno\n" +
                "4 - Modificar Aluno\n" +
                "5 - Cadastrar bolsista de IC\n" +
                "6 - Modificar bolsista de IC\n" +
                "7 - Registrar acompanhamento do uso de IA\n" +
                "8 - Modificar acompanhamento do uso de IA\n" +
                "9 - Listar\n" + //perguntar: listar o que, pessoas, alunos, bolsistas...
                "10 - Listar bolsistas de IC\n" + //retirar esta opção
                "11 - Mostrar nome mais longo\n" +
                "12 - Contar vogais nos nomes cadastrados\n" +
                "13 - Percentual de alunos por curso\n" +
                "14 - Média de idade dos alunos\n" +
                "15 - Criar ou atualizar lista de chamada\n" +
                "16 - Exibir lista de chamada\n" +
                "17 - Calcular risco pedagógico relacionado ao uso de IA\n" +
                "18 - Exibir relatório geral de risco por aluno\n" +
                "19 - Exibir alunos em risco alto\n" +
                "20 - Inovação do grupo\n" +
                "0 - Sair");
        int menu = teclado.nextInt();
        teclado.nextLine();
        return menuOpcao(menu);
    }

    public static boolean menuOpcao(int x){
        switch(x){
            case 1:
                System.out.print("nome: ");
                String n = teclado.nextLine();
                System.out.print("local: ");
                String l = teclado.nextLine();
                System.out.print("idade: ");
                int i = teclado.nextInt();
                turmaGiraffa.cadastrarPessoa(n, l, i);
                return true;

            case 2:
                System.out.println("Modificar pessoa");
                return true;

            case 3:
                Pessoa p;
                String c, m;
                int ano, s;
                char aux;
                boolean ic = false;

                System.out.println("Qual pessoa você deseja cadastrar como aluno?\n Digite o número correspondente a ele.");
                int nome;
                do{
                    turmaGiraffa.listarPessoas();
                    nome = teclado.nextInt();
                    p = turmaGiraffa.pessoaExiste(turmaGiraffa.pessoas[nome - 1].getNome());
                }while(p == null);
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
                do{
                    System.out.println("IC: (s/n)");
                    aux = teclado.nextLine().toLowerCase().charAt(0);
                    if(aux == 's'){
                        ic = true;
                    }else if(aux == 'n'){
                        ic = false;
                    }
                }while(aux != 's' && aux != 'n');
                turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[nome - 1], c, m, ano, s, ic);
                return true;

            case 4:
                System.out.println("Modificar aluno");
                return true;

            case 5:
                turmaGiraffa.cadastrarBolsistaIC();
                return true;

            case 6:
                System.out.println("Modificar bolsista de IC");
                return true;

            case 7:
                System.out.println("Registrar acompanhamento de IA");
                return true;

            case 8:
                System.out.println("Modificar acompanhamento de IA");
                return true;

            case 9:
                turmaGiraffa.listarPessoas(); // ver se não ficaria melhor listar Alunos, pode ser pessoa mas pode não ser aluno
                return true;

            case 10:
                System.out.println("Listar todos os bolsistas de IC"); //tirar
                return true;

            case 11:
                System.out.println("Mostrar nome mais longo");
                return true;

            case 12:
                System.out.println("Contar vogais nos nomes cadastrados");
                return true;

            case 13:
                System.out.println("Percentual de alunos por curso");
                return true;

            case 14:
                System.out.println("Média de idade dos alunos");
                return true;

            case 15:
                System.out.println("Criar ou atualizar lista de chamada");
                return true;

            case 16:
                System.out.println("Exibir lista de chamada em ordem alfabética com nome, matrícula e curso");
                return true;

            case 17:
                System.out.println("Calcular risco pedagógico por IA");
                return true;

            case 18:
                System.out.println("Exibir relatório geral de risco por aluno");
                return true;

            case 19:
                System.out.println("Exibir alunos em risco alto");
                return true;

            case 20:
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