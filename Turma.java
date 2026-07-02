public class Turma{
    //Estes são os arrays que irão guardar todos os objetos para futuras funções
    Pessoa[] pessoas;
    Aluno[] alunos;
    Aluno[] listaChamada;
    AlunoBolsistaIC[] bolsistas;
    AcompanhamentoIA[] registros;
    int qtdPessoas;
    int qtdAlunos;
    int qtdBolsistas;
    int qtdRegistros;

    //Constructor da classe turma
    public Turma(int tam){
        pessoas = new Pessoa[tam];
        alunos = new Aluno[tam];
        bolsistas = new AlunoBolsistaIC[tam];
        registros = new AcompanhamentoIA[tam];
        qtdPessoas = 0;
        qtdAlunos = 0;
        qtdBolsistas = 0;
        qtdRegistros = 0;
    }

    /*
        Os métodos a seguir todos funcionam do mesmo jeito, para objetos diferentes
        -Cadastrar: Cria um objeto com os parâmetros passados e chama inserirObjeto
        -Inserir: Cria um array auxiliar com 1 a mais de tamanho, copia o array pro auxiliar e adiciona o objeto passado como última posição
        -Existe: Checa se tal objeto existe
        -Modificar: Modifica o objeto selecionado com novos parâmetros
        -Listar: Imprime todos os objetos do array nesta formatação "Posição - Nome"
    */

    //Pessoas 
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
        for(int i = 0; i < qtdPessoas; i++){
                System.out.println((i + 1) + " - " + pessoas[i].getNome());
        }
    }

    //Aluno
    public void cadastrarAluno(Pessoa p, String c, String m, int ano, int s, boolean ic){
        Aluno a1 = new Aluno(p, c, m, ano, s, ic);
        inserirAluno(a1);
        qtdAlunos++;
    }

    public void alunoExiste(String matricula){
        for(int i = 0; i < alunos.length; i++){
            if(alunos[i] != null && alunos[i].getMatricula().equals(matricula)){
                System.out.println(alunos[i].getPessoa().getNome() + " está cadastrado e está cursando: " + alunos[i].getCurso());
                return;
            }
        }
        System.out.println("Este aluno ainda não foi cadastrado no nosso sistema.");
    }

    public boolean matriculaExiste(String matricula){
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return false;
            }
        }
        return true;
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

    public void modificarAluno(Aluno a, String novoCurso, String novaMatricula, int novoAno, int novoSemestre, boolean novoIC){
        a.setCurso(novoCurso);
        a.setMatricula(novaMatricula);
        a.setAno(novoAno);
        a.setSemestre(novoSemestre);
        a.setEIc(novoIC);
    }
    
    public void listarAluno() {
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println(i+1 + " - " + alunos[i].getPessoa().getNome());
        }
    }

    //Bolsistas
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

    public void modificarBolsistaIC(AlunoBolsistaIC b, String novoProjeto, String novoOrientador) {
            b.setProjeto(novoProjeto);
            b.setOrientador(novoOrientador);
    }

    public void listarBolsistas(){
        for(int i = 0; i < qtdBolsistas; i++){
            System.out.println((i + 1) + " - " + bolsistas[i].getAluno().getPessoa().getNome());
        }
    }

    //Registros
    public void registrarAcompanhamentoIA(Aluno pAluno ,int pAtivEntregue, int pAtivIA, int pAtivExplica, int pCodigoMod, int pCodigoExtra){
        AcompanhamentoIA acompIA1 = new AcompanhamentoIA(pAluno, pAtivEntregue, pAtivIA, pAtivExplica, pCodigoMod, pCodigoExtra);
        inserirAcompanhamentoIA(acompIA1);
        qtdRegistros++;
        acompIA1.calcularRisco();
    }

    public void modificarAcompanhamentoIA(AcompanhamentoIA Aluno ,int novoAtivEntregue, int novoAtivIA, int novoAtivExplica, int novoCodigoMod, int novoCodigoExtra){
        Aluno.setAtivEntregue(novoAtivEntregue);
        Aluno.setAtivIA(novoAtivIA);
        Aluno.setAtivExplica(novoAtivExplica);
        Aluno.setCodigoMod(novoCodigoMod);
        Aluno.setCodigoExtra(novoCodigoExtra);
    }

    private void inserirAcompanhamentoIA(AcompanhamentoIA x){
        if(qtdRegistros == registros.length){
            AcompanhamentoIA[] registrosAux = new AcompanhamentoIA[registros.length + 1];
            for(int i = 0; i < registros.length; i++){
                registrosAux[i] = registros[i];
            }
            registrosAux[registros.length] = x;
            this.registros = registrosAux;
        }else{
            registros[qtdRegistros] = x;
        }
    }

    public void listarRegistros(){
        for(int i = 0; i < qtdRegistros; i++){
            System.out.println((i + 1) + " - " + registros[i].getAluno().getPessoa().getNome() + " - Matrícula: " + registros[i].getAluno().getMatricula());
        }
    }

    public void listarRiscoAlto(){
        for (AcompanhamentoIA aluno: registros) {
            if (aluno.getRisco().equals("Alto")) {
                System.out.println(aluno.getAluno().getPessoa().getNome() + " - " + aluno.getAluno().getMatricula());
            }
        }
    }

    //Gets, caso queiramos acessar estas informações no Main, por exemplo
    public int getQtdPessoas(){return qtdPessoas;}
    public int getQtdAlunos(){return qtdAlunos;}
    public int getQtdBolsistas(){return qtdBolsistas;}
   
    //Aqui contamos a quantidade de letras do primeiro nome e comparamos todos os outros tamanhos com ele
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

    //Nada de mais nesse método, percorremos o vator e somamos as idades, depois dividimos pela quantidade de alunos
    public double mediaIdade() {
        int soma = 0;
        for (Aluno aluno: alunos){
            soma += aluno.getPessoa().getIdade();
        }
        return (double) soma / alunos.length;
    }

    public int contVogal() {
        //Percorremos todo o vetor de aluno, apenas contando as vogais
        int qtdVogais = 0;
        String vogais = "aeiou";

        for (Pessoa pessoa : pessoas) {
            String nome = pessoa.getNome().toLowerCase();
            for (int i = 0; i < nome.length(); i++) {
                if (vogais.contains(String.valueOf(nome.charAt(i)))) { //Converte o char pra string pra comparar
                    qtdVogais++;
                }
            }
        }
        return qtdVogais;
    }

    public void qtdPorCurso() {
        //Cria uma variável para a quantidade de cada curso, percorremos todo o vetor de alunos e contamos quantos tem em cada curso, depois fazemos a média.
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
        System.out.println("O percentual de alunos que cursam Engenharia da Computação é: " + (double)   ec / qtdAlunos * 100 + "%");
        System.out.println("O percentual de alunos que cursam Sistemas de Informação é: " + (double) si / qtdAlunos * 100 + "%");
        System.out.println("O percentual de alunos que cursam Ciência de dados e Inteligência Artificial é: " + (double) cdIa / qtdAlunos * 100 + "%");
    }

    public void criarAtualizarListaChamada(){
        //Sempre é criado uma lista nova, deletando a lista antiga
        listaChamada = new Aluno[qtdAlunos];
        for(int i = 0; i < qtdAlunos; i++){
            listaChamada[i] = alunos[i];
        }

        //Organiza o array utilizando o método bubble sort. Funciona porquê o método compareTo compara, lexicograficamente, ou seja, em ordem alfabética. Ele retorna um número negativo se a palavra vem antes, 0 se são iguais e positivo se ela vier depois
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

    //Exibe a lista formatada, já em formato de tabela.
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
