class CuentaCorriente extends Cuenta1 {
    private int retirosMes;
    private static final int RETIROS_GRATIS = 3;
    private static final double COMISION = 3.0;

    public CuentaCorriente(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
        this.retirosMes = 0;
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        retirosMes++;
        if (retirosMes > RETIROS_GRATIS) {
            saldo -= COMISION;
            System.out.println("Se aplicó comisión de S/.3. Nuevo saldo: " + saldo);
        }
    }

    @Override
    public void consultar() {
        retirosMes = 0; // reinicia retiros
        System.out.println("Consultado. Contador de retiros reiniciado.");
    }
}

