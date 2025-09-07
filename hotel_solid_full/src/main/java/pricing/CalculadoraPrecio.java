package pricing;

import model.Habitacion;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CalculadoraPrecio {
    private final List<Promocion> promociones;

    public CalculadoraPrecio(List<Promocion> promociones) { this.promociones = promociones; }

    public double calcular(Habitacion h, LocalDate desde, LocalDate hasta) {
        long noches = Math.max(1, ChronoUnit.DAYS.between(desde, hasta));
        double base = h.precioPorNoche() * noches;
        double precio = base;
        for (Promocion p : promociones) precio = p.aplicar(precio, h, desde, hasta);
        return Math.round(precio*100.0)/100.0;
    }
}
