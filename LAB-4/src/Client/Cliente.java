package Client;
import java.util.ArrayList;
import java.util.Date;
import veiculo.Veiculo;
import validation.Validacao;
import Principal.Main;
import Erro.SeguradoraErro;
public class Cliente {
    private String nome;
    private String endereco;
    static private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;
    // implementação//
    public Cliente(String nome, String endereco) {
		while(!Validacao.validacaoStringSomenteLetras(nome)){
			SeguradoraErro.imprimirMensagemErro("Erro - Nome inválido");
			nome = Main.input("Digite outro nome com apenas letras!");
		}
		while(!Validacao.validacaoStringEndereco(endereco)){
			SeguradoraErro.imprimirMensagemErro("Erro - endereço inválido");
			endereco = Main.input("Digite o numero seguido do nome da" 
			+ " rua/avenida!");
		}
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();

    }
    // getters and setters//
    public String getNome() {
		return nome;
    }

    public void setNome(String nome) {
		this.nome = nome;
    }

	public double getValorSeguro(){
		return valorSeguro;
	}
	
	public void setValorSeguro(double valor){
		this.valorSeguro = valor;
	}

    public String getEndereco() {
		return endereco;
    }

    public void setEndereco(String endereco) {
		this.endereco = endereco;
    }

	static public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	static public String mostrarVeiculos(){
		String str = new String("");
		for(Veiculo v : listaVeiculos){
			str += v.toString();
		}
		return str;
	}
	double calculaScore(){
		return 1.0;
	}
	
	@Override 
	public String toString(){
		String str = new String();
		str += "nome: " + nome +'\n' +"endereço: " +  endereco + '\n';
		return str;
	}
}
