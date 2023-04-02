package pacote;

public class Lance {

	private float valor;
	private Pessoa pessoa;
	
	public Lance() {
		valor = 0;
		pessoa = null;
	}
	
	public Lance(float valor, Pessoa pessoa) {
		this.valor = valor;
		this.pessoa = pessoa;
	}
	public Lance(float valor) {
		this.valor = valor;
		pessoa = null;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public String getNomePessoa() {
		return pessoa.getNome();
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public boolean equals(Lance lance) {
		if(this.valor == lance.valor && this.pessoa.equals(lance.getPessoa()))
			return true;
		else
			return false;
	}
}
