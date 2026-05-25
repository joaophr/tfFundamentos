import java.util.Scanner;

public class Main {
public static Scanner teclado = new Scanner(System.in);
//region [Métodos do Menu]
    public static void menuDisplay(){
        System.out.println("O que vai querer hoje?\n1 – Cadastrar aluno\n2 – Cadastrar bolsista de IC\n3 – Registrar acompanhamento do uso de IA\n4 – Listar todos os alunos\n5 – Listar bolsistas de IC\n6 – Mostrar nome mais longo\n7 – Contar vogais nos nomes cadastrados\n8 – Percentual de alunos por curso\n9 – Média de idade dos alunos\n10 – Criar ou atualizar lista de chamada\n11 – Exibir lista de chamada\n12 – Calcular risco pedagógico relacionado ao uso de IA\n13 – Exibir relatório geral de risco por aluno\n14 – Exibir alunos em risco alto\n15 – Inovação do grupo\n0 – Sair");

        int menuOpção = teclado.nextInt();
        teclado.nextLine();

        menuOpcao(menuOpção);
    }

    public static void menuOpcao(int x){

        switch (x){
            case 1:
                cadastrarAluno();
                break;
            
            case 2:
                //System.out.println(aluno1);
                break;
            
            case 3:
                System.out.println("Registrar acompanhamento de IA");
                break;
            
            case 4:
                System.out.println("Listar todos os alunos");
                break;
            
            case 5:
                System.out.println("Listar todos os bolsistas");
                break;
            
            case 6:
                System.out.println("Mostrar nome mais longo");
                break;
            
            case 7:
                System.out.println("Contar vogais nos nomes cadastrados");
                break;
            
            case 8:
                System.out.println("Percentual de alunos por curso");
                break;
            
            case 9:
                System.out.println("Média de idade dos alunos");
                break;

            case 10:
                System.out.println("Criar ou atualizar lista de chamada");
                break;
            
            case 11:
                System.out.println("Exibir lista de chamada");
                break;
            
            case 12:
                System.out.println("Calcular risco pedagógico");
                break;
            
            case 13:
                System.out.println("Exibir relatório geral de risco");
                break;
            
            case 14:
                System.out.println("Exibir alunos em risco alto");
                break;
            
            case 15:
                System.out.println("Inovação do grupo");
                break;

            case 0:
                System.out.println("Até mais");
                break;
        }
    }
//endregion
    
//region [Métodos Funções]
    public static void cadastrarAluno(){
        String n, l;
        int i;

        System.out.print("O nome do aluno que deseja cadastrar: ");
        n = teclado.nextLine();
        System.out.print("A idade do aluno que deseja cadastrar: ");
        i = teclado.nextInt();
        System.out.print("O local de nascimento do aluno que deseja cadastrar: ");
        teclado.nextLine();
        l = teclado.nextLine();

        Aluno aluno1 = new Aluno(n, i, l);
        System.out.print("Aluno criado com sucesso! Digite 1 para voltar para o menu e 0 para fechar o programa: ");
        int p = teclado.nextInt();
        if(p == 1){
            menuDisplay();
        }else if(p == 0){
            System.out.println("Até mais!");
        }
    }
//endregion

    public static void main(String[] args){
        menuDisplay();
    }
}