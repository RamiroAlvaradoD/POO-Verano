package dominio;

public class DisneyPlus extends PlataformaStreaming {

    private int descuentoFamiliar;

    public DisneyPlus(int basico, int estandar, int premium, int costoPantallaExtra, int descuentoFamiliar) {
        super("Disney+", basico, estandar, premium, costoPantallaExtra);
        this.descuentoFamiliar = descuentoFamiliar;
    }

    public int getDescuentoFamiliar() {
        return descuentoFamiliar;
    }
}
