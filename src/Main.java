import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        String nome;
        String typeAccount = "Corrente";
        double saldo;
        String opcao = "0";

        System.out.println("Vamos criar sua conta Corrente no banco Java123. Para isso preciso que voce faça um cadastro");
        System.out.println("Digite seu nome");
        nome=read.nextLine();
        System.out.println("Digite o valor do seu primeiro saldo");

        while(true){
            if(read.hasNextDouble()){//Verify if the value typed on terminal is a number
                saldo=read.nextFloat();
                if(saldo<1){
                    System.out.println("Valor digitado é menor do que 0. Digite outro valor");
                }else{
                    break;
                }
            }else {
                System.out.println("Valor digitado não é um numero. Digite novamente");
                read.nextLine();//Get a any value typed on terminal. It is matter to won't happen bugs
            }
        }

        System.out.println("Pronto! Cadastro realizado com sucesso! Agora voce deseja realizar alguma operação?");

        String menu = """
            Operações
            1-Transferência
            2-Receber
            3-Encerrar sessão
            """;
        while (!opcao.equals("3")) {
            System.out.println("\n\n*********");
            System.out.println("Dados iniciais do cliente");
            System.out.println("Nome: " + nome);
            System.out.println("Tipo de conta: " + typeAccount);
            System.out.println("Saldo: " + saldo);
            System.out.println("********* \n\n");

            System.out.println(menu);

            opcao = read.nextLine();
            switch (opcao) {

                case "1":
                    System.out.println("Digite valor a ser transferido: ");
                    int valorTransferido = Integer.parseInt(read.nextLine());
                    saldo -= valorTransferido;
                    break;

                case "2":
                    System.out.println("Digite valor a ser recebido: ");
                    int valorRecebido = Integer.parseInt(read.nextLine());
                    saldo += valorRecebido;
                    break;

                default:
                    if (!opcao.equals("4")) {
                        System.out.println("Esta operação não existe");
                    } else {
                        System.out.println("Bye bye");
                    }
            }
        }

        read.close();
    }
}