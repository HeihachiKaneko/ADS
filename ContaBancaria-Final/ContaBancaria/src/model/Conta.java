package model;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private String titularConta;
	private int tipo;
	private float saldo;

	private List<Movimentacao> listaDeMovimentacoes = new ArrayList<Movimentacao>();
	private List<Movimentacao> listaDeDepositos = new ArrayList<Movimentacao>();
	private List<Movimentacao> listaDeSaques = new ArrayList<Movimentacao>();

	public void depositar(float valor) {
		setSaldo(valor);
		Movimentacao movimentacao = new Movimentacao(2, valor);
		Movimentacao movimentacaoDepositos = new Movimentacao(valor);
		listaDeMovimentacoes.add(movimentacao);
		listaDeDepositos.add(movimentacaoDepositos);
	}

	public void sacar(float valor) {
		setSaldo(-valor);
		Movimentacao movimentacao = new Movimentacao(1, valor);
		Movimentacao movimentacaoSaques = new Movimentacao(valor);
		listaDeMovimentacoes.add(movimentacao);
		listaDeSaques.add(movimentacaoSaques);
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo + getSaldo();
	}

	public float getSaldo() {
		return saldo;
	}

	public void setListaDeSaques(List<Movimentacao> listaDeSaques) {
		this.listaDeSaques = listaDeSaques;
	}

	public List<Movimentacao> getListaDeSaques() {
		return listaDeSaques;
	}
	
	public void setListaDeMovimentacoes(List<Movimentacao> listaDeMovimentacoes) {
		this.listaDeMovimentacoes = listaDeMovimentacoes;
	}
	
	public List<Movimentacao> getListaDeMovimentacoes() {
		return listaDeMovimentacoes;
	}
	
	public void setListaDeDepositos(List<Movimentacao> listaDeDepositos) {
		this.listaDeDepositos = listaDeDepositos;
	}
	
	public List<Movimentacao> getListaDeDepositos() {
		return listaDeDepositos;
	}
	
	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public String getTitularConta() {
		return titularConta;
	}
}
