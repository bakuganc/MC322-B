package seguradora;
import seguradora.Cliente;
import seguradora.Veiculo;
import javax.persistence.Entity;
import seguradora.Veiculo;
import seguradora.Validacao;
import java.util.*;
@Entity
public class ClientePF extends Cliente{
	static private String cpf;
	private String genero;
	private String educacao;
	private Date dataNasc;
	private static ArrayList<Veiculo> listaVeiculos;
	
	public ClientePF(String nome, String telefone, String endereco, String email,String cpf, String genero,Date dataNasc,String educacao){
		super(nome,telefone,endereco,email);
		this.educacao = educacao;
		this.genero = genero;
		this.dataNasc = dataNasc;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}
	public static String getCPF(){
		return cpf;
	}
	public String getGenero(){
		return genero;
	}
	public Date getDataNasc(){
		return dataNasc;
	}
	static public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	public void setGenero(String genero){
		this.genero = genero;
	}
	public void setDate(Date data){
		this.dataNasc = data;
	}
	
	public static boolean cadastraVeiculo(String placa, String marca, String modelo,int anoFabricacao){
		if((placa == null || marca == null || modelo == null || anoFabricacao == 0) || (placa.length() == 0 || marca.length() == 0 || modelo.length() == 0 || anoFabricacao < 0)){
			return false;
		}
		Veiculo veiculo = new Veiculo(placa,marca,modelo,anoFabricacao);
		getListaVeiculos().add(veiculo);
		return true;
	}

	public boolean removerVeiculo(String placa){
		if(placa == null || placa.length() == 0){
			return false;
		}
		int indice = 0;
		for(Veiculo v : listaVeiculos){
			if(v.getPlaca().equals(placa)){
				listaVeiculos.remove(indice);
				return true;
			}
			indice++;
		}
		return true;
	}
	public boolean removerVeiculo(Veiculo veiculo){
		if(veiculo == null || veiculo.getPlaca().length() == 0){
			return false;
		}
		int indice = 0;
		for(Veiculo v: listaVeiculos){
			if(v == veiculo){
				listaVeiculos.remove(indice);
				return true;
			}
			indice++;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String str = new String();
		str += "cpf:\t" + cpf + '\n'+
		"genero:\t" + genero + '\n'+
		"data nascimento:\t" + dataNasc;
		return str;
	}
}
