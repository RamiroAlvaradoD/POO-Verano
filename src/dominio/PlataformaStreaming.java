package dominio;

public abstract class PlataformaStreaming {

    protected String nombre;

    protected int precioBasico;
    protected int precioEstandar;
    protected int precioPremium;

    protected int costoPantallaExtra;

    public PlataformaStreaming(String nombre, int basico, int estandar, int premium, int costoPantallaExtra) {
        this.nombre = nombre;
        this.precioBasico = basico;
        this.precioEstandar = estandar;
        this.precioPremium = premium;
        this.costoPantallaExtra = costoPantallaExtra;
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

    public int getCostoPantallaExtra() {
        return costoPantallaExtra;
    }
}
