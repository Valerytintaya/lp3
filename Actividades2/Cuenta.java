// Clase Cuenta
public class Cuenta {
    private int numero;
    private double saldo;

    // Constructor con número y saldo
    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    // Constructor solo con número
    public Cuenta(int numero) {
        this(numero, 0.0);
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cuenta [Número=" + numero + ", Saldo=" + saldo + "]";
    }
}

