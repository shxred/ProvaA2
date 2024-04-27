import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Informe o nome do titular da conta:");
        String cpf = JOptionPane.showInputDialog("Informe o CPF do titular:");
        float saldoInicial = Float.parseFloat(JOptionPane.showInputDialog("Informe o saldo inicial:"));

        Conta conta = new Conta(nome, cpf);
        conta.depositar(saldoInicial);
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Menu:\n" +
                "1 - Depositar\n" +
                "2 - Sacar\n" +
                "3 - Imprimir Saldo\n" +
                "4 - Informações da Conta\n" +
                "5 - Dados do Projeto\n" +
                "6 - Sair\n"+
                "\nOpção:"));

            switch (opcao) {
                case 1:
                    float valorDeposito = Float.parseFloat(JOptionPane.showInputDialog("Valor a depositar:"));
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    float valorSaque = Float.parseFloat(JOptionPane.showInputDialog("Valor a sacar:"));
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    exibirMensagem("Saldo atual: R$" + String.format("%.2f", conta.getSaldo()));
                    break;
                case 4:
                    exibirMensagem(conta.getInfoConta());
                    break;
                case 5:
                    exibirMensagem("Dados do Projeto:\n" +
                            "Nome: Eduardho Carneiro Costa | RGM: 33393834\n" +
                            "Nome: Guilherme Souza Cruz | RGM: 34032207");
                    break;
                case 6:
                    exibirMensagem("Saindo do sistema...");
                    break;
                default:
                    exibirMensagem("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
