public class TestAgregacion{
    public static void main(String[] args) {
        Motor motor = new Motor(12345, 6000);
        Automovil auto = new Automovil("ABC123", 4, "Toyota", "Corolla", motor);

        System.out.println(auto.toString());
    }
}

