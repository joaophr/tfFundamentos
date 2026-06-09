import java.util.Scanner;

public class Turma{
    public static Scanner teclado = new Scanner(System.in);
    Pessoa[] pessoas;
    Aluno[] alunos;
    AlunoBolsistaIC[] bolsistas;
    int qtdPessoas;
    int qtdAlunos;
    int qtdBolsistas;
   

    public Turma(int tam){
        pessoas = new Pessoa[tam];
        alunos = new Aluno[tam];
        bolsistas = new AlunoBolsistaIC[tam];
        qtdPessoas = 0;
        qtdAlunos = 0;
        qtdBolsistas = 0;
    }

    //Funções pessoa
    public void cadastrarPessoa(String n, String l, int i){
        Pessoa p1 = new Pessoa(n, i, l);
        inserirPessoa(p1);
        qtdPessoas++;
       
        System.out.println("Muito obrigado pelo cadastro!\n");
    }

    public Pessoa pessoaExiste(String nome){
        for(Pessoa i: pessoas){
            if(i != null && i.getNome().equals(nome)){
                return i;
            }
        }
        System.out.println("Esta pessoa nao existe. Tente novamente!");
        return null;
    }

   
    private void inserirPessoa(Pessoa p){
        if(qtdPessoas == pessoas.length){
            Pessoa[] pessoasAux = new Pessoa[pessoas.length + 1];
            for(int i = 0; i < pessoas.length; i++){
                pessoasAux[i] = pessoas[i];
            }
            pessoasAux[pessoas.length] = p;
            this.pessoas = pessoasAux;
        }else{
            pessoas[qtdPessoas] = p;
        }
    }

    public void listarPessoas(){
        for(Pessoa j : pessoas){
            if(j != null){System.out.println(j.getNome());}
        }
    }

    //Funções aluno
    public void cadastrarAluno(Pessoa p, String c, String m, int ano, int s, boolean ic){
        Aluno a1 = new Aluno(p, c, m, ano, s, ic);
        qtdAlunos++;
        inserirAluno(a1);

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

    private void inserirAluno(Aluno p){
        if(qtdAlunos == alunos.length){
            Aluno[] alunosAux = new Aluno[alunos.length + 1];
            for(int i = 0; i < alunos.length; i++){
                alunosAux[i] = alunos[i];
            }
            alunosAux[alunos.length] = p;
            this.alunos = alunosAux;
        }else{
            alunos[qtdAlunos] = p;
        }
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
