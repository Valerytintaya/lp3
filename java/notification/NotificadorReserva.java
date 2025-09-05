package notification;

public class NotificadorReserva {
    private final CanalNotificacion canal;
    public NotificadorReserva(CanalNotificacion canal) { this.canal = canal; }
    public void notificar(String msg) { canal.enviar(msg); }
}
