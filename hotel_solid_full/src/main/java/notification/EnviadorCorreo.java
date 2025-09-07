package notification;

public class EnviadorCorreo implements CanalNotificacion {
    @Override public void enviar(String mensaje) { System.out.println("[EMAIL] " + mensaje); }
}
