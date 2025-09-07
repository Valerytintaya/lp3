package pricing;

import model.Habitacion;
import java.time.LocalDate;
import java.time.Month;

public class PromocionTemporadaAlta implements Promocion {
    @Override public double aplicar(double precioBase, Habitacion h, LocalDate desde, LocalDate hasta) {
        Month m = desde.getMonth();
        if (m == Month.DECEMBER || m == Month.JULY) return precioBase * 1.25;
        return precioBase;
    }
}
