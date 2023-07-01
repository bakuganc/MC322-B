package seguradora;
import seguradora.Cliente;
import seguradora.Veiculo;
import seguradora.Erro;
import javax.persistence.Entity;
import java.util.*;
@Entity
public class ClientePJ extends Cliente{
	private static String cnpj;
	private Date dataFundacao;
	static private int quantidadeDeFunc;
	static private ArrayList<Veiculo> listaFrota;

	public ClientePJ(String nome, String telefone, String endereco,String email,String cnpj,Date dataFundacao,int qFunc){
		super(nome,telefone,endereco,email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.quantidadeDeFunc = qFunc;
		this.listaFrota = new ArrayList<Veiculo>();
	}
	// getter e setters
	public static String getCNPJ(){
		return cnpj;
	}
	
	public static int getQuantFunc(){
		return quantidadeDeFunc;
	}
	public Date getDataFundacao(){
		return dataFundacao; 
	}

	public void setDataFundacao(Date df){
		this.dataFundacao = df;
	}
	public static int getNumVeiculos(){
		return listaFrota.size();
	}
	public boolean atualizarFrota(int n,boolean removerTudo,boolean cadastrar,boolean remover,Veiculo v){
		if(removerTudo){
			listaFrota.clear();
			return true;
		}
		if(cadastrar){
			cadastrarFrota(n);
			return true;
		}
		if(remover){
			int indice = getIndice(v);
			if(indice >= 0){
				removerDaFrota(indice);
				return true;
			}
		}
		return false;
	}
	private int getIndice(Veiculo v){
		for(int i = 0;i<listaFrota.size();i++){
			if(listaFrota.get(i) == v){
				return i;
			}
		}
		return -1;
	}
	public boolean removerDaFrota(int indice){
		if(indice < 0 || indice >= listaFrota.size()){
			return false;
		}
		listaFrota.remove(indice);
		return true;
	}
	public boolean cadastrarFrota(int numeroVeiculos){
		if(numeroVeiculos <= 0){
			return false;
		}
		int i = numeroVeiculos;
		while(i != 0){
			String placa = Utilidades.input("Digite a placa");
			String marca = Utilidades.input("Digite a marca");
			String modelo = Utilidades.input("Digite o modelo");
			int anoFabricacao = Utilidades.strToInt(Utilidades.input("Digite o ano de fabricacao"));
			Veiculo v = new Veiculo(placa,marca,modelo,anoFabricacao);
			cadastrarFrota(v);
			i--;
		}
		return true;
	}
	
	private boolean cadastrarFrota(Veiculo v){
		if(v != null){
			listaFrota.add(v);
			return true;
		}
		return false;
	}
	@Override
	public String toString(){
		String str = new String();
		str += "CNPJ:\t" + cnpj + '\n'+
		"data fundacao:\t" + dataFundacao + '\n';
		return str;
	}
}

