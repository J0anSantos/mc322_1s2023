import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private Date dataFundacao;
    private String cnpjFormatado;

    public ClientePJ(String nome, String endereco, Date dataLicensa, String educacao, String genero, String classeEconomica, ArrayList<Veiculo> listaVeiculos, String cnpj, Date dataFundacao){
        super(nome, endereco, dataLicensa, educacao, genero, classeEconomica);
        this.dataFundacao = new Date();
        this.dataFundacao = dataFundacao;
        this.cnpj = cnpj;
    }

    // Retorna o CPF
    public String getCnpj() {
        return this.cnpj;
    }

  // Retorna a data de nascimento
  public Date getDataFundacao() {
        return this.dataFundacao;
    }
  
  // Altera a data de nascimento
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

  // Retorna a quantidade de números existentes no CPF informado
	public int tamanhoCNPJ(String cnpj){
        return cnpj.length();
    }

 // Função que formata o CPF, removendo os caracteres especiais e alterando a variavel de classe: cpfFormatado
	public void formataCNPJ(String cnpj){
        this.cnpjFormatado = cnpj.replaceAll("\\.", "");
        this.cnpjFormatado = this.cnpjFormatado.replaceAll("-", "");
        this.cnpjFormatado = this.cnpjFormatado.replaceAll("/", "");
    }

 // Verifica se todos os numeros do CNPJ são iguais e retorna falso caso nao sejam todos iguais
	public boolean ehIgual(char cnpj[]){
        char ini = cnpj[0];

        for(int i = 1; i<14; i++){
            if(cnpj[i] != ini)
                return false;
        }
        return true;
    }

    public boolean primeiroDigitoVerificador(char vetCNPJ[]){
        int vet[] = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0, resto, codigoVerificador;

        for(int i=0; i < 12; i++)
            soma += (vet[i] * Character.getNumericValue(vetCNPJ[i]));

        resto = soma % 11;
        if(resto < 2)
            codigoVerificador = 0;
        else
            codigoVerificador = 11 - resto;
        
        if(codigoVerificador == Character.getNumericValue(vetCNPJ[12]))
            return true;
        return false;
    }

    public boolean segundoDigitoVerificador(char vetCNPJ[]){
        int vet[] = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0, resto, codigoVerificador;

        for(int i=0; i < 13; i++)
            soma += (vet[i] * Character.getNumericValue(vetCNPJ[i]));

        resto = soma % 11;

        if(resto < 2)
            codigoVerificador = 0;
        else
            codigoVerificador = 11 - resto;
    
        if(codigoVerificador == Character.getNumericValue(vetCNPJ[13]))
            return true;
        return false;
    }

    public boolean validarCNPJ(String cnpj){
        char vetCNPJ[];

		  formataCNPJ(cnpj);

		  // vetCNPJ é um vetor de caracteres que guarda todos os elementos do CNPJ
		  vetCNPJ = cnpjFormatado.toCharArray();

		  // Verificação do tamanho da String CNPJ, se tamanho incorreto é retornado falso
		  if(tamanhoCNPJ(this.cnpjFormatado) != 14)
			  return false;
		  // Verifica se todos os números do CNPJ são iguais, caso sejam todos iguais retorna falso
		  else if(ehIgual(vetCNPJ) == true)
		      return false;

        // Retorna true se o primeiro e o segundo digito verificador for válido
		  if(primeiroDigitoVerificador(vetCNPJ) && segundoDigitoVerificador(vetCNPJ))
			  return true;
		  else
			  return false;
    }
    
    // Realiza a impressão de todos os atributos da classe  
	  @Override
	  public String toString(){
		return super.toString() + "\nData de Fundação: " + getDataFundacao() +
		"\nCNPJ do cliente: " + getCnpj() + "\n\n";
	  }

}
