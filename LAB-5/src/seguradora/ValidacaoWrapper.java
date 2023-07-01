package seguradora;
import seguradora.Validacao;
import seguradora.Utilidades;
import seguradora.Erro;
public class ValidacaoWrapper extends Validacao{
	static public String wrapperCPF(boolean isCPF){
		String cpf = new String("");
		while(!isCPF){
			Erro.imprimirErro("Erro - CPF invalido");
			cpf = Utilidades.input("digite outro CPF\n");
			if(Validacao.validarCPF(cpf)){
				isCPF = true;
			}
		}
		return cpf;
	}
	public static String wrapperCNPJ(boolean isCNPJ){
		String cnpj = new String("");
		while(!isCNPJ){
				Erro.imprimirErro("Erro - CNPJ invalido");
			cnpj = Utilidades.input("digite outro CNPJ\n");
			if(Validacao.validarCPF(cnpj)){
				isCNPJ = true;
			}
		}
		return cnpj;
	}
	static public String wrapperNome(boolean isNome){
		String nome = new String("");
		while(!isNome){
				Erro.imprimirErro("Erro - nome invalido");
			nome = Utilidades.input("digite outro nome\n");
			if(Validacao.validacaoStringSomenteLetras(nome)){
				isNome = true;
			}
		}
		return nome;
	}
	static public String wrapperTelefone(boolean isTelefone){
		String telefone = new String("");
		while(!isTelefone){
				Erro.imprimirErro("Erro - telefone invalido");
			telefone = Utilidades.input("digite outro telefone\n");
			if(Validacao.validacaoStringTelefone(telefone)){
				isTelefone = true;
			}
		}
		return telefone;
	}
	static public String wrapperEndereco(boolean isEndereco){
		String endereco = new String("");
		while(!isEndereco){
				Erro.imprimirErro("Erro - endereco invalido");
			endereco = Utilidades.input("digite outro endereco\n");
			if(Validacao.validacaoStringEndereco(endereco)){
				isEndereco = true;
			}
		}
		return endereco;
	}
}
