import programa.Conta;
import programa.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList();

        operacoes();
    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("------------Bem-vindos a nossa Agência----------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|     Opção 1 - Criar Conta   |");
        System.out.println("|     Opção 2 - Depositar     |");
        System.out.println("|     Opção 3 - Sacar         |");
        System.out.println("|     Opção 4 - Transferir    |");
        System.out.println("|     Opção 5 - Listar        |");
        System.out.println("|     Opção 6 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por utilizar nossa Agência");
                System.exit(0);
            default:
                System.out.println("Esta opção não existe em nosso Menu");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nE-mail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;

        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Digite o número da conta que receberá o depósito: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Essa conta não foi encontrada.");
        }

        operacoes();
    }

    public static void sacar() {
        System.out.println("Digite o número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Essa conta não foi encontrada.");
        }

        operacoes();
    }

    public static void transferir() {
        System.out.println("Digite a conta que enviará transferência: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Digite a conta que receberá transferência: ");
            int numeroContaDestino = input.nextInt();

            Conta contaDestino = encontrarConta(numeroContaDestino);

            if (contaDestino != null) {
                System.out.println("Qual valor deseja transferir? ");
                Double valorTransferencia = input.nextDouble();

                contaRemetente.transferir(valorTransferencia, contaDestino);
            } else {
                System.out.println("Essa conta não foi encontrada.");
            }


        } else {
            System.out.println("Essa conta não foi encontrada.");
        }

        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                System.out.println(c);
            }
        } else {
            System.out.println("Não existem contas cadastradas.");
        }
        operacoes();
    }
}