package br.com.reccos.admin.enums;

public enum Positions {

	GOLEIRO(0, "GOLEIRO"), LATERAL(1, "LATERAL"), ZAGUEIRO(2, "ZAGUEIRO"), VOLANTE(3, "VOLANTE"), MEIA(4, "MEIA"),
	ATACANTE(5, "ATACANTE");

	private Integer cod;
	private String description;

	private Positions(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static Positions toEnum(Integer cod) {
		if (cod == null)
			return null;

		for (Positions x : Positions.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}

		throw new IllegalArgumentException("Posição do jogador inválida!");
	}

}
