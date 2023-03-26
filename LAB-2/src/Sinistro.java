
public class Sinistro {
	private String id;
	private String data;
	private String endereço;

	// implementação//
	public Sinistro(String id, String data, String endereço) {
		this.id = id;
		this.data = data;
		this.endereço = endereço;
	}

	// getters and setters//
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

}
