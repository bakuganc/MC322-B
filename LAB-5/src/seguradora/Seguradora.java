package seguradora;
import javax.persistence.Entity;
import java.util.*;
import seguradora.Utilidades;
import seguradora.Validacao;
import seguradora.SeguroPF;
import seguradora.SeguroPJ;
import java.text.ParseException;
@Entity
public class Seguradora{
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private static ArrayList<Cliente> listaClientes;
	private static ArrayList<Seguro>  listaSeguros;
	private float receita;
	
	public Seguradora(final String cnpj,String nome,String telefone,String endereco){
		this.cnpj     = cnpj;
		this.nome     = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		listaClientes = new ArrayList<Cliente>();
		listaSeguros  = new ArrayList<Seguro>();
		receita = 0.0f;
	}
	/*
	public Seguradora(String nome,String telefone,String endereco,String cnpj){
		this(nome,telefone,endereco,cnpj);
	}
	*/
	// getter e setters 
	public String getCNPJ(){
		return cnpj;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(String telefone){
		this.telefone= telefone;
	}
	
	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	public void adicionarSeguro(Seguro s){
		if(s == null){
			String mensagemErro = new String("Erro - Seguro deve ser difente de null");
			throw new IllegalArgumentException(mensagemErro);
		}
		listaSeguros.add(s);
		this.receita += s.getValorMensal();
	}
	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}
	static public ArrayList<Seguro> getListaSeguros(){
		return listaSeguros;
	}
	public void adicionarCliente(Cliente clt){
		if(clt == null){
			String mensagemErro = new String("Erro - Cliente deve ser difente de null");
			throw new IllegalArgumentException(mensagemErro);
		}
		listaClientes.add(clt);
	}
	//public void adicionarCliente(ClientePF cltPF){
	//	if(cltPF == null){
	//		String mensagemErro = new String("Erro - Cliente deve ser difente de null");
	//		throw new IllegalArgumentException(mensagemErro);
	//	}
	//	listaClientes.add(cltPF);
	//}
	//public void adicionarCliente(ClientePF cltPJ){
	//	if(cltPJ == null){
	//		String mensagemErro = new String("Erro - Cliente deve ser difente de null");
	//		throw new IllegalArgumentException(mensagemErro);
	//	}
	//	listaClientes.add(cltPJ);
	//}
	//public void adicionarSeguro(SeguroPF segPF){
	//	if(segPF == null){
	//		String mensagemErro = new String("Erro - Seguro deve ser difente de null");
	//		throw new IllegalArgumentException(mensagemErro);
	//	}
	//	listaSeguros.add(segPF);
	//}
	//public void adicionarSeguro(SeguroPF segPJ){
	//	if(segPJ == null){
	//		String mensagemErro = new String("Erro - Seguro deve ser difente de null");
	//		throw new IllegalArgumentException(mensagemErro);
	//	}
	//	listaSeguros.add(segPJ);
	//}
	public boolean removerCliente(String identificacao){
		boolean foiRemovido = false;
		if(identificacao == null){
			return foiRemovido;
		}
		int posicao = 0;
		for(Cliente c: listaClientes){
			if(c instanceof ClientePF && identificacao.equals(ClientePF.getCPF())){
				listaClientes.remove(posicao);
				foiRemovido = true;
			}
			posicao++;
		}
		return foiRemovido;
	}
	public void listarClientes(String tipoCliente){
		final String mensgaemErro = new String("O tipo de cliente deve ser PF para pessoas fisicas ou PJ para pessoas juridicas");
		if(tipoCliente == null){
			throw new IllegalArgumentException(mensgaemErro);
		}
		for(Cliente c : listaClientes){
			if(tipoCliente == "PF" && c instanceof ClientePF){
				Utilidades.imprimirString("Cliente ");
				Utilidades.imprimirString(c.toString());
			}
			else if(tipoCliente == "PJ" && c instanceof ClientePJ){
				Utilidades.imprimirString("Cliente ");
				Utilidades.imprimirString(c.toString());
			}
			else{
				throw new IllegalArgumentException(mensgaemErro);
			}
		}
	}
	static public int getSegurosPorCliente(Cliente clt){
		if(clt == null){
			throw new IllegalArgumentException("Cliente deve ser diferente de null");
		}
		for(Cliente c : listaClientes){
			if(c == clt){
				return getListaSeguros().size();
			}
		}
		return -1;
	}
	
	static public int getSinistrosPorCliente(ClientePF clt,Condutor cond){
		if(clt == null || cond == null){
			final String mensgaemErro = new String("Cliente/Condutor devem ser diferentes de null");
			throw new IllegalArgumentException(mensgaemErro);
		}
		if(cond.getCPF().equals(ClientePF.getCPF())){
			return cond.getListaSinistros().size();
		}
		return -1;
	}
	
	public boolean gerarSeguro(ClientePF cltPF,SeguroPF seg ){
		boolean isCPF = false;
		if(Validacao.validarCPF(cltPF.getCPF()) && seg.getClientePF() == cltPF){
			isCPF = true;
		}
		else{
			final String mensgaemErro = new String("CPF invalido ou cliente invalido");
			throw new IllegalArgumentException(mensgaemErro);
		}
		assert(isCPF != true): "Erro de Assercao: " +
			"isCPF ou isCNPJ eh diferente de true";
		if(isCPF){
			Condutor cond = Seguro.getCondutorLista(cltPF.getCPF());
			float valorMensal = SeguroPF.calcularValor(cltPF,cond);
			seg.setValorMensal(valorMensal);
			return true;
		}
		return false;
	}
	public boolean gerarSeguro(SeguroPJ  seg, ClientePJ  cltPJ , CondutorPJ cond){
		boolean isCNPJ = false;
		if(seg.getClientePJ().getCNPJ().equals(cltPJ.getCNPJ()) && cltPJ.getCNPJ().equals(cond.getCNPJ() )){
			isCNPJ = true;
		}
		else{
			final String mensgaemErro = new String("CNPJ invalido");
			throw new IllegalArgumentException(mensgaemErro);
		}
		assert(isCNPJ != true): "Erro de Assercao: " +
			"isCNPJ eh diferente de true";
		if(isCNPJ){
			float valorMensal = seg.calcularValor(cltPJ,cond);
			seg.setValorMensal(valorMensal);
			return true;
		}
		return false;
	}

	static private int getIndice(String identificacao){
		int indice = 0;
		for(Cliente c : listaClientes){
			if(c instanceof ClientePF && ClientePF.getCPF().equals(identificacao)){
				break;
			}
			indice++;
		}
		return indice;
	}
	static private Cliente getClientePFLista(String identificacao){
		if(identificacao == null){
			String mensgaemErro = new String("Erro - identificacao deve ser diferente de null");
			throw new IllegalArgumentException(mensgaemErro);
		}
		return  listaClientes.get(getIndice(identificacao));
	}
	
	@Override
	public String toString(){
		String str = new String();
		str += "Nome:\t" + nome +'\n' +
		"Telefone:\t" + telefone + '\n'+
		"Endereco:\t" + endereco + '\n'+
		"CNPJ:\t" + cnpj + '\n';
		return str;
	}
}
