import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

// Classe principal do programa


public class Main {

	// Design no Menu
	public static void modeloMenu(){
		System.out.println(" Sistema de Seguradora de Carros \n");
		System.out.println(" 1 - Listar Clientes de Seguradora");
		System.out.println(" 2 - Listar Sinistros");
		System.out.println(" 0 - Sair do programa");
	}

	// Classe que converte uma string pra Date
	public static Date converteStringParaDate(String data){
		Date objData;
		Calendar calendario = Calendar.getInstance();
		int dia, mes, ano;
		String partes[] = data.split("/");

		dia = Integer.parseInt(partes[0]);
		mes = Integer.parseInt(partes[1]) - 1;
		ano = Integer.parseInt(partes[2]);
		calendario.set(Calendar.YEAR, ano);
		calendario.set(Calendar.MONTH, mes);
		calendario.set(Calendar.DAY_OF_MONTH, dia);

		objData = calendario.getTime();
		return objData;
	}


	public static void main(String[] args) {
		int resposta;
		Date dataLicenca, dataFundacao, dataNasc;
		Seguradora seg;
		ClientePF cli1, cli3;
		ClientePJ cli2;
		Veiculo v1, v2, v3; 
		Scanner sc = new Scanner(System.in);
		boolean remove;

		// Criando datas
		dataNasc = converteStringParaDate("26/03/1999");
		dataFundacao = converteStringParaDate("01/02/2021");
		dataLicenca = converteStringParaDate("23/03/2022");
		
		// Criando objetos da classe Veiculo
		v1 = new Veiculo("ABC-1234", "Fiat", "Uno", 2022);
		v2 = new Veiculo("DEF-5678", "Honda", "Civic", 2018);
		v3 = new Veiculo("GHI-8920", "Chevrolet", "Onix", 2015);

		// Criando objetos da classe Cliente
		cli1 = new ClientePF("Joan", "Rua Um", dataLicenca, "Ensino Medio completo", "Masculino", "Media", null, "371.581.760-70", dataNasc);
		cli2 = new ClientePJ("João", "Rua Dois", dataLicenca, "Ensino Medio Completo", "Masculino", "Media", null, "34.666.931/0001-45", dataFundacao);
		cli3 = new ClientePF("Maria", "Rua Cinco", dataLicenca, "Ensino Medio completo", "Feminino", "Media", null, "664.436.430-62", dataNasc);

		// Validando cpf do cliente um
		if(cli1.validarCPF(cli1.getCpf()) == true)
			System.out.println("O cpf do cliente " + cli1.getNome() + " é valido!");
		else
			System.out.println("O cpf do cliente " + cli1.getNome() + " não é valido!");
		
		// Validando cnpj do cliente dois
		if(cli2.validarCNPJ(cli2.getCnpj()) == true)
			System.out.println("O cnpj do cliente " + cli2.getNome() + " é valido!");
		else
			System.out.println("O cnpj do cliente " + cli2.getNome() + " não é valido!");

		// Adicionando um veiculo para cada cliente	
		cli1.adicionarVeiculo(v1);
		cli2.adicionarVeiculo(v3);
		cli3.adicionarVeiculo(v2);

		// Cadastrando cliente PJ e PF na seguradora
		seg = new Seguradora("Seguradora A", "4002-8922", "seguradoraA@gmail.com", "Rua Dez");
		seg.cadastrarCliente(cli1);
		seg.cadastrarCliente(cli2);
		seg.cadastrarCliente(cli3);

		// Remoção de um cliente da seguradora
		remove = seg.removerCliente(cli3.getCpf(), cli3.getClass().getName());

		if(remove == true){
			System.out.println("Cliente removido com sucesso!");
		}else{
			System.out.println("O cliente não existe no sistema!");
		}

		// Gerando sinistro do cliente 2
		seg.gerarSinistro(cli2, seg, v3, "25/03/2021", "Rua vinte e dois", seg);


		// Utilizando metodo toString() de cada classe
		System.out.println(cli1.toString());
		System.out.println(v1.toString());

		System.out.println(seg.toString());
		seg.listarSinistros(); // Utilizando toString em todos os sinistros gerados.


		// É gerado um menu pra interagir com o Cliente
		do{
			modeloMenu();
			resposta = sc.nextInt();

			if(resposta == 1){
				seg.listarClientes();
			}else if(resposta == 2){
				seg.listarSinistros();
			}else if(resposta == 0){
				System.out.println("Encerrando programa...");
			}else{
				System.out.println("Opção incorreta, tente novamente");
			}
		}while(resposta != 0);
		
		sc.close();
	}
}
