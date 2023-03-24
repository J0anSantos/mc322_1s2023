public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	private String cpfFormatado;
	
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

	// Função que formata o CPF, removendo os caracteres especiais e alterando a variavel de classe: cpfFormatado
	public void formataCPF(String cpf){
		this.cpfFormatado = cpf.replaceAll("\\.", "");
		this.cpfFormatado = this.cpfFormatado.replaceAll("-", "");
	}

	// Retorna a quantidade de números existentes no CPF informado
	public int tamanhoCPF(String cpf){
		return cpf.length();
	}

	// Verifica se todos os numeros do CPF são iguais e retorna falso caso nao sejem todos iguais
	public boolean ehIgual(char cpf[]){
		char ini = cpf[0];

		for(int i = 1; i<11; i++){
        	if(cpf[i] != ini)
				return false;
		}
		return true;
	}

	// Retorna se o primeiro digito verificador é válido ou não
	public boolean primeiroDigitoVerificador(char cpf[]){
		int ini = 10, soma = 0, resto;
		
		for(int i = 0; i < 9; i++){
			soma += (Character.getNumericValue(cpf[i]) * ini); 
			ini -= 1;
		}

		resto = soma % 11;
		if((resto < 2 && Character.getNumericValue(cpf[9]) == 0) || (resto >= 2 && Character.getNumericValue(cpf[9]) == (11 - resto)))
			return true;
		else
			return false;
	}

	// Retorna se o segundo digito verificador é válido ou não
	public boolean segundoDigitoVerificador(char cpf[]){
		int ini = 11, soma = 0, resto;

		for(int i = 0; i < 10; i++){
			soma += (Character.getNumericValue(cpf[i]) * ini);
			ini -= 1;
		}

		resto = soma % 11;

		if((resto < 2 && Character.getNumericValue(cpf[10]) == 0) || (resto >= 2 && Character.getNumericValue(cpf[10]) == (11 - resto)))
			return true;
		else
			return false;
	}

	// Realiza a validação de um dado CPF de uma classe
	public boolean validarCPF(String cpf){
		char vetCPF[];

		formataCPF(cpf);

		// vetCPF é um vetor de caracteres que guarda todos os elementos do CPF
		vetCPF = cpfFormatado.toCharArray();


		// Verificação do tamanho da String CPF, se tamanho incorreto é retornado falso
		if(tamanhoCPF(cpfFormatado) != 11)
			return false;
		
		// Verifica se todos os números do CPF são iguais, caso sejam todos iguais retorna falso
		else if(ehIgual(vetCPF) == true)
		    return false;
		
		// Retorna true se o primeiro e o segundo digito verificador for válido
		if(primeiroDigitoVerificador(vetCPF) && segundoDigitoVerificador(vetCPF))
			return true;
		else
			return false;
	}
	
	// Realiza a impressão de todos os atributos da classe
	public String toString(){
		return "Cliente\n\n" + "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nData de Nascimento: " + getDataNascimento()
		+ "\nIdade: " + getIdade() + "\nEndereço: " + getEndereco() + "\n\n";
	}
	
	
}
