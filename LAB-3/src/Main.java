import java.util.Scanner;
import Client.Cliente;
import Insurance.Seguradora;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import clientepf.ClientePF;
import clientepj.ClientePJ;

public class Main {
	public static void main(String[] args) {

	try{
		
		String nome = input("Digite o nome da seguradora:");
		String telefone = input("Digite o numero de telefone:");
		String email = input("Digite o endereco de email:");
		String endereco = input("Digite o endereco"); 
		System.out.println();
		Seguradora seguradora = new Seguradora(nome,telefone,email,endereco);
		boolean sair = false;
		int opcao = 0;
		char digito = 'a';
		String opcMenu;
		String menuStr = new String();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		String dataStr = "0/0/0000";
		Date dataTst= formatter.parse(dataStr);
		Cliente demoClt = new Cliente("N/D","N/D");
		ClientePF demoCltPF = new ClientePF("N/D","N/D","03024355065","N/D",dataTst,dataTst,"N/D","N/D");
		ClientePJ demoCltPJ = new ClientePJ("N/D","N/D","18471967000117",dataTst);
		menuStr += "MENU:\n"  + "1: Adicionar Cliente PJ\n" + "2: Adicionar Cliente PF\n" + "3: Remover Cliente (PF/PJ)\n"+ "4: toString()\n" + "5: Listar clientes:\n" + "6: visualizar sinistro\n" + "7: Listar Sinistros\n" + "8: Sair"; 
		while(!sair){
			System.out.println("Bem-vindo(a) a aplicação da Seguradora " + seguradora.getNome());
			System.out.println(menuStr);
			opcMenu = input("");	
			digito = opcMenu.charAt(0);
			opcao = digito - '0';
			switch(opcao){
				case 1:
					String nomeCltPJ = input("Digite o nome do cliente:");
					String endCltPJ = input("Digite o endereco do cliente:");
					String cnpj = input("Digite o cnpj");
					String dataFundStr = input("digite a data de fundação");
					Date dataFund = formatter.parse(dataFundStr);
					Cliente cltPj = new ClientePJ(nome,endCltPJ,cnpj,dataFund);
					seguradora.cadastrarCliente(cltPj);
					break;
				case 2:
					String nomeCltPF = input("Digite o nome do cliente:");
					String endCltPF = input("Digite o endereco do cliente:");
					String cpf = input("Digite o cpf");
					String genero = input("Digite o genero"); 
					String dataNasStr = input("Digite a data de nascimento");
					Date dataNasc = formatter.parse(dataNasStr);
					String dataLicStr = input("Digite a data da licenca");
					Date dataLic = formatter.parse(dataLicStr);
					String educ = input("Digite o grau de escolaridade");
					String clasEco = input("Digite a classe economica");
					Cliente cltPf = new ClientePF(nomeCltPF,endCltPF,cpf,genero,dataNasc,dataLic,educ,clasEco);
					seguradora.cadastrarCliente(cltPf);
					break;
				case 3:
					String nomeClt = input("Digite o nome do cliente");
					if(seguradora.removerCliente(nomeClt)){
						System.out.println("Cliente de CPF/CPNJ " + nomeClt+ " removido com sucesso");
					}
					else{
						System.err.println("Não foi possivel remover o cliente: " + nomeClt+ "\nRazao: Cliente Inexistente");
					}
					break;
				case 4:
					System.out.println("toString()");
					System.out.println(seguradora);
					System.out.println("demos de Clientes");
					System.out.println(demoCltPJ);
					System.out.println(demoCltPF);
					System.out.println(demoClt);
					break;
				case 5:
					String tipoClt = input("Digite o tipo do cliente");
					seguradora.listarClientes(tipoClt);
					break;

				case 6:
					System.out.println("Nada pra ver por aqui, circulando meliante");
					break;
					
				case 7:
					String nomeSin = input("Digite o nome");
					if(seguradora.visualizarSinistros(nomeSin)){
						System.out.println("Sinistro de " + nomeSin);	
						seguradora.visualizarSinistros(nomeSin);
					}
					else{
						System.err.println("Não foi possivel visualizar o cliente de CPF/CNPJ " + nomeSin + " Razão: " + "Nome inexistente");
					}
					break;
				case 8:
					sair = true;
					break;
				default:
					System.err.println("Erro: Opcao invalida");
					break;
			}
		}
	}
	catch(ParseException e){
		e.printStackTrace();
	}
}
	public static  String input(String mensagem){
		Scanner sc = new Scanner(System.in);
		System.out.println(mensagem);
		String str = new String();
		str = sc.nextLine();
		return str;

	}
}
