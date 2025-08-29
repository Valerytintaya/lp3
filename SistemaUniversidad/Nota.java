class Nota {
    float nota;
    Asignatura asig;

    public Nota(float n, Asignatura a) {
        nota = n;
        asig = a;
    }

    public void mostrar() {
        System.out.println("Asignatura: " + asig.getNombre()+ " Nota: " + nota);
    }
}
