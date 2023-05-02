package Insurance;
import java.util.ArrayList;
import Client.Cliente;
import clientepf.ClientePF;
import Sinister.Sinistro;
import clientepj.ClientePJ;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList <Sinistro> listaSinistros ;
	private ArrayList <Cliente> listaClientes ;
	// Construtor //
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();
	}

	// Getters e setters //
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	
	//valores pra lista//
	public ArrayList<Sinistro> getListaSinistro(){
			return this.listaSinistros;
		}

	public ArrayList<Cliente> getListaClientes(){
			return this.listaClientes;
	}
	
	public boolean cadastrarCliente(Cliente cliente){
		if(cliente == null){
			return false;
		}
		listaClientes.add(cliente);
		return true;
	}

	public boolean removerCliente(String cliente){
		if(cliente == null){
			return false;
		}
		int posicao = 0;
		for(Cliente c : listaClientes){
			System.out.println(c);
			if(c.getNome() .equals(cliente)){
				listaClientes.remove(posicao);
				return true;
			}
			posicao++;
		}
		return false;
	}
	
	public void listarSinistros(){
		System.out.println("Sinistros");
		for(Sinistro s : listaSinistros){
			System.out.println(s);
		}
	}
	public boolean visualizarSinistros(String cliente){
		if(cliente == null || cliente.length() == 0){
			return false;
		}
		int i = 0;
		for(Cliente c: listaClientes){
			if(c.getNome() .equals(cliente) ){
				System.out.println(listaSinistros.get(i));
				return true;
			}
			i++;
		}
		return false;
	}
	
	public void listarClientes(String tipoCliente){
		System.out.println("Lista Clientes");
		System.out.println(tipoCliente);
		if(tipoCliente .equals("PF")){
			for(Cliente c : listaClientes){
				if(c instanceof ClientePF ){
					System.out.println(c);
				}
				
			}
		}
		else if(tipoCliente.equals("PJ")){
			for(Cliente c : listaClientes){
				if(c instanceof ClientePJ ){
					System.out.println(c);
				}
				
			}
			
		}
		
		else{
			System.err.println("Erro - tipo do cliente deve ser PF ou PJ !");
		}
	}
	@Override
	public String  toString(){
		String str = new String();
		str += nome + '\n' + telefone
	    + '\n' + email + '\n' + endereco;
		return str;
	}
}
