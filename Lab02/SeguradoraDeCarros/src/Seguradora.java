public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	// Getters e Setters
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	// Realiza a impressão de todos os atributos da classe
	public String toString(){
		return "Seguradora\n\n" + "Seguradora: " + getNome() + "\nTelefone: " + getTelefone() + "\nEmail: " + getEmail()
		+ "\nEndereço: " + getEndereco() + "\n\n";
	}
	
}
