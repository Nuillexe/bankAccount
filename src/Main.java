import java.util.Scanner;

class BankAccount{
    private String name;
    protected double saldo;
    protected String typeAccount;

    public double typeNumbersDouble(Scanner read){

        double value=0;
        while(true){
            if(read.hasNextDouble()){//Verify if the value typed on terminal is a number
                value=read.nextDouble();
                if(value<1){
                    System.out.println("Valor digitado é menor do que 0. Digite outro valor");
                }else{
                    break;
                }
            }else {
                System.out.println("Valor digitado não é um numero. Digite novamente");
                read.nextLine();//Get a any value typed on terminal. It is matter to won't happen bugs
            }
        }

        return value;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }


    public void sacar(Scanner read){
        System.out.println("Escreva o valor a ser sacado");
        saldo-=typeNumbersDouble(read);
    }

    public void depositar(Scanner read){
        System.out.println("Escreva o valor a ser depositado");
        saldo+=typeNumbersDouble(read);
    }

    public double getSaldo(){
        return saldo;
    }
}

class CurrentAccount extends BankAccount{
    CurrentAccount(){
        typeAccount = "Corrente";
    }

    public String getTypeAccount(){
        return typeAccount;
    }
    //            System.out.println("\n\n*********");
//            System.out.println("Dados iniciais do cliente");
//            System.out.println("Nome: " + conta.getName());
//            System.out.println("Tipo de conta: " + conta.getTypeAccount());
//            System.out.println("Saldo: " + conta.getSaldo());
//            System.out.println("********* \n\n");
}

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String opcao = "0";

        CurrentAccount conta=new CurrentAccount();
        System.out.println("Vamos criar sua conta Corrente no banco Java123. Para isso preciso que voce faça um cadastro");
        System.out.println("Digite seu nome");
        conta.setName(read.nextLine());
        System.out.println("Digite o valor do seu primeiro deposito");
        conta.depositar(read);

        System.out.println("Pronto! Cadastro realizado com sucesso! Agora voce deseja realizar alguma operação?");

        String menu = """
            Operações
            1-Ver saldo
            2-Sacar
            3-Deposito
            4-Encerrar sessão
            """;

        while (!opcao.equals("4")) {


            System.out.println(menu);

            opcao = read.nextLine();
            switch (opcao) {

                case "1":
                    System.out.println("O seu saldo é de "+conta.getSaldo());
                    break;

                case "2":
                    conta.sacar(read);
                    break;

                case "3":
                    conta.depositar(read);
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