package dominio;

import java.util.List;

public class Netflix extends PlataformaStreaming {
	private int cargo4k;

	public Netflix(int precioBasico, int precioEstandar, int precioPremium, int minPantallas,
			int maxPantallas, int costoPantallaExtra, List<String> extrasDisponibles, int cargo4k) {
		super("Netflix", precioBasico, precioEstandar, precioPremium, minPantallas, maxPantallas, costoPantallaExtra,
				extrasDisponibles);
		this.cargo4k = cargo4k;
	}

	public int getCargo4k() {
		return cargo4k;
	}
	
	

}
