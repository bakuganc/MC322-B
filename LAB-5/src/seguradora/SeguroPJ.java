package seguradora;
import seguradora.Frota;
import seguradora.ClientePJ;
import seguradora.Seguro;
import seguradora.Fator;
import seguradora.CondutorPJ;
import javax.persistence.Entity;
import java.util.*;
import java.time.*;
@Entity
public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ cltPJ;
	public SeguroPJ(Date dataI,Date dataF, Seguradora seguradora,Frota frota,ClientePJ cltPJ,float valor){
		super(dataI,dataF,seguradora,valor);
		this.frota = frota;
		this.cltPJ = cltPJ;
	}
	ClientePJ getClientePJ(){
		return cltPJ;
	}
	static public float calcularValor(ClientePJ cltPJ,CondutorPJ cond){
		Fator.FatoresPJ fator  = Fator.FatoresPJ.VALOR_BASE;
		float valorMensal = (fator.getFator() *(10 + cltPJ.getQuantFunc()/10) * (1 + 1/( cltPJ.getNumVeiculos() + 2)) * (1 + 1/calcularIdade(cltPJ) + 2)) * (2 + getSinistrosPorCliente(cltPJ,cond)/10) * (5 + cond.getListaSinistros().size());;
		return valorMensal;
	}
	static private int calcularIdade(ClientePJ cltPJ){
		LocalDate agora = LocalDate.now();
		int idade =  Utilidades.calcularIdade(Utilidades.converterData(cltPJ.getDataFundacao()),agora);
		return idade;
	}
	static private int getSinistrosPorCliente(ClientePJ clt,CondutorPJ  cond){
		if(clt == null || cond == null){
			final String mensgaemErro = new String("Cliente/Condutor devem ser diferentes de null");
			throw new IllegalArgumentException(mensgaemErro);
		}
		if(cond.getCNPJ().equals(clt.getCNPJ())){
			return cond.getListaSinistros().size();
		}
		return -1;
	}

	public Frota getFrota(){
		return frota;
	}
	public ClientePJ getCliente(){
		return cltPJ;
	}
	public void setFrota(Frota f){
		this.frota = f;
	}
	public void setCliente(ClientePJ c){
		this.cltPJ = c;
	}
	static public boolean autorizarCondutor(Condutor cond){
		return Seguro.autorizarCondutor(cond);
	}
	static public boolean desautorizarCondutor(Condutor cond){
		return Seguro.desautorizarCondutor(cond);
	}
}
