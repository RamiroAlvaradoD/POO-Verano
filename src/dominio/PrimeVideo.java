package dominio;

import java.util.List;

public class PrimeVideo extends PlataformaStreaming {
	private int descuentoAnual;

	public PrimeVideo(int precioBasico, int precioEstandar, int precioPremium, int minPantallas,
			int maxPantallas, int costoPantallaExtra, List<String> extrasDisponibles, int descuentoAnual) {
		super("Prime Video", precioBasico, precioEstandar, precioPremium, minPantallas, maxPantallas, costoPantallaExtra,
				extrasDisponibles);
		this.descuentoAnual = descuentoAnual;
	}

	public int getDescuentoAnual() {
		return descuentoAnual;
	}
	
	

}
