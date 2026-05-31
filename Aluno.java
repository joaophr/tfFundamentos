public class Aluno {
    String aNome, aLocalNasc, aMatricula;
    int aIdade;

    public Aluno(String pNome, int pIdade, String pLocalNasc, String pMatricula){
        aNome = pNome;
        aIdade = pIdade;
        aLocalNasc = pLocalNasc;
        aMatricula = pMatricula;
    }

    public String toString(){
        return "Nome: " + aNome + "\n" + "Idade: " + aIdade + "\n" + "Local de Nascimento: " + aLocalNasc;
    }
}
