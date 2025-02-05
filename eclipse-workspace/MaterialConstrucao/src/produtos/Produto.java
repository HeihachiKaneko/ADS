package produtos;

public class Produto {
	
	private String id;
	private String nome;
	private String descricao;
	private float preco;
	private int quantidade;
	
	public void registrarProduto(String id, float preco, String descricao, String nome) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.quantidade = 0;
    }
	
	public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    public void addQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
}
