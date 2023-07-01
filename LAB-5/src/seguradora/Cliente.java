package seguradora;
import javax.persistence.Entity;
@Entity
public abstract class Cliente{
	String nome;
	String telefone;
	String endereco;
	String email;

	public Cliente(String nome,String telefone, String endereco, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}

	// getter e setters
	public String getNome(){
		return nome;
	}
	public void setNome(){
		this.nome = nome;
	}
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(){
		this.telefone = telefone;
	}
	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(){
		this.endereco = endereco;
	}
	public String getEmail(){
		return telefone;
	}
	public void setEmail(){
		this.telefone = telefone;
	}
	@Override
	public String toString(){
		String str = new String();
		str += "Nome:\t" + nome +'\n' +
		"Telefone:\t" + telefone + '\n'+
		"Endereco:\t" + endereco + '\n'+
		"Email:\t" + email + '\n';
		return str;
	}
	
}
