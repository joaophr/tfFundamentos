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
        for(int i = 0; i < qtdPessoas;i++){
                System.out.println((i + 1) + " - " + pessoas[i].getNome());
        }
    }

    //Funções aluno
    public void cadastrarAluno(Pessoa p, String c, String m, int ano, int s, boolean ic){
        Aluno a1 = new Aluno(p, c, m, ano, s, ic);
        inserirAluno(a1);
        qtdAlunos++;

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

    public void listarAluno() {
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println(i+1 + " - " + alunos[i].getPessoa().getNome());
        }
    }

    //Funções bolsista
    public void cadastrarBolsistaIC(Aluno paluno, String pProjeto, String pOrientador ){
        AlunoBolsistaIC alunoIc1 = new AlunoBolsistaIC(paluno, pProjeto, pOrientador);
        inserirAlunoBolsista(alunoIc1);
        qtdBolsistas++;
        System.out.println("Muito obrigado pelo cadastro!\n");
    }

    private void inserirAlunoBolsista(AlunoBolsistaIC x){
        if(qtdBolsistas == bolsistas.length){
            AlunoBolsistaIC[] bolsistaAux = new AlunoBolsistaIC[bolsistas.length + 1];
            for(int i = 0; i < bolsistas.length; i++){
                bolsistaAux[i] = bolsistas[i];
            }
            bolsistas[alunos.length] = x;
            this.bolsistas = bolsistaAux;
        }else{
            bolsistas[qtdBolsistas] = x;
        }
    }

    public void listarBolsistas(){
        for(int i = 0; i < qtdBolsistas;i++){
            System.out.println((i + 1) + " - " + bolsistas[i].getAluno().getPessoa().getNome());
        }
    }


    //region [Gets]
    public int getQtdPessoas(){return qtdPessoas;}
    public int getQtdAlunos(){return qtdAlunos;}
    public int getQtdBolsistas(){return qtdBolsistas;}
    //endregion
    
    
    public String nomeLongo() {
        int aux = 0;
        String aux2 = "Não Existe";
        for (Aluno al : alunos) {
            if (al == null) {
             break;
            }
            if (al.getPessoa().getNome().length() > aux) {
                aux = al.getPessoa().getNome().length();
                aux2 = al.getPessoa().getNome();
            }
        }
        return aux2;
    }
}

