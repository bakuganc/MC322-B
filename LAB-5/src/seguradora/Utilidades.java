package seguradora;
import java.util.*;
import java.time.*;
import java.text.ParseException;
import java.text.*;
import seguradora.Erro;
import seguradora.Menu;
import seguradora.ClientePF;
import seguradora.Seguro;
import seguradora.Condutor;
import java.util.concurrent.ThreadLocalRandom;
public class Utilidades{
	public Utilidades(){
	}
	static public String gerarID(){
		final int min = 1024;
		final int max  = 2048;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		String ID = new String("" + randomNum);
		return ID;
	}
	static public Integer strToInt(String str){
		
		int digito = 1; 
		int resultado = 1;
		int pot = 1;
		int base = 10;
		int expoente = 1;
		int i = 0;
		int soma = 0;
		if(str == null || str.length() == 0){
			return null;
		}
		if(str.charAt(i) == '-'){
			resultado *= -1;
			i++;
			expoente =  str.length() - 2;
		} else{
			expoente =  str.length() - 1;
		}
		pot = potencia(base,expoente); 
		for(;i<str.length();i++){
			digito = charToInt(str.charAt(i));
			soma += (digito * pot);
			pot /= base;
		}
		return resultado*=soma;
	}
	static private Integer charToInt(char c){
		if( '0' > c || '9' < c){
			return null;
		}
		return c - '0';
	}
	static private Integer potencia(int base,int expoente){
		if(expoente < 0){
			return null;
		}
		int resultado = 1;
		for(int i = 0,j = base;i<expoente;i++){
			resultado *=  j;
		}
		return resultado;
	}
	static public Long potencia(long base,long expoente){
		if(expoente < 0){
			return null;
		}
		long resultado = 1;
		for(long i = 0,j = base;i<expoente;i++){
			resultado *=  j;
		}
		return resultado;
		
	}
	static public Long  strtoLong(String s){
		long  digito = 1; 
		long  resultado = 1;
		long  pot = 1;
		long  base = 10;
		long  expoente = 1;
		int i = 0;
		long  soma = 0;
		if(s == null || s.length() == 0){
			return null;
		}
		if(s.charAt(i) == '-'){
			resultado *= -1;
			i++;
			expoente =  s.length() - 2;
		} else{
			expoente =  s.length() - 1;
		}
		pot = potencia(base,expoente); 
		for(;i<s.length();i++){
			digito = charToInt(s.charAt(i));
			soma += (digito * pot);
			pot /= base;
		}
		return resultado*=soma;
		
	}
	static public String longToString(long l){
			String str = new String("");
			Stack <Long> pilha = new Stack<Long>();
			while(l != (long) 0){
				long digito = l % 10;
				l /= 10;
				pilha.add(digito);
			}
			while(!pilha.isEmpty()){
				str+= (pilha.pop());
			}
			return str;
	}
	public static LocalDate converterData(Date data){
		LocalDate dataConvertida = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return dataConvertida;
	}
	public static int calcularIdade(LocalDate dataNascimento,LocalDate dataAtual){
		if(dataNascimento == null || dataAtual == null){
			return -1;
		}
		return Period.between(dataNascimento,dataAtual).getYears();
	}
	static public void imprimirString(String str){
		if(str == null){
			return;
		}
		System.out.println(str);
	}
	public static  String input(String mensagem){
		Scanner sc = new Scanner(System.in);
		System.out.printf(mensagem);
		String str = new String();
		str = sc.nextLine();
		return str;
	}
	public static boolean setVariavel(boolean variavel,boolean valorDesejado){
		variavel = valorDesejado;
		return variavel;
	}
	static public boolean tratarExcecaoMenu(Menu.MenuPrincipalSeguradora mp,String opcaoStr, int start, int end){
		boolean excecaoFoiJogada = false;
		do{
			if(excecaoFoiJogada){
				Erro.imprimirErro("Erro - digite um número entre " +
				start + " e " + end);
				opcaoStr = input("");
			}
			try{
				int opcao = strToInt(opcaoStr);
				mp = Menu.MenuPrincipalSeguradora.lerDoMenu(opcao);
				excecaoFoiJogada = true;
			}
			catch(IllegalArgumentException e){
				excecaoFoiJogada = true;
			}
		}while(excecaoFoiJogada);
		return true;
	}
	static public String tratarExcecaoData(String dataStr){
		boolean excecaoFoiJogada = false;
		do{
			if(excecaoFoiJogada){
				Erro.imprimirErro("Erro - digite uma data valida");
				dataStr = input("");
			}
			try{
				String PADRAO_DATA = "dd/m,m/yyyy";
				DateFormat formatador = new SimpleDateFormat(PADRAO_DATA);
				Date data = formatador.parse(dataStr);
				excecaoFoiJogada = false;
			}
			catch(IllegalArgumentException e){
				excecaoFoiJogada = true;
			}
			catch(ParseException parseExc){
				excecaoFoiJogada = true;
			}
		}while(excecaoFoiJogada);
		return dataStr;
	}
	static public String tratarExcecaoString(String str,String mensgaemErro){
		boolean excecaoFoiJogada = false;
		do{
			if(excecaoFoiJogada){
				Erro.imprimirErro(mensgaemErro);
				str = input("");
			}
			try{
				imprimirMensagem(str);
				excecaoFoiJogada = false;
			}
			catch(IllegalArgumentException e){
				excecaoFoiJogada = true;
			}
		}while(excecaoFoiJogada);
		return str;
	}
	static public void imprimirMensagem(String mensagem){
		if(mensagem == null){
			throw new IllegalArgumentException("Mensagem deve ser diferente de "+ "null");
		}
		System.out.println(mensagem);
	}
	static public int quantidadeDeVeiculos(ClientePF cltPF){
		if(cltPF == null){
			throw new IllegalArgumentException("Erro - Condutor deve ser diferente de null");
		}
		return cltPF.getListaVeiculos().size();
	}

	static public int quantidadeDeSinistrosCondutor(Condutor cond){
		if(cond == null){
			throw new IllegalArgumentException("Erro - Condutor deve ser diferente de null");
		}
		return cond.getListaSinistros().size();
	}
	static public boolean booleanAt( ArrayList<Boolean> array,int index){
		if(array.size() == 0){
			String mensagemErro = new String("Erro - Tamanho invalido para o array");
			throw new IllegalArgumentException(mensagemErro);
		}
		if(index < 0 || index >= array.size()){
			String mensagemErro = new String("Erro - indice invalido para o array");
			throw new IllegalArgumentException(mensagemErro);
			
		}
		return array.get(index); 

	}
}

