package sistema;

import dominio.*;
import strategy.*;

public class SistemaImpl implements Sistema {

    @Override
    public int calcularTotal(PlanStreaming plan) {

        PlataformaStreaming plataforma = crearPlataforma(plan.getPlataforma());
        PriceStrategy strategy = obtenerStrategy(plataforma);

        return strategy.calcular(plan, plataforma);
    }

    private PlataformaStreaming crearPlataforma(String nombre) {

        if (nombre.equalsIgnoreCase("Netflix")) {
            return new Netflix(6990, 9990, 12990, 1500, 2500);
        }

        if (nombre.equalsIgnoreCase("Disney+")) {
            return new DisneyPlus(5990, 8990, 10990, 1200, 1500);
        }

        if (nombre.equalsIgnoreCase("Prime Video")) {
            return new PrimeVideo(4990, 7990, 9990, 1000, 1000);
        }

        throw new IllegalArgumentException("Plataforma inválida: " + nombre);
    }

    private PriceStrategy obtenerStrategy(PlataformaStreaming plataforma) {

        if (plataforma instanceof Netflix) return new StrategyNetflix();
        if (plataforma instanceof DisneyPlus) return new StrategyDisney();
        if (plataforma instanceof PrimeVideo) return new StrategyPrime();

        throw new IllegalArgumentException("No hay estrategia para: " + plataforma.getNombre());
    }
}
