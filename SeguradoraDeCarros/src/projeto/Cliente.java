package projeto;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Construtor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	// Getters e Setters
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString(){
		return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nData de Nascimento: " + getDataNascimento()
		+ "\nIdade: " + getIdade() + "\nEndereço: " + getEndereco();
	}
	//TODO implementar toString(): String; validarCPF(String cpf) : boolean;
}
