package negocio;

public class Seguro {
	private int id;
	private String descripcion;
	private double costoContratacion;
	private double costoMaximoAsegurado;
	private TipoSeguro tipoSeguro;
	
	public Seguro() {
		tipoSeguro=new TipoSeguro();
    }
	
	public Seguro(int id,String descripcion, double costoContratacion, double costoMaximoAsegurado, TipoSeguro tipoSeguro) {
        this.descripcion = descripcion;
        this.costoContratacion = costoContratacion;
        this.costoMaximoAsegurado = costoMaximoAsegurado;
        this.tipoSeguro = tipoSeguro;
    }
	
	 public int getId() {
	        return id;
	    }

	 public void setId(int id) {
		 this.id=id;
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
	    
	    /*
	    public TipoSeguro getTipoSeguro() {
	        return tipoSeguro;
	    }*/

	    /*
	    public void setTipoSeguro(TipoSeguro tipoSeguro) {
	        this.tipoSeguro = tipoSeguro;
	    }*/
	    
	    public void setIdTipoSeguro(int idTipoSeguro) {
	    	tipoSeguro.setIdTipo(idTipoSeguro);
	    }
	    
	    public int getIdTipoSeguro() {
	    	return tipoSeguro.getIdTipo();
	    }
}
