package notification;

public class EnviadorSMS implements CanalNotificacion {
    @Override public void enviar(String mensaje) { System.out.println("[SMS] " + mensaje); }
}
