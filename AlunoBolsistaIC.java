public class AlunoBolsistaIC {
    Aluno bAluno;
    String bProjeto, bOrientador;

    public AlunoBolsistaIC(Aluno pAluno, String pProjeto, String pOrientador){
        bAluno = pAluno;
        bProjeto = pProjeto;
        bOrientador = pOrientador;
    }

    public String toString(){
        return bAluno + "\n" + bProjeto + "\n" + bOrientador + "\n";
    }
}