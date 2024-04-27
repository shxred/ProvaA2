import java.util.Random;
import javax.swing.JOptionPane;
import provaa2.Pessoa;

public class Conta implements Pessoa {

    private int numero;
    private float saldo;
    private String nome;
    private String cpf;

    private static final Random random = new Random();

    public Conta(String nome, String cpf) {
        this.numero = random.nextInt(999999) + 100000;
        this.saldo = 0.0f;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    public String getInfoConta() {
        return "Número da conta: " + numero + "\n" +
               "Nome do titular: " + nome + "\n" +
               "CPF do titular: " + cpf + "\n" +
               "Saldo: R$" + String.format("%.2f", saldo);
    }
    public void depositar(float valor) {
        if (valor > 0.0f) {
            this.saldo += valor;
            exibirMensagem("Saldo atualizado: R$" + String.format("%.2f", saldo));
        }
    }

    public void sacar(float valor) {
        if (valor > 0.0f && valor <= saldo) {
            this.saldo -= valor;
            exibirMensagem("Saldo atualizado: R$" + String.format("%.2f", saldo));
        } else {
            exibirMensagem("Saque não realizado. Saldo insuficiente.");
        }
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
