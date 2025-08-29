import java.util.Vector;

class Inventario {
    private Vector<Objeto> objetos;

    public Inventario() {
        objetos = new Vector<>();
    }

    public void agregarObjeto(Objeto o) {
        objetos.add(o);
        System.out.println(o.getNombre() 
        + " agregado al inventario!");
    }

    public void mostrarObjetos() {
        if (objetos.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            System.out.println("Objetos en inventario:");
            for (Objeto o : objetos) {
                System.out.println("- " + o);
            }
        }
    }
}
