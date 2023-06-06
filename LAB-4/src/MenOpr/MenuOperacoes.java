package MenOpr;
public enum MenuOperacoes{
	INICIAR(0),
	CADASTRAR_PJ(1),
	CADASTRAR_PF(2),
	REMOVER(3),
	LISTAR_CLIENTES(4),
	GERAR_SINISTRO(5),
	VISUALIZAR_SINISTRO(6),
	SAIR(7);
	public final int operacao;
	MenuOperacoes(int operacao){
		this.operacao = operacao;
	}
	public int getOperacao(){
		return this.operacao;
	}
	public static MenuOperacoes lerDoMenu(int operacao){
		if(operacao < 1 || operacao > 7){
			throw new IllegalArgumentException("Erro: argumento invalido"
			);
		}
		return MenuOperacoes.values()[operacao];
	}
	

}
