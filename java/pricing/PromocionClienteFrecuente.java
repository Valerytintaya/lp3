package pricing;

import model.Habitacion;
import java.time.LocalDate;

public class PromocionClienteFrecuente implements Promocion {
    @Override public double aplicar(double precioBase, Habitacion h, LocalDate desde, LocalDate hasta) {
        return precioBase * 0.9;
    }
}
