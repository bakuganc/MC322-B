package Principal;
import java.util.Scanner;
import Client.Cliente;
import Insurance.Seguradora;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import clientepf.ClientePF;
import clientepj.ClientePJ;
import MenOpr.MenuOperacoes;
import validation.Validacao;
import utilidades.Utilidades;
import java.util.ArrayList;
import Erro.SeguradoraErro;
import utilidades.Utilidades;
public class Main {
	public static void main(String[] args) {
	try{
		String nome = input("Digite o nome da seguradora:");
		String telefone = input("Digite o numero de telefone:");
		String email = input("Digite o endereco de email:");
		String endereco = input("Digite o endereco"); 
		System.out.println();
		MenuOperacoes menuOperacao = MenuOperacoes.INICIAR;
		Seguradora seguradora = new Seguradora(nome,telefone,email,
		endereco);
		boolean sair = false;
		int opcao = 0;
		String opcMenu;
		String menuStr = new String();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		String dataStr = "0/0/0000";
		Date dataTst= formatter.parse(dataStr);
		Cliente demoClt = new Cliente("ND","00 ND ND ND");
		ClientePF demoCltPF = new ClientePF("ND","00 ND","03024355065",
		"M",dataTst,dataTst,"ND","ND","ND","ND","ND");
		ClientePJ demoCltPJ = new ClientePJ("ND","00 ND",
		"18471967000117",dataTst,100,"ND","ND","ND");
		menuStr += "MENU:\n"  + "1: Adicionar Cliente PJ\n" 
		+ "2: Adicionar Cliente PF\n" + "3: Remover Cliente (PF/PJ)\n" 
		 + "4: Listar clientes:\n" 
		+ "5: Gerar sinistro\n" + "6: Visualizar sinistro\n" + "7: Sair"; 
		System.out.println("Bem-vindo (a) a aplicação da Seguradora "
		+ seguradora.getNome());
		while(!sair){
			opcMenu = input(menuStr);
			opcao = Utilidades.strToInt(opcMenu);
			boolean excecaoFoiJogada = false;
			do{
				if(excecaoFoiJogada){
					SeguradoraErro.imprimirMensagemErro("Erro - digite um "+
					"número entre 1 e 7 ");
					opcMenu = input(menuStr);
					opcao = Utilidades.strToInt(opcMenu);
				}
				try{
					menuOperacao = menuOperacao.lerDoMenu(opcao);
					excecaoFoiJogada = false;
				}
				catch(IllegalArgumentException e){
					excecaoFoiJogada = true;
				}
			}while(excecaoFoiJogada);
			switch(menuOperacao){
				case CADASTRAR_PJ:
					String nomeCltPJ = input("Digite o nome do cliente:");
					String endCltPJ = input("Digite o endereco do cliente:");
					String cnpj = input("Digite o cnpj");
					String dataFundStr = input("digite a data de fundação");
					Date dataFund = formatter.parse(dataFundStr);
					int quantidadeDeFuncionarios = 
					Utilidades.strToInt(input("Digite a "+
					"quantidade de funcionários"));
					Cliente cltPj = new ClientePJ(nome,endCltPJ,
					cnpj,dataFund,quantidadeDeFuncionarios);
					seguradora.cadastrarCliente(cltPj);
					break;
				case CADASTRAR_PF: 
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
					String placa = input("Digite a placa");
					String marca = input("Digite a marca");
					String modelo = input("Digite o modelo");
					Cliente cltPf = new ClientePF(nomeCltPF,endCltPF,
					cpf,genero,dataNasc,dataLic,
					educ,clasEco,placa,marca,modelo);
					seguradora.cadastrarCliente(cltPf);
					break;
				case REMOVER:
					String entrada = input("Digite o CPF/CNPF do cliente");
					if(seguradora.removerCliente(entrada)){
						System.out.println("Cliente de CPF/CPNJ " + entrada 
								+ " removido com sucesso");
					}else{
						System.err.println("Não foi possivel remover o cliente:" 
								+ entrada + "\nRazao: Cliente Inexistente");
					}
					break;
				case LISTAR_CLIENTES:
					String tipoClt = input("Digite o tipo do cliente");
					seguradora.listarClientes(tipoClt);
					break;
				
				case GERAR_SINISTRO: 
					System.out.println("Gerar sinistro");
					System.out.println("Digite 1 para PF e 2 para PJ");
					String opc = input("");
					if(opc.equals("1")){
						cpf = input("Digite o CPF");
						if(seguradora.gerarSinitstro(cpf)){
							System.out.println("Sinistro de " + cpf + 
							" gerado com sucesso");
						}else{
							System.err.println("Não foi possível gerar " +
							"sinistro. Razão: " + "cliente inexistente");
						}
						
					}
					else if(opc.equals("2")){
						cnpj = input("Digite o cnpj");
						seguradora.gerarSinitstro(cnpj);
						if(seguradora.gerarSinitstro(cnpj)){
							System.out.println("Sinistro de " + cnpj + 
							"gerado com sucesso");
						}else{
							System.err.println("Não foi possível gerar " +
							"sinistro. Razão: " + "cliente inexistente");
						}
					}
					break;
				case VISUALIZAR_SINISTRO:
					String nomeSin = input("Digite o CPF/CNPJ");
					if(seguradora.visualizarSinistros(nomeSin)){
						System.out.println("Sinistro de " + nomeSin);	
						seguradora.visualizarSinistros(nomeSin);
					}
					else{
						System.err.println(
						"Não foi possivel visualizar o  cliente de CPF/CNPJ " 
						+ nomeSin + "Razão: " + "CPF/CNPJ inexistente");
					}
					break;
				case SAIR:
					sair = true;
					break;
				default:
					System.err.println("Erro: Opcao invalida");
					break;

			}
			System.out.println("Receita = R$ " + Seguradora.calcularReceita());
		}
		System.out.println("toString()");
		System.out.println(seguradora);
		System.out.println("demos de Clientes");
		System.out.println(demoCltPJ);
		System.out.println(demoCltPF);
		System.out.println(demoClt);
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
