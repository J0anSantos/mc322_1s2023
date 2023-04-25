import java.util.Date;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private Date dataNascimento;
    private final String cpf;
    private String cpfFormatado;

    // Construtor da subclasse ClientePF
    public ClientePF(String nome, String endereco, Date dataLicensa, String educacao, String genero, String classeEconomica, ArrayList<Veiculo> listaVeiculos, String cpf, Date dataNascimento){
        super(nome, endereco, dataLicensa, educacao, genero, classeEconomica);
        this.dataNascimento = new Date();
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    // Retorna o CPF
    public String getCpf() {
		  return this.cpf;
	  }

    // Retorna a data de nascimento
    public Date getDataNascimento() {
		  return this.dataNascimento;
	  }
	
    // Altera a data de nascimento
	  public void setDataNascimento(Date dataNascimento) {
		  this.dataNascimento = dataNascimento;
	  }

    // Retorna a quantidade de números existentes no CPF informado
	  public int tamanhoCPF(String cpf){
		  return cpf.length();
	  }

    // Função que formata o CPF, removendo os caracteres especiais e alterando a variavel de classe: cpfFormatado
	  public void formataCPF(String cpf){
		  this.cpfFormatado = cpf.replaceAll("\\.", "");
		  this.cpfFormatado = this.cpfFormatado.replaceAll("-", "");
	  }

    // Verifica se todos os numeros do CPF são iguais e retorna falso caso nao sejam todos iguais
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
	  @Override
	  public String toString(){
		return super.toString() + "\nData de Nascimento: " + getDataNascimento() +
		"\nCPF do cliente: " + getCpf() + "\n\n";
	  }
}
