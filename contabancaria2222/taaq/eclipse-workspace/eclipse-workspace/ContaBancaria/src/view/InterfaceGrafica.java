package view;

import javax.swing.JOptionPane;

import controler.Controle;
import model.Conta;

public class InterfaceGrafica {

	public void cadastrarUsuario() {
		Conta conta = new Conta();
		String nomeUsuario = JOptionPane.showInputDialog("Informe seu nome:");
		conta.setTitularConta(nomeUsuario);
		int tipo = Integer.parseInt(JOptionPane
				.showInputDialog("Qual o tipo de conta ? \n" + "1 - Conta poupanca \n" + "2 - Conta corrente"));
		conta.setTipo(tipo);
		exibirMenu(conta);
	}

	public void exibirMenu(Conta conta) {
		while (true) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual opcao bancaria deseja fazer "
					+ conta.getTitularConta() + "? \n" + "1 - Informacoes Deposito  \n" + "2 - Informacoes Saque \n"
					+ "3 - Mostrar Saldo \n" + "4 - Mostrar dados da Conta \n" + "5 - Mostrar Extrato Completo \n"
					+ "6 - Mostrar Extrato Depositos \n" + "7 - Mostrar Extrato Saques \n" + "8 - Sair"));

			Controle controler = new Controle();
			controler.controleDoMenu(opcao);
		}
	}

	public void informacoesDeposito(Conta conta) {
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Qual valor deseja depositar ?"));
		while (valor < 10) {
			JOptionPane.showMessageDialog(null, "Nao e possivel depositar valores menores que R$10.00");
			valor = Float.parseFloat(JOptionPane.showInputDialog("Qual valor deseja depositar ?"));
		}
		conta.depositar(valor);
	}

	public void informacoesSaque(Conta conta) {
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Quanto deseja sacar ?"));
		while (valor < 5) {
			JOptionPane.showMessageDialog(null, "Nao e possivel sacar menos que R$5.00");
			valor = Float.parseFloat(JOptionPane.showInputDialog("Quanto deseja sacar ?"));
		}

	}

	public void mostrarSaldo(Conta conta) {
		conta.getSaldo();
	}

	public void mostrarDadosConta() {

	}

	public void mostrarExtratoCompleto() {

	}

	public void mostrarExtratoDesposito() {

	}

	public void mostrarExtratoSaque() {

	}

}
