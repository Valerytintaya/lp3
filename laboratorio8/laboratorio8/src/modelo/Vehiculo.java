package modelo;

public class Vehiculo {
    private int vehiculoId;
    private String marca;
    private String modelo;
    private int ano;
    private int estado;
    private int idTipo;
    private int numPuertas;
    private int numAsientos;
    private int idSucursal; // ✅ nombre correcto según tu BD

    public Vehiculo(int vehiculoId, String marca, String modelo, int ano, int estado,
                    int idTipo, int numPuertas, int numAsientos, int idSucursal) {
        this.vehiculoId = vehiculoId;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.estado = estado;
        this.idTipo = idTipo;
        this.numPuertas = numPuertas;
        this.numAsientos = numAsientos;
        this.idSucursal = idSucursal;
    }

    public Vehiculo(String marca, String modelo, int ano, int estado, int idTipo, int numPuertas, int numAsientos, int idSucursal) {
        this(0, marca, modelo, ano, estado, idTipo, numPuertas, numAsientos, idSucursal);
    }

    public int getVehiculoId() { return vehiculoId; }
    public void setVehiculoId(int id) { this.vehiculoId = id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public int getEstado() { return estado; }
    public int getIdTipo() { return idTipo; }
    public int getNumPuertas() { return numPuertas; }
    public int getNumAsientos() { return numAsientos; }
    public int getIdSucursal() { return idSucursal; }

    @Override
    public String toString() {
        return String.format("Vehiculo[%d] %s %s (%d) Tipo:%d Estado:%d Sucursal:%d",
                vehiculoId, marca, modelo, ano, idTipo, estado, idSucursal);
    }
}
