package dominio;

import java.util.List;

public class PlanStreaming {

    private String nombreCliente;
    private String plataforma;
    private String tipoPlan;
    private int pantallas;
    private int calidad; 
    private List<String> extras;
    private List<String> packs;

    public PlanStreaming(String nombreCliente, String plataforma, String tipoPlan,
                         int pantallas, int calidad,
                         List<String> extras, List<String> packs) {

        this.nombreCliente = nombreCliente;
        this.plataforma = plataforma;
        this.tipoPlan = tipoPlan;
        this.pantallas = pantallas;
        this.calidad = calidad;
        this.extras = extras;
        this.packs = packs;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public int getPantallas() {
        return pantallas;
    }

    public int getCalidad() {
        return calidad;
    }

    public List<String> getExtras() {
        return extras;
    }

    public List<String> getPacks() {
        return packs;
    }
}
