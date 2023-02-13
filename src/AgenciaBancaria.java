import programa.Conta;
import programa.Pessoa;

import javax.swing.*;
import java.util.ArrayList;

public class AgenciaBancaria {
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList();

        operacoes();
    }

    public static void operacoes() {

        int operacao = Integer.parseInt(JOptionPane.showInputDialog("------------------------------------------------------" +
                "\n-------Bem-vindos a nossa Agência-------" +
                "\n***** Selecione uma operação que deseja realizar *****" +
                "\n------------------------------------------------------" +
                "\n|     Opção 1 - Criar Conta   |" +
                "\n|     Opção 2 - Depositar      |" +
                "\n|     Opção 3 - Sacar             |" +
                "\n|     Opção 4 - Transferir     |" +
                "\n|     Opção 5 - Listar             |" +
                "\n|     Opção 6 - Sair                |"
        ));

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
                JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossa Agência");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Esta opção não existe em nosso Menu");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
        pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
        pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);

        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

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

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta que receberá o depósito: "));

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar? "));
            conta.depositar(valorDeposito);
        } else {
            JOptionPane.showMessageDialog(null, "Essa conta não foi encontrada.");
        }

        operacoes();
    }

    public static void sacar() {
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta: "));

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar? "));
            conta.sacar(valorSaque);
        } else {
            JOptionPane.showMessageDialog(null, "Essa conta não foi encontrada.");
        }

        operacoes();
    }

    public static void transferir() {
        int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta que enviará transferência: "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            int numeroContaDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta que receberá transferência: "));

            Conta contaDestino = encontrarConta(numeroContaDestino);

            if (contaDestino != null) {
                Double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja transferir? "));

                contaRemetente.transferir(valorTransferencia, contaDestino);
            } else {
                JOptionPane.showMessageDialog(null, "Essa conta não foi encontrada.");
            }


        } else {
            JOptionPane.showMessageDialog(null, "Essa conta não foi encontrada.");
        }

        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                JOptionPane.showMessageDialog(null, c);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existem contas cadastradas.");
        }
        operacoes();
    }
}