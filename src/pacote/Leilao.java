package pacote;
import java.util.ArrayList;

public class Leilao {
	private ArrayList<Lote> lotes;

	public Leilao() {
		lotes = new ArrayList<Lote>();
	}
	
	public Leilao(ArrayList<Lote> lotes) {
		this.lotes = lotes;
	}

	public ArrayList<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(ArrayList<Lote> lotes) {
		this.lotes = lotes;
	}
	public void inserirLote(Lote lote) {
		 lotes.add(lote);
	}
	public void receberLance(int numLote, String descricaoProduto, Lance lance) {
		lotes.get(numLote).receberPrudutoAtualizado(lance, descricaoProduto);
	}
	public 	void encerrarLeilao() {
	    System.out.printf("Chega ao fim o leilão!!\n");
	    for(Lote lote : lotes) {
	    	for(Produto prod: lote.getProdutos()) {
	    	    System.out.printf("O produto " + prod.getDescricao() + " foi adiquirido por "+ prod.getMaiorLance().getNomePessoa() + " pelo valor de "+ prod.getMaiorLance().getValor() + "$  !!\n");

	    	}

	    }
	    		
	    	
	}
	
	public ArrayList<Produto> listarProdutos() {
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		if(lotes != null) {

		for(Lote lote : lotes) {
			for(Produto produto: lote.getProdutos()) 
			listaProdutos.add(produto);
		}
		}
		return listaProdutos;
	}
}
