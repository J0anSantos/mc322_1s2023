import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();
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

	public ArrayList<Sinistro> getListaSinistros(){
		return this.listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros){
		this.listaSinistros = listaSinistros;
	}

	public ArrayList<Cliente> getListaClientes(){
		return this.listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes){
		this.listaClientes = listaClientes;
	}

	public boolean cadastrarCliente(Cliente cliente){
		for(int i=0; i<this.listaClientes.size(); i++){
			if(this.listaClientes.get(i).getNome() == cliente.getNome()){
				return false;
			}
		}

		this.listaClientes.add(cliente);
		return true;
	}

	public boolean removerCliente(String documento, String classe){
		String cpf, cnpj;
		for(int i=0; i<this.listaClientes.size(); i++){
			if(classe.equals("ClientePF")){
				if(this.listaClientes.get(i) instanceof ClientePF){
					ClientePF clientePf = (ClientePF) this.listaClientes.get(i);
					cpf = clientePf.getCpf();
					if(cpf.equals(documento)){
						this.listaClientes.remove(i);
						return true;
					}
				}
			}else{
				if(this.listaClientes.get(i) instanceof ClientePJ){
					ClientePJ clientePj = (ClientePJ) this.listaClientes.get(i);
					cnpj = clientePj.getCnpj();
					if(cnpj.equals(documento)){
						this.listaClientes.remove(i);
						return true;
					}
				}
			}
		}
		return false;
	}

	public void listarClientes(){
		
		for(int i=0; i<listaClientes.size(); i++){
			System.out.println(listaClientes.get(i).toString());
		}
	}

	public boolean gerarSinistro(Cliente cliente, Seguradora seguradora, Veiculo veiculo, String data, String endereco, Seguradora seg){
		Sinistro novoSinistro;

		novoSinistro = new Sinistro(data, endereco, seg, veiculo, cliente);
		this.listaSinistros.add(novoSinistro);

		return true;
	}

	public boolean visualizarSinistro(String cliente){
		for(int i=0; i<listaSinistros.size(); i++){
			if(listaSinistros.get(i).getCliente().getNome() == cliente){
				System.out.println(listaSinistros.get(i).toString());
				return true;
			}
		}
		return false;
	}

	public void listarSinistros(){
		for(int i=0; i<this.listaSinistros.size(); i++){
			System.out.println(this.listaSinistros.get(i).toString());
		}
	}

	// Realiza a impressão de todos os atributos da classe
	public String toString(){
		return "Seguradora\n\n" + "Nome: " + getNome() + "\nTelefone: " + getTelefone() + "\nEmail: " + getEmail()
		+ "\nEndereço: " + getEndereco() + "\nLista de Sinistros: " + getListaSinistros().size() +
		"\nLista de Clientes: " + getListaClientes().size() + "\n\n";
	}
	
}
