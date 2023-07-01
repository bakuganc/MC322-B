package seguradora;
import seguradora.Sinistro;
import seguradora.Utilidades;
import java.util.*;
import javax.persistence.Entity;
@Entity
public class Condutor{
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private Date dataNasc;
	private ArrayList<Sinistro> listaSinistros;
	
	public Condutor(String cpf,String nome,String telefone,String endereco,Date dataNasc){
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
		listaSinistros = new ArrayList<Sinistro>();
	}
	public String getCPF(){
		return cpf;
	}
	
	public String getNome(){
		return nome;
	}

	public void setNome(String n){
		this.nome = n; 
	}

	public String getEndereco(){
		return endereco;
	}

	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public Date getDataNasc(){
		return dataNasc;
	}

	public void setDataNasc(Date d){
		this.dataNasc = d;
	}
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	public boolean adicionarSinistro(Date data, Condutor condutor,Seguro seguro){
		if(condutor == null){
			return false;
		}
		Sinistro sinistro = new Sinistro(data, condutor.getEndereco(),this,seguro);
		listaSinistros.add(sinistro);
		return true;
	}
	@Override 
	public String toString(){
		String str = new String();
		str += "cpf:\t" + cpf + '\n'
		+"telefone:\t" + telefone + '\n'
		+ "endereco:\t" + endereco + '\n'
		+ "data nascimento:\t" + dataNasc;
		return str;
	}
}
