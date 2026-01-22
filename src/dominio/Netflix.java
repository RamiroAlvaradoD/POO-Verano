package dominio;

public class Netflix extends PlataformaStreaming {

    private int recargo4K;

    public Netflix(int basico, int estandar, int premium, int costoPantallaExtra, int recargo4K) {
        super("Netflix", basico, estandar, premium, costoPantallaExtra);
        this.recargo4K = recargo4K;
    }

    public int getRecargo4K() {
        return recargo4K;
    }
}
