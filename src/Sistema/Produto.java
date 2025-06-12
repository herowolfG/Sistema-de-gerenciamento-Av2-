package Sistema;

public class Produto {
	private int Codigo;
	private String Nome;
	private String Setor;
	private Float Valor;
	private Float ValorO;
	private String Fornecedor;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSetor() {
		return Setor;
	}
	public void setSetor(String setor) {
		Setor = setor;
	}
	public Float getValor() {
		return Valor;
	}
	public void setValor(Float valor) {
		Valor = valor;
	}
	public Float getValorO() {
		return ValorO;
	}
	public void setValorO(Float valorO) {
		ValorO = valorO;
	}
	public String getFornecedor() {
		return Fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		Fornecedor = fornecedor;
	}

}
