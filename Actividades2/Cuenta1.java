
abstract class Cuenta1 {
    protected String numeroCuenta;
    protected double saldo;
    public Cuenta1(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
    }
    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
    public double getSaldo() {
        return saldo;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    // Método abstracto que las subclases redefinen
    public abstract void consultar();
}

