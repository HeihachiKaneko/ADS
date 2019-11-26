package produtos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
    private List<Produto> produto = new ArrayList<Produto>();

    public void addProduto(Produto produto) {
        this.produto.add(produto);
    }

    public void removeProduto(Produto produto) {
        this.produto.remove(produto);
    }
    
    public void setProdutos(List<Produto> produto) {
		this.produto = produto;
	}
    
    public List<Produto> getProdutos() {
		return produto;
	}
}
