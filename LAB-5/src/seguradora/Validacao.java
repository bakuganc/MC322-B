package seguradora;
public class Validacao {
	
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

		// Calcular o segundo dígito verificador//
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += (cpfArray[i] - '0') * (11 - i);
		}
		resto = soma % 11;
		int digito2 = resto < 2 ? 0 : 11 - resto;

		// Verificar o segundo dígito verificador//
		return (cpfArray[10] - '0') == digito2;
	}

	public static boolean validarCNPJ(String cnpj){
		if(cnpj.length() < 14 || cnpj == null){
			return false;
		}
		int peso = 2;
		int soma = 0;
		for(int i = 11; i >= 0; i--){
			if(10 == peso){
				peso = 2;
			}
			char letra = cnpj.charAt(i);
			int digito = letra - '0';
			int parcela =   digito * peso;
			soma += parcela;
			peso++;

		}
		int primDigitoVerif = soma % 11;
		if(primDigitoVerif == 0 || primDigitoVerif == 1){
			primDigitoVerif = 0;
		}
		else{
			int temp = primDigitoVerif;
			primDigitoVerif = 11 - temp;
		}
		peso = 2;
		soma = 0;
		for(int j = 12; j >= 0; j--){
			if(10 == peso){
				peso = 2;
			}
			char letra = cnpj.charAt(j);
			int digito = letra - '0';
			int parcela =   digito * peso;
			soma += parcela;
			peso++;
		}
		int segDigitoVerif = soma % 11;
		if(segDigitoVerif == 0 || segDigitoVerif == 1){
			segDigitoVerif = 0;
		}
		else{
			int temp = segDigitoVerif;
			segDigitoVerif = 11 - temp;
		}
		char l1 = cnpj.charAt(12);
		int d1 = l1 - '0';
		char l2 = cnpj.charAt(13);
		int d2 = l2 - '0';

		if(primDigitoVerif == d1 && d2 == segDigitoVerif){
			return true;
		}

		return false;

	}
	public static boolean validacaoStringSomenteLetras(String mensagem){
		for(int i = 0;i < mensagem.length();i++){
			char letra = mensagem.charAt(i);
			if('a' <= letra && letra <= 'z' || 'A' <= letra && letra<= 'Z' ||
				letra == ' '){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean validacaoStringSomenteNumeros(String mensagem){
		for(int i = 0;i < mensagem.length();i++){
			char numero = mensagem.charAt(i);
			if('0' <= numero && numero <= '9'){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean validacaoPlaca(String placa, boolean isMercoSul){
		int numerais = 0;
		int letras = 0;
		// 1) Verificação MercoSul
		if(placa.length() != 7){
			return false;
		}
		for(int i = 0;i < placa.length(); i++){
			char digito = placa.charAt(i);
			if(isMercoSul && '0'<=  digito && digito <='9'){
				numerais++;
			}
			else if(isMercoSul && 'A' <= digito && digito <= 'Z'){
				letras++;
			}
			else{
				return false;
			}
		}
		if(letras == 4 && numerais == 3){
			return true;
		}
		// Validação de placas pré-MercoSul
		numerais = letras = 0;
		for(int i = 0;i < placa.length(); i++){
			char digito = placa.charAt(i);
			if('0'<= digito && digito <='9'){
				numerais++;
			}
			else if('A' <= digito && digito <= 'Z'){
				letras++;
			}
			else if(digito == '-'){
				continue;
			}
			else{
				return false;
			}
		}
		if(letras == 3 && numerais == 4 && !isMercoSul){
			return true;
		}
		return false;

	}
	private static int contarNumeroDePalavras(String str,String regex){
		if(str == null){
			return -1;
		}
		int contador = 0;
		for(String s : str.split(regex)){
			contador++;
		}
		return contador;

	}
	public static boolean validacaoStringEndereco(String endereco){
		if(endereco == null || endereco.length() == 0){
			return false;
		}
		int iteracao = 0;
		if(contarNumeroDePalavras(endereco," ")<2){
			return false;
		}
		for(String s : endereco.split(" ")){
			if(iteracao == 0 && validacaoStringSomenteNumeros(s)){
				iteracao++;
				continue;
			} 
			else if(validacaoStringSomenteLetras(s) && iteracao != 0){
				iteracao++;
				continue;
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	public static boolean validacaoStringNumeroEndereco(String numero){
		return validacaoStringSomenteNumeros(numero);
		
	}
	private static boolean isDigito(char digit){
		return '0' <= digit && digit <= '9';
	}
	public static boolean validacaoStringTelefone(String telefone){
		if(telefone == null || telefone.length() == 0 ){
			return false;
		}
		// 01234567891011121314
		// (11)12345-67890
		boolean isTelefone = true;
		final int posicaoTraco = 10;
		final int posicaoComecoParenteses = 0;
		final int posicaoFinalParenteses = 3;
		final int posicaoEspaco = 4;
		for(int i = 0;i<telefone.length();i++){
			char digito = telefone.charAt(i);
			if(i == posicaoComecoParenteses && digito != '('){
				isTelefone = false;
				break;
			}
			else if(i == posicaoFinalParenteses && digito != ')'){
				isTelefone = false;
				break;
			}
			else if(i == posicaoTraco && digito != '-'){
				isTelefone = false;
				break;
			}
			else if(digito != ' ' && i == posicaoEspaco){
				isTelefone = false;
				break;
			}
			else if((!isDigito(digito) && i != posicaoEspaco && i != posicaoTraco && i != posicaoFinalParenteses && i != posicaoComecoParenteses) ||  telefone.length() != 15){
				isTelefone = false;
				break;
			}
			
		}
		return isTelefone;
	}
}

