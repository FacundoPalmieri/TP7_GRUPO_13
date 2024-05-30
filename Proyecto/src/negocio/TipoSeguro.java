package negocio;

public class TipoSeguro {
	private static int idTipo=0;
	private String descripcion;
	
	public TipoSeguro() {
		idTipo++;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static int getIdTipo() {
		return idTipo;
	}
	
	
}
