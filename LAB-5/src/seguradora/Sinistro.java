package seguradora;
import javax.persistence.Entity;
import java.util.Date;
import seguradora.Seguro;
@Entity
public class Sinistro{
	private final int id;
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	public Sinistro(Date data,String endereco,Condutor condutor,Seguro seguro){
		String idStr = Utilidades.gerarID();
		this.id = Utilidades.strToInt(idStr);
		this.data= data;
		this.condutor = condutor;
		this.seguro = seguro;
	}
	
	public int getID(){
		return id;
	}

	public Date getData(){
		return data;
	}

	public void setData(Date data){
		this.data = data;
	}

	public String getEndereco(){
		return endereco;
	}

	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public Seguro getSeguro(){
		return seguro;
	}

	public void setSeguro(Seguro seguro){
		this.seguro = seguro;
	}

	@Override
	public String toString(){
		String str = new String();
		str += "Condutor:\t" + condutor + '\n'+
		"Seguro:\t" + seguro + '\n'+
		"ID:\t" + id +'\n' +
		"Data:\t" + data + '\n';
		return str;
	}
}
