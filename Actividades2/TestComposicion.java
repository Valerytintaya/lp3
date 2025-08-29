public class TestComposicion {
    public static void main(String[] args) {
        Persona p1 = new Persona(1, "Carlos", "Gomez", 1001);
        p1.getCuenta().setSaldo(1500.75);

        System.out.println(p1.toString());
    }
}
