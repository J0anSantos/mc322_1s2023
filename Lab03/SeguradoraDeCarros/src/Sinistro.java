public class Sinistro {
	private static int classId = 0;
	private final int id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;

	// Construtor
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.data = data;	
		this.endereco = endereco;
		this.id = geraId();
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	// Funçâo que gera um id para o objeto
	public int geraId() {
		classId++;
		return classId;
	}
	
	// Getters e Setters
	public int getID() {
		return this.id;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Seguradora getSeguradora(){
		return this.seguradora;
	}

	public void setSeguradora(Seguradora seguradora){
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo(){
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo){
		this.veiculo = veiculo;
	}

	public Cliente getCliente(){
		return this.cliente;
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	// Realiza a impressão de todos os atributos da classe
	public String toString(){
		return "Sinistro\n\n" + "ID: " + getID() + "\nData: " + getData() + "\nEndereço: " + getEndereco() 
		+ seguradora.toString() + cliente.toString() + veiculo.toString();
	}
}
