public class AcompanhamentoIA {
    Aluno aAluno;
    int aAtivEntregue, aAtivIA, aAtivExplica, aCodigoMod, aCodigoExtra, ativTotais;
    String aNivelRisco;
    double risco;

    public AcompanhamentoIA(Aluno pAluno ,int pAtivEntregue, int pAtivIA, int pAtivExplica, int pCodigoMod, int pCodigoExtra) {
        aAluno = pAluno;
        aAtivEntregue = pAtivEntregue;
        aAtivIA = pAtivIA;
        aAtivExplica = pAtivExplica;
        aCodigoMod = pCodigoMod;
        aCodigoExtra = pCodigoExtra;
        aNivelRisco = "";
        ativTotais = aAtivIA + aAtivEntregue;

        double entendimento;
        if(aAtivIA == 0){
            entendimento = 1.0;
        }else{
            entendimento = (double) aAtivExplica / aAtivIA;
        }
        double usoIA = (double) aAtivIA / ativTotais;
        double codigosMod = (double) aCodigoMod / ativTotais;
        double codigosExtras = (double) aCodigoExtra / ativTotais;

        risco = usoIA * 30 + (1 - entendimento) * 40 + codigosMod * 15 + codigosExtras * 8;

        if(risco < 30){
            aNivelRisco = "Baixo";
        }else if(risco < 70){
            aNivelRisco = "Moderado";
        }else{
            aNivelRisco = "Alto";
        }
    }

    public Aluno getAluno(){return aAluno;}
    public String getRisco(){return aNivelRisco;}
}
