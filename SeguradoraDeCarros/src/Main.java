import java.util.Scanner;

// Classe principal do programa
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sinistro sin1, sin2;
		String cpf;
		
		
		Cliente cliente1 = new Cliente("Joan", "721.651.110-40", "26/03/1999", 23, "Rua Um");
		Seguradora seg1 = new Seguradora("A seguradora", "4002-8922", "aseguradora@gmail.com", "Rua Um");
		Veiculo v1 = new Veiculo("ABC-1234", "Fiat", "Uno");
		sin1 = new Sinistro("25/08/2022", "Rua dois");
		sin2 = new Sinistro("27/04/2022", "Rua Dez");
		
		

		// Caso o CPF do cliente esteja incorreto, o usuario deve digitar um novo cpf ate que seja algum valido
		while(!cliente1.validarCPF(cliente1.getCpf())){
			System.out.print("CPF incorreto, informe um novo: ");
			cpf = sc.nextLine();
			cliente1.setCpf(cpf);
		}

		System.out.print("\n");



		//Teste de objetos
		
		System.out.println(cliente1.toString());
		System.out.println(seg1.toString());
		System.out.println(sin1.toString());
		System.out.println(sin2.toString());
		System.out.println(v1.toString());

		sc.close();
	}
}
