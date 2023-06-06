package Insurance;
import java.util.ArrayList;
import Client.Cliente;
import clientepf.ClientePF;
import Sinister.Sinistro;
import clientepj.ClientePJ;
import Principal.Main;
import validation.Validacao;
import Erro.SeguradoraErro;
import utilidades.Utilidades;
import java.rmi.server.UID;
import java.time.*;
import java.util.*;
public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	static private ArrayList <Sinistro> listaSinistros ;
	private static ArrayList <Cliente> listaClientes ;
	// Construtor //
	public Seguradora(String nome, String telefone, 
		String email, String endereco) {
		while(!Validacao.validacaoStringSomenteLetras(nome)){
			SeguradoraErro.imprimirMensagemErro("Erro - Nome inválido");
			nome = Main.input("Digite outro nome com apenas letras!");
		}
		while(!Validacao.validacaoStringEndereco(endereco)){
			SeguradoraErro.imprimirMensagemErro("Erro - endereço inválido");
			endereco = Main.input("Digite o numero seguido do nome da" + 
			" rua/avenida");
		}
		while(!Validacao.validacaoStringSomenteNumeros(telefone)){
			SeguradoraErro.imprimirMensagemErro("Erro - numero inválido");
			telefone = Main.input("Digite o numero do telefone");
		}
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

	public ArrayList<Sinistro> getListaSinistro(){
			return this.listaSinistros;
		}

	public ArrayList<Cliente> getListaClientes(){
			return this.listaClientes;
	}

	public boolean gerarSinitstro(String cliente){
		ArrayList<String> Arraystr = new ArrayList<String>();
		String str = new String();
		for(Cliente c: listaClientes){
			if(c instanceof ClientePF && ClientePF.getCPF().equals(cliente)){
					str = new UID().toString();
					Arraystr.add(str);
					str = Main.input("digite a data");
					Arraystr.add(str); 
					str = Main.input("digite endereco");
					Arraystr.add(str);
					Sinistro sinistro = new Sinistro(Arraystr.get(0),Arraystr.get(1),Arraystr.get(2),this,c.getListaVeiculos().get(0), c);
					listaSinistros.add( sinistro );
					return true;
			}
			else if(c instanceof ClientePJ && ClientePJ.getCNPJ().equals(cliente)){
				str = Main.input("digite o id");
				Arraystr.add(str); 
				str = Main.input("digite a data");
				Arraystr.add(str); 
				str = Main.input("digite endereco");
				Arraystr.add(str);
				Sinistro sinistro = new Sinistro(Arraystr.get(0),Arraystr.get(1),Arraystr.get(2),this,c.getListaVeiculos().get(0), c);
				listaSinistros.add( sinistro );
				return true;
			
			}
		}
		return false;
	}
	public boolean cadastrarCliente(Cliente cliente){
		if(cliente == null){
			return false;
		}
		if(contemCliente(cliente)){
			String resposta = Main.input("Deseja adicionar outro veículo?S/N");
			if((resposta.charAt(0) == 'S' || resposta.charAt(0) == 's') && 
			   cliente instanceof ClientePF){
				ClientePF.adicionarVeiculo();
			}
			else if((resposta.charAt(0) == 'S' || resposta.charAt(0) == 's')&& 
			   cliente instanceof ClientePJ){
				ClientePJ.adicionarVeiculo();
			}
			else{
				System.out.println("Ok");
				return true;
			}
		}
		else{
			listaClientes.add(cliente);
		}
		double valorFinal = 0.0;
		if(cliente instanceof ClientePF){ 
			valorFinal = calcularPrecoSeguroCliente(ClientePF.getCPF());
		}
		else if(cliente instanceof ClientePJ){
			valorFinal = calcularPrecoSeguroCliente(ClientePJ.getCNPJ());
		}
		else{
			throw new IllegalArgumentException("Erro - Tipo de Cliente" +
			"desconhecido");
		}
		System.out.println("Valor do seguro = R$" + valorFinal);
		return true;
	}

	public boolean contemCliente(Cliente clt){
		for(Cliente c : listaClientes){
			if(c instanceof ClientePF && 
			ClientePF.getCPF().equals(ClientePF.getCPF())){
				return true;
			}
			else if(c instanceof ClientePJ && 
			ClientePJ.getCNPJ().equals(ClientePJ.getCNPJ())){
				return true;
			}
		}
		return false;
	}
	public boolean removerCliente(String cliente){
		if(cliente == null){
			return false;
		}
		int posicao = 0;
		for(Cliente c : listaClientes){
			if(c.getNome().equals(cliente)){
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
			if(c instanceof ClientePF && ClientePF.getCPF().equals(cliente)){
				System.out.println(listaSinistros.get(i));
				return true;
			}
			if(c instanceof ClientePJ && ClientePJ.getCNPJ().equals(cliente)){
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
	
	static public double calcularPrecoSeguroCliente(String identificacao)
	{
		long idade  = 0L;
		double valorFinal = 0.00;
		Date agora = Date.from(Instant.now());
		if(identificacao == null || identificacao.length() == 0){
			return -1;
		}
		for(Cliente c : listaClientes){
			if( c instanceof ClientePF && 
				ClientePF.getCPF().equals(identificacao)){
				idade = Utilidades.calcularIdade(ClientePF.getDataNascimento(),
				agora);
				double score = ClientePF.calculaScore(idade);
				valorFinal += score * (1 + numeroDeSinistros(identificacao));
			}
			else if(c instanceof ClientePJ && 
				ClientePJ.getCNPJ().equals(identificacao)){
				
				double score = ClientePJ.calculaScore();
				valorFinal += score * numeroDeSinistros(identificacao);
				valorFinal += score * (1 + numeroDeSinistros(identificacao));
			}
			else{
				throw new IllegalArgumentException("Erro - Tipo de cliente des"
				+ "conhecido");
			}
		}
		return valorFinal;
	}
	static public double calcularReceita(){
		double soma = 0.0;
		for(Cliente c : listaClientes){
			if(c instanceof ClientePF){
				soma += calcularPrecoSeguroCliente(ClientePF.getCPF());
				
			}
			else if(c instanceof ClientePJ){
				soma += calcularPrecoSeguroCliente(ClientePJ.getCNPJ());
			}
			else{
				throw new IllegalArgumentException("Erro - Tipo de cliente des"
				+ "conhecido");
			}
		}
		return soma;
	}
	static public int numeroDeSinistros(String identificacao){
		int soma = 0;
		for(Sinistro s : listaSinistros){
			if(s.getCliente() instanceof ClientePF && ClientePF.getCPF().equals(
			identificacao)){
				soma++;
			}
			if(s.getCliente() instanceof ClientePJ && 
			ClientePJ.getCNPJ().equals(
			identificacao)){
				soma++;
			}
		}
		return soma;
	}
	@Override
	public String  toString(){
		String str = new String();
		str += nome + '\n' + telefone
	    + '\n' + email + '\n' + endereco;
		return str;
	}
}
