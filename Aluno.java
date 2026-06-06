public class Aluno {
    Pessoa aPessoa;
    String aCurso, aMatricula;
    int aSemestre, aAno;
    boolean aEIc;

    Aluno [] alunos = new Aluno[5]; // ver onde armazenar isso
    int qtdAlunos = alunos.length; //  ver onde armazenar isso
    public Aluno(Pessoa pPessoa, String pCurso, String pMatricula, int pSemestre, int pAno, boolean pEIc){
        aPessoa = pPessoa;
        aCurso = pCurso;
        aMatricula = pMatricula;
        aSemestre = pSemestre;
        aAno = pAno;
        aEIc = pEIc;
    }

    public Pessoa getPessoa() {
        return aPessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        aPessoa = pessoa;
    }

    public String getCurso() {
        return aCurso;
    }

    public void setCurso(String curso) {
        aCurso = curso;
    }

    public String getMatricula() {
        return aMatricula;
    }

    public void setMatricula(String matricula) {
        aMatricula = matricula;
    }

    public int getSemestre() {
        return aSemestre;
    }

    public void setSemestre(int semestre) {
        aSemestre = semestre;
    }

    public int getAno() {
        return aAno;
    }

    public void setAno(int ano) {
        aAno = ano;
    }

    public boolean getEIc() {
        return aEIc;
    }

    public void setEIc(boolean eIc) {
        aEIc = eIc;
    }

    public String toString(){
        return "Aluno: " + aPessoa + "\n" + "Curso: " + aCurso + "\n" + "Matrícula: " + aMatricula + "\n" + "Ano: " + aAno + "\n" + "Semestre: " + aSemestre + "\n" + "É Bolsista de IC: " + aEIc + "\n";
    }
}
