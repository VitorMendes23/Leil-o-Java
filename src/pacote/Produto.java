package pacote;

public class Produto {

	private String descricao;
	private Lance maiorLance;
	
	public Produto() {
		descricao = "";
		maiorLance = null;
	}
	
	public Produto(String descricao, Lance maiorLance) {
		this.descricao = descricao;
		this.maiorLance = maiorLance;
	}
	public Produto(String descricao) {
		this.descricao = descricao;
		this.maiorLance = new Lance();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Lance getMaiorLance() {
		return maiorLance;
	}

	public void setMaiorLance(Lance maiorLance) {
		this.maiorLance = maiorLance;
	}
	public Lance verificarMaiorLance(Lance lance) {
		
		if (maiorLance.getValor() < lance.getValor()) {
			return lance;
		}else {
			return maiorLance;
		}
	}

}
