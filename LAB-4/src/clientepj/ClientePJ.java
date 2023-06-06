package clientepj;
import Client.Cliente;
import java.util.Date;
import java.util.Scanner;
import validation.Validacao;
import Erro.SeguradoraErro;
import java.util.ArrayList;
import Principal.Main;
import veiculo.Veiculo;
import calcseguro.CalcSeguro;
public class ClientePJ extends Cliente { 
	private static String cnpj;
	private Date dataFundacao;
	static int qtdeFuncionarios;

	public ClientePJ(String nome, String endereco,String cnpj,
		Date dataFundacao,int quantidadeDeFuncionarios){
		super(nome,endereco);
		Scanner sc = new Scanner(System.in);
		while(!Validacao.validarCNPJ(cnpj)){
			SeguradoraErro.imprimirMensagemErro("Erro - cnpj invalido!");
			SeguradoraErro.imprimirMensagemErro("Digite outro cnpj");
			cnpj = sc.nextLine();
		}
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = quantidadeDeFuncionarios;
		adicionarVeiculo();
	}
	public ClientePJ(String nome, String endereco,String cnpj,
	Date dataFundacao,int quantidadeDeFuncionarios,
	String placa,String marca,String modelo){
		super(nome,endereco);
		Scanner sc = new Scanner(System.in);
		while(!Validacao.validarCNPJ(cnpj)){
			SeguradoraErro.imprimirMensagemErro("Erro - cnpj invalido!");
			SeguradoraErro.imprimirMensagemErro("Digite outro cnpj");
			cnpj = sc.nextLine();
		}
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = quantidadeDeFuncionarios;
		Veiculo veiculo = new Veiculo(placa,marca,modelo);
		this.getListaVeiculos().add(veiculo);
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
		Veiculo veiculo = new Veiculo(arrayStr.get(0),arrayStr.get(1),arrayStr.get(2));
		getListaVeiculos().add(veiculo);
	}

	static public double calculaScore(){
		CalcSeguro cs = CalcSeguro.VALOR_BASE;

		return cs.getFator() * (1 + (getQtdeFuncionarios())/100) * Cliente.getListaVeiculos().size();
		
	}
	
	@Override
	public String toString(){
		String str = new String();
		str += "nome: " + getNome() + '\n' + "endereço " + getEndereco() + '\n' 
		+ "cnpj: "+cnpj + '\n' + "data fundação: " + dataFundacao 
		+ '\n' + "quantidade De "+ "Funcionarios" + qtdeFuncionarios 
		+ '\n' + Cliente.mostrarVeiculos()+ '\n';
		return str;
	}
	public static String getCNPJ(){
		return cnpj;
	}
	
	public Date getDateFundacao(){
		return dataFundacao;
	}
	
	public void setDataFundacao(Date data){
		dataFundacao = data;
	}
	public void setqtdeFuncionarios(int qtd){
		this.qtdeFuncionarios = qtd;
	}
	static public int getQtdeFuncionarios(){
		return qtdeFuncionarios;
	}

}
