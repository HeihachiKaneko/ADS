package produtos;

public class Cupom {
    private float valor;
    private String produto;
    private int quantidade;

    public void setValor(float valor) {
		this.valor = valor;
	}
    
    public float getValor() {
		return valor;
	}
    
    public void setProduto(String produto) {
		this.produto = produto;
	}
    
    public String getProduto() {
		return produto;
	}
    
    public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
    
    public int getQuantidade() {
		return quantidade;
	}
    
}