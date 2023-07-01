package seguradora;
import seguradora.Seguro;
import seguradora.ClientePF;
import seguradora.Condutor;
import seguradora.Veiculo;
import seguradora.ClientePF;
import seguradora.Utilidades;
import seguradora.Fator;
import seguradora.Seguradora;
import seguradora.Seguro;
import seguradora.Erro;
import seguradora.Veiculo;
import javax.persistence.Entity;
import java.util.Date;
import java.time.*;
@Entity
public class SeguroPF extends Seguro{
	private Veiculo veiculo;
	private ClientePF clientePF;
	public SeguroPF(Date dataI,Date dataF,Seguradora seguradora,float valor,Veiculo veiculo,ClientePF clientepf){
		super(dataI,dataF,seguradora,valor);
		this.veiculo = veiculo;
		this.clientePF = clientepf;
	}
	// getter e stters
	public Veiculo getVeiculo(){
		return veiculo;
	}
	public void setVeiculo(Veiculo v){
		this.veiculo = v;
	}
	public ClientePF getClientePF(){
		return clientePF;
	}
	public void setClientePF(ClientePF clientepf){
		this.clientePF = clientepf;
	}
	static public boolean autorizarCondutor(Condutor condutor){
		return Seguro.autorizarCondutor(condutor);
	}
	static public boolean desautorizarCondutor(Condutor condutor){
		return Seguro.desautorizarCondutor(condutor);
	}

	public boolean gerarSinistro(Condutor cond,Date data){
		final String mensgaemErro = new String("Condutor e Data deve ser diferentes de null");
		if(cond == null || data == null){
			Erro.imprimirErro(mensgaemErro);
			return false;
		}
		String endereco = Utilidades.input("Digite o endereco");
		Sinistro sinistro = new Sinistro(data,endereco,cond,this);
		Seguro.addListaSinistros(sinistro);
		return true;
	}
	static private int calcularIdade(ClientePF cltPF){
		LocalDate agora = LocalDate.now();
		int idade =  Utilidades.calcularIdade(Utilidades.converterData(cltPF.getDataNasc()),agora);
		return idade;
	}
	static public float calcularValor(ClientePF cltPF,Condutor cond){
		if(cond  == null || cltPF  == null){
			final String mensgaemErro = new String("Erro - Condutor ou cliente PF devem ser diferente de null!");
			throw new IllegalArgumentException(mensgaemErro);
		}
		int idade = calcularIdade(cltPF);
		if(idade < 0){
			final String mensgaemErro = new String("Erro - uma ou mais idades são invalidas");
			throw new RuntimeException(mensgaemErro);
		}
		Fator.FatoresPF fatorPF = Fator.FatoresPF.VALOR_BASE; 
		return (fatorPF.getFator() * fatorPF.setFator(idade).getFator() * (1 + 1/(Utilidades.quantidadeDeVeiculos(cltPF)+2)) * (2 + Seguradora.getSinistrosPorCliente(cltPF,cond)/10) * (5 + Utilidades.quantidadeDeSinistrosCondutor(cond)/10));
	}
	
}
