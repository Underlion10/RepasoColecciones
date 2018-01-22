package modelo;

public class Vendedor extends Persona{
	
	private String codigoVendedor;
	private float importeTotal;
	
	public Vendedor(String codigoVendedor, float importeTotal) {
		super();
		this.codigoVendedor = codigoVendedor;
		this.importeTotal = importeTotal;
	}

	public String getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public float getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(float importeTotal) {
		this.importeTotal = importeTotal;
	}

}
