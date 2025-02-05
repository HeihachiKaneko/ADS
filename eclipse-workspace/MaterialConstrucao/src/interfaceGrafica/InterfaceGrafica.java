package interfaceGrafica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import produtos.Cupom;
import produtos.Estoque;
import produtos.Produto;

public class InterfaceGrafica {

	private Estoque estoque = new Estoque();
	private List<Cupom> cupom = new ArrayList<Cupom>();

	public void menu() {
		while (true) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Produtos\n"
					+ "2 - Listar os Produtos\n" + "3 - Adicionar Produtos\n" + "4 - Vizualizar os cupons\n"
					+ "5 - Calcular o valor dos cupons\n" + "6 - Vender Produto\n" + "7 - Sair"));

			switch (opcao) {
			case 1:
				cadastrarProdutos();
				break;
			case 2:
				mostrarProdutos();
				break;
			case 3:
				adicionarProdutos();
				break;
			case 4:
				mostrarCupons();
				break;
			case 5:
				calcularCupons();
				break;
			case 6:
				venderProdutos();
				break;
			case 7:
				System.exit(1);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Voc� informou uma op��o invalida");
				break;
			}
		}
	}

	private void cadastrarProdutos() {
		Produto produto = new Produto();
		String nomeProduto = JOptionPane.showInputDialog("Informe o produto que deseja cadastrar: ");
		String id = JOptionPane.showInputDialog("Informe o codigo do produto: ");
		for (int i = 0; i < estoque.getProdutos().size(); i++) {
			while(estoque.getProdutos().get(i).getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "Este produto ja foi adicionado!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				id = JOptionPane.showInputDialog("Informe o codigo do produto: ");
			}
		}

		
		
		String descricao = JOptionPane.showInputDialog("Descricao do produto: ");
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o preco do produto: "));
		while (preco < 1.00) {
			JOptionPane.showMessageDialog(null, "O valor do produto n�o pode ser menor que R$ 1,00", "Erro",
					JOptionPane.ERROR_MESSAGE);
			preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o preco do produto: "));
		}
		
		produto.registrarProduto(id, preco, descricao, nomeProduto);
		estoque.addProduto(produto);
	}

	private Produto pedirProduto() {
		Produto selecionarProduto = null;
		String idProduto = JOptionPane.showInputDialog("Informe o codigo do produto");
		for (Produto produto : this.estoque.getProdutos()) {
			if (produto.getId().equals(idProduto)) {
				selecionarProduto = produto;
			} else if (produto.getNome().equalsIgnoreCase(idProduto)) {
				selecionarProduto = produto;
			}
		}
		return selecionarProduto;
	}

	private void mostrarProdutos() {
		String produtos = "";
		for (Produto produto : this.estoque.getProdutos()) {
			produtos += "Produto: " + produto.getNome() + "\n" + "ID: " + produto.getId() + "\n" + "Pre�o: "
					+ produto.getPreco() + "\n" + "Quantidade: " + produto.getQuantidade() + "\n" + "Descri��o: "
					+ produto.getDescricao() + "\n" + "\n";
		}

		
		JOptionPane.showMessageDialog(null, produtos);
	}

	private void adicionarProdutos() {
		Produto produto = this.pedirProduto();
		if (produto != null) {
			int quantidade = Integer
					.parseInt(JOptionPane.showInputDialog("Quantos produtos quer adicionar ao estoque ?"));
			produto.addQuantidade(quantidade);
			
			while (quantidade < 1) {
				JOptionPane.showMessageDialog(null, "Nao e possivel adicionar quantidades negativas", "Erro",
						JOptionPane.ERROR_MESSAGE);
				quantidade = Integer
						.parseInt(JOptionPane.showInputDialog("Quantos produtos quer adicionar ao estoque ?"));
				produto.addQuantidade(quantidade);
				JOptionPane.showMessageDialog(null, "O produto foi adicionado");
			}
			JOptionPane.showMessageDialog(null, "O produto foi adicionado");
		} else {
			JOptionPane.showMessageDialog(null, "Voce digitou um produto ou codigo inexistente");
		}

	}

	private void mostrarCupons() {
		if (this.cupom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "N�o existem cupons cadastrados");
        } else {
            String mensagem = "";
            int cont = 1;
            for (Cupom cupom : this.cupom) {
                mensagem += "Cupom: " + cont + "\n" + "Produto: " + cupom.getProduto() + " quantidade: "
                        + cupom.getQuantidade() + " valor: " + cupom.getValor() + "\n";
                cont++;
            }
            JOptionPane.showMessageDialog(null, mensagem);
        }
	}

	private void calcularCupons() {
		if (this.cupom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "N�o existem cupons cadastrados");
        } else {
            float valor = 0f;
            for (Cupom cupom : this.cupom) {
                valor += cupom.getValor();
            }
            JOptionPane.showMessageDialog(null, "O valor total de cupons �: " + valor);
        }
	}

	private void venderProdutos() {
		Produto selecionarProduto = this.pedirProduto();
        if (selecionarProduto != null) {
            if (selecionarProduto.getQuantidade() > 0 ) {
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Produto encontrado, existem "
                        + selecionarProduto.getQuantidade() + " no estoque, quantos quer vender ?"));
                if (quantidade <= selecionarProduto.getQuantidade()) {
                    Cupom cupom = new Cupom();
                    cupom.setProduto(selecionarProduto.getNome());
                    cupom.setValor(selecionarProduto.getPreco() * quantidade);
                    cupom.setQuantidade(quantidade);
                    this.cupom.add(cupom);
                    selecionarProduto.removerQuantidade(quantidade);
                    JOptionPane.showMessageDialog(null, "Produto vendido");
                } else {
                    JOptionPane.showMessageDialog(null, "Voc� digitou uma quantidade que n�o temos em estoque");
                }
            } else {
                JOptionPane.showMessageDialog(null, "o estoque desse produto est� vazio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Voc� digitou um produto ou c�digo inexistente");
        }
	}

}
