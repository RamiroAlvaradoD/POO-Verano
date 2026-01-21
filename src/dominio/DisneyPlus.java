package dominio;

import java.util.List;

public class DisneyPlus extends PlataformaStreaming {

	private int descuentoFamiliar;

	public DisneyPlus(int precioBasico, int precioEstandar, int precioPremium, int minPantallas,
			int maxPantallas, int costoPantallaExtra, List<String> extrasDisponibles, int descuentoFamiliar) {
		super("Disney+", precioBasico, precioEstandar, precioPremium, minPantallas, maxPantallas, costoPantallaExtra,
				extrasDisponibles);
		this.descuentoFamiliar = descuentoFamiliar;
	}

	public int getDescuentoFamiliar() {
		return descuentoFamiliar;
	}
	
	
	
}
