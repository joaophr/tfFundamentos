import java.util.Scanner;

public class Main {
    //Inicializando o teclado e a turma, objetos que iremos usar na classe inteira.
    public static Scanner teclado = new Scanner(System.in);
    public static Turma turmaGiraffa = new Turma(0);
    //Por que a turma está inicializada em 0? Cada vez que utilizamos o método cadastrarPessoa, ou qualquer outro cadastrar, o tamanho do array aumenta. Inicializando em 2, por exemplo, geraria espaços vazios que nunca seriam preenchidos. Basicamente, é um array "infinito", possibilitando a inserção de vários objetos.
   
    public static void main (String []Args) {
        boolean cont;

        //Pre-cadastros. 5 alunos, no mínimo 2 são bolsistas
        turmaGiraffa.cadastrarPessoa("Agustini", "Porto Alegre", 52);
        turmaGiraffa.cadastrarPessoa("Pedro", "Porto Alegre", 25);
        turmaGiraffa.cadastrarPessoa("Giraffa", "Tupanciretã", 70);
        turmaGiraffa.cadastrarPessoa("Joao", "Porto Alegre", 19);
        turmaGiraffa.cadastrarPessoa("Luigi", "Nova Araçá", 18);

        turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[0], "Ciência da Computação", "00001", 1983, 8, false);
        turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[1], "Ciência da Computação", "00002", 2018, 8, true);
        turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[2], "Ciência de Dados e Inteligência Artificial", "00003", 1975, 8, false);
        turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[3], "Ciência da Computação", "00004", 2026, 1, true);
        turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[4], "Ciência da Computação", "00005", 2026, 1, false);

        turmaGiraffa.cadastrarBolsistaIC(turmaGiraffa.alunos[1], "MALTA", "Lucas");
        turmaGiraffa.cadastrarBolsistaIC(turmaGiraffa.alunos[3], "Dados", "César");

        //menuDisplay marcado para sempre aparecer, exceto se a pessoa selecionar 0
        do{
            cont = menuDisplay();
        }while(cont);
    }

    //menuDisplay é a "interface gráfica", ele que printa todas as opções
    public static boolean menuDisplay(){
        System.out.print("============================================\n" +
                "O que vai querer hoje?\n" + // quebra de linha em todas opções pra melhor visualização no código
                "1 - Cadastrar pessoa\n" +
                "2 - Modificar pessoa\n" +
                "3 - Modificar aluno\n" +
                "ADICIONAR - Procurar aluno\n" + 
                "4 - Cadastrar bolsista de IC\n" +
                "5 - Modificar bolsista de IC\n" +
                "6 - Registrar acompanhamento do uso de IA\n" +
                "7 - Modificar acompanhamento do uso de IA\n" +
                "8 - Listar\n" + //perguntar: listar o que, pessoas, alunos, bolsistas...
                "9 - Mostrar nome mais longo\n" +
                "10 - Contar vogais nos nomes cadastrados\n" +
                "11 - Percentual de alunos por curso\n" +
                "12 - Média de idade dos alunos\n" +
                "13 - Criar ou atualizar lista de chamada\n" +
                "14 - Exibir lista de chamada\n" +
                "15 - Calcular risco pedagógico relacionado ao uso de IA\n" +
                "16 - Exibir relatório geral de risco por aluno\n" +
                "17 - Exibir alunos em risco alto\n" +
                "18 - Inovação do grupo\n" +
                "0 - Sair\n" +
                "> "
        );
        //Aqui é o sistema de seleção, retorna true em todos os casos, exceto 0
        int menu = teclado.nextInt();
        teclado.nextLine();
        return menuOpcao(menu);
    }

    //menuOpção é o método que chama todas as funções do programa. Ele roda a respectiva função e retorna true, para o programa continuar rodando
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
                teclado.nextLine();
                turmaGiraffa.cadastrarPessoa(n, l, i);
                String m, curso;
                int ano, s, c;
                char aux;
                boolean ic = false;
                System.out.print("============================================\n");
                System.out.print("Agora vamos cadastrar esta pessoa como aluno no nosso sistema.\n");
                //Decidimos limitar os cursos para facilitar o cálculo de média de cursos.
                System.out.print("O curso do aluno que deseja cadastrar:\n" +
                        "1 - Ciência da Computação\n" +
                        "2 - Engenharia de Software\n" +
                        "3 - Engenharia da Computação\n" +
                        "4 - Sistemas de Informação\n" +
                        "5 - Ciência de Dados e Inteligência Artificial\n" +
                        "> ");
                c = teclado.nextInt();
                switch (c) {
                    case 1:
                        curso = "Ciência da Computação";
                        break;
                    case 2:
                        curso = "Engenharia de Software";
                        break;
                    case 3:
                        curso = "Engenharia da Computação";
                        break;
                    case 4:
                        curso = "Sistemas de Informação";
                        break;
                    case 5:
                        curso = "Ciência de Dados e Inteligência Artificial";
                        break;
                    default:
                        System.out.println("Essa opção não existe!");
                        curso = "";
                        break;
                }
                System.out.print("O número de matrícula do aluno que deseja cadastrar: ");
                teclado.nextLine();
                m = teclado.nextLine();
                System.out.print("O ano que o aluno que você deseja cadastrar entrou na faculdade: ");
                ano = teclado.nextInt();
                teclado.nextLine();
                System.out.print("O semestre que o aluno que você deseja cadastrar está na faculdade: ");
                s = teclado.nextInt();
                teclado.nextLine();
                do {
                    System.out.println("Por acaso o aluno participa de um projeto de IC? (s/n)");
                    aux = teclado.nextLine().toLowerCase().charAt(0);
                    if (aux == 's') {
                        ic = true;
                    } else if (aux == 'n') {
                        ic = false;
                    }
                } while (aux != 's' && aux != 'n');
                turmaGiraffa.cadastrarAluno(turmaGiraffa.pessoas[turmaGiraffa.getQtdPessoas() - 1], curso, m, s, ano, ic);
                if (ic) {
                    System.out.print("============================================\n");
                    System.out.println("Notamos que o aluno cadastrado já está em algum projeto, vamos cadastrá-lo como bolsista.");
                    System.out.print("O nome do projeto que você deseja cadastrar: ");
                    String prAluno = teclado.nextLine();
                    System.out.print("O nome do orientador do aluno que você deseja cadastrar: ");
                    String orAluno = teclado.nextLine();
                    turmaGiraffa.cadastrarBolsistaIC(turmaGiraffa.alunos[turmaGiraffa.getQtdAlunos() - 1], prAluno, orAluno);
                }
                System.out.print("Muito obrigado pelo cadastro!\n");
                pausar();
                return true;
            case 2:
                System.out.print("============================================\n");
                Pessoa p2;
                int nomeM;
                System.out.print("Qual pessoa você deseja modificar?\n Digite o número correspondente a ela.\n");
                do {
                    turmaGiraffa.listarPessoas();
                    nomeM = teclado.nextInt();
                    teclado.nextLine();
                    p2 = turmaGiraffa.pessoaExiste(turmaGiraffa.pessoas[nomeM - 1].getNome());
                } while (p2 == null);
                System.out.print("Digite o novo nome da pessoa que deseja cadastrar: ");
                String novoN = teclado.nextLine();
                System.out.print("Digite o novo lugar que a pessoa nasceu: ");
                String novoL = teclado.nextLine();
                System.out.print("Digite a nova idade da pessoa: ");
                int novoI = teclado.nextInt();
                teclado.nextLine();
                turmaGiraffa.modificarPessoa(turmaGiraffa.pessoas[nomeM - 1], novoN, novoL, novoI);
                pausar();
                return true;
            case 3:
                System.out.print("============================================\n");
                Pessoa p3;
                int pessoaM;
                System.out.print("Qual aluno você deseja modificar?\nDigite o número correspondente a ele.\n");
                do {
                    turmaGiraffa.listarAluno();
                    pessoaM = teclado.nextInt();
                    teclado.nextLine();
                    p3 = turmaGiraffa.alunos[pessoaM - 1].getPessoa();
                } while (p3 == null);
                System.out.print("Digite o novo curso do aluno que deseja cadastrar: ");
                String novoC = teclado.nextLine();
                System.out.print("Digite a nova matrícula do aluno: ");
                String novoM = teclado.nextLine();
                System.out.print("Digite o novo ano que o aluno entrou na faculdade: ");
                int novoA = teclado.nextInt();
                teclado.nextLine();
                //turmaGiraffa.modificarAluno(turmaGiraffa.alunos[pessoaM - 1], novoC, novoM, novoA, novoS, novoIC);
                pausar();
                return true;
            case 4:
                System.out.print("============================================\n");
                String pr, o;
                int aux2;
                System.out.println("Qual aluno você deseja cadastrar?\n Digite o número correspondente a ele.");
                do {
                    turmaGiraffa.listarAluno();
                    aux2 = teclado.nextInt();
                    teclado.nextLine();
                    if (turmaGiraffa.alunos[aux2 - 1].getEIc() == false) {
                        System.out.println("Esse aluno não é bolsista, não pode ser cadastrado.\n");
                        break;
                    }
                } while ((aux2 > turmaGiraffa.alunos.length) || (turmaGiraffa.alunos[aux2 - 1] == null));
                System.out.print("O nome do projeto que você deseja cadastrar: ");
                pr = teclado.nextLine();
                System.out.print("O nome do orientador do aluno que você deseja cadastrar: ");
                o = teclado.nextLine();
                turmaGiraffa.cadastrarBolsistaIC(turmaGiraffa.alunos[aux2 - 1], pr, o);
                System.out.println("Muito obrigado pelo cadastro!\n");
                pausar();
                return true;
            case 5:
                System.out.print("============================================\n");
                System.out.println("Modificar bolsista de IC");
                pausar();
                return true;
            case 6:
                System.out.print("============================================\n");
                Aluno pAluno;
                int pAtivEntregue, pAtivIA, pAtivExplica, pCodigoMod, pCodigoExtra;
                System.out.print("Vamos registrar o uso de IA do aluno!\n");
                System.out.print("Primeiro, selecione qual aluno gostaria de registrar:");
                //Selecionar aluno
                System.out.print("Quantas atividades foram feitas sem o auxílio de IA: ");
                pAtivEntregue = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantas atividades foram realizadas com o auxílio de IA: ");
                pAtivIA = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantas atividades o aluno consegue explicar bem: ");
                pAtivExplica = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantos códigos o aluno consegue modificar: ");
                pCodigoMod = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantos códigos o aluno entregou com conteúdos extras, funções não estudadas: ");
                pCodigoExtra = teclado.nextInt();
                teclado.nextLine();

                //turmaGiraffa.registrarAcompanhamentoIA(pAluno, pAtivEntregue, pAtivIA, pAtivExplica, pCodigoMod, pCodigoExtra);
                pausar();
                return true;
            case 7:
                System.out.print("============================================\n");
                System.out.println("Modificar acompanhamento de IA");
                pausar();
                return true;
            case 8:
                int y;
                System.out.print("============================================\n");
                System.out.print("Qual lista você deseja?\n" +
                        "1 - Alunos\n" +
                        "2 - Bolsistas\n" +
                        "0 - Voltar\n" +
                        "> ");
                y = teclado.nextInt();
                teclado.nextLine();
                switch (y) {
                    case 1:
                        System.out.print("============================================\n");
                        System.out.print("Aqui estão os alunos cadastrados: \n");
                        turmaGiraffa.listarAluno();
                        break;
                    case 2:
                        System.out.print("============================================\n");
                        System.out.print("Aqui estão os alunos bolsistas cadastrados: \n");
                        turmaGiraffa.listarBolsistas();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Não existe essa opção");
                        break;
                    }
                pausar();
                return true;
            case 9:
                System.out.print("============================================\n");
                System.out.print("O nome mais longo é: ");
                System.out.print(turmaGiraffa.nomeLongo() + "\n");
                pausar();
                return true;
            case 10:
                System.out.print("============================================\n");
                System.out.print("A quantidade de vogais nos nomes dos alunos é: ");
                System.out.println(turmaGiraffa.contVogal());
                pausar();
                return true;
            case 11:
                System.out.print("============================================\n");
                if (turmaGiraffa.qtdAlunos == 0) {
                    System.out.println("Não existem alunos para ser calculado o percentual");
                }
                turmaGiraffa.qtdPorCurso();
                pausar();
                return true;
            case 12:
                System.out.print("============================================\n");
                if (turmaGiraffa.alunos.length == 0) {
                    System.out.println("Não existem alunos cadastrados, impossível fazer a média de idades.");
                    return true;
                }
                System.out.print("Aqui está a média de idade dos alunos: ");
                System.out.print(turmaGiraffa.mediaIdade() + "\n");
                pausar();
                return true;
            case 13:
                System.out.print("============================================\n");
                turmaGiraffa.criarAtualizarListaChamada();
                System.out.println("Lista de chamada criada/atualizada!");
                pausar();
                return true;
            case 14:
                System.out.print("============================================\n");
                System.out.println("Aqui está a chamada:");
                turmaGiraffa.exibirListaChamada();
                pausar();
                return true;
            case 15:
                System.out.print("============================================\n");
                System.out.println("Calcular risco pedagógico por IA");
                pausar();
                return true;
            case 16:
                System.out.print("============================================\n");
                System.out.println("Exibir relatório geral de risco por aluno");
                pausar();
                return true;
            case 17:
                System.out.print("============================================\n");
                System.out.println("Exibir alunos em risco alto");
                pausar();
                return true;
            case 18:
                System.out.print("============================================\n");
                System.out.println("Inovação do grupo");
                pausar();
                return true;
            case 0:
                System.out.print("============================================\n");
                System.out.println("Até mais");
                return false;
            default:
                System.out.print("============================================\n");
                System.out.println("Essa opção não existe, tente novamente!");
                pausar();
                return true;
        }
    }

    //No modelo que fizemos, o menuDisplay era chamado instantaneamente após a escolha. O método pausar serve pra dar tempo do usuário ler
    public static void pausar(){
        System.out.print("> Pressione Enter para voltar pro menu.");
        teclado.nextLine();
    }
}
