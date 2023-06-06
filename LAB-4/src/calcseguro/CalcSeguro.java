package calcseguro;
public enum CalcSeguro {
	VALOR_BASE (100.0),
	FATOR_18_30(1.2),
	FATOR_30_60(1.0),
	FATOR_60_90(1.5);

	public final double fator;
	CalcSeguro(double fator){
		this.fator = fator;
	}

	public double getFator(){
		return fator;
	}
	
	public static CalcSeguro mudarFator(long idade){
		if(18 <= idade && idade <= 30){
			return CalcSeguro.values()[1];
		}
		else if(30 <= idade && idade <= 60){
			return CalcSeguro.values()[2];
		}
		else if(60 <= idade && idade <= 90){
			return CalcSeguro.values()[3];
		}
		else{
			throw new IllegalArgumentException("idade deve ser maior ou igual " +
			" a 18 e menor que 90!");
		}
	}
}
