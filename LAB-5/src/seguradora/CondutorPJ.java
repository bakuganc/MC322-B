package seguradora;
import seguradora.Sinistro;
import seguradora.Utilidades;
import java.util.*;
import javax.persistence.Entity;
@Entity
public class CondutorPJ extends Condutor{
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private Date dataNasc;
	private ArrayList<Sinistro> listaSinistros;
	
	public CondutorPJ(String cnpj,String nome,String telefone,String endereco,Date dataNasc){
		super(null,nome,telefone,endereco,dataNasc);
		this.cnpj = cnpj;
		listaSinistros = new ArrayList<Sinistro>();
	}
	public String getCNPJ(){
		return cnpj;
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
	public boolean adicionarSinistro(Date data, CondutorPJ condutor,Seguro seguro){
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
		str += "cnpj:\t" + cnpj + '\n'
		+"telefone:\t" + telefone + '\n'
		+ "endereco:\t" + endereco + '\n'
		+ "data nascimento:\t" + dataNasc;
		return str;
	}
}


