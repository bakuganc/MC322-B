package Client;
import java.util.ArrayList;
import java.util.Date;
import veiculo.Veiculo;
public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    // implementação//
    public Cliente(String nome, String endereco) {
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

    public String getEndereco() {
		return endereco;
    }

    public void setEndereço(String endereco) {
		this.endereco = endereco;
    }
	
	@Override 
	public String toString(){
		String str = new String();
		str += "nome: " + nome +'\n' +"endereço: " +  endereco + '\n';
		return str;
	}
}
