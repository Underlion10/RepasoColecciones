package modelo;

import java.time.LocalDate;

public class Venta {
	
	private LocalDate fechaVenta;
	private float importe;
	private Vendedor vendedor;
	
	public Venta(Vendedor vendedor, LocalDate fechaVenta, float importe) {
		this.fechaVenta = fechaVenta;
		this.importe = importe;
		this.vendedor = vendedor;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
