package model;

import java.util.List;
import java.util.ArrayList;

public class Conta {
	private String titularConta;
	private int tipo;
	private float saldo;
	private List<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>(); 
	private List<Movimentacao> listaDeDepositos = new ArrayList<Movimentacao>();
    private List<Movimentacao> listaDeSaques = new ArrayList<Movimentacao>();
    
	public void setListaDeMovimentacao(List<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}
	
	public List<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}
	
	public void depositar(float valor) {
		setSaldo(valor);
	}
	
	public void sacar(float valor) {
		setSaldo(-valor);
			
		
	}
	
	public void consultarSaldo() {
		
	}
	
	public void gerarExtrato() {
		
	}
	
	public void gerarExtrtoDepositos() {
		
	}
	
	public void gerarExtratoSaques() {
		
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}
	
	public String getTitularConta() {
		return titularConta;
	}
}
