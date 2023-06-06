package clientepf;
import Client.Cliente;
import java.util.Date;
import java.util.Scanner;
import validation.Validacao;
import java.util.ArrayList;
import Principal.Main;
import veiculo.Veiculo;
import validation.Validacao;
import Erro.SeguradoraErro; 
import calcseguro.CalcSeguro;
public class ClientePF extends Cliente { 

	private static String cpf;
	private String genero;
	static private Date dataNascimento;
	private Date dataLicenca;
	private String educacao;
	private String classeEconomica;
	// getters e setters 
	public ClientePF(String nome, String endereco,String cpf, String genero, Date dataNascimento, Date dataLicenca, String educacao, String classeEconomica){
		super(nome,endereco);
		while(!Validacao.validarCPF(cpf)){
			SeguradoraErro.imprimirMensagemErro("Erro - CPF invalido!");
			cpf = Main.input("Digite outro CPF: ");
		}
		while(!Validacao.validacaoStringSomenteLetras(genero)){
			SeguradoraErro.imprimirMensagemErro("Erro - genero invalido!");
			cpf = Main.input("Digite outro CPF: ");
		}
		while(!Validacao.validacaoStringSomenteLetras(educacao)){
			SeguradoraErro.imprimirMensagemErro("Erro - educacao invalida!");
			educacao = Main.input("Digite outra educacao: ");
		}
		while(!Validacao.validacaoStringSomenteLetras(classeEconomica)){
			SeguradoraErro.imprimirMensagemErro("Erro - classe economica" + 
			"invalida!");
			educacao = Main.input("Digite outra educacao: ");
		}
		this.cpf = cpf;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.classeEconomica = classeEconomica;
		adicionarVeiculo();
	}
	public ClientePF(String nome, String endereco,String cpf,
	String genero, Date dataNascimento, Date dataLicenca, 
	String educacao, String classeEconomica,String placa,
	String marca,String modelo){
		super(nome,endereco);
		Scanner sc = new Scanner(System.in);
		while(!Validacao.validarCPF(cpf)){
			SeguradoraErro.imprimirMensagemErro("Erro - CPF invalido!");
			SeguradoraErro.imprimirMensagemErro("Digite outro CPF: ");
			cpf = sc.nextLine();
		}
		while(!Validacao.validacaoStringSomenteLetras(genero)){
			SeguradoraErro.imprimirMensagemErro("Erro - genero invalido!");
			cpf = Main.input("Digite outro CPF: ");
		}
		while(!Validacao.validacaoStringSomenteLetras(educacao)){
			SeguradoraErro.imprimirMensagemErro("Erro - educacao invalida!");
			educacao = Main.input("Digite outra educacao: ");
		}
		while(!Validacao.validacaoStringSomenteLetras(classeEconomica)){
			SeguradoraErro.imprimirMensagemErro("Erro - classe economica" + 
			"invalida!");
			educacao = Main.input("Digite outra educacao: ");
		}
		this.cpf = cpf;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.classeEconomica = classeEconomica;
		Veiculo veiculo = new Veiculo(placa,marca,modelo);
		this.getListaVeiculos().add(veiculo);
	}
	public String getGenero(){
		return genero;
	}

	public static String getCPF(){
		return cpf;
	}

	static public Date getDataNascimento(){
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
	static public void adicionarVeiculo(){
		ArrayList<String> arrayStr = new ArrayList<String>();
		String str = new String();
		str = Main.input("Digite a placa");
		arrayStr.add(str);
		str = Main.input("Digite a marca");
		arrayStr.add(str);
		str = Main.input("Digite o modelo");
		arrayStr.add(str);
		Veiculo veiculo = new Veiculo(arrayStr.get(0),
		arrayStr.get(1),arrayStr.get(2));
		getListaVeiculos().add(veiculo);
	}
	static public double calculaScore(long idade){
		if(idade <= 18 || idade >90){
			throw new IllegalArgumentException("Erro: idade deve" +
			"ser maior ou igual a 18 e menor ou igual a 90");
		}
		CalcSeguro cs = CalcSeguro.VALOR_BASE;

		return cs.getFator() * cs.mudarFator(idade).getFator()
		* Cliente.getListaVeiculos().size();
	}
	@Override 
	public String toString(){
		String str = new String();
		str += "nome: "+ getNome() + '\n'+ "endereco: " + 
		getEndereco() +'\n' + "cpf: " + cpf + '\n' + "genero: " + 
		genero + '\n' + "data nascimento: " + dataNascimento + '\n' 
		+ "data licenca: " + dataLicenca + '\n' + "educacao: " 
		+ educacao + '\n' + "classe economica: " + classeEconomica + '\n' + 
		"carros:\n" + Cliente.mostrarVeiculos() + '\n';
		return str;
	}
	
}
