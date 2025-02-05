package view;

import javax.swing.JOptionPane;

import model.Conta;
import model.Movimentacao;

public class InterfaceGrafica {

	Conta conta = new Conta();

	public void cadastrarUsuario() {
		String nomeUsuario = JOptionPane.showInputDialog("Informe seu nome:");
		conta.setTitularConta(nomeUsuario);
		int tipo = Integer.parseInt(JOptionPane
				.showInputDialog("Qual o tipo de conta ? \n" + "1 - Conta poupanca \n" + "2 - Conta corrente"));
		conta.setTipo(tipo);
		exibirMenu(conta);
	}

	public void exibirMenu(Conta conta) {
		while(true) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual opcao bancaria deseja fazer "
					+ conta.getTitularConta() + "? \n" + "1 - Informacoes Deposito  \n" + "2 - Informacoes Saque \n"
					+ "3 - Mostrar Saldo \n" + "4 - Mostrar dados da Conta \n" + "5 - Mostrar Extrato Completo \n"
					+ "6 - Mostrar Extrato Depositos \n" + "7 - Mostrar Extrato Saques \n" + "8 - Sair"));
	
			switch (opcao) {
			case 1:
				this.informacoesDeposito(conta);
				break;
			case 2:
				this.informacoesSaque(conta);
				break;
			case 3:
				this.mostrarSaldo(conta);
				break;
			case 4:
				this.mostrarDadosConta(conta);
				break;
			case 5:
				this.mostrarExtratoCompleto(conta);
				break;
			case 6:
				this.mostrarExtratoDesposito(conta);
				break;
			case 7:
				this.mostrarExtratoSaque(conta);
				break;
			case 8:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Erro, tente uma op��o v�lida", "Erro", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}

	public void informacoesDeposito(Conta conta) {
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Insira o valor que deseja depositar:"));
		while (valor < 10) {
			JOptionPane.showMessageDialog(null, "O valor depositado n�o pode ser menor que R$ 10.00", "Erro",
					JOptionPane.ERROR_MESSAGE);
			valor = Float.parseFloat(JOptionPane.showInputDialog("Insira o valor que deseja depositar:"));
		}
		conta.depositar(valor);
	}

	public void informacoesSaque(Conta conta) {
		float valor = Float
				.parseFloat(JOptionPane.showInputDialog("Insira o valor que deseja sacar: "));
		while (valor < 5) {
			JOptionPane.showMessageDialog(null, "O valor depositado n�o pode ser menor que R$ 5.00", "Erro",
					JOptionPane.ERROR_MESSAGE);
			valor = Float
					.parseFloat(JOptionPane.showInputDialog("Insira o valor que deseja sacar:"));
		}
		conta.sacar(valor);
	}

	public void mostrarSaldo(Conta conta) {
		String mostrarSaldo = "Saldo: R$ " + conta.getSaldo();
		JOptionPane.showMessageDialog(null, mostrarSaldo);
	}

	public void mostrarDadosConta(Conta conta) {
		String dados = "Nome do Titular: " + conta.getTitularConta() + "\n" + "Tipo de Conta: "
				+ conta.getTipo() + "\n" + "Saldo: R$ " + conta.getSaldo();
		JOptionPane.showMessageDialog(null, dados, "Dados da Conta", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarExtratoCompleto(Conta conta) {
		String movimentacoes = "";
		if (conta.getListaDeMovimentacoes().size() == 0) {
			movimentacoes = "Voc� ainda n�o possui movimenta��es em sua conta";
		} else {
			for (Movimentacao movimentacao : conta.getListaDeMovimentacoes()) {
				if (movimentacao.getTipo() == 2) {
					movimentacoes += movimentacao.getData() + " - Dep�sito de R$ " + movimentacao.getValor() + "\n";
				} else {
					movimentacoes += movimentacao.getData() + " - Saque de R$ " + movimentacao.getValor() + "\n";
				}
			}
		}
		JOptionPane.showMessageDialog(null, movimentacoes, "Extrato Completo", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarExtratoDesposito(Conta conta) {
		String depositos = "";
		if (conta.getListaDeDepositos().size() == 0) {
			depositos = "Voc� ainda n�o efetuou nenhum Deposito";
		} else {
			for (Movimentacao movimentacao : conta.getListaDeMovimentacoes()) {
				if (movimentacao.getTipo() == 2) {
					depositos += movimentacao.getData() + " - Dep�sito de R$ " + movimentacao.getValor() + "\n";
				}
			}
		}
		JOptionPane.showMessageDialog(null, depositos, "Extrato de Dep�sitos", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarExtratoSaque(Conta conta) {
		String saques = "";
		if (conta.getListaDeSaques().size() == 0) {
			saques = "Voc� ainda n�o efetuou nenhum saque";
		} else {
			for (Movimentacao movimentacao : conta.getListaDeMovimentacoes()) {
				if (movimentacao.getTipo() == 1) {
					saques += movimentacao.getData() + " - Saque de R$ " + movimentacao.getValor() + "\n";
				}
			}
		}
		JOptionPane.showMessageDialog(null, saques, "Extrato de Saques", JOptionPane.INFORMATION_MESSAGE);
	}

}
