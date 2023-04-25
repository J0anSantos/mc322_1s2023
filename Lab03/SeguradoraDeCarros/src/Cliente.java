import java.util.Date;
import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private ArrayList<Veiculo> listaVeiculos;
	
	// Construtor da classe Cliente
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = new Date();
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}
	
	// Getters e Setters
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataLicenca(){
		return this.dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca){
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao(){
		return this.educacao;
	}

	public void setEducacao(String educacao){
		this.educacao = educacao;
	}

	public String getGenero(){
		return this.genero;
	}

	public void setGenero(String genero){
		this.genero = genero;
	}

	public String getClasseEconomica(){
		return this.classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica){
		this.classeEconomica = classeEconomica;
	}

	public ArrayList<Veiculo> getListaVeiculos(){
		return this.listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos){
		this.listaVeiculos = listaVeiculos;
	}

	public void adicionarVeiculo(Veiculo novoVeiculo){
		this.listaVeiculos.add(novoVeiculo);
	}
	
	// Realiza a impressão de todos os atributos da classe
	public String toString(){
		return "Cliente\n\n" + "Nome: " + getNome() + "\nEndereço: " + getEndereco() +
		"\nData Licença: " + getDataLicenca() + "\nEducação: " + getEducacao() + 
		"\nGênero: " + getGenero() + "\nClasse Econômica: " + getClasseEconomica() +
		"\nVeiculos: " + getListaVeiculos() + "\n\n";
	}
	
	
}
