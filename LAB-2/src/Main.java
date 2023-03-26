import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
			Scanner scanner = new Scanner(System.in);
			Cliente cliente = new Cliente(null, null, null, 0, null);
			Veículo veiculo = new Veículo(null, null, null);
			Seguradora seguradora = new Seguradora(null, null, null, null);
			Sinistro sinistro = new Sinistro(null, null, null);

			//cliente//
			
			System.out.print("Digite o nome do cliente: ");
			String nome = scanner.nextLine();
			cliente.setNome(nome);

			System.out.print("Digite o CPF do cliente: ");
			String cpf = scanner.nextLine();
			cliente.setCpf(cpf);

			System.out.print("Digite a Data de Nascimento do cliente: ");
			String dataNascimento = scanner.nextLine();
			cliente.setDataNascimento(dataNascimento);

			System.out.print("Digite a idade do cliente: ");
			int idade = scanner.nextInt();
			cliente.setIdade(idade);
			scanner.nextLine();
			
			System.out.print("Digite o endereço do cliente: ");
			String enderecocliente = scanner.nextLine();
			cliente.setEndereço(enderecocliente);
			
			//veículo//
			
			System.out.print("Digite o placa do veículo: ");
			String placa = scanner.nextLine();
			veiculo.setPlaca(placa);
			
			System.out.print("Digite a marca do veículo: ");
			String marca = scanner.nextLine();
			veiculo.setMarca(marca);
			
			System.out.print("Digite o modelo do veículo: ");
			String modelo = scanner.nextLine();
			veiculo.setModelo(modelo);
			
			//seguradora//
			
			System.out.print("Digite o nome da seguradora: ");
			String nomeSeguradora = scanner.nextLine();
			seguradora.setNome(nomeSeguradora);

			System.out.print("Digite o telefone da seguradora: ");
			String telefone = scanner.nextLine();
			seguradora.setTelefone(telefone);

			System.out.print("Digite o email da seguradora: ");
			String email = scanner.nextLine();
			seguradora.setEmail(email);

			System.out.print("Digite o endereço da seguradora: ");
			String endereçoseguradora = scanner.nextLine();
			seguradora.setEndereco(endereçoseguradora);

			
			//sinistro//
			
			System.out.print("Digite o Id do sinistro: ");
			String id = scanner.nextLine();
			sinistro.setId(id);
			
			System.out.print("Digite a data do sinistro: ");
			String data = scanner.nextLine();
			sinistro.setData(data);
			
			System.out.print("Digite a endereço do sinistro: ");
			String endereçosinistro = scanner.nextLine();
			sinistro.setEndereço(endereçosinistro);
		}
	
	public static boolean validarCPF(String cpf) {
		if (cpf == null || cpf.length() != 11) {
			return false;
		}

		// Remove os caracteres de formatação (pontos e hífen)//
		cpf = cpf.replaceAll("[.-]", "");

		// Verifica se o CPF é composto apenas de números//
		if (!cpf.matches("\\d+")) {
			return false;
		}

		// Verifica se os dígitos verificadores são válidos//
		int[] digitos = new int[11];
		for (int i = 0; i < 11; i++) {
			digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
		}
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += digitos[i] * (10 - i);
		}
		int resto = 11 - soma % 11;
		if (resto == 10 || resto == 11) {
			resto = 0;
		}
		if (resto != digitos[9]) {
			return false;
		}
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += digitos[i] * (11 - i);
		}
		resto = 11 - soma % 11;
		if (resto == 10 || resto == 11) {
			resto = 0;
		}
		if (resto != digitos[10]) {
			return false;
		}

		return true;
	}

}