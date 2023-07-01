package seguradora;
import seguradora.Erro;
import seguradora.Utilidades;
import seguradora.Validacao;
import java.util.*;
public class MatrizStr{
	final int linhas;
	final int colunas;
	String[][] matriz;
	
	public int getLinhas(){
		return linhas;
	}
	public int getColunas(){
		return colunas;
	}
	public MatrizStr(int linhas,int colunas){
		this.linhas = linhas;
		this.colunas = colunas;
		matriz = new String[linhas][colunas];
	}
	private boolean verificarLinhasEColunas(int nLinhas,int nColunas){
		if(nLinhas < 0 || nColunas < 0){
			String mensagemErro = new String("Erro - o numero de linhas/colunas deve ser maior ou igual a zero!");
			Erro.imprimirErro(mensagemErro);
			return false;
		}
		if(nLinhas > getLinhas() || nColunas > getColunas()){
			String mensagemErro = new String("Erro - o numero de linhas/colunas maior que o tamanho da matriz ");
			Erro.imprimirErro(mensagemErro);
		}
		return true;
		
	}
	public String getElemento(int nLinhas,int nColunas){
		if(verificarLinhasEColunas(nLinhas,nColunas)){
			return matriz[nLinhas][nColunas];
		}
		return null;
	}
	@Deprecated
	private ArrayList<Boolean> preencherArrayBool(int nVariaveis,Boolean ... variaveis){
		if(nVariaveis <= 0){
			String mensagemErro = new String("Erro - numero de variaveis deve ser maior que zero");
			throw new IllegalArgumentException(mensagemErro);
		}
		ArrayList<Boolean> vetorVariaveis = new ArrayList<Boolean>(nVariaveis);
		for(int i = 0;i<nVariaveis;i++){
			vetorVariaveis.add(variaveis[i]);
		}
		return vetorVariaveis;
	}
	@Deprecated
	private int getBooleanPosition(ArrayList<Boolean> bools){
		boolean variable = false;
		for(int i = 0;i<bools.size();i++){
			variable = bools.get(i);
			if(variable){
				return i;
			}
		}
		return -1;
	}
	@Deprecated
	private void preencherMatrizApenasColunas(int nLinhas,int nColunas,int nVariaveis,Boolean ... variaveis){
		ArrayList<Boolean> vetorVariaveis = preencherArrayBool(nVariaveis,variaveis);
		int pos = getBooleanPosition(vetorVariaveis);
		if(verificarLinhasEColunas(nLinhas,nColunas)){
			for(int k = 0;k<nColunas;k++){
				String str = Utilidades.input("");
				if(vetorVariaveis.get(0)){
					while(!Validacao.validarCNPJ(str)){
						String mensagemErro = new String("Erro - CNPJ invalido");
						Erro.imprimirErro(mensagemErro);
						str = Utilidades.input("Por favor, digite outro CNPJ\n");
					}
					matriz[nLinhas][k] = str;
				}
				else if(vetorVariaveis.get(1)){
					while(!Validacao.validarCPF(str)){
						String mensagemErro = new String("Erro - CPF invalido");
						Erro.imprimirErro(mensagemErro);
						str = Utilidades.input("Por favor, digite outro CPF\n");
					}
					matriz[nLinhas][k] = str;
					
				}
				else if(vetorVariaveis.get(2)){
					while(!Validacao.validacaoStringSomenteLetras(str)){
						String mensagemErro = new String("Erro - nome invalido");
						Erro.imprimirErro(mensagemErro);
						str = Utilidades.input("Por favor, digite outro nome com somente letras e espacos\n");
					}
					matriz[nLinhas][k] = str;
					
				}
				else if(vetorVariaveis.get(3)){
					while(!Validacao.validacaoStringEndereco(str)){
						String mensagemErro = new String("Erro - endereco invalido");
						Erro.imprimirErro(mensagemErro);
						str = Utilidades.input("Por favor, digite outro endereco comecando com o numero seguido pelo nome da rua/avenida sem virgulas\n");
					}
					matriz[nLinhas][k] = str;
				}
				else if(vetorVariaveis.get(4)){
					while(!Validacao.validacaoStringTelefone(str)){
						String mensagemErro = new String("Erro - telefone invalido");
						str = Utilidades.input("Por favor, digite outro telefone no formato (XX) XXXXX-XXXX\n");
					}
					matriz[nLinhas][k] = str;
				}
				}
			}
		return ;
	}
	public void preencherMatrizClientePF(int nLinhas,int nColunas){
		if(verificarLinhasEColunas(nLinhas,nColunas) && nColunas == 8){
			for(int i = 0;i<nLinhas;i++){
				for(int k = 0;k<nColunas;k++){
						if(k == 0){
							Utilidades.tratarExcecaoString("Digite o nome","Erro - digite outro nome");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringSomenteLetras(str)){
								String mensagemErro = new String("Erro - nome invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro nome com somente letras\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 1){
							Utilidades.tratarExcecaoString("Digite o telefone","Erro - digite outro telefone");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringTelefone(str)){
								String mensagemErro = new String("Erro - telefone invalido");
								str = Utilidades.input("Por favor, digite outro telefone com somente numeros, (), -  no formato (XX) XXXXX-XXXX\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
					
						else if(k == 2){
							Utilidades.tratarExcecaoString("Digite o endereco","Erro - digite outro endereco");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringEndereco(str)){
								String mensagemErro = new String("Erro - endereco invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro endereco no formato XX <NOME RUA, AVENIDA, ETC>\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 3){
							Utilidades.tratarExcecaoString("Digite o endereco de email","Erro - digite outro endereco de email");
							String str = Utilidades.input("");
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 4){
							Utilidades.tratarExcecaoString("Digite o cpf","Erro - digite outro cpf");
							String str = Utilidades.input("");
							while(!Validacao.validarCPF(str)){
								String mensagemErro = new String("Erro - cpf invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro cpf\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
							
						}
						else if(k == 5){
							Utilidades.tratarExcecaoString("Digite o genero","Erro - digite outro genero");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringSomenteLetras(str)){
								String mensagemErro = new String("Erro - xgenero invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro genero\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
							
						}
						else if(k == 6){
							Utilidades.tratarExcecaoString("Digite a data de nascimento","Erro - digite outra data de nascimento");
							String str = Utilidades.input("");
							setElement(i,k,str);
							
						}
						else if(k == 7){
							Utilidades.tratarExcecaoString("Digite a educacao","Erro - digite outra educacao");
							String str = Utilidades.input("");
							setElement(i,k,str);
							
						}

				}
			}
			return;
		}
	}
	public void preencherMatrizSeguradora(int nLinhas,int nColunas ){
		if(verificarLinhasEColunas(nLinhas,nColunas) && nColunas == 4){
			for(int i = 0;i<nLinhas;i++){
				for(int k = 0;k<nColunas;k++){
						if(k == 0){
							Utilidades.tratarExcecaoString("Digite o nome","Erro - digite outro nome");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringSomenteLetras(str)){
								String mensagemErro = new String("Erro - nome invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro nome com somente letras e espacos\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 1){
							Utilidades.tratarExcecaoString("Digite o telefone","Erro - digite outro telefone");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringTelefone(str)){
								String mensagemErro = new String("Erro - telefone invalido");
								str = Utilidades.input("Por favor, digite outro telefone no formato (XX) XXXXX-XXXX\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
					
						else if(k == 2){
							Utilidades.tratarExcecaoString("Digite o endereco","Erro - digite outro endereco");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringEndereco(str)){
								String mensagemErro = new String("Erro - endereco invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro endereco comecando com o numero seguido pelo nome da rua/avenida sem virgulas\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 3){
							Utilidades.tratarExcecaoString("Digite o cnpj","Erro - digite outro cnpj");
							String str = Utilidades.input("");
							while(!Validacao.validarCNPJ(str)){
								String mensagemErro = new String("Erro - CNPJ invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro CNPJ\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
				}
			}
			return;
		}
	}
	public void preencherMatrizClientePJ(int nLinhas,int nColunas ){
		if(verificarLinhasEColunas(nLinhas,nColunas) && nColunas == 7){
			for(int i = 0;i<nLinhas;i++){
				for(int k = 0;k<nColunas;k++){
						if(k == 0){
							Utilidades.tratarExcecaoString("Digite o nome","Erro - digite outro nome");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringSomenteLetras(str)){
								String mensagemErro = new String("Erro - nome invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro nome com somente letras\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 1){
							Utilidades.tratarExcecaoString("Digite o telefone","Erro - digite outro telefone");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringTelefone(str)){
								String mensagemErro = new String("Erro - telefone invalido");
								str = Utilidades.input("Por favor, digite outro telefone com somente numeros, (), -  no formato (XX) XXXXX-XXXX\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
					
						else if(k == 2){
							Utilidades.tratarExcecaoString("Digite o endereco","Erro - digite outro endereco");
							String str = Utilidades.input("");
							while(!Validacao.validacaoStringEndereco(str)){
								String mensagemErro = new String("Erro - endereco invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro endereco no formato XX <NOME RUA, AVENIDA, ETC>\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 3){
							Utilidades.tratarExcecaoString("Digite o endereco de email","Erro - digite outro endereco de email");
							String str = Utilidades.input("");
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
						}
						else if(k == 4){
							Utilidades.tratarExcecaoString("Digite o cnpj","Erro - digite outro cnpj");
							String str = Utilidades.input("");
							while(!Validacao.validarCNPJ(str)){
								String mensagemErro = new String("Erro - cnpj invalido");
								Erro.imprimirErro(mensagemErro);
								str = Utilidades.input("Por favor, digite outro cnpj\n");
							}
							//matriz[nLinhas][k] = str;
							setElement(i,k,str);
							
						}
						else if(k == 5){
							Utilidades.tratarExcecaoString("Digite a data de fundacao","Erro - digite outra data de fundacao");
							String str = Utilidades.input("");
							setElement(i,k,str);
						}
						else if(k == 6){
							Utilidades.tratarExcecaoString("Digite o numero de funcionarios","Erro - digite outro numero");
							String str = Utilidades.input("");
							setElement(i,k,str);
							
						}

				}
			}
			return;
		}
	}
	private void setElement(int linha,int coluna,String str){
		if(verificarLinhasEColunas(linha,coluna) && str  != null){
			matriz[linha][coluna] = str;
		}
		else{
			String mensagemErro = new String("Erro - linha ou coluna fora de alcance ou string igual a null");
			throw new IllegalArgumentException(mensagemErro);
		}
	}
	
}
