package utilidades;
import java.util.*;
public class Utilidades{
	private int numero;
	private String str;
	public Utilidades(){
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
	static public Integer charToInt(char c){
		if( '0' > c || '9' < c){
			return null;
		}
		return c - '0';
	}
	static public Integer potencia(int base,int expoente){
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
	public static long calcularIdade(Date nascimento,Date atual){
		if(nascimento == null || atual == null){
			return 0;
		}
		return atual.getYear()-nascimento.getYear(); 
	}
}
