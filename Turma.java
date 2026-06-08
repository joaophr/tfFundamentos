import java.util.Scanner;

public class Turma{
    public static Scanner teclado = new Scanner(System.in);
    Pessoa[] pessoas = new Pessoa[10];
    Aluno[] alunos;
    AlunoBolsistaIC[] bolsistas;
    int qtdPessoas;
    int qtdAlunos;
    int qtdBolsistas;
    Pessoa p1 = new Pessoa("marcos", 23, "poa");

    public Turma(int tam){
        pessoas[0] = p1;
        //pessoas = new Pessoa[tam];
        alunos = new Aluno[tam];
        bolsistas = new AlunoBolsistaIC[tam];
    }

    //Funções pessoa
    public void cadastrarPessoa(){
        String n, l;
        int i;

        System.out.println("Qual o nome da pessoa que deseja cadastrar? ");
        n = teclado.nextLine();
        System.out.println("Qual a idade da pessoa que deseja cadastrar? ");
        i = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Qual o local de nascimento da pessoa que deseja cadastrar? ");
        l = teclado.nextLine();

        Pessoa p1 = new Pessoa(n, i, l);
        inserirPessoa(p1);
       
        System.out.println("Muito obrigado pelo cadastro!\n");
    }

    private Pessoa pessoaExiste(String nome){
        for(Pessoa i: pessoas){
            if(i != null && i.getNome().equals(nome)){
                return i;
            }
        }
        System.out.println("Esta pessoa nao existe. Tente novamente!");
        return null;
    }

   
    private void inserirPessoa(Pessoa p){
        for(int i = 0; i < pessoas.length; i++){
            if(pessoas[i] == null){
                pessoas[i] = p;
                break;
            }
        }
        System.out.println("Já há pessoas o bastante na turma.");
    }

    public void listarPessoas(){
        for(Pessoa j : pessoas){
            if(j != null){System.out.println(j.getNome());}
        }
    }

    //Funções aluno
    public void cadastrarAluno(){
        Pessoa p;
        String c, m;
        int ano, s;
        boolean ic = false;

        System.out.print("Qual pessoa você deseja cadastrar como aluno? ");
        String nome;
        do{
            nome = teclado.nextLine();
            p = pessoaExiste(nome);
        }while(p == null);
        System.out.print("O curso do aluno que deseja cadastrar: ");
        c = teclado.nextLine();
        System.out.print("O número de matrícula do aluno que deseja cadastrar: ");
        m = teclado.nextLine();
        System.out.print("O ano que o aluno que você deseja cadastrar está na faculdade: ");
        ano = teclado.nextInt();
        System.out.println("O semestre que o aluno que você deseja cadastrar está na faculdade: ");
        s = teclado.nextInt();
        //System.out.println("O aluno que você deseja cadastrar é bolsista de Iniciação científica? (s/n) ");
        //aux = teclado.nextLine().toLowerCase().strip();

        Aluno aluno1 = new Aluno(p, c, m, ano, s, ic);

        System.out.println("Muito obrigado pelo cadastro!\n");
    }

    private Aluno alunoExiste(String nome){
        for(Aluno i: alunos){
            if(i != null && i.getPessoa().getNome().equals(nome)){
                return i;
            }
        }
        System.out.println("Este aluno nao existe. Tente novamente!");
        return null;
    }

    //Funções bolsista
    public void cadastrarBolsistaIC(){
        Aluno n;
        String p, o;
        System.out.print("Qual aluno você deseja cadastrar?\n");
        String nome;
        do{
            nome = teclado.nextLine();
            n = alunoExiste(nome);
        }while(n == null);
        System.out.print("O nome do projeto que você deseja cadastrar: ");
        p = teclado.nextLine();
        System.out.print("O nome do orientador do aluno que você deseja cadastrar: ");
        o = teclado.nextLine();

        //AlunoBolsistaIC alunoIc1 = new AlunoBolsistaIC(x, p, o); // arrumar erro

        System.out.println("Muito obrigado pelo cadastro!\n");
    }
   
    //region [Gets]
    public int getQtdPessoas(){return qtdPessoas;}
    public int getQtdAlunos(){return qtdAlunos;}
    public int getQtdBolsistas(){return qtdBolsistas;}
    //endregion
}