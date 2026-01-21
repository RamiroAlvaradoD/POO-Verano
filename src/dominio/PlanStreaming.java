package dominio;

import java.util.List;

public class PlanStreaming {
    private String nombreCliente;
    private String plataforma;
    private String tipoPlan;
    private int pantallas;
    private int calidad; // 1 SD, 2 HD, 3 4K
    private List<String> extras;
    private List<String> packs;
	public PlanStreaming(String nombreCliente, String plataforma, String tipoPlan, int pantallas, int calidad,
			List<String> extras, List<String> packs) {
		this.nombreCliente = nombreCliente;
		this.plataforma = plataforma;
		this.tipoPlan = tipoPlan;
		this.pantallas = pantallas;
		this.calidad = calidad;
		this.extras = extras;
		this.packs = packs;
	}
    
    
}
