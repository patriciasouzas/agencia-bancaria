package programa;

import utilitarios.Utils;

import javax.swing.*;

public class Conta {
    private static int contadorDeContas = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.00;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nNome: " + this.getPessoa().getNome() +
                "\nCPF: " + this.getPessoa().getCpf() +
                "\nE-mail: " + this.getPessoa().getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o depósito.");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o saque.");
        }
    }

    public void transferir(Double valor, Conta contaParaDeposito) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência.");
        }
    }
}
