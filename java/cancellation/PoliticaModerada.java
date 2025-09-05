package cancellation;

import model.Reserva;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements PoliticaCancelacion {
    @Override public double penalizacion(Reserva reserva, LocalDate fechaSolicitud) {
        long horas = ChronoUnit.HOURS.between(fechaSolicitud.atStartOfDay(), reserva.getDesde().atStartOfDay());
        return horas >= 72 ? 0.0 : 0.5;
    }
}
