public class MainVehiculo {
    public static void main(String[] args) {
        Vehiculo coche = new Coche();
        Vehiculo bicicleta = new Bicicleta();

        probarAceleracion(coche);
        probarAceleracion(bicicleta);
    }

    public static void probarAceleracion(Vehiculo v) {
        v.acelerar();
    }

}
