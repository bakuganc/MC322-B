package seguradora;
public class Menu{
	public enum MenuPrincipalSeguradora{
		INICIO(0),
		SAIR(1),
		CADASTRO(2),
		ADICIONAR_SEGURO(3),
		LISTAR_CLIENTES(4),
		CANCELAR(5),
		REMOVER(6),
		GERAR_SINISTRO(7),
		TRANSFERIR_SEGURO(8),
		CALCULAR_RECEITA_SEGURADORA(9);
		public final int operacao;
		MenuPrincipalSeguradora(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuPrincipalSeguradora lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 9){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuPrincipalSeguradora.values()[operacao];
		}
		
	}
	public enum MenuClientePJ{
		INICIO(0),
		CADASTRAR_FROTA(1),
		ATUALIZAR_FROTA(2);
		public final int operacao;
		MenuClientePJ(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuClientePJ lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 2){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuClientePJ.values()[operacao];
		}
	}
	public enum MenuClientePF{
		INICIO(0),
		ADICIONAR_VEICULO(1),
		REMOVER_VEICULO(2);
		public final int operacao;
		MenuClientePF(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuClientePF lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 2){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuClientePF.values()[operacao];
		}
	}
	public enum MenuCondutor{
		INICIO(0),
		ADICIONAR_VEICULO(1),
		REMOVER_VEICULO(2);
		public final int operacao;
		MenuCondutor(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuCondutor lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 2){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuCondutor.values()[operacao];
		}
	}
	public enum MenuFrota{
		INICIO(0),
		ADICIONAR_VEICULO(1),
		REMOVER_VEICULO(2);
		public final int operacao;
		MenuFrota(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuFrota lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 2){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuFrota.values()[operacao];
		}
	}

	public enum MenuSeguro{
		INICIO(0),
		DESAUTORIZAR_CONDUTOR(1),
		AUTORIZAR_CONDUTOR(2),
		CALCULAR_VALOR(3),
		GERAR_SINISTRO(4);
		final int operacao;
		MenuSeguro(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuFrota lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 4){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuFrota.values()[operacao];
		}
	}
	
	public enum MenuSeguroPJ{
		INICIO(0),
		DESAUTORIZAR_CONDUTOR(1),
		AUTORIZAR_CONDUTOR(2),
		CALCULAR_VALOR(3),
		GERAR_SINISTRO(4);
		public final int operacao;
		MenuSeguroPJ(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuSeguroPJ lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 4){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuSeguroPJ.values()[operacao];
		}
	}

	public enum MenuSeguroPF{
		INICIO(0),
		DESAUTORIZAR_CONDUTOR(1),
		AUTORIZAR_CONDUTOR(2),
		CALCULAR_VALOR(3),
		GERAR_SINISTRO(4);
		public final int operacao;
		MenuSeguroPF(int operacao){
			this.operacao = operacao;
		}
		public int getOperacao(){
			return this.operacao;
		}
		public static MenuSeguroPF lerDoMenu(int operacao){
			if(operacao < 0 || operacao > 4){
				throw new IllegalArgumentException("Erro: argumento invalido"
				);
			}
			return MenuSeguroPF.values()[operacao];
		}
	}
}
