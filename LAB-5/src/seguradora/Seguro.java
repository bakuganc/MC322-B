package seguradora;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import seguradora.Utilidades;
import seguradora.Erro;
@Entity
public abstract class Seguro{
	final int id;
	Date dataInicio;
	Date dataFim;
	Seguradora seguradora;
	static ArrayList<Sinistro> listaSinistros;
	static ArrayList<Condutor> listaCondutores;
	float valorMensal;

	public Seguro(Date dataI,Date dataF,Seguradora seguradora,float valor){
		String idStr = Utilidades.gerarID();
		this.id = Utilidades.strToInt(idStr);
		this.dataInicio = dataI;
		this.dataFim = dataF;
		this.seguradora = seguradora;
		listaSinistros = new ArrayList<Sinistro>();
		listaCondutores = new ArrayList<Condutor>();
		valorMensal = valor;
	}
	float getValorMensal(){
		return valorMensal;
	}
	//getter e setters
	public int getID(){
		return id;
	}
	public Date getDataInicio(){
		return dataInicio;
	}
	public void setID(Date data){
		this.dataInicio = data;
	}
	public Date getdataFim(){
		return dataFim;
	}
	public void setdataFim(Date data){
		this.dataFim = data;
	}
	public Seguradora getSeguradora(){
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora){
		this.seguradora = seguradora;
	}
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	static public void addListaSinistros(Sinistro s){
		listaSinistros.add(s);
	}
	public ArrayList<Condutor> getListaCondutores(){
		return listaCondutores;
	}
	public void addListaCondutores(Condutor c){
		this.listaCondutores.add(c);
	}
	public float getvalorMensal(){
		return valorMensal;
	}
	public void setValorMensal(float valorMensal){
		this.valorMensal = valorMensal;
	}
	public float calcularValor(int idade){
		return 0.0f;
	}
	

	static public boolean desautorizarCondutor(Condutor cond){
		final String mensgaemErro = new String("Condutor deve ser diferente de null");
		if(cond == null){
			Erro.imprimirErro(mensgaemErro);
			return false;
		}
		if(cond.getListaSinistros().size() >= 5){
			return true;
		}
		return false;
	}
	static public boolean autorizarCondutor(Condutor cond){
		final String mensgaemErro = new String("Condutor deve ser diferente de null");
		if(cond == null){
			Erro.imprimirErro(mensgaemErro);
		}
		return !(desautorizarCondutor(cond));
	}

	public boolean gerarSinistro(Condutor cond,Date data){
		if(cond == null){
			return false;
		}
		String endereco = Utilidades.input("Digite o endereco");
		Sinistro sinistro = new Sinistro(data,endereco,cond,this);
		listaSinistros.add(sinistro);
		return true;
	}

	static public boolean pesquisarCondutor(String cpf){
		if(!Validacao.validarCPF(cpf)){
			final String mensgaemErro = new String("CPF invalido ou igual a null");
			throw new IllegalArgumentException(mensgaemErro);
		}
		for(Condutor c :  listaCondutores){
			if(c.getCPF().equals(cpf)){
				return true;
			}
		}
		return false;
	}
	static public Condutor getCondutorLista(String cpf){
		if(pesquisarCondutor(cpf)){
			for(Condutor c: listaCondutores){
				if(c.getCPF().equals(cpf)){
					return c;
				}
			}
		}
		return null;
	}
	@Override
	public String toString(){
		String str = new String();
		str += "Seguradora:\t" + seguradora +'\n' +
		"Data inicial:\t" + dataInicio + '\n'+
		"Data Final:\t" + dataFim + '\n'+
		"Valor Mensal:\t" + valorMensal + '\n';
		return str;
	}
}
