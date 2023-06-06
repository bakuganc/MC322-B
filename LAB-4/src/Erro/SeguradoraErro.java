package Erro;
public class SeguradoraErro  {
	private static String mensagem;
	private Throwable causa;

	public static void imprimirMensagemErro(String mensagem){
		System.err.println(mensagem);
	}
}
