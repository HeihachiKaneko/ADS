package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimentacao {
	private int tipo;
	private float valor;
	private String data;
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValor() {
		return valor;
	}
}
