package negocio;

public class Seguro {
	private static int id=0;
	private String descripcion;
	private double costoContratacion;
	private double costoMaximoAsegurado;
	
	public Seguro(){
		id++;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public double getCostoMaximoAsegurado() {
		return costoMaximoAsegurado;
	}

	public void setCostoMaximoAsegurado(double costoMaximoAsegurado) {
		this.costoMaximoAsegurado = costoMaximoAsegurado;
	}

	public static int getId() {
		return id;
	}
	
	
}
