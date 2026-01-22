package dominio;

public class PrimeVideo extends PlataformaStreaming {

    private int descuentoAnual;

    public PrimeVideo(int basico, int estandar, int premium, int costoPantallaExtra, int descuentoAnual) {
        super("Prime Video", basico, estandar, premium, costoPantallaExtra);
        this.descuentoAnual = descuentoAnual;
    }

    public int getDescuentoAnual() {
        return descuentoAnual;
    }
}
