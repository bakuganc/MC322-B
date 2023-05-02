import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			Cliente cliente = new Cliente(null, null, null, 0, null);
			Veículo veiculo = new Veículo(null, null, null);
			Seguradora seguradora = new Seguradora(null, null, null, null);
			Sinistro sinistro = new Sinistro(null, null, null);

			// cliente//

			System.out.print("Digite o nome do cliente: ");
			String nome = scanner.nextLine();
			cliente.setNome(nome);

			for(;;){
				System.out.print("Digite o CPF do cliente: ");
				String cpf = scanner.nextLine();
				
				boolean valido = validarCPF(cpf);
				if (valido == true) {
					cliente.setCpf(cpf);
					break;
				}
				else {
					System.out.println("CPF inválido");
				}
			}
				
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

			// veículo//

			System.out.print("Digite o placa do veículo: ");
			String placa = scanner.nextLine();
			veiculo.setPlaca(placa);

			System.out.print("Digite a marca do veículo: ");
			String marca = scanner.nextLine();
			veiculo.setMarca(marca);

			System.out.print("Digite o modelo do veículo: ");
			String modelo = scanner.nextLine();
			veiculo.setModelo(modelo);

			// seguradora//

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

			// sinistro//

			String id = sinistro.getId();
			sinistro.setId(id);
			System.out.println("O ID do sinistro é: " + id);

			System.out.print("Digite a data do sinistro: ");
			String data = scanner.nextLine();
			sinistro.setData(data);

			System.out.print("Digite a endereço do sinistro: ");
			String endereçosinistro = scanner.nextLine();
			sinistro.setEndereço(endereçosinistro);
		}

		System.out.println();

	}

	
	public static boolean validarCPF(String cpf) {
		if (cpf == null || cpf.length() != 11) {
			return false;
		}

		// Converter a string em um array de caracteres//
		char[] cpfArray = cpf.toCharArray();

		// Verificar se todos os caracteres são dígitos//
		for (char c : cpfArray) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		// Calcular o primeiro dígito verificador//
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += (cpfArray[i] - '0') * (10 - i);
		}
		int resto = soma % 11;
		int digito1 = resto < 2 ? 0 : 11 - resto;

		// Verificar o primeiro dígito verificador//
		if ((cpfArray[9] - '0') != digito1) {
			return false;
		}

		// Calcular o segundo dígito verifi+cador//
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += (cpfArray[i] - '0') * (11 - i);
		}
		resto = soma % 11;
		int digito2 = resto < 2 ? 0 : 11 - resto;

		// Verificar o segundo dígito verificador//
		return (cpfArray[10] - '0') == digito2;
	}
	
}