package seguradora;
public class Fator{
	public enum FatoresPF{
		VALOR_BASE(10.0f),
		FATOR_IDADE_MENOR_30(1.25f),
		FATOR_IDADE_30_E_60(1.00f),
		FATOR_IDADE_MAIOR_60(1.5f);
		public final float fator;
		FatoresPF(float valor){
			fator = valor;
		}
		public float getFator(){
			return fator;
		}
		public static FatoresPF setFator(int idade){
			final int idadeLegal = 18;
			if(idade >= idadeLegal && idade < 30){
				return FatoresPF.values()[1];
			}
			else if(idade >= 30 && idade <= 60){
				return FatoresPF.values()[2];
			}
			else if(idade > 60){
				return FatoresPF.values()[3];
			}
			else{
				throw new IllegalArgumentException("Erro - idade deve ser maior ou igual a 18");
			}
		}
	}
	public enum FatoresPJ{
		VALOR_BASE(10.0f);
		public final float fator;
		FatoresPJ(float valor){
			fator = valor;
		}
		public float getFator(){
			return fator;
		}
	}
	
}
