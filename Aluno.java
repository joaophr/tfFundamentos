public class Aluno {
    String aNome, aLocalNasc;
    int aIdade;
    static String [] alunos = {"Luigi", "João", "Braga", "Bife", "Zin"};
    static int tam = alunos.length;
    public Aluno(String pNome, int pIdade, String pLocalNasc){
        aNome = pNome;
        aIdade = pIdade;
        aLocalNasc = pLocalNasc;
    }

    public String toString(){
        return "Nome: " + aNome + "\n" + "Idade: " + aIdade + "\n" + "Local de Nascimento: " + aLocalNasc;
    }
}