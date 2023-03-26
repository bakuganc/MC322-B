
public class Veículo {
	 private String placa;
	 private String marca;
	 private String modelo;
	 
	 //implementação//
	 public Veículo ( String placa , String marca , String modelo ) {
	 this . placa = placa;
	 this . marca = marca;
	 this . modelo = modelo;
	 }

	//getters and setters//
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	 
}
