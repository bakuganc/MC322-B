package clientepf;
import Client.Cliente;
import java.util.Date;
import java.util.Scanner;
public class ClientePF extends Cliente { 

	final private String cpf;
	private String genero;
	private Date dataNascimento;
	private Date dataLicenca;
	private String educacao;
	private String classeEconomica;
	// getters e setters 
	public ClientePF(String nome, String endereco,String cpf, String genero, Date dataNascimento, Date dataLicenca, String educacao, String classeEconomica){
			
		super(nome,endereco);
		Scanner sc = new Scanner(System.in);
		while(!validarCPF(cpf)){
			System.err.println("Erro - CPF invalido!");
			System.err.println("Digite outro CPF: ");
			cpf = sc.nextLine();
		}
		this.cpf = cpf;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.classeEconomica = classeEconomica;
	}
	public String getGenero(){
		return genero;
	}

	public String getCPF(){
		return cpf;
	}

	public Date getDataNascimento(){
		return dataNascimento;
	}
	
	public Date getDataLicenca(){
		return dataLicenca;
	}

	public String getEducacao(){
		return educacao;
	}
	
	public String getclasseEconomica(){
		return classeEconomica;
	}

	public void setGenero(String genero){
		this.genero = genero;
	}


	public void setDataNascimento(Date dataNascimento){
		this.dataNascimento = dataNascimento;
	}

	public void setDataLicenca(Date dataLicenca){
		this.dataLicenca = dataLicenca;
	}

	public void setEducacao(String educacao){
		this.educacao = educacao;
	}
	
	public void setClasseEconomica(String classeEconomica){
		this.classeEconomica  = classeEconomica;
	}
	@Override 
	public String toString(){
		String str = new String();
		str += "nome: "+ getNome() + '\n'+ "endereco: " + getEndereco() +'\n' + "cpf: " + cpf + '\n' + "genero: " + genero + '\n' + "data nascimento: " + dataNascimento + '\n' + "data licenca: " + dataLicenca + '\n' + "educacao: " + educacao + '\n' + "classe economica: " + classeEconomica + '\n';  
		return str;
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
	
	}
