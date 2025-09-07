package cancellation;

import model.Reserva;
import java.time.LocalDate;

public class PoliticaEstricta implements PoliticaCancelacion {
    @Override public double penalizacion(Reserva reserva, LocalDate fechaSolicitud) {
        return 1.0;
    }
}
