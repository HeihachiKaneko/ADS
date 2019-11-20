package interfaceGrafica;

import javax.swing.JOptionPane;

import produtos.Produto;

public class InterfaceGrafica {
	
	//private Estoque estoque = new Estoque();
    //private List<Coupon> coupons = new ArrayList<Coupon>();
	
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
		//codigo, desc, preco
		String nomeProduto = JOptionPane.showInputDialog("Informe o produto que deseja cadastrar: ");
		String id = JOptionPane.showInputDialog("Informe o codigo do produto: ");
		String descricao = JOptionPane.showInputDialog("Descricao do produto: ");
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o preco do produto: "));
		Produto produto = new Produto();
        produto.registrarProduto(id, preco, descricao, nomeProduto);
        this.estoque.add(produto);
	}
	
	private void mostrarProdutos() {
		
	}
	
	private void adicionarProdutos() {
		
	}
	
	private void mostrarCupons(){
		
	}
	
	private void calcularCupons() {
		
	}
	
	private void venderProdutos() {
		
	}
	
}
