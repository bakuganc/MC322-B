package seguradora;
import javax.persistence.Entity;
import java.util.*;
@Entity
public class Veiculo{
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	public Veiculo(String placa, String marca, String modelo,int anoFabricacao){
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	public String getPlaca(){
		return placa;
	}

	public void setPlaca(String placa){
		this.placa = placa;
	}

	public String getMarca(){
		return marca;
	}

	public void setMarca(String marca){
		this.marca = marca;
	}

	public String getModelo(){
		return modelo;
	}

	public void setModelo(String modelo){
		this.modelo = modelo;
	}

	public int getAno(){
		return anoFabricacao;
	}

	public void setAno(int ano){
		this.anoFabricacao = ano;
	}
	@Override
	public String toString(){
		String str = new String();
		str += "placa:\t" + placa +'\n'+
		"marca:\t" + marca + '\n' + 
		"modelo:\t" + modelo + '\n'+
		"ano:\t" + anoFabricacao;
		return str;
	}
}

