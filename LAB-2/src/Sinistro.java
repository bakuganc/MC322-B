import java.util.Random;

public class Sinistro {
	private String id;
	private String data;
	private String endereço;

	// implementação//
	public Sinistro(String id, String data, String endereço) {
		this.id = generateRandomId();
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

	private static String generateRandomId() {
		// definir o comprimento do ID aqui//
		int length = 10;
		// caracteres possíveis para o ID//
		String chars = "0123456789";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}
}
