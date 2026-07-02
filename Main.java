import java.util.Scanner;

public class Main {
    //Inicializando o teclado e a turma, objetos que iremos usar na classe inteira.
    public static Scanner teclado = new Scanner(System.in);
    public static Turma turmaGiraffa = new Turma(0);
    static String professor; // Usamos varíavel global porque contribui para o funcionamento do sistema, sendo ele de uso único por disciplina.
    static String disciplina;
    //Por que a turma está inicializada em 0? Cada vez que utilizamos o método cadastrarPessoa, ou qualquer outro cadastrar, o tamanho do array aumenta. Inicializando em 2, por exemplo, geraria espaços vazios que nunca seriam preenchidos. Basicamente, é um array "infinito", possibilitando a inserção de vários objetos.
   
    public static void main (String[] Args) {
        boolean cont;

        System.out.println("Seja bem vindo ao nosso programa!");
        System.out.print("Primeiro vamos fazer o seu cadastro, professor/a, qual é o seu nome? \n> ");
        professor = teclado.nextLine();
        System.out.print("Qual é a disciplina que o senhor/a quer cadastrar nesse aplicativo? \n> ");
        disciplina = teclado.nextLine();

        //Pré-cadastros. 5 alunos, no mínimo 2 são bolsistas
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
                "4 - Procurar aluno\n" + 
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
                "16 - Exibir relatório geral de risco por aluno\n" +
                "17 - Exibir alunos em risco alto\n" +
                "18 - Aconselhamento individual\n" +
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
                System.out.print("Digite o nome da pessoa que deseja cadastrar: \n> ");
                String n = teclado.nextLine();
                System.out.print("Digite o lugar que a pessoa nasceu: \n> ");
                String l = teclado.nextLine();
                System.out.print("Digite a idade da pessoa: \n> ");
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
                do {
                    System.out.print("O número de matrícula do aluno que deseja cadastrar: \n> ");
                    teclado.nextLine();
                    m = teclado.nextLine();
                } while (turmaGiraffa.matriculaExiste(m));
                System.out.print("O ano que o aluno que você deseja cadastrar entrou na faculdade: \n> ");
                ano = teclado.nextInt();
                teclado.nextLine();
                System.out.print("O semestre que o aluno que você deseja cadastrar está na faculdade: \n> ");
                s = teclado.nextInt();
                teclado.nextLine();
                do {
                    System.out.println("Por acaso o aluno participa de um projeto de IC? (s/n) \n> ");
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
                    System.out.print("O nome do projeto que você deseja cadastrar: \n> ");
                    String prAluno = teclado.nextLine();
                    System.out.print("O nome do orientador do aluno que você deseja cadastrar: \n> ");
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
                System.out.print("Qual pessoa você deseja modificar?\n Digite o número correspondente a ela.\n> ");
                do {
                    turmaGiraffa.listarPessoas();
                    System.out.println("> ");
                    nomeM = teclado.nextInt();
                    teclado.nextLine();
                    p2 = turmaGiraffa.pessoaExiste(turmaGiraffa.pessoas[nomeM - 1].getNome());
                } while (p2 == null);
                System.out.print("Digite o novo nome da pessoa que deseja cadastrar: \n> ");
                String novoN = teclado.nextLine();
                System.out.print("Digite o novo lugar que a pessoa nasceu: \n> ");
                String novoL = teclado.nextLine();
                System.out.print("Digite a nova idade da pessoa: \n> ");
                int novoI = teclado.nextInt();
                teclado.nextLine();
                turmaGiraffa.modificarPessoa(turmaGiraffa.pessoas[nomeM - 1], novoN, novoL, novoI);
                pausar();
                return true;
            case 3:
                System.out.print("============================================\n");
                Pessoa p3;
                int pessoaM;
                String novoC;
                boolean novoIC = false;
                System.out.print("Qual aluno você deseja modificar?\nDigite o número correspondente a ele.\n> ");
                do {
                    turmaGiraffa.listarAluno();
                    System.out.println("> ");
                    pessoaM = teclado.nextInt();
                    teclado.nextLine();
                    p3 = turmaGiraffa.alunos[pessoaM - 1].getPessoa();
                } while (p3 == null);
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
                        novoC = "Ciência da Computação";
                        break;
                    case 2:
                        novoC = "Engenharia de Software";
                        break;
                    case 3:
                        novoC = "Engenharia da Computação";
                        break;
                    case 4:
                        novoC = "Sistemas de Informação";
                        break;
                    case 5:
                        novoC = "Ciência de Dados e Inteligência Artificial";
                        break;
                    default:
                        System.out.println("Essa opção não existe!");
                        novoC = "";
                        break;
                }
                System.out.print("Digite a nova matrícula do aluno: \n> ");
                teclado.nextLine();
                String novoM = teclado.nextLine();
                System.out.print("Digite o novo ano que o aluno entrou na faculdade: \n> ");
                int novoA = teclado.nextInt();
                teclado.nextLine();
                System.out.print("Digite o novo semestre que o aluno entrou na faculdade: \n> ");
                int novoS = teclado.nextInt();
                teclado.nextLine();
                do {
                    System.out.println("Por acaso o aluno começou a participar de algum projeto de IC? (s/n) \n> ");
                    aux = teclado.nextLine().toLowerCase().charAt(0);
                    if (aux == 's') {
                        novoIC = true;
                    } else if (aux == 'n') {
                        novoIC = false;
                    }
                } while (aux != 's' && aux != 'n');
                if (novoIC) {
                    System.out.print("============================================\n");
                    System.out.println("Notamos que o aluno cadastrado entrou em algum projeto, vamos cadastrá-lo como bolsista.");
                    System.out.print("O nome do projeto que você deseja cadastrar: \n> ");
                    String prAluno = teclado.nextLine();
                    System.out.print("O nome do orientador do aluno que você deseja cadastrar: \n> ");
                    String orAluno = teclado.nextLine();
                    turmaGiraffa.cadastrarBolsistaIC(turmaGiraffa.alunos[pessoaM - 1], prAluno, orAluno);
                }
                System.out.print("Muito obrigado pelo cadastro!\n");
                turmaGiraffa.modificarAluno(turmaGiraffa.alunos[pessoaM - 1], novoC, novoM, novoS, novoA, novoIC);
                pausar();
                return true;

            case 4:
                String matric = "";
                System.out.print("============================================\n");
                System.out.print("Por favor, digite a matrícula que gostaria de checar. \n> ");
                matric = teclado.nextLine();
                turmaGiraffa.alunoExiste(matric);
                pausar();
                return true;
            case 5:
                System.out.print("============================================\n");
                String pr, o;
                int aux2;
                System.out.println("Qual aluno você deseja cadastrar?\n Digite o número correspondente a ele. \n> ");
                do {
                    turmaGiraffa.listarAluno();
                    System.out.println("> ");
                    aux2 = teclado.nextInt();
                    teclado.nextLine();
                    if (turmaGiraffa.alunos[aux2 - 1].getEIc() == false) {
                        System.out.println("Esse aluno não é bolsista, não pode ser cadastrado.\n");
                        break;
                    }
                } while ((aux2 > turmaGiraffa.alunos.length) || (turmaGiraffa.alunos[aux2 - 1] == null));
                System.out.print("O nome do projeto que você deseja cadastrar: \n> ");
                pr = teclado.nextLine();
                System.out.print("O nome do orientador do aluno que você deseja cadastrar: \n> ");
                o = teclado.nextLine();
                turmaGiraffa.cadastrarBolsistaIC(turmaGiraffa.alunos[aux2 - 1], pr, o);
                System.out.println("Muito obrigado pelo cadastro!\n");
                pausar();
                return true;
            case 6:
                System.out.print("============================================\n");
                int b;
                AlunoBolsistaIC b1;
                String p, ori;
                System.out.print("Qual Bolsista você deseja modificar?\nDigite o número correspondente a ele.\n> ");
                do {
                    turmaGiraffa.listarBolsistas();
                    b = teclado.nextInt();
                    teclado.nextLine();
                    b1 = turmaGiraffa.bolsistas[b - 1];
                } while (b1 == null);
                System.out.print("O nome do novo projeto que você deseja cadastrar: \n> ");
                p = teclado.nextLine();
                System.out.print("O nome do novo orientador que você deseja cadastrar: \n> ");
                ori = teclado.nextLine();
                turmaGiraffa.modificarBolsistaIC(b1, p, ori);
                System.out.println("Bolsista modificado com sucesso!\n");
                pausar();
                return true;
            case 7:
                System.out.print("============================================\n");
                Aluno pAluno;
                int alunoM;
                int pAtivEntregue, pAtivIA, pAtivExplica, pCodigoMod, pCodigoExtra;
                System.out.print("Vamos registrar o uso de IA do aluno!\n");
                System.out.print("Primeiro, selecione qual aluno gostaria de registrar:\n> ");
                do {
                    turmaGiraffa.listarAluno();
                    System.out.println("> ");
                    alunoM = teclado.nextInt();
                    teclado.nextLine();
                    pAluno = turmaGiraffa.alunos[alunoM - 1];
                } while (pAluno == null);
                System.out.print("Quantas atividades foram feitas sem o auxílio de IA: \n> ");
                pAtivEntregue = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantas atividades foram realizadas com o auxílio de IA: \n> ");
                pAtivIA = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantas atividades o aluno consegue explicar bem: \n> ");
                pAtivExplica = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantos códigos o aluno consegue modificar: \n> ");
                pCodigoMod = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantos códigos o aluno entregou com conteúdos extras, funções não estudadas: \n> ");
                pCodigoExtra = teclado.nextInt();
                teclado.nextLine();

                turmaGiraffa.registrarAcompanhamentoIA(pAluno, pAtivEntregue, pAtivIA, pAtivExplica, pCodigoMod, pCodigoExtra);
                pausar();
                return true;
            case 8:
                System.out.print("============================================\n");
                AcompanhamentoIA no;
                int numA, numEn, numI, numEx, numCM, numCE;
                System.out.print("Primeiro, selecione qual aluno gostaria de modificar:\n");
                do {
                    turmaGiraffa.listarRegistros();
                    System.out.println("> ");
                    numA = teclado.nextInt();
                    teclado.nextLine();
                    no = turmaGiraffa.registros[numA - 1];
                } while (no == null);
                System.out.print("Quantas atividades foram feitas sem o auxílio de IA: \n> ");
                numEn = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantas atividades foram realizadas com o auxílio de IA: \n> ");
                numI = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantas atividades o aluno consegue explicar bem: \n> ");
                numEx = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantos códigos o aluno consegue modificar: \n> ");
                numCM = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Quantos códigos o aluno entregou com conteúdos extras, funções não estudadas: \n> ");
                numCE = teclado.nextInt();
                teclado.nextLine();
                turmaGiraffa.modificarAcompanhamentoIA(no, numEn, numI, numEx, numCM, numCE);
                System.out.println("O Acompanhamento de IA do aluno foi modificado com sucesso!");
                pausar();
                return true;
            case 9:
                int y;
                System.out.print("============================================\n");
                System.out.print("Qual lista você deseja?\n" +
                        "1 - Alunos\n" +
                        "2 - Bolsistas\n" +
                        "3 - Acompanhamento IA" +
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
                    case 3:
                        System.out.print("============================================\n");
                        System.out.print("Aqui estão os alunos que já possuem acompanhamento IA cadastrados: \n");
                        turmaGiraffa.listarRegistros();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Não existe essa opção");
                        break;
                    }
                pausar();
                return true;
            case 10:
                System.out.print("============================================\n");
                System.out.print("O nome mais longo é: ");
                System.out.print(turmaGiraffa.nomeLongo() + "\n");
                pausar();
                return true;
            case 11:
                System.out.print("============================================\n");
                System.out.print("A quantidade de vogais nos nomes dos alunos é: ");
                System.out.println(turmaGiraffa.contVogal());
                pausar();
                return true;
            case 12:
                System.out.print("============================================\n");
                if (turmaGiraffa.qtdAlunos == 0) {
                    System.out.println("Não existem alunos para ser calculado o percentual");
                }
                turmaGiraffa.qtdPorCurso();
                pausar();
                return true;
            case 13:
                System.out.print("============================================\n");
                if (turmaGiraffa.alunos.length == 0) {
                    System.out.println("Não existem alunos cadastrados, impossível fazer a média de idades.");
                    return true;
                }
                System.out.print("Aqui está a média de idade dos alunos: ");
                System.out.print(turmaGiraffa.mediaIdade() + "\n");
                pausar();
                return true;
            case 14:
                System.out.print("============================================\n");
                turmaGiraffa.criarAtualizarListaChamada();
                System.out.println("Lista de chamada criada/atualizada!");
                pausar();
                return true;
            case 15:
                System.out.print("============================================\n");
                System.out.println("Aqui está a chamada, Prof(a) " + professor + ", da sua disciplina " + disciplina + ".");
                turmaGiraffa.exibirListaChamada();
                pausar();
                return true;
            case 16:
                System.out.print("============================================\n");
                System.out.println("Aqui está o relatório de uso de IA dos alunos cadastrados\n> ");
                turmaGiraffa.relatorioGeralRisco();
                pausar();
                return true;
            case 17:
                System.out.print("============================================\n");
                    
                    System.out.println("Aqui estão os alunos em risco alto!");
                    turmaGiraffa.listarRiscoAlto();
                pausar();
                return true;
            case 18:
                System.out.print("============================================\n");
                int acIA;
                AcompanhamentoIA checAcompanhamento;
                System.out.println("Qual aluno você gostaria de acompanhar individualmente: \n> ");
                do {
                    turmaGiraffa.listarRegistros();
                    System.out.println("> ");
                    acIA = teclado.nextInt();
                    teclado.nextLine();
                    checAcompanhamento = turmaGiraffa.registros[acIA - 1];
                } while (checAcompanhamento == null);
                turmaGiraffa.recomendIA(checAcompanhamento);
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
        System.out.print("Pressione Enter para voltar pro menu.");
        teclado.nextLine();
    }
}