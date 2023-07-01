package seguradora;
import javax.persistence.Entity;
import java.util.*;
import seguradora.Veiculo;
import seguradora.Utilidades;
@Entity
public class Frota{
	private String code;
	private ArrayList<Veiculo> listaVeiculos;

	public Frota(){
		this.code = Utilidades.gerarID();
		listaVeiculos = new ArrayList<Veiculo>();
	}
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code = code;
	}
	public boolean adicionarVeiculo(Veiculo v){
		if(v == null){
			return false;
		}
		listaVeiculos.add(v);
		return true;
	}
	public boolean adicionarVeiculo(int numeroVeiculos){
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
			listaVeiculos.add(v);
			i--;
		}
		return true;
	}
	public boolean removeVeiculo(Veiculo v){
		if(v == null){
			return false;
		}
		int index = 0;
		while(index < listaVeiculos.size()){
			if(listaVeiculos.get(index) == v){
				listaVeiculos.remove(index);
			}
			index++;
		}
		return true;
	}
	public boolean removeVeiculo(int numeroVeiculos){
		if(numeroVeiculos <= 0){
			return false;
		}
		int i = 0;
		while(i < listaVeiculos.size()){
			listaVeiculos.remove(i);
			i++;
		}
		return true;
	}
	@Override
	public String toString(){
		String str = new String();
		str += "code:\t" + code + '\n';
		return str;
	}
}
