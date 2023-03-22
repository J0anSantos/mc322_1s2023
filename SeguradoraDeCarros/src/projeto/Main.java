package projeto;

public class Main {

	public static void main(String[] args) {
		Cliente joan = new Cliente("Joan", "444.111.222.33", "26/03/1999", 23, "Rua Santo Ignácio de Loyola");
		System.out.println(joan.validarCPF(joan.getCpf()));
	}
}
