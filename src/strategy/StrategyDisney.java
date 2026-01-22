package strategy;

import dominio.DisneyPlus;
import dominio.PlanStreaming;
import dominio.PlataformaStreaming;

public class StrategyDisney implements PriceStrategy {

    @Override
    public int calcular(PlanStreaming plan, PlataformaStreaming plataforma) {

        DisneyPlus dp = (DisneyPlus) plataforma;

        int total = 0;

        total += obtenerPrecioBase(plan, plataforma);
        total += Math.max(0, plan.getPantallas() - 1) * plataforma.getCostoPantallaExtra();

        if (plan.getCalidad() == 3) total += 1500;
        if (plan.getCalidad() == 2) total += 800;

        total += costoExtras(plan);
        total += costoPacks(plan);

        if (plan.getPacks().contains("Kids Pack")) {
            total -= dp.getDescuentoFamiliar();
        }

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
