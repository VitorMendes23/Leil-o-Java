package pacote;
import java.util.ArrayList;

public class Lote {

	private ArrayList<Produto> produtos;

	public Lote() {
		produtos = new ArrayList<Produto>();
	}

	public Lote(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public void inserirProduto(Produto produto) {
		produtos.add(produto);
	}
	public void receberPrudutoAtualizado(Lance lance, String descricao) {
		for(Produto prod : produtos) {
			if(prod.getDescricao().equals(descricao)) {
				if(lance.getValor() > prod.getMaiorLance().getValor())
					produtos.set(produtos.indexOf(prod), new Produto(descricao, lance));
			}
		}
	}

	public boolean equals(Lote lote) {
	    if (lote == null) {
	        return false;
	    }
	    ArrayList<Produto> outrosProdutos = lote.getProdutos();
	    if (produtos.size() != outrosProdutos.size()) {
	        return false;
	    }
	    for (int i = 0; i < produtos.size(); i++) {
	        if (!produtos.get(i).equals(outrosProdutos.get(i))) {
	            return false;
	        }
	    }
	    return true;
	}

}
