package Sinister;
import java.util.Random;
import Insurance.Seguradora;
import veiculo.Veiculo;
import Client.Cliente;
public class Sinistro {
	private final String id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	static private Cliente cliente;
	private Veiculo veiculo;
	// implementação//
	public Sinistro(String id, String data, String endereco,Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.id = generateRandomId();
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}


	// getters and setters//
	public String getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereço() {
		return endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}

	Seguradora getSeguradora(){
		return seguradora;
	}

	void setSeguradora(Seguradora s){
		this.seguradora = s;
	}

	static public Cliente getCliente(){
		return cliente;
	}

	public void setCliente(Cliente c){
		this.cliente = c;
	}
	
	void setVeiculo(Veiculo v){
		this.veiculo = v;
	}

	Veiculo getVeiculo(){
		return veiculo;
	}

	private static String generateRandomId() {
		// definir o comprimento do ID aqui//
		int length = 10;
		// caracteres possíveis para o ID//
		String chars = "0123456789";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}
	@Override
	public String toString(){
		String str = new String();
		str += "id: " + id + '\n' + "data: " + data + '\n' + "endereco: " 
			+ endereco + '\n' + "seguradora:" + seguradora + '\n' + 
			"veiculo: " + veiculo + '\n' + "cliente: " + cliente + '\n'; 
		return str;
	}
}
