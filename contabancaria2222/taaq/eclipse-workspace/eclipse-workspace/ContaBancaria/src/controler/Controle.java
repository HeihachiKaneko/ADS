package controler;

import model.Conta;
import view.InterfaceGrafica;

public class Controle {

	public void controleDoMenu(int opcao) {
		InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
		Conta conta = new Conta();
		
		
			switch (opcao) {
			case 1:
				interfaceGrafica.informacoesDeposito(conta);
				break;
			case 2:
				interfaceGrafica.informacoesSaque(conta);
				break;
			case 3:
				interfaceGrafica.mostrarSaldo(conta);
				break;
			case 4:
				interfaceGrafica.mostrarDadosConta();
				break;
			case 5:
				interfaceGrafica.mostrarExtratoCompleto();
				break;
			case 6:
				interfaceGrafica.mostrarExtratoDesposito();
				break;
			case 7:
				interfaceGrafica.mostrarExtratoSaque();
				break;
			case 8:
				System.exit(0);
			default:
				break;
			}
		}
}
