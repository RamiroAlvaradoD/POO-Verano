package dominio;

import java.util.List;

public abstract class PlataformaStreaming {
	String nombre;
	protected int precioBasico;
    protected int precioEstandar;
    protected int precioPremium;
	
	protected int minPantallas;
    protected int maxPantallas;
    
    protected int costoPantallaExtra;
    
    protected List<String> extrasDisponibles;

	public PlataformaStreaming(String nombre, int precioBasico, int precioEstandar, int precioPremium, int minPantallas,
			int maxPantallas, int costoPantallaExtra, List<String> extrasDisponibles) {
		this.nombre = nombre;
		this.precioBasico = precioBasico;
		this.precioEstandar = precioEstandar;
		this.precioPremium = precioPremium;
		this.minPantallas = minPantallas;
		this.maxPantallas = maxPantallas;
		this.costoPantallaExtra = costoPantallaExtra;
		this.extrasDisponibles = extrasDisponibles;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPrecioBasico() {
		return precioBasico;
	}

	public int getPrecioEstandar() {
		return precioEstandar;
	}

	public int getPrecioPremium() {
		return precioPremium;
	}

	public int getMinPantallas() {
		return minPantallas;
	}

	public int getMaxPantallas() {
		return maxPantallas;
	}

	public int getCostoPantallaExtra() {
		return costoPantallaExtra;
	}

	public List<String> getExtrasDisponibles() {
		return extrasDisponibles;
	}
    
    
	

}
