package clientepj;
import Client.Cliente;
import java.util.Date;
import java.util.Scanner;

public class ClientePJ extends Cliente { 
	final private String cnpj;
	private Date dataFundacao;

	public ClientePJ(String nome, String endereco,String cnpj, Date dataFundacao){
		super(nome,endereco);
		Scanner sc = new Scanner(System.in);
		while(!validarCNPJ(cnpj)){
			System.err.println("Erro - cnpj invalido!");
			System.err.println("Digite outro cnpj");
			cnpj = sc.nextLine();
		}
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}
	@Override
	public String toString(){
		String str = new String();
		str += "nome: " + getNome() + '\n' + "endereço " + getEndereco() + '\n' + "cnpj: "+
		cnpj + '\n' + "data fundação: " + dataFundacao + '\n';
		return str;
	}
	public String getCNPJ(){
		return this.cnpj;
	}
	
	public Date getDateFundacao(){
		return this.dataFundacao;
	}
	
	public void setDataFundacao(Date data){
		this.dataFundacao = data;
	}

	public boolean validarCNPJ(String cnpj){
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
}
