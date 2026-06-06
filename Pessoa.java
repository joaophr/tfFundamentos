public class Pessoa {
    String aNome, aLocalNasc;
    int aIdade;

    Pessoa [] pessoas = new Pessoa[5]; // ver onde armazenar isso
    int qtdPessoas = pessoas.length; // ver onde armazenar isso

    public Pessoa(String pNome, int pIdade, String pLocalNasc){
            aNome = pNome;
            aIdade = pIdade;
            aLocalNasc = pLocalNasc;
    }

    public String getNome() {
        return aNome;
    }

    public void setNome(String nome) {
        aNome = nome;
    }

    public int getIdade() {
        return aIdade;
    }

    public void setIdade(int idade) {
        aIdade = idade;
    }

    public String getLocalNasc() {
        return aLocalNasc;
    }

    public void setLocalNasc(String localNasc) {
        aLocalNasc = localNasc;
    }

    public String toString(){
        return "Nome: " + aNome + "\n" + "Idade: " + aIdade + "\n" + "Local de Nascimento: " + aLocalNasc;
    }
}

