package pricing;

import model.Habitacion;
import java.time.LocalDate;

public interface Promocion {
    double aplicar(double precioBase, Habitacion h, LocalDate desde, LocalDate hasta);
}
