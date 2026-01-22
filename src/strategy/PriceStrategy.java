package strategy;

import dominio.PlanStreaming;
import dominio.PlataformaStreaming;

public interface PriceStrategy {
    int calcular(PlanStreaming plan, PlataformaStreaming plataforma);
}
