public class Turma{
    Pessoa[] pessoas;
    Aluno[] alunos;
    Aluno[] listaChamada;
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

    public void modificarPessoa(Pessoa p, String novoNome, String novoLocal, int novaIdade){
        p.setNome(novoNome);
        p.setIdade(novaIdade);
        p.setLocalNasc(novoLocal);
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
    }

    public Aluno alunoExiste(String nome){
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
    }

    private void inserirAlunoBolsista(AlunoBolsistaIC x){
        if(qtdBolsistas == bolsistas.length){
            AlunoBolsistaIC[] bolsistaAux = new AlunoBolsistaIC[bolsistas.length + 1];
            for(int i = 0; i < bolsistas.length; i++){
                bolsistaAux[i] = bolsistas[i];
            }
            bolsistaAux[bolsistas.length] = x;
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
   
   //region [Específicos]
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

    public double mediaIdade() {
        int soma = 0;
        for (Aluno aluno: alunos){
            soma += aluno.getPessoa().getIdade();
        }
        return (double) soma / alunos.length;
    }

    public int contVogal() {
        int qtdVogais = 0;
        String vogais = "aeiou";

        for (Pessoa pessoa : pessoas) {
            String nome = pessoa.getNome().toLowerCase();
            for (int i = 0; i < nome.length(); i++) {
                if (vogais.contains(String.valueOf(nome.charAt(i)))) { // converte o char pra string pra comparar
                    qtdVogais++;
                }
            }
        }
        return qtdVogais;
    }

    public void qtdPorCurso() {
        int cc = 0, es = 0, ec = 0, si = 0, cdIa = 0;
        for (Aluno aluno: alunos) {
            if (aluno.getCurso().equals("Ciência da Computação")) {
                cc++;
            } else if (aluno.getCurso().equals("Engenharia de Software")) {
                es++;
            } else if (aluno.getCurso().equals("Engenharia da Computação")) {
                ec++;
            } else if (aluno.getCurso().equals("Sistemas de Informação")) {
                si++;
            } else if (aluno.getCurso().equals("Ciência de Dados e Inteligência Artificial")) {
                cdIa++;
            }
        }
        System.out.println("O percentual de alunos que cursam Ciência da Computação é: " + (double) cc / qtdAlunos * 100 + "%");
        System.out.println("O percentual de alunos que cursam Engenharia de Software é: " + (double) es / qtdAlunos * 100 + "%");
        System.out.println("O percentual de alunos que cursam Engenharia da Computação é: " + (double) ec / qtdAlunos * 100 + "%");
        System.out.println("O percentual de alunos que cursam Sistemas de Informação é: " + (double) si / qtdAlunos * 100 + "%");
        System.out.println("O percentual de alunos que cursam Ciência de dados e Inteligência Artificial é: " + (double) cdIa / qtdAlunos * 100 + "%");
    }

    public void criarAtualizarListaChamada(){
        listaChamada = new Aluno[qtdAlunos];
        for(int i = 0; i < qtdAlunos; i++){
            listaChamada[i] = alunos[i];
        }

        for(int i = 0; i < listaChamada.length - 1; i++){
            for(int j = 0; j < listaChamada.length - 1; j++){
                String nomeAtual = listaChamada[j].getPessoa().getNome();
                String nomeProximo = listaChamada[j + 1].getPessoa().getNome();
                if(nomeAtual.compareTo(nomeProximo) > 0){
                    Aluno aux = listaChamada[j];
                    listaChamada[j] = listaChamada[j + 1];
                    listaChamada[j + 1] = aux;
                }
            }
        }
    }

    public void exibirListaChamada(){
        if(listaChamada == null || listaChamada.length == 0){
            System.out.println("A lista de chamada ainda não foi criada.");
            return;
        }
        System.out.printf("%-20s %-12s %s%n", "Nome", "Matrícula", "Curso");
        for(Aluno a: listaChamada){
            System.out.printf("%-20s %-12s %s%n", a.getPessoa().getNome(), a.getMatricula(), a.getCurso());
        }
    }
}
