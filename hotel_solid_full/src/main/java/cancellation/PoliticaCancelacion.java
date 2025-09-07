package cancellation;

import model.Reserva;
import java.time.LocalDate;

public interface PoliticaCancelacion {
    // devuelve factor de penalizacion entre 0.0 y 1.0
    double penalizacion(Reserva reserva, LocalDate fechaSolicitud);
}
