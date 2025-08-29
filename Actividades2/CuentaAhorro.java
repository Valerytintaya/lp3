class CuentaAhorro extends Cuenta1 {
    private double tasaInteres;
    private double saldoMinimo;

    public CuentaAhorro(String numeroCuenta, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.saldoMinimo = saldoInicial;
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        if (saldo < saldoMinimo) {
            saldoMinimo = saldo;
        }
    }

    @Override
    public void consultar() {
        double interes = saldoMinimo * tasaInteres;
        depositar(interes);
        saldoMinimo = saldo; // reinicia el mínimo
        System.out.println("Intereses aplicados. Saldo actualizado: " + saldo);
    }
}
