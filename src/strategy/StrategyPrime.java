package strategy;

import dominio.PlanStreaming;
import dominio.PlataformaStreaming;
import dominio.PrimeVideo;

public class StrategyPrime implements PriceStrategy {

    @Override
    public int calcular(PlanStreaming plan, PlataformaStreaming plataforma) {

        PrimeVideo pv = (PrimeVideo) plataforma;

        int total = 0;

        total += obtenerPrecioBase(plan, plataforma);
        total += Math.max(0, plan.getPantallas() - 1) * plataforma.getCostoPantallaExtra();

        // calidad (Prime cobra casi nada)
        if (plan.getCalidad() == 3) total += 500;
        if (plan.getCalidad() == 2) total += 300;

        total += costoExtras(plan);
        total += costoPacks(plan);

        // Atributo único: descuento fijo (simula promoción)
        total -= pv.getDescuentoAnual();

        return Math.max(total, 0);
    }

    private int obtenerPrecioBase(PlanStreaming plan, PlataformaStreaming plataforma) {
        switch (plan.getTipoPlan()) {
            case "Básico": return plataforma.getPrecioBasico();
            case "Estándar": return plataforma.getPrecioEstandar();
            case "Premium": return plataforma.getPrecioPremium();
            default: return plataforma.getPrecioBasico();
        }
    }

    private int costoExtras(PlanStreaming plan) {
        int extra = 0;
        for (String e : plan.getExtras()) {
            if (e.equals("Sin anuncios")) extra += 2000;
            if (e.equals("Descargas offline")) extra += 1000;
            if (e.equals("Deportes")) extra += 3000;
        }
        return extra;
    }

    private int costoPacks(PlanStreaming plan) {
        int packs = 0;
        for (String p : plan.getPacks()) {
            if (p.equals("Kids Pack")) packs += 800;
            if (p.equals("Cine Premium")) packs += 2000;
            if (p.equals("Música")) packs += 1200;
            if (p.equals("Familiar")) packs += 1500;
        }
        return packs;
    }
}
