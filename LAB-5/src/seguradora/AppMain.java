package seguradora;
import java.text.ParseException;
import java.util.ArrayList;
import seguradora.Seguro;
import seguradora.Sinistro;
import seguradora.Seguradora;
import seguradora.Cliente;
import seguradora.Condutor;
import seguradora.ClientePF;
import seguradora.ClientePJ;
import seguradora.Menu;
import seguradora.Utilidades;
import seguradora.MatrizStr;
import seguradora.Validacao;
import seguradora.ValidacaoWrapper;
import seguradora.Erro;
import seguradora.Menu.MenuPrincipalSeguradora;
import java.util.*;
import java.lang.*;
import java.text.*;
public class AppMain{
	public static void main(String [] args){
		try{
			String str = new String();
			final int nColunasSeguradora = 4;
			final int linhas = 1;
			final int nColunasClientePF = 8;
			final int nColunasClientePJ = 7;
			String cnpj = Utilidades.input("Digite o cnpj da seguradora:\n");
			if(!Validacao.validarCNPJ(cnpj)){
				boolean isCNPJ = false;
				cnpj = ValidacaoWrapper.wrapperCNPJ(isCNPJ);
			}
			String nome = Utilidades.input("Digite o nome da seguradora:\n");
			if(!Validacao.validacaoStringSomenteLetras(nome)){
				boolean isNome = false;
				nome = ValidacaoWrapper.wrapperNome(isNome);
			}
			String telefone = Utilidades.input("Digite o numero de telefone:\n");
			if(!Validacao.validacaoStringTelefone(telefone)){
				boolean isTelefone = false;
				telefone = ValidacaoWrapper.wrapperTelefone(isTelefone);
			}
			String email = Utilidades.input("Digite o endereco de email:\n");
			String endereco = Utilidades.input("Digite o endereco\n"); 
			if(!Validacao.validacaoStringEndereco(endereco)){
				boolean isEndereco = false;
				endereco = ValidacaoWrapper.wrapperEndereco(isEndereco);
			}
			Seguradora seguradora = new Seguradora(cnpj,nome,telefone,endereco);
			ArrayList<Seguradora> seguradoras  = new ArrayList<Seguradora>();
			ArrayList<ClientePF> clientesPF = new ArrayList<ClientePF>();
			ArrayList<ClientePJ> clientesPJ = new ArrayList<ClientePJ>();
			MatrizStr matrizSeguradora  = new MatrizStr(linhas,nColunasSeguradora);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			MatrizStr matrizClientePF = new MatrizStr(linhas,nColunasClientePF);
			MatrizStr matrizClientePJ = new MatrizStr(linhas,nColunasClientePJ);
			matrizSeguradora.preencherMatrizSeguradora(linhas,nColunasSeguradora);
			matrizClientePF.preencherMatrizClientePF(linhas,nColunasClientePF);
			matrizClientePJ.preencherMatrizClientePJ(linhas,nColunasClientePJ);

			for(int i = 0;i<linhas;i++){
				for(int k = 0;k<nColunasSeguradora;k++){
					nome = matrizSeguradora.getElemento(i,0);
					telefone = matrizSeguradora.getElemento(i,1);
					endereco = matrizSeguradora.getElemento(i,2);
					cnpj = matrizSeguradora.getElemento(i,3);
					Seguradora seguradora_ = new Seguradora(cnpj,nome,telefone,endereco);
					seguradoras.add(seguradora_);
				}
			}
			for(int i = 0;i<linhas;i++){
				for(int k = 0;k<nColunasClientePF;k++){
					nome = matrizClientePF.getElemento(i,0);
					telefone = matrizClientePF.getElemento(i,1);
					endereco = matrizClientePF.getElemento(i,2);
					email = matrizClientePF.getElemento(i,3);
					String cpf = matrizClientePF.getElemento(i,4);
					String genero = matrizClientePF.getElemento(i,5);
					String dataStr = matrizClientePF.getElemento(i,6);
					Date data = formatter.parse(dataStr);
					String educacao = matrizClientePF.getElemento(i,7);
					ClientePF cltPF = new ClientePF(nome,telefone,endereco,email,cpf,genero,data,educacao);
					clientesPF.add(cltPF);
				}
			}
			for(int i = 0;i<linhas;i++){
				for(int k = 0;k<nColunasClientePJ;k++){
					nome = matrizClientePJ.getElemento(i,0);
					telefone = matrizClientePJ.getElemento(i,1);
					endereco = matrizClientePJ.getElemento(i,2);
						email = matrizClientePJ.getElemento(i,3);
						cnpj = matrizClientePJ.getElemento(i,4);
						String dataStr = matrizClientePJ.getElemento(i,5);
						Date data = formatter.parse(dataStr);
						int numFunc = Utilidades.strToInt(matrizClientePJ.getElemento(i,6));
						ClientePJ cltPJ = new ClientePJ(nome,telefone,endereco,email,cnpj,data,numFunc);
						clientesPJ.add(cltPJ);
					}
				}
				boolean sair = false;
				MenuPrincipalSeguradora menuPrincipal = MenuPrincipalSeguradora.INICIO;

				while(!sair){
					String menuStr = new String();
					menuStr += "MENU:\n"  + "1: Sair\n" + "2: Cadastro\n" 
					+ "3: Adicionar Seguro\n" + "4: Listar clientes\n" 
					 + "5: Cancelar\n" 
					+ "6: Remover\n" + "7: Gerar sinistro\n" + "8: Transferir Seguro\n" + "9: Calcular receita seguradora\n"; 
				
					String opcMenu = Utilidades.input(menuStr);
					int opcao = Utilidades.strToInt(opcMenu);
					menuPrincipal = menuPrincipal.lerDoMenu(opcao);
					switch (menuPrincipal){
						case SAIR:
								sair = true;
								break;
						case CADASTRO:{
						String opcaoClt = Utilidades.input("Digite PF para cliente PF ou PJ para cliente PJ\n");
						if(opcaoClt.equals("PF") || opcaoClt.equals("pf")){
							nome = Utilidades.input("digite o nome:\n");
							 String dataStrI = Utilidades.input("Digite a data de inicio:\n");
							String dataStrII = Utilidades.input("digite a data de termino:\n"); 
							telefone = Utilidades.input("digite o telefone\n");
							endereco = Utilidades.input("digite o endereco\n");
							email = Utilidades.input("digite o email\n");
							String educacao = Utilidades.input("digite sua educacao\n");
							String cpf = Utilidades.input("digite o cpf:\n");
							String genero = Utilidades.input("digite o genero\n");
							String dataStr = Utilidades.input("digite a data de nascimento\n");
							Date data = formatter.parse(dataStr);
							ClientePF cltPF = new ClientePF(nome,telefone,endereco,email,cpf,genero,data,educacao);
							String placa = Utilidades.input("digite a placa\n");
							String marca = Utilidades.input("digite a marca\n");
							String modelo = Utilidades.input("digite o modelo\n");
							int anoFabricacao = Utilidades.strToInt(Utilidades.input("Digite o ano de fabricacao\n"));
							Veiculo veiculo = new Veiculo(placa,marca,modelo,anoFabricacao);
							Condutor cond = new Condutor(cpf,nome,telefone,endereco,data); 
							seguradora.adicionarCliente(cltPF);
							Date dataI = formatter.parse(dataStrI);
							Date dataF = formatter.parse(dataStrII);
							float valorMensal = SeguroPF.calcularValor(cltPF,cond);
							SeguroPF seg = new SeguroPF(dataI,dataF,seguradora,valorMensal,veiculo,cltPF);
							seguradora.adicionarSeguro(seg);
						}	
						if(opcaoClt.equals("pj") || opcaoClt.equals("PJ")){
							String dataStrI = Utilidades.input("Digite a data de inicio\n");
							String dataStrII = Utilidades.input("digite a data de termino\n"); 
							nome = Utilidades.input("digite o nome da empresa\n");
							telefone = Utilidades.input("digite o telefone\n");
							endereco = Utilidades.input("digite o endereco\n");
							email = Utilidades.input("digite o email\n");
							cnpj = Utilidades.input("digite o cnpj\n");
							String dataStr = Utilidades.input("digite a data de fundação\n");
							int n = Utilidades.strToInt(Utilidades.input("digite quantos automoveis deseja cadastrar na frota\n"));
							Frota frota = new Frota();
							frota.adicionarVeiculo(n);
							Date data = formatter.parse(dataStr);
							int qFunc = Utilidades.strToInt(Utilidades.input("digite a quantidade de funcionarios\n"));
							ClientePJ cltPJ = new ClientePJ(nome,telefone,endereco,email,cnpj,data,qFunc);
							cnpj = Utilidades.input("Digite o cnpj\n");
							nome = Utilidades.input("Digite o nome\n");
							endereco = Utilidades.input("Digite o endereco\n");
							telefone = Utilidades.input("Digite o telefone\n");
							String dataNasc = Utilidades.input("Digite a data de nascimento\n");
							Date dataN = formatter.parse(dataNasc);
							CondutorPJ condPJ = new CondutorPJ(cnpj,nome,telefone,endereco,dataN);
							float valorMensal = SeguroPJ.calcularValor(cltPJ,condPJ);
							seguradora.adicionarCliente(cltPJ);
						}
							break;
						}
						case ADICIONAR_SEGURO:
								String opcaoClt = Utilidades.input("Digite PF para seguro do tipo PF e PJ para seguro do tipo PJ");
								if(opcaoClt.equals("pf") || opcaoClt.equals("PF")){
									 String dataStrI = Utilidades.input("Digite a data de inicio");
									String dataStrII = Utilidades.input("digite a data de termino"); 
									String cpf = Utilidades.input("Digite o cpf");
									nome = Utilidades.input("digite o nome");
									endereco = Utilidades.input("digite o endereco");
									String dataNasc = Utilidades.input("digite a data de nascimento");
									Date dataN = formatter.parse(dataNasc);
									Condutor cond = new Condutor(cpf,nome,telefone,endereco,dataN); 
									String genero = Utilidades.input("Digite o genero");
									String educacao = Utilidades.input("digite a educacao");
									ClientePF cltPF = new ClientePF(nome,telefone,endereco,email,cpf,genero,dataN,educacao);
									float valorMensal = SeguroPF.calcularValor(cltPF,cond);
									Date dataI = formatter.parse(dataStrI);
									Date dataF = formatter.parse(dataStrII);
									String placa = Utilidades.input("digite a placa\n");
									String marca = Utilidades.input("digite a marca\n");
									String modelo = Utilidades.input("digite o modelo\n");
									int anoFabricacao = Utilidades.strToInt(Utilidades.input("Digite o ano de fabricacao"));
									Veiculo veiculo = new Veiculo(placa,marca,modelo,anoFabricacao);
									SeguroPF seg = new SeguroPF(dataI,dataF,seguradora,valorMensal,veiculo,cltPF);
									seguradora.adicionarSeguro(seg);
								}
								break;
						case LISTAR_CLIENTES:
								String tipoCliente = Utilidades.input("O tipo de cliente deve ser PF para pessoas fisicas ou PJ para pessoas juridicas");
								while(!tipoCliente.equals("pf") &&  !tipoCliente.equals("PF") && !tipoCliente.equals("PJ") && !tipoCliente.equals("pj")){
									Erro.imprimirErro("Erro - digite pf ou pj para proseeguir");
									tipoCliente = Utilidades.input("");
								}
								seguradora.listarClientes(tipoCliente);
								break;
						case CANCELAR:
						case REMOVER:
								String identificacao = Utilidades.input("digite a identificacao (CPF/CNPJ) para remover ou cancelar o seguro");

								seguradora.removerCliente(identificacao);
								break;
						case GERAR_SINISTRO:
								break;
						case TRANSFERIR_SEGURO:
								break;
						case CALCULAR_RECEITA_SEGURADORA:
								break;
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
}
