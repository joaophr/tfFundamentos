public class AlunoBolsistaIC {
    Aluno aAluno;
    String aProjeto, aOrientador;

    public AlunoBolsistaIC(Aluno pAluno, String pProjeto, String pOrientador){
        aAluno = pAluno;
        aProjeto = pProjeto;
        aOrientador = pOrientador;
    }

    public Aluno getAluno() {
        return aAluno;
    }

    public void setNome(Aluno aluno) {
        aAluno = aluno;
    }

    public String getProjeto() {
        return aProjeto;
    }

    public void setProjeto(String projeto) {
        aProjeto = projeto;
    }

    public String getOrientador() {
        return aOrientador;
    }

    public void setOrientador(String orientador) {
        aOrientador = orientador;
    }

    public String toString(){
        return "Nome: "+ aAluno + "\n" + "Projeto: " + aProjeto + "\n" + "Orientador: " + aOrientador;
    }
}