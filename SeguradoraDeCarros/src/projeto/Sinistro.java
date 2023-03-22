package projeto;


public class Sinistro {
	private static int classId = 0;
	private int id;
	private String data;
	private String endereco;
	
	
	// Construtor
	public Sinistro(String data, String endereco) {
		this.data = data;	
		this.endereco = endereco;
		this.id = geraId();
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
}
