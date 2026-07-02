public class Pessoa {
    String aNome, aLocalNasc;
    int aIdade;

    public Pessoa(String pNome, int pIdade, String pLocalNasc){
            aNome = pNome;
            aIdade = pIdade;
            aLocalNasc = pLocalNasc;
    }

    //region [Gets e Sets]
    public String getNome(){return aNome;}
    public void setNome(String nome){aNome = nome;}
    public int getIdade(){return aIdade;}
    public void setIdade(int idade){aIdade = idade;}
    public String getLocalNasc(){return aLocalNasc;}
    public void setLocalNasc(String localNasc){aLocalNasc = localNasc;}
    //endregion

    public String toString(){
        return "Nome: " + aNome + "\n" + "Idade: " + aIdade + "\n" + "Local de Nascimento: " + aLocalNasc;
    }
}
