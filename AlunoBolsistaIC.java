public class AlunoBolsistaIC {
    Aluno bAluno;
    String bProjeto, bOrientador;

    public AlunoBolsistaIC(Aluno pAluno, String pProjeto, String pOrientador){
        bAluno = pAluno;
        bProjeto = pProjeto;
        bOrientador = pOrientador;
    }

    public String toString(){
        return "Nome: "+ bAluno + "\n" + "Projeto: " + bProjeto + "\n" + "Orientador: " + bOrientador;
    }
}